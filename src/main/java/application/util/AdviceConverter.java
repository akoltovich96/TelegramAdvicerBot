package application.util;

import application.dto.AdviceDTO;
import application.entity.Advice;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdviceConverter {

    public AdviceDTO adviceToAdviceDTO(Advice advice) {
        AdviceDTO adviceDTO = new AdviceDTO();
        adviceDTO.setId(advice.getId());
        adviceDTO.setContent(advice.getContent());
        return adviceDTO;
    }

    public List<AdviceDTO> listOfAdvicesToDTO(List<Advice> advice) {
        List<AdviceDTO> adviceDTOS = new ArrayList<>();
        for (Advice a : advice) {
            AdviceDTO adviceDTO = new AdviceDTO();
            adviceDTO.setId(a.getId());
            adviceDTO.setContent(a.getContent());
            adviceDTOS.add(adviceDTO);
        }
        return adviceDTOS;
    }
}
