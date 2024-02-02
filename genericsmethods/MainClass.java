package genericsmethods;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("X");
        strings.add("Y");
        strings.add("Z");
        strings.add("A");
//        shout(strings);

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        ArrayList<?> arrayLists = shout(strings);
        ArrayList<?> arrayListIntegers = shout(integers);


    }
    public static <T> ArrayList<T>  shout(ArrayList<T> arrayLists){
        for (T arrayList:arrayLists){
            System.out.println(arrayList);
        }
        System.out.println("Done Printing");
        return new ArrayList<T>();
    }
}
