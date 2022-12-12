package com.contactProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contactProject.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
	
	/*In this Interface we no need to write any methods. Data JPA will automatically provide 
	 * its implementation class using proxy design pattern
	 */

}
