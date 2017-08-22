package com.buzzec;

public class Card {
    private String name;
    private String text;
    private int id;

    public Card(String name, String text, int id){
        this.name = name;
        this.text = text;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public String getText() {
        return text;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return name + ": " + text;
    }
}
