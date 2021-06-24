package com.example.demo.presentation;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

class EmployeeControllerOnExternalServerTest {
    /** 接続テスト用のクライアント */
    WebTestClient client = WebTestClient.bindToServer().build();
    /** 接続先のポート番号 */
    private final int port = 8080;
    @Test
    void test() throws Exception {
        //実行
        this.client.get().uri("http://localhost:" + this.port + "/employees/{employeeId}", "123").exchange() //
        //確認
        .expectStatus().isEqualTo(HttpStatus.valueOf(200)) //
        .expectBody(String.class).isEqualTo("{\"employeeId\":\"123\",\"name\":\"Taro\"}");
    }
}
