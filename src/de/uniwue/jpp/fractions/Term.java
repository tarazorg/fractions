package de.uniwue.jpp.fractions;

public class Term implements Element{
    
	private String inputString;
	
	public Term(){    
    }

    public Term(String term){
    	inputString = term;

    }
    
    @Override
    public boolean equals(Object obj) {
    	if(obj instanceof Term) {
    		Term t = (Term) obj;
    		if(t.inputString.equals(inputString)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    @Override
    public String toString() {
    	return inputString;
    }

	@Override
	public int width() {
		return inputString.length();
	}

	@Override
	public int lineCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
