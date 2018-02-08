package java08threads;

public class Java08Threads {

    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread 1", 1000);
        MyThread thread2 = new MyThread("Thread 2", 400);
        MyThread thread3 = new MyThread("Thread 3", 700);
        
        thread1.start();
        thread2.start();
        thread3.start();
        
    }   
}
