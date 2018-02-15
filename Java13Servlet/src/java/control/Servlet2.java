package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
    private Connection conn;
    private Statement statem;
    private ResultSet rs;
    private String query;
    
    // JDBC driver name and database URL
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    final String DB_URL = "jdbc:mysql://localhost:3306/nba";
    //final String SQL_QUERY = "SELECT * FROM equipos";
    final String SQL_QUERY = "SELECT * FROM jugadores WHERE Nombre_equipo=\"Bulls\"";
    //final String SQL_QUERY = "SELECT * FROM jugadores WHERE Posicion=\"C\"";
    //final String SQL_QUERY = "SELECT * FROM estadisticas WHERE Puntos_por_partido>=10 AND Asistencias_por_partido>=5 AND Rebotes_por_Partido>=10";
    //  Database credentials
    final String USER = "root";
    final String PASS = "hazerta";
    
    
    public void leerDatos (String query){
        try {
            // Register JDBC driver and open a connection
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Constructor de Servlet2 " + JDBC_DRIVER);
            statem = conn.createStatement();
            //query = "SELECT * FROM " + tname;
            rs = statem.executeQuery(query);
            System.out.println("Query: " + query);
            System.out.println("Result set: " + rs.toString());
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Class exception");
            cnfe.printStackTrace();
        }
        catch(SQLException se) {
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
        System.out.println("Request de Servlet2 " + request.getRequestURI());
        leerDatos(SQL_QUERY);
        
        try {
            // Set response
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet2</title>");  
            out.println("<link rel =\"stylesheet\" href=\"css/styles.css\">");
            out.println("<script src=\"js/myscript.js\"></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet2 DB Manager </h1>");
            out.println("<p>Base de datos: " + DB_URL + "</p>");
            out.println("<p>Sentencia SQL: " + SQL_QUERY + "</p>");
            out.println("<p><img src=\"images/nbaicon.png\" width=\"80\" height=\"80\" alt=\"nba\">");

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
//            rs.close();
//            statem.close();
//            conn.close();
            }
            catch(SQLException se) {
                se.printStackTrace();
            } 
            catch(Exception e) {
                e.printStackTrace();
            }
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

}
