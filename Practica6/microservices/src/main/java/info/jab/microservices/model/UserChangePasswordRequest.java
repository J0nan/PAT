package info.jab.microservices.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserChangePasswordRequest {
    @NotNull
	@NotEmpty
	@Pattern(message="max 10 words please" , regexp="^[a-zA-Z-.0-9]{1,15}$")
    private String currentPassword;
    @NotNull
	@NotEmpty
	@Pattern(message="max 10 words please" , regexp="^[a-zA-Z-.0-9]{1,15}$")
    private String newPassword;
    @NotNull
	@NotEmpty
	@Pattern(message="max 10 words please" , regexp="^[a-zA-Z-.0-9]{1,15}$")
    private String newPassword2;
}
