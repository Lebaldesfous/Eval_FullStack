package fr.Eval_fullstack.service;

import fr.Eval_fullstack.entity.EvaluationFinaleEntity;
import fr.Eval_fullstack.exception.NotFoundException;
import fr.Eval_fullstack.repository.EvaluationFinaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationFinaleService {

    private final EvaluationFinaleRepository evaluationFinaleRepository;

    public List<EvaluationFinaleEntity> getEvaluationsFinales() {
        return evaluationFinaleRepository.findAll();
    }
    public EvaluationFinaleEntity getEvaluationFinaleByIdRestaurant(Integer id) {
        return evaluationFinaleRepository.findByRestaurantId(id).orElseThrow(() -> new NotFoundException("Evaluation finale non trouvée"));
    }

    public EvaluationFinaleEntity addEvaluationFinale(EvaluationFinaleEntity evaluationFinaleEntity) {
        return evaluationFinaleRepository.save(evaluationFinaleEntity);
    }

    public void deleteEvaluationFinale(Integer id) {
        evaluationFinaleRepository.deleteById(id);
    }

    public EvaluationFinaleEntity updateEvaluationFinale(EvaluationFinaleEntity evaluationFinaleEntity) {
        return evaluationFinaleRepository.save(evaluationFinaleEntity);
    }


}
