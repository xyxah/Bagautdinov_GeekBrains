package lesson10_collections;

import java.util.ArrayList;
import java.util.HashMap;

public class MainApp {

    public static void main(String[] args) {

        //1
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("кот");
        arrayList.add("собака");
        arrayList.add("горилла");
        arrayList.add("медведь");
        arrayList.add("жираф");
        arrayList.add("медведь");
        arrayList.add("кот");
        arrayList.add("слон");
        arrayList.add("медведь");
        arrayList.add("волк");
        uniqueElements(arrayList);

        System.out.println();

        //2
        Phonebook pb = new Phonebook();
        pb.add("89015748201", "Иванов");
        pb.add("89174259230", "Глазова");
        pb.add("89322347975", "Иванов");
        pb.add("89873648234", "Мегин");
        pb.add("89013472387", "Шипачев");
        pb.add("89042784528", "Кулакин");
        pb.get("Иванов");
    }

    public static void uniqueElements(ArrayList<String> arrayList){

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : arrayList) {
            if (hashMap.containsKey(s)) {
                int number = hashMap.get(s);
                hashMap.remove(s);
                hashMap.put(s, number + 1);
            } else hashMap.put(s, 1);

        }

        for (String key : hashMap.keySet())
            System.out.println("Слово " + key + " встретилось " + hashMap.get(key) + " раз(а).");
    }
}
