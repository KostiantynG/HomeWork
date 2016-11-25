package ua.gk.task0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
//1 Add about 20 of Person class instances to "mainCollection" collection
		System.out.println("//1 Add about 20 of Person class instances to \"mainCollection\" collection");
		List<Person> mainCollection = new ArrayList<>();
		mainCollection.add(new Person("Alex", "Bilikov"));
		mainCollection.add(new Person("Oleg", "Bilikov"));
		mainCollection.add(new Person("Alex", "Bilikov"));
		mainCollection.add(new Person("Valeriy", "Litvin"));
		mainCollection.add(new Person("Kostiantyn", "Tokov"));
		mainCollection.add(new Person("Jakov", "Fain"));
		mainCollection.add(new Person("Evgen", "Drach"));

		mainCollection.add(new Person("Mariana", "Vaselenko"));
		mainCollection.add(new Person("Olena", "Petrenkoe"));
		mainCollection.add(new Person("Tetiana", "Bezilko"));
		mainCollection.add(new Person("Oksana", "Peta"));

		System.out.println(mainCollection);

//2 Create two more collections "ukranianSurnames" and "russianSurnames"
		List<Person> russianSurnames = new ArrayList<>();
		List<Person> ukranianSurnames = new ArrayList<>();

//3 Fill ukranianSurnames collection with persons from mainCollection that have 'ilko' and 'enko' surname suffix
//4 Fill russianSurnames collection with persons from mainCollection that have 'ov' and 'in' surname suffix
		System.out.println("//3 Fill ukranianSurnames collection with persons from mainCollection that have 'ilko' and 'enko' surname suffix\n" + "//4 Fill russianSurnames collection with persons from mainCollection that have 'ov' and 'in' surname suffix");
		String surname;
		for (Person person : mainCollection) {
			surname = person.getSurname();
			if (surname.endsWith("ilko") || surname.endsWith("enko")) {
				ukranianSurnames.add(person);
			}
			if (surname.endsWith("ov") || surname.endsWith("in")) {
				russianSurnames.add(new Person(person.getName(), person.getSurname()));
			}
		}
		System.out.println(ukranianSurnames);
		System.out.println(russianSurnames);

//5 All collections should be sorted from A to Z by surname AND name (if there is 3 brothers they should be sorted by name)
		System.out.println("//5 All collections should be sorted from A to Z by surname AND name (if there is 3 brothers they should be sorted by name)");
		Collections.sort(ukranianSurnames, Comparator.comparing(Person::getSurname).thenComparing(Person::getName));
		System.out.println(ukranianSurnames);

		Collections.sort(russianSurnames, Comparator.comparing(Person::getSurname).thenComparing(Person::getName));
		System.out.println(russianSurnames);

//6 Output all elements from ukranianSurnames with prefix 'Pan'. I.e. 'Pan Oleksandr Tereshenko'
//7 Output all elements from russianSurnames with prefix 'Tovarisch'. I.e. 'Tovarisch Ivan Kovalov'surname
		System.out.println("//6 Output all elements from ukranianSurnames with prefix 'Pan'. I.e. 'Pan Oleksandr Tereshenko'\n" + "//7 Output all elements from russianSurnames with prefix 'Tovarisch'. I.e. 'Tovarisch Ivan Kovalov'surname");
		printSurnames(russianSurnames, ukranianSurnames);
	}

	private static void printSurnames(List<Person> russianSurnames, List<Person> ukranianSurnames) {
		for (Person person : ukranianSurnames) {
			System.out.println("Pan " + person.getName() + " " + person.getSurname());
		}

		for (Person person : russianSurnames) {
			System.out.println("Tovarisch " + person.getName() + " " + person.getSurname());

		}
	}
}

