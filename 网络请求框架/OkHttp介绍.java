//
OkHttpClient client=new OkHttpClient();
// Get请求
Request request=new Request.Builder().get().url("https:www.baidu.com").build();
//
Call call=client.newCall(request);
// 同步请求,可能阻塞主线程
Response response=call.execute();
// 异步调用,
call.enqueue(new Callback(){
	public void onFailure(Call call, IOException e){
		
	}

	public void onResponse(Call call,final Response response) throws IOException {
		final String res=response.body().string();
	}
})

// Post请求
//
FormBody formbody=new FormBody.Builder().add("username","admin").add("passwd","root").build();
//
final Request request=new Request.Builder().url("http://ww.jianshu.com/").post(formBody).build();
//
Call call=client.newCall(request);
call.enqueue(new Callback(){

})

// FormBody是RequestBody的子类,提交字符串用父类即可,向服务端发送json数据
RequestBody requestBody=RequestBody.create(MediaType.parse("text/plain;charset="utf-8","{username:admin}","{password:root}"));
// 上传文件,添加写权限

// 提交表单
File file=new File(Environment.getExternalStorageDirectory(),"1.png");
RequestBody multipartBody=new MultipartBody.Builder()
	.setType(MultipartBody.FORM)
	.addFormDataPart()// ...
	.build()
// get下载图片
public void downloadImg(View view){
	OkHttpClient client=new OkHttpClient();
	final Request request=new Request.Builder().get().url("www.baidu.com/img/bd_logo1.png")
		.build();
	Call call=client.newCall(request);
	call.enqueue(new Callback(){
		
	})
}
// 网络下载图片并设置到IV中
public void onResponse(Call call,Response response) throws IOException {
	InputStream is=response.body().byteStream();
	final Bitmap bitmap=BitmapFactory.decodeStream(is);
	runOnUiThread(new Runnable(){
		public void run(){
			imageView.setImageBitmap(bitmap);
		}
	})
	is.close();
}
// 给文件加上进度条
public void onResponse(Call call,Response response) throws IOException {
	InputStream is=response.body().byteStream();
	long sum=0L;
	final long total=response.body().contentLength();
	int len=0;
	File file=new File(Environment.getExternalStorageDirectory(),"n.png");
	FileOutputStream fos=new FIleOutputStream(file);
	byte[] buf=new byte[128];

	while((len=is.read(buf))!=-1){
		fos.write(buf,0,len);
		sum+=len;
		final long finalSum=sum;
		RunOnUiThread(new Runnable(){
			public void run(){
				contentTv.setText(finalSum+"/"+total);
			}
		});
	}
	fos.flush();
	fos.close();
	is.close();
}
