package lesson11_generalizations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> list;

    public Box(){
        list = new ArrayList<T>();
    }

    @SafeVarargs
    public Box(T... obj){
        list = Arrays.asList(obj);
    }

    public List<T> getList(){
        return list;
    }

    public void moveAt(Box<T> box) {
        box.getList().addAll(list);
        list.clear();
    }

    public void add(T obj){
        list.add(obj);
    }

    public float getWeight(){
        if (list.isEmpty()) return 0;
        else return list.size() * list.get(0).getWeight();
    }

    public boolean compare(Box<? extends Fruit> box){
        return this.getWeight() == box.getWeight();
    }
}
