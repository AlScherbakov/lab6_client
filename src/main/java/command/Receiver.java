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
    private String outputFilepath;
    private List<CommandEnum> history;
    private boolean working;
    private DataInputSource source;
    public String collectionInitializationDate;
    private final Deque<BufferedReader> readers = new ArrayDeque<>();
    public Receiver(Set<StudyGroup> c, String o, List<CommandEnum> h, boolean w, DataInputSource s, String cid){
        collection = c;
        outputFilepath = o;
        history = h;
        working = w;
        source = s;
        collectionInitializationDate = cid;
    }
    public Set<StudyGroup> getCollection(){
        return collection;
    }
    public String getOutputFilepath(){
        return outputFilepath;
    }
    public List<CommandEnum> getHistory(){
        return history;
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
    public String getCollectionInitializationDate(){
        return collectionInitializationDate;
    }
    public Deque<BufferedReader> getReaders(){
        return readers;
    }
    public void setCollection(Set<StudyGroup> c){
        collection = c;
    }
    public void setOutputFilepath(String o){
        outputFilepath = o;
    }
    public void setHistory(ArrayList<CommandEnum> h){
        history = h;
    }
    public void setWorking(boolean w){
        working = w;
    }
    public void setSource(DataInputSource s){
        source = s;
    }
    public void setCollectionInitializationDate(String d){
        collectionInitializationDate = d;
    }

    public void pushReader(BufferedReader r){
        if(!readers.contains(r)){
            readers.push(r);
        } else {
            System.out.println("Один из скриптов пропущен во избежании рекурсии");
        }
    }

    public void removeFirstReader(){
        if (readers.size() > 0){
            readers.remove();
        }
    }

    public void addToCollection(StudyGroup e){
        collection.add(e);
    }

}
