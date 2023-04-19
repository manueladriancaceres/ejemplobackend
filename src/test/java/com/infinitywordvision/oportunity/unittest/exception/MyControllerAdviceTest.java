package com.infinitywordvision.oportunity.unittest.exception;

import com.infinitywordvision.oportunity.controller.AuthController;
import com.infinitywordvision.oportunity.repository.UserSystemRepository;
import com.infinitywordvision.oportunity.service.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AuthController.class)
public class MyControllerAdviceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserSystemRepository userSystemRepository;

    @MockBean
    private AuthService authService;

    @Test
    public void handleExceptionTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login"))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

}
