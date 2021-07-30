package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;


public interface IEmployeService {


	List<Employe> RetrieveAllEmployee(); 
	Employe addEmploye(Employe e);
	void deleteEmploye(long id);
	Employe updateEmploye(Employe e);
	Employe retrieveEmploye (long id);

	
}
