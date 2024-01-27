package homework;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Homework {
    /* Задача 1
    Пусть есть класс Person с полями имя и возраст. Написать метод, принимающий список Person
    и возвращающий мапу, где возраст является ключом, а лист людей этого возраста значением

       Задача 2
    Тот же класс Person с полями String name, int age.
    - Написать метод, принимающий список Person и возвращающий суммарный возраст тех, кто старше 18 лет.
    - Написать метод, принимающий список Person и возвращающий имена тех, кто старше 18 лет в виде такой строки:
    "At the moment John, and Ann, and Bill are of legal age".
    (имена и текст могут быть любыми, по вашему выбору, структура предложения должна сохраняться)

       Задача 3
    Написать метод, принимающий в качестве параметров две строки. Первая строка состоит из слов,
    разделенных пробелом. Метод возвращает количество слов первой строки, начинающихся со второй строки
    Пример : Первая строка "aaaaaaa cccc ab bbbbb a ff aaa"
    Если вторая строка а, то ответ 4
    Если вторая строка ааа, ответ 2
    Если вторая строка aaaa, ответ 1
     */
    public static void main(String[] args) {
        Person person1 = new Person("John Snow", 22);
        Person person2 = new Person("Ann Smith", 16);
        Person person3 = new Person("Tom Sawyer", 9);
        Person person4 = new Person("James Bond", 43);
        Person person5 = new Person("Bill Gates", 55);
        Person person6 = new Person("Kate Hudson", 43);
        Person person7 = new Person("Leon Black", 9);
        Person person8 = new Person("Theo White", 22);

        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5, person6, person7, person8);

        // TASK 1
        sortByAge(personList).forEach((age, persons) -> {
            System.out.println("Age: " + age);
            persons.forEach(person -> System.out.println(" "+ person.getName()));
        });

        // TASK 2 (part1)
        System.out.println(sumOfAges(personList));

        // TASK 2 (part2)
        System.out.println(getPersonsOver_18(personList));

        // TASK 3
        System.out.println(countStrings("i, item, in, inside, hide", "i") + " words starts with 'i'.");

    }

    public static Map<Integer, List<Person>> sortByAge (List<Person> personList){
        return personList.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        // Не поняла, как собирать в лист имена, поэтому в main в выводе - танцы с бубном
    }

    public static Optional<Integer> sumOfAges (List<Person> personList){
        return personList.stream()
                .filter(n -> n.getAge()>18)
                .map(Person::getAge)
                .reduce((a, b)-> a + b);
        // Не поняла, как вернуть результат в виде простой переменной int
    }

    public static String getPersonsOver_18 (List<Person> personList){
        return personList.stream()
                .filter(n -> n.getAge()>18)
                .map(Person::getName)
                .collect
                (Collectors.joining(", ","At the moment, these persons: "," - are of legal age."));
    }

    public static int countStrings (String string1, String string2){
        String [] str = string1.split(" ");
        return (int)Arrays.stream(str).filter(s ->s.startsWith(string2)).count();
    }
}
