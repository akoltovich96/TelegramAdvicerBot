package application.util;

import application.dto.CityDTO;
import application.entity.City;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CityConverter {

    private static ModelMapper modelMapper;

    public CityConverter(ModelMapper modelMapper) {
        CityConverter.modelMapper = modelMapper;
    }

    public static CityDTO cityToCityDTO(City city) {
        return modelMapper.map(city, CityDTO.class);
    }

    public static City cityDTOToCity(CityDTO cityDTO) {
        return modelMapper.map(cityDTO, City.class);
    }
}
