package unam.diplomado.pixup.discoservice.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.pixup.discoservice.domain.Artista;
import unam.diplomado.pixup.discoservice.repository.ArtistaRepository;
import unam.diplomado.pixup.discoservice.service.ArtistaService;

@RestController
public class ArtistaController implements ArtistaApi{
	
	@Autowired
	private ArtistaRepository artistaRepository;

	@Autowired
	private ArtistaService artistaService;
	
	public List<Artista> obtenerArtistas() {
		return artistaRepository.findAll();
	}
	
	
	public Artista crearArtista(Artista artista) {
		return artistaRepository.save(artista);
		}
	
	public ResponseEntity<Artista> obtenerArtistaPorId(String id) {
		Optional<Artista> artista = artistaRepository.findById(id);
		if(artista.isPresent()) {
			return new ResponseEntity<>(artista.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	
	public ResponseEntity<Artista> actualizarArtista(String id, Artista artista) {
		Artista artistaActualizado = artistaService.actualizarArtista(id, artista);
		if(artistaActualizado != null) {
			return new ResponseEntity<>(artistaActualizado,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	
	public void eliminarArtista(String id) {
		artistaRepository.deleteById(id);
	}
	
	

}
