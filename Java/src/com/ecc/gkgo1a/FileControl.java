package com.ecc.gkgo1a;

import java.io.*;

public class FileControl extends IExecutable {

    @Override
    public void Question1() {
        try {
            FileOutputStream fs = new FileOutputStream("output.txt");
            String outputString = "This is the string to output.";
            fs.write(outputString.getBytes());
            fs.close();
            System.out.println("Completed.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Question2() {

    }

    @Override
    public void Question3() {

    }

    @Override
    public void Question4() {

    }
}
