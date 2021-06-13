package ar.edu.unju.fi.tp9.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Beneficio;
import ar.edu.unju.fi.tp9.repository.IBeneficioDAO;
import ar.edu.unju.fi.tp9.service.IBeneficioService;

@Service("beneficioServiceMysql")
public class BeneficioServiceImp implements IBeneficioService{

	@Autowired
	IBeneficioDAO beneficioDAO;
	
	@Autowired
	private Beneficio beneficio;

	@Override
	public Beneficio getBeneficio() {
		return this.beneficio;
	}

	@Override
	public void addBeneficio(Beneficio beneficio) {
		beneficioDAO.save(beneficio);
	}

	@Override
	public List<Beneficio> getAllBeneficios() {
		List<Beneficio> beneficios = (List<Beneficio>) beneficioDAO.findAll();
		return beneficios;
	}

	@Override
	public Beneficio getBeneficioId(Long id) {
		Beneficio beneficio=beneficioDAO.findById((long)id);
		return beneficio;
	}

	@Override
	public void deleteBeneficio(Long id) {
		beneficioDAO.deleteById(id);
	}
	
	

}
