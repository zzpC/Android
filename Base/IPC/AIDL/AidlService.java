// Service在MainFest中注册，exported设置为true，避免客户端异常
public class AidlService extends Service {
	public void onCreate(){
		super.onCreate();
	}
	public IBinder onBind(Intent arg0){
		return new IService.Stub(){
			public String testString(String name) throws RemoteException {
				return "Hello"+name;
			}
			public int testInt(int a,int b) throws RemoteException {
				return a+b;
			}
		};
	}
}


