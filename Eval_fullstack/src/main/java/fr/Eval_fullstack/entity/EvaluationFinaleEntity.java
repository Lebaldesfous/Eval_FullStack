package fr.Eval_fullstack.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "evaluationFinale")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
public class EvaluationFinaleEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nom", columnDefinition = "VARCHAR(90)", nullable = false)
    private String nom;

    @Column(name="note" ,  nullable = false)
    private Integer note;

    @Column(name="description" , columnDefinition = "TEXT", nullable = false)
    private String description;

    @OneToOne
    private RestaurantEntity restaurant;

}
