package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class App {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // Thread th = new Thread(new Runnable() {
        //     public void run() {
        //         for(int i = 0; i < 10; i++)
        //             System.out.println(Thread.currentThread().getName() + " -> " + i);            
        //     }
        // });

        // th.start();

        MyImplementation my1 = new MyImplementation();
        MyImplementation my2 = new MyImplementation();
        MyImplementation my3 = new MyImplementation();
        MyImplementation my4 = new MyImplementation();
        MyImplementation my5 = new MyImplementation();

        // Execute tasks using single thread
        // ExecutorService es = Executors.newSingleThreadExecutor();
        // es.execute(my1);
        // es.execute(my2);
        // es.shutdown();

        // Execyte tasks using fixed thread pool
        // ExecutorService es2 = Executors.newFixedThreadPool(5);
        // es2.execute(my1);
        // es2.execute(my2);
        // es2.execute(my3);
        // es2.execute(my4);
        // es2.execute(my5);
        // es2.shutdown();

        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Apple iPad", "Apple tablet", "computer"));
        products.add(new Product(2L, "Apple MacBook Pro", "Apple laptop", "computer"));
        products.add(new Product(3L, "Logitech Mouse", "Mouse", "computer"));
        products.add(new Product(4L, "32 inch monitor", "Samsung monitor", "computer"));
        products.add(new Product(5L, "Huawei 5", "Huawei phone", "mobile"));
        products.add(new Product(6L, "Pixel 6", "Pixel phone", "mobile"));
        products.add(new Product(7L, "Huawei 6", "Huawei phone", "mobile"));
        products.add(new Product(8L, "Huawei 7", "Huawei phone", "mobile"));

        // Print products
        products.forEach(prod -> System.out.println(prod));
        // Print products (alt mtd) using fn declared in class
        // products.forEach(Product::print);

        // Retrieve products with category "mobile"
        List<Product> mobileProducts = products.stream()
                                        .filter(prod -> prod.getCategory().equals("mobile"))
                                        .collect(Collectors.toList());
                          
        System.out.println("Mobile products:");
        mobileProducts.forEach(Product::print);


        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1L, "Bob", "Tan", 6000, new Date(1995, 5, 17)));
        persons.add(new Person(2L, "Ali", "Baba", 9000, new Date(1965, 2, 12)));
        persons.add(new Person(3L, "John", "Doe", 5000, new Date(1988, 6, 3)));
        persons.add(new Person(4L, "Jill", "Doe", 4500, new Date(1990, 1, 13)));
        persons.add(new Person(5L, "Rick", "Alan", 3200, new Date(1951, 8, 1)));
        persons.add(new Person(6L, "Darren", "Ng", 4420, new Date(1991, 11, 10)));
        persons.add(new Person(7L, "Raj", "Abc", 6200, new Date(1955, 5, 30)));
        persons.add(new Person(8L, "Mary", "Tan", 5555, new Date(1990, 12, 4)));
        persons.add(new Person(9L, "Mary", "Ng", 3210, new Date(1989, 4, 14)));

        // Compare and sort using firstName
        Comparator<Person> compare = Comparator.comparing(p -> p.getFirstName());
        persons.sort(compare);                  // sort A-Z
        //persons.sort(compare.reversed());     // sort Z-A (reversed order)

        System.out.println("Printing persons list sorted by first name:");
        persons.forEach(p -> {
            System.out.println(p.toString());
        });

        // Compare and sort using firstName & lastName
        Comparator<Person> compareMulti = Comparator.comparing(Person::getFirstName)
                                            .thenComparing(Person::getLastName);
        persons.sort(compareMulti);

        System.out.println("Printing persons list sorted by first name & last name:");
        persons.forEach( p -> System.out.println(p.toString()) );
    }
}
