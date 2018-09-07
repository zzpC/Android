import java.util.concurrent.*;
public class ESDemo {
	public void fun(){
		ExecutorService es=Executors.newFixedThreadPool(3);
		
		es.submit(new Runnable(){
			public void run(){
			
			}
		});

		es.execute(new Runnable(){
			public void run(){
			
			}
		});
	}
	public static void main(String[] args){
		return;
	}
}
