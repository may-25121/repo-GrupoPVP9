package ar.edu.unju.fi.tp9.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp9.model.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Long> {
	
	public Producto findByCodigo(int codigo);

}
