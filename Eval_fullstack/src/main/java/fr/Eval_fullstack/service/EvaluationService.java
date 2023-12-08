package fr.Eval_fullstack.service;

import fr.Eval_fullstack.entity.EvaluationEntity;
import fr.Eval_fullstack.exception.NotFoundException;
import fr.Eval_fullstack.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public List<EvaluationEntity> getEvaluations() {
        return evaluationRepository.findAll();
    }

    public List<EvaluationEntity> getEvaluationsByIdRestaurant(Integer id) {
        return evaluationRepository.findAllByRestaurantId(id);
    }

    public EvaluationEntity getEvaluationById(Integer idEvaluation) {
        return evaluationRepository.findById(idEvaluation).orElseThrow(() -> new NotFoundException("Evaluation non trouvée"));
    }

    public EvaluationEntity addEvaluation(EvaluationEntity evaluationEntity) {
        return evaluationRepository.save(evaluationEntity);
    }

    public void deleteEvaluation(Integer idEvaluation) {
        evaluationRepository.deleteById(idEvaluation);
    }

    public EvaluationEntity updateEvaluation(EvaluationEntity evaluationEntity) {
        return evaluationRepository.save(evaluationEntity);
    }


}
