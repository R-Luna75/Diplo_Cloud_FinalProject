package unam.diplomado.pixup.discoservice.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import unam.diplomado.pixup.discoservice.domain.Artista;

@RequestMapping(path="api/artistas", produces="application/json")
@CrossOrigin(origins="*")
@Tag(name="artista", description="Api del Recurso Artista")
public interface ArtistaApi {
	
	@Operation(summary="Crear Artista")
	@ApiResponses(value= {
			@ApiResponse(responseCode="201",
					description="Artista Creado Exitosamente",
					content= {
							@Content(mediaType="application/json",
									schema=@Schema(implementation=Artista.class))})
			})
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	Artista crearArtista(@RequestBody Artista artista);
	
	@Operation(summary="Obtener Artistas")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",
					description="Artistas Obtenidos Exitosamente",
					content= {
							@Content(mediaType="application/json",
									schema=@Schema(implementation=Artista.class))})})
	@GetMapping
	List<Artista> obtenerArtistas();
	
	
	@Operation(summary="Obtener Artista por Id")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",
					description="Artista Obtenido Exitosamente",
					content= {
							@Content(mediaType="application/json",
									schema=@Schema(implementation=Artista.class))}),
			@ApiResponse(responseCode="404",
					description="Artista no encontrado",
					content=@Content)})
	@GetMapping("{id}")
	ResponseEntity<Artista> obtenerArtistaPorId(@PathVariable("id") String id);
	
	
	@Operation(summary="Actualizar Artista por Id")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",
					description="Artista Actualizado Exitosamente",
					content= {
							@Content(mediaType="application/json",
									schema=@Schema(implementation=Artista.class))}),
			@ApiResponse(responseCode="404",
					description="Artista no encontrado",
					content=@Content)})
	@PutMapping(path="{id}", consumes="application/json")
	ResponseEntity<Artista> actualizarArtista(@PathVariable("id") String id, @RequestBody Artista artista);
	
	
	@Operation(summary="Eliminar Artista por ID")
	@ApiResponses(value= {
			@ApiResponse(responseCode="204",
					description="Artista Eliminado",
					content= @Content)})
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void eliminarArtista(@PathVariable("id") String id);
	
	
	
}
	