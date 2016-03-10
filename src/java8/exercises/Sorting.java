import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by olexandra on 3/10/16.
 */
public class Sorting {

    /**
     * Ex 1. Sort the List ascending
     */

    @Test
    public void sortListAsc() {

//given
        List<String> list = Arrays.asList("Maria", "Victor", "Pavel", "Alfina", "Sasha");
//when
        List actual = null; //TODO write your implementation here
//then
        List<String> expected = Arrays.asList("Alfina", "Maria", "Pavel", "Sasha", "Victor");
        assertEquals(expected, actual);
    }

    /**
     * Ex 2. Sort the List descending
     */

    @Test
    public void sortListDesc() {

//given
        List<String> list = Arrays.asList("Maria", "Victor", "Pavel", "Alfina", "Sasha");
//when
        List actual = null; //TODO write your implementation here
//then
        List<String> expected = Arrays.asList("Victor", "Sasha", "Pavel", "Maria", "Alfina");
        assertEquals(expected, actual);
    }

    /**
     * Ex 3. Sort the list of FamilyMembers first by name and then my age
     */

    @Test
    public void sortListObject() {

//given
        List<FamilyMember> list = Arrays.asList(
                new FamilyMember("Kolia", 3, "grandson"),
                new FamilyMember("Illina Petrovna", 89, "great grandma"),
                new FamilyMember("Illina Petrovna", 50, "grandma"),
                new FamilyMember("Ivan Vasilich", 92, "great grandpa"),
                new FamilyMember("Vitalina Fedorovna", 70, "grandmother"),
                new FamilyMember("Vitalij Valerianovich", 70, "grandfather"));

        System.out.println("---------------This is the initial array---------------");
        list.stream().forEach(System.out::println);

//when
// TODO: insert the code which updates list heres

        List<FamilyMember> expected = Arrays.asList(
                new FamilyMember("Illina Petrovna", 50, "grandma"),
                new FamilyMember("Illina Petrovna", 89, "great grandma"),
                new FamilyMember("Ivan Vasilich", 92, "great grandpa"),
                new FamilyMember("Kolia", 3, "grandson"),
                new FamilyMember("Vitalij Valerianovich", 70, "grandfather"),
                new FamilyMember("Vitalina Fedorovna", 70, "grandmother"));

        assertEquals(expected, list);
        assertEquals(expected.get(0).toString(), list.get(0).toString());
        assertEquals(expected.get(1).toString(), list.get(1).toString());
    }


    class FamilyMember {

        String name;
        int age;
        String role;

        public FamilyMember(String name, int age, String role) {
            this.name = name;
            this.age = age;
            this.role = role;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getRole() {
            return role;
        }
    }
}