package fr.Eval_fullstack.converter;

import fr.Eval_fullstack.dto.request.AddRestaurantDto;
import fr.Eval_fullstack.dto.response.RestaurantDto;
import fr.Eval_fullstack.entity.RestaurantEntity;

import java.util.ArrayList;
import java.util.List;

public class RestaurantConverteur {

   public static RestaurantDto entityRestaurantToDto(RestaurantEntity entityRestaurant){

       //return RestaurantDto.builder().id(entityRestaurant.getId()).build();
        return RestaurantDto.builder()
                .id(entityRestaurant.getId())
                .nom(entityRestaurant.getNom())
                .adresse(entityRestaurant.getAdresse())
                .moyenne(entityRestaurant.getMoyenne())
                .evaluations(EvaluationConverter.entityEvaluationsToDto(entityRestaurant.getEvaluations()))
                .evaluationFinale(EvaluationFinaleConverter.entityEvaluationFinaleToDto(entityRestaurant.getEvaluationFinale()))
                .tags(TagConverter.entityToDto(entityRestaurant.getTags()))
                .build();
   }

   public static RestaurantEntity dtoRestaurantToEntity(RestaurantDto dtoRestaurant){

       return RestaurantEntity.builder()
               .id(dtoRestaurant.getId())
               .nom(dtoRestaurant.getNom())
               .adresse(dtoRestaurant.getAdresse())
               .moyenne(dtoRestaurant.getMoyenne())
               .tags(TagConverter.dtoToEntity(dtoRestaurant.getTags()))
               .evaluations(EvaluationConverter.dtoEvaluationsToEntity(dtoRestaurant.getEvaluations()))
               .evaluationFinale(EvaluationFinaleConverter.dtoEvaluationFinaleToEntity(dtoRestaurant.getEvaluationFinale()))
               .build();
   }

   public static RestaurantEntity addRestaurantDtoToEntity(AddRestaurantDto addRestaurantDto){

       return RestaurantEntity.builder()
               .nom(addRestaurantDto.getNom())
               .adresse(addRestaurantDto.getAdresse())
               .moyenne(-1.0f).tags(TagConverter.dtoToEntity(addRestaurantDto.getTags()))
               .build();
   }

   public static List<RestaurantDto> entityRestaurantsToDto(List<RestaurantEntity> l) {
       List<RestaurantDto> lDto = new ArrayList<>();
       l.forEach(restaurantEntity -> {
           lDto.add(entityRestaurantToDto(restaurantEntity));
       });
       return lDto;
   }
}
