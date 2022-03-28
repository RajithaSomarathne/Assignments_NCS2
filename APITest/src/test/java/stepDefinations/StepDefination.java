package stepDefinations;

import bdd.APITest.pojo.Post;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StepDefination extends Utils {
    TestDataBuild testData = new TestDataBuild();
    Response response;
    Post post;

    @When("user calls {string} with path param {string} as {int}")
    public void userCallsWithPathParam(String resource, String pathParam, int value) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(resource);
        response = given().pathParam(pathParam,value).spec(requestSpecification()).when().get(resourceAPI.getResource());
    }

    @Then("the API call got success with status code {int}")
    public void checkAPIResponseCode(int code) {
        assertEquals(code,response.getStatusCode());
    }

    @When("user calls {string} with param {string} as {int}")
    public void userCallsWithParam(String resource, String param, int value) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(resource);
        response = given().param(param,value).spec(requestSpecification()).when().get(resourceAPI.getResource());
    }

    @Then("verify posts id's are valid")
    public void verifyPostIds() {
        JsonPath jsonPath = new JsonPath(response.asString());
        List<Integer> ids = jsonPath.getList("id");
        //System.out.println(ids);
        for(int i = 0; i < ids.size(); i++) {
            Integer id = ids.get(i);
            if(id!=null){
                if(id <= 0 || id > 100){
                    fail("ID is not between 1 and 100 for post Id ="+id);
                }
            }else{
                fail("ID is null for post Id ="+id);
            }
        }
        assertEquals(200,response.getStatusCode());
    }

    @When("user calls {string} to add a post with user id {int} title {string} body {string}")
    public void userAddPost(String resource, int userId, String title, String body) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(resource);
        post = testData.addPostPayload(userId,title,body);
        response = given().spec(requestSpecification()).body(post)
                .when().post(resourceAPI.getResource());
    }

    @Then("verify response body")
    public void verifyPostResponseBody() {
        String userId = getJsonPath(response,"userId");
        if(userId!=null){
            assertEquals(post.getUserId(),Integer.parseInt(userId));
            assertEquals(post.getTitle(),getJsonPath(response,"title"));
            assertEquals(post.getBody(),getJsonPath(response,"body"));
        }else{
            fail("Invalid user Id");
        }
    }

}
