package unam.diplomado.pixup.usuariomicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pixup.usuariomicroservice.domain.Estado;

public interface EstadoRepository 
	extends MongoRepository<Estado, String>{
	

}
