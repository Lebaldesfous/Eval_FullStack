package fr.Eval_fullstack.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    private String nom;
}
