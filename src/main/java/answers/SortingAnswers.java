package answers;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by olexandra on 3/10/16.
 */
public class SortingAnswers {

    /**
     * Ex 1. Sort the List ascending
     */

    @Test
    public void sortListAsc() {

//given
        List<String> list = Arrays.asList("Maria", "Victor", "Pavel", "Alfina", "Sasha");
//when
        List actual = (List) list.stream().sorted().collect(Collectors.toList());
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
        List actual = (List) list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
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

//when

        //Sort by name
        list.stream().sorted((m1, m2) -> m1.getName().compareTo(m2.getName())).forEach(System.out::println);
        System.out.println("---------");

        //Sort by age and name - don't do that
        list.stream().sorted((m1, m2) -> m1.getName().compareTo(m2.getName())).sorted((m1, m2) -> ((Integer) m1.getAge()).compareTo(m2.getAge())).forEach(System.out::println);
        System.out.println("---------");

        //Sort by name and age
        Comparator<FamilyMember> compareNameThenAge = Comparator.comparing(FamilyMember::getName).thenComparing(FamilyMember::getAge);
        list.stream().sorted(compareNameThenAge).forEach(System.out::println);
        System.out.println("---------");

        //////////////Live Codding//////////////
        List<FamilyMember> actualName = list.stream()
                .sorted((fm1, fm2) -> fm1.getName().compareTo(fm2.getName()))
                .collect(Collectors.toList());
        System.out.println("--------");
        System.out.println("Sorted Family by name");
        actualName.stream().forEach(System.out::println);

        List<FamilyMember> actualNameAge = list.stream()
                .sorted((fm1, fm2) -> fm1.getName().compareTo(fm2.getName()))
                .sorted((fm1, fm2) -> ((Integer) fm1.getAge()).compareTo(fm2.getAge()))
                .collect(Collectors.toList());
        System.out.println("--------");
        System.out.println("Sorted Family by name and age bad");
        actualNameAge.stream().forEach(System.out::println);

        List<FamilyMember> actualAge = list.stream()
                .sorted((fm1, fm2) -> ((Integer) fm1.getAge()).compareTo(fm2.getAge()))
                .collect(Collectors.toList());
        System.out.println("--------");
        System.out.println("Sorted Family by age");
        actualAge.stream().forEach(System.out::println);

        Comparator<FamilyMember> compareName = (fm1, fm2) -> fm1.getName().compareTo(fm2.getName());
        Comparator<FamilyMember> compareAge = (fm1, fm2) -> ((Integer) fm1.getAge()).compareTo(fm2.getAge());

        Comparator<FamilyMember> compareNameAge = compareName.thenComparing(compareAge);

//        List<FamilyMember> actualNameAgeGood = list.stream()
//                .sorted(compareNameAge)
//                .collect(Collectors.toList());

//        List<FamilyMember> actualNameAgeGood = list.stream()
//                .sorted(Comparator.comparing(FamilyMember::getName).thenComparing(compareAge))
//                .collect(Collectors.toList());

        List<FamilyMember> actualNameAgeGood = list.stream()
                .sorted(Comparator.comparing(FamilyMember::getName)
                        .thenComparing((FamilyMember::getAge)))
                .collect(Collectors.toList());
        System.out.println("--------");
        System.out.println("Sorted Family by name and age good");
        actualNameAgeGood.stream().forEach(System.out::println);

        Collections.sort(list, compareNameAge);
        System.out.println("--------");
        System.out.println("Sorted Family by name and age using Collections");
        list.stream().forEach(System.out::println);
        //////////////Live Codding Closed//////////////


        //Sort by name and age using Comparator
        Collections.sort(list, compareNameThenAge);
        list.stream().forEach(System.out::println);
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

        @Override
        public String toString() {
            return name +
                    ", age=" + age +
                    ", role=" + role;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof FamilyMember))
                return false;
            if (obj == this)
                return true;
            if (obj != null) {
                FamilyMember member = (FamilyMember) obj;
                return name.equals(member.getName()) && age == member.getAge() && role.equals(member.getRole());
            } else
                return this == null;
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + age;
            result = 31 * result + role.hashCode();
            return result;
        }
    }
}