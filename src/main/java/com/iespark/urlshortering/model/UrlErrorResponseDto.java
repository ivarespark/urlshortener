package com.iespark.urlshortering.model;

public class UrlErrorResponseDto {
    private String status;
    private String error;

    public UrlErrorResponseDto() {
    }

    public UrlErrorResponseDto(String status, String error) {
        this.status = status;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String statu) {
        this.status = statu;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "UrlErrorResponseDto{" +
                "status='" + status + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
