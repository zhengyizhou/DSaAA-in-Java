package com.dsaaainjava.list;

import com.dsaaainjava.util.FormatUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试普通的for循环的增强的for循环对两种list读取效率的影响
 * Created by mather on 2016/11/8.
 */
public class EX02_TestFor {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long beginTime = 0;
        long endTime = 0;
        long N = 100000L;

        for (int i = 0; i < N; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        Long sum = 0L;

        beginTime = new Date().getTime();
        System.out.println("ArrayList 普通for,开始:" + beginTime);
        for (int i = 0; i < N; i++) {
            sum += arrayList.get(i);
        }
        endTime = new Date().getTime();
        System.out.println("ArrayList 普通for,结束:" + endTime);
        System.out.println("ArrayList 普通for " + N + " 条求和耗时:" + (endTime-beginTime) + " 毫秒.计算结果:"+sum);

        FormatUtil.splitLine();

        sum = 0L;
        beginTime = new Date().getTime();
        System.out.println("LinkedList 普通for,开始:" + beginTime);
        for (int i = 0; i < N; i++) {
            sum += linkedList.get(i);
        }
        endTime = new Date().getTime();
        System.out.println("LinkedList 普通for,结束:" + endTime);
        System.out.println("LinkedList 普通for " + N + " 条求和耗时:" + (endTime-beginTime) + " 毫秒.计算结果:"+sum);

        FormatUtil.splitLine();

        sum = 0L;
        beginTime = new Date().getTime();
        System.out.println("ArrayList 增强for,开始:" + beginTime);
        for(int i : arrayList){
            sum += i;
        }
        endTime = new Date().getTime();
        System.out.println("ArrayList 增强for,结束:" + endTime);
        System.out.println("ArrayList 增强for " + N + " 条求和耗时:" + (endTime-beginTime) + " 毫秒.计算结果:"+sum);

        FormatUtil.splitLine();

        sum = 0L;
        beginTime = new Date().getTime();
        System.out.println("LinkerList 增强for,开始:" + beginTime);
        for(int i : linkedList){
            sum += i;
        }
        endTime = new Date().getTime();
        System.out.println("LinkerList 增强for,结束:" + endTime);
        System.out.println("LinkerList 增强for " + N + " 条求和耗时:" + (endTime-beginTime) + " 毫秒.计算结果:"+sum);

        FormatUtil.splitLine();

    }
}/**:

 * 笔记:
 * LinkedList中对get的调用为O(N)
 * 但在增强的for循环中,由于使用迭代器,在迭代中一项一项推进,因此读取每一项的效率是O(1).

 *///:~
