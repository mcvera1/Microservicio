package co.com.webService.mainAplicacion;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.webService.dto.Persona;
import co.com.webService.exception.PersonaNoContentException;
import co.com.webService.exception.PersonaNotFoundException;
import co.com.webService.service.ServiciosUsuarioInterface;

@RestController
public class AplicacionController {
	
	@Autowired
	@Qualifier("usuarios")//sirve para invocar la implementacion que se necesita cada implementacion tiene su qualifier
	ServiciosUsuarioInterface servicioUsuario;

	@RequestMapping("/hola")
	public String hola() {
		return ("hola mundo");
	}
	
	@GetMapping("/obtenerPersona/{id}") 
	public Persona obtenerPersona(@Valid @PathVariable Long id) {
		Persona persona = servicioUsuario.obtenerUsuarios(id);
		if(persona == null) {
			throw new PersonaNotFoundException("id:"+ id);
		}
		return persona;
	}
	
	@DeleteMapping("/eliminarPersona/{id}")
	public boolean eliminarPersona(@PathVariable Long id) {
		boolean encontroUsuario;
		try {
			encontroUsuario = servicioUsuario.eliminarUsuario(id);
			if(!encontroUsuario) {
				throw new PersonaNoContentException("Bad id:"+ id);
			}
		}catch(Exception e) {
			throw new PersonaNoContentException("Bad id:"+ id);
		}
		
		return encontroUsuario;
	}
	
	@PostMapping("/insertarUsuario")
	public ResponseEntity<Persona> insertarPersona(@RequestBody Persona personaInsertar) {
		Persona persona = servicioUsuario.registrarPersona(personaInsertar);
		if (persona != null) {
			return new ResponseEntity<Persona>(persona, HttpStatus.OK);
		}else {
			return new ResponseEntity<Persona>(persona, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/actualizarUsuario")
	public Persona actualizarPersona(@RequestBody Persona personaActualizar) {
		Persona persona = servicioUsuario.actualizarUsuario(personaActualizar);
		return persona;
	}
	
	@GetMapping("/obtenerPersonas") 
	public List<Persona> obtenerPersonas() {
		List<Persona> personas = servicioUsuario.listaUsuarios();
		if(personas.size() == 0) {
			throw new PersonaNotFoundException();
		}
		return personas;
	}

}
