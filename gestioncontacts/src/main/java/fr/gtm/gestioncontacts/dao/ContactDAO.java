package fr.gtm.gestioncontacts.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import fr.gtm.gestioncontacts.entities.Civilite;
import fr.gtm.gestioncontacts.entities.Contact;

public class ContactDAO {
	private EntityManagerFactory emf;

	public ContactDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void create(Contact contact) {
		// 1 - récupèrer un EntityManager (connexion)
		EntityManager em = emf.createEntityManager();
		// 2 - démarrer une transaction
		em.getTransaction().begin();
		// 3 - sauvegarder l'entité en base
		em.persist(contact);
		// 4 - valider la transaction
		em.getTransaction().commit();
		// 5 - fermer l'Entitymanager (connexion)
		em.close();
	}
	
	public Contact getContactById(long id) {
		EntityManager em = emf.createEntityManager();
		Contact contact = em.find(Contact.class, id);
		em.close();
		return contact;
	}
	
	public void delete(Contact contact) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// on réattache l'entité avant de la supprimer
		Contact c1 = em.find(Contact.class, contact.getId());
		em.remove(c1);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Contact contact) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(contact);
		em.getTransaction().commit();
		em.close();
	}

	public List<Contact> getContactsWithAddresses(){
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createNamedQuery("Contact.getWithAddress", Contact.class)
										.getResultList();
		em.close();
		return contacts;
	}
	
	public List<Contact> getContactsByCivilite(Civilite civilite){
		String sql = "SELECT c FROM Contact c WHERE c.civilite= :foo";
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createQuery(sql, Contact.class)
										.setParameter("foo", civilite)
										.getResultList();
		em.close();
		return contacts;
	}
	
	
	
	public List<Contact> getContactsByNom(String nom){
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createNamedQuery("Contact.getByNom", Contact.class)
										.setParameter("nom", nom+"%")
										.getResultList();
		em.close();
		return contacts;
	}
	
	
	public List<Contact> getContacts(){
		EntityManager em = emf.createEntityManager();
		List<Contact> contacts = em.createNamedQuery("Contact.getContacts", Contact.class).getResultList();
		em.close();
		return contacts;
	}
	
}
