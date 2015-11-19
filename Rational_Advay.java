// Team MRE -- Advay Sriram, Calvin Vuong
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

    //Mutators; purely for DIAGNOSTIC purposes only
    public void setNumerator(int newNumerator){
	numerator = newNumerator;
    }

    public void setDenominator(int newDenominator){
	if (newDenominator == 0) { newDenominator = 1; }
	denominator = newDenominator;
    }
    
    //returns the value of number as a float 
    public double floatValue(){
	double retFloat;
	retFloat = (double)(numerator) / (double)(denominator); //typecast to prevent int division
	return retFloat;
    }

    //does not return anything, takes another Rational and sets this Rational to the product of itself and the parameter.
    //leaves parameter object alone
    public void multiply(Rational other){
	this.numerator *= other.numerator; //multiply numerators
	this.denominator *= other.denominator; //multipy denominators
    }

     //does not return anything, takes another Rational and sets this Rational to the quotient of itself over the parameter.
    public void divide(Rational other){
	this.numerator *= other.denominator; //mult. num by denom
	this.denominator *= other.numerator; //mut. denom by num.
    }
    
    //returns the gcd between numberator and denominator
    public int gcd (){
	int a = max (numerator, denominator); //find greater of numerator and denominator
	int b = min (numerator, denominator); //find lesser of numerator and denominator
	while (a % b != 0) {
	    int i = a; //temp store a
	    int f = b; //temp store b
	    a = b;
	    b = i % f; //b is remainder of a and b
	}
	return b;
    }
   
    public void reduce (){
	numerator = numerator/gcd();
	denominator = denominator/gcd();
    }
    public static int gcd2 (int numerator, int denominator){
	int a = max (numerator, denominator); //find greater of numerator and denominator
	int b = min (numerator, denominator); //find lesser of numerator and denominator
	while (a % b != 0) {
	    int i = a; //temp store a
	    int f = b; //temp store b
	    a = b;
	    b = i % f; //b is remainder of a and b
	}
	return b;
    }
    public int compareTo (int num, int denom){
	if (num == denom){
	    return 0;
	}
	else if (num > denom){
	    return 1;
	}
	else if (denom > num){
	    return -1;
	}
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
	System.out.println( "good.multiply(foo); Expected: 15/15, New good: " + good );
	System.out.println();
	
	System.out.println("*==========*");
	System.out.println();
	System.out.println("resetting values of Rationals...");

	//reset values
	good.setNumerator(3);
	good.setDenominator(5);
	foo.setNumerator(5);
	foo.setDenominator(3);
	System.out.println();

	System.out.println("*==========*");
	foo.multiply(good);
        System.out.println( "foo.multiply(good); Expected: 15/15, New foo: " + foo );
	System.out.println();

	System.out.println("*==========*");
	System.out.println();
	System.out.println("resetting values of Rationals...");

	//reset values
	good.setNumerator(3);
	good.setDenominator(5);
	foo.setNumerator(5);
	foo.setDenominator(3);
	System.out.println();

	System.out.println("*==========*");
	System.out.println("divide()");
	good.divide(foo);
	System.out.println( "good.divide(foo); Expected: 9/25, New good: " + good );
	System.out.println();

	System.out.println("*==========*");
	System.out.println();
	System.out.println("resetting values of Rationals...");

	//reset values
	good.setNumerator(3);
	good.setDenominator(5);
	foo.setNumerator(5);
	foo.setDenominator(3);
	System.out.println();

	System.out.println("*==========*");
	foo.divide(good);
	System.out.println( "foo.divide(good); Expected: 25/9, New foo: " + foo );
    }
}
