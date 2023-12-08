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
public class AddRestaurantDto {

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("adresse")
    private String adresse;



}
