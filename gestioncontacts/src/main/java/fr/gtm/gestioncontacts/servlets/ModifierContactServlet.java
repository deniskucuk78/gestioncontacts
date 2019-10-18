package fr.gtm.gestioncontacts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.gestioncontacts.entities.Contact;
import fr.gtm.gestioncontacts.services.ContactService;

/**
 * Servlet implementation class ModifierContactServlet
 */
@WebServlet("/ModifierContactServlet")
public class ModifierContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContactService service =  (ContactService) getServletContext().getAttribute(Constantes.CONTACT_SERVICE);
		
		String idTemp = request.getParameter("id");
		Long id = Long.parseLong(idTemp);
		String page ="";
		
		
		if(id==null || id < 0) {
			page = "/ContactServlet";
		}
		else
		{
			Contact contact = service.getContactById(id);
			request.setAttribute("contact", contact);
			
			page = "/modifier-contact.jsp";
			
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
