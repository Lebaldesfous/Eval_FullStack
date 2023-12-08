package fr.Eval_fullstack.repository;

import fr.Eval_fullstack.entity.EvaluationFinaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationFinaleRepository extends JpaRepository<EvaluationFinaleEntity, Integer> {
}
