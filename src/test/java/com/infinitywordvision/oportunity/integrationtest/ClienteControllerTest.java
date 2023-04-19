package com.infinitywordvision.oportunity.integrationtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "admin", password = "123456", roles = "USER")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /*
    @BeforeAll
    static void configurar() {

    }
    */

    @Test
    void shouldReturnList() throws Exception {

        MvcResult mockResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/api/clientes"))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();

        /*
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4MDcyMzE0NSwiZXhwIjoxNjgwNzI2NzQ1fQ.SynGJ6sQphxuPVRDlYMCtTMoxf6YmFJEJ9ZoVmE1tgg";

        MvcResult mockResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/api/clientes")
                                .with(user("admin").password("123456").roles("ADMIN"))
                        .header("Authorization", "Bearer " + token))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();
        */

    }
}
