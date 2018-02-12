package de.uniwue.jpp.fractions;

import java.io.BufferedReader;
import java.io.StringReader;

public class Fraction implements Element{

	private Element numerator;
	private Element denominator;
	private String dash ="";
	private int width;


	public static void main(String[] args) {

		//		Fraction frac = new Fraction(new Term("22"), new Term("4444"));
		//		Fraction frac2 = new Fraction(new Term("2x/4"), new Term("4y/2"));
		Fraction frac = new Fraction(new Fraction(new Term("88"), new Term("44")), new Term("55"));
		Fraction frac2 = new Fraction(new Term("55"), new Fraction(new Term("88"), new Term("1337")));
		Fraction frac3 = new Fraction(new Fraction(new Term("8888888888"), new Term("(44)")), new Fraction(new Term("666666"), new Term("333")));

		System.out.println(frac.toString());
		System.out.println();
		System.out.println(frac2.toString());
		System.out.println();
		System.out.println(frac3.toString());

		//		System.out.println(frac.equals(frac2));
	}

	public Fraction(Element numerator, Element denominator){
		// throw NPE if either argument is null
		if(null == numerator || null == denominator) {
			throw new NullPointerException("Nummerator/Denominator is NULL!");
		}

		//throw IllegalArgumentException if either argument = 0
		if (numerator.width() == 0 ) {
			throw new IllegalArgumentException("Nummerator cannot be 0!");
		}else if( denominator.width() == 0) {
			throw new IllegalArgumentException("Denominator cannot be 0!");
		}


		//set
		this.numerator = numerator;
		this.denominator = denominator;
		this.width= width();

		StringBuilder dashBuilder = new StringBuilder();
		for (int i=0; i<width; i++) {
			dashBuilder.append("-");
		}
		dash = dashBuilder.toString();


	}

	@Override
	public String toString() {
		StringBuilder ausgabe = new StringBuilder();
		String currentLine;

		String[] numeratorString = numerator.toString().split("\n");
		String[] denominatorString = denominator.toString().split("\n");

		//numerator bauen
		for(String s : numeratorString) {
			//delta zur Gesamtbreite
			int delta = dash.length() - s.length();
			//padding wert holen
			int padding = delta/2;
			//delta gerade/ungerade?
			switch (delta%2) {
			//bei geradem delta gleichmäßig padden
			case 0:
				currentLine = s;
				currentLine = Parser.lPad(s, padding);
				currentLine = Parser.rPad(currentLine, padding);
				ausgabe.append(currentLine+"\n");
				currentLine = "";
				break;
				//bei ungeraden delta Fractions regel 3
			case 1:
				currentLine = s;
				currentLine = Parser.rPad(Parser.lPad(currentLine, padding-1), padding);
				ausgabe.append(currentLine+"\n");
				currentLine = "";
				break;
			default:
				ausgabe.append(s+"\n");
				break;
			}
		}
		//bruchstrich
		ausgabe.append(dash+"\n");
		//denominator analog zum numerator
		for(String s : denominatorString) {
			int delta = dash.length() - s.length();
			int padding = delta/2;
			switch (delta%2) {
			case 0:
				currentLine = s;
				currentLine = Parser.lPad(s, padding);
				currentLine = Parser.rPad(currentLine, padding);
				ausgabe.append(currentLine+"\n");
				currentLine = "";
				break;
			case 1:
				currentLine = s;
				currentLine = Parser.rPad(Parser.lPad(currentLine, padding-1), padding);
				ausgabe.append(currentLine+"\n");
				currentLine = "";
				break;
			default:
				ausgabe.append(s+"\n");
				break;
			}
		}
		return ausgabe.toString();
	}



	public Element getNumerator() {
		return numerator;
	}

	public void setNumerator(Element numerator) {
		this.numerator = numerator;
	}

	public Element getDenominator() {
		return denominator;
	}

	public void setDenominator(Element denominator) {
		this.denominator = denominator;
	}


	/*Returns the width of the broadest element + 2
	 * 
	 * */
	@Override
	public int width() {
		return (numerator.width() < denominator.width()) ? (denominator.width()+2) : (numerator.width()+2);
	}

	@Override
	public int lineCount() {
		return numerator.lineCount() + denominator.lineCount() + 1;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Fraction) {
			Fraction frac = (Fraction) obj;
			if(frac.getDenominator().equals(denominator) && frac.getNumerator().equals(numerator)) {
				return true;
			}
		}
		return false;
	}
}

