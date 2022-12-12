package com.contactProject.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactProject.entity.Contact;
import com.contactProject.repository.ContactRepository;


@Service
public class ContactServiceImpl implements ContactService {
	
	
	@Autowired                           //for Dependency Injection
	private ContactRepository repo;    //object of this will provide methods to perform databse operations

	
/*--------------------------------------------------------------------------------------------------*/	
	                 //Save Operation
	
	@Override
	public String saveContact(Contact contact) {
		
		contact = repo.save(contact);   //method returns saved entity
		
		if(contact.getContactId() != null) {
			
			return "Contact Saved Successfully";
			
		}else {
			
			return "Failed To Save Contact";
			
		}
	}

/*--------------------------------------------------------------------------------------------------*/	
	                //Get All Data
	
	@Override
	public List<Contact> showAllContacts() {
		
		return repo.findAll();          //This Method return list of entity/objects
		
	}

/*--------------------------------------------------------------------------------------------------*/
	              //Edit Data >> getData + updateData
	
	@Override
	public Contact getContactById(Integer contactId) {
		
		Optional<Contact> fbi =repo.findById(contactId);
		
		if(fbi.isPresent()) {
			return fbi.get();
		}
			return null;
		
	}


	           //Update Data
	
	@Override
	public String updateContact(Contact contact) {
		
		if(repo.existsById(contact.getContactId())) {
			
			repo.save(contact);
			return "Contact Updated Successfully";
		}else {
			return "Contact Not Found";
		}
		
	}

/*--------------------------------------------------------------------------------------------------*/
	          //Delete Data
	
	@Override
	public String deleteContactById(Integer contactId) {
		if(repo.existsById(contactId)){
			repo.deleteById(contactId);
			return "Contact Deleted Successfully";
		}else {
			return "Contact Not Found";
		}
	}

}
