package com.infinitywordvision.oportunity.integrationtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PingControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void souldReturnPong() throws Exception {
        MvcResult mockResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/ping"))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();
        // Assertions.assertEquals("text/plain;charset=ISO-8859-1",mockResult.getResponse().getContentType());
    }

    @Test
    void souldReturnForbbien() throws Exception {
        MvcResult mockResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/protegido"))
                        .andDo(print()).andExpect(status().isForbidden())
                        .andReturn();
    }

}
