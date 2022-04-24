package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

public class VentanaModificacionPaciente extends JDialog {

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
	
	private JButton btnCancelarModificacionPaciente;
	private JButton btnModificarPaciente;
	private JCheckBox chckbxRecuperadoPaciente;
	
	public VentanaModificacionPaciente() {
		setResizable(false);
		getContentPane().setLayout(null);
		
		txtCicPaciente = new JTextField();
		txtCicPaciente.setEditable(false);
		txtCicPaciente.setBounds(37, 57, 170, 29);
		getContentPane().add(txtCicPaciente);
		txtCicPaciente.setColumns(10);
		
		txtDniPaciente = new JTextField();
		txtDniPaciente.setEditable(false);
		txtDniPaciente.setColumns(10);
		txtDniPaciente.setBounds(37, 149, 170, 29);
		getContentPane().add(txtDniPaciente);
		
		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(37, 237, 170, 29);
		getContentPane().add(txtNombrePaciente);
		
		txtApellidoPaciente = new JTextField();
		txtApellidoPaciente.setColumns(10);
		txtApellidoPaciente.setBounds(37, 340, 170, 29);
		getContentPane().add(txtApellidoPaciente);
		
		txtTelefonoPaciente = new JTextField();
		txtTelefonoPaciente.setColumns(10);
		txtTelefonoPaciente.setBounds(287, 53, 170, 29);
		getContentPane().add(txtTelefonoPaciente);
		
		txtEnfermedadPaciente = new JTextField();
		txtEnfermedadPaciente.setColumns(10);
		txtEnfermedadPaciente.setBounds(287, 149, 170, 29);
		getContentPane().add(txtEnfermedadPaciente);
		
		btnRegistrarPaciente = new JButton("REGISTRAR");
		btnRegistrarPaciente.setBounds(705, 520, 199, 36);
		getContentPane().add(btnRegistrarPaciente);
		
		lblCicALtaPaciente = new JLabel("CIC");
		lblCicALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblCicALtaPaciente.setBounds(37, 25, 170, 21);
		getContentPane().add(lblCicALtaPaciente);
		
		lblDniALtaPaciente = new JLabel("DNI");
		lblDniALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblDniALtaPaciente.setBounds(37, 114, 170, 21);
		getContentPane().add(lblDniALtaPaciente);
		
		lblNombreALtaPaciente = new JLabel("Nombre");
		lblNombreALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblNombreALtaPaciente.setBounds(37, 205, 170, 21);
		getContentPane().add(lblNombreALtaPaciente);
		
		lblApellidoALtaPaciente = new JLabel("Apellido/s");
		lblApellidoALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblApellidoALtaPaciente.setBounds(37, 300, 170, 21);
		getContentPane().add(lblApellidoALtaPaciente);
		
		lblTelefonoALtaPaciente = new JLabel("Telefono");
		lblTelefonoALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblTelefonoALtaPaciente.setBounds(287, 21, 170, 21);
		getContentPane().add(lblTelefonoALtaPaciente);
		
		lblEnfermedadALtaPaciente = new JLabel("Enfermedad");
		lblEnfermedadALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblEnfermedadALtaPaciente.setBounds(287, 114, 170, 21);
		getContentPane().add(lblEnfermedadALtaPaciente);
		
		btnCancelarModificacionPaciente = new JButton("Cancelar");
		btnCancelarModificacionPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 15));
		btnCancelarModificacionPaciente.setBounds(260, 390, 134, 46);
		getContentPane().add(btnCancelarModificacionPaciente);
		
		
		btnModificarPaciente = new JButton("Modificar");
		btnModificarPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 15));
		btnModificarPaciente.setBounds(421, 390, 134, 46);
		getContentPane().add(btnModificarPaciente);
		
		/*
		 * En caso de los botones modificar y cancelar, tendran una pestaña emeprgente para confirmar la accion
		 */
		
		chckbxRecuperadoPaciente = new JCheckBox("Recuperado");
		chckbxRecuperadoPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		chckbxRecuperadoPaciente.setBounds(299, 237, 143, 26);
		getContentPane().add(chckbxRecuperadoPaciente);
		
		/*
		 * Recuperado quita al paciente de la lista de pacientes que puede ver
		 */
		
	}

}
