package de.uniwue.jpp.fractions;

public class Parser {
    public static Element parse(String input){


        return null;
    }
    
    public static void main(String[]args) {
    	String test = "test";
    	System.out.println("l"+rPad(test, 5)+"l");
    	System.out.println("l"+lPad(test, 5)+"l");
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
