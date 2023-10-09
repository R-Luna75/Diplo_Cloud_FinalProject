package unam.diplomado.pixup.discoservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pixup.discoservice.domain.Artista;

public interface ArtistaRepository extends MongoRepository<Artista, String>{
	
}
