package ar.edu.unju.fi.tp9;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tp9.model.Beneficio;
import ar.edu.unju.fi.tp9.model.Cliente;
import ar.edu.unju.fi.tp9.service.IBeneficioService;
import ar.edu.unju.fi.tp9.service.IClienteService;
@SpringBootTest
class BeneficioTest {

	@Autowired
	@Qualifier("clienteServiceMysql")
	IClienteService clienteService;
	@Autowired
	@Qualifier("beneficioServiceMysql")
	IBeneficioService beneficioService;
	
	
	@Test
	void test() {
		List<Cliente>clientes= new ArrayList<Cliente>();
		Beneficio beneficio= new Beneficio();
		beneficio.setDescripcion("Jubilado");
		
		Cliente cliente1 = clienteService.getClientePorId(1);
		//Cliente cliente2 = clienteService.getClientePorNroDocumento(66745321);//Paula
		//Cliente cliente3 = clienteService.getClientePorNroDocumento(42582629);//Andrea bejarano
		
		clientes.add(cliente1);
	//	clientes.add(cliente2);
	//	clientes.add(cliente3);
		
		beneficio.setClientes(clientes);
		
		beneficioService.guardarBeneficio(beneficio);
		assertEquals("Jubilado",beneficio.getDescripcion());
		
		
	}

}
