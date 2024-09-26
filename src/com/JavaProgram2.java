/**
 * @author sadanandchavan
 *
 * 2024-09-26 9:53:53 pm	
 */
package com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 */
public class JavaProgram2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.out.println("Application Start.");

		JavaProgram2 jp = new JavaProgram2();
		List <String> list = Arrays.asList("JAVA", "SPRING","JSON","XML","BEAN","JAVA","XML", "4BOOK");
		List <Integer> number = Arrays.asList(2,5,7,14,99,38,89,23,16,3,999,999);
		List <Integer> number2 = Arrays.asList(2,999);

		System.out.println("Remove duplicate element Start...");
		jp.removeDuplicate(list);
		System.out.println("Remove duplicate element End...");



		System.out.println("Frequency of element Start...");
		jp.getFrequencyOfElement(list);
		System.out.println("Frequency of element End...");


		jp.sortNumber(number);

		jp.getMaxOrMinNumber(number);

		int[] a = new int[] {4, 2, 7, 1};

		int[] b = new int[] {8, 3, 9, 5};
		jp.MergeArray(a,b);


		jp.getMaxMinFirstThree(number);
		
		jp.getSecondHighest(number);
		
		jp.getCommonelement(number,number2);
		
		String msg ="Public static void main";
		jp.reverseWordInString(msg);

		//jp.checkPalindrome("sada");

		//jp.removeDuplicate(number);

		//jp.getInteger(number);

		//jp.numberstartWith(number);

		//jp.totalnumber(number);
		System.out.println("Odd Even Start...");
		//jp.sortOddEvenNumber(number);
		System.out.println("Odd Even Start...");

	}




	/**
	 * @param msg
	 */
	private void reverseWordInString(String msg) {
		
	List <StringBuffer> lsitList=	Arrays.stream(msg.split(" ")).map(word->new StringBuffer(word).reverse()).collect(Collectors.toList());
		System.out.println("reverse each world "+lsitList);
	}



	/**
	 * @param number
	 * @param number2
	 */
	private void getCommonelement(List<Integer> number, List<Integer> number2) {
		
		List<Integer> list= number.stream().filter(number2::contains).collect(Collectors.toList());
		System.out.println("Common element"+list);
		
	}


	/**
	 * @param number
	 */
	private void getSecondHighest(List<Integer> number) {
		System.out.println("Second highest " +number.stream().sorted(Comparator.naturalOrder()).skip(1).collect(Collectors.toList()).get(0));
		
	}






	/**
	 * @param number
	 */
	private void getMaxMinFirstThree(List<Integer> number) {

		List<Integer> list= number.stream().sorted(Comparator.naturalOrder()).limit(3).collect(Collectors.toList());

		System.out.println("Min 3 "+list);

		List<Integer> list2= number.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());

		System.out.println("Max 3 "+list2);

	}






	/**
	 * @param a
	 * @param b
	 */
	private void MergeArray(int[] a, int[] b) {
		int[] c =IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
		System.out.println(Arrays.toString(c));

	}






	/**
	 * @param number
	 */
	private void getMaxOrMinNumber(List<Integer> number) {
		System.out.println("Max number: "+number.stream().max(Comparator.naturalOrder()));
		System.out.println("Min number: "+number.stream().min(Comparator.naturalOrder()));

	}

	/**
	 * @param number
	 */
	private void sortNumber(List<Integer> number) {
		List<Integer> list= number.stream().sorted((number1,number2)->number1.compareTo(number2)).collect(Collectors.toList());
		System.out.println("Sort number output : "+list);
		List<Integer> list2= number.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		System.out.println("Sort number output : "+list2);
		List<Integer> list3= number.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("Sort reverser number output : "+list3);
	}

	/**
	 * @param list
	 */
	private void getFrequencyOfElement(List<String> list) {
		Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

		System.out.println("Frequency of element "+map);
	}

	/**
	 * @param list
	 */
	private void removeDuplicate(List<String> list) {


		List<String> list2=	list.stream().distinct().collect(Collectors.toList());
		System.out.println("Remove duplicate output "+list2);
		/*
		for (String obj : list2) {
			System.out.print("Remove duplicate output "+obj.toString()+",");
		}
		 */
		Set<String> set=list.stream().collect(Collectors.toSet());
		System.out.println("Remove duplicate output set"+set);


		//list.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
	}

}
