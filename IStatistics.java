package taxify;

// keeps track of information such as: Services, Reviews, Stars, Distance, Billing
// this info can be later displayed after the completion of a users service

public interface IStatistics {
	//getters
	public int getService();
	public int getReviews();
	public double getStars();
	public int getDistance();
	public int getBilling();
	
	//setters
	public void updateService();
	public void updateReviews();
	public void updateStars(double s);
	public void updateDistance(int d);
	public void updateBilling(int b);

}
