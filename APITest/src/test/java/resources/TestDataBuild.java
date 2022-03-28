package resources;

import bdd.APITest.pojo.Post;

public class TestDataBuild {

    public Post addPostPayload(int userId, String title, String body){
        Post post = new Post();
        post.setUserId(userId);
        post.setTitle(title);
        post.setBody(body);
        return post;
    }
}
