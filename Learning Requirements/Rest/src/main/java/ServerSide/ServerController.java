package ServerSide;

import Entity.AddObject;
import com.google.gson.Gson;

import static spark.Spark.*;

public class ServerController {
    public static void main(String[] args) {

        get("/hello/:name", (req,res)->{
            return "Hello, "+ req.params(":name");
        });
        Gson gson = new Gson();
        post("/add", (req, res) -> {
            res.type("application/json");
            AddObject addObject = gson.fromJson(req.body(), AddObject.class);
            int a = addObject.getNumber1();
            int b = addObject.getNumber2();
            int sum = a + b;
            addObject.setSum(sum);
            return addObject;
        }, gson ::toJson);

    }
}