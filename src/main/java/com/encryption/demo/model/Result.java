package com.encryption.demo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Result {
    SUCCESS(0, "Success"),
    FAIL(1, "Fail");

    private final int resultCode;
    private final String resultDesc;
}
