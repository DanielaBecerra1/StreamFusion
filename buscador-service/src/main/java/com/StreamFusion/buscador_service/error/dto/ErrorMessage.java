package com.StreamFusion.buscador_service.error.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorMessage {
    private HttpStatus status;
    private String message;

}
