package java12managerdb;

public class Java12ManagerDB {

    public static void main(String[] args) {
        String dbname = "nba";
        String usuario = "myadmin";      
        String IP = "localhost";
        String pass = "hazerta";
        System.out.println("Accediendo a base de datos " + dbname + 
                "(MySQL)...");
        
        // Conectar a DB
        ConectaDB conec = new ConectaDB(dbname, IP, usuario, pass);
        
        // Pasar datos a base remota
        //conec.insertRemote("Angel");
        
        // Leer tabla
        conec.lee("jugadores");
        //conec.lee("estadisticas");
        
        // Insertar fila en tabla
        //conec.insertTeclado("jugadores");
        
        // Borrar jugador
        //conec.borraPlayer("jugadores","7777");
        //conec.updateAtributo("jugadores", "108", "Procedencia", "Sao Paulo");
        
        // Equipo a XML
        //conec.teamToXML("jugadores", "Knicks");
        
        // Leer de XML
        //conec.lee("books");
        //conec.getFromXML("books", "dbooks_catalog");
        
        //conec.ptosPromedioJugador(44);  // code=44, avg pt=4.314285
        //conec.listaJugadores();
        
        // Llamar proced
        //conec.callProced("DatosJugadores", null);
        //conec.callProced("JugadoresEquipo", new String[]{"Lakers"});
        //conec.callProced("TripleDoble", new String[]{"10", "10","5"});
        //conec.callProced("Alturas", new String[]{"5"});

        // Cerrar DB
        conec.close();
        
    }
    
}
