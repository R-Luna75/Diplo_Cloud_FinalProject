package unam.diplomado.proyfinal.libroservice.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.proyfinal.libroservice.domain.Libro;
import unam.diplomado.proyfinal.libroservice.repository.LibroRepository;
import unam.diplomado.proyfinal.libroservice.service.LibroService;

@RestController
public class LibroController implements LibroApi{
	

	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private LibroService libroService;
	
	public List<Libro> obtenerLibros() {
		return libroRepository.findAll();
	}
	
	
	public Libro crearLibro(Libro libro) {
		return libroRepository.save(libro);
		}
	
	public ResponseEntity<Libro> obtenerLibroPorId(String id) {
		Optional<Libro> libro = libroRepository.findById(id);
		if(libro.isPresent()) {
			return new ResponseEntity<>(libro.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<Libro> actualizarLibro(String id, Libro libro) {
		Libro libroActualizado = libroService.actualizarLibro(id, libro);
		if(libroActualizado != null) {
			return new ResponseEntity<>(libroActualizado,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	
	public void eliminarLibro(String id) {
		libroRepository.deleteById(id);
	}
	
	


}
