package com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * Date: SEP 27, 2024
 * Time: 02:31:00 PM
 * @author Sadanand Chavan
 * @version 1.0
 */
public class JavaProgram3 {

	public static void main(String[] args) {

		JavaProgram3 jp = new JavaProgram3();

		//Find the longest string in a list of strings using Java streams:
		List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "grapefruit");
		jp.findLongestString(strings);


		//Calculate the average age of a list of Person objects using Java streams:
		List<Person> persons = Arrays.asList(
				new Person("Alice", 25),
				new Person("Bob", 30),
				new Person("Charlie", 35)
				);
		jp.averageAge(persons);

		//Find the kth smallest element in an array using Java streams:
		jp.getElement(strings,3);

		//partition a list into two groups based on a predicate using Java streams:
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		jp.getGroup(numbers);

		//Find the intersection of two lists using Java streams:
		List <Integer> list1= Arrays.asList(1,4,6,7,4,3,2,17);
		List <Integer> list2 =Arrays.asList(12,13,17,11,74,55);
		jp.getIntersection(list1,list2);

		jp.groupBy(strings);



	}

	private void groupBy(List<String> strings) {
		Map<Integer, Long> map = strings.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println("Group by "+map);

		Map<String, Long> map2 = strings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Group by "+map2);
		
		Map<String, Long> map3 = strings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Group by "+map2);

	}

	private void getIntersection(List<Integer> list1, List<Integer> list2) {
		List<Integer> intersection =list1.stream().
				filter(list2::contains).
				collect(Collectors.toList());
		System.out.println("Insertion output =" +intersection);	
	}

	private void getGroup(List<Integer> numbers) {
		Map<Boolean, List<Integer>> map =numbers.stream()
				.collect(Collectors.partitioningBy(n->n%2==0));
		List <Integer> even= map.get(true);
		List <Integer> odd= map.get(false);
		System.out.println("Even "+even);
		System.out.println("ODD "+odd);
	}

	private void getElement(List<String> strings, int postion) {
		System.out.println("element at "+strings.stream()
		.skip(postion-1)
		.findFirst());
	}

	private void findLongestString(List<String> strings) {
		Optional<String> str=strings.stream()
				.max(Comparator.comparingInt(String::length));
		System.out.println("LongestString "+str);
	}

	private void averageAge(List<Person> list) {

		OptionalDouble opt=	list.stream()
				.mapToInt(Person::getAge).average();
		System.out.println(opt);
	}


}
