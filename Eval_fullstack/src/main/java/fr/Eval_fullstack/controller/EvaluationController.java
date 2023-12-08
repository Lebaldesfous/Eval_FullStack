package fr.Eval_fullstack.controller;


import fr.Eval_fullstack.converter.EvaluationConverter;
import fr.Eval_fullstack.dto.request.AddEvaluationDto;
import fr.Eval_fullstack.entity.EvaluationEntity;
import fr.Eval_fullstack.entity.RestaurantEntity;
import fr.Eval_fullstack.service.EvaluationService;
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
public class EvaluationController {

    private final EvaluationService evaluationService;
    private final RestaurantService restaurantService;

    @GetMapping("/evaluations")
    public List<EvaluationEntity> getEvaluations() {
        return evaluationService.getEvaluations();
    }

    @GetMapping("/restaurants/{id}/evaluations")
    public List<EvaluationEntity> getEvaluationsByIdRestaurant(@Valid @PathVariable Integer id) {
        restaurantService.getRestaurant(id);
        return evaluationService.getEvaluationsByIdRestaurant(id);
    }

    @PostMapping("/restaurants/{id}/evaluations")
    public EvaluationEntity addEvaluation(@Valid @PathVariable Integer id ,@Valid @RequestBody AddEvaluationDto evaluationDto) {
        RestaurantEntity restaurant = restaurantService.getRestaurant(id);
        return evaluationService.addEvaluation(EvaluationConverter.dtoEvaluationToEntity(evaluationDto,restaurant));
    }

    @DeleteMapping("/restaurants/{id}/evaluations/{idEvaluation}")
    public void deleteEvaluation(@Valid @PathVariable Integer id,@Valid @PathVariable Integer idEvaluation) {
        restaurantService.getRestaurant(id);
        evaluationService.deleteEvaluation(idEvaluation);
    }

    @PutMapping("/restaurants/{id}/evaluations/{idEvaluation}")
    public EvaluationEntity updateEvaluation(@Valid @PathVariable Integer id,@Valid @PathVariable Integer idEvaluation,@Valid @RequestBody AddEvaluationDto evaluationDto) {
        restaurantService.getRestaurant(id);
        EvaluationEntity evaluation = evaluationService.getEvaluationById(idEvaluation);
        if (evaluationDto.getCommentaire() != null)
            evaluation.setCommentaire(evaluationDto.getCommentaire());
        if (evaluationDto.getNom() != null)
            evaluation.setNom(evaluationDto.getNom());
        if (evaluationDto.getNote() != null)
            evaluation.setNote(evaluationDto.getNote());


        return evaluationService.updateEvaluation(evaluation);
    }
}
