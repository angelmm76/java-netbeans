package java11accesodb;

public class Java11AccesoDB {

    public static void main(String[] args) {
        String dbname = "sakila";
        String usuario = "usu";
        String pass = "hazerta";
        System.out.println("Accediendo a base de datos " + dbname + 
                "(MySQL)...");
        
        LeerDB lee = new LeerDB(dbname, usuario, pass);
        lee.showData();
        lee.close();
    }
    
}
