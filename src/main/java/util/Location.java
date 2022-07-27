package util;

import java.io.Serializable;

public class Location implements Serializable {
    private static final long serialVersionUID = 102L;
    private Double x; //Поле не может быть null
    private Float y; //Поле не может быть null
    private Integer z; //Поле не может быть null
    private String name; //Поле не может быть null

    public Location(Double x, Float y, Integer z, String name){
        setX(x);
        setY(y);
        setZ(z);
        setName(name);
    }

    public void setX(Double x) throws IllegalArgumentException {
        if(x != null){
            this.x = x;
        } else {
            throw new IllegalArgumentException("Поле не может быть null");
        }
    }
    public void setY(Float y) throws IllegalArgumentException {
        if(y != null){
            this.y = y;
        } else {
            throw new IllegalArgumentException("Поле не может быть null");
        }
    }
    public void setZ(Integer z) throws IllegalArgumentException {
        if(z != null){
            this.z = z;
        } else {
            throw new IllegalArgumentException("Поле не может быть null");
        }
    }
    public void setName(String name) throws IllegalArgumentException {
        if(name != null){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Поле не может быть null");
        }
    }

    public double getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public int getZ(){
        return z;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return String.format("%s: X - %.5f, Y - %.5f, Z - %d", name, x, y, z);
    }
}