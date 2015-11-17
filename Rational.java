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
	if (q == 0){ 
	    numerator = 0;
	    denominator = 1;
	    System.out.println("Invalid denominator; cannot be 0. Rational Number set to 0/1"); //print divide by 0 error
	}
	else{
	    numerator = p;
	    denominator = q;\
	}
    }

    //returns fractional representation of num as string
    public String toString(){
	return numerator + "/" + denominator;
    }

    public double floatValue(){
	double floatQuotient;
	floatQuotient = (double)(numerator) / (double)(denominator);
	return floatQuotient;
    }
}
