package com.encryption.demo.caching;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {
    private String name;
    private int age;
    private String bookHouse;
}
