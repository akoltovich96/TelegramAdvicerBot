package application.controllerTest;

import application.controller.CityController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerPostMappingTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addCityTest() throws Exception {
        mockMvc.perform(post("/city/add").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"Moscow\"}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addAdviceToCity() throws Exception {
        mockMvc.perform(post("/advice/add/New York").contentType(MediaType.APPLICATION_JSON).content("new advice"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
