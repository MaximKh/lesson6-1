package com.company;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String inFileName = "input.txt";
        String outFileName = "output.txt";
        Stack<String> stack = new Stack<>();
        try{
            BufferedReader inFile = new BufferedReader(new FileReader(new File(inFileName).getAbsoluteFile()));
            try{
                String s;
                while ((s = inFile.readLine()) != null){
                    stack.push(s);
                }
            } finally {
                inFile.close();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        try{
            FileWriter outFile = new FileWriter(new File(outFileName).getAbsoluteFile(), false);
            try{
                while (!stack.isEmpty()){
                    outFile.write(stack.pop());
                    outFile.append('\n');
                }
            } finally {
                outFile.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
