import java.util.stream.Collectors;
import java.util.*;
import java.util.function.*;

public class ExerciciosStreamApi {

    public static Collection<String> numerosAleatoriosInteger;

    public static void main(String[] args) {
        List<String> numerosAleatorios = //é criada uma arrayList
             Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima todos os elementos da lista de String: ");
        numerosAleatorios.stream().forEach(t -> System.out.println(t));
        //o metodo stream devolve a corrente de objetos 

        System.out.println("Pegue os 5 primeiros numeros e coloque dentro de um set: ");
        numerosAleatorios.stream()
        .limit(5) //impoe uma quantidade max de elementos a serem devolvidos
        .collect(Collectors.toSet()) // "coleta" os objetos para levar para dentro de um set
        .forEach(System.out::println);//faz a impressão de cada objeto da lista 

        System.out.println("Transforme essa lista de String em uma de numeros inteiros:");
        numerosAleatorios.stream()
        .map(s -> Integer.parseInt(s)) //trasnforma stream em integer
        .collect(Collectors.toList()) //"coleta" os objetos e os transforma em lista
        .forEach(System.out::println);//faz a impressão de cada objeto da lista 

        System.out.println("Pegue os numeros pares e maiores que 2 e coloque em uma lista: ");
        numerosAleatorios.stream()
        .map(Integer::parseInt) //converte os objetos 
        .filter(i -> i % 2 == 0 && i > 2 )//filtra todos objetos que são pares e maiores que 2
        .collect(Collectors.toList()) // "coleta" esses objetos e os coloca em uma lista 
        .forEach(System.out::println); //faz a impressão de cada objeto da lista 
        
        System.out.println("Mostre a média dos numeros: ");
        //numerosAleatorios1.stream()
        //.average()
        //.ifPresent(System.out::println);
        numerosAleatorios.stream()
        .mapToInt(Integer::parseInt) //retorna uma nova stream de numeros inteiros 
        .average() //retorna um double contendo a média dos numeros inteiros 
        .ifPresent(System.out::println); //imprime se existir um valor 

        List<Integer> numerosAleatoriosIntegers = numerosAleatorios.stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
        System.out.println("Remova os valores ímpares: ");
        numerosAleatoriosIntegers.removeIf(integer -> (integer % 2 !=0));
        System.out.println(numerosAleatoriosIntegers);
        
        
        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
        numerosAleatorios.stream()
        .skip(3)
        .forEach(System.out::println);
        
        long countNumerosUnicos = numerosAleatorios.stream()
                .distinct() //remove elementos duplicados
                .count(); //conta o numero de elementos 
        System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);
        
        System.out.println("Mostre o menor valor da lista: ");
        numerosAleatorios.stream() //retorna a corrente de objetos 
        .mapToInt(Integer::parseInt) //trasnforma um map em int 
        .min() //retorne o menor elemento 
        .ifPresent(System.out::println); //imprime se existir um valor 

        System.out.println("Mostre o maior valor da lista: ");
        numerosAleatorios.stream()
        .mapToInt(Integer::parseInt)
        .max()
        .ifPresent(System.out::println);



    }
}
