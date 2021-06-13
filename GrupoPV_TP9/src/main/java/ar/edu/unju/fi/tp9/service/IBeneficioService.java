package ar.edu.unju.fi.tp9.service;

import java.util.List;

import ar.edu.unju.fi.tp9.model.Beneficio;

public interface IBeneficioService {
	
	public Beneficio getBeneficio();
	public void addBeneficio(Beneficio beneficio);
	public List<Beneficio> getAllBeneficios();
	public Beneficio getBeneficioId(Long id);
	public void deleteBeneficio(Long id);
	
}
