package com.dsaaainjava.list;

import com.dsaaainjava.util.FormatUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试ArrayList和LinkedList不同插入方式的效率
 * Created by mather on 2016/10/27.
 */
public class EX01_TestInsert {
    public static void main(String[] args) {
        List<Integer> arraylist = new ArrayList<>();
        List<Integer> linkedlist = new LinkedList<>();
        long beginTime = 0;
        long endTime = 0;
        long N = 1000000L;

        //测试尾端插入,N条
        beginTime = new Date().getTime();
        System.out.println("测试ArrayList,开始时间:" + beginTime);
        makeListAtLast(arraylist,N);
        endTime = new Date().getTime();
        System.out.println("测试ArrayList,结束时间:" + endTime);
        System.out.println("测试ArrayList " + N + " 条耗时:" + (endTime-beginTime) + " 毫秒.");

        FormatUtil.splitLine();

        arraylist.clear();
        N *= 10;
        beginTime = new Date().getTime();
        System.out.println("测试ArrayList,开始时间:" + beginTime);
        makeListAtLast(arraylist,N);
        endTime = new Date().getTime();
        System.out.println("测试ArrayList,结束时间:" + endTime);
        System.out.println("测试ArrayList " + N + " 条耗时:" + (endTime-beginTime) + " 毫秒.");

        FormatUtil.splitLine();

        N /= 10;
        beginTime = new Date().getTime();
        System.out.println("测试LinkedList,开始时间:" + beginTime);
        makeListAtLast(linkedlist,N);
        endTime = new Date().getTime();
        System.out.println("测试LinkedList,结束时间:" + endTime);
        System.out.println("测试LinkedList " + N + " 条耗时:" + (endTime-beginTime) + " 毫秒.");

        FormatUtil.splitLine();

        arraylist.clear();
        linkedlist.clear();

        //测试头端插入,(N/10000)条
        N /= 100;
        beginTime = new Date().getTime();
        System.out.println("测试ArrayList头端插入,开始时间:" + beginTime);
        makeListAtFirst(arraylist,N);
        endTime = new Date().getTime();
        System.out.println("测试ArrayList头端插入,结束时间:" + endTime);
        System.out.println("测试ArrayList头端插入 " + N + " 条耗时:" + (endTime-beginTime) + " 毫秒.");

        FormatUtil.splitLine();

        N *= 10;
        arraylist.clear();
        beginTime = new Date().getTime();
        System.out.println("测试ArrayList头端插入,开始时间:" + beginTime);
        makeListAtFirst(arraylist,N);
        endTime = new Date().getTime();
        System.out.println("测试ArrayList头端插入,结束时间:" + endTime);
        System.out.println("测试ArrayList头端插入 " + N + " 条耗时:" + (endTime-beginTime) + " 毫秒.");

        FormatUtil.splitLine();

        N *= 10;
        beginTime = new Date().getTime();
        System.out.println("测试LinkedList头端插入,开始时间:" + beginTime);
        makeListAtFirst(linkedlist,N);
        endTime = new Date().getTime();
        System.out.println("测试LinkedList头端插入,结束时间:" + endTime);
        System.out.println("测试LinkedList头端插入 " + N + " 条耗时:" + (endTime-beginTime) + " 毫秒.");


    }

    /**
     * 每次都在List的尾端插入
     * @param list
     * @param N
     */
    public static void makeListAtLast(List<Integer> list,long N){
        for (int i = 0; i < N ; i++) {
            list.add(i);
        }
    }

    /**
     * 每次都在List的前端插入
     * @param list
     * @param N
     */
    public static void makeListAtFirst(List<Integer> list,long N){
        for (int i = 0; i < N; i++) {
            list.add(0,i);
        }
    }


}/**:

 * 笔记:
 * LinkedList头尾插入效率类似,头端还略低,都是O(1)级的(针对插入1个元素).
 * ArrayList尾端插入效率高,是O(1)级.头端插入是O(N)级,针对初始化全表,则是O(N^2)的,如Output中显示.

*///:~
