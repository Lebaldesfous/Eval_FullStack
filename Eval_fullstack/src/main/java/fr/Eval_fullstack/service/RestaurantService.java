package fr.Eval_fullstack.service;

import fr.Eval_fullstack.entity.RestaurantEntity;
import fr.Eval_fullstack.exception.NotFoundException;
import fr.Eval_fullstack.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<RestaurantEntity> getRestaurants() {
        return this.restaurantRepository.findAll();
    }

    public RestaurantEntity getRestaurant(Integer id) {
        return this.restaurantRepository.findById(id).orElseThrow(() -> new NotFoundException("Restaurant non trouvé"));
    }

    public RestaurantEntity addRestaurant(RestaurantEntity restaurantEntity) {
        return this.restaurantRepository.save(restaurantEntity);
    }

    public void deleteRestaurant(Integer id) {
        this.restaurantRepository.deleteById(id);
    }

    public RestaurantEntity updateRestaurant(RestaurantEntity restaurantEntity) {
        return this.restaurantRepository.save(restaurantEntity);
    }
}
