package tech.teslex.telegroo.telegram.api.types.passport.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class PassportElementError {
}
