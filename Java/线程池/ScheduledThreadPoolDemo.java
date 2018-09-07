import java.util.concurrent.*;

class ScheduledThreadPoolDemo {
	public void scheduledThreadPoolDemo(){
		ScheduledExecutorService scheduledThreadPool=Executors.newScheduledThreadPool(3);
		scheduledThreadPool.schedule(new Runnable(){
			public void run(){
				System.out.println(Thread.currentThread().getName()+", delay 1s");
			}
		},1,TimeUnit.SECONDS);
		scheduledThreadPool.scheduleAtFixedRate(new Runnable(){
			public void run(){
				System.out.println(Thread.currentThread().getName()+", every 3s");
			}
		},2,3,TimeUnit.SECONDS);
	}

	public static void main(String[] args){
		ScheduledThreadPoolDemo demo=new ScheduledThreadPoolDemo();
		demo.scheduledThreadPoolDemo();
		return;
	}
}
