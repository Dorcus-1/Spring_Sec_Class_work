package rw.ac.rca.springsecurity1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data

public class ApiResponse {
    private Boolean success;
    private String message;
    private Object data;
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }



    public ApiResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public static ApiResponse success(Object data) {
        return new ApiResponse(true, data);
    }

    public static ApiResponse fail(Object data) {
        return new ApiResponse(false, data);
    }

    public static ApiResponse success(String message) {
        return new ApiResponse(true, message);
    }

    public static ApiResponse fail(String message) {
        return new ApiResponse(false, message);
    }

}
