package taxify;
import java.lang.Math;

public class Statistics implements IStatistics{
	private int services;
	private int reviews;
	private double stars;
	private int distance;
	private int billing;
	
	public Statistics() {		// when initialized, all the attributes start at 0
		this.services = 0;
		this.reviews = 0;
		this.stars = 0.0;
		this.distance = 0;
		this.billing = 0;
	}
	
	
	
	//getters
	@Override
	public int getService() {
		return this.services;
	}
	
	@Override
	public int getReviews() {	// returns the number of reviews given
		return this.reviews;
	}
	
	@Override
	public double getStars() {  	// this will be calculated using a 5-star rating formula.   5star score = score total / total responses
		double stars = this.stars / (double) this.reviews;
		
		return Math.round(stars * 100.0) / 100.0;
	}
	
	@Override
	public int getDistance() {
		return this.distance;
	}
	
	@Override
	public int getBilling() {
		return this.billing;
	}
	
	//setters
	@Override
	public void updateService() {
		this.services++;
	}
	
	@Override
	public void updateReviews() {
		this.reviews++;
	}
	
	@Override
	public void updateStars(double s) {
		this.stars += s;
		
	}
	
	@Override
	public void updateDistance(int d) {
		this.distance += d;
	}
	
	@Override
	public void updateBilling(int b) {
		this.billing = b;
	}

}
