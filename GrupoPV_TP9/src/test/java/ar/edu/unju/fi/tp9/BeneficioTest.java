package ar.edu.unju.fi.tp9;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
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
		//List<Cliente>clientes= new ArrayList<Cliente>();
		List<Beneficio> beneficios= new ArrayList<Beneficio>();
		Beneficio beneficio= new Beneficio();
		
		Cliente cliente1 = new Cliente();
		
		cliente1.setTipoDocumento("DNI");
		cliente1.setNroDocumento(35892564);
		cliente1.setNombreApellido("Silvana Suarez");
		cliente1.setEmail("sil240@mail.com");
		cliente1.setPassword("1234");
		cliente1.setFechaNacimiento(LocalDate.of(1995,10,11));
		cliente1.setEdad(cliente1.getEdad());
		cliente1.setCodigoAreaTelefono(388);
		cliente1.setNroTelefono(3452673);
		cliente1.setFechaUltimaCompra(LocalDate.now());
		cliente1.setCuenta(null);
		
		beneficio.setDescripcion("15% descuento cliente Bco. Macro");
		beneficioService.addBeneficio(beneficio);
		Beneficio beneficio2= new Beneficio();
		beneficio2.setDescripcion("10% descuento para jubilados");
		beneficioService.addBeneficio(beneficio2);
		cliente1.setBeneficios(beneficioService.getAllBeneficios());
		
		clienteService.addCliente(cliente1);
		
		
		assertEquals("10% de descuento", beneficio.getDescripcion());
		/*
		
		beneficio.setId((long) 20);
		beneficio.setDescripcion("Jubilados 100% de descuento");
		System.out.println(beneficio);
		clientes= clienteService.getClientes();
		
		
		//Cliente cliente1 = clienteService.getClienteId((long) 1);
		//Cliente cliente2 = clienteService.getClientePorNroDocumento(66745321);//Paula
		//Cliente cliente3 = clienteService.getClientePorNroDocumento(42582629);//Andrea bejarano
		//cliente1.toString();
		//clientes.add(cliente1)
	//	clientes.add(cliente2);
/*
		System.out.println(beneficio);
		
		beneficioService.addBeneficio(beneficio);
		assertEquals("Jubilado",beneficio.getDescripcion());
		*/
		
	}

}
