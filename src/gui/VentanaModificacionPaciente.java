package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import clases.Paciente;
import interfaces.EmpleadosPacienteControlable;
import panel.ListadoBajasPacientePanel;

import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.Cursor;

/**
 * Esta ventana recoge los datos de un paciente para modificarlos
 * @author Emil
 *
 */

public class VentanaModificacionPaciente extends JDialog implements ActionListener{

	protected static final Component VentanaModificacionPaciente = null;
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
	private JLabel lblApellido2ALtaPaciente;
	private JLabel lblHeaderApp;
	private JCheckBox chckbxRecuperadoPaciente;
	private Paciente pac;
	private EmpleadosPacienteControlable pacientesInterface;
	
	private JButton btnCerrarVentana;
	private JButton btnModificarPaciente;
	private JButton btnCancelarModificacionPaciente;
	private JTextField txtSegundoApellido;
	
	private int xPositionMouse, yPositionMouse;
	private JSeparator separatorCodigoDelDepartamento_1;
	private JSeparator separatorCodigoDelDepartamento_1_1;
	private JSeparator separatorCodigoDelDepartamento_1_2;
	private JSeparator separatorCodigoDelDepartamento_1_3;
	private JSeparator separatorCodigoDelDepartamento_1_4;
	private JSeparator separatorCodigoDelDepartamento_1_5;
	private JSeparator separatorCodigoDelDepartamento_1_6;
	
	public VentanaModificacionPaciente(Paciente pac, EmpleadosPacienteControlable pacientesInterface) {
		this.pac = pac;
		this.pacientesInterface = pacientesInterface;
		
		getContentPane().setBackground(new Color(255, 255, 255));
		//Disenio de la ventana
		setModal(true);
		setUndecorated(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(600, 300, 600, 600);
		
		txtCicPaciente = new JTextField();
		txtCicPaciente.setBackground(new Color(255, 255, 255));
		txtCicPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtCicPaciente.setBorder(null);
		txtCicPaciente.setEditable(false);
		txtCicPaciente.setBounds(35, 103, 170, 29);
		getContentPane().add(txtCicPaciente);
		txtCicPaciente.setColumns(10);
		
		txtDniPaciente = new JTextField();
		txtDniPaciente.setBackground(new Color(255, 255, 255));
		txtDniPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtDniPaciente.setBorder(null);
		txtDniPaciente.setEditable(false);
		txtDniPaciente.setColumns(10);
		txtDniPaciente.setBounds(35, 195, 170, 29);
		getContentPane().add(txtDniPaciente);
		
		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setBackground(new Color(255, 255, 255));
		txtNombrePaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtNombrePaciente.setBorder(null);
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(35, 283, 170, 29);
		getContentPane().add(txtNombrePaciente);
		
		txtApellidoPaciente = new JTextField();
		txtApellidoPaciente.setBackground(new Color(255, 255, 255));
		txtApellidoPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtApellidoPaciente.setBorder(null);
		txtApellidoPaciente.setColumns(10);
		txtApellidoPaciente.setBounds(285, 291, 170, 29);
		getContentPane().add(txtApellidoPaciente);
		
		txtTelefonoPaciente = new JTextField();
		txtTelefonoPaciente.setBackground(new Color(255, 255, 255));
		txtTelefonoPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtTelefonoPaciente.setBorder(null);
		txtTelefonoPaciente.setColumns(10);
		txtTelefonoPaciente.setBounds(285, 99, 170, 29);
		getContentPane().add(txtTelefonoPaciente);
		
		txtEnfermedadPaciente = new JTextField();
		txtEnfermedadPaciente.setBackground(new Color(255, 255, 255));
		txtEnfermedadPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtEnfermedadPaciente.setBorder(null);
		txtEnfermedadPaciente.setColumns(10);
		txtEnfermedadPaciente.setBounds(285, 195, 170, 29);
		getContentPane().add(txtEnfermedadPaciente);
		
		lblCicALtaPaciente = new JLabel("CIC");
		lblCicALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblCicALtaPaciente.setBounds(35, 71, 170, 21);
		getContentPane().add(lblCicALtaPaciente);
		
		lblDniALtaPaciente = new JLabel("DNI");
		lblDniALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblDniALtaPaciente.setBounds(35, 160, 170, 21);
		getContentPane().add(lblDniALtaPaciente);
		
		lblNombreALtaPaciente = new JLabel("Nombre");
		lblNombreALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblNombreALtaPaciente.setBounds(35, 251, 170, 21);
		getContentPane().add(lblNombreALtaPaciente);
		
		lblApellidoALtaPaciente = new JLabel("Apellido");
		lblApellidoALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblApellidoALtaPaciente.setBounds(285, 251, 170, 21);
		getContentPane().add(lblApellidoALtaPaciente);
		
		lblTelefonoALtaPaciente = new JLabel("Telefono");
		lblTelefonoALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblTelefonoALtaPaciente.setBounds(285, 67, 170, 21);
		getContentPane().add(lblTelefonoALtaPaciente);
		
		lblEnfermedadALtaPaciente = new JLabel("Enfermedad");
		lblEnfermedadALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblEnfermedadALtaPaciente.setBounds(285, 160, 170, 21);
		getContentPane().add(lblEnfermedadALtaPaciente);
		
		chckbxRecuperadoPaciente = new JCheckBox("Recuperado");
		chckbxRecuperadoPaciente.setBackground(new Color(255, 255, 255));
		chckbxRecuperadoPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		chckbxRecuperadoPaciente.setBounds(285, 389, 143, 26);
		getContentPane().add(chckbxRecuperadoPaciente);
		
		btnCerrarVentana = new JButton("x");
		btnCerrarVentana.setBounds(532, 0, 68, 29);
		btnCerrarVentana.setFocusPainted(false);
		btnCerrarVentana.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrarVentana.setForeground(new Color(255, 255, 255));
		btnCerrarVentana.setFont(new Font("Montserrat Medium", Font.BOLD, 25));
		btnCerrarVentana.setBorder(null);
		btnCerrarVentana.setBackground(new Color(0, 118, 255));
		getContentPane().add(btnCerrarVentana);
		
		lblApellido2ALtaPaciente = new JLabel("Segundo apellido");
		lblApellido2ALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblApellido2ALtaPaciente.setBounds(35, 349, 170, 21);
		getContentPane().add(lblApellido2ALtaPaciente);
		
		
		txtSegundoApellido = new JTextField();
		txtSegundoApellido.setBackground(new Color(255, 255, 255));
		txtSegundoApellido.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtSegundoApellido.setBorder(null);
		txtSegundoApellido.setColumns(10);
		txtSegundoApellido.setBounds(35, 389, 170, 29);
		getContentPane().add(txtSegundoApellido);
		
		txtCicPaciente.setText(pac.getCic());
		txtDniPaciente.setText(pac.getDniPaciente());
		txtNombrePaciente.setText(pac.getNombrePaciente());
		txtTelefonoPaciente.setText(pac.getTlf());
		txtEnfermedadPaciente.setText(pac.getEnfermedad());
		txtApellidoPaciente.setText(pac.getApellidoPaciente());
		txtSegundoApellido.setText(pac.getApellido2Paciente());
		chckbxRecuperadoPaciente.setSelected(pac.isPacienteRecuperado());
		
		lblHeaderApp = new JLabel("");
		lblHeaderApp.setBounds(0, 0, 532, 29);
		getContentPane().add(lblHeaderApp);
		
		separatorCodigoDelDepartamento_1 = new JSeparator();
		separatorCodigoDelDepartamento_1.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1.setBounds(35, 133, 170, 2);
		getContentPane().add(separatorCodigoDelDepartamento_1);
		
		separatorCodigoDelDepartamento_1_1 = new JSeparator();
		separatorCodigoDelDepartamento_1_1.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1_1.setBounds(35, 225, 170, 2);
		getContentPane().add(separatorCodigoDelDepartamento_1_1);
		
		separatorCodigoDelDepartamento_1_2 = new JSeparator();
		separatorCodigoDelDepartamento_1_2.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1_2.setBounds(35, 313, 170, 2);
		getContentPane().add(separatorCodigoDelDepartamento_1_2);
		
		separatorCodigoDelDepartamento_1_3 = new JSeparator();
		separatorCodigoDelDepartamento_1_3.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1_3.setBounds(35, 418, 170, 2);
		getContentPane().add(separatorCodigoDelDepartamento_1_3);
		
		separatorCodigoDelDepartamento_1_4 = new JSeparator();
		separatorCodigoDelDepartamento_1_4.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1_4.setBounds(285, 129, 170, 2);
		getContentPane().add(separatorCodigoDelDepartamento_1_4);
		
		separatorCodigoDelDepartamento_1_5 = new JSeparator();
		separatorCodigoDelDepartamento_1_5.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1_5.setBounds(285, 225, 170, 2);
		getContentPane().add(separatorCodigoDelDepartamento_1_5);
		
		separatorCodigoDelDepartamento_1_6 = new JSeparator();
		separatorCodigoDelDepartamento_1_6.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1_6.setBounds(285, 321, 170, 2);
		getContentPane().add(separatorCodigoDelDepartamento_1_6);
		
		btnModificarPaciente = new JButton("Modificar");
		btnModificarPaciente.setFocusPainted(false);
		btnModificarPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarPaciente.setForeground(Color.WHITE);
		btnModificarPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnModificarPaciente.setBorder(null);
		btnModificarPaciente.setBackground(new Color(0, 118, 255));
		btnModificarPaciente.setBounds(400, 494, 172, 36);
		getContentPane().add(btnModificarPaciente);
		
		btnCancelarModificacionPaciente = new JButton("Cancelar");
		btnCancelarModificacionPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelarModificacionPaciente.setFocusPainted(false);
		btnCancelarModificacionPaciente.setForeground(Color.WHITE);
		btnCancelarModificacionPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnCancelarModificacionPaciente.setBorder(null);
		btnCancelarModificacionPaciente.setBackground(new Color(0, 118, 255));
		btnCancelarModificacionPaciente.setBounds(218, 494, 172, 36);
		getContentPane().add(btnCancelarModificacionPaciente);
		
		btnCerrarModificacionMouseListener();
		btnModificarMouseListener(pacientesInterface, pac);
		lblHeaderAppMouseListener();
		lblHeaderAppMouseMotionListener();
		btnCancelarModificacionMouseListener();
		btnModificarPacienteMouseListener();
		btnCancelarModificacionPacienteMouseListener();
		btnCerrarVentanaMouseListener();
		
		/*
		 * Recuperado quita al paciente de la lista de pacientes que puede ver
		 */
		
	}
	
	private void btnCerrarVentanaMouseListener() {
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
				btnCerrarVentana.setBackground(new Color(0, 118, 255));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnCerrarVentana.setBackground(new Color(209, 26, 42));

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		};

		btnCerrarVentana.addMouseListener(ml);
		
	}

	private void btnCancelarModificacionPacienteMouseListener() {
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
				btnCancelarModificacionPaciente.setBackground(new Color(0, 118, 255));
				btnCancelarModificacionPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancelarModificacionPaciente.setBackground(new Color(0, 80, 255));
				btnCancelarModificacionPaciente.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		};

		btnCancelarModificacionPaciente.addMouseListener(ml);
	}

	private void btnModificarPacienteMouseListener() {
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
				btnModificarPaciente.setBackground(new Color(0, 118, 255));
				btnModificarPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificarPaciente.setBackground(new Color(0, 80, 255));
				btnModificarPaciente.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		};

		btnModificarPaciente.addMouseListener(ml);
	}

	/*
	 * Metodo que cierra la ventana sin modificar los datos 
	 */
	private void lblHeaderAppMouseMotionListener() {

		MouseMotionListener mml = new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xPositionMouse, y - yPositionMouse);

			}
		};

		lblHeaderApp.addMouseMotionListener(mml);

	}

	private void lblHeaderAppMouseListener() {

		MouseListener ml = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				xPositionMouse = e.getX();
				yPositionMouse = e.getY();

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

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

		lblHeaderApp.addMouseListener(ml);

	}
	
	
	private void btnCerrarModificacionMouseListener() {

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
				int confirmado = JOptionPane.showConfirmDialog(VentanaModificacionPaciente, "Estas seguro de querer cancelar la modificacion?", "",JOptionPane.OK_CANCEL_OPTION,  JOptionPane.INFORMATION_MESSAGE);
				if (JOptionPane.OK_OPTION == confirmado) {
					JOptionPane.showMessageDialog(VentanaModificacionPaciente, "Modificacion cancelada");
					dispose();
				}else {
					dispose();
				}
			}
		};

		btnCerrarVentana.addMouseListener(nl);
		
	}
	
	private void btnCancelarModificacionMouseListener() {

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
				int confirmado = JOptionPane.showConfirmDialog(VentanaModificacionPaciente, "Estas seguro de querer cancelar la modificacion?", "",JOptionPane.OK_CANCEL_OPTION,  JOptionPane.INFORMATION_MESSAGE);
				if (JOptionPane.OK_OPTION == confirmado) {
					JOptionPane.showMessageDialog(VentanaModificacionPaciente, "Modificacion cancelada");
					dispose();
				}else {
					dispose();
				}
			}
		};

		btnCancelarModificacionPaciente.addMouseListener(nl);
		
	}
	
	private void btnModificarMouseListener(EmpleadosPacienteControlable pacientesInterface, Paciente pac) {

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
				Paciente paciente = new Paciente(txtCicPaciente.getText(), pac.getCodEmpleadoDoctor(), pac.getCodEmpleadoEnfermero(), txtDniPaciente.getText(),
						txtNombrePaciente.getText(), txtApellidoPaciente.getText(), txtSegundoApellido.getText(), txtTelefonoPaciente.getText(), txtEnfermedadPaciente.getText(),
						chckbxRecuperadoPaciente.isSelected());
				
				int confirmado = JOptionPane.showConfirmDialog(VentanaModificacionPaciente,"Estas seguro de querer modificar?", "", JOptionPane.INFORMATION_MESSAGE);
				if (JOptionPane.OK_OPTION == confirmado) {
					pacientesInterface.modificarPaciente(paciente, pac.getCic());
					dispose();
				} else {
					JOptionPane.showMessageDialog(VentanaModificacionPaciente, "Modificacion cancelada");
					dispose();
				}
			}
		};

		btnModificarPaciente.addMouseListener(nl);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}
}