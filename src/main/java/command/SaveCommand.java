package command;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import util.StudyGroup;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * Save command writes data into output file
 */

public class SaveCommand extends Command{
    private static final long serialVersionUID = 14L;
//    String outputFilepath;
//    Set<StudyGroup> collection;
//    public SaveCommand(String path, Set<StudyGroup> c){
//        outputFilepath = path;
//        collection = c;
//        this.name = CommandEnum.SAVE;
//    }
//    @Override
//    public Boolean execute() throws IOException {
//        Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy HH:mm:ss").create();
//        File outputFile = new File(outputFilepath);
//        OutputStream os = new FileOutputStream(outputFile);
//        BufferedOutputStream br = new BufferedOutputStream(os, 16384);
//        br.write(gson.toJson(collection).getBytes(StandardCharsets.UTF_8));
//        br.close();
//        os.close();
//        return new File(outputFilepath).exists();
//    }

    @Override
    public String describe() {
        return "save : сохранить коллекцию в файл";
    }
}
