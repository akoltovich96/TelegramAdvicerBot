package application.util;

import application.dto.AdviceDTO;
import application.entity.Advice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdviceConverter {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public AdviceDTO adviceToAdviceDTO(Advice advice) {
        return modelMapper().map(advice, AdviceDTO.class);
    }

    public Advice adviceDTOToAdvice(AdviceDTO adviceDTO) {
        return modelMapper().map(adviceDTO, Advice.class);
    }

    public static List<AdviceDTO> listOfAdvicesToDTO(List<Advice> advice) {
        List<AdviceDTO> adviceDTOS = new ArrayList<>();
        for (Advice a : advice) {
            AdviceDTO adviceDTO = new AdviceDTO();
            adviceDTO.setContent(a.getContent());
            adviceDTOS.add(adviceDTO);
        }
        return adviceDTOS;
    }
}
