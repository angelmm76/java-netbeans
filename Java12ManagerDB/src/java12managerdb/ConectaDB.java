package java12managerdb;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ConectaDB {
    private String dbname;
    Connection conn, conn2;
    Statement statem;
    PreparedStatement prepStatem, prepStatem2;
    CallableStatement callStatem;
    ResultSet rs, rsjug;
    //ArrayList<Player> arplayers;
    private Document doc;  // DOM Document W3C
    private Element root;
    private Transformer trans;
    private File xmlFile;
    private DocumentBuilderFactory dbf;
    private DocumentBuilder builder;
    
    // Constructor
    public ConectaDB(String dbna, String IP, String usuario, String pass){
        this.dbname = dbna;
        // Abrir conexión mysql de una base de datos con user y password
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    //"jdbc:mysql://localhost:3306/" + dbname, usuario, pass);
                    "jdbc:mysql://" + IP + ":3306/" + dbname, usuario, pass);
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Class exception");
            cnfe.printStackTrace();
        }
        catch(SQLException sqle){
            System.out.println("Closing exception");
            sqle.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
                       
    }
    
    public void lee(String tablename){
        // Crear statement con su query
        String sqlquery = "SELECT * FROM " + tablename;
//        String prstquery = "SELECT * FROM " + tablename + 
//                " WHERE Nombre_equipo=?";
        String prstquery = "SELECT * FROM " + tablename + 
            " WHERE Puntos_por_partido >= ? AND Rebotes_por_partido >= ?";
        try {
            // Con prepared statement
//            prepStatem = conn.prepareStatement(prstquery);
//            //prepStatement.setString(1, "Magic");
//            prepStatem.setInt(1, 20);
//            prepStatem.setInt(2, 10);
//            rs = prepStatem.executeQuery();
            // Con statement
            statem = conn.createStatement();
            rs = statem.executeQuery(sqlquery);
            //rs = statem.getResultSet(); // Resultado de la consulta        
        } 
        catch (SQLException ex) {
            System.out.println("Statement exception");
            ex.printStackTrace();
        }
        // Leer los registros del result set
        listarResultSet(rs);
           
    }
    
    public void teamToXML(String tablename, String team){
        // Crear XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            // Construir documento DOM
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.newDocument();
            root = doc.createElement(team);
            doc.appendChild(root);
        } 
        catch (ParserConfigurationException e){
            System.out.println("Excepcion: " + e.toString());
        }
        catch(Exception e){
            System.out.println("Excepcion: " + e.toString());
            e.printStackTrace();
        }
        //arplayers = new ArrayList<Player>();
        
        // Crear statement con su query
        String sqlquery = "SELECT * FROM " + tablename + " WHERE Nombre_equipo='" 
                + team + "';";
        System.out.println(sqlquery);
        try {
            statem = conn.createStatement();
            rs = statem.executeQuery(sqlquery);
            // Resultado de la consulta
            rs = statem.getResultSet();       

        } catch (SQLException ex) {
            System.out.println("Statement exception");
            ex.printStackTrace();
        }
        // Leer los registros del result set
        int i = 0;
        
        try {   
            System.out.println(rs.toString());
            int ncol = rs.getMetaData().getColumnCount(); // Nº de campos
            while (rs.next()){ // Leer mientras existan registros 
                i++;
                String cod = rs.getString("codigo");
                String nomb = rs.getString("Nombre");
                String proc = rs.getString("Procedencia");
                String altu = rs.getString("Altura");
                String peso = rs.getString("Peso");
                String pos = rs.getString("Posicion");
                String equi= rs.getString("Nombre_equipo");
                System.out.println(cod + ": " + nomb + ", " + proc + ", " +
                    altu + ", " + peso + ", " + pos + ", " + equi);
                
                // Nuevo hijo (jugador)
                Element jugador = doc.createElement("player");
                jugador.setAttribute("codigo", cod);  // Atributo del hijo
                root.appendChild(jugador); // Agregar jugador al root

                // Hijos de jugador
                Element nombre = doc.createElement("nombre");  // Nombre
                nombre.appendChild(doc.createTextNode(nomb));
                jugador.appendChild(nombre);

                Element proce = doc.createElement("procedencia");  // Procedencia
                proce.appendChild(doc.createTextNode(proc));
                jugador.appendChild(proce);

                Element altura = doc.createElement("altura");  // Altura
                altura.appendChild(doc.createTextNode(altu));
                jugador.appendChild(altura);

                Element pesop = doc.createElement("peso");  // Peso
                pesop.appendChild(doc.createTextNode(peso));
                jugador.appendChild(pesop);

                Element posic = doc.createElement("posición");  // Posición
                posic.appendChild(doc.createTextNode(pos));
                jugador.appendChild(posic);

                Element equipo = doc.createElement("equipo");  // Equipo
                equipo.appendChild(doc.createTextNode(equi));
                jugador.appendChild(equipo);
            
            }
            statem.close();

        } 
        catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        System.out.println("Jugadores leidos de " + team + ": " + i);
        
        save("Players_" + team);
        
    }
    
    public void save(String filename){
        // Guardar archivo XML
        TransformerFactory factoXML = TransformerFactory.newInstance();
        try {
            trans = factoXML.newTransformer();        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        String ruta = "C:\\Users\\Alumno.ALUMNO20\\Documents\\" + filename +
                ".xml";
        // Objeto fuente DOM que se transformará en un fichero
        Source source = new DOMSource(doc);

        try {
            File file = new File(ruta);
            Result result = new StreamResult(file);
            // Transforma la fuente (XML DOM) en resultado (file)
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.transform(source, result);
            System.out.println("Archivo XML guardado en " + ruta);
        }
        catch(Exception e){
            e.printStackTrace();
        } 
    }
               
    public void insertTeclado(String tablename){
        // Crear statement con su query
        //sqlquery = "SELECT * FROM " + tablename;
        String sqlupdate = "INSERT INTO " + tablename + " VALUES ("; 
        // "INSERT INTO jugadores VALUES (999,'Pepe Garcia'," + 
            //"'Soria Tech','9-9',266,'G','Clippers')";
        Scanner leer = new Scanner(System.in);
        System.out.println("Introducir codigo (nº): ");
        String cod = leer.next();
        System.out.println("Introducir nombre: ");
        String nomb = leer.next();
        System.out.println("Introducir procedencia: ");
        String proc = leer.next();
        System.out.println("Introducir altura: ");
        String altur = leer.next();
        System.out.println("Introducir peso (nº): ");
        String peso = leer.next();
        System.out.println("Introducir posicion: ");
        String pos = leer.next();
        System.out.println("Introducir equipo: ");
        String equip = leer.next();
        sqlupdate = sqlupdate + cod + ",\"" + nomb + "\",\"" + proc + "\",\"" + 
                altur + "\"," + peso + ",\"" + pos + "\",\"" + equip + "\")";
        
//        sqlupdate = "INSERT INTO jugadores VALUES (99999,'Pepe Garcia'," + 
//            "'Soria Tech','9-9',266,'G','Clippers')";
        
        System.out.println("Sentencia update: " + sqlupdate);
        
        try {
            statem = conn.createStatement();
            int up = statem.executeUpdate(sqlupdate);  
            statem.close();
        } 
        catch (SQLException ex) {
            System.out.println("Statement exception");
            ex.printStackTrace();
        }
        System.out.println("Registros añadidos: " + sqlupdate);
        
    }
    
    public void getFromXML(String tablename, String filename) {
        // Builder
        try {
            dbf = DocumentBuilderFactory.newInstance();
            builder = dbf.newDocumentBuilder();
        }
        catch(Exception e){
            e.printStackTrace();
        }
         //Leer XML y mostrar datos en consola
        String ruta = "C:\\Users\\Alumno.ALUMNO20\\Documents\\" + 
            filename + ".xml";
        try {
            statem = conn.createStatement();
            
            xmlFile = new File(ruta);
            doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("\nRaiz del xml: " + 
                doc.getDocumentElement().getNodeName());
            // Lista de hijos con etiqueta book
            NodeList nList = doc.getElementsByTagName("book");
            System.out.println("Nº de books: " + nList.getLength());
            
            // Bucle sobre books
            for (int i = 0; i < nList.getLength(); i++){
                Node nNode = nList.item(i);
                //System.out.print(nNode.getNodeName());
                if(nNode.getNodeType() == Node.ELEMENT_NODE){
                    String query = "INSERT INTO books VALUES (";
                    Element eElement = (Element) nNode;
                    // Código del book
                    String id = eElement.getAttribute("id").substring(2, 5);
                    query += id + ",\"";
                    // Autor
                    String author = eElement.getElementsByTagName("author").
                            item(0).getTextContent();
                    query += author + "\",\""; 
                    // Title
                    String title = eElement.getElementsByTagName("title").
                            item(0).getTextContent();
                    query += title + "\",\""; 
                    // Genre
                    String genre = eElement.getElementsByTagName("genre").
                            item(0).getTextContent();
                    query += genre + "\","; 
                    // Price
                    String price = eElement.getElementsByTagName("price").
                                item(0).getTextContent();
                    query += price + ",\"";
                    // Pub date
                    String pubdate = eElement.getElementsByTagName("publish_date").
                            item(0).getTextContent();  
                    query += pubdate + "\",\"";
                    // Description
                    String descrip = eElement.getElementsByTagName("description")
                            .item(0).getTextContent().replaceAll("      ", "");
                    query += descrip + "\");";
                    
//                    System.out.println("\tId: " + id + "\tAuthor: " + author + "\tTitle: " + 
//                        title + "\tGenre: " + genre + "\tPrice: " + price + 
//                        "\tPublication Date: " + pubdate + "\tDescription: " +  descrip);
                    
                    System.out.println(query);
                    statem.addBatch(query);
                                       
                }
            }
            System.out.println("Datos leidos de archivo XML: " + ruta);
            statem.executeBatch();
            statem.close();
            System.out.println("Registros insertados en tabla: " + tablename);
            
        }
        catch (SQLException ex) {
            System.out.println("Statement exception");
            ex.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }    
        
    public void borraPlayer(String tablename, String code){
        // Crear statement con su query
        String sqldelete = "DELETE FROM " + tablename + " WHERE codigo=" + code;
        //sqldelete = "DELETE FROM ? WHERE codigo = ?";
       
        try {
            prepStatem = conn.prepareStatement(sqldelete);
            //preparedStatement.setString(1, tablename);
            //preparedStatement.setString(2, code);
            prepStatem.executeUpdate();        

        } catch (SQLException ex) {
            System.out.println("Statement exception");
            ex.printStackTrace();
        }
        System.out.println("Registro borrado: " + sqldelete);        
    }
    
    public void updateAtributo(String tablename, String code, String field, 
                                     String newvalue){
        // Crear statement con su query
        String sqlupdate = "UPDATE " + tablename + " SET " + field + " =\"" + 
            newvalue + "\" WHERE codigo=\"" + code + "\";";
       
        try {
            statem = conn.createStatement();
            int up = statem.executeUpdate(sqlupdate);  
            statem.close();

        } 
        catch (SQLException ex) {
            System.out.println("Statement exception");
            ex.printStackTrace();
        }
        System.out.println("Registros modificado: " + sqlupdate);
        
    }
    
    public float ptosPromedioJugador(int code){
        String prstquery = "SELECT Puntos_por_partido FROM estadisticas " + 
                "WHERE jugador= ?";
        float promedio = 0f;
        try {
            prepStatem = conn.prepareStatement(prstquery);
            prepStatem.setInt(1, code);
            rsjug = prepStatem.executeQuery();
            // Bucle sobre registros del jugador
            int i = 0;
            float total = 0f;
            while (rsjug.next()){              
                total += Float.parseFloat(rsjug.getString(1));
                i++;  
            }
            // Calcular promedio, pero si no hay valores devolver 0f
            promedio = (i==0) ? 0f : total / i;
            //System.out.println(promedio);           
        } 
        catch (SQLException ex) {
            System.out.println("Statement exception");
            ex.printStackTrace();
        } 
        return promedio;
    }
    
    public void listaJugadores(){
        String query = "SELECT codigo FROM jugadores";
        String upsql = "UPDATE jugadores SET puntos_promedio=? WHERE codigo=?";
        try {
            prepStatem = conn.prepareStatement(query);
            prepStatem2 = conn.prepareStatement(upsql);
            rs = prepStatem.executeQuery();
            // Leer mientras existan registros 
            int i = 0;
            while (rs.next()){    
                // Leer codigo de jugador
                int cod = Integer.parseInt(rs.getString(1));
                // Obtener promedio de puntos
                float ptmedia = ptosPromedioJugador(cod);
                System.out.println(cod + "\t" + ptmedia);
                // Escribir el valor en la tabla jugadores
                prepStatem2.setInt(2, cod);
                prepStatem2.setFloat(1, ptmedia);
                prepStatem2.executeUpdate();
                // Contador
                i++;
            }
            System.out.println("Nº jugadores en lista: " + i);
        } 
        catch (SQLException ex) {
            System.out.println("Statement exception");
            ex.printStackTrace();
        }
    }
    
    public void insertRemote(String nombre) {
        // Leer datos de mi db
        String sqlquery = "SELECT * FROM equipos";
        try {
            statem = conn.createStatement();
            rs = statem.executeQuery(sqlquery);
        } 
        catch (SQLException ex) {
            System.out.println("Statement exception");
            ex.printStackTrace();
        }
        
        // Conectar a db remota
        System.out.println("Conectando a base remota...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn2 = DriverManager.getConnection("jdbc:mysql://192.168.1.34:3306/nba",
                "profe","hazerta");
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Class exception");
            cnfe.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        // Insertar valores en db remota
        String prstquery = "INSERT INTO equipos VALUES (?,?,?,?,?)";
        System.out.println("Insertando en remoto: " + rs.toString());
        try {
            int i = 0;
            while (rs.next()){    
                prepStatem = conn2.prepareStatement(prstquery);
                prepStatem.setString(1, "6 " + rs.getString(1));
                prepStatem.setString(2, rs.getString(2));
                prepStatem.setString(3, rs.getString(3));
                prepStatem.setString(4, rs.getString(4));
                prepStatem.setString(5, nombre);
                prepStatem.executeUpdate();
                // Contador
                i++;
            }
            System.out.println("Nº registros insertados remotamente: " + i);
            conn2.close();
        } catch (SQLException ex) {
            System.out.println("Statement exception");
            ex.printStackTrace();
        }             
    }
    
    public void callProced (String proc, String params[]) {
        System.out.println("Llamada a procedimiento " + proc + " de " + 
                dbname);
        String query;
        try {
            // Crear statement distintas para cada proc
            switch (proc) {
                case "JugadoresEquipo":
                    query = "{ call "+ proc + "(?) }";
                    callStatem = conn.prepareCall(query);
                    callStatem.setString(1, params[0]);
                    break;
                case "TripleDoble":
                    query = "{ call "+ proc + "(?,?,?) }";
                    callStatem = conn.prepareCall(query);
                    callStatem.setInt(1, Integer.parseInt(params[0]));
                    callStatem.setInt(2, Integer.parseInt(params[1]));
                    callStatem.setInt(3, Integer.parseInt(params[2]));
                    break;
                case "Alturas":
                    query = "{ call "+ proc + "(?) }";
                    callStatem = conn.prepareCall(query);
                    callStatem.setString(1, params[0]);
                    break;
                case "DatosJugadores":
                    //query = "{ call "+ proc + "(?) }";
                    query = "{ call "+ proc + "() }";
                    callStatem = conn.prepareCall(query);
                    //callStatem.setString(1, params[0]);
                    break;
            }
            // Ejecutar query
            rs = callStatem.executeQuery();
            
        } 
        catch (SQLException ex) {
            System.out.println("Statement exception");
            ex.printStackTrace();
        }
        listarResultSet(rs); 

    }
    
    public void listarResultSet (ResultSet rset) {
        // Leer los registros del result set
        int i = 0;  // contador
        try {   
            System.out.println(rset.toString());
            int ncol = rset.getMetaData().getColumnCount(); // Nº de campos
            
            // Mostar nombres de campos
            String nomcamp = "";
            for (int k = 1; k< ncol+1; k++) {
                nomcamp += rset.getMetaData().getColumnName(k) + ", ";
            }
            System.out.println(nomcamp.substring(0,nomcamp.length() - 2));
            
            // Leer mientras existan registros 
            while (rset.next()){ 
//                System.out.println(rs.getString("actor_id") + ": " + 
//                        rs.getString("first_name") + ", " + 
//                        rs.getString("last_name") + ", " +
//                        rs.getString("last_update"));               
                String reg = "";
                for (int j = 1; j< ncol+1; j++) {
                    reg += rset.getString(j) + ", ";
                }
                System.out.println(reg.substring(0,reg.length() - 2));
                i++;
            }
            //System.out.println(rset.getMetaData().getColumnName(2));
        } 
        catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        System.out.println("Registros leidos de " + dbname + ": " + i);
    }
    
    public void close(){
        // Cerrar conexión
        try{
           conn.close();
           if (statem != null) statem.close();
           if (rs != null) rs.close();
           if (rsjug != null) rsjug.close();
           if (prepStatem != null) prepStatem.close();
           if (prepStatem2 != null) prepStatem2.close();
        }
        catch (SQLException sqle) {
            System.out.println("Closing error");
            sqle.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
