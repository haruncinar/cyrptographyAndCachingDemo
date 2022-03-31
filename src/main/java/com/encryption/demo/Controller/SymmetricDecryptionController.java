package com.encryption.demo.Controller;

import com.encryption.demo.Cryptography.CryptographyService;
import com.encryption.demo.model.DecryptionRequest;
import com.encryption.demo.model.DecryptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/symmetric/decryption")
@RequiredArgsConstructor
public class SymmetricDecryptionController {

    @Autowired
    private CryptographyService cryptographyService;

    @GetMapping("/getSymmetricDecryptionForInput")
    public DecryptionResponse getSymmetricDecryptionForInput(@RequestBody DecryptionRequest decryptionRequest)
    {
        return cryptographyService.createSymmetricDecryptionForInputEncryptedData(decryptionRequest);
    }
}
