public void acquire(RealConnection connection) {
	connection.allocations.add(new WeakReference<>(this));
}
private void release(RealConnection connection){
	for(int i=0,size=connection.allocations.size();i<size;i++){
		Reference<StreamAllocation> reference=connection.allocations.get(i);
		if(reference.get()==this) {
			connection.allocations.remove(i);
			return;
		}
	}
	throw new IllegalStateException();
}

// 连接池
private static final Executor executor=new ThreadPoolExecutor(0,Integer.MAX_VALUE,60L,TimeUnit.SEDCONDS,new SynchronousQueue<Runnable>(),Util.threadFactory("OkHttp ConnectionPool",true));
