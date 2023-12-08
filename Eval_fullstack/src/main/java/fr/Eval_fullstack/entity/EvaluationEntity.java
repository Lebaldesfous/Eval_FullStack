package fr.Eval_fullstack.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "evaluation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
public class EvaluationEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nom", columnDefinition = "VARCHAR(50)", nullable = false)
    private String nom;

    @Column(name = "note" , nullable = false)
    private Integer note;

    @Column(name = "commentaire", columnDefinition= "VARCHAR(255)" , nullable = false)
    private String commentaire;

    @ManyToOne
    private RestaurantEntity restaurant;

    @Column(name="dateCreation" , columnDefinition = "DATE", nullable = false)
    private String dateCreation;


    @Column(name="dateModification" , columnDefinition = "DATE", nullable = false)
    private String dateModification;

}
