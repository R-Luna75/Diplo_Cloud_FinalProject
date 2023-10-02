package unam.diplomado.pixup.usuariomicroservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pixup.usuariomicroservice.domain.Usuario;

public interface UsuarioRepository 
	extends MongoRepository<Usuario, String>{
	Optional<Usuario> findByEmail(String email);
}
