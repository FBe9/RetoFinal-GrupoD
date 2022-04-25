package panel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;

public class AltasPacientePanel extends JPanel {
	private JTextField txtCicPaciente;
	private JTextField txtDniPaciente;
	private JTextField txtNombrePaciente;
	private JTextField txtApellidoPaciente;
	private JTextField txtTelefonoPaciente;
	private JTextField txtEnfermedadPaciente;

	private JButton btnRegistrarPaciente;
	private JLabel lblCicALtaPaciente;
	private JLabel lblDniALtaPaciente;
	private JLabel lblNombreALtaPaciente;
	private JLabel lblApellidoALtaPaciente;
	private JLabel lblTelefonoALtaPaciente;
	private JLabel lblEnfermedadALtaPaciente;
	private JLabel lblMedicoPaciente;
	private JLabel lblEnfermeroPaciente;
	
	private JComboBox cboxMedicosPaciente;
	private JComboBox cbxEnfermerosPaciente;
	
	/**
	 * Create the panel.
	 */
	public AltasPacientePanel() {
		setLayout(null);
		setBounds(500, 200, 1000, 600);
		
		txtCicPaciente = new JTextField();
		txtCicPaciente.setBounds(68, 109, 170, 29);
		add(txtCicPaciente);
		txtCicPaciente.setColumns(10);
		
		txtDniPaciente = new JTextField();
		txtDniPaciente.setColumns(10);
		txtDniPaciente.setBounds(68, 221, 170, 29);
		add(txtDniPaciente);
		
		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(68, 333, 170, 29);
		add(txtNombrePaciente);
		
		txtApellidoPaciente = new JTextField();
		txtApellidoPaciente.setColumns(10);
		txtApellidoPaciente.setBounds(68, 434, 170, 29);
		add(txtApellidoPaciente);
		
		txtTelefonoPaciente = new JTextField();
		txtTelefonoPaciente.setColumns(10);
		txtTelefonoPaciente.setBounds(352, 109, 170, 29);
		add(txtTelefonoPaciente);
		
		txtEnfermedadPaciente = new JTextField();
		txtEnfermedadPaciente.setColumns(10);
		txtEnfermedadPaciente.setBounds(352, 225, 170, 29);
		add(txtEnfermedadPaciente);
		
		btnRegistrarPaciente = new JButton("REGISTRAR");
		btnRegistrarPaciente.setBounds(669, 475, 199, 36);
		add(btnRegistrarPaciente);
		
		lblCicALtaPaciente = new JLabel("CIC");
		lblCicALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblCicALtaPaciente.setBounds(68, 77, 170, 21);
		add(lblCicALtaPaciente);
		
		lblDniALtaPaciente = new JLabel("DNI");
		lblDniALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblDniALtaPaciente.setBounds(68, 186, 170, 21);
		add(lblDniALtaPaciente);
		
		lblNombreALtaPaciente = new JLabel("Nombre");
		lblNombreALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblNombreALtaPaciente.setBounds(68, 299, 170, 21);
		add(lblNombreALtaPaciente);
		
		lblApellidoALtaPaciente = new JLabel("Apellido/s");
		lblApellidoALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblApellidoALtaPaciente.setBounds(68, 409, 170, 21);
		add(lblApellidoALtaPaciente);
		
		lblTelefonoALtaPaciente = new JLabel("Telefono");
		lblTelefonoALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblTelefonoALtaPaciente.setBounds(352, 77, 170, 21);
		add(lblTelefonoALtaPaciente);
		
		lblEnfermedadALtaPaciente = new JLabel("Enfermedad");
		lblEnfermedadALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblEnfermedadALtaPaciente.setBounds(352, 190, 170, 21);
		add(lblEnfermedadALtaPaciente);
		
		
		
		lblMedicoPaciente = new JLabel("Medico asigando");
		lblMedicoPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblMedicoPaciente.setBounds(669, 81, 170, 21);
		add(lblMedicoPaciente);
		
		lblEnfermeroPaciente = new JLabel("Enfermero asigando");
		lblEnfermeroPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblEnfermeroPaciente.setBounds(669, 225, 170, 21);
		add(lblEnfermeroPaciente);
		
		cboxMedicosPaciente = new JComboBox(); //Añadir Medicos
		cboxMedicosPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 11));
		cboxMedicosPaciente.setMaximumRowCount(5);
		cboxMedicosPaciente.setBounds(669, 113, 170, 22);
		add(cboxMedicosPaciente);
		
		cbxEnfermerosPaciente = new JComboBox(); //Añadir Enfermeros
		cbxEnfermerosPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 11));
		cbxEnfermerosPaciente.setMaximumRowCount(5);
		cbxEnfermerosPaciente.setBounds(669, 260, 170, 22);
		add(cbxEnfermerosPaciente);
		
		
		/*
		 * En caso de dar de alta un paciente correctamente, no es nueva ventana, sale una pestaña avisando
		 * 
		 */
		
		
		
	}
}
