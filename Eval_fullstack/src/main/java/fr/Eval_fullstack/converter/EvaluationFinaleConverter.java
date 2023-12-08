package fr.Eval_fullstack.converter;

import fr.Eval_fullstack.dto.request.AddEvaluationFinaleDto;
import fr.Eval_fullstack.dto.response.EvaluationFinaleDto;
import fr.Eval_fullstack.entity.EvaluationFinaleEntity;
import fr.Eval_fullstack.entity.RestaurantEntity;

public class EvaluationFinaleConverter {

    public static EvaluationFinaleDto entityEvaluationFinaleToDto(EvaluationFinaleEntity entityEvaluationFinale){
        if(entityEvaluationFinale == null)
            return null;

        return EvaluationFinaleDto.builder()
                .id(entityEvaluationFinale.getId())
                .note(entityEvaluationFinale.getNote())
                .nom(entityEvaluationFinale.getNom())
                .nom(entityEvaluationFinale.getNom())
                .description(entityEvaluationFinale.getDescription())
                .build();
    }

    public static EvaluationFinaleEntity dtoEvaluationFinaleToEntity(EvaluationFinaleDto dtoEvaluationFinale){
        if(dtoEvaluationFinale == null)
            return null;
        return EvaluationFinaleEntity.builder()
                .id(dtoEvaluationFinale.getId())
                .note(dtoEvaluationFinale.getNote())
                .nom(dtoEvaluationFinale.getNom())
                .description(dtoEvaluationFinale.getDescription())
                .build();
    }

    public static EvaluationFinaleEntity addDtoEvaluationFinaleToEntity(AddEvaluationFinaleDto dtoEvaluationFinale, RestaurantEntity restaurantEntity){
        return EvaluationFinaleEntity.builder()
                .note(dtoEvaluationFinale.getNote())
                .nom(dtoEvaluationFinale.getNom())
                .restaurant(restaurantEntity)
                .description(dtoEvaluationFinale.getDescription())
                .build();
    }
}
