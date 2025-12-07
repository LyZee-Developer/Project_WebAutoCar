package com.example.project_api_car.helper;


import com.example.project_api_car.security.ApiResponseHandler;

public class PartnerSupportHelper {
    public static class URL {
        public final static String List="api/partner_support/list";
        public final static String Create="api/partner_support/create";
        public final static String Update="api/partner_support/update";
        public final static String Delete="api/partner_support/delete";
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("Partner support not found!");
    }
}
