package assessment;
// Import in the program the classes needed that existing within the external Java library 
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// this class represents a JFrame.
public class Frame extends JFrame {

	// variables position and speed declared.
	private static int position;
	private static int speed;

	// variables Pos_MIN, Pos_MAX, Pos_INIT declared.
	static final int Pos_MIN = 0;
	static final int Pos_MAX = 10;
	static final int Pos_INIT = 5;

	// variables speed_MIN, speed_MAX, speed_INIT declared.
	static final int speed_MIN = 0;
	static final int speed_MAX = 10;
	static final int speed_INIT = 0;

	// a JTextArea, a JScrollPane, two JSlider's and a JButton declared.
	private static JTextArea jtaMessage;
	private JScrollPane jspMessage;
	private JSlider jsPosition;
	private JSlider jsSpeed;
	private JButton jbReset;

	// a field aeroplane of type Aeroplane
	private Aeroplane aeroplane;

	/*
	*constructor is supplied an aeroplane, which is assigned an value and
	*/
	public Frame(Aeroplane aeroplane) {
		//the constructor of the  super class is called 
		super("Plane take off");
		this.aeroplane = aeroplane;

		// a JTextArea called jtaMessage is createdwith size of 15 by 30 
		// and is added to the frame.
		// the TextArea is not editable
		jtaMessage = new JTextArea(15, 30);
		jtaMessage.setEditable(false);
		add(jtaMessage);

		//  a JScrollPane  callled jspMessage is created 
		// and added to the frame.
		jspMessage = new JScrollPane(jtaMessage);
		jspMessage.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(jspMessage);

		// jsPosition, a JSlider is created and added to the frame. Also a
		// ChangeListener used to assign the value of slider to position.
		jsPosition = new JSlider(JSlider.HORIZONTAL, Pos_MIN, Pos_MAX, Pos_INIT);
		add(jsPosition);
		jsPosition.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				position = jsPosition.getValue();
			}
		});

		// jsSpeed, a JSlider is created and added to the frame. Also a
		// ChangeListener used to assign the value of slider to speed.
		jsSpeed = new JSlider(JSlider.VERTICAL, speed_MIN, speed_MAX, speed_INIT);
		add(jsSpeed);
		jsSpeed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				speed = jsSpeed.getValue();
			}
		});

		// jbReset, a JButton is created and added to the frame. 
		// Also an ActionListener is added and creates an object of ResetButton 
		// that assignes all the values as the initial one
		jbReset = new JButton("Reset");
		add(jbReset);
		jbReset.addActionListener(new ResetButton(jsPosition, jsSpeed, jtaMessage, aeroplane));

		// layout is set to BorderLayout and three JPanels created, 
		// where jpNorth, jpCenter and jpSouth are asigned to 
		// BorderLayout.NORTH, BorderLayout.CENTER and BorderLayout.SOUTH
		setLayout(new BorderLayout());
		JPanel jpNorth = new JPanel();
		JPanel jpCenter = new JPanel();
		JPanel jpSouth = new JPanel();
		this.add(jpNorth, BorderLayout.NORTH);
		this.add(jpCenter, BorderLayout.CENTER);
		this.add(jpSouth, BorderLayout.SOUTH);

		// layout of jpNorth is set to Borderlayout and jspMessage is added to
		// CENTER.
		jpNorth.setLayout(new BorderLayout());
		jpNorth.add(jspMessage, BorderLayout.CENTER);

		// layout of jpCenter is set to GridLayout and 
		//j sPosition and jsSpeed added to the Layout.
		jpCenter.setLayout(new GridLayout(2, 1));
		jpCenter.add(jsPosition);
		jpCenter.add(jsSpeed);

		// layout of jpSouth is set to FlowLayout and jbReset added.
		jpSouth.setLayout(new FlowLayout());
		jpSouth.add(jbReset);

		// the frame is packed and setVisible set to true.
		this.pack();
		this.setVisible(true);

		// initially, position is set to 5.
		position = 5;
	}

	/*
	 * this method is supplied a Frame and a Runway.
	 * It calls the methods inside try
	 * then stop the whole program for a second 
	 */
	public void startImplementation(Frame myFrame, Runway pista) {
		
		// This method is implemented while aeroplane is not in air 
		//and y is less than or equal to 100.
		while (aeroplane.getInAir() == false && aeroplane.getCoorY() <= 100) {

			try {
	   		    //The value of x will be set to position
				aeroplane.setCoorX(position);
				//The value of y will be set to speed.
				aeroplane.setCoorY(speed);
				//The value of speed will be set to speed.
				aeroplane.setSpeed(speed);
				//the elevation method will be called.
				aeroplane.elevation();
				//the setInAir method will be called.
				aeroplane.setInAir();
				// the seconds of the aeroplane will be printed inside the textArea
				jtaMessage.append("Seconds: " + aeroplane.getSeconds() + "\n");
				// the overwritten toString method of the plane will be printed
				jtaMessage.append(aeroplane.toString() + "\n");
				// this method is used to adjust the scroller where the text is printed
				jtaMessage.setCaretPosition(jtaMessage.getDocument().getLength());
				//. IncrementSeconds will also be called.
				aeroplane.incrementSeconds();
				// sleep method in Thread object will be used to pause the loop for one second.
				Thread.sleep(1000);
				
				//If the aeroplane is in Air, the message "Plane in air" is printed.
				if (aeroplane.getInAir() == true) {
					jtaMessage.append("Plane in air.");
				}
				
				//If the aeroplane is not in air and 
				//the aeroplane y is greater than the length of the runway
				// "Take off failed" is printed.
				if (aeroplane.getInAir() == false && aeroplane.getCoorY() > pista.getLength()) {
					jtaMessage.append("Take-off failed.");
				}

			} catch (InterruptedException e) {

			}

		}
	}

	/*
	* returns position. 
	*/
	public int getPosition() {
		return position;
	}

	/* 
	* returns speed. 
	*/
	public int getSpeed() {
		return speed;
	}
}
