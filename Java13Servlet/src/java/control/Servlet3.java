package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
public class Servlet3 extends HttpServlet {
    private Connection conn;
    private Statement statem;
    private PreparedStatement prepStatem;
    private ResultSet rs;
    private String query;
    private String user;
    private String pass;
    private String dburl;
    private String table;
    private String field;
    private String value;
    private Timestamp timestamp;
    
    // JDBC driver name and database URL
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    final String DB_URL = "jdbc:mysql://localhost:3306/nba";
    //final String SQL_QUERY = "SELECT * FROM equipos";
    final String SQL_QUERY = "SELECT * FROM jugadores WHERE Nombre_equipo=\"Bulls\"";
    
        public void leerDatos (){
        try {
            // Register JDBC driver and open a connection
            Class.forName(JDBC_DRIVER);
            //dburl = DB_URL;
            System.out.println("Constructor de Servlet3 " + dburl);
//            conn = DriverManager.getConnection(dburl, user, pass);
//            statem = conn.createStatement();
//            //query = "SELECT * FROM equipos";
//            rs = statem.executeQuery(query);
//            System.out.println("Query: " + query);
//            System.out.println("Result set: " + rs.toString());
            // Con prepared statement
            String prstquery = query + "?";
            System.out.println("Prep Query: " + query + value);
            prepStatem = conn.prepareStatement(prstquery);
            prepStatem.setString(1, value);
            rs = prepStatem.executeQuery();
            System.out.println("Result set: " + rs.toString());
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Class exception");
            cnfe.printStackTrace();
        }
        catch(SQLException se) {
            // Salta si el usuario/contraseña son incorrectos
            se.printStackTrace();
        } 
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);

        System.out.println("Request de Servlet3 " + request.getRequestURI());
        //query = SQL_QUERY;
        
        // Leer parámetros del input
        user = request.getParameter("user");
        pass = request.getParameter("password");
        //dburl = "jdbc:mysql://localhost:3306/nba";
        dburl = "jdbc:mysql://" + request.getParameter("ip") + ":3306/" +
                                            request.getParameter("dbname");
        table = request.getParameter("table");
        field = request.getParameter("field");
        value = request.getParameter("valor");
        //query = "SELECT * FROM " + table + " WHERE " + field + "=\"" + value + "\";";
        query = "SELECT * FROM " + table + " WHERE " + field + "="; //\"" + value + "\";";
        System.out.println("Usuario y contraseña: " + user + ", " + pass);
        System.out.println("DBurl, Tabla, campo, valor: " +  ", " + dburl +
                " , " + table + ", " + field + ", " + value);
        
        //leerDatos();
        
        // Set response
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet3</title>");  
        out.println("<link rel =\"stylesheet\" href=\"css/styles.css\">");
        out.println("<script src=\"js/myscript.js\"></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet3 DB Manager desde formulario</h1>");
        out.println("<p>Base de datos: " + dburl + "</br>");
        out.println("Sentencia SQL: " + query + value + "</br>");
        out.println("Timestamp: " + timestamp + "</br>");
        out.println("Usuario: " + user + ". Contraseña: " + pass + "</br>");
        out.println("Remote User: " + request.getRemoteUser() + 
                ". Remote Host: " + request.getRequestURI() + 
                ". Remote Host: " + request.getRemoteHost() + 
                ". Remote Address: " + request.getRemoteAddr() + "</br>");
        out.println("<p><img src=\"images/nbaicon.png\" width=\"80\" height=\"80\" alt=\"nba\">");
        
        // Probar conexión
        try {
            Class.forName(JDBC_DRIVER);
            //dburl = DB_URL;
            System.out.println("Constructor de Servlet3 " + dburl);
            conn = DriverManager.getConnection(dburl, user, pass);
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Class exception");
            cnfe.printStackTrace();
            logging(cnfe.toString());
            cleanup();
        }
        catch(SQLException se) {
            // Salta si el usuario,contraseña,ip,dbname son incorrectos 
            se.printStackTrace();
            out.println("<p>Hubo un problema al acceder a la base de datos: " + 
                    se.toString());
            out.println("<p>Introduzca valores correctos de usuario, contraseña, " +
                    " IP y nombre de base de datos <a href=\"\\Java13Servlet\">aquí<a>");
            out.println("</body>");
            out.println("</html>");
        } 
        
        // Leer datos de DB
        //leerDatos();
        try {
            String prstquery = query + "?";
            System.out.println("Prep Query: " + query + value);
            prepStatem = conn.prepareStatement(prstquery);
            prepStatem.setString(1, value);
            rs = prepStatem.executeQuery();
            System.out.println("Result set: " + rs.toString());
        }
        catch(SQLException se) {
            // Salta si la tabla no existe
            se.printStackTrace();
            out.println("<p>Hubo un problema al acceder a la base de datos: " + se.toString());
            out.println("<p>Introduzca valores correctos de tabla y campo " +
                    "<a href=\"\\Java13Servlet\">aquí<a>");
            out.println("</body>");
            out.println("</html>");
            logging(se.toString());
            cleanup();
        }
               
        // Escribir datos en tabla HTML
        try {

            out.println("<table id=\"data\">");
            
            System.out.println(rs.toString());
            int ncol = rs.getMetaData().getColumnCount(); // Nº de campos
            
            // Mostar nombres de campos
            String header = "<tr><td>";
            for (int k = 1; k < ncol+1; k++) {
                header += rs.getMetaData().getColumnName(k) + "</td><td>";
            }
            System.out.println(header);
            out.println(header.substring(0,header.length() - 4) + "</tr>");
            
            int i=0;
            // Leer mientras existan registros 
            while (rs.next()){                
                String line = "<tr><td>";
                for (int j = 1; j< ncol+1; j++) {
                    line += rs.getString(j) +  "</td><td>";
                }
                System.out.println(line);
                out.print(line.substring(0,line.length() - 4) + "</tr>");
                i++;
            }
            System.out.println("Nº de registros leidos: " + i);
            
            out.println("</table>");
            out.println("<p>Nº de registros leidos: " + i);
            out.println("<p><a href=\"\\Java13Servlet\">Back<a>");
            out.println("</body>");
            out.println("</html>");

            // Clean-up environment
            logging("OK");
            cleanup();
            }
            catch(SQLException se) {
                se.printStackTrace();
            } 
            catch(Exception e) {
                e.printStackTrace();
            }
        cleanup();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public void cleanup(){
        try {
            if(rs != null )rs.close();
            if(statem != null) statem.close();
            if(prepStatem != null) prepStatem.close();
            if(conn != null) conn.close();
        }
        catch(SQLException se) {
            se.printStackTrace();
        }       
    }
    
    public void logging(String mes) {
        String log = timestamp + " " + dburl + " " + user + " " + 
        pass + " " + table + " " + field + " " + value + " " + mes;
        System.out.println("Log de SQL: " + log);
        Logging logq = new Logging();
        logq.writeLine(log);
    }
}
