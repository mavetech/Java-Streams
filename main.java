import java.lang.String;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.nio.file.*;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException{
		
		// 1. Integer Stream
		IntStream
		    .range(1,10)
		    .forEach(System.out::print);
	    System.out.println();
	    
		// 2. Integer Stream with skip
		IntStream
		    .range(1,10)
		    .skip(5)
		    .forEach(x -> System.out.println(x));
	    System.out.println();
	    
		// 3. Integer Stream with sum
		System.out.println(
		IntStream
		    .range(1,10)
	        .sum());
	    System.out.println();
	    
		// 4. Stream of sorted and findFirst
		// stream strings, int, float or objects
		Stream.of("Ava", "Aneri", "Alberto")
		    .sorted()
		    .findFirst()
		    .ifPresent(System.out::println);
	    System.out.println();
        
        // 5. Stream from Array, sort, filter and print
	    String[] names = {"AI", "Ankit", "Kushal", "Brent", "Sarika"};
		Stream.of(names)
		    .filter(x->x.startsWith("S"))
		    .sorted()
            .forEach(System.out::println);
	    
		Arrays.stream(names)
		    .filter(x->x.startsWith("B"))
		    .sorted()
            .forEach(System.out::println);
	    
	    // 6. average of squares of an int array
        Arrays.stream(new int[] {2,4,6,8,10})
            .map(x -> x*x)
            .average()
            .ifPresent(System.out::println);
    	    
    	// 7. Stream from List, filter and print
    	List<String> people = Arrays.asList("AI", "Ankit", "Kushal", "Brent", "Sarika");
		people
		    .stream()
		    .map(String::toLowerCase)
		    .filter(x -> x.startsWith("a"))
		    .forEach(System.out::println);
		    
        // 8. Stream rows from text file, sort, filter and print
        Stream<String> bands = Files.lines(Paths.get("bands.txt"));
        bands
            .sorted()
            .filter(x -> x.length() > 13)
            .forEach(System.out::println);
        bands.close();
        
        
        // 9. Stream rows from text file and save to list
        List<String> bands2 = Files.lines(Paths.get("bands.txt"))
            .filter(x -> x.contains("jit"))
            .collect(Collectors.toList());
        bands2.forEach(x->System.out.println(x));
		
	}
}
