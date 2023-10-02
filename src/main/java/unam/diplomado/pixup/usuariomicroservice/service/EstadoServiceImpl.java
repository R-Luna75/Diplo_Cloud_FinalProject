package unam.diplomado.pixup.usuariomicroservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.pixup.usuariomicroservice.domain.Estado;
import unam.diplomado.pixup.usuariomicroservice.repository.EstadoRepository;

@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	
	@Override
	public Estado actualizarEstado(String Id, Estado estado) {
		Optional<Estado> estadoExistente = estadoRepository.findById(Id);
		if(estadoExistente.isPresent()) {
			Estado estadoActualizar = estadoExistente.get();
			estadoActualizar.setNombre(estado.getNombre());
			estadoRepository.save(estadoActualizar);
			return estadoActualizar;
		}
		return null;
	}

}
