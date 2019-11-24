import java.util.*;
import java.io.*;
public class CM307HashMap<keys, objects> {
    private String[] keys;
    private Object[] objects;
    private int size  = 0;
    public CM307HashMap() {
        keys = (String[])new String[100];
        objects = (Object[])new Object[100];
        
    }
    public void put(String key, Object object) {
        int i = Math.abs(key.hashCode()) % keys.length;
        while((keys[i] != null) && !(keys[i].equals(key))) {
            i = (i + 1) % keys.length;
        }
        keys[i] = key;
        objects[i] = object;
        size++;
    }
    public Object get(String key) {
        int i = Math.abs(key.hashCode()) % keys.length;
        if(keys[i]==null)return null;
        if(keys[i].equals(key))return objects[i];
        while((keys[i] != null) && (keys[i].equals(key))) {
            i = (i + 1) % keys.length;
        }
        return objects[i];
    }
    public void printObjects() {
        for (int k = 0; k < keys.length; k++) {
            System.out.println(keys[k] + " = " + objects[k]);
        }
    }
}
