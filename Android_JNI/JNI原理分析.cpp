// System.java
public static void loadLibrary(String libName){
	// 
	Runtime.getRuntime().loadLibrary(libName,VMStack.getCallingClassLoader());
}

//Runtime.java
void  loadLibrary(String libraryName,ClassLoader loader){
	if(loader!=null){
		// 查找库所在路径
		String filename=loader.findLibrary(libraryName);
		if(filename==null){// throw xxx; }
		String error=doLoad(filename,loader);
		if(error!=null){// throw xxx;}
		return;
	}

	// loader为空
	String filename=loader.findLibrary(libraryName);
	List<String> candidate=new ArrayList<String>();
	String lastError=null;
	// mLibPaths是通过Sytem.getProperty("java.library.path")获取的
	for(string directory : mLibPaths){
		String candidate=directory+filename;
		candidates.add(candidate,loader);
		if(error==null){
			return ;// 加载成功
		}
		lastError=error;
	}
	if(lastError!=null){// throw xxx;}
	throw new xxx;
}

private String doLoad(String name,ClassLoader loader){
	// ...
	synchronized(this){
		return nativeLoad(name,loader,librarySearchPath); // 需要进入ART虚拟机java_Runtime.cc
	} 
}
// 到此直接上虚拟机的操作结论,通过dlsym()调用相应库的JNI_OnLoad

// andorid_media_MediaPlayer.cpp
jint JNI_OnLoad(JavaVM* vm, void* reserved){
	JNIEnv* env=NULL;
	if(register_android_media_MediaPlayer(env)<0){goto bail;}
}
static int register_android_media_MediaPlayer(JNIEnv* env){
	return AndroidRuntime::registerNativeMethods(env,"android/media/MediaPlayer",gMethods,NELEM(gMethods));
}

//
static JNINativeMethod gMethods[]={
	// java和C++层方法的映射关系
	static JNINativeMethod gMethods[]={
		{"prepare","()V",(void *)android_media_MediaPlayer_prepare},	
		// ...
	};
};
typedef struct {
	const char* name;// java本地函数名
	const char* signature;// Java函数签名,记录参数类型和个数,以及返回值类型
	void* fnPtr;//Native层对应的函数指针
} JNINativeMethod;

//  ...省略一部分调用链

// JavaVM：进程虚拟机环境，进程唯一
// JNIEnv：线程上下文环境，线程唯一

