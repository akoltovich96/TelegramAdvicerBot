package application.service;

import application.dto.AdviceDTO;
import application.entity.Advice;
import application.entity.City;
import application.repository.AdviceRepository;
import application.repository.CityRepository;
import application.util.AdviceConverter;
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
        City city = cityRepository.findByName(name);
        Advice advice = new Advice();
        advice.setContent(content);
        advice.setCity(city);
        city.getAdvices().add(advice);
        cityRepository.saveAndFlush(city);
    }

    public List<AdviceDTO> getAllAdvicesByCityName(String name) {
        return adviceConverter.listOfAdvicesToDTO(cityRepository.findByName(name).getAdvices());
    }

    public AdviceDTO updateAdvice(Long id, String content) {
        Advice advice = adviceRepository.findById(id).get();
        advice.setContent(content);
        adviceRepository.saveAndFlush(advice);
        return adviceConverter.adviceToAdviceDTO(adviceRepository.findById(id).get());
    }

    public void deleteAdvice(Long id) {
        adviceRepository.deleteById(id);
    }

}
