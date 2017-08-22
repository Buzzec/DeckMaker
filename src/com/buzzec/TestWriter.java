package com.buzzec;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestWriter {
    public static void main(String[] args){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
            fw = new FileWriter("test\\test1", true);
            bw = new BufferedWriter(fw);
            for(int x = 0; x < 50; x++){
                bw.write("Card " + x + "/This is card " + x + "/" + x + "\n");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(bw != null){
                    bw.close();
                }
                if(fw != null){
                    fw.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
