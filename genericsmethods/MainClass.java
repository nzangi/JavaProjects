package genericsmethods;

import java.util.ArrayList;

public class MainClass {
    public static  void main(String[] args) {
        ArrayList<?> strings = new ArrayList<>();
//        strings.add("X");
//        strings.add("Y");
//        strings.add("Z");
//        strings.add("A");
//        shout(strings);

        ArrayList<?> integers = new ArrayList<>();
//        integers.add(1);

        ArrayList<?> arrayListIntegers = shout(integers);
        System.out.println("Started Printing");

        for (Object arrayList:arrayListIntegers){
            System.out.println(arrayList);
        }
        System.out.println("Done Printing");



    }
    public static <T> ArrayList<T>  shout(ArrayList<T> arrayLists){
        arrayLists.add((T) Integer.valueOf(1));
        arrayLists.add((T) "weeeeh");
        arrayLists.add((T) Integer.valueOf(3));

//        for (T arrayList:arrayLists){
//            System.out.println(arrayList);
//        }
        System.out.println("Returned ArrayList");
        return arrayLists;
    }
}
