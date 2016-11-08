package com.dsaaainjava.list;

import com.dsaaainjava.util.FormatUtil;

import java.util.*;

/**
 * 测试用Iterator作Remove操作时,ArrayList和LinkedList的效率区别
 * Created by mather on 2016/11/8.
 */
public class EX03_TestRemove {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long beginTime = 0;
        long endTime = 0;
        long N  = 100000L;
        long LN = 4000000L;

        for (int i = 0; i < N; i++) {
            arrayList.add(i);
        }

        for (int i = 0; i <LN ; i++) {
            linkedList.add(i);
        }

        beginTime = new Date().getTime();
        System.out.println("ArrayList remove,开始:" + beginTime);
        removeEvensVer(arrayList);
        endTime = new Date().getTime();
        System.out.println("ArrayList remove,结束:" + endTime);
        System.out.println("ArrayList remove " + N + " 条耗时:" + (endTime-beginTime) + " 毫秒.");

        FormatUtil.splitLine();

        beginTime = new Date().getTime();
        System.out.println("LinkedList remove,开始:" + beginTime);
        removeEvensVer(linkedList);
        endTime = new Date().getTime();
        System.out.println("LinkedList remove,结束:" + endTime);
        System.out.println("LinkedList remove " + LN + " 条耗时:" + (endTime-beginTime) + " 毫秒.");

        FormatUtil.splitLine();

        arrayList.clear();
        linkedList.clear();

        N  = 200000L;
        LN = 8000000L;
        for (int i = 0; i < N; i++) {
            arrayList.add(i);
        }

        for (int i = 0; i <LN ; i++) {
            linkedList.add(i);
        }

        beginTime = new Date().getTime();
        System.out.println("ArrayList remove,开始:" + beginTime);
        removeEvensVer(arrayList);
        endTime = new Date().getTime();
        System.out.println("ArrayList remove,结束:" + endTime);
        System.out.println("ArrayList remove " + N + " 条耗时:" + (endTime-beginTime) + " 毫秒.");

        FormatUtil.splitLine();

        beginTime = new Date().getTime();
        System.out.println("LinkedList remove,开始:" + beginTime);
        removeEvensVer(linkedList);
        endTime = new Date().getTime();
        System.out.println("LinkedList remove,结束:" + endTime);
        System.out.println("LinkedList remove " + LN + " 条耗时:" + (endTime-beginTime) + " 毫秒.");

        FormatUtil.splitLine();
    }

    public static void removeEvensVer(List<Integer> list){
        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()){
            if(itr.next() % 2 == 0)
                itr.remove();
        }

    }
}
