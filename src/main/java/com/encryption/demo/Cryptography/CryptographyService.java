package com.encryption.demo.Cryptography;

import com.encryption.demo.model.DecryptionRequest;
import com.encryption.demo.model.DecryptionResponse;
import com.encryption.demo.model.EncryptionResponse;
import com.encryption.demo.model.Result;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

@Service
public class CryptographyService {
    private static final String AES = "AES";
    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static final String secret = "deneme";


    // We are using a Block cipher(CBC mode)
    private static final String AES_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    public static void setKey(final String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] do_AESEncryption(
            String plainText,
            SecretKey secretKey)
            throws Exception
    {

        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(plainText.getBytes());
    }

    public static String do_AESDecryption(
            byte[] cipherText,
            SecretKey secretKey)
            throws Exception
    {
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] result = cipher.doFinal(cipherText);

        return new String(result);
    }

    public EncryptionResponse createSymmetricEncryptionForInputText(String text)
    {
        try
        {
            setKey(secret);

            byte[] cipherText = do_AESEncryption(text, secretKey);

            return EncryptionResponse.builder().encryption(DatatypeConverter.printHexBinary(cipherText)).result(Result.SUCCESS).build();

        }
        catch (Exception exception)
        {
            return EncryptionResponse.builder().result(Result.FAIL).build();
        }
    }

    public DecryptionResponse createSymmetricDecryptionForInputEncryptedData(DecryptionRequest decryptionRequest)
    {
        try
        {
            setKey(secret);

            byte[] asBytes = DatatypeConverter.parseHexBinary(decryptionRequest.getEncryptedData());
            String decryptedText = do_AESDecryption(asBytes, secretKey);
            return DecryptionResponse.builder().decryption(decryptedText).result(Result.SUCCESS).build();
        }
        catch(Exception exception)
        {
            return DecryptionResponse.builder().result(Result.FAIL).build();
        }
    }
}
