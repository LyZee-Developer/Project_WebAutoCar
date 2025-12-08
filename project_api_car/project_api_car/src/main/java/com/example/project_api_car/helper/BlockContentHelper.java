package com.example.project_api_car.helper;


import com.example.project_api_car.security.ApiResponseHandler;

public class BlockContentHelper {
    public static class URL {
        public final static String List="api/block_content/list";
        public final static String Create="api/block_content/create";
        public final static String Update="api/block_content/update";
        public final static String Delete="api/block_content/delete";
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("Block content not found!");
    }
}
