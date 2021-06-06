package ar.edu.unju.fi.tp9.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tp9.model.Cliente;

public interface IClienteService {
	
	
	public void guardarCliente(Cliente cliente);
	public void addCliente(Cliente cliente);
	public List<Cliente>getClientes();
	public void generarListaClientes();
	public Optional<Cliente>getClientePorId(Long id);
	public void borrarCliente(Long id);

	
	

}
