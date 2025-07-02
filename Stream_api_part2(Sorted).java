import java.util.*;

class Employee {
    private String name;
    private double salary;

    // Constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }
}

class Movie {
    private String title;
    private int year;
    private double rating;

    // Constructor
    public Movie(String title, int year, double rating) {
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }
}

class Pirate {
    String name;
    int bounty;

    Pirate(String name, int bounty) {
        this.name = name;
        this.bounty = bounty;
    }

    public String toString() {
        return name + " → " + bounty;
    }
}

public class Onepiece2 {
    public static void main(String[] args) {
        List<Employee> e = List.of(
                new Employee("Zoro", 75),
                new Employee("Sanji", 68),
                new Employee("Luffy", 900));

        ----------------------------one set of sorted and Comparator -----------------------------------------------------//

        e.stream()

        ----------- this is how wwe compare and sort based on employee salary in ascending order --------------//

        .sorted(Comparator.comparing(Employee::getSalary))

        .forEach(f -> System.out.println(f.getName() + ": " + f.getSalary()));

        ----------- this is how wwe compare and sort based on employee salary in descending order --------------//

        e.stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed()) //to use
        reverse

        .forEach(ff -> System.out.println(ff.getName() + ":" + ff.getSalary()));

        --------- real-world multi-level comparator — extremely important for backend, dashboards, and data presentation----------------//

        List<Movie> movies = List.of(
        new Movie("One Piece Film: Z", 2012, 8.0),
        new Movie("One Piece Film: Red", 2022, 7.5),
        new Movie("One Piece Film: Gold", 2016, 7.9));

        movies.stream()
        .sorted(Comparator.comparing(Movie::getYear)
        .thenComparing(Comparator.comparing(Movie::getRating).reversed())) //joining 2 compartors to one and then sorting it
        .forEach(k -> System.out.println(k.getTitle() + " : " + k.getYear() + " : " +
        k.getRating()));

        

        List<Pirate> crew = Arrays.asList(
                new Pirate("Luffy", 1500000000),
                new Pirate("Zoro", 320000000),
                new Pirate("Sanji", 330000000),
                new Pirate("Jinbei", 438000000));

        crew.stream()
                .sorted(Comparator.comparingInt((Pirate p) -> p.bounty).reversed()) /// here we need mention the object name while using lambda explicit type and we dodint use getters here
                .limit(3)
                .forEach(System.out::println);

    }

}
