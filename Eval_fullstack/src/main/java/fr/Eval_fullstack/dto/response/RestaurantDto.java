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
public class RestaurantDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("adresse")
    private String adresse;

    @JsonProperty("moyenne")
    private float moyenne;

    @JsonProperty("evaluations")
    private List<EvaluationDto> evaluations;

    @JsonProperty("evaluationFinale")
    private EvaluationFinaleDto evaluationFinale;

    @JsonProperty("illustrations")
    private List<String> illustrations;

    @JsonProperty("tags")
    private List<String> tags;

}
