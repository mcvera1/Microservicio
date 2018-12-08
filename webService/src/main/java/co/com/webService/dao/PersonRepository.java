package co.com.webService.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.webService.dto.Persona;

@Repository
public interface PersonRepository extends CrudRepository<Persona, Long> {

	List<Persona> findById(Long id);//despues del findBy va alguno de los atributos del dto Persona
	
	List<Persona> findAll();
}
