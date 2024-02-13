
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.mycompany.todo.list.entity.TodoEntity;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {

    public static void main(String args[]) throws ParseException, FileNotFoundException {
//        Gson gson = new Gson();
//        ArrayList<TodoEntity> list = new ArrayList();
//        TodoEntity todo = new TodoEntity("Nome",new Date(),"lorem inpsu",5,"Tarefa",TodoEntity.Status.todo);
//        list.add(todo);
//        String userJson = gson.toJson(list);
//        try {
//            FileWriter file = new FileWriter("./src/main/java/com/mycompany/todo/list/data/todos.json");
//            file.write(userJson);
//            file.close();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader("./src/main/java/com/mycompany/todo/list/data/todos.json"));
            TodoEntity[] data = gson.fromJson(reader, TodoEntity[].class);
            System.out.println(data[0].getName());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        System.out.println("JSON file created: " + userJson);
    }
}
