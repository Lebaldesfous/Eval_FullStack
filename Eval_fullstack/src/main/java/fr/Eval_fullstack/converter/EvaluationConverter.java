package fr.Eval_fullstack.converter;

import fr.Eval_fullstack.dto.request.AddEvaluationDto;
import fr.Eval_fullstack.dto.response.EvaluationDto;
import fr.Eval_fullstack.entity.EvaluationEntity;

import java.util.ArrayList;
import java.util.List;

public class EvaluationConverter {

    public static EvaluationDto entityEvaluationToDto(EvaluationEntity entityEvaluation){
        return EvaluationDto.builder().id(entityEvaluation.getId()).note(entityEvaluation.getNote()).nom(entityEvaluation.getNom()).commentaire(entityEvaluation.getCommentaire()).dateCreation(entityEvaluation.getDateCreation()).dateModification(entityEvaluation.getDateModification()).build();
    }

    public static EvaluationEntity dtoEvaluationToEntity(EvaluationDto dtoEvaluation){
        return EvaluationEntity.builder().id(dtoEvaluation.getId()).note(dtoEvaluation.getNote()).nom(dtoEvaluation.getNom()).commentaire(dtoEvaluation.getCommentaire()).dateCreation(dtoEvaluation.getDateCreation()).dateModification(dtoEvaluation.getDateModification()).build();
    }

    public static EvaluationEntity dtoEvaluationToEntity(AddEvaluationDto dtoEvaluation){
        return EvaluationEntity.builder().note(dtoEvaluation.getNote()).nom(dtoEvaluation.getNom()).commentaire(dtoEvaluation.getCommentaire()).dateCreation(dtoEvaluation.getDateCreation()).dateModification(dtoEvaluation.getDateModification()).build();
    }

    public static List<EvaluationEntity> dtoEvaluationsToEntity(List<EvaluationDto> l) {
        List<EvaluationEntity> lEntity = new ArrayList<>();
        if(l == null){
            return lEntity;
        }
        l.forEach(evaluationDto -> {
            lEntity.add(dtoEvaluationToEntity(evaluationDto));
        });
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
