import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PutResponseBody {

    @Test
    public void put01(){

        String url= "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject requestBody= new JSONObject();
        requestBody.put("title","Sema Nur");
        requestBody.put("body","Kızıl");
        requestBody.put("userId",30);
        requestBody.put("id",80);


        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .put(url);

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");

    }
}

