package ar.edu.unju.fi.tp9.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.tp9.model.Beneficio;
import ar.edu.unju.fi.tp9.model.Cliente;
import ar.edu.unju.fi.tp9.service.IBeneficioService;
import ar.edu.unju.fi.tp9.service.IClienteService;

@Controller
public class BeneficioController {
	
	@Autowired
	private Beneficio beneficio;
	
	@Autowired
	@Qualifier("beneficioServiceMysql")
	IBeneficioService beneficioService;
	
	@Autowired
	@Qualifier("clienteServiceMysql")
	private IClienteService clienteService;
	
	
	@GetMapping("/beneficio/nuevo")
	public String getBeneficioNuevoPage(Model model) {
		this.beneficio=new Beneficio();
		model.addAttribute("beneficio", this.beneficio);
		model.addAttribute("clientesdisponibles", this.clienteService.getClientes());
		return "nuevobeneficio";
	}
	
	@GetMapping("/beneficio/listar")
	public String getBeneficioListaPage(Model model) {
		model.addAttribute("beneficios", beneficioService.getAllBeneficios());
		model.addAttribute("beneficio",beneficioService.getBeneficio());
		System.out.println(beneficio);
		return "listarbeneficios";
	}
	
	@GetMapping("/beneficio/editar/{id}")
	public String getBeneficioModificarPage(@PathVariable(name="id")Long id, Model model) {
		this.beneficio=	beneficioService.getBeneficioId(id);
		model.addAttribute("beneficio", this.beneficio);
		model.addAttribute("clientesdisponibles", this.clienteService.getClientes());
		model.addAttribute("clientesbeneficios", this.beneficio.getClientes());
		return "nuevobeneficio";
	}
	
	@PostMapping("/beneficio/guardar")
	public String saveBeneficio(@ModelAttribute("beneficio") Beneficio beneficio, Model model) {
		try {
			beneficioService.addBeneficio(beneficio);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		model.addAttribute("beneficios", beneficioService.getAllBeneficios());
		
		return "listarbeneficios";
	}
	
	@GetMapping("/beneficio/borrar/{id}")
	public String DeleteBeneficioPage(@PathVariable Long id, Model model) {
		List<Cliente> clientes = beneficioService.getBeneficioId(id).getClientes();
		clienteService.quitarBeneficioCliente(clientes,id);
		beneficioService.deleteBeneficio(id);
		model.addAttribute("beneficios", beneficioService.getAllBeneficios());
		return "listarbeneficios";
	}
	
	
	@GetMapping("/beneficio/{idbeneficio}/cliente/agregar/{idcliente}")
	public String agregarClienteBeneficio(@PathVariable(name="idbeneficio") Long idbeneficio, @PathVariable(name="idcliente") Long idcliente, Model model) {
		this.beneficio = beneficioService.getBeneficioId(idbeneficio);
		Cliente cliente = clienteService.getClientePorId(idcliente).get();
		cliente.getBeneficios().add(this.beneficio);
		
		try {
			clienteService.addCliente(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		this.beneficio = beneficioService.getBeneficioId(idbeneficio);
		model.addAttribute("clientesbeneficios", this.beneficio.getClientes());
		model.addAttribute("beneficio", this.beneficio);
		model.addAttribute("clientesdisponibles", this.clienteService.getClientes());
		return "nuevobeneficio";
	}
	
	
	@GetMapping("/beneficio/{idbeneficio}/cliente/quitar/{idcliente}")
	public String quitarClienteBeneficio(@PathVariable(name="idbeneficio") Long idbeneficio, @PathVariable(name="idcliente") Long idcliente, Model model) {
		this.beneficio = beneficioService.getBeneficioId(idbeneficio);
		Cliente cliente = clienteService.getClientePorId(idcliente).get();
		cliente.getBeneficios().remove(this.beneficio);
		try {
			clienteService.addCliente(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		this.beneficio = beneficioService.getBeneficioId(idbeneficio);
		model.addAttribute("clientesbeneficios", this.beneficio.getClientes());
		model.addAttribute("beneficio", this.beneficio);
		model.addAttribute("clientesdisponibles", this.clienteService.getClientes());

		return "nuevobeneficio";
	}

}
