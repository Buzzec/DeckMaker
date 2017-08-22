package com.buzzec;

public class Tester{
    public static void main(String[] args){
        Deck test = new Deck("fun", "test\\test1");
        test.shuffle();
        System.out.println("Draw: " + test.draw());
        System.out.println("Peek: " + test.peek() + "\n");
        System.out.println(test);
    }
}
