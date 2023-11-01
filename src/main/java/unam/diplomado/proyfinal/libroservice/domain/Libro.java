package unam.diplomado.proyfinal.libroservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="libros")
public class Libro {
	
	
	@Id
	private String id;
	private String nombre;
	private String autor;
	private String calif;
	private String launch_date;
	
	

}
