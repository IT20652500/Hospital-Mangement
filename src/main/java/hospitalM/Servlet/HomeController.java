package hospitalM.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospitalM.Model.MedicineModel;
import hospitalM.Model.UserModel;
import hospitalM.Service.MedicineService;
import hospitalM.Service.MedicineServiceimpl;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MedicineService medicineService = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        medicineService = new MedicineServiceimpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
		switch (action) {
		case "EDIT":
			edit(request, response);
			break;
		case "DELETE":
			delete(request, response);
			break;
		case "ADD":
			home(request, response);
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
		case "ADD":
			addMedicine(request, response);
			break;
		case "HOME":
			home(request, response);

			break;
		case "UPDATE":
			update(request, response);
			break;
		default:
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}
	public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MedicineModel>list = medicineService.allMedi();
		System.out.println(list);
		request.setAttribute("medies", list);
		request.setAttribute("fb", true);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
	}
	public void addMedicine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MedicineModel medicine = new MedicineModel();

		medicine.setPrice(Float.parseFloat(request.getParameter("price")));
		medicine.setName(request.getParameter("medicalname"));
		medicine.setCategory(request.getParameter("category"));
		medicine.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		medicine.setCompany(request.getParameter("company"));
		medicine.setExpdate(request.getParameter("expDate"));
		medicine.setFabDate(request.getParameter("fabDate"));
		if(medicineService.addMedicine(medicine)) {
			List<MedicineModel>list = medicineService.allMedi();
			request.setAttribute("medies", list);
			request.setAttribute("message", "Medicine Added Successfully");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("error", "Medicine Failed To Add");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<MedicineModel>list = medicineService.allMedi();
		System.out.println(list);
		request.setAttribute("medies", list);	
		MedicineModel medi = medicineService.getSingleMedie(id);
		request.setAttribute("medi", medi);
		request.setAttribute("fb", false);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id is came here like "+id);
		if(medicineService.deleteMedi(id)) {
			request.setAttribute("message", "Medicine Deleted Successfully");
			List<MedicineModel>list = medicineService.allMedi();
			request.setAttribute("medies", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("error", "Medicine Failed To Delete");
			home(request, response);
		}
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MedicineModel medicine = new MedicineModel();
		medicine.setPrice(Float.parseFloat(request.getParameter("price")));
		medicine.setName(request.getParameter("medicalname"));
		medicine.setCategory(request.getParameter("category"));
		medicine.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		medicine.setCompany(request.getParameter("company"));
		medicine.setExpdate(request.getParameter("expDate"));
		medicine.setFabDate(request.getParameter("fabDate"));
		medicine.setId(Integer.parseInt(request.getParameter("id")));
		System.out.println("came to update function");
		if(medicineService.updateMedi(medicine)) {
			request.setAttribute("message", "Medicine Updated Successfully");
			home(request, response);
		}else {
			request.setAttribute("error", "Medicine failed to Update");
			home(request, response);
		}
	}
}
