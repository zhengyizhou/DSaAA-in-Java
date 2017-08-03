package com.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * ClassName: com.collection.LinkedListTest
 *
 * @Description:
 * @Author: mather.
 * @Date: 2016/12/24.
 * @Time: 下午8:59.
 */
public class LinkedListTest {


    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        System.out.println(a);
        System.out.println(b);

//        a.addAll(b);
//        System.out.println(a);

        ListIterator aInte = a.listIterator();
        ListIterator bInte = b.listIterator();

        while(bInte.hasNext()){
            if(aInte.hasNext())
                aInte.next();
            aInte.add(bInte.next());
        }

        System.out.println(a);

        bInte = b.listIterator();

        int i = 0;
        while (bInte.hasNext()){

            bInte.next();
            if(i % 2 == 1){
                bInte.remove();
            }
            i++;
        }

        System.out.println(b);

        a.removeAll(b);

        System.out.println(a);
        System.out.println(b);
        System.out.println(a.retainAll(b));
        System.out.println(a);
    }
}
