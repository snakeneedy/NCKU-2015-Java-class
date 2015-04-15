import java.util.ArrayList;

public class Product implements Comparable<Product> {
	// member
	private String name;
	private double average;
	private ArrayList< Integer > rateList;
	// constructor
	Product () {
		name = new String();
		rateList = new ArrayList<Integer>();
		average = -1.0;
	}
	// function
	public void printFormatted () {
		System.out.printf("[%-25s%.2f, %d, %d, %.2f]%n"
				, getName() + ",", getAverage()
				, getMaxRate(), getMinRate()
				, getStandardDeviation() );
	}
	public int compareTo (Product x) {
		if( x.getAverage() > this.getAverage() )
			return 1;
		else
			return -1;
	}
	//// set
	public void setName (String input) {
		name = input;
	}
	public void addRate (int input) {
		rateList.add( input );
		this.average = (-1.0);
	}
	//// get
	public String getName () {
		return name;
	}
	public double getAverage () {
		if ( this.average == (-1.0) ) {
			double average = 0.0;
			for ( int i=0; i<rateList.size(); ++i ) {
				average += rateList.get(i);
			}
			average /= rateList.size();
			this.average = average;
			return average;
		}
		else {
			return this.average;
		}
	}
	public int getMaxRate () {
		if ( rateList.size() == 0 )
			return 0;
		int maxRate = Integer.MIN_VALUE;
		for ( int i=0; i<rateList.size(); ++i ) {
			maxRate = Integer.max(maxRate, rateList.get(i));
		}
		return maxRate;
	}
	public int getMinRate () {
		if ( rateList.size() == 0 )
			return 0;
		int minRate = Integer.MAX_VALUE;
		for ( int i=0; i<rateList.size(); ++i ) {
			minRate = Integer.min(minRate, rateList.get(i));
		}
		return minRate;
	}
	public double getStandardDeviation () {
		double standardDeviation = 0.0;
		double mean = getAverage();
		for (int i=0; i<rateList.size(); ++i) {
			double tmp = rateList.get(i) - mean;
			standardDeviation += (tmp * tmp);
		}
		standardDeviation /= (rateList.size() - 1);
		standardDeviation = Math.sqrt( standardDeviation );
		return standardDeviation;
	}
}
