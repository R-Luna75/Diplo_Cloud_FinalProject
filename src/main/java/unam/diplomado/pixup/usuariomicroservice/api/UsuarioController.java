package unam.diplomado.pixup.usuariomicroservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pixup.usuariomicroservice.domain.Usuario;
import unam.diplomado.pixup.usuariomicroservice.dto.RegistroUsuarioRequest;
import unam.diplomado.pixup.usuariomicroservice.service.UsuarioService;

@RestController
public class UsuarioController implements UsuarioApi{

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public Usuario registrarUsuario(
			RegistroUsuarioRequest request) {
		return usuarioService.registrarUsuario(
				request.getUsuario(), request.getDomicilio());
				
	}

}
