// JNI查找方式
// Android系统启动,先启动Kernel创建init进程,fork第一个横穿Java、C++的进程--Zygote进程，创建虚拟机，注册JNI方法
int AndroidRuntime::startReg(JNIEnv* env){
	// 
	androidSetCreateThreadFun((android_create_thread_fn) javaCreateThreadEtc);

	env->PushLocalFrame(200);
	// 
	if(register_jni_procs(gRegJNI,NELEM(gRegJNI),env)<0){
		env->PopLocalFrame(NULL);
		return -1;
	}
	env->PopLocalFrame(NULL);
	return 0;
}
// 启动时注册大量的JNI方法
static int register_jni_procs(const RegJNIRec array[],size_t count,JNIEnv* env){
	for(size_t i=0;i<count<;i++){
		if(array[i].mProc(env)<0){
			return -1;
		}
	}
}

// RegJNIRec结构体，结构体成员是方法指针，都是Android类库的本地方法
static const RegJNIRec gRegJNI[]={
	// 100+个成员变量
}

// 实例1 命名方式为[包名]_[类名].cpp
// Android消息机制源码，遇到消息队列的一个本地方法nativePollOnce，
// 方法对应的cpp文件，其cpp文件的注册名是register_android_os_MessageQueue存储在AndrodiRuntime.cpp的RegJNI静态全局数组中
// （即有些本地方法存储在cpp文件的静态全局数组中，并用结构体进行封装）

// 实例2  Binder对应的cpp文件命名为android_util_Binder.cpp
// 在RegJNI数组中可以找到register_android_os_Binder

// 实例3 自定义的JNI方法，不由系统启动进行注册的JNI
public class MediaPlayer{
	static {
		System.loadLibrary("media_jni");
		native_init();
	}

	private static native final void native_init();
}

// 使用grep命令搜索包含libmedia_jni字段的Android.mk,打开获知libmedia_jni.so位于/frameworks/base/media/jni/Android.mk
static void android_media_MediaPlayer_native_init(JNIEnv* env){
	jclass clazz;
	clazz=env->FindClass("android/media/MediaPlayer");
	fields.context=env->FieldID(clazz,"mNativeContext","J");
}

