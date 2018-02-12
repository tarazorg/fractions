package de.uniwue.jpp.fractions;

public class Parser {
    public static Element parse(String input){
    	int openCounter = 0;
    	String zaehler = "";
    	String nenner = "";
    	int closeCounter = 0;
    	//Regel 1 -> trim
    	char[] chars = input.trim().toCharArray();
    	
    	for(int i=0; i<chars.length; i++) {
    		char currentChar = chars[i];
    		if(currentChar == '(') {
    			openCounter++;
    		}else if (currentChar == ')') {
    			closeCounter++;
    				//Regel 2
    		}else if (currentChar == '/' && openCounter==closeCounter && i != 0) {
    			zaehler = (String) input.subSequence(0, i-1);
    			nenner = (String) input.subSequence(i+1, chars.length);
    			System.out.println("Zähler: "+zaehler);
    			System.out.println("Nenner: "+nenner);
    		}
    	}
    	
        return null;
    }
    
    public static void main(String[]args) {
    	String test = "sin(x) + (1/x) / x + 7";
    	String test2 = "1 / ((3 / x) * (y / 5) + ((2 / x) / y))";
    	parse(test2);
    }
    
    
    
    public static String rPad(String s, int padding) {
    	StringBuilder rpadBuilder = new StringBuilder();
    	rpadBuilder.append(s);
    	for(int i=0; i<padding; i++) {
    		rpadBuilder.append(" ");
    	}
    	return rpadBuilder.toString();
    }
    
    public static String lPad(String s, int padding) {
    	StringBuilder lpadBuilder = new StringBuilder();
    	for(int i=0; i<padding; i++) {
    		lpadBuilder.append(" ");
    	}
    	lpadBuilder.append(s);
    	return lpadBuilder.toString();
    }
    
    public static String padRight(String s, int i) {
        return String.format("%1$-" + i + "s", s);  
   }

   public static String padLeft(String s, int i) {
       return String.format("%1$" + i + "s", s);  
   }

}
