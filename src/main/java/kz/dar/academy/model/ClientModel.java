package kz.dar.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientModel {
    @NotNull(message = "Client id can not be empty")
    private String clientId;
    @NotNull(message = "Recipient id can not be empty")
    private String name;
    private String surname;
    @Email
    private String email;
}
