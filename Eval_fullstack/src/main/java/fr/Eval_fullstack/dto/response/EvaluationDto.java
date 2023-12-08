package fr.Eval_fullstack.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EvaluationDto {

    @JsonProperty("id")
    private Integer id;

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

    @JsonProperty("photos")
    private List<String> photos;
}
