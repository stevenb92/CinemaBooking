/*
 * This class was made to work out the prices of seats in the cinema and to calculate the charges due for each booking
 * there are two normal methods used to work out the cost and then two access methods to get the output of those methods
 */
public class Ticket {
	private int child = 0;
	private int adult = 0;
	private int senior = 0;
	double cost = 0.00;
	private  double SeatPrice = 5.00;
	
	public Ticket (int child, int adult, int senior){
		this.child = child;
		this.adult = adult;
		this.senior = senior;
		
		
	}	
	public void setSeatPrice(double SeatPrice){
		this.SeatPrice = SeatPrice;
	}
	
	public double getSeatPrice(){
		return SeatPrice;
	}
	
	public void calcChargeDue(){
		
		cost = (child * 0.7 * getSeatPrice()) + (adult * 1.5 * getSeatPrice()) + (senior * 1 * getSeatPrice());
		
	}
	
	public double getChargeDue(){
		return cost;
	}
}
