package application.util;

import application.dto.CityDTO;
import application.entity.City;
import org.springframework.stereotype.Component;

@Component
public class CityConverter {

    private final AdviceConverter adviceConverter;

    public CityConverter(AdviceConverter adviceConverter) {
        this.adviceConverter = adviceConverter;
    }

    public CityDTO cityToCityDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setAdvices(adviceConverter.listOfAdvicesToDTO(city.getAdvices()));
        return cityDTO;
    }
}
