package unam.diplomado.pixup.usuariomicroservice.service;

import unam.diplomado.pixup.usuariomicroservice.domain.Domicilio;
import unam.diplomado.pixup.usuariomicroservice.domain.Usuario;

public interface UsuarioService {
	
	Usuario registrarUsuario(Usuario usuario, Domicilio domicilio);

}
