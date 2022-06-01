/* O deadlock é a situação, que ocorre quando uma thread está aguardando o recurso,
que foi adquirido pela segunda thread e a segunda thread está aguardando o recurso
que foi adquirido pela primeira thread. Essa dependência cíclica resulta em uma
situação de deadlock. */


public class Deadlock {

    static Object recursoA = new Object();
    static Object recursoB = new Object();

    public static void main(String[] args) {
        new Thread("Thread 01"){
            public void run(){
                synchronized (recursoA){
                    System.out.println("Thread 01: Pegou recurso A");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread 01: Interrompida.");
                    }
                    System.out.println("Thread 01: Esperando por recurso B");
                    synchronized (recursoB){
                        System.out.println("Thread 01: Pegou recurso B");
                    }
                }
            }
        }.start();

        new Thread("Thread 02"){
            public void run(){
                synchronized (recursoB){
                    System.out.println("Thread 02: Pegou recurso B");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread 02: Interrompida.");
                    }
                    System.out.println("Thread 02: Esperando por recurso A");
                    synchronized (recursoA){
                        System.out.println("Thread 02: Pegou recurso A");
                    }
                }
            }
        }.start();
    }
}