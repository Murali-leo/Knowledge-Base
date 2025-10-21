package main.java.exception;

import java.io.IOException;

public class Main {

    public void message() {
        Parent p = new Parent();
        try{
            p.display();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
