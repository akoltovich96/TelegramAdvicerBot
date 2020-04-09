package application.service;

import application.dto.AdviceDTO;
import application.dto.CityDTO;
import application.entity.Advice;
import application.entity.City;
import application.repository.AdviceRepository;
import application.repository.CityRepository;
import application.util.AdviceConverter;
import application.util.CityConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviceService {

    private final AdviceConverter adviceConverter;
    private final AdviceRepository adviceRepository;
    private final CityRepository cityRepository;

    private AdviceService(AdviceConverter adviceConverter, AdviceRepository adviceRepository, CityRepository cityRepository) {
        this.adviceConverter = adviceConverter;
        this.adviceRepository = adviceRepository;
        this.cityRepository = cityRepository;
    }

    public void addAdviceToCity(String name, String content) {
        CityDTO cityDTO = CityConverter.cityToCityDTO(cityRepository.findByName(name));
        AdviceDTO adviceDTO = new AdviceDTO();
        adviceDTO.setContent(content);
        cityDTO.getAdvices().add(adviceDTO);
    }

    public List<AdviceDTO> getAllAdvicesByCityName(String name) {
        return AdviceConverter.listOfAdvicesToDTO(cityRepository.findByName(name).getAdvices());
    }

    public AdviceDTO updateAdvice(Long id, String advice) {
        adviceRepository.findById(id).get().setContent(advice);
        return adviceConverter.adviceToAdviceDTO(adviceRepository.findById(id).get());
    }

    public void deleteAdvice(Long id) {
        adviceRepository.deleteById(id);
    }

}
