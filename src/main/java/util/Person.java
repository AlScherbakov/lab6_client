package util;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Comparable<Person>, Serializable {
    private static final long serialVersionUID = 101L;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private LocalDate birthday; //Поле не может быть null
    private Color eyeColor; //Поле может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле не может быть null

    public Person(String name, LocalDate birthday, Color eyeColor, Country nationality, Location location){
        setName(name);
        setBirthday(birthday);
        setEyeColor(eyeColor);
        setNationality(nationality);
        setLocation(location);
    }

    public void setName(String name) throws IllegalArgumentException{
        if (name != null && name.length() > 0){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Поле не может быть null, Строка не может быть пустой");
        }
    }
    public void setBirthday(LocalDate birthday) throws IllegalArgumentException{
        if(birthday != null){
            this.birthday = birthday;
        } else {
            throw new IllegalArgumentException("Поле не может быть null");
        }
    }
    public void setEyeColor(Color eyeColor) throws IllegalArgumentException{
        if (eyeColor != null){
            this.eyeColor = eyeColor;
        } else {
            throw new IllegalArgumentException("Поле не может быть null");
        }
    }
    public void setNationality(Country nationality) throws IllegalArgumentException{
        if (nationality != null){
            this.nationality = nationality;
        } else {
            throw new IllegalArgumentException("Поле не может быть null");
        }
    }
    public void setLocation(Location location) throws IllegalArgumentException{
        if (location != null){
            this.location = location;
        } else {
            throw new IllegalArgumentException("Поле не может быть null");
        }
    }

    public String getName(){
        return name;
    }

    public LocalDate getBirthday(){
        return birthday;
    }
    public Color getEyeColor(){
        return eyeColor;
    }
    public Country getNationality(){
        return nationality;
    }
    public Location getLocation(){
        return location;
    }

    @Override
    public String toString() {
        return String.format("Человек %s. Родился %s с %s цветом глаз. Национальность - %s. Местоположение - %s.", this.name, birthday, eyeColor, nationality, location);
    }

    @Override
    public int compareTo(Person o) {
        //сортировка по возрасту
        return o.getBirthday().compareTo(birthday);
    }
}