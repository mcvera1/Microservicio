package co.com.webService.service;

import java.util.List;

import co.com.webService.dto.Persona;
import javassist.NotFoundException;

//@FunctionalInterface una interfaz funcional solo tiene un metod abstracto ya se le definen los otros
//metodos como default java 8
//@Service
public interface ServiciosUsuarioInterface {

	public Persona registrarPersona(Persona persona);
	
	public Persona obtenerUsuarios(Long id);
	
	public Persona actualizarUsuario(Persona persona);
	
	public boolean eliminarUsuario(Long id) throws NotFoundException;
	
	public List<Persona> listaUsuarios();
	
}
