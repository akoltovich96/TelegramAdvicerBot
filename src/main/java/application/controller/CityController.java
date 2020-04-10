package application.controller;

import application.dto.AdviceDTO;
import application.dto.CityDTO;
import application.service.AdviceService;
import application.service.CityService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CityDTO> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping(value = "/city/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CityDTO findByName(@Valid @PathVariable(name = "name") String name) {
        return cityService.findByName(name);
    }

    @GetMapping("/advice/{name}")
    public List<AdviceDTO> getAllAdvicesByCityName(@PathVariable(name = "name") String name) {
        return adviceService.getAllAdvicesByCityName(name);
    }

    @PostMapping(value = "/advice/add/{name}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addAdviceToCity(@Valid @PathVariable(name = "name") String name, @Valid @RequestBody String content) {
        adviceService.addAdviceToCity(name, content);
    }

    @PostMapping(value = "/city/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addCity(@Valid @RequestBody CityDTO cityDTO) {
        cityService.addCity(cityDTO);
    }

    @PutMapping(value = "/city/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CityDTO updateCity(@Valid @PathVariable Long id, @RequestBody String name) {
        return cityService.updateCity(id, name);
    }

    @PutMapping("/advice/update/{id}")
    public AdviceDTO updateAdvice(@PathVariable Long id, @RequestBody String content) {
        return adviceService.updateAdvice(id, content);
    }

    @DeleteMapping("/city/delete/{name}")
    public void deleteCity(@PathVariable String name) {
        cityService.deleteCity(name);
    }

    @DeleteMapping("/advice/delete/{id}")
    public void deleteAdvice(@PathVariable Long id) {
        adviceService.deleteAdvice(id);
    }
}