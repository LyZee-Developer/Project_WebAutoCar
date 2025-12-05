package com.example.project_api_car.helper;


import java.util.Arrays;
import java.util.List;

import com.example.project_api_car.security.ApiResponseHandler;

public class AuthAccessHelper {
    public static class URL {
        public final static String List="api/auth_access/list";
        public final static String Create="api/auth_access/create";
        public final static String Update="api/auth_access/update";
        public final static String Delete="api/auth_access/delete";
        public final static String Login="api/auth_access/login";
    }
    public static class Type{
        public final static List<String> Type = Arrays.asList("O", "A");
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("Auth user access not found!");
        public static final ApiResponseHandler RequiredUserPw = new ApiResponseHandler().SetDetail("Username or password is required!");
    }
}
