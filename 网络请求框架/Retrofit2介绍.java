// 入门
// 1创建实例
Retrofit retrofit=new Retrofit.Builder().baseUrl("http://xxx.com/").build();

// 2定义接口
public interface BlogService {
	@GET("blog/{id}")
	Call<ResponseBody> getBlog(@Path("id"));
}

BlogService service=retrofit.create(BlogService.class);

// 3调用接口
Call<ResponseBody> call=service.getBlog(2);
call.enqueue(new Callback<ResponseBody>) {
	public void onResponse(Call<ResponseBody> call,Response<ResponseBody> response) {
		try{
			System.out.println(response.body().string());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void onFailure(Call<ResponseBody> call,Throwable t){
		t.printStackTrace();
	}
});

//
