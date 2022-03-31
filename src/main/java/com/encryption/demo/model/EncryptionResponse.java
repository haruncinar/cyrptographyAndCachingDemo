package com.encryption.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EncryptionResponse {
    private String encryption;
    private Result result;
    private byte[] chipterText;
}
