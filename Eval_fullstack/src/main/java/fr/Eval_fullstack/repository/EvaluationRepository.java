package fr.Eval_fullstack.repository;

import fr.Eval_fullstack.entity.EvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<EvaluationEntity, Integer> {

     List<EvaluationEntity> findAllByRestaurantId(Integer id);

}
