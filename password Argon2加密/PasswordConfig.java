package com.sky.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Argon2PasswordEncoder 預設使用的就是 Argon2id 模式
        // 參數說明：（鹽值長度, 哈希長度, 平行度/執行緒數, 記憶體消耗KB, 迭代次數）
        return new Argon2PasswordEncoder(
                16,     // saltLength: 16 位元組的鹽值
                32,     // hashLength: 32 位元組的雜湊輸出
                2,      // parallelism: 使用 2 個並行執行緒
                65536,  // memory: 消耗 64MB 記憶體（65536 KB）
                3       // iterations: 迭代 3 次
        );
    }
}