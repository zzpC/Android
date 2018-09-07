import java.util.concurrent.*;

class FixedThreadPoolDemo {
	public void fixedThreadPoolDemo(){
		ExecutorService fixedThreadPool=Executors.newFixedThreadPool(3);
		for(int i=0;i<5;i++){
			final int index=i;
			fixedThreadPool.execute(new Runnable(){
				public void run(){
					System.out.println(Thread.currentThread().getName()+", index="+index);
				}
			});

			try{
				Thread.sleep(1000);// Thread.sleep(); Object.wait()
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
		FixedThreadPoolDemo demo=new FixedThreadPoolDemo();
		demo.fixedThreadPoolDemo();
		return;
	}
}
