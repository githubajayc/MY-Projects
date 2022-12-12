package com.contactProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contactProject.entity.Contact;
import com.contactProject.service.ContactService;

@RestController
public class ContactController {
	
	
	@Autowired
	private ContactService service;
	
/*---------------------------------------------------------------------------------------------------------*/	
	//Post Request >> to Save Data
	
	@PostMapping("/contact")
	public String saveContact(@RequestBody Contact contact) {
		
		String msg = service.saveContact(contact);
		return msg;
	}
	

/*---------------------------------------------------------------------------------------------------------*/
    //Get Mapping
         
	     @GetMapping("/contacts")
         public List<Contact> showAllContacts(){
        	 
        	 return service.showAllContacts();
        	 
         }
 
/*---------------------------------------------------------------------------------------------------------*/
  // Get By Id
	     
	     @GetMapping("/contacts/{contactId}")
	     public Contact getContactById(@PathVariable Integer contactId) {
	    	 
	    	 
	    	 return service.getContactById(contactId);
	     }
	     
/*---------------------------------------------------------------------------------------------------------*/
   //Put Mapping
	     
	     @PutMapping("/contact")
	     public String updateContact(@RequestBody Contact contact) {
	    	 
	    	 return service.updateContact(contact);
	     }
/*---------------------------------------------------------------------------------------------------------*/
   //Delete Mapping
	     
	     @DeleteMapping("/contact/{contactId}")
	     public String deleteContactById(@PathVariable Integer contactId) {
	    	 
	    	 return service.deleteContactById(contactId);
	    	 
	     }
}