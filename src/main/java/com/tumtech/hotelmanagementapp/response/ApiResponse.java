package com.tumtech.hotelmanagementapp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String statusCode;
    private String message;
    private Map<String, Object> data;
}
