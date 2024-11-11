package com.workintech.ecomm.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class EcommErrorResponse {
    private String message;
    private LocalDateTime timeStamp;
    private int status;
}
