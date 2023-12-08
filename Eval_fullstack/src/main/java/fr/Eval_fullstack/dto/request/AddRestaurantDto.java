package fr.Eval_fullstack.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.Eval_fullstack.dto.response.TagDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddRestaurantDto {

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("adresse")
    private String adresse;

    @JsonProperty("tags")
    private List<TagDto> tags;

}
