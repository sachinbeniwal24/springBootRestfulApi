package com.example.SpringBootRestfulProgram1.controller;


import com.example.SpringBootRestfulProgram1.response.CustomResponse;

public class BaseController {

        protected <T> CustomResponse<T> success(T data, String message) {
            return new CustomResponse<>(true, message, data);
        }

        protected CustomResponse<Object> failure(String message) {
            return new CustomResponse<>(false, message,null);
        }
    }

