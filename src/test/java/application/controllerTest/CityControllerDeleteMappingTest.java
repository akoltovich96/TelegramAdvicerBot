package application.controllerTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerDeleteMappingTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteCityTest() throws Exception{
        mockMvc.perform(delete("/city/delete/New York"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteAdviceTest() throws Exception{
        mockMvc.perform(delete("/advice/delete/3"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
