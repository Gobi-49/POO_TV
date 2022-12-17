import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import filein.Input;
import fileout.UserOut;
import program.InputProcessing;
import resources.Processing;
import resources.data.*;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileNameOut = "results.out";
        String fileNameIn = "/home/gabi/Desktop/OOP/POO_TV/checker/resources/in/basic_8.json";
        fileNameIn = args[0];
        fileNameOut = args[1];
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode output = objectMapper.createArrayNode();

        Input inputData = objectMapper.readValue(new File(fileNameIn), Input.class);

        InputProcessing.addUsersToDatabase(inputData);
        InputProcessing.addMoviesToDatabase(inputData);
        ActiveUser activeUser = new ActiveUser();
        Processing processing = new Processing(objectMapper,output);
        InputProcessing.actions(inputData, activeUser, processing);


        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(fileNameOut),output);

        Database.getDatabase().deleteDatabase();
    }
}
