import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import filein.Input;
import program.InputProcessing;
import program.Processing;
import resources.data.*;

import java.io.File;
import java.io.IOException;

public class Main {
    /**
     * the main method of the program
     * @param args the input and output file name
     */
    public static void main(final String[] args) throws IOException {
        String fileNameOut;
        String fileNameIn;
        fileNameIn = "/home/gabi/Desktop/OOP/POO_TV/checker/resources/in/basic_1.json";
        fileNameOut = "results.out";
        fileNameIn = args[0];
        fileNameOut = args[1];
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode output = objectMapper.createArrayNode();

        Input inputData = objectMapper.readValue(new File(fileNameIn), Input.class);

        InputProcessing.addUsersToDatabase(inputData);
        InputProcessing.addMoviesToDatabase(inputData);
        ActiveUser activeUser = new ActiveUser();
        Processing processing = new Processing(objectMapper, output);
        InputProcessing.actions(inputData, activeUser, processing);


        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File(fileNameOut), output);

        SingletonDatabase.getDatabase().deleteDatabase();
    }
}
