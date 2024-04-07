package com.authentication.AuthenticationService.dto;

public class ErrorResponse {
    private String status;
    private int statusCode;

    // Constructor, getters, and setters
    public ErrorResponse(String status, int statusCode) {
        this.status = status;
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }
}