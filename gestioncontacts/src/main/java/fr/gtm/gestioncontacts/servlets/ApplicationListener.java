package fr.gtm.gestioncontacts.servlets;

import java.util.logging.Logger;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.gtm.gestioncontacts.services.ContactService;
import fr.gtm.gestioncontacts.servlets.Constantes;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

	private static final Logger LOG = Logger.getLogger("contacts");
	


	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	LOG.info(">>> appli démarrée");
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contacts");
    	LOG.info(">>> EMF " + emf);
    	ServletContext application = sce.getServletContext();
    	application.setAttribute(Constantes.EMF, emf);
    	
    	
    	//ON met le service dans le context applicatif :
    	
    	ContactService service = new ContactService(emf);
    	LOG.info(">>> Service " + service);
    	application.setAttribute(Constantes.CONTACT_SERVICE, service);
    	
    	

    }
    
    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	LOG.info(">>> appli retirée");
    	EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute(Constantes.EMF);
    	emf.close();
    	LOG.info(">>> EMF closed");
    	LOG.info(">>> appli retirée");
    	
    }	
}
