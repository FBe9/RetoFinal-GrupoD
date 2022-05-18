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
import javax.swing.JSeparator;
import java.awt.Cursor;

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
	private JSeparator separatorCodigoDelDepartamento;
	private JSeparator separatorCodigoDelDepartamento_1;
	private JSeparator separatorCodigoDelDepartamento_3;
	private JSeparator separatorCodigoDelDepartamento_4;
	private JSeparator separatorCodigoDelDepartamento_5;
	private JSeparator separatorCodigoDelDepartamento_6;

	/**
	 * Create the panel.
	 * @param usuario 
	 */
	public AltasPacientePanel(EmpleadosPacienteControlable pacientesInterface, Empleado empleado) {
		setBackground(new Color(245, 245, 245));
		this.pacientesInterface = pacientesInterface;
		this.empleado = empleado;
		
		setLayout(null);
		setBounds(500, 200, 870, 568);
		btnRegistrarPaciente = new JButton("Registrar");
		btnRegistrarPaciente.setFocusPainted(false);
		btnRegistrarPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnRegistrarPaciente.setForeground(new Color(255, 255, 255));
		btnRegistrarPaciente.setBackground(new Color(0, 118, 255));
		btnRegistrarPaciente.setBorder(null);
		btnRegistrarPaciente.setBounds(640, 501, 172, 36);
		add(btnRegistrarPaciente);
		btnRegistrarPacienteMouseListener();

		lblCicALtaPaciente = new JLabel("CIC");
		lblCicALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblCicALtaPaciente.setBounds(68, 77, 170, 21);
		add(lblCicALtaPaciente);

		lblDniALtaPaciente = new JLabel("DNI");
		lblDniALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblDniALtaPaciente.setBounds(68, 186, 170, 21);
		add(lblDniALtaPaciente);

		lblNombreALtaPaciente = new JLabel("Nombre");
		lblNombreALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblNombreALtaPaciente.setBounds(68, 299, 170, 21);
		add(lblNombreALtaPaciente);

		lblApellidoALtaPaciente = new JLabel("Apellido");
		lblApellidoALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblApellidoALtaPaciente.setBounds(68, 409, 170, 21);
		add(lblApellidoALtaPaciente);

		lblTelefonoALtaPaciente = new JLabel("Telefono");
		lblTelefonoALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblTelefonoALtaPaciente.setBounds(323, 186, 170, 21);
		add(lblTelefonoALtaPaciente);

		lblEnfermedadALtaPaciente = new JLabel("Enfermedad");
		lblEnfermedadALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblEnfermedadALtaPaciente.setBounds(323, 299, 170, 21);
		add(lblEnfermedadALtaPaciente);

		lblMedicoPaciente = new JLabel("Medico asigando");
		lblMedicoPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblMedicoPaciente.setBounds(563, 77, 170, 21);
		add(lblMedicoPaciente);

		lblEnfermeroPaciente = new JLabel("Enfermero asigando");
		lblEnfermeroPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblEnfermeroPaciente.setBounds(563, 186, 170, 21);
		add(lblEnfermeroPaciente);
	
		cboxMedicosPaciente = new JComboBox<String>(); //Aniadir Medicos
		cboxMedicosPaciente.setBorder(null);
		ArrayList<String> doctores = new ArrayList<>(pacientesInterface.listaMedicos());
		for (String doctor : doctores) {
			cboxMedicosPaciente.addItem(doctor);
		}
		cboxMedicosPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 11));
		cboxMedicosPaciente.setMaximumRowCount(5);
		cboxMedicosPaciente.setBounds(563, 116, 170, 22);
		cboxMedicosPaciente.setSelectedIndex(-1);
		add(cboxMedicosPaciente);

		cbxEnfermerosPaciente = new JComboBox<String>(); // Aniadir Enfermeros
		cbxEnfermerosPaciente.setBorder(null);
		ArrayList<String> enfermeros = new ArrayList<>(pacientesInterface.listaEnfermeros());
		for (String enfermero : enfermeros) {
			cbxEnfermerosPaciente.addItem(enfermero);
		}
		cbxEnfermerosPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 11));
		cbxEnfermerosPaciente.setMaximumRowCount(5);
		cbxEnfermerosPaciente.setSelectedIndex(-1);
		cbxEnfermerosPaciente.setBounds(563, 228, 170, 22);
		add(cbxEnfermerosPaciente);
		
		txtCicPaciente = new JTextField();
		txtCicPaciente.setBorder(null);
		txtCicPaciente.setBackground(new Color(245, 245, 245));
		txtCicPaciente.setForeground(new Color(128, 128, 128));
		txtCicPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtCicPaciente.setText("CE + numero del paciente");
		txtCicPaciente.setBounds(68, 109, 170, 29);
		add(txtCicPaciente);
		txtCicPaciente.setColumns(10);

		txtDniPaciente = new JTextField();
		txtDniPaciente.setBorder(null);
		txtDniPaciente.setBackground(new Color(245, 245, 245));
		txtDniPaciente.setForeground(new Color(128, 128 ,128));
		txtDniPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtDniPaciente.setText("00000000A");
		txtDniPaciente.setColumns(10);
		txtDniPaciente.setBounds(68, 221, 170, 29);
		add(txtDniPaciente);

		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setBorder(null);
		txtNombrePaciente.setBackground(new Color(245, 245, 245));
		txtNombrePaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(68, 333, 170, 29);
		add(txtNombrePaciente);

		txtApellidoPaciente = new JTextField();
		txtApellidoPaciente.setBorder(null);
		txtApellidoPaciente.setBackground(new Color(245, 245, 245));
		txtApellidoPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtApellidoPaciente.setColumns(10);
		txtApellidoPaciente.setBounds(68, 434, 170, 29);
		add(txtApellidoPaciente);

		txtTelefonoPaciente = new JTextField();
		txtTelefonoPaciente.setBorder(null);
		txtTelefonoPaciente.setBackground(new Color(245, 245, 245));
		txtTelefonoPaciente.setForeground(new Color(128, 128 ,128));
		txtTelefonoPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtTelefonoPaciente.setText("9 Caracteres maximo");
		txtTelefonoPaciente.setColumns(10);
		txtTelefonoPaciente.setBounds(323, 222, 170, 29);
		add(txtTelefonoPaciente);

		txtEnfermedadPaciente = new JTextField();
		txtEnfermedadPaciente.setBorder(null);
		txtEnfermedadPaciente.setBackground(new Color(245, 245, 245));
		txtEnfermedadPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtEnfermedadPaciente.setColumns(10);
		txtEnfermedadPaciente.setBounds(323, 333, 170, 29);
		add(txtEnfermedadPaciente);

		JLabel lblApellido2ALtaPaciente = new JLabel("Apellido");
		lblApellido2ALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblApellido2ALtaPaciente.setBounds(323, 77, 170, 21);
		add(lblApellido2ALtaPaciente);

		txtApellido2Paciente = new JTextField();
		txtApellido2Paciente.setBorder(null);
		txtApellido2Paciente.setBackground(new Color(245, 245, 245));
		txtApellido2Paciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtApellido2Paciente.setColumns(10);
		txtApellido2Paciente.setBounds(323, 110, 170, 29);
		add(txtApellido2Paciente);
		
		JSeparator separatorCodigoDelDepartamento_2 = new JSeparator();
		separatorCodigoDelDepartamento_2.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_2.setBounds(68, 139, 170, 2);
		add(separatorCodigoDelDepartamento_2);
		
		separatorCodigoDelDepartamento = new JSeparator();
		separatorCodigoDelDepartamento.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento.setBounds(68, 250, 170, 2);
		add(separatorCodigoDelDepartamento);
		
		separatorCodigoDelDepartamento_1 = new JSeparator();
		separatorCodigoDelDepartamento_1.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1.setBounds(68, 362, 170, 2);
		add(separatorCodigoDelDepartamento_1);
		
		separatorCodigoDelDepartamento_3 = new JSeparator();
		separatorCodigoDelDepartamento_3.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_3.setBounds(68, 464, 170, 2);
		add(separatorCodigoDelDepartamento_3);
		
		separatorCodigoDelDepartamento_4 = new JSeparator();
		separatorCodigoDelDepartamento_4.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_4.setBounds(323, 139, 170, 2);
		add(separatorCodigoDelDepartamento_4);
		
		separatorCodigoDelDepartamento_5 = new JSeparator();
		separatorCodigoDelDepartamento_5.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_5.setBounds(323, 252, 170, 2);
		add(separatorCodigoDelDepartamento_5);
		
		separatorCodigoDelDepartamento_6 = new JSeparator();
		separatorCodigoDelDepartamento_6.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_6.setBounds(323, 362, 170, 2);
		add(separatorCodigoDelDepartamento_6);

		txtCodigoUsuarioMouseListener();
		txtTelefonoPacienteMouseListener();
		txtDniPacienteoMouseListener();
		darDeAltaMouseListener(pacientesInterface);

	}

	private void btnRegistrarPacienteMouseListener() {
		
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
				btnRegistrarPaciente.setBackground(new Color(0, 118, 255));
				btnRegistrarPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistrarPaciente.setBackground(new Color(0, 80, 255));
				btnRegistrarPaciente.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};

		btnRegistrarPaciente.addMouseListener(ml);
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

				if (txtTelefonoPaciente.getText().equals("9 Caracteres maximo")) {
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

					pacientesInterface.aniadirPaciente(paciente);
					
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
