package com.contactProject.service;

import java.util.List;

import com.contactProject.entity.Contact;


public interface ContactService {
	
	//In this Interface we will just declare methods and will do its implementation in implementation class
	
	
	public String saveContact(Contact contact);
	
	public List<Contact> showAllContacts();
	
	public Contact getContactById(Integer contactId);
	
	public String updateContact(Contact contact);
	
	public String deleteContactById(Integer contactId);
	
	

}
