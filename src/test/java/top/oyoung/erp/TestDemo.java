package top.oyoung.erp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestDemo {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails("ya")
    public void demoTest2() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/test/3/1"))
//                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
}
