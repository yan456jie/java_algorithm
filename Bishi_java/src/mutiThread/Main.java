package mutiThread;

class Thread2 implements Runnable{  
    private int count=15;  
    @Override  
    public void run() {  
          for (int i = 0; i < 5; i++) {  
              System.out.println(Thread.currentThread().getName() + "运行  count= " + count--);  
                try {  
                    Thread.sleep((int) Math.random() * 10);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
            }  
          
    }  
      
}  
public class Main {  
  
    public static void main(String[] args) throws InterruptedException {  
          
        Thread2 my = new Thread2();  
        Thread t1 = new Thread(my, "A");
        t1.start();//同一个mt，但是在Thread中就不可以，如果用同一个实例化对象mt，就会出现异常     
        t1.join();
        new Thread(my, "B").start();  
        new Thread(my, "D").start();  
    }  
  
}
