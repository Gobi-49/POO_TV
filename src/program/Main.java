package program;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import filein.Input;
import fileout.UserOut;
import resources.data.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileNameOut = "results.out";
        String fileNameIn = "/home/gabi/Desktop/OOP/POO_TV/checker/resources/in/basic_1.json";
//        fileNameIn = args[0];
//        fileNameOut = args[1];
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode output = objectMapper.createArrayNode();

        Input inputData = objectMapper.readValue(new File(fileNameIn), Input.class);

        InputWorks.addUsersToDatabase(inputData);
        InputWorks.addMoviesToDatabase(inputData);
        CurrentUser currentUser = new CurrentUser();
        InputWorks.actions(inputData,currentUser);
        ArrayList<User> users = Database.getDatabase().getUsers();
//        ArrayList<Movie> movies = Database.getDatabase().getMovies();
//
        ObjectNode cred = objectMapper.createObjectNode();
////        User user = new User();
////        user.setCredentials(new Credentials("Eduard", "secret", "standard", "Romania", 200));
        UserOut user = new UserOut(currentUser);
        cred.putPOJO("user", user);
//        cred.putPOJO("movies", movies);
//
        output.add(cred);

        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(fileNameOut),output);
    }
}
