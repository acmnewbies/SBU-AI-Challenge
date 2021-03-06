package ClientSide;


import Entity.AddObject;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.nio.charset.StandardCharsets;


public class Client {
    public static void main(String[] args) throws Exception {

        AddObject addObject = new AddObject( 10, 20 );
        String uri = "http://localhost:4567/add";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(uri);

        Gson gson = new Gson();
        String jSonString = gson.toJson( addObject );

        /*
            jSonString is an instance of AddObject converted to JSON as a string
            for example:
            jSonString = "{\"number1\":1,\"number2\":3,\"sum\":5}";

        */
        HttpEntity entity = new ByteArrayEntity(jSonString.getBytes(StandardCharsets.UTF_8));
        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        String result = EntityUtils.toString(response.getEntity());

        AddObject responsded = gson.fromJson( result, AddObject.class );

        System.out.println( responsded.getSum() );

    }
}
