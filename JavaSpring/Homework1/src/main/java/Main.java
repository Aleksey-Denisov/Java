import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = getObjects();
        System.out.println("Method toString()");
        persons.forEach(System.out::println);
        Person one, two;
        one = persons.get(0);
        two = persons.get(1);
        System.out.println("Equals persons: " + one.equals(one));
        System.out.println("Equals persons: " + one.equals(two));
        persons.forEach(person -> System.out.println("hasCode person:" + person.hashCode()));
        Gson gson = new GsonBuilder().create();
        String gsonString = gson.toJson(persons);
        System.out.println("Serializable JSON: " + gsonString);
        Type typeListPersons = new TypeToken<List<Person>>(){}.getType();
        List<Person> des = gson.fromJson(gsonString, typeListPersons);
        System.out.println("Deserializable");
        des.forEach(System.out::println);
    }

    private static List<Person> getObjects() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Aleksey", "Smirnov", 25));
        persons.add(new Person("Vladimir", "Bobrov", 33));
        persons.add(new Person("Igor", "Semenov", 29));
        return persons;
    }
}


