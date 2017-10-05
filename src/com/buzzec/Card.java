package com.buzzec;

import com.buzzec.loggger.*;

public class Card {
    private String name;
    private String text;
    private int id;
    private Logger logger;

    public Card(String name, String text, int id, Logger logger){
        this.name = name;
        this.text = text;
        this.id = id;
        this.logger = logger;
//        logger.log("Card(" + name + ", " + text + ", " + id + ", " + logger, LogLevel.DEBUG);
    }

    public String getName() {
//        logger.log("getName()", LogLevel.DEBUG);
        return name;
    }
    
    public String getText() {
//        logger.log("getText()", LogLevel.DEBUG);
        return text;
    }
    
    public int getId() {
//        logger.log("getId()",LogLevel.DEBUG);
        return id;
    }

    @Override
    public String toString(){
//        logger.log("toString()", LogLevel.DEBUG);
        return name + ": " + text;
    }
}
