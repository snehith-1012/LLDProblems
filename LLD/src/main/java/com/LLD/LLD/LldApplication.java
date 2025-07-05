package com.LLD.LLD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;


@SpringBootApplication
public class LldApplication {


//	public static int fun(String s1, String s2, int i, int j, List<List<Integer>> l) {
//		if (i == s1.length() || j == s2.length()) {
//			return 0;
//		}
//
//		if (l.get(i).get(j) != -1) {
//			return l.get(i).get(j);
//		}
//		if (s1.charAt(i) == s2.charAt(j)) {
//			int result = 1 + fun(s1, s2, i + 1, j + 1, l);
//			l.get(i).set(j, result);
//			return result;
//		} else {
//			int result = Math.max(fun(s1, s2, i + 1, j, l), fun(s1, s2, i, j + 1, l));
//			l.get(i).set(j, result);
//			return result;
//		}
//	}

	public static void main(String[] args) {
		SpringApplication.run(LldApplication.class, args);

//		String s = "avcrwavrwcz";
//
//		Map<Character,Integer> mp = new TreeMap<>();
//
//		for(int i=0;i<s.length();i++){
//			mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
//		}
//
//		StringBuilder res= new StringBuilder();
//		Character firstOddChar='@';
//		int freq = Integer.MAX_VALUE;
//		for(Character ch: mp.keySet()){
//			if(mp.get(ch)%2==0) {
//				for (int i = 0; i < mp.get(ch)/2; i++) {
//					res.append(ch);
//				}
//			} else {
//				if(firstOddChar!='@') {
//					firstOddChar = ch;
//					freq = mp.get(ch);
//				} else {
//					if(mp.get(ch)< freq){
//						freq = mp.get(ch);
//						firstOddChar = ch;
//					}
//				}
//			}
//		}
//		for(int i=0;i<mp.get(firstOddChar);i++){
//			res.append(firstOddChar);
//		}
//
//		if(res.length()!=s.length()){
//			System.out.println("impossible to frame palindrome with given chars");
//		}
//		int x = res.length();
//		for(int i=x-2;i>=0;i--){
//			res.append(res.charAt(i));
//		}
//		System.out.println(res);
//		String s1 = "snehith";
//		String s2 = "kalyanit";
//
//		List<List<Integer>> l = new ArrayList<>();
//		for(int i=0;i<s1.length();i++){
//			l.add(new ArrayList<>());
//			for(int j=0;j<s2.length();j++){
//				l.get(i).add(-1);
//			}
//		}
//
//		System.out.println(fun(s1,s2,0,0,l));

//		List<AbstractMap.SimpleEntry<Integer, Integer>> l = new ArrayList<>();
//
//		l.add(new AbstractMap.SimpleEntry<>(1,2));
//		l.add(new AbstractMap.SimpleEntry<>(3,4));
//		l.add(new AbstractMap.SimpleEntry<>(5,6));
//
//		Collections.sort(l, (a,b)->{
//			return a.getKey() - b.getKey();
//		});
//
//		l.forEach(System.out::println);
//
//		Collections.sort(l, (a,b)->{
//			return b.getValue() - a.getValue();
//		});
//
//		l.forEach(System.out::println);

//		List<Integer> l = new ArrayList<>();
//		l.add(1);
//		l.add(2);
//		l.add(3);
//		l.add(4);
//		l.add(5);
//
//		Collections.sort(l, (a,b)-> {return a-b;});
//
//		l.forEach(System.out::println);
//
//		Collections.sort(l, (a,b)-> {return b-a;});
//		l.forEach(System.out::println);

//        String s = "42";
//
//        int num = Integer.parseInt(s);
//        System.out.println(num);
//
//        char c = '9';
//
//        int num2 = Character.getNumericValue(c);
//        System.out.println(num2);
//
//        int num3 = c - '0';
//        System.out.println(num3);
//
//        int num4 = 72;
//        int num5 = 5;
//
//        String s1 = String.valueOf(num4);
//
//        Character c1 = String.valueOf(num5).charAt(0);
//
//        String c2 = String.valueOf(num5);
//
//        System.out.println(s1);
//        System.out.println(c1);
//        System.out.println(c2);

//		List<List<Integer>> l =new ArrayList<>();
//		for(int i=0;i<5;i++){
//			l.add(new ArrayList<>(5));
//		}
//
//		Random random = new Random();
//
//		for(int i=0;i<5;i++){
//			for(int j=0;j<5;j++){
//				l.get(i).add(random.nextInt(2));
//			}
//		}

//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				System.out.print(l.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}
//
//		for(int i=0;i<5;i++){
//			for(int j=0;j<5;j++){
//
//			}

//		List<String> l1 = new ArrayList<>();
//		l1.add("sneh");
//		l1.add("kalyani");
//		l1.add("gee");
//		l1.add("odd");
//		l1.add("geetha");
//
//		Collections.sort(l1, (a,b)->{
//			return a.length()-b.length();
//		});
//		System.out.println(l1);
//		Collections.sort(l1, (a,b)->{
//			return b.length()-a.length();
//		});
//		System.out.println(l1);
//
//		Collections.sort(l1,(a,b)->{
//			return a.compareTo(b);
//		});
//		System.out.println(l1);
//		Collections.sort(l1,(a,b)->{
//			return b.compareTo(a);
//		});
//		System.out.println(l1);
//

		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{return b-a;});
		pq.add(1);
		pq.add(2);
		pq.add(3);
		pq.add(4);
		pq.add(5);
		pq.add(6);

		pq.remove(4);
		System.out.println(pq.size());
	}


}
