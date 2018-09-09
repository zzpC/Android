public interface GitHubService {
	@GET("users/{user}/repos")
	Call<List<Repo>> listRepos(@Path("user") String user)
}

Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.github.com/").build();
GitHubService service=retrofit.create(GitHubService.class);

Call<List<Repo>> repos=service.listRepos("octocat");

//
Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.github.com").addConverterFactory(GsonConverterFactory.create()).build();
GithubService serviece=retrofit.create(GitHubServicec.class);

