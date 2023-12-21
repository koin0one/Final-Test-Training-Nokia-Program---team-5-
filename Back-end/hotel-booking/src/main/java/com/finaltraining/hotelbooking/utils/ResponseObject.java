package com.finaltraining.hotelbooking.utils;

import com.finaltraining.hotelbooking.dto.UserEntityDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ResponseObject {
    private static final String STATUS = "status";
    private static final String OBJECTS = "objs";
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    @SuppressWarnings("unchecked")
    public static <T> Map<String, T> responseRequest(T t){
        Map<String, T> coordinates = new HashMap<>();
        if (t != null){
            coordinates.put(STATUS, (T) SUCCESS_STATUS);
            coordinates.put(OBJECTS, (T) t);
        } else {
            coordinates.put(STATUS, (T) ERROR_STATUS);
        }
        return coordinates;
    }
}
