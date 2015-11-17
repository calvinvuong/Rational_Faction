// Team MRE -- Derek Lin, Calvin Vuong
// APCS1 pd5
// HW32 -- Irrationality Stops Here
// 2015-11-18

public class Rational{
    //inst vars
    private int numerator;
    private int denominator;

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

    //Mutators

    public void setNumerator(int newNumerator){
	numerator = newNumerator;
    }

    public void setDenominator(int newDenominator){
	denominator = newDenominator;
    }
    
    //returns the value of number as a float 
    public double floatValue(){
	double retFloat;
	retFloat = (double)(numerator) / (double)(denominator); //typecast to prevent int division
	return retFloat;
    }

    //does not return anything, takes another Rational and sets this Rational to the product of itself and the parameter.
    public void multiply(Rational other){
	/*
	//DEBUG
	System.out.println("Before: " + this);
	*/
	this.numerator *= other.numerator;
	this.denominator *= other.denominator;
	/*
	//DEBUG
	System.out.println("After: " + this);
	*/
    }

     //does not return anything, takes another Rational and sets this Rational to the quotient of itself over the parameter.
    public void divide(Rational other){
	/*
	//DEBUG
	System.out.println("Before: " + this);
	*/
	this.numerator *= other.denominator;
	this.denominator *= other.numerator;
	/*
	//DEBUG
	System.out.println("After: " + this);
	*/
    }

    //test cases
    public static void main(String[] args){
	Rational bad = new Rational(3, 0);
	Rational good = new Rational(3, 5);
	Rational foo = new Rational(5, 3);
	System.out.println("*==========*");
	System.out.println();
	System.out.println("toString()");
	System.out.println( "bad.toString(); Expected: 0/1, Result: " + bad);
	System.out.println( "good.toString(); Expected: 3/5, Result: " + good);
	System.out.println( "foo.toString(); Expected: 5/3, Result: " + foo);
	System.out.println();

	System.out.println("*==========*");
	System.out.println();
	System.out.println("floatValue()");
	System.out.println( "bad.floatValue(); Expected: 0.0, Result: " + bad.floatValue() );
	System.out.println( "good.floatValue(); Expected: 0.6, Result: " + good.floatValue() );
	System.out.println( "foo.floatValue(); Expected: 1.666..., Result: " + foo.floatValue() );
	System.out.println();

	System.out.println("*==========*");
	System.out.println();
	System.out.println("multiply()");
	good.multiply(foo);
	System.out.println( "good.multiply(); Expected: 1.0, Result: " + good );
	System.out.println();
	
	System.out.println("*==========*");
	System.out.println();
	System.out.println("resetting values of Rationals...");
	good.setNumerator(3);
	good.setDenominator(5);
	foo.setNumerator(5);
	foo.setDenominator(3);
	System.out.println();

	System.out.println("*==========*");
	foo.multiply(good);
        System.out.println( "foo.multiply(); Expected: 1.0, Result: " + foo );
	System.out.println();

	System.out.println("*==========*");
	System.out.println();
	System.out.println("resetting values of Rationals...");
	good.setNumerator(3);
	good.setDenominator(5);
	foo.setNumerator(5);
	foo.setDenominator(3);
	System.out.println();

	System.out.println("*==========*");
	System.out.println("divide()");
	good.divide(foo);
	System.out.println( "good.divide(); Expected: 0.36, Result: " + good );
	System.out.println();

	System.out.println("*==========*");
	System.out.println();
	System.out.println("resetting values of Rationals...");
	good.setNumerator(3);
	good.setDenominator(5);
	foo.setNumerator(5);
	foo.setDenominator(3);
	System.out.println();

	System.out.println("*==========*");
	foo.divide(good);
	System.out.println( "foo.divide(); Expected: 2.777..., Result: " + foo );
    }
}
