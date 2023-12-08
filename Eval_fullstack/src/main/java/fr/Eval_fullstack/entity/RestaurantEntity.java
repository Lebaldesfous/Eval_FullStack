package fr.Eval_fullstack.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "restaurant")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
public class RestaurantEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nom", columnDefinition = "VARCHAR(90)", nullable = false)
    private String nom;

    @Column(name = "adresse", columnDefinition = "VARCHAR(255)", nullable = false)
    private String adresse;

    @Column(name="moyenne" , columnDefinition = "FLOAT(2)", nullable = false)
    private Float moyenne;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<EvaluationEntity> evaluations;

    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private EvaluationFinaleEntity evaluationFinale;

}
