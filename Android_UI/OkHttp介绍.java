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
