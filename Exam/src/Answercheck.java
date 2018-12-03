

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Answercheck
 */
@WebServlet("/Answercheck")
public class Answercheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Answercheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String answer1 = request.getParameter("q1");
		String answer2 = request.getParameter("q2");
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url    = "jdbc:mysql://localhost:3306/exam";
			String user = "root";
			String password ="123456";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement st = con.prepareStatement("select * from exam.answers");
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				if((answer1.equals(rs.getString(1)))&&(answer2.equals(rs.getString(2))))
				{
					count = 2;
					response.sendRedirect("Result1.html");
				}
				else if ((answer1.equals(rs.getString(1)))||(answer2.equals(rs.getString(2))))
				{
					count = 1;
					response.sendRedirect("Result2.html");
				}
				else
				{
					count = 0;
					response.sendRedirect("Result3.html");
				}
			}
			
			
		}
			
			catch(Exception e)
			{
				System.out.println(e);
			}
	
		
		
		
	}

}
