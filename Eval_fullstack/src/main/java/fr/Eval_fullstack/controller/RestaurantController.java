package fr.Eval_fullstack.controller;


import fr.Eval_fullstack.converter.RestaurantConverteur;
import fr.Eval_fullstack.dto.request.AddRestaurantDto;
import fr.Eval_fullstack.dto.response.RestaurantDto;
import fr.Eval_fullstack.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping(value = "/restaurants", produces = "application/json")
    public List<RestaurantDto> getRestaurants() {
        return RestaurantConverteur.entityRestaurantsToDto(restaurantService.getRestaurants());
    }

    @GetMapping(value = "/restaurants/{id}", produces = "application/json")
    public RestaurantDto getRestaurant(@Valid @PathVariable("id") Integer id) {

        return RestaurantConverteur.entityRestaurantToDto(restaurantService.getRestaurant(id));
    }

    @PostMapping(value = "/restaurants", produces = "application/json", consumes = "application/json")
    public RestaurantDto addRestaurant(@Valid @RequestBody AddRestaurantDto restaurantDto) {
        return RestaurantConverteur.entityRestaurantToDto(restaurantService.addRestaurant(RestaurantConverteur.addRestaurantDtoToEntity(restaurantDto)));
    }

    @DeleteMapping(value = "/restaurants/{id}")
    public void deleteRestaurant(@Valid @PathVariable("id") Integer id) {
        restaurantService.deleteRestaurant(id);
    }

    @PutMapping(value = "/restaurants/{id}", produces = "application/json", consumes = "application/json")
    public RestaurantDto updateRestaurant(@Valid @PathVariable("id") Integer id, @Valid @RequestBody RestaurantDto restaurantDto) {
        RestaurantDto tmp = RestaurantConverteur.entityRestaurantToDto(restaurantService.getRestaurant(id));
        tmp.setNom(restaurantDto.getNom());
        tmp.setAdresse(restaurantDto.getAdresse());
        tmp.setMoyenne(restaurantDto.getMoyenne());
        tmp.setEvaluations(restaurantDto.getEvaluations());
        tmp.setEvaluationFinale(restaurantDto.getEvaluationFinale());

        return RestaurantConverteur.entityRestaurantToDto(restaurantService.updateRestaurant(RestaurantConverteur.dtoRestaurantToEntity(tmp)));

    }

}
