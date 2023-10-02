package unam.diplomado.pixup.usuariomicroservice.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.pixup.usuariomicroservice.domain.Domicilio;
import unam.diplomado.pixup.usuariomicroservice.domain.Usuario;

@Data
@NoArgsConstructor
public class RegistroUsuarioRequest {
	
	@NotNull
	@Valid
	private Usuario usuario;
	@NotNull
	@Valid
	private Domicilio domicilio;

}
