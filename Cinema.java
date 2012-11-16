
import javax.swing.*; //imports everything in the swing class and dumps what is not used
import java.awt.*; // imports  everything in the awt class and dumps what is not used
import java.awt.event.*; //imports everything in the awt event class and dumps what is not used



public class Cinema extends JFrame implements ActionListener  {
	//Here I have named and declared the variable sand swing components I will be using
	
	JPanel pseats,  pinfo, pout ; // JPanel used to contain the buttons for the seats
	JLabel lage, ltime, lblock, lseats, lcost;  //JLabels to display information on the screen to the user
	JComboBox cage, ctime, cblock;// JComboBoxes for the user to select age, the desired block and the time
	JButton submit;// JButton to submit the desired information
	JButton[] seat = new JButton[50]; //An Array of  50 JButtons to be used as the seats for the cinema
	JTextField tseats, tcost; //JTextFields to display the number of seats in the current booking and the total cost of the booking
	String ttype;
	String [] age = {"Child" , "Adult" , "Senior"}; //The array of string options to be used for the age JComboBox
	String [] block = {"Middle" , "Left" , "Right"};//The array of string options to be used for the block JComboBox
	String [] time = {"13:00" , "15:00" , "17:00" , "19:00" , "21:00"};//The array of string options to be used for the time JComboBox
	int people, tickettype, blocktype, agetype, child, adult, senior, timetype; // declare the integer variables to be used in calculations later in the program
	double cost;// declare double variable used to show cost
	
	
	
	
	public Cinema(){
		
		setTitle("Cinema Booking System");// set title for the application
		setLayout(new FlowLayout());// set a flow layout
		setSize(840, 400); // Set default window size to be 840 x 30
		setResizable(true); // Set so the user cannot resize the window
		pinfo = new JPanel(); // create new JPanwel to store input information
		add(pinfo);// add new Jpanel to JFrame
		lage = new JLabel("Please Select Age Category:");//new JLabel for age	
		pinfo.add(lage);//add JLabel to the JPanel
		cage = new JComboBox(age);//new JComboBox for age
		pinfo.add(cage);//add JComboBox to JPanel
		cage.addActionListener(this);//add an action listener for JComboBox
		lblock = new JLabel("Please Select Desired Block:");//New JLabel for block
		pinfo.add(lblock);//add JLabel to the JPanel
		cblock = new JComboBox(block);// new JComboBox for block
		pinfo.add(cblock);//add JComboBox to JPanel
		cblock.addActionListener(this);//add an action listener for JComboBox
		ltime = new JLabel("Please Select Viewing Time:");//new JLabel for time
		pinfo.add(ltime);//add JLabel to the JPanel
		ctime = new JComboBox(time);// new JComboBox for time
		pinfo.add(ctime);//add JComboBox to JPanel
		ctime.addActionListener(this);//add an action listener for JComboBox
		pseats = new JPanel();// new JPanel to store seat buttons
		add(pseats);// add JPanel to JFrame
		pseats.setLayout(new GridLayout(10, 5)); //Set GridLayout for the JPanel
		for(int i = 0; i < 50; i++){ // loop through the array of JButtons
			seat[i] = new JButton(); // new JButton for seat
			pseats.add(seat[i]); // add JButton to JPanel
			seat[i].setText("seat no. : " + (i+1)); // set Text of the JButton
			seat[i].setBackground(Color.RED); //set background color of JButton to red
			seat[i].setOpaque(true); 
			seat[i].setBorderPainted(false);// because I developed this on a mac I needed to set these two to make the JButtons change colour
			seat[i].addActionListener(this);// add an action listener for JButton
			seat[i].setEnabled(false);
		}
		pout = new JPanel(); //Create new JPanel for storing outputs and submit button
		add(pout);// add new JPanel to JFrame
		setLayout(new FlowLayout()); //set new flowlayout
		lseats = new JLabel("       Number Of Seats:"); // new JLabel for seats
		pout.add(lseats);// add JLabel to JFrame
		tseats = new JTextField(8); // new JTextField for number of seats
		tseats.setEditable(false); // set so user is unable to edit the JTextField
		pout.add(tseats);// add JTextField to JPanel
		lcost = new JLabel("Total Cost Of Booking: "); // new JLabel for cost
		pout.add(lcost); // add JLabel to JPanel
		tcost = new JTextField(8); // new JTextField for number of seats
		tcost.setEditable(false);// set so user is unable to edit the JTextField
		pout.add(tcost);// add JTextField to JPanel
		submit = new JButton("submit"); // new JButton for submitting booking
		pout.add(submit);// add JButton to JPanel
		submit.addActionListener(this);//add an action listener for JButton
		setVisible(true); //Set the Components to be visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//the program will exit upon close
		
		
	}
	
	
	public void actionPerformed(ActionEvent ev) {// required when implementing action listener
		if (ev.getSource() == submit)//If submit button is clicked
		{
			
			
			for(int i = 0; i < 50; i++){//loop through the array of JButtons
				if (seat[i].getBackground() != Color.RED){ 
					seat[i].setBackground(Color.GRAY);
					seat[i].setText("Booked");
					
					/* if the background color of the button is not red (it has been selected for a booking)
					 * set the background color to gray and set the text to show it has now been booked 
					 */
				}
			}
			Ticket Ticket = new Ticket (child, adult, senior);// pass child , adult and senior into the ticket object
			Ticket.calcChargeDue(); //calculate charge due using method from ticket object
			cost = Ticket.getChargeDue();// cost is equal to the output of the getChargeDue method in the ticket object
			tcost.setText(Double.toString(cost));// set the JTextField to have the same value as the variable cost (converting to string)
			Receipt receipt = new Receipt(child, adult, senior, people, (String)ctime.getSelectedItem(), cost ); //passes variables to receipt class
			people = 0; // reset the value of people to 0
			tseats.setText(Integer.toString(people)); // set the text in the seats JTextField to equal the variable people
			cost = 0.00;// reset cost variable to 0
			child = 0;// reset cost variable to 0
			adult = 0;// reset cost variable to 0
			senior = 0;// reset cost variable to 0
			
			
		}
		
		if (ev.getSource() == cage)//If JComboBox cage fires an event
		{
			String atype = (String)cage.getSelectedItem(); //set a string to retrieve the value selected in JComboBox
			if(atype =="Adult"){ 
				tickettype = 1;
				// If the string is equal to Adult, set the variable  tickettype to be equal to 1
			}
			else if(atype =="Child"){
				tickettype = 0;
				// If the string is equal to Child, set the variable  tickettype to be equal to 0
			}
			else if(atype=="Senior"){
				tickettype = 2;
				// If the string is equal to Senior, set the variable  tickettype to be equal to 2
			}
		
		}
		
		if (ev.getSource() == cblock)//If JComboBox cblock fires an event
		{
			for(int i = 0; i < 50; i++){
				seat[i].setEnabled(false);
				String btype = (String)cblock.getSelectedItem();//set a string to retrieve the value selected in JComboBox
				if(btype =="Left" && i % 5 ==0){
					blocktype = 0;
					seat[i].setEnabled(true);
				}
				// If the string is equal to Middle, set the variable  blocktype to be equal to 1
				
				else if(btype =="Right" && (i+1) % 5 == 0){
					blocktype = 1;
					seat[i].setEnabled(true);
					// If the string is equal to Left, set the variable  blocktype to be equal to 0
				}
				else if(btype=="Middle" && i%5 != 0 && (i+1) % 5 !=0){
					blocktype = 2;
					seat[i].setEnabled(true);
					// If the string is equal to Right, set the variable  blocktype to be equal to 2
				}
			}
			
			
		}
		
		if (ev.getSource() == ctime)//If JComboBox ctime fires an event
		{
			String ttype = (String)ctime.getSelectedItem();//set a string to retrieve the value selected in JComboBox
			if(ttype =="13:00"){
				timetype = 0;
				// If the string is equal to 13:00, set the variable  timetype to be equal to 0
			}
			else if(ttype =="15:00"){
				timetype = 1;
				// If the string is equal to 15:00, set the variable  timetype to be equal to 1
			}
			else if(ttype =="17:00"){
				timetype = 2;
				// If the string is equal to 17:00, set the variable  timetype to be equal to 2
			}
			else if(ttype =="19:00"){
				timetype = 3;
				// If the string is equal to 19:00, set the variable  timetype to be equal to 3
			}
			else if(ttype =="21:00"){
				timetype = 4;
				// If the string is equal to 21:00, set the variable  timetype to be equal to 4
			}
			
			
		}
		
		
		for(int i = 0; i < 50; i++){ // loop through array of JButtons
			
			if (ev.getSource() == seat[i])//If a seat button is clicked
			{
				if (seat[i].getBackground() == Color.RED){ // If a seat button is red (unbooked)
					if (tickettype == 0){ // if tickettype is 0 (Child)
						seat[i].setBackground(Color.YELLOW); // set background color to yellow
						seat[i].setText("Child");// set text to "Child"
						people = people + 1;// set the value of people to equal people + 1
						seat[i].setEnabled(true);
						tseats.setText(Integer.toString(people)); // set the text in the JTextFeild to equal the value of people
						child = child + 1;
					}
					else if (tickettype == 1){// if tickettype is 1 (Adult)
						seat[i].setBackground(Color.GREEN); // set background color to green
						seat[i].setText("Adult");// set text to "Adult"
						people = people + 1;// set the value of people to equal people + 1
						seat[i].setEnabled(true);
						tseats.setText(Integer.toString(people));// set the text in the JTextFeild to equal the value of people
						adult = adult + 1;
					}
					else if (tickettype == 2){// if tickettype is 2 (Senior)
						seat[i].setBackground(Color.CYAN);// set background color to cyan
						seat[i].setText("Senior");// set text to "Senior"
						people = people + 1;// set the value of people to equal people + 1
						seat[i].setEnabled(true);
						tseats.setText(Integer.toString(people));// set the text in the JTextFeild to equal the value of people
						senior = senior + 1;
					}
					
					
					
					
				}
				else { // if seat was not red(it had been clicked by mistake?)
					seat[i].setBackground(Color.RED); // set the background color back to red
					seat[i].setText("seat no. : " + (i+1)); // set the text in th JButton back to orginal
					people = people - 1; // set value of people to equal people - 1
					tseats.setText(Integer.toString(people));// set text in JTextField to equal the value of people
				}
			}
		}
		
		}
		
		
		
		
	
	
	
	
	public static void main (String args[]){ // main loop and point of entry into our program
		
		new Cinema();// create new cinema
		
		
	}
}
