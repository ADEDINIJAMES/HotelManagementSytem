package com.tumtech.hotelmanagementapp.config;

import com.tumtech.hotelmanagementapp.serviceImplementation.AuthServiceImpl;
import com.tumtech.hotelmanagementapp.util.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthServiceImpl authServiceImpl;

    @Autowired
    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, @Lazy AuthServiceImpl authServiceImpl) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authServiceImpl = authServiceImpl;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(authServiceImpl::loadUserByUsername);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain httpSecurity(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(httpRequest ->
                        httpRequest
                                .requestMatchers("/api/v1/user/register",
                                        "/api/v1/user/login",
                                        "/api/v1/user/verifyRegistration/{token}",
                                        "/api/v1/user/forgotPassword",
                                        "/api/v1/user/resetPassword/{token}",
                                        "/api/v1/user/resendVerifyToken/{oldToken}",
                                        "/api/v1/user/dashboard",
                                        "/api/v1/quiz/all-quiz-images",
                                        "/swagger-ui/**",
                                        "/v3/api-docs/**",
                                        "/swagger-ui.html",
                                        "/subject/fetch-all-subjects",
                                        "/v3/api-docs.yaml").permitAll()
                                .requestMatchers("/**").permitAll()
                                .requestMatchers("/api/v1/user/logout",
                                        "/api/v1/user/changePassword",
                                        "/api/v1/quiz/delete-quiz/{quizId}",
                                        "/api/v1/questions/delete-question/{questionId}",
                                        "/api/v1/quiz/create-quiz",
                                        "/api/v1/quiz/get-quiz/{quizId}",
                                        "/api/v1/quiz/edit-quiz/{id}",
                                        "/api/v1/questions/edit/{questionId}",
                                        "/api/v1/quiz/{id}/publish",
                                        "/api/v1/quiz/get-published-draft",
                                        "/api/v1/quiz//take-quiz/{quizId}",
                                        "/api/v1/quiz/quizzes-by-subject/{subjectName}").authenticated())
                .logout(logout -> logout
                        .deleteCookies("remove")
                        .invalidateHttpSession(true)
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authenticationProvider(authenticationProvider())

                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
