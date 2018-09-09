public interface IService extends android.os.IInterface {
	public static abstract class Stub extends android.os.Binder implements com.example.aidlserver.IService {
		private static final java.lang.String DESCRIPTOR="IService";
		public Stub() {
			this.attachInterface(this,DESCRIPTOR);
		}
		public static IService asInterface(android.os.IBinder obj) {
			if(obj==null){
				return null;
			}
			IInterface iin=obj.queryLocalInterface(DECRIPTOR);
			if((iin!=null) && (iin instanceof IService)){
				return (IService) iin;
			}
			return new IService.Stub.Proxy(obj);
		}
	}
}
