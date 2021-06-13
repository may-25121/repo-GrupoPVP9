package ar.edu.unju.fi.tp9.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BENEFCIOS")
public class Beneficio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BENEFICIO_ID")
	private Long id;
	
	@Column(name = "BENEFICIO_DESCRIPCION")
	private  String descripcion;
	
	/*@ManyToMany
	@JoinTable(name = "BENEFICIO_CLIENTE",
				joinColumns = @JoinColumn(name="BENEFICIO_ID"),
				inverseJoinColumns = @JoinColumn(name="CLIENTE_ID"))
	private List<Cliente> clientes = new ArrayList<Cliente>();
*/
	
	@ManyToMany(mappedBy="beneficios")
	@Column(name = "clientes")
	private List<Cliente> clientes = new ArrayList<Cliente>();
		
	public Beneficio() {
	}


	public Beneficio(Long id, String descripcion, List<Cliente> clientes) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.clientes = clientes;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
/*

	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
*/
	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	

	@Override
	public String toString() {
		return "Beneficio [id=" + id + ", descripcion=" + descripcion ;
	}



	
	

}
