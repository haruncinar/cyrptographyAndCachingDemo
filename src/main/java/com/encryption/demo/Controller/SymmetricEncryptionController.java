package com.encryption.demo.Controller;

import com.encryption.demo.Cryptography.CryptographyService;
import com.encryption.demo.model.EncryptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/symmetric/encryption")
public class SymmetricEncryptionController {

    @Autowired
    private CryptographyService cryptographyService;

    @GetMapping("/getSymmetricEncryptionForInput")
    EncryptionResponse getSymmetricEncryptionForInput(@RequestParam String textInput)
    {
        return cryptographyService.createSymmetricEncryptionForInputText(textInput);
    }

}
