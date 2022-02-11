package lesson10_collections;

import java.util.HashMap;

public class Phonebook {
    HashMap<String, String> phonebook = new HashMap<>();


    public void add(String number, String surname){
        phonebook.put(number,surname);
    }

    public void get(String surname){
        for (String s : phonebook.keySet())
            if (surname == phonebook.get(s))
                System.out.println("Фамилия " + surname + " Номер " + s);
    }
}
