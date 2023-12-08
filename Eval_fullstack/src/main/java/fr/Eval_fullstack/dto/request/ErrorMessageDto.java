package fr.Eval_fullstack.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorMessageDto {

    @JsonProperty("code")
    public String code;
    @JsonProperty("message")
    public String message;
}
