package main.java.exception;

import java.io.FileReader;
import java.io.IOException;

public class Parent {
    public int msg() {
        int x = 1;
        try {
            x = x + 1;
            System.out.println("Try Block" + x);
            return x;
        } catch (Exception e) {
            System.out.println("Parent");
        } finally {
            x = x + 1;
            System.out.println("Finally Block" + x);
        }
        return x;
    }

    public static void main(String[] args) {
        // System.out.println(new Parent().msg());

        int i = 20;
        int j = 10;

        try {
            j = i / 100;
            if(j == 0) {
                throw new CustomException("We are throwing Custom Exception");
            }
        } catch(CustomException ex) {
            System.out.println("The value of the j shouldn't be zero \n" + ex);
        }
    }

    public void display() throws IOException {
        FileReader fr = new FileReader("file.txt");
        fr.close();
    }
}
