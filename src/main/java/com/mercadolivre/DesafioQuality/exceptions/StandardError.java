package com.mercadolivre.DesafioQuality.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StandardError {
    private Integer status;
    private String message;
    private String path;
}
