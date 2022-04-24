package panel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class ListadoBajasPacientePanel extends JPanel {

	private JTextField txtCicPaciente;
	private JTextField txtDniPaciente;
	private JTextField txtNombrePaciente;
	private JTextField txtApellidoPaciente;
	private JTextField txtTelefonoPaciente;
	private JTextField txtEnfermedadPaciente;

	private JButton btnModificarPaciente;
	private JLabel lblCicALtaPaciente;
	private JLabel lblDniALtaPaciente;
	private JLabel lblNombreALtaPaciente;
	private JLabel lblApellidoALtaPaciente;
	private JLabel lblTelefonoALtaPaciente;
	private JLabel lblEnfermedadALtaPaciente;
	
	private JButton btnDardeBajaPaciente;
	private JTextField txtBarraDeBusqueda;
	private JButton btnBotonBusquedaPaciente;
	
	
	public ListadoBajasPacientePanel() {

		
		setLayout(null);

		
		//if paciente en tabla = true {Visible hasta la linea 102}
		txtCicPaciente = new JTextField();
		txtCicPaciente.setBounds(481, 96, 170, 29);
		add(txtCicPaciente);
		txtCicPaciente.setColumns(10);

		txtDniPaciente = new JTextField();
		txtDniPaciente.setColumns(10);
		txtDniPaciente.setBounds(481, 208, 170, 29);
		add(txtDniPaciente);

		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(481, 307, 170, 29);
		add(txtNombrePaciente);

		txtApellidoPaciente = new JTextField();
		txtApellidoPaciente.setColumns(10);
		txtApellidoPaciente.setBounds(481, 402, 170, 29);
		add(txtApellidoPaciente);

		txtTelefonoPaciente = new JTextField();
		txtTelefonoPaciente.setColumns(10);
		txtTelefonoPaciente.setBounds(744, 92, 170, 29);
		add(txtTelefonoPaciente);

		txtEnfermedadPaciente = new JTextField();
		txtEnfermedadPaciente.setColumns(10);
		txtEnfermedadPaciente.setBounds(744, 208, 170, 29);
		add(txtEnfermedadPaciente);

		btnModificarPaciente = new JButton("REGISTRAR");
		btnModificarPaciente.setBounds(826, 493, 104, 36);
		add(btnModificarPaciente);

		lblCicALtaPaciente = new JLabel("CIC");
		lblCicALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblCicALtaPaciente.setBounds(481, 64, 170, 21);
		add(lblCicALtaPaciente);

		lblDniALtaPaciente = new JLabel("DNI");
		lblDniALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblDniALtaPaciente.setBounds(481, 173, 170, 21);
		add(lblDniALtaPaciente);

		lblNombreALtaPaciente = new JLabel("Nombre");
		lblNombreALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblNombreALtaPaciente.setBounds(481, 273, 170, 21);
		add(lblNombreALtaPaciente);

		lblApellidoALtaPaciente = new JLabel("Apellido/s");
		lblApellidoALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblApellidoALtaPaciente.setBounds(481, 377, 170, 21);
		add(lblApellidoALtaPaciente);

		lblTelefonoALtaPaciente = new JLabel("Telefono");
		lblTelefonoALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblTelefonoALtaPaciente.setBounds(744, 64, 170, 21);
		add(lblTelefonoALtaPaciente);

		lblEnfermedadALtaPaciente = new JLabel("Enfermedad");
		lblEnfermedadALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblEnfermedadALtaPaciente.setBounds(744, 173, 170, 21);
		add(lblEnfermedadALtaPaciente);

		btnDardeBajaPaciente = new JButton("BAJA");
		btnDardeBajaPaciente.setBounds(696, 493, 104, 36);
		add(btnDardeBajaPaciente);
		
		//Poner panel para señalar busqueda o no?
		
		txtBarraDeBusqueda = new JTextField();
		txtBarraDeBusqueda.setColumns(10);
		txtBarraDeBusqueda.setBounds(10, 64, 300, 35);
		add(txtBarraDeBusqueda);
		
		
		//Buscar imagen para boton
		btnBotonBusquedaPaciente = new JButton("");
		btnBotonBusquedaPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBotonBusquedaPaciente.setBounds(326, 62, 70, 37);
		add(btnBotonBusquedaPaciente);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(448, 64, 11, 492);
		add(separator);

		/*
		 * En caso de que se busque paciente
		 * 
		 * Jtable = new Jtable(); (Mandandole array[][] de pacientes)
		 * String Titles =  {CIC, Nombre, Enfermedad}
		 * 
		 */
		
	}
}
