package ar.edu.unju.fi.tp9.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp9.model.Beneficio;

public interface IBeneficioDAO extends CrudRepository<Beneficio, Long>{
	
	public Beneficio findById(long id);

}
