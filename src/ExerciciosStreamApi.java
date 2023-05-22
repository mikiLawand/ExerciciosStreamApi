import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.*;

public class ExerciciosStreamApi {

    public static void main(String[] args) {
        List<String> numerosAleatorios = //é criada uma arrayList
             Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima todos os elementos da lista de String: ");
        numerosAleatorios.stream().forEach(t -> System.out.println(t));
        //o metodo stream devolve a corrente de objetos 

        System.out.println("Pegue os 5 primeiros numeros e coloque dentro de um set: ");
        numerosAleatorios.stream()
        .limit(5)
        .collect(Collectors.toSet())
        .forEach(System.out::println);

        System.out.println("Transforme essa lista de String em uma de numeros inteiros:");
        numerosAleatorios.stream()
        .map(s -> Integer.parseInt(s)) //trasnforma stream em integer
        .collect(Collectors.toList())
        .forEach(System.out::println);

        System.out.println("Pegue os numeros pares e maiores que 2 e coloque em uma lista: ");
        numerosAleatorios.stream()
        .map(Integer::parseInt)
        .filter(i -> i % 2 == 0 && i > 2 )
        .collect(Collectors.toList())
        .forEach(System.out::println);
        
        System.out.println("Mostre a média dos numeros: ");
        //numerosAleatorios1.stream()
        //.average()
        //.ifPresent(System.out::println);
        numerosAleatorios.stream()
        .mapToInt(Integer::parseInt)
        .average()
        .ifPresent(System.out::println);

        System.out.println("Remova os valores ímpares: ");
        numerosAleatorios.removeIf(i -> (i % 2 != 0));
      System.out.println(numerosAleatorios);


            
        
    }
}
