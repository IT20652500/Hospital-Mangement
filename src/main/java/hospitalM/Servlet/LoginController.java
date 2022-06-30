package hospitalM.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospitalM.Model.UserModel ;
import hospitalM.Service.LoginService;
import hospitalM.Service.LoginServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService= null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        loginService = new LoginServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
					String action = request.getParameter("action");
				
				switch (action) {
				case "LOGIN":
					response.sendRedirect("login.jsp");	
					break;
				
				default:
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
					break;
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action) {
		case "CHECK":
			validate(request, response);
			break;
		
		default:
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}
	public void validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String type = request.getParameter("userType");
		UserModel user = new UserModel();
		
		user.setEmail(email);
		user.setPassword(password);

		if(loginService.validateUser(user)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("HomeController?action=HOME");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("message", "Invalid user name or password! Please try again");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
