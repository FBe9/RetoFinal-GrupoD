package panel;

import javax.swing.JPanel;


import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import clases.Doctor;
import clases.Empleado;
import clases.Paciente;
import interfaces.EmpleadosPacienteControlable;

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

	private JComboBox<String> cboxMedicosPaciente;
	private JComboBox<String> cbxEnfermerosPaciente;
	private JTextField txtApellido2Paciente;
	private EmpleadosPacienteControlable pacientesInterface;
	private Empleado empleado;

	/**
	 * Create the panel.
	 * @param usuario 
	 */
	public AltasPacientePanel(EmpleadosPacienteControlable pacientesInterface, Empleado empleado) {
		this.pacientesInterface = pacientesInterface;
		this.empleado = empleado;
		
		setLayout(null);
		setBounds(500, 200, 822, 583);

		btnRegistrarPaciente = new JButton("REGISTRAR");
		btnRegistrarPaciente.setBounds(563, 471, 199, 36);
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

		lblApellidoALtaPaciente = new JLabel("Apellido");
		lblApellidoALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblApellidoALtaPaciente.setBounds(68, 409, 170, 21);
		add(lblApellidoALtaPaciente);

		lblTelefonoALtaPaciente = new JLabel("Telefono");
		lblTelefonoALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblTelefonoALtaPaciente.setBounds(323, 186, 170, 21);
		add(lblTelefonoALtaPaciente);

		lblEnfermedadALtaPaciente = new JLabel("Enfermedad");
		lblEnfermedadALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblEnfermedadALtaPaciente.setBounds(323, 299, 170, 21);
		add(lblEnfermedadALtaPaciente);

		lblMedicoPaciente = new JLabel("Medico asigando");
		lblMedicoPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblMedicoPaciente.setBounds(563, 77, 170, 21);
		add(lblMedicoPaciente);

		lblEnfermeroPaciente = new JLabel("Enfermero asigando");
		lblEnfermeroPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblEnfermeroPaciente.setBounds(563, 186, 170, 21);
		add(lblEnfermeroPaciente);
	
		cboxMedicosPaciente = new JComboBox<String>(); //Añadir Medicos
		ArrayList<String> doctores = new ArrayList<>(pacientesInterface.listaMedicos());
		for (String doctor : doctores) {
			cboxMedicosPaciente.addItem(doctor);
		}
		cboxMedicosPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 11));
		cboxMedicosPaciente.setMaximumRowCount(5);
		cboxMedicosPaciente.setBounds(563, 109, 170, 22);
		cboxMedicosPaciente.setSelectedIndex(-1);
		add(cboxMedicosPaciente);

		cbxEnfermerosPaciente = new JComboBox<String>(); // Añadir Enfermeros
		ArrayList<String> enfermeros = new ArrayList<>(pacientesInterface.listaEnfermeros());
		for (String enfermero : enfermeros) {
			cbxEnfermerosPaciente.addItem(enfermero);
		}
		cbxEnfermerosPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 11));
		cbxEnfermerosPaciente.setMaximumRowCount(5);
		cbxEnfermerosPaciente.setSelectedIndex(-1);
		cbxEnfermerosPaciente.setBounds(563, 225, 170, 22);
		add(cbxEnfermerosPaciente);
		
		txtCicPaciente = new JTextField();
		txtCicPaciente.setText("CE + numero del paciente");
		txtCicPaciente.setBounds(68, 109, 170, 29);
		add(txtCicPaciente);
		txtCicPaciente.setColumns(10);

		txtDniPaciente = new JTextField();
		txtDniPaciente.setText("00000000A");
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
		txtTelefonoPaciente.setText("*********");
		txtTelefonoPaciente.setColumns(10);
		txtTelefonoPaciente.setBounds(323, 218, 170, 29);
		add(txtTelefonoPaciente);

		txtEnfermedadPaciente = new JTextField();
		txtEnfermedadPaciente.setColumns(10);
		txtEnfermedadPaciente.setBounds(323, 330, 170, 29);
		add(txtEnfermedadPaciente);

		JLabel lblApellido2ALtaPaciente = new JLabel("Apellido");
		lblApellido2ALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblApellido2ALtaPaciente.setBounds(323, 77, 170, 21);
		add(lblApellido2ALtaPaciente);

		txtApellido2Paciente = new JTextField();
		txtApellido2Paciente.setColumns(10);
		txtApellido2Paciente.setBounds(323, 102, 170, 29);
		add(txtApellido2Paciente);

		txtCodigoUsuarioMouseListener();
		txtTelefonoPacienteMouseListener();
		txtDniPacienteoMouseListener();
		darDeAltaMouseListener(pacientesInterface);

	}

	private void txtCodigoUsuarioMouseListener() {

		MouseListener ml = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (txtCicPaciente.getText().equals("CE + numero del paciente")) {
					txtCicPaciente.setText("");
					txtCicPaciente.setForeground(Color.BLACK);
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};

		txtCicPaciente.addMouseListener(ml);

	}

	private void txtDniPacienteoMouseListener() {
		MouseListener ml = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (txtDniPaciente.getText().equals("00000000A")) {
					txtDniPaciente.setText("");
					txtDniPaciente.setForeground(Color.BLACK);
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};

		txtDniPaciente.addMouseListener(ml);
	}

	private void txtTelefonoPacienteMouseListener() {
		MouseListener ml = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

				if (txtTelefonoPaciente.getText().equals("*********")) {
					txtTelefonoPaciente.setText("");
					txtTelefonoPaciente.setForeground(Color.BLACK);
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};

		txtTelefonoPaciente.addMouseListener(ml);
	}

	private void darDeAltaMouseListener(EmpleadosPacienteControlable pacientesInterface) {
		MouseListener ml = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (txtCicPaciente.getText().isEmpty() || txtDniPaciente.getText().isEmpty()
						|| txtNombrePaciente.getText().isEmpty() || txtApellidoPaciente.getText().isEmpty()
						|| txtTelefonoPaciente.getText().isEmpty() || txtEnfermedadPaciente.getText().isEmpty()
						|| (cboxMedicosPaciente.getSelectedIndex() == -1)
						|| (cbxEnfermerosPaciente.getSelectedIndex() == -1)) {

					JOptionPane.showMessageDialog(btnRegistrarPaciente, "Error, falta algun dato por rellenar");
					
				} else {
					Paciente paciente;
					String codigoMedico = (String) cboxMedicosPaciente.getSelectedItem();
					String codigoEnfermero = (String) cbxEnfermerosPaciente.getSelectedItem();

					paciente = new Paciente(txtCicPaciente.getText(), codigoMedico, codigoEnfermero,
							txtDniPaciente.getText(), txtNombrePaciente.getText(), txtApellidoPaciente.getText(),
							txtApellido2Paciente.getText(), txtTelefonoPaciente.getText(),
							txtEnfermedadPaciente.getText(), false);

					pacientesInterface.añadirPaciente(paciente);
					
					txtCicPaciente.setText("CE + numero del paciente");
					txtDniPaciente.setText("00000000A");
					txtNombrePaciente.setText(" ");
					txtApellidoPaciente.setText(" ");
					txtTelefonoPaciente.setText("*********");
					txtEnfermedadPaciente.setText(" ");
					cboxMedicosPaciente.setSelectedIndex(-1);
					cbxEnfermerosPaciente.setSelectedIndex(-1);
					txtApellido2Paciente.setText(" ");
				}

			}
		};

		btnRegistrarPaciente.addMouseListener(ml);
	}
}
