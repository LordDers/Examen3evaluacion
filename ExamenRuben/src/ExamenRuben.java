import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExamenRuben
 */
public class ExamenRuben extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static final String DB_URL = "jdbc:mysql://localhost/";
	static final String USER = "root";
	static final String PASS = "zubiri";
	static String database = "examen";
	static final String URL_BD="jdbc:mysql://localhost/"+database;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamenRuben() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType( "text/html; charset=iso-8859-1" );
		
		
		Connection con = null;	
		Statement sentencia = null;
		
		// 2 - Conexión BD
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(DB_URL,USER,PASS);
			sentencia = con.createStatement();
			
		} catch(Exception e) {
			System.err.println("No se ha podido conectar con la base de datos, compruebe las credenciales");
		}
		
		// 3 - Creación BD
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(DB_URL,USER,PASS);
			sentencia = con.createStatement();	
			
			String sqlCreate = "CREATE DATABASE IF NOT EXISTS "+ database;
			sentencia.executeUpdate(sqlCreate);
			
		} catch(Exception e) {
			System.err.println("No se ha podido crear la base de datos, compruebe la síntaxis SQL");
		}
		
		// 3 - Creación tabla
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(URL_BD,USER,PASS);
			sentencia = con.createStatement();
			
			String sqlTable = "CREATE TABLE IF NOT EXISTS matriculaciones "+
					"(dni VARCHAR(9) NOT NULL, "+
					"nombre VARCHAR(20), "+
					"apellido VARCHAR(20), "+
					"anyo_nacimiento INTEGER(4), "+
					"PRIMARY KEY(dni))";
			sentencia.executeUpdate(sqlTable);
			
		} catch(Exception e) {
			System.err.println("No se ha podido crear la tabla, compruebe la síntaxis SQL");
		}
		
		// 4 - Insertar contenido en tabla
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(URL_BD,USER,PASS);
			sentencia = con.createStatement();
			
			String dni = request.getParameter("dni");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			int anyo = Integer.parseInt(request.getParameter("ano"));

			/*System.out.println("DNI: " + request.getParameter("dni"));
			System.out.println("Nombre: " + request.getParameter("nombre"));
			System.out.println("Apellido: " + request.getParameter("apellido"));
			System.out.println("Año de nacimiento: " + request.getParameter("ano"));*/
			
			// 1 - Mostrar datos introducidos por HTML
			response(response, dni, nombre, apellido, anyo);
			
			String sqlInsert;
			sqlInsert = "INSERT INTO matriculaciones VALUES (\""+
					dni+"\",\""+
					nombre+"\",\""+
					apellido+"\","+ 
					anyo+")";
			
			//System.out.println(sqlInsert);
			sentencia.executeUpdate(sqlInsert);
			
		} catch(Exception e) {
			System.err.println("No se ha podido insertar, compruebe la síntaxis SQL");
		}
	}
	
	private void response(HttpServletResponse response, String dni, String nombre, String apellido, int anyo) throws IOException {
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		
		// 1 - Mostrar datos introducidos por HTML
		out.println("<html>");
		out.println("<head>");
			out.println("<title> Mostrar response </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table align=\"center\" border=5>");
			out.println("<tr>");
				out.println("<th> DNI </th>");
				out.println("<th> Nombre </th>");
				out.println("<th> Apellido </th>");
				out.println("<th> Año de Nacimiento </th>");
			out.println("</tr>");
			out.println("<tr>");
				out.println("<td>" + dni + "</td>");
				out.println("<td>" + nombre + "</td>");
				out.println("<td>" + apellido + "</td>");		
				out.println("<td>" + anyo + "</td>");
			out.println("</tr>");
			out.println("<tr>");
				out.println("<td colspan=5>");
					out.println("<center> <a href='index.html'> <button> Volver </button> </a> </center>");
				out.println("</td>");
				out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
