package unam.diplomado.proyfinal.libroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.proyfinal.libroservice.domain.Libro;


public interface LibroRepository extends MongoRepository<Libro, String>{

}
