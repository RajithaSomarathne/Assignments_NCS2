package resources;

public enum APIResources {
	
	UsersAPI("/users"),
	UsersAPIGetUser("/users/{userId}"),
	PostsAPI("/posts");

	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
}
