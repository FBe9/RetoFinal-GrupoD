package panel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import gui.VentanaModificacionPaciente;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class ListadoBajasPacientePanel extends JPanel implements ActionListener{
	
	VentanaModificacionPaciente ventanaModificacion;
	
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

		setBounds(500, 200, 926, 607);
		setLayout(null);

		
		//if paciente en tabla = true {Visible hasta la linea 102}
		txtCicPaciente = new JTextField();
		txtCicPaciente.setBounds(446, 96, 172, 29);
		add(txtCicPaciente);
		txtCicPaciente.setColumns(10);

		txtDniPaciente = new JTextField();
		txtDniPaciente.setColumns(10);
		txtDniPaciente.setBounds(446, 187, 172, 29);
		add(txtDniPaciente);

		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(446, 261, 172, 29);
		add(txtNombrePaciente);

		txtApellidoPaciente = new JTextField();
		txtApellidoPaciente.setColumns(10);
		txtApellidoPaciente.setBounds(446, 356, 172, 29);
		add(txtApellidoPaciente);

		txtTelefonoPaciente = new JTextField();
		txtTelefonoPaciente.setColumns(10);
		txtTelefonoPaciente.setBounds(644, 96, 161, 29);
		add(txtTelefonoPaciente);

		txtEnfermedadPaciente = new JTextField();
		txtEnfermedadPaciente.setColumns(10);
		txtEnfermedadPaciente.setBounds(644, 187, 161, 29);
		add(txtEnfermedadPaciente);

		btnModificarPaciente = new JButton("MODIFICAR");
		btnModificarPaciente.setBounds(672, 449, 104, 36);
		add(btnModificarPaciente);

		lblCicALtaPaciente = new JLabel("CIC");
		lblCicALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblCicALtaPaciente.setBounds(446, 64, 172, 21);
		add(lblCicALtaPaciente);

		lblDniALtaPaciente = new JLabel("DNI");
		lblDniALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblDniALtaPaciente.setBounds(446, 153, 172, 21);
		add(lblDniALtaPaciente);

		lblNombreALtaPaciente = new JLabel("Nombre");
		lblNombreALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblNombreALtaPaciente.setBounds(446, 227, 172, 21);
		add(lblNombreALtaPaciente);

		lblApellidoALtaPaciente = new JLabel("Apellido/s");
		lblApellidoALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblApellidoALtaPaciente.setBounds(446, 331, 172, 21);
		add(lblApellidoALtaPaciente);

		lblTelefonoALtaPaciente = new JLabel("Telefono");
		lblTelefonoALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblTelefonoALtaPaciente.setBounds(644, 64, 132, 21);
		add(lblTelefonoALtaPaciente);

		lblEnfermedadALtaPaciente = new JLabel("Enfermedad");
		lblEnfermedadALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblEnfermedadALtaPaciente.setBounds(644, 155, 132, 21);
		add(lblEnfermedadALtaPaciente);

		btnDardeBajaPaciente = new JButton("BAJA");
		btnDardeBajaPaciente.setBounds(500, 449, 104, 36);
		add(btnDardeBajaPaciente);
		
		//Poner panel para señalar busqueda o no?
		
		txtBarraDeBusqueda = new JTextField();
		txtBarraDeBusqueda.setColumns(10);
		txtBarraDeBusqueda.setBounds(25, 64, 270, 35);
		add(txtBarraDeBusqueda);
		
		
		//Buscar imagen para boton
		btnBotonBusquedaPaciente = new JButton("");
		btnBotonBusquedaPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBotonBusquedaPaciente.setBounds(305, 62, 70, 37);
		add(btnBotonBusquedaPaciente);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(385, 60, 11, 492);
		add(separator);

		
		btnModificacionMouseListener();
		/*
		 * En caso de que se busque paciente
		 * 
		 * Jtable = new Jtable(); (Mandandole array[][] de pacientes)
		 * String Titles =  {CIC, Nombre, Enfermedad}
		 * 
		 */
		
	}
	
	private void btnModificacionMouseListener() {

		MouseListener ml = new MouseListener() {

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
				btnModificarPaciente.setBackground(new Color(255, 255, 255));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificarPaciente.setBackground(new Color(245, 245, 245));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setBounds(500, 200, 600, 600);
				ventanaModificacion.setVisible(true);
			}
		};

		btnModificarPaciente.addMouseListener(ml);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
