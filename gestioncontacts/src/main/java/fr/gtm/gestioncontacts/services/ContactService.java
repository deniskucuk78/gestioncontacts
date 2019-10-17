package fr.gtm.gestioncontacts.services;

import java.util.List;

import javax.persistence.EntityManagerFactory;


import fr.gtm.gestioncontacts.dao.ContactDAO;
import fr.gtm.gestioncontacts.entities.Contact;

public class ContactService {
	
	private ContactDAO dao;
	
	public ContactService(EntityManagerFactory emf)
	{
		dao = new ContactDAO(emf);
	}
	
	public List<Contact> getContacts(){
		return dao.getContacts();
	}
	
	public void delete(Contact contact){
		dao.delete(contact);
	}
	
	
	public Contact getContactById(long id){
		return dao.getContactById(id);
	}
	
	public void create(Contact contact) {
		dao.create(contact);
	}
	

	
	
	

}
