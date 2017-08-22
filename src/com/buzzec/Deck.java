package com.buzzec;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private String name;
    private int id;
    private ArrayList<Card> deck;

    private static int idTracker = 0;

    public Deck(String name, int id, ArrayList<Card> deck){
        this.name = name;
        this.id = id;
        this.deck = deck;
    }
    public Deck(String name, ArrayList<Card> deck){
        this(name, idTracker++, deck);
    }
    public Deck(String name, int id){
        this(name, id, new ArrayList<>());
    }
    public Deck(String name){
        this(name, idTracker++);
    }
    public Deck(String name, int id, String filename){
        this(name, id, new ArrayList<>());
        makeDeck(filename);
    }
    public Deck(String name, String filename){
        this(name, idTracker++, filename);
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
        return deck.remove(0);
    }
    public Card peek(){
        return deck.get(0);
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
