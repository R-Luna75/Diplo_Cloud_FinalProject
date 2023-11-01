package unam.diplomado.proyfinal.libroservice.api;

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
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import unam.diplomado.proyfinal.libroservice.domain.Libro;

@RequestMapping(path="api/libros", produces="application/json")
@CrossOrigin(origins="*")
@Tag(name="libro", description="Api del Recurso Libro")
public interface LibroApi {
	
	
	@Operation(summary="Crear Libro")
	@ApiResponses(value= {
			@ApiResponse(responseCode="201",
					description="Libro Creado Exitosamente",
					content= {
							@Content(mediaType="application/json",
									schema=@Schema(implementation=Libro.class))})
			})
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	Libro crearLibro(@RequestBody Libro libro);
	
	@Operation(summary="Obtener Libros")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",
					description="Libros Obtenidos Exitosamente",
					content= {
							@Content(mediaType="application/json",
									array=@ArraySchema(schema=@Schema(implementation=Libro.class)))})})
	@GetMapping
	List<Libro> obtenerLibros();
	
	
	@Operation(summary="Obtener Libro por Id")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",
					description="Libro Obtenido Exitosamente",
					content= {
							@Content(mediaType="application/json",
									schema=@Schema(implementation=Libro.class))}),
			@ApiResponse(responseCode="404",
					description="Libro no encontrado",
					content=@Content)})
	@GetMapping("{id}")
	ResponseEntity<Libro> obtenerLibroPorId(@PathVariable("id") String id);
	
	
	@Operation(summary="Actualizar Libro por Id")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",
					description="Libro Actualizado Exitosamente",
					content= {
							@Content(mediaType="application/json",
									schema=@Schema(implementation=Libro.class))}),
			@ApiResponse(responseCode="404",
					description="Libro no encontrado",
					content=@Content)})
	@PutMapping(path="{id}", consumes="application/json")
	ResponseEntity<Libro> actualizarLibro(@PathVariable("id") String id, @RequestBody Libro libro);
	
	
	@Operation(summary="Eliminar Libro por Id")
	@ApiResponses(value= {
			@ApiResponse(responseCode="204",
					description="Libro Eliminado",
					content= @Content)})
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void eliminarLibro(@PathVariable("id") String id);
	
	

}
