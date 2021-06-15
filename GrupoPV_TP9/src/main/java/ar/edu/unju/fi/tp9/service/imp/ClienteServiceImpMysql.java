package ar.edu.unju.fi.tp9.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Beneficio;
import ar.edu.unju.fi.tp9.model.Cliente;
import ar.edu.unju.fi.tp9.repository.IBeneficioDAO;
import ar.edu.unju.fi.tp9.repository.IClienteDAO;
import ar.edu.unju.fi.tp9.service.IClienteService;

@Service("clienteServiceMysql")
public class ClienteServiceImpMysql implements IClienteService{
	
	@Autowired
	IClienteDAO clienteDAO;
	
	@Autowired
	IBeneficioDAO beneficioDAO;
	

	@Override
	public void guardarCliente(Cliente cliente) {
		clienteDAO.save(cliente);
	}

	@Override
	public void addCliente(Cliente cliente) {
		clienteDAO.save(cliente);
	}

	@Override
	public List<Cliente> getClientes() {
		List<Cliente> clientes = (List<Cliente>) clienteDAO.findAll();
		return clientes;
	}

	@Override
	public void generarListaClientes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Cliente> getClientePorId(Long id) {
		Optional<Cliente>cliente = clienteDAO.findById(id);
		return cliente;
	}

	public void borrarCliente(Long id) {
		clienteDAO.deleteById(id);
	}

	@Override
	public Cliente getClienteId(Long id) {
		Cliente cliente = clienteDAO.findById((long)id);
		System.out.println("cliente buscado:"+cliente.toString());
		return cliente;
	}

	@Override
	public void quitarBeneficioCliente(List<Cliente> clientes, Long id) {
		List<Beneficio> beneficios = new ArrayList<>();
		List<Beneficio> beneficiosactuales = new ArrayList<>();
		for(Cliente c: clientes) {
			beneficios = clienteDAO.findById(c.getId()).get().getBeneficios();
			for(Beneficio b: beneficios) {
				if(b.getId()!=id) {
					beneficiosactuales.add(b);
				}
			}
			clienteDAO.findById(c.getId()).get().setBeneficios(beneficiosactuales);
		}
	}
	
}
