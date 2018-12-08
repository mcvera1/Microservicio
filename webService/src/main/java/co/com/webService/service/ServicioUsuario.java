package co.com.webService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.com.webService.dto.Persona;
import javassist.NotFoundException;

@Service
@Qualifier("usuariosSinBD")
public class ServicioUsuario implements ServiciosUsuarioInterface{

	@Override
	public Persona registrarPersona(Persona persona) {
		System.err.println("entre registrarPersona");
		return null;
	}

	@Override
	public Persona obtenerUsuarios(Long id) {
		System.err.println("entre obtenerUsuarios");
		return null;
	}

	@Override
	public Persona actualizarUsuario(Persona persona) {
		System.err.println("entre actualizarUsuario");
		return null;
	}

	@Override
	public boolean eliminarUsuario(Long id) throws NotFoundException {
		System.err.println("entre eliminarUsuario");
		return false;
	}

	@Override
	public List<Persona> listaUsuarios() {
		System.err.println("entre listaUsuarios");
		return null;
	}

}
