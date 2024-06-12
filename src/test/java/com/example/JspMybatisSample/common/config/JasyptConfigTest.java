package com.example.JspMybatisSample.common.config;

import org.assertj.core.api.Assertions;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JasyptConfigTest {

    @Value("${jasypt.encryptor.password}")
    private String PASSWORD_KEY;

    @Test
    public void jasypt() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(PASSWORD_KEY);
        config.setPoolSize("1");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setStringOutputType("base64");
        config.setKeyObtentionIterations("1000");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        encryptor.setConfig(config);

        String plainText = "postgres";
        String encryptedPassword = encryptor.encrypt(plainText);
        String decryptedPassword = encryptor.decrypt(encryptedPassword);

        System.out.println("encryptedPassword : " + encryptedPassword);
        System.out.println("decryptedPassword : " + decryptedPassword);

        Assertions.assertThat(plainText).isEqualTo(decryptedPassword);

    }

}
