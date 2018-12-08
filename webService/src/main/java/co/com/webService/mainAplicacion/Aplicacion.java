package co.com.webService.mainAplicacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"co.com.webService"})//por etiqueta los bean deben tener el component scan
public class Aplicacion extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}
}
