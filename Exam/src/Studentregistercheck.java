

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Studentregistercheck
 */
@WebServlet("/Studentregistercheck")
public class Studentregistercheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Studentregistercheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("t2");
		String pword = request.getParameter("p2");
		String address = request.getParameter("a2");
		String city = request.getParameter("c2");
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url    = "jdbc:mysql://localhost:3306/exam";
			String user = "root";
			String password ="123456";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			String sql = "insert into exam.students(username,password,address,city) values ('"+uname+"','"+pword+"','"+address+"','"+city+"');";
			st.executeUpdate(sql);
			}
		catch(Exception e)
			{
				System.out.println(e);
			}
		response.sendRedirect("error.html");
	}

}
