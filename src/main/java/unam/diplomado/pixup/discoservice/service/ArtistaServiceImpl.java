package unam.diplomado.pixup.discoservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.pixup.discoservice.domain.Artista;
import unam.diplomado.pixup.discoservice.repository.ArtistaRepository;

@Service
public class ArtistaServiceImpl implements ArtistaService{
	
	@Autowired
	ArtistaRepository artistaRepository;

	@Override
	public Artista actualizarArtista(String Id, Artista artista) {
		
		Optional<Artista> artistaExistente = artistaRepository.findById(Id);
		if(artistaExistente.isPresent()) {
			Artista artistaActualizar = artistaExistente.get();
			artistaActualizar.setNombre(artista.getNombre());
			artistaRepository.save(artistaActualizar);
			return artistaActualizar;
		}
		return null;
	}

}
