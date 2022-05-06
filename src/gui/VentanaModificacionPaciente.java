package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

/**
 * Esta ventana recoge los datos de un paciente para modificarlos
 * @author Emil
 *
 */

public class VentanaModificacionPaciente extends JDialog implements ActionListener{

	private JTextField txtCicPaciente;
	private JTextField txtDniPaciente;
	private JTextField txtNombrePaciente;
	private JTextField txtApellidoPaciente;
	private JTextField txtTelefonoPaciente;
	private JTextField txtEnfermedadPaciente;
	private JLabel lblCicALtaPaciente;
	private JLabel lblDniALtaPaciente;
	private JLabel lblNombreALtaPaciente;
	private JLabel lblApellidoALtaPaciente;
	private JLabel lblTelefonoALtaPaciente;
	private JLabel lblEnfermedadALtaPaciente;
	
	private JButton btnCancelarModificacionPaciente;
	private JButton btnModificarPaciente;
	private JCheckBox chckbxRecuperadoPaciente;
	
	private JButton btnCerrarVentana;
	
	public VentanaModificacionPaciente() {
		//Diseño de la ventana
		
		setUndecorated(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(600, 300, 600, 600);
		
		txtCicPaciente = new JTextField();
		txtCicPaciente.setEditable(false);
		txtCicPaciente.setBounds(35, 103, 170, 29);
		getContentPane().add(txtCicPaciente);
		txtCicPaciente.setColumns(10);
		
		txtDniPaciente = new JTextField();
		txtDniPaciente.setEditable(false);
		txtDniPaciente.setColumns(10);
		txtDniPaciente.setBounds(35, 195, 170, 29);
		getContentPane().add(txtDniPaciente);
		
		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(35, 283, 170, 29);
		getContentPane().add(txtNombrePaciente);
		
		txtApellidoPaciente = new JTextField();
		txtApellidoPaciente.setColumns(10);
		txtApellidoPaciente.setBounds(35, 386, 170, 29);
		getContentPane().add(txtApellidoPaciente);
		
		txtTelefonoPaciente = new JTextField();
		txtTelefonoPaciente.setColumns(10);
		txtTelefonoPaciente.setBounds(285, 99, 170, 29);
		getContentPane().add(txtTelefonoPaciente);
		
		txtEnfermedadPaciente = new JTextField();
		txtEnfermedadPaciente.setColumns(10);
		txtEnfermedadPaciente.setBounds(285, 195, 170, 29);
		getContentPane().add(txtEnfermedadPaciente);
		
		lblCicALtaPaciente = new JLabel("CIC");
		lblCicALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblCicALtaPaciente.setBounds(35, 71, 170, 21);
		getContentPane().add(lblCicALtaPaciente);
		
		lblDniALtaPaciente = new JLabel("DNI");
		lblDniALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblDniALtaPaciente.setBounds(35, 160, 170, 21);
		getContentPane().add(lblDniALtaPaciente);
		
		lblNombreALtaPaciente = new JLabel("Nombre");
		lblNombreALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblNombreALtaPaciente.setBounds(35, 251, 170, 21);
		getContentPane().add(lblNombreALtaPaciente);
		
		lblApellidoALtaPaciente = new JLabel("Apellido/s");
		lblApellidoALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblApellidoALtaPaciente.setBounds(35, 346, 170, 21);
		getContentPane().add(lblApellidoALtaPaciente);
		
		lblTelefonoALtaPaciente = new JLabel("Telefono");
		lblTelefonoALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblTelefonoALtaPaciente.setBounds(285, 67, 170, 21);
		getContentPane().add(lblTelefonoALtaPaciente);
		
		lblEnfermedadALtaPaciente = new JLabel("Enfermedad");
		lblEnfermedadALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblEnfermedadALtaPaciente.setBounds(285, 160, 170, 21);
		getContentPane().add(lblEnfermedadALtaPaciente);
		
		btnCancelarModificacionPaciente = new JButton("Cancelar");
		btnCancelarModificacionPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 15));
		btnCancelarModificacionPaciente.setBounds(275, 498, 115, 29);
		getContentPane().add(btnCancelarModificacionPaciente);
		
		
		btnModificarPaciente = new JButton("Modificar");
		btnModificarPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 15));
		btnModificarPaciente.setBounds(400, 498, 115, 29);
		getContentPane().add(btnModificarPaciente);
		
		/*
		 * En caso de los botones modificar y cancelar, tendran una pestaña emeprgente para confirmar la accion
		 */
		
		chckbxRecuperadoPaciente = new JCheckBox("Recuperado");
		chckbxRecuperadoPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		chckbxRecuperadoPaciente.setBounds(297, 283, 143, 26);
		getContentPane().add(chckbxRecuperadoPaciente);
		
		btnCerrarVentana = new JButton("X");
		btnCerrarVentana.setBounds(548, 0, 52, 29);
		btnCerrarVentana.setFocusPainted(false);
		btnCerrarVentana.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrarVentana.setForeground(new Color(255, 255, 255));
		btnCerrarVentana.setFont(new Font("Montserrat Medium", Font.BOLD, 25));
		btnCerrarVentana.setBorder(null);
		btnCerrarVentana.setBackground(new Color(0, 118, 255));
		getContentPane().add(btnCerrarVentana);
		
		btnCerrarSesionMouseListener();
		
		/*
		 * Recuperado quita al paciente de la lista de pacientes que puede ver
		 */
		
	}
	
	/*
	 * Metodo que cierra la ventana sin modificar los datos 
	 */
	private void btnCerrarSesionMouseListener() {

		MouseListener nl = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		};

		btnCerrarVentana.addMouseListener(nl);
		btnCancelarModificacionPaciente.addMouseListener(nl);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}
	
}
