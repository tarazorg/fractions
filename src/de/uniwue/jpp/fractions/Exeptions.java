package de.uniwue.jpp.fractions;

public class Exeptions {
    String a;

    {
        a = "Fraction cannot be 0";
    }

    public Exeptions (int Ex){
       if (Ex == 1 ) {
         return  a;
       }
   }
}
