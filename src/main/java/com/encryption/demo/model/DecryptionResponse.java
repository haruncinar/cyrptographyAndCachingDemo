package com.encryption.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DecryptionResponse {
    private String decryption;
    private Result result;
}
