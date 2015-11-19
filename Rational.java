// Team MRE -- Advay Sriram, Calvin Vuong
// APCS1 pd5
// HW33 -- Do You Even Add, Bro?
// 2015-11-19

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
    
    //returns the gcd between calling class's numberator and denominator
    public int gcd (){
	int a; int b; //a is greater than b
	//set greater of numerator and denominator to a, lesser to b
	if (numerator >= denominator){
	    a = numerator;
	    b = denominator;
	}
	else{
	    a = denominator;
	    b = numerator;
	}
	//euclid's algo
	while (a % b != 0) {
	    int i = a; //temp sotre a
	    int f = b; //temp store b
	    a = b;
	    b = i % f; //b is remainder of a and b
	}
	return b;
    }

    //static method gcd
    //takes two inputs, x and y, and returns greatest common divisor of the two
    //use x and y to represent numerator and denominator to avoid confusion with instance vars
    public static int gcd (int x, int y){
        int a; int b; //a is greater than b
	//set greater of x and y to a, lesser to b
	if (x >= y){
	    a = x;
	    b = y;
	}
	else{
	    a = y;
	    b = x;
	}
	//euclid's algo
	while (a % b != 0) {
	    int i = a; //temp store a
	    int f = b; //temp store b
	    a = b;
	    b = i % f; //b is remainder of a and b
	}
	return b;
    }

    //puts numerator and denominator of calling object into simplest terms
    public void reduce (){
        numerator = numerator / gcd();
        denominator = denominator / gcd();
    }

    /*this.compareTo(Rational other)
      returns 0 if this is equivalent to other
      returns 1 if this is greater than other
      reurns -1 if this is less than other
    */
    public int compareTo(Rational other){
	//use float value to take advanatage of primitive comparison
	if (this.floatValue() == other.floatValue()){ //if values equal
	    return 0;
	}
	else if (this.floatValue() > other.floatValue()){ //if calling value greater
	    return 1;
	}
	else{ //if parameter value greater
	    return -1;
	}
    }

    //takes one Rational object specified in parameter and adds it to this Rational object
    public void add(Rational other){
	int commonDenominator = this.denominator * other.denominator;
	int numerator1; //numerator of this Rational object, after modificaiton
	int numerator2; //numerator of other Rational object, after modification
	numerator1 = this.numerator * other.denominator;
	numerator2 = other.numerator * this.denominator;
	
	//add rational numbers by summing numerators, keeping common denominator
	this.numerator = numerator1 + numerator2;
	this.denominator = commonDenominator;
    }

    //takes one Rational object specified in parameter and add subtracts it from this Ratinal Object
    public void subtract(Rational other){
	int commonDenominator = this.denominator * other.denominator;
	int numerator1; //numerator of this Rational object, after modification
	int numerator2; //numerator of other Rational object, after modification
	numerator1 = this.numerator * other.denominator;
	numerator2 = other.numerator * this.denominator;

	//subtract rational numbers by subtracting numerators, keeping common denominator
	this.numerator = numerator1 - numerator2;
	this.denominator = commonDenominator;
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
	System.out.println();
	System.out.println("divide()");
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
	System.out.println("resetting values of Rationals...");

	//reset values
	good.setNumerator(3);
	good.setDenominator(5);
	foo.setNumerator(5);
	foo.setDenominator(3);
	System.out.println();

	System.out.println("*=========*");
	System.out.println();
	System.out.println("add()");
	good.add(foo);
	System.out.println("good.add(foo); Expected: 34/15, New good: " + good );
	System.out.println("resetting values of Rationals...");

	//reset values
	good.setNumerator(3);
	good.setDenominator(5);
	foo.setNumerator(5);
	foo.setDenominator(3);
	System.out.println();

	System.out.println("*=========*");
	System.out.println();
	System.out.println("subtract()");
	good.subtract(foo);
	System.out.println("good.subtract(foo); Expected: -16/15, New good: " + good );
	System.out.println("resetting values of Rationals...");
	System.out.println();

	//reset values
	good.setNumerator(3);
	good.setDenominator(5);
	foo.setNumerator(5);
	foo.setDenominator(3);
	System.out.println();

	//new instance vars
	Rational bar = new Rational(24, 10);
	Rational sar = new Rational(240, 100);
	
	//test reduce, which also tests gcd
	System.out.println("*=========*");
	System.out.println();
	System.out.println("reduce()");
	System.out.println(bar + " before reducing.");
	bar.reduce(); //reduce bar
	System.out.println("After reducing... Expected: 12/5, New number: " + bar);
	System.out.println();

	//test compareTo()
	System.out.println("*=========*");
	System.out.println();
	System.out.println("compareTo()");
	System.out.println("Comparing " + bar + " to " + sar + " should yield 0... Result: " + bar.compareTo(sar));
	System.out.println("Comparing " + bar + " to " + foo + " should yield 1... Result: " + bar.compareTo(foo));
	System.out.println("Comparing " + good + " to " + foo + " should yield -1... Result: " + good.compareTo(foo));
	System.out.println();

	//test static gcd method
	System.out.println("*========*");
	System.out.println();
	System.out.println("GCD of 5 and 3 should be 1... Result: " + Rational.gcd(5,3));
	System.out.println("GCD of 12 and 4 should be 4... Result: " + Rational.gcd(12,4));
	System.out.println("GCD of 15 and 12 should be 3... Result: " + Rational.gcd(12,3));
    }
}
