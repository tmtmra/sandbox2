package com.example.demo.presentation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo.infrastructure.TempEmployeeRepositoryImp;
import com.example.demo.usecase.GetEmployeeUsecase;

@WebMvcTest(EmployeeController.class)
@Import({ GetEmployeeUsecase.class, TempEmployeeRepositoryImp.class })
class EmployeeControllerSliceAndImportTest {
    /** 接続テスト用のクライアント */
    @Autowired
    private MockMvc mvc;
    @Test
    void test() throws Exception {
        //実行
        this.mvc.perform(get("/employees/{employeeId}", "123")) //
        //確認
        .andExpect(status().is(200)) //
        .andExpect(content().json("{\"employeeId\":\"123\",\"name\":\"Taro\"}")); //Repositoryから取得したデータ
    }
}
