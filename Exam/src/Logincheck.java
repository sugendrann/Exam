
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



//import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * Servlet implementation class Logincheck
 */
@WebServlet("/Logincheck")
public class Logincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Logincheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	String uname = request.getParameter("t1");
		//String pword = request.getParameter("p1");
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url    = "jdbc:mysql://localhost:3306/exam";
			String user = "root";
			String password ="123456";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement st = con.prepareStatement("select * from exam.students");
			ResultSet rs = st.executeQuery();
			//ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			//int n = rsmd.getColumnCount();
			//for(int i=1;i<=n;i++)
			//{
			while(rs.next())
				
			{
				String uname = request.getParameter("t1");
				String pword = request.getParameter("p1");
				
				if((uname.equals(rs.getString(1)))&&(pword.equals(rs.getString(2))))
				{
					response.sendRedirect("starttest.html");
				}
			}
			response.sendRedirect("error.html");
			//}
			
			
		}
			
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		}
	}
