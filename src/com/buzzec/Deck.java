package com.buzzec;

import java.io.*;
import java.util.*;

public class Deck {
    private String name;
    private ArrayList<Card> deck;
    
    public Deck(String name, ArrayList<Card> deck){
        this.name = name;
        this.deck = deck;
    }
    public Deck(String name){
        this(name, new ArrayList<>());
    }
    public Deck(String name, String filename){
        this(name, new ArrayList<>());
        makeDeck(filename);
    }

    public void makeDeck(String filename){
        String line;
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String split = br.readLine();
            while((line = br.readLine()) != null){
                String[] splitLine = line.split(split);
                //Print deck for testing
                
                for(String x:splitLine){
                    System.out.print(x + "_");
                }
                System.out.println();
                
                deck.add(new Card(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2])));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }
    public Card draw(){
        return draw(0);
    }
    public Card draw(int x){
        return deck.remove(x);
    }
    public Card peek(){
        return deck.get(0);
    }
    public Card get(int x){
        return deck.get(x);
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        for(Card x : deck){
            output.append(x.toString());
            output.append("\n");
        }
        return output.toString();
    }
}
