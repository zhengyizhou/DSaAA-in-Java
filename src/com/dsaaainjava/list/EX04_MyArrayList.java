package com.dsaaainjava.list;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 写一个类,实现util.ArrayList的类似功能
 * Created by mather on 2016/11/9.
 */
public class EX04_MyArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private T[] theItems;

    //默认的构造函数,new时清空此表
    public EX04_MyArrayList(){
        clean();
    }

    //清空表
    public void clean(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    //返回表的长度
    public int size(){
        return theSize;
    }

    //判断是否为空表
    public boolean isEmpty(){
        return size() == 0;
    }

    //删除表中空位置
    public void trimToSize(){
        ensureCapacity(size());
    }

    //实现get(index)
    public T get(int idx){
        if(idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }

    //实现set
    public T set(int idx, T newVal){
        if(idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException();
        T oldVal = theItems[idx];
        theItems[idx] = newVal;
        return oldVal;
    }

    //用来扩充数组容量,或者收缩数组(当newCapacity==size()时)
    public void ensureCapacity(int newCapacity){
        if(newCapacity <  size()) return;
        T[] old = theItems;

        theItems = (T[]) new Object[newCapacity];

        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    //在尾端添加元素
    public boolean add(T newVal){
        add(size(),newVal);
        return true;
    }

    //在指定的位置添加元素
    public void add(int idx, T newVal){
        if(idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        if(theSize == theItems.length){
            ensureCapacity(theSize * 2 + 1);
        }
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i-1];
        }
        theItems[idx] = newVal;
        theSize++;
    }

    //在指定的位置删除元素
    public T remove(int idx){
        if(idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException();
        T oldVal = theItems[idx];
        for(int i = idx; i < size() - 1; i++){
            theItems[i] = theItems[i+1];
        }
        theSize--;
        return oldVal;
    }

    public Iterator<T> iterator(){
        return new ArrayListIterator();
    }

    //用内部类来实现Iterator迭代器
    private class ArrayListIterator implements Iterator<T>{
        private int current = 0;
        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new ArrayIndexOutOfBoundsException();
            return theItems[current++];
        }

        @Override
        public void remove() {
            EX04_MyArrayList.this.remove(--current);
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {

        }
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
