package fr.Eval_fullstack.controller;


import fr.Eval_fullstack.converter.EvaluationFinaleConverter;
import fr.Eval_fullstack.dto.request.AddEvaluationFinaleDto;
import fr.Eval_fullstack.dto.response.EvaluationFinaleDto;
import fr.Eval_fullstack.entity.EvaluationFinaleEntity;
import fr.Eval_fullstack.service.EvaluationFinaleService;
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
public class EvaluationFinaleController {

    private final EvaluationFinaleService evaluationFinaleService;
    private final RestaurantService restaurantService;

    @GetMapping("/evaluationsfinales")
    public List<EvaluationFinaleEntity> getEvaluationsFinales() {
        return evaluationFinaleService.getEvaluationsFinales();
    }

    @GetMapping("/restaurants/{id}/evaluationfinale")
    public EvaluationFinaleEntity getEvaluationFinaleByIdRestaurant(@Valid @PathVariable Integer id) {
        return evaluationFinaleService.getEvaluationFinaleByIdRestaurant(id);
    }

    @PostMapping("/restaurants/{id}/evaluationfinale")
    public EvaluationFinaleEntity addEvaluationFinale(@Valid @PathVariable Integer id, @Valid @RequestBody AddEvaluationFinaleDto addEvaluationFinaleDto) {
        log.info("addEvaluationFinaleDto : {}", addEvaluationFinaleDto);
        return evaluationFinaleService.addEvaluationFinale(EvaluationFinaleConverter.addDtoEvaluationFinaleToEntity(addEvaluationFinaleDto, restaurantService.getRestaurant(id)));
    }

    @PutMapping("/restaurants/{id}/evaluationfinale")
    public EvaluationFinaleEntity updateEvaluationFinale(@Valid @PathVariable Integer id,@Valid @RequestBody EvaluationFinaleDto evaluationFinaleDto) {
        restaurantService.getRestaurant(id);
        EvaluationFinaleEntity tmp = evaluationFinaleService.getEvaluationFinaleByIdRestaurant(id);

        if(evaluationFinaleDto.getNom() != null)
            tmp.setNom(evaluationFinaleDto.getNom());
        if(evaluationFinaleDto.getNote() != null)
            tmp.setNote(evaluationFinaleDto.getNote());
        if(evaluationFinaleDto.getDescription() != null)
            tmp.setDescription(evaluationFinaleDto.getDescription());

        return evaluationFinaleService.updateEvaluationFinale(tmp);
    }
}
