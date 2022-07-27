package messages;

import command.CommandEnum;

/**
 * Save command writes data into output file
 */

public class SaveMessage extends Message {
    private static final long serialVersionUID = 14L;
    public SaveMessage(){
        this.name = CommandEnum.SAVE;
    }
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
}