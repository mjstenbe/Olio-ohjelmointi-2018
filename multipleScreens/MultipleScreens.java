package multipleScreens;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class MultipleScreens extends JFrame {
	// If Eclipse shows a warning about  "serializable Class does not declare a static final serialVersionUID ...", just ignore it

	final static int MAX_QTY = 5; // final Class variable (Constant). Max possible amount of cars in my collection
	static int dbItems = 0; //Class variable. Current amount of cars in my collection 
	
	/*
	 * myDB is an Array of car objects with fixed size defined by the value stored in MAX_QTY.
	 * It is used as a Class variable as a workaround to simulate a database. A similar, more flexible workaround could be
	 * implemented with the use of an ArrayList. The final and proper solution is to use a database to store data about the car objects 
	 */
	static SimpleCar[] myDB = new SimpleCar[MAX_QTY]; 
	
	static JTable tableCar; // A JTable component that will be used to display the cars
	static JButton btnAddCar; // A JButton component that will be used to add a new car
	
	// Class constructor
	public MultipleScreens(){
		super("My Car Collection"); // Setting the title for the JFrame

		// Initiating the Car Collection
		initiateCarCollection();
		
		// Setting some initial values to the JFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null); // Sets the JFrame's container with a null Layout Manager (Absolute positioning)
		setBounds(0,0,436,331); // Sets the size of the JFrame
		setLocationRelativeTo(null);  // Positioning the JFrame (Window) at the center of the computer's screen

		// Label
		JLabel lblTheseAreMy = new JLabel("These are my cars:");
		lblTheseAreMy.setBounds(10, 11, 187, 14);
		getContentPane().add(lblTheseAreMy);
		
		// A JTable to display my collection
		tableCar = new JTable();
		tableCar.setRowSelectionAllowed(false);
		tableCar.setModel(new DefaultTableModel(
			new Object[MAX_QTY][3], // MAX_QTY rows, 3 columns
			new String[] {"Plate Number", "Colour", "Model"} // Column headers (will not be displayed due to JTable limitations)
		));
		tableCar.setBounds(10, 36, 194, 90);
		getContentPane().add(tableCar);
		
		// Command button - Add Car
		btnAddCar = new JButton("Add Car");
		btnAddCar.setBounds(236, 36, 89, 23);
		getContentPane().add(btnAddCar);
		
		//Populate table
		populateTable();
		
		// Creating a MyEventHandler to handle events generated by the command buttons AddCar
		// Registering the event handlers for the
		MyEventHandler commandHandler = new MyEventHandler();
		btnAddCar.addActionListener(commandHandler);
	}

	//Populate a JTable (tableCar) with data from my Car database (i.e the Array containing car objects)
	private void populateTable(){
		for (int row=0; row<dbItems; row++){
			tableCar.setValueAt(myDB[row].plateNr, row, 0);  //PlateNr
			tableCar.setValueAt(myDB[row].colour, row, 1);  //Colour
			tableCar.setValueAt(myDB[row].model, row, 2);  //Model			
		}
	}
	
	// This method creates two cars with some "hard-coded" values and stores them in the myDB array
	private void initiateCarCollection(){
		myDB[0] = new SimpleCar("HGF-234", "Green", "Toyota");
		myDB[1] = new SimpleCar("YSL-409", "Black", "Renault");
		dbItems = 2;
	}

	
	/* This class will handle the Action events generated by the AddCar button. Note that this is an inner Class,
	 * i.e, it is defined inside the top class MultipleScreens. An inner class is known by the term Nested Class.
	 * Using nested classes is a common technique to define event handlers in an application. Beware, that you may 
	 * also come across other techniques to define event handling classes. Don't feel overwhelmed because of it.
	 * In this course it is enough you understand and use this technique being shown here 
	 */
	private class MyEventHandler implements ActionListener
	{
		// In this method we will process the Action events generated by both buttons in the GUI
		public void actionPerformed (ActionEvent myEvent)
		{
			if (myEvent.getSource() == btnAddCar){
				// Open a standard input dialog to get input from the user and insert data into myDB
				getNewCarFromUser();
				
				// Refresh the main screen table containing the list of cars
				populateTable();
			}
		}
	}
	
	// This method will display the dialog box to get the input from the user and store the new car into the myDB array
	private void getNewCarFromUser(){
		// Defining the text input fields we will need in the dialog
		JTextField plateNrField = new JTextField(10);
	    JTextField colourField = new JTextField(10);
	    JTextField modelField = new JTextField(10);
 
	    // A JPanel is needed so we can add UI components to a standard dialog
	    JPanel myPanel = new JPanel();
	    
	    // Adding the PlateNR field to the JPanel
	    myPanel.add(new JLabel("Plate number:"));
	    myPanel.add(plateNrField);
	    
	    // Adding the Colour field to the JPanel
	    myPanel.add(new JLabel("Colour:"));
	    myPanel.add(colourField);

	    // Adding the Model field to the JPanel
	    myPanel.add(new JLabel("Model:"));
	    myPanel.add(modelField);
	    
	    // Displaying the input dialog: a standard Confirmation dialog showing the text fields from the JPanel myPanel
	    int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter details of your new car", JOptionPane.OK_CANCEL_OPTION);
	    
	    if (result == JOptionPane.OK_OPTION) {
	    	// Update myDB by adding a new car. Note that dbItems has a value equivalent to the next free index in myDB
	    	myDB[dbItems] = new SimpleCar(plateNrField.getText(), colourField.getText(), modelField.getText());
	    	
	    	//Increase the dbItems variable
	    	++dbItems;
	    }
	}
	
	// The entry point for the application
	public static void main(String[] args) {
		MultipleScreens frame = new MultipleScreens();
		frame.setVisible(true);
	}
}
