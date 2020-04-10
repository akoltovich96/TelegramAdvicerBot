package application.service;

import application.dto.AdviceDTO;
import application.dto.CityDTO;
import application.entity.City;
import application.repository.CityRepository;
import application.util.CityConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityConverter cityConverter;
    private final CityRepository cityRepository;

    private CityService(CityConverter cityConverter, CityRepository cityRepository) {
        this.cityConverter = cityConverter;
        this.cityRepository = cityRepository;
    }

    public List<CityDTO> getAllCities() {
        List<City> cities = cityRepository.findAll();
        if (!cities.isEmpty()) {
            List<CityDTO> cityDTOS = cities.stream()
                    .map(city -> CityDTO.builder()
                            .id(city.getId())
                            .name(city.getName())
                            .advices(city.getAdvices().stream()
                                    .map(advice -> AdviceDTO.builder()
                                            .id(advice.getId())
                                            .content(advice.getContent())
                                            .build()).collect(Collectors.toList()))
                            .build())
                    .collect(Collectors.toList());
            return cityDTOS;
        }
        return new ArrayList<>();
    }

    public void addCity(CityDTO cityDTO) {
        City newCity = new City();
        newCity.setId(cityDTO.getId());
        newCity.setName(cityDTO.getName());
        newCity.setAdvices(new ArrayList<>());
        cityRepository.save(newCity);
    }

    public CityDTO findByName(String name) {
        City city = cityRepository.findByName(name);
        if (city != null) {
            return cityConverter.cityToCityDTO(city);
        }
        return null;
    }

    public CityDTO updateCity(Long id, String name) {
        Optional<City> byId = cityRepository.findById(id);
        byId.get().setName(name);
        cityRepository.saveAndFlush(byId.get());
        return cityConverter.cityToCityDTO(byId.get());
    }

    public void deleteCity(String name) {
        City city = cityRepository.findByName(name);
        cityRepository.deleteById(city.getId());
    }
}
