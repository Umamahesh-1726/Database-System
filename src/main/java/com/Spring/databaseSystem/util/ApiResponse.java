package com.Spring.databaseSystem.util;

public class ApiResponse {

    private boolean success;
    private String message;
    private Object data;

    public ApiResponse() {}

    public ApiResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static ApiResponse success(String msg, Object data) {
        return new ApiResponse(true, msg, data);
    }

    public static ApiResponse error(String msg, Object data) {
        return new ApiResponse(false, msg, data);
    }

    // GETTERS
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public Object getData() { return data; }
}
