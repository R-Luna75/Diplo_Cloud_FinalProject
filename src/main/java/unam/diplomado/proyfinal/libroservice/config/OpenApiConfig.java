package unam.diplomado.proyfinal.libroservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				version = "v1",
				title = "Proyecto Final Microservice Endpoints",
				description = "Definición de los Endpoints del " 
				+ "servicio de registros de libros para el Proyecto Final del Diplomado.",
				contact = @Contact(
						name = "UNAM",
						url = "https://www.unam.mx/",
						email = "lunaesquivelrodrigo@gmail.com")))


public class OpenApiConfig {

}
