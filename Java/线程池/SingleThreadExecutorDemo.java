import java.util.concurrent.*;

class SingleThreadExecutorDemo {
	public void singleThreadExecutorDemo(){
		ExecutorService singleThreadExecutor=Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			final int index=i;
			singleThreadExecutor.execute(new Runnable(){
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
		SingleThreadExecutorDemo demo=new SingleThreadExecutorDemo();
		demo.singleThreadExecutorDemo();
		return;
	}
}
