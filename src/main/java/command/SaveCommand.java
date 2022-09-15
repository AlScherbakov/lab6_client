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
    @Override
    public String describe() {
        return "save : сохранить коллекцию в файл";
    }
}
