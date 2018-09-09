public class MainActivity extends Activity{
	IService mRemoteIService;
	private ServiceConnection mSC=new ServiceConneciton(){
		public void onServiceConnected(ComponentName arg0,IBinder ibinder){
			mRemoteIService=IService.Stub.asInterface(ibinder);
			try{
				String s=mRemoteIService.testString("world");
			}catch (RemoteException e){
				e.printStackTrace();
			}
			try{
				int i=mRemoteIService.testInt(1,2);
			}catch (RemoteException e){
				e.printStackTrace();
			}
		}
	}

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		// initService()
		Intent i=new Intent();
		i.setClassName("aidlserver","AidlService");
		boolean ret=bindService(i,mSC,BIND_AUTO_CREATE;
	}
	
	protected void onDestroy(){
		super.onDestroy();

		// releaseIService()
		unbindService(mSC);
		mSC=null;
	}
}

