package fr.Eval_fullstack.converter;

import fr.Eval_fullstack.dto.request.AddEvaluationDto;
import fr.Eval_fullstack.dto.response.EvaluationDto;
import fr.Eval_fullstack.entity.EvaluationEntity;
import fr.Eval_fullstack.entity.RestaurantEntity;
import fr.Eval_fullstack.exception.InvalidArgumentException;

import javax.swing.text.html.parser.Entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EvaluationConverter {
    static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
    public static EvaluationDto entityEvaluationToDto(EvaluationEntity entityEvaluation){
        return EvaluationDto.builder().id(entityEvaluation.getId()).note(entityEvaluation.getNote()).nom(entityEvaluation.getNom()).commentaire(entityEvaluation.getCommentaire()).dateCreation(entityEvaluation.getDateCreation().toString()).dateModification(entityEvaluation.getDateModification().toString()).build();
    }

    public static EvaluationEntity dtoEvaluationToEntity(EvaluationDto dtoEvaluation){
        try{
            return EvaluationEntity.builder().id(dtoEvaluation.getId()).note(dtoEvaluation.getNote()).nom(dtoEvaluation.getNom()).commentaire(dtoEvaluation.getCommentaire()).dateCreation(formatter.parse(dtoEvaluation.getDateCreation())).dateModification(formatter.parse(dtoEvaluation.getDateModification())).build();
        }catch (ParseException e){
            throw new InvalidArgumentException("La date n'est pas au bon format");
        }
    }

    public static EvaluationEntity dtoEvaluationToEntity(AddEvaluationDto dtoEvaluation, RestaurantEntity restaurantEntity){
        try{
            return EvaluationEntity.builder().note(dtoEvaluation.getNote()).nom(dtoEvaluation.getNom()).restaurant(restaurantEntity).commentaire(dtoEvaluation.getCommentaire()).dateCreation(formatter.parse(dtoEvaluation.getDateCreation())).dateModification(formatter.parse(dtoEvaluation.getDateModification())).build();
        }catch (ParseException e){
            throw new InvalidArgumentException("La date n'est pas au bon format");
        }
    }

    public static List<EvaluationEntity> dtoEvaluationsToEntity(List<EvaluationDto> l) {
        List<EvaluationEntity> lEntity = new ArrayList<>();
        if(l == null){
            return lEntity;
        }
        l.forEach(evaluationDto -> {
            lEntity.add(dtoEvaluationToEntity(evaluationDto));
        });t
        return lEntity;
    }

    public static List<EvaluationDto> entityEvaluationsToDto(List<EvaluationEntity> l) {
        if(l == null){
            return new ArrayList<EvaluationDto>();
        }
        List<EvaluationDto> lDto = new ArrayList<>();
        l.forEach(evaluationEntity -> {
            lDto.add(entityEvaluationToDto(evaluationEntity));
        });
        return lDto;
    }
}
