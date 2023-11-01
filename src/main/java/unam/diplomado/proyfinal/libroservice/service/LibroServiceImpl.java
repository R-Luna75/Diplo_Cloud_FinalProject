package unam.diplomado.proyfinal.libroservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.proyfinal.libroservice.domain.Libro;
import unam.diplomado.proyfinal.libroservice.repository.LibroRepository;


@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	LibroRepository libroRepository;

	@Override
	public Libro actualizarLibro(String Id, Libro libro) {
		
		Optional<Libro> libroExistente = libroRepository.findById(Id);
		if(libroExistente.isPresent()) {
			Libro libroActualizar = libroExistente.get();
			libroActualizar.setNombre(libro.getNombre());
			libroRepository.save(libroActualizar);
			return libroActualizar;
		}
		return null;
	}
	

}
