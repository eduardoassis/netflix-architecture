package com.in28minutes.microservices;


import com.google.common.primitives.Ints;
import com.in28minutes.microservices.testes.BankNotification;
import com.in28minutes.microservices.testes.models.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
public class LimitsServiceApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
//		SpringApplication.run(LimitsServiceApplication.class, args);

//		int size = 3;
//
//		LinkedCache<Long> cache = LinkedCache.getNewInstance(size);
//
//		cache.add(1l, new Cache<String>("4"));
//		cache.print();
//
//		TimeUnit.SECONDS.sleep(1);
//
//		System.out.println();
//		cache.add(2l, new Cache<String>("2"));
//		cache.print();
//
//		TimeUnit.SECONDS.sleep(15);
//		System.out.println();
//		cache.add(3l, new Cache<String>("3"));
//		cache.print();
//
//		TimeUnit.SECONDS.sleep(25);
//		System.out.println();
//		cache.add(4l, new Cache<String>("1"));
//		cache.print();
//
//		int[] a = new int[] {4, 2, 3, 1};
//		countSwaps(a);

//		Dog aDog = new Dog("Max");
//		Dog oldDog = aDog;
//
//		// we pass the object to foo
//		foo(aDog);
//		// aDog variable is still pointing to the "Max" dog when foo(...) returns
//		aDog.getName().equals("Max"); // true
//		aDog.getName().equals("Fifi"); // false
//		System.out.println(aDog == oldDog); // true
//
//		Player[] players = new Player[]{
//			new Player("amy", 100),
//			new Player("david", 100),
//			new Player("heraldo", 50),
//			new Player("aakansha", 150),
//			new Player("aleksa", 150)
//		};
//		Arrays.sort(players, (o1, o2) -> {
//			return o1.getScore() == o2.getScore()
//					? o1.getName().compareTo(o2.getName())
//					: Integer.valueOf(o2.getScore()).compareTo(o1.getScore());
//		});
//		Arrays.asList(players).forEach(player -> System.out.println(player.getName() + " " + player.getScore()));

//		int[] array = new int[]{1, 3, 4, 5,3, 1};//read(200000l);
////		2, 3, 4, 2, 3, 6, 8, 4, 5
////		2, 2, 3, 3, 4, 4, 5, 6, 8
//		// [0, 0, 2, 2, 1, 1, 1, 0, 8]
//
//		int result = BankNotification.activityNotifications(array, 4/*10000*/);

//		Instant start = Instant.now();
//		int[] array = read(200000l);
//		Arrays.parallelSort(array);
//		Instant finish = Instant.now();
//		long timeElapsed = Duration.between(start, finish).toMillis();
//		System.out.println("Collection sort: " + timeElapsed);

//		int[] array2 = new int[]{5, 1, 3, 4, 2, 1};
//		start = Instant.now();
//		array2 = BankNotification.countingSort(array2, 5);
//		finish = Instant.now();
//		timeElapsed = Duration.between(start, finish).toMillis();
//		System.out.println("Counting sort: " + timeElapsed);

//        whatFlavors(new int[]{1, 4, 5, 3, 2}, 4);
//
//		System.out.println(BankNotification.divisor_sum(6));
//
//		int[][] matriz = new int[6][6];
//		matriz[0][0] = 1;
//		matriz[0][1] = 1;
//		matriz[0][2] = 1;
//		matriz[0][3] = 0;
//		matriz[0][4] = 0;
//		matriz[0][5] = 0;
//		matriz[1][0] = 0;
//		matriz[1][1] = 1;
//		matriz[1][2] = 0;
//		matriz[1][3] = 0;
//		matriz[1][4] = 0;
//		matriz[1][5] = 0;
//		matriz[2][0] = 1;
//		matriz[2][1] = 1;
//		matriz[2][2] = 1;
//		matriz[2][3] = 0;
//		matriz[2][4] = 0;
//		matriz[2][5] = 0;
//		matriz[3][0] = 0;
//		matriz[3][1] = 0;
//		matriz[3][2] = 2;
//		matriz[3][3] = 4;
//		matriz[3][4] = 4;
//		matriz[3][5] = 0;
//		matriz[4][0] = 0;
//		matriz[4][1] = 0;
//		matriz[4][2] = 0;
//		matriz[4][3] = 2;
//		matriz[4][4] = 0;
//		matriz[4][5] = 0;
//		matriz[5][0] = 0;
//		matriz[5][1] = 0;
//		matriz[5][2] = 1;
//		matriz[5][3] = 2;
//		matriz[5][4] = 4;
//		matriz[5][5] = 0;
//
//		int result = BankNotification.hourglassSum(matriz);
//		System.out.println(result);

		User userAge40 = new User(40, "Guilherme Silveira", true);
        List<User> users = new ArrayList<>(){{
           add(new User(20, "Paulo Silveira", false));
            add(new User(30, "Rodrigo Turini", false));
			add(userAge40);
			add(userAge40);
        }};

		Double resultado = users.stream().collect(Collectors.averagingInt(User::getAge));
		HashSet<User> set = new HashSet<User>(users);

		Predicate<User> removeAdmin = (u) -> u.isAdmin();
		Predicate<User> removeUnder20 = (User u) -> u.getAge() <= 20;

		System.out.print(removeUnder20.test(new User(15, "Test", true)));

		BinaryOperator<Integer> soma = (a, b) -> a +b;


//
//		users.removeIf(removeAdmin.or(removeUnder20));
//
//        Consumer<User> printAge = (User u) -> System.out.print(u.getAge());
//        Consumer<User> printName = (User u) -> System.out.print(u.getName() + ": ");
//		Consumer<User> printIsAdmin = (User u) -> System.out.println(". Is Admin? " + u.isAdmin());
//
//        users.forEach(printName.andThen(printAge).andThen(printIsAdmin));
//
//
//        Function<User, Optional<User>> userAdmin = (User u) -> {
//            if(u.isAdmin()) {
//                return Optional.of(u);
//            }
//            return Optional.empty();
//        };
//
//        List<Optional<User>> list = users.stream()
//                .map(userAdmin)
//                .collect(Collectors.toList());
//
//        list.forEach(user -> System.out.print(user.get().getName()));
	}

    static void whatFlavors(int[] cost, int money) {

	    Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<cost.length; i++) {
            if(map.containsKey(cost[i])) {
                System.out.println(map.get(cost[i])+" "+(i+1));
                break;
            }
            else if(money-cost[i]>0) {
                map.put(money-cost[i], i+1);
            }
        }
    }


	static int[] read(Long size) throws IOException {
		Resource resource = new ClassPathResource("teste");
        InputStream fstream = resource.getInputStream();
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String data;
        List<Integer> integers = new ArrayList<Integer>();
        while ((data = br.readLine()) != null)   {
            //How can I do what I described above here?
            String[] tmp = data.split(", ");    //Split space
            for(String s: tmp)
                integers.add(Integer.parseInt(s));
        }
        return  Ints.toArray(integers);
    }
	static void foo(Dog d) {
		d.getName().equals("Max"); // true
		// change d inside of foo() to point to a new Dog instance "Fifi"
		d = new Dog("Fifi");
		d.getName().equals("Fifi"); // true
	}
static class Dog {
	private String name;

	public Dog(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
	static void countSwaps(int[] a) {

		int count = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-1; j++) {
				if (a[j] > a[j + 1]) {
					count++;
					swap(a, j, j+1);
				}
			}
		}

		System.out.println(String.format("Array is sorted in %d swaps.", count));
		System.out.println(String.format("First Element: %d", a[0]));
		System.out.println(String.format("Last Element: %d", a[a.length-1]));
	}

	private static void swap(int[] a, int pos1, int pos2) {
		a[pos1] = a[pos1] + a[pos2];
		a[pos2] = a[pos1] - a[pos2];
		a[pos1] = a[pos1] - a[pos2];
	}

}

class LinkedCache<K> {

	private Integer size;
	private LinkedHashMap<K, Cache> linkedHashMap;

	private LinkedCache(Integer size) {
		this.linkedHashMap = new LinkedHashMap<K, Cache>(size);
		this.size = size;
	}

	private boolean hasToRemoveEldestEntry() {
		return this.linkedHashMap.size() >= this.size;
	}

	public void add(K key, Cache value) {
		if (hasToRemoveEldestEntry()) {
			K eldestKey = retrieveEldestEntryKey();
			this.linkedHashMap.remove(eldestKey);
		}
		this.linkedHashMap.put(key, value);
	}

	private K retrieveEldestEntryKey() {
		return this.linkedHashMap
						.entrySet()
						.stream()
						.sorted((o1, o2) -> o1.getValue().getTimestamp().compareTo(o2.getValue().getTimestamp()))
						.findFirst().get().getKey();
	}

	public static <K> LinkedCache<K> getNewInstance(int size) {
		return new LinkedCache<K>(size);
	}

	public void print() {
		this.linkedHashMap.values().stream().forEach(System.out::print);
	}

}

class Cache <T>{

	private Timestamp timestamp;
	private T info;

	public Cache(T info) {
		this.info = info;
		this.timestamp = new Timestamp(System.currentTimeMillis());
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return String.valueOf(info) + " ";
	}
}