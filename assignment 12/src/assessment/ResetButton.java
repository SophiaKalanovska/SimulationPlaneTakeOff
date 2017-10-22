package assessment;
// Import in the program the classes needed that existing within the external Java library 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.JTextArea;

// this class represents a ResetButton which implements ActionListener.
public class ResetButton implements ActionListener {

	// jsPosition and jsSpeed of type JSlider, jtaMessage of type JTextArea are
	// declared.
	private JSlider jsPosition;
	private JSlider jsSpeed;
	private JTextArea jtaMessage;

	// the object aeroplane of Airplane is created.
	private Aeroplane aeroplane;

	/*
	*constructor is used to assign values to jsPosition, jsSpeed, jtaMessage
	*and aeroplane.
	*/ 
	public ResetButton(JSlider jsPosition, JSlider jsSpeed, JTextArea jtaMessage, Aeroplane aeroplane) {
		this.jsPosition = jsPosition;
		this.jsSpeed = jsSpeed;
		this.jtaMessage = jtaMessage;
		this.aeroplane = aeroplane;
	}

	/*
	 * this method performs the function of setting value of position to 5,
	 * value of aeroplane Y to 0, value of speed to 0, value of seconds to 0 and
	 * clearing the textArea.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		jsPosition.setValue(5);
		aeroplane.resetCoorY(0);
		jsSpeed.setValue(0);
		jtaMessage.setText("");
		aeroplane.setSeconds(0);

		// TODO Auto-generated method stub

	}

}
