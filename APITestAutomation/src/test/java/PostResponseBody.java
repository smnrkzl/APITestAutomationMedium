import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostResponseBody {

    @Test
    public void post01(){

        String url= "https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody= new JSONObject();
        requestBody.put("title","API");
        requestBody.put("body","Rest Assured");
        requestBody.put("userId",20);

        Response response= given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);

        response
                .then()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", Matchers.equalTo("API"))
                .body("userId",Matchers.lessThan(100))
                .body("body",Matchers.containsString("API"));
    }


}



