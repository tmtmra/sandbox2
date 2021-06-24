package com.example.demo.presentation;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo.domain.Employee;
import com.example.demo.usecase.GetEmployeeUsecase;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerSliceTest {
    /** テストターゲットにインジェクションするモック */
    @MockBean
    GetEmployeeUsecase mockedUsecase;
    /** 接続テスト用のクライアント */
    @Autowired
    private MockMvc mvc;
    @Test
    void test() throws Exception {
        //モックの動きを設定する
        when(this.mockedUsecase.getEmployee(anyString())).thenReturn(Optional.ofNullable(new Employee("foo", "bar")));
        //テストを実行
        this.mvc.perform(get("/employees/{employeeId}", "123")) //idは何でもよい
        .andExpect(status().is(200)) //
        .andExpect(content().json("{\"employeeId\":\"foo\",\"name\":\"bar\"}")); //クエリに関係なくモックのデータ
    }
}
