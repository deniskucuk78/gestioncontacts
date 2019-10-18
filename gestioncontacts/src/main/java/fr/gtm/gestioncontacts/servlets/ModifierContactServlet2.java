package fr.gtm.gestioncontacts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.gestioncontacts.entities.Civilite;
import fr.gtm.gestioncontacts.entities.Contact;
import fr.gtm.gestioncontacts.services.ContactService;

/**
 * Servlet implementation class ModifierContactServlet2
 */
@WebServlet("/ModifierContactServlet2")
public class ModifierContactServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierContactServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ContactService service = (ContactService) getServletContext().getAttribute(Constantes.CONTACT_SERVICE);
		
		String civilite = request.getParameter("civilite");
		String idTemp = request.getParameter("id");
		Long id = Long.parseLong(idTemp);
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String page = "";
		
		
		if(civilite==null || civilite.isEmpty() || nom==null || nom.isEmpty() || prenom==null || prenom.isEmpty()  ) {
			page = "/modifier-contact.jsp";
		}
		else
		{
			Contact contact = service.getContactById(id);
			contact.setCivilite(Civilite.valueOf(civilite));
			contact.setNom(nom);
			contact.setPrenom(prenom);
			service.update(contact);
			page = "/ContactServlet";
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		
		rd.forward(request, response);
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
