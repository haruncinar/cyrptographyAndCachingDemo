package com.encryption.demo.caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AuthorService {
    private final List<Author> authors = Arrays.asList(Author.builder().name("Jose Saramago").age(50).bookHouse("RedBook").build(),
            Author.builder().name("Dostoyevski").age(70).bookHouse("RussianHouse").build(),
            Author.builder().name("Khalil Cibran").age(58).bookHouse("BostonGroup").build());

    @Cacheable("authors")
    public List<Author> getAllAuthors()
    {
        try
        {
            System.out.println("Preparing data...");
            Thread.sleep(3000);
        }
        catch (Exception e)
        {
            System.out.println("fail");
        }
        return authors;
    }
}
