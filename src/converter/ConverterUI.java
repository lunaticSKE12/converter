package converter;

import javax.swing.*; 

import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

/**
 * ConverterUI is UI of program.
 * @author Napong Dungduangsasitorn
 *
 */
public class ConverterUI extends JFrame{    
	// attributes for graphical components    
	private JButton convertButton, clearButton;    
	private JTextField inputField1, inputField2;
	private JComboBox unit1, unit2;
	private JLabel equal;


	//Constructor convertorUI.
	public ConverterUI() {    

		this.setTitle("Length Converter"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		initComponents( );     
	} 

	/**     
	 * initialize components in the window      
	 */    
	private void initComponents() { 
		UnitConverter uc = new UnitConverter();
		Unit[] units = uc.getUnits();
		JFrame frame = new JFrame();
		//frame.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());	//set layout
		inputField1 = new JTextField(20);
		unit1 = new JComboBox<Unit>();
		equal = new JLabel(" = ");
		inputField2 = new JTextField(20);
		inputField2.setEditable(false);
		unit2 = new JComboBox<Unit>();
		Unit[] lengths = units;
		for(Unit u : lengths){
			unit1.addItem(u);
			unit2.addItem(u);
		}
		convertButton = new JButton("Convert");
		clearButton = new JButton("Clear");

		/**     
		 * ConvertButtonListener is an ActionListener that performs an action when     
		 * the button is pressed.  It is an inner class so it can access private     
		 * attributes of ConverterUI.     
		 * It reads the text from a JTextField, convert the value to a number,      
		 * call the unitconverter to convert, and write result in other text field.    
		 */    
		class ConvertButtonListener implements ActionListener { 
			/** The action to perform action when the "convert" button is pressed */    
			public void actionPerformed( ActionEvent evt ) {    
				String s = inputField1.getText().trim();            
				//This line is for testing.  Comment it out after you see how it works. 
				System.out.println("actionPerformed: input=" + s);    
				try{
					if ( s.length() > 0 ) {                  
						double value = Double.valueOf( s ); 
						Unit fromUnit = (Unit) unit1.getSelectedItem();
						Unit toUnit = (Unit) unit2.getSelectedItem();
						double result = uc.convert(value, fromUnit, toUnit);
						//  then display the result.          
						inputField2.setText(String.format("%.3f", result));            
					} 
				}catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null,"Please Insert Number","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		}  // end of the inner class for ConvertButtonListener

		convertButton.addActionListener(new ConvertButtonListener());
		inputField1.addActionListener(new ConvertButtonListener());
		
		// clear text field.
		clearButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inputField1.setText("");
				inputField2.setText("");
			}
		});

		
		//add to panel
		panel.add(inputField1);
		panel.add(unit1);
		panel.add(equal);
		panel.add(inputField2);
		panel.add(unit2);
		panel.add(convertButton);
		panel.add(clearButton);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}