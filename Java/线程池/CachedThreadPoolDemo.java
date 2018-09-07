import java.util.concurrent.*;

class CachedThreadPoolDemo {
	public void cachedThreadPoolDemo(){
		ExecutorService cachedThreadPool=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			final int index=i;
			cachedThreadPool.execute(new Runnable(){
				public void run(){
					System.out.println(Thread.currentThread().getName()+", index="+index);
				}
			});

//			try{
//				Thread.sleep(1000);// Thread.sleep(); Object.wait()
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
		}
	}
	public static void main(String[] args){
		CachedThreadPoolDemo demo=new CachedThreadPoolDemo();
		demo.cachedThreadPoolDemo();
		return;
	}
}
