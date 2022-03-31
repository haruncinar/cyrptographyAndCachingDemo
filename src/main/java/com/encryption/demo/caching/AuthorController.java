package com.encryption.demo.caching;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/caching")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAllAuthors()
    {
        System.out.println("Retrieving data..");
        List<Author> authors = authorService.getAllAuthors();
        System.out.println("Data have been taken!");
        return authors;
    }
}
