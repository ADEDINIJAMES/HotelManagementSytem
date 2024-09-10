package com.tumtech.hotelmanagementapp.serviceImplementation;

import com.tumtech.hotelmanagementapp.dto.LoginRequest;
import com.tumtech.hotelmanagementapp.dto.RegisterRequest;
import com.tumtech.hotelmanagementapp.entity.Users;
import com.tumtech.hotelmanagementapp.repository.UserRepository;
import com.tumtech.hotelmanagementapp.response.ApiResponse;
import com.tumtech.hotelmanagementapp.services.AuthService;
import com.tumtech.hotelmanagementapp.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl
        implements AuthService
{
    private UserRepository userRepository;
    private EmailServiceImp emailServiceImp;
    private JwtUtil jwtUtil;

    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(()-> new RuntimeException("user not found"));
    }

    private  String getToken (UserDetails userDetails){
        return jwtUtil.createJwt.apply(userDetails);
    }
    private Boolean checkPassword (String rawPassword, String encodedPassword){
        return passwordEncoder.matches(rawPassword,encodedPassword);
    }

    @Override
    public ApiResponse loginUser(LoginRequest loginRequest) {
        String email= loginRequest.getUsername();
        Optional<Users> users = userRepository.findByEmail(email);
        String rawPassword = loginRequest.getPassword();
        if(users.isPresent()){
            String dbPassword = users.get().getPassword();
            if (checkPassword(rawPassword,dbPassword)){
                String generatedToken = getToken(users.get());
                Map<String, Object> returnData= new HashMap<>();
                returnData.put("Token", generatedToken);
                return   ApiResponse.builder()
                        .message("Login Successful !!!")
                        .statusCode("200")
                        .data(returnData).build();
            }
            return ApiResponse.builder()
                    .message("password or username incorrect")
                    .statusCode("403")
                    .data(null).build();
        }
        return ApiResponse.builder()
                .message("User not found")
                .statusCode("403")
                .data(null).build();


    }

    public ApiResponse registerUser (RegisterRequest request){

        return new ApiResponse();
    }
    public ApiResponse registerAdmin (RegisterRequest request){

        return new ApiResponse();
    }
    public ApiResponse registerStaff (RegisterRequest request){

        return  new ApiResponse();
    }

    @Override
    public ApiResponse LogoutUser(Long userId) {
        return null;
    }

    public ApiResponse LoginUser (LoginRequest loginRequest){

        return new ApiResponse();
    }

    public ApiResponse LoginStaff(LoginRequest loginRequest){

        return new ApiResponse();
    }
}
