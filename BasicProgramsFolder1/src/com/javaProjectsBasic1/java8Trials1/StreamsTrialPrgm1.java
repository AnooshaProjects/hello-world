package com.javaProjectsBasic1.java8Trials1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsTrialPrgm1 {

    public static void main(String[] args) {

        //create Stream directly from individual values.
        Stream<Integer> myIntStream = Stream.of(2, 6, 8, 10, 1, 9, 14);

        //myIntStream.forEach(System.out::println);

        //myIntStream.forEach(el -> System.out.print(el+" ") );

        //NOTE: any Stream, once it is used up by any stream calls,
        //it cannot be used to perform any operations on same stream again.
        //so i've to comment out previous Stream calls to make different stream calls and do trials.

/*       myIntStream.forEach( el -> {
                                       System.out.print(el);
                                       System.out.print(" ");
                                     }
        );
*/

        //Stream to array
        Integer[] myIntArrayFromStream = myIntStream.toArray(Integer[]::new);

        //2nd way of array to Stream.
        Integer[] newIntsArray= new Integer[5];
        newIntsArray[0]=1;
        newIntsArray[1]=3;
        newIntsArray[2]=5;
        newIntsArray[3]=7;
        newIntsArray[4]=9;
        Stream<Integer> myNewIntStream= Stream.of(newIntsArray);
        myNewIntStream.forEach(el -> System.out.print(el+" "));
        System.out.println();

        //old Arrays class operations - static methods
        String str = Arrays.toString(myIntArrayFromStream);
        System.out.println(str);

        //NOTE: In below 2 examples, stream(...) is a method on Collection/Array Class!!!!
        //array to Stream
        Stream<Integer> streamFromArray=Arrays.stream(myIntArrayFromStream);
        streamFromArray.forEach(el -> System.out.print(el+" "));

        //array to list to Stream
        System.out.println();
        List<Integer> list=Arrays.asList(myIntArrayFromStream);
        Stream<Integer> streamFromList = list.stream();
        streamFromList.forEach(el -> System.out.print(el+" "));
        //Stream.of(list); ----> NOTE: Cannot create Stream from List object for the list's values; throws error!!


    }

    public void printIntValuesWithSpaceNotAtEnd(){

    }
}
