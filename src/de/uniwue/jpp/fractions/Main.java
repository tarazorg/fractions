package de.uniwue.jpp.fractions;
import java.util.Scanner;

public  class Main {
    public static void main(String[] args){
        String input;
        System.out.println("Put in your fraction");
        Scanner scanInput = new Scanner(System.in);
        input = scanInput.nextLine();
        scanInput.close();
        Parser.parse(input);

    }
}



