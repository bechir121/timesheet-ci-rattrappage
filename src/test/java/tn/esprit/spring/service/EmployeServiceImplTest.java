package tn.esprit.spring.service;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;

import tn.esprit.spring.services.IEmployeService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {

		@Autowired
		IEmployeService es; 
	
		@Test
		public void testRetrieveAllEmployee() {
			List<Employe> listEmployes = es.RetrieveAllEmployee(); 
			// if there are 7 users in DB : 
			Assert.assertEquals(15, listEmployes.size());
		}
		
		
		@Test
		public void addEmploye()  {
			
			Employe e = new Employe(2,"werteni", "werteni"); 
			Employe employeAdded = es.addEmploye(e);
			Assert.assertEquals(employeAdded.getPrenom(), employeAdded.getPrenom());
		}
	 
		@Test
		public void updateEmploye() {
			
			Employe e ;
			e = new Employe(1, "marianes", "marine1"); 
			Employe employeUpdated  = es.updateEmploye(e); 
			Assert.assertEquals(e.getId(), employeUpdated.getId());
		}
	
		@Test
		public void testRetrieveUser() {
			Employe employeeRetrieved = es.retrieveEmploye(1); 
			Assert.assertEquals(1L, employeeRetrieved.getId());
		}
		
		@Test
		public void testDeleteUser() {
			es.deleteEmploye(1);
			Assert.assertNull(es.retrieveEmploye(1));
		}
		

	
	
	
}
