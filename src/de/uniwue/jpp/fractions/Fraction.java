package de.uniwue.jpp.fractions;
import static java.lang.System.*;

public class Fraction {
    public Fraction(Element numerator, Element denominator){
        if (numerator.width() == 0 || denominator.width() == 0)
            throw new IllegalArgumentException("Fraction cannot be 0!");

    }

}
