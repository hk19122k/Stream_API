
public class onepiece {

    public static void main(String[] args) {

        List<String> b = Arrays.asList("Zoro", "Sanji", "Buggy", "Luffy");

        --------------------- STREAM API & Filter() & forEach()-------------------------//

        b.stream() ///converts list to stream
        .filter(n -> !n.equals("Buggy")) ///this is the lambda function that use predicate interface
        .forEach(n -> System.out.println(n)); // this l function uses consumerinterface

        -------------------- MAP() --------------------------------//

        b.stream()
        .filter(n -> !n.equals("Buggy"))
        .map(n -> n + " Haki unlocker") //.map() is used to transform each element in the stream
        .forEach(System.out::println);

        -------------------------Collect()--------------------------//

        List<String> a = b.stream()
        .filter(n -> n.length() > 4)
        .map(n -> n + " mugivara")
        .collect(Collectors.toList()); /// collect is used to convert Stream API that gathers elements from the stream into a data structure

        System.out.println(a);

        ///---------------------Sorted()------------------------//

        List<Integer> l = Arrays.asList(15, 32, 9, 500, 98, 8);
        l.stream()
        .sorted()
        .forEach(System.out::println);

        ---------------------alpabetic sort-------------------------//

        b.stream()
        .sorted(Comparator.comparing(m -> m.toLowerCase())) ///sorted based on alphabetical order
        .forEach(System.out::println);

        ---------------------Advanced sort concepts-------------------------//

        List<Integer> li = Arrays.asList(15, 32, 9, 500, 98, 8);
        li.stream()
        .sorted(Comparator.comparingInt(n -> String.valueOf(n).length())) ///convertthe number value into string and count the digits and retuen based in that .
        .forEach(System.out::println);

        --------------------Reduce() method -------------------------///

        List<Integer> pp = Arrays.asList(150, 320, 900);
        int t = pp.stream()
        .reduce(0, (sum, target) -> sum + target); // it will add the list elements simple
        System.out.println(t);

        ----------------------------Distinct()---------------------------//

        List<String> pi = Arrays.asList("Luffy", "Zoro", "Zoro", "Nami");
        pi.stream()
        .distinct()
        .forEach(System.out::println);

        --------------------limit & skip---------------------------------------------//
      
        List<String> al = Arrays.asList("Luffy", "Zoro", "Sanji", "Nami", "Usopp",  "Chopper");
        System.out.println("First 3 Pirates:");
        al.stream().limit(3).forEach(System.out::println); //// used to limit only 3  values

        al.stream().skip(2).forEach(System.out::println); //used to skip first two values in list

        --------------------------Match()--------------------------------//

        List<String> crew = Arrays.asList("Luffy", "Zoro", "Chopper", "Nami");
        boolean j = crew.stream()
        .anyMatch(n -> n.equals("Nami"));
        System.out.println(j);

        --------------------------Custom Collectors--------------------------------//

        List<String> cp = Arrays.asList("Luffy", "Zoro", "Sanji");
        String r = cp.stream().collect(Collectors.joining(" ! "));
        System.out.println(r);

    }

}
