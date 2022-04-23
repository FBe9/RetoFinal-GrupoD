package panel;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class AltasPacientePanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public AltasPacientePanel() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(37, 95, 170, 29);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(37, 207, 170, 29);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(37, 335, 170, 29);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(37, 461, 170, 29);
		add(textField_3);
		
	}
}
