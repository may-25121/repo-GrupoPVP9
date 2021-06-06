package ar.edu.unju.fi.tp9.service;

import java.util.List;

import ar.edu.unju.fi.tp9.model.Producto;



public interface IProductoService {
	
	public Producto getProducto();
	
	public void addProducto(Producto producto);
	
	public Producto getUltimoProducto();
	
	public List<Producto> getAllProductos();
	
	public Producto searchProducto(int codigo);
	
}
