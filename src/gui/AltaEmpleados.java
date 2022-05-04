package gui;

import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class AltaEmpleados extends JPanel {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDniEmple;
	private JTextField txtCodEmple;
	private JTextField txtNomEmple;
	private JTextField txtApellidosEmple;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JDateChooser dateChooserAddUser;
	private JDateChooser dateChooserAddUser_1;
	private JTextFieldDateEditor addUserDateEditor;
	
	
	public AltaEmpleados() {
		//Parametros panel
		setLayout(null);
		setBounds(500, 200, 1100, 600);
		contentPanel.setBackground(SystemColor.controlLtHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		
		
	}

}
