package co.com.webService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import co.com.webService.dao.PersonRepository;
import co.com.webService.dto.Persona;
import javassist.NotFoundException;

@Service
@EnableJpaRepositories("co.com.webService.dao")
@EntityScan("co.com.webService")
@Qualifier("usuarios")
public class ServicioUsuariosImp implements ServiciosUsuarioInterface {

	List<Persona> listaPersonas = new ArrayList<>();
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public Persona registrarPersona(Persona persona) {
		try {
			personRepository.save(persona);						
		}catch(Exception e) {
			e.printStackTrace();
		}
		return persona;
	}

	@Override
	public Persona obtenerUsuarios(Long id) {
		Persona persona = null;
		try {
			persona = personRepository.findOne(id);						
		}catch(Exception e) {
			e.printStackTrace();
		}
		return persona;
	}

	@Override
	public Persona actualizarUsuario(Persona persona) {
		try {
			personRepository.save(persona);			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return persona;
	}

	@Override
	public boolean eliminarUsuario(Long id) throws NotFoundException {
		Persona persona = personRepository.findOne(id);
		if(persona != null) {
			personRepository.delete(id);
			return Boolean.TRUE;
		}else {
			return Boolean.FALSE;			
		}
	}

	@Override
	public List<Persona> listaUsuarios() {
		List<Persona> personas = null;
		try {
			personas = personRepository.findAll();			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return personas;
	}

}
