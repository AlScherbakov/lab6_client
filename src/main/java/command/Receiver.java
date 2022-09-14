package command;

import util.DataInputSource;
import util.StudyGroup;

import java.io.BufferedReader;
import java.io.Serializable;
import java.util.*;

/**
 * Receiver class - Command pattern element - stores program state
 */

public class Receiver {
    private Set<StudyGroup> collection;
    private final boolean working;
    private DataInputSource source;
    public String collectionInitializationDate;
    private final Deque<BufferedReader> readers = new ArrayDeque<>();
    private final List<String> scriptBanList = new ArrayList<>();

    public Receiver(Set<StudyGroup> c, boolean w, DataInputSource s, String cid){
        collection = c;
        working = w;
        source = s;
        collectionInitializationDate = cid;
    }
    public Set<StudyGroup> getCollection(){
        return collection;
    }
    public boolean getWorking(){
        return working;
    }
    public DataInputSource getSource(){
        if (!readers.isEmpty()){
            return new DataInputSource(readers.getFirst());
        }
        return source;
    }
    public void setCollection(Set<StudyGroup> c){
        collection = c;
    }
    public void setSource(DataInputSource s){
        source = s;
    }

    public boolean pushReader(BufferedReader r, String scriptPath){
        if(scriptBanList.stream().filter(x -> x.matches(scriptPath) || scriptPath.matches(x)).findAny().orElse(null) == null){
            readers.push(r);
            scriptBanList.add(scriptPath);
            return true;
        } else {
            System.out.printf("Cкрипт %s пропущен во избежании рекурсии\n", scriptPath);
            return false;
        }
    }

    public void removeFirstReader(){
        if (readers.size() > 0){
            readers.remove();
            scriptBanList.remove(0);
        }
    }

}
