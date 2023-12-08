package fr.Eval_fullstack.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddEvaluationDto {

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("commentaire")
    private String commentaire;

    @JsonProperty("note")
    private Integer note;

    @JsonProperty("dateCreation")
    private String dateCreation;

    @JsonProperty("dateModification")
    private String dateModification;


}
