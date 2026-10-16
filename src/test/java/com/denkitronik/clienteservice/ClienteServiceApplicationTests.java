package com.denkitronik.clienteservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Smoke test — el contexto de Spring arranca")
class ClienteServiceApplicationTests {

    @Test
    @DisplayName("contextLoads — la aplicación arranca sin errores")
    void contextLoads() {
    }
}