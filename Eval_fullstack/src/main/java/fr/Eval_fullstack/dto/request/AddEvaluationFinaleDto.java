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
public class AddEvaluationFinaleDto {

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("note")
    private Integer note;

    @JsonProperty("description")
    private String description;
}
