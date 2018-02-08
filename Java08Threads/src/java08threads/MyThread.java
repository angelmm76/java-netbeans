package java08threads;

public class MyThread extends Thread {
    public String threadname;
    public int milis;
    
    // Constructor
    public MyThread(String name, int mili){
        this.threadname = name;
        this.milis = mili;
        System.out.println("Creando el thread " + threadname + 
                " que dormirá " + milis + " ms");
        //start();
    }
    
    // Métodos
    public void run(){
        int cont;
        System.out.println("Soy el thread " + this.threadname + " corriendo");
        try{
            for(int i = 1; i<4; i++) {
                System.out.println(threadname + " - " + i);
                this.sleep(this.milis);
            }
            
        }
        catch(Exception e){
            System.out.println("Excepcion " + e.toString());
        }
        System.out.println(this.threadname + " finalizado");
    }    
}
