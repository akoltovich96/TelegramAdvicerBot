package application.controller;

import application.dto.CityDTO;
import application.entity.City;
import application.service.AdviceService;
import application.service.CityService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CityController {

    private final CityService cityService;
    private final AdviceService adviceService;

    public CityController(CityService cityService, AdviceService adviceService) {
        this.cityService = cityService;
        this.adviceService = adviceService;
    }

    @GetMapping(value = "/city", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CityDTO> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping(value = "/city/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CityDTO findByName(@Valid @RequestParam(required = false, name = "name") String name) {
        return cityService.findByName(name);
    }

    @PostMapping(value = "/advice/{name}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addAdviceToCity(@Valid @RequestParam(required = false, name = "name") String name, @Valid @RequestBody String content) {
        adviceService.addAdviceToCity(name, content);
    }

    @PostMapping(value = "/city/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addCity(@Valid @RequestBody CityDTO cityDTO) {
        cityService.addCity(cityDTO);
    }

    @PutMapping(value = "/city/update/{name}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CityDTO updateCity(@PathVariable Long id, @RequestBody String name) {
        return cityService.updateCity(id, name);
    }

    @DeleteMapping("/city/delete/{name}")
    public void deleteCity(String name) {
        cityService.deleteCity(name);
    }
}