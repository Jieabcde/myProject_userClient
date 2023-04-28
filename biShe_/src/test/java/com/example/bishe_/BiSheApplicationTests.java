package com.example.bishe_;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BiSheApplicationTests {
    private static int count;

    @Test
    void contextLoads() {
        try {
            method();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println(count);
        }
    }

    void method() {
        count++;
        method();
    }
}
