// Team MRE -- Derek Lin, Calvin Vuong
// APCS1 pd5
// HW32 -- Irrationality Stops Here
// 2015-11-18

public class Rational{
    //inst vars
    private int numerator;
    private int denominator;

    //main method; test cases
    public static void main(String[] args){

    }

    //default constructor, default 0/1
    public Rational(){
	numerator = 0;
	denominator = 1;
    }

    //overloaded constructor, sets num to p/q
    //if q == 0, set to 0/1
    public Rational(int p, int q){
	this();
	if (q == 0){ //denom should not be 0...
	    //set rational # equal to 0
	    numerator = 0;
	    denominator = 1;
	    System.out.println("Invalid denominator; cannot be 0. Rational Number set to 0/1"); //print divide by 0 error
	}
	else{ //if params fine...
	    //set numer and denomin as requested
	    numerator = p;
	    denominator = q;
	}
    }

    //returns fractional representation of num as string
    public String toString(){
	return numerator + "/" + denominator;
    }

    //returns the value of number as a float 
    public double floatValue(){
	double retFloat;
	retFloat = (double)(numerator) / (double)(denominator); //typecast to prevent int division
	return retFloat;
    }
}
