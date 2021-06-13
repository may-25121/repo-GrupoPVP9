package ar.edu.unju.fi.tp9.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp9.model.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long> {
	
	public Cliente findById(long id);

}
