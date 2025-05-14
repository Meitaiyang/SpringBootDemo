package org.meitaiyang.springbootdemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.meitaiyang.springbootdemo.web.BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemoApplicationTests {

    @Autowired
    private BookController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
