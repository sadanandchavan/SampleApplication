package com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class JavaProgram4 {

	public static void main(String[] args) {
		JavaProgram4 jp =new JavaProgram4();
		jp.compaire();

	}

	private void compaire() {
		Comparator<Developer> byName = new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};


		Comparator<Developer> byName2 =
				(Developer o1, Developer o2) -> o1.getName().compareTo(o2.getName());



	}

	public void stream() {

		List <People> people = Arrays.asList(
				new People("Mahes", 35),
				new People("sanjay", 32),
				new People("rajkumar", 60)
				);


		List<String> names =
				people.stream()
				.filter(p -> p.getAge() > 21)
				.map(p -> p.getName())
				.sorted((n1,n2) -> n1.compareToIgnoreCase(n2))
				.collect(Collectors.toList());

		//It would be:
		/*
		List<String> names2 =
				people.stream()
				.filter(new Predicate<Person>() {
					@Override
					public boolean test(Person p) {
						return p.getAge() > 21;
					}
				})
				.map(new Function<Person,String>() {
					@Override
					public String apply(Person p) {
						return p.getName();
					}
				})
				.sorted(new Comparator<String>() {
					@Override
					public int compare(String n1, String n2) {
						return n1.compareToIgnoreCase(n2);
					}
				})
				.collect(Collectors.toList());
		 */
	}
	
	void iteration() {
		
		
		List <Integer> numbers= Arrays.asList(1,4,6,7,4,3,2,17);
		
		numbers.forEach((Integer value) -> System.out.println(value));
		
		numbers.forEach(System.out::println);
		
		
		numbers.forEach(new Consumer<Integer>() {
		    public void accept(Integer value) {
		        System.out.println(value);
		    }
		});
	}
}
