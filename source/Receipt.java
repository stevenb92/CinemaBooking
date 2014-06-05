import java.awt.*;// imports  everything in the awt class and dumps what is not used
import javax.swing.*;//imports everything in the swing class and dumps what is not used
/*
 * This class was made to produce a receipt to show how many types of ticket were made , for what time they were booked 
 * and how much the booking has cost, it takes in variables from the Cinema class and outputs them into a JFrame separate
 * to the main program
 */

public class Receipt extends JFrame { //Constructor
	//Initialize the variables I am going to use
	private int child = 0;
	private int adult = 0;
	private int senior = 0;
	private int people = 0;
	private String ttype;
	private double cost = 0.00;
	JLabel lchild, ladult, lsenior, lpeople,ltime,  lcost;
	JTextField tchild, tadult, tsenior, tpeople,ttime,  tcost;
	
	public Receipt(int child, int adult, int senior, int people, String ttype , double cost){
		this.child = child;
		this.adult=adult;
		this.senior = senior;
		this.people = people;
		this.ttype = ttype;
		this.cost = cost;
		setSize(600,600);
		setLayout(new GridLayout(6,2));
		lchild = new JLabel ("Child Tickets: ");
		add(lchild);
		tchild = new JTextField(Integer.toString(child));
		tchild.setEditable(false);
		add(tchild);
		ladult = new JLabel("Adult Tickets: ");
		add(ladult);
		tadult = new JTextField(Integer.toString(adult));
		tadult.setEditable(false);
		add(tadult);
		lsenior = new JLabel("Senior Tickets: ");
		add(lsenior);
		tsenior =new JTextField(Integer.toString(senior));
		tsenior.setEditable(false);
		add(tsenior);
		lpeople = new JLabel("Total Tickets: ");
		add(lpeople);
		tpeople =new JTextField(Integer.toString(people));
		tpeople.setEditable(false);
		add(tpeople);
		ltime = new JLabel("Booking time: ");
		add(ltime);
		ttime =new JTextField(ttype);
		ttime.setEditable(false);
		add(ttime);
		lcost = new JLabel("Total Cost: ");
		add(lcost);
		tcost =new JTextField(Double.toString(cost));
		tcost.setEditable(false);
		add(tcost);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//the program will exit upon close
	}
		
	}


