package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;

import tn.esprit.spring.repository.EmployeRepository;




@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);


	
	
	
	@Override
	public List<Employe> RetrieveAllEmployee() {
		List<Employe> employes = null; 
		try {
	
			l.info("In retrieveAllEmployes() : ");
			employes = (List<Employe>) employeRepository.findAll();  
			for (Employe employe : employes) {
				l.debug("employe +++ : " + employe);
			} 
			l.info("Out of retrieveAllEmployes()  : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllEmployes() : " + e);
		}

		return employes;
	}

	@Override
	public Employe addEmploye(Employe e) {
		try {
		l.info("In addEmploye() : ");
			employeRepository.save(e); 
		l.info("out of addEmploye() : ");	}	
		
		catch(Exception d){
		
			l.error("Error in addEmploye() :  " + d);
		}
		return employeRepository.save(e);
	}

	@Override
	public void deleteEmploye(long id) {
		
		try {
			l.info("deleteEmploye() : ");
			employeRepository.deleteById(id);
			l.info("deleteEmploye() : ");	}	
			
			catch(Exception s){
			
				l.error("Error in deleteEmploye() :  " + s);
			}
			}

	@Override
	public Employe updateEmploye(Employe e) {
		try {
			l.info("updateEmploye() : ");
				employeRepository.save(e); 
			l.info("updateEmploye () : ");	}	
			
			catch(Exception m){
			
				l.error("Error in updateEmploye :  " + m);
			}
		
		
	return employeRepository.save(e);
	}

	@Override
	public Employe retrieveEmploye(long id) {
		l.info("in  retrieveUser id = " + id);
		Employe e =  employeRepository.findById(id).get(); 
		l.info("user returned : " + e);
		return e; 
		

}}
