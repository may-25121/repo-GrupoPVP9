package ar.edu.unju.fi.tp9.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp9.model.Beneficio;
import ar.edu.unju.fi.tp9.repository.IBeneficioDAO;
import ar.edu.unju.fi.tp9.service.IBeneficioService;

@Service("beneficioServiceMysql")
public class BeneficioServiceImp implements IBeneficioService{

	@Autowired
	IBeneficioDAO beneficioDAO;
	@Override
	public void guardarBeneficio(Beneficio beneficio) {
		beneficioDAO.save(beneficio);
		
	}

}
