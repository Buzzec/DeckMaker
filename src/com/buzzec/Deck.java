package com.buzzec;

import com.buzzec.loggger.*;

import java.util.*;

public class Deck {
    private String name;
    private ArrayList<Card> deck;
    private Logger logger;
    
    public Deck(String name, ArrayList<Card> deck, Logger logger){
        this.name = name;
        this.deck = deck;
        this.logger = logger;
    }
    public Deck(String name, Logger logger){
        this(name, new ArrayList<>(), logger);
    }
    public Deck(String name, String filename, Logger logger){
        this(name, new ArrayList<>(), logger);
        makeDeck(filename);
    }

    private void makeDeck(String filename){
//        logger.log("makeDeck(" + filename + ")", LogLevel.DEBUG);
        logger.log("Making Deck of file: " + filename, LogLevel.INFO);
        
        ArrayList<AnalyzedLine> file = FileAnalyzer.analyzeFile(filename, logger);

        for(AnalyzedLine x : file){
            deck.add(new Card(x.get(0), x.get(1), Integer.parseInt(x.get(2)), logger));
        }
        
        logger.log("Deck made.", LogLevel.INFO);
    }

    public void shuffle(){
        logger.log("Shuffling Deck", LogLevel.INFO);
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
    protected Deck clone() throws CloneNotSupportedException{
        logger.log("Cloning Deck", LogLevel.INFO);
        ArrayList<Card> deck = new ArrayList<>();
        
        deck.addAll(deck);
        
        return new Deck(name, deck, logger);
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
