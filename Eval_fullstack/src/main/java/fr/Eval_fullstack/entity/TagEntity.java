package fr.Eval_fullstack.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tag")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
public class TagEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nom", columnDefinition = "VARCHAR(90)", nullable = false)
    private String nom;

    @ManyToMany
    @JsonBackReference
    private List<RestaurantEntity> restaurants;
}
