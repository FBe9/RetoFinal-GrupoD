package gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Cursor;
import com.toedter.calendar.JDateChooser;

import interfaces.EmpleadoControlable;
import interfaces.EmpleadoControlableBDImplementation;

import javax.swing.JRadioButton;
import java.awt.SystemColor;
/**
 * Gestion de Empleados por el Administrador
 * @author Nerea
 *
 */
public class VentanaGestionEmpleados extends JDialog implements ActionListener {

	//Paneles
	private JPanel background;
	private JPanel menuHospitalContainer;
	private JPanel panelAlta;
	private JPanel panelMasInfo;
	private JPanel panelModificacion;

	private JLabel lblHeaderApp;
	private JLabel lblNombreHospital;
	private JLabel lblHospitalIcono;
	private JLabel lblAlta;
	private JLabel lblModificacion;
	private JLabel lblCdigoDelDepartamento_3;
	private JLabel lblNombreDelDepartamento_3;
	private JLabel lblEspecialidad_3;
	private JTextField txtBarraDeBusqueda_2;
	private JTextField textFieldCdigoDelDepartamento_3;
	private JTextField textFieldNombreDelDepartamento_3;

	private JButton btnAlta;
	private JButton btnMasInformacion;
	private JButton btnBajaModificacion;
	private JButton btnCerrarApp;
	private JButton btnBusqueda_2;
	private JButton btnVolverAlMenu;
	private JButton btnCerrarSesion;
	
	//Alta
	private int xPositionMouse, yPositionMouse;
	private JTextField txtCodEmpleA;
	private JTextField txtDniEmpleA;
	private JTextField txtNombreEmpleA;
	private JTextField txtApellidosEmpleA;
	private JLabel lblCodigoEmpleA;
	private JLabel lblDniEmpleA;
	private JLabel lblNomEmpleA;
	private JLabel lblApellidosDelEmpleadoA;
	private JLabel lblNomDepartA;
	private JComboBox comboBoxNomDepartA;
	private JLabel lblContratoA;
	private JLabel lblFechaInicioA;
	private JDateChooser dcFechaInicioA;
	private JDateChooser dcFechaFinA;
	private JLabel lblFechaFinA;
	private JComboBox comboBoxContratoA;
	private JCheckBox chckbxActivoA;
	private JComboBox comboBoxEspecialidadA; 
	private JLabel lblActivoA;
	private JLabel lblTipoEmpleA;
	private JLabel lblEspecialidadA;
	private JRadioButton rdbtnDoctorA;
	private JRadioButton rdbtnEnfermeroA;
	private JLabel lblHorarioA;
	private JComboBox comboBoxHorarioA;
	private JButton btnRegistrarA;
	private JSeparator separadorAlta;
	
	//Mas info
	private JLabel lblMasInfo;
	private JLabel lblCodigoEmpleMI;
	private JTextField txtCodigoEmpleMI;
	private JLabel lblDniEmpleMI;
	private JTextField txtDniEmpleMI;
	private JLabel lblNomEmpleB;
	private JTextField txtNomEmpleMI;
	private JLabel lblApellido1DelEmpleMI;
	private JTextField txtApellido1DelEmpleMI;
	private JLabel lblNomDepartMI;
	private JComboBox comboBoxNomDepartMI;
	private JLabel lblContratoMI;
	private JComboBox comboBoxContratoMI;
	private JLabel lblFechaInicioMI;
	private JDateChooser dcFechaInicioMI;
	private JLabel lblFechaFinMI;
	private JDateChooser dcFechaFinMI;
	private JCheckBox chckbxActivoMI;
	private JLabel lblActivoMI;
	private JLabel lblTipoEmpleMI;
	private JRadioButton rdbtnEnfermeroMI;
	private JRadioButton rdbtnDoctorMI;
	private JLabel lblEspecialidadMI;
	private JComboBox comboBoxEspecialidadMI;
	private JLabel lblHorarioMI;
	private JComboBox comboBoxHorarioMI;
	private JButton btnIrVentanaModificar;
	private JSeparator separadorBajaMod;
	private JTextField txtApellido2DelEmpleMI;
	private JTextField textField;
	private JLabel lblDniEmpleMI_1;
	private JTextField textField_1;
	private JLabel lblApellido1DelEmpleMI_1;
	private JTextField textField_2;
	private JLabel lblApellido2DelEmpleMI_1;
	private JTextField textField_3;

	public VentanaGestionEmpleados(EmpleadoControlable datosE) {
		setUndecorated(true);
		setLocationByPlatform(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imgs/cruzRoja.png")));
		setBounds(500, 200, 1100, 600);
		getContentPane().setLayout(null);

		btnCerrarApp = new JButton("x");
		btnCerrarApp.setBounds(1032, 0, 68, 31);
		getContentPane().add(btnCerrarApp);
		btnCerrarApp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrarApp.setForeground(Color.WHITE);
		btnCerrarApp.setFont(new Font("Montserrat Medium", Font.BOLD, 25));
		btnCerrarApp.setFocusPainted(false);
		btnCerrarApp.setBorder(null);
		btnCerrarApp.setBackground(new Color(0, 118, 255));

		background = new JPanel();
		background.setBackground(new Color(248, 250, 251));
		background.setBounds(0, 0, 1100, 600);
		background.setLayout(null);
		getContentPane().add(background);

		// Panel de Alta
		panelAlta = new JPanel();
		panelAlta.setBounds(234, 32, 866, 568);
		panelAlta.setVisible(true);

		lblCodigoEmpleA = new JLabel("C\u00F3digo del empleado");
		lblCodigoEmpleA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblCodigoEmpleA.setBounds(29, 95, 167, 22);
		panelAlta.add(lblCodigoEmpleA);

		txtCodEmpleA = new JTextField();
		txtCodEmpleA.setEditable(false);
		txtCodEmpleA.setForeground(Color.WHITE);
		txtCodEmpleA.setColumns(10);
		txtCodEmpleA.setBackground(Color.WHITE);
		txtCodEmpleA.setBounds(29, 134, 174, 22);
		panelAlta.add(txtCodEmpleA);

		lblDniEmpleA = new JLabel("DNI del empleado");
		lblDniEmpleA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblDniEmpleA.setBounds(29, 174, 167, 22);
		panelAlta.add(lblDniEmpleA);

		txtDniEmpleA = new JTextField();
		txtDniEmpleA.setForeground(Color.WHITE);
		txtDniEmpleA.setEditable(false);
		txtDniEmpleA.setColumns(10);
		txtDniEmpleA.setBackground(Color.WHITE);
		txtDniEmpleA.setBounds(29, 207, 174, 22);
		panelAlta.add(txtDniEmpleA);
		
		lblNomEmpleA = new JLabel("Nombre del empleado");
		lblNomEmpleA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblNomEmpleA.setBounds(29, 245, 185, 22);
		panelAlta.add(lblNomEmpleA);

		txtNombreEmpleA = new JTextField();
		txtNombreEmpleA.setForeground(Color.WHITE);
		txtNombreEmpleA.setEditable(false);
		txtNombreEmpleA.setColumns(10);
		txtNombreEmpleA.setBackground(Color.WHITE);
		txtNombreEmpleA.setBounds(29, 278, 174, 22);
		panelAlta.add(txtNombreEmpleA);
		
		lblApellidosDelEmpleadoA = new JLabel("Apellidos del empleado");
		lblApellidosDelEmpleadoA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellidosDelEmpleadoA.setBounds(29, 313, 185, 22);
		panelAlta.add(lblApellidosDelEmpleadoA);

		txtApellidosEmpleA = new JTextField();
		txtApellidosEmpleA.setForeground(Color.WHITE);
		txtApellidosEmpleA.setEditable(false);
		txtApellidosEmpleA.setColumns(10);
		txtApellidosEmpleA.setBackground(Color.WHITE);
		txtApellidosEmpleA.setBounds(29, 346, 174, 22);
		panelAlta.add(txtApellidosEmpleA);
		
		lblNomDepartA = new JLabel("Nombre del Departamento");
		lblNomDepartA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblNomDepartA.setBounds(29, 379, 222, 34);
		panelAlta.add(lblNomDepartA);
		
		comboBoxNomDepartA = new JComboBox();
		comboBoxNomDepartA.setBounds(29, 418, 174, 23);
		panelAlta.add(comboBoxNomDepartA);

		lblContratoA = new JLabel("Contrato\r\n");
		lblContratoA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblContratoA.setBounds(278, 90, 202, 34);
		panelAlta.add(lblContratoA);

		comboBoxContratoA = new JComboBox();
		comboBoxContratoA.setBounds(278, 135, 174, 23);
		panelAlta.add(comboBoxContratoA);
		
		lblFechaInicioA = new JLabel("Fecha de inicio del contrato");
		lblFechaInicioA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblFechaInicioA.setBounds(277, 175, 227, 22);
		panelAlta.add(lblFechaInicioA);
		
		dcFechaInicioA = new JDateChooser();
		dcFechaInicioA.setBounds(278, 207, 174, 22);
		panelAlta.add(dcFechaInicioA);
		
		lblFechaFinA = new JLabel("Fecha de fin del contrato");
		lblFechaFinA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblFechaFinA.setBounds(277, 246, 207, 22);
		panelAlta.add(lblFechaFinA);

		dcFechaFinA = new JDateChooser();
		dcFechaFinA.setBounds(278, 278, 174, 22);
		panelAlta.add(dcFechaFinA);
		
		chckbxActivoA = new JCheckBox("");
		chckbxActivoA.setSelected(true);
		chckbxActivoA.setForeground(Color.WHITE);
		chckbxActivoA.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxActivoA.setEnabled(false);
		chckbxActivoA.setBackground(Color.WHITE);
		chckbxActivoA.setBounds(278, 314, 26, 23);
		panelAlta.add(chckbxActivoA);
		
		lblActivoA = new JLabel("Activo");
		lblActivoA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblActivoA.setBounds(310, 307, 58, 34);
		panelAlta.add(lblActivoA);
	
		lblTipoEmpleA = new JLabel("Tipo de empleado");
		lblTipoEmpleA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblTipoEmpleA.setBounds(590, 88, 139, 34);
		panelAlta.add(lblTipoEmpleA);
		
		rdbtnEnfermeroA = new JRadioButton("Enfermero\r\n");
		rdbtnEnfermeroA.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		rdbtnEnfermeroA.setBackground(new Color(245, 245, 245));
		rdbtnEnfermeroA.setBounds(590, 147, 93, 23);
		panelAlta.add(rdbtnEnfermeroA);

		rdbtnDoctorA = new JRadioButton("Doctor");
		rdbtnDoctorA.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		rdbtnDoctorA.setBackground(Color.WHITE);
		rdbtnDoctorA.setBounds(590, 190, 75, 23);
		panelAlta.add(rdbtnDoctorA);

		lblEspecialidadA = new JLabel("Especialidad");
		lblEspecialidadA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblEspecialidadA.setBounds(590, 238, 110, 34);
		panelAlta.add(lblEspecialidadA);

		comboBoxEspecialidadA = new JComboBox();
		comboBoxEspecialidadA.setBounds(590, 277, 174, 23);
		panelAlta.add(comboBoxEspecialidadA);

		lblHorarioA = new JLabel("Horario");
		lblHorarioA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblHorarioA.setBounds(590, 307, 110, 34);
		panelAlta.add(lblHorarioA);
		
		comboBoxHorarioA = new JComboBox();
		comboBoxHorarioA.setBounds(590, 346, 174, 23);
		panelAlta.add(comboBoxHorarioA);
		
		btnRegistrarA = new JButton("REGISTRAR");
		btnRegistrarA.setForeground(Color.WHITE);
		btnRegistrarA.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		btnRegistrarA.setFocusPainted(false);
		btnRegistrarA.setBorder(null);
		btnRegistrarA.setBackground(new Color(0, 118, 255));
		btnRegistrarA.setBounds(709, 504, 131, 41);
		panelAlta.add(btnRegistrarA);
		
		separadorAlta = new JSeparator();
		separadorAlta.setOrientation(SwingConstants.VERTICAL);
		separadorAlta.setForeground(SystemColor.textHighlight);
		separadorAlta.setBackground(SystemColor.textHighlight);
		separadorAlta.setBounds(522, 22, 10, 523);
		panelAlta.add(separadorAlta);
		background.add(panelAlta);
		panelAlta.setLayout(null);

		lblAlta = new JLabel("Alta");
		lblAlta.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAlta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlta.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		lblAlta.setBounds(0, 0, 141, 36);
		panelAlta.add(lblAlta);
		// Fin Alta --------------------------------------------------------

		// Panel Baja y Modificacion
		panelModificacion = new JPanel();
		panelModificacion.setVisible(false);
		panelModificacion.setBackground(Color.WHITE);
		panelModificacion.setBounds(234, 32, 866, 568);
		background.add(panelModificacion);
		panelModificacion.setLayout(null);
		
		lblModificacion = new JLabel("Baja y Modificaci\u00F3n");
		lblModificacion.setBounds(0, 0, 369, 61);
		lblModificacion.setHorizontalTextPosition(SwingConstants.CENTER);
		lblModificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificacion.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		panelModificacion.add(lblModificacion);
				

		btnMasInformacion = new JButton("MAS INFORMACION");
		btnMasInformacion.setBounds(664, 503, 172, 41);
		btnMasInformacion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMasInformacion.setForeground(Color.WHITE);
		btnMasInformacion.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnMasInformacion.setFocusPainted(false);
		btnMasInformacion.setBorder(null);
		btnMasInformacion.setBackground(new Color(0, 118, 255));
		panelModificacion.add(btnMasInformacion);
		btnMasInformacion.addActionListener(this);
				
		btnBusqueda_2 = new JButton("");
		btnBusqueda_2.setBounds(460, 101, 67, 34);
		btnBusqueda_2.setFocusPainted(false);
		btnBusqueda_2.setIcon(new ImageIcon(VentanaGestionEmpleados.class.getResource("/imgs/lupa.png")));
		btnBusqueda_2.setForeground(Color.BLACK);
		btnBusqueda_2.setBorder(null);
		btnBusqueda_2.setBackground(new Color(0, 118, 255));
		panelModificacion.add(btnBusqueda_2);
		
		textField = new JTextField();
		textField.setBounds(26, 101, 420, 34);
		panelModificacion.add(textField);
		textField.setColumns(10);
		
		lblDniEmpleMI_1 = new JLabel("DNI del empleado");
		lblDniEmpleMI_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblDniEmpleMI_1.setBounds(598, 101, 167, 22);
		panelModificacion.add(lblDniEmpleMI_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(598, 134, 174, 22);
		panelModificacion.add(textField_1);
		
		lblApellido1DelEmpleMI_1 = new JLabel("1\u00BA Apellido del Empleado");
		lblApellido1DelEmpleMI_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellido1DelEmpleMI_1.setBounds(598, 167, 187, 22);
		panelModificacion.add(lblApellido1DelEmpleMI_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(598, 200, 174, 22);
		panelModificacion.add(textField_2);
		
		lblApellido2DelEmpleMI_1 = new JLabel("2\u00BA Apellido del Empleado");
		lblApellido2DelEmpleMI_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellido2DelEmpleMI_1.setBounds(598, 243, 202, 22);
		panelModificacion.add(lblApellido2DelEmpleMI_1);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.WHITE);
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(598, 276, 174, 22);
		panelModificacion.add(textField_3);
		
		JLabel lblContratoMI_1 = new JLabel("Contrato\r\n");
		lblContratoMI_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblContratoMI_1.setBounds(598, 309, 202, 34);
		panelModificacion.add(lblContratoMI_1);
		
		JComboBox comboBoxContratoMI_1 = new JComboBox();
		comboBoxContratoMI_1.setEnabled(false);
		comboBoxContratoMI_1.setEditable(true);
		comboBoxContratoMI_1.setBounds(598, 348, 174, 23);
		panelModificacion.add(comboBoxContratoMI_1);
		
		JSeparator separadorBajaMod_1 = new JSeparator();
		separadorBajaMod_1.setOrientation(SwingConstants.VERTICAL);
		separadorBajaMod_1.setForeground(SystemColor.textHighlight);
		separadorBajaMod_1.setBackground(SystemColor.textHighlight);
		separadorBajaMod_1.setBounds(550, 21, 10, 523);
		panelModificacion.add(separadorBajaMod_1);
		// Fin Panel Baja y Modificacion ----------------------------------------------------
		
		// Panel mas informacion
		panelMasInfo = new JPanel();
		panelMasInfo.setVisible(false);
		panelMasInfo.setBackground(new Color(255, 255, 255));
		panelMasInfo.setBounds(234, 32, 866, 568);
		background.add(panelMasInfo);
		panelMasInfo.setLayout(null);

		lblMasInfo = new JLabel("Informacion completa del Empleado");
		lblMasInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMasInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMasInfo.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		lblMasInfo.setBounds(0, 0, 433, 41);
		panelMasInfo.add(lblMasInfo);

		lblCodigoEmpleMI = new JLabel("C\u00F3digo del empleado");
		lblCodigoEmpleMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblCodigoEmpleMI.setBounds(29, 95, 167, 22);
		panelMasInfo.add(lblCodigoEmpleMI);

		txtCodigoEmpleMI = new JTextField();
		txtCodigoEmpleMI.setEnabled(false);
		txtCodigoEmpleMI.setForeground(Color.WHITE);
		txtCodigoEmpleMI.setColumns(10);
		txtCodigoEmpleMI.setBackground(Color.WHITE);
		txtCodigoEmpleMI.setBounds(29, 134, 174, 22);
		panelMasInfo.add(txtCodigoEmpleMI);

		lblDniEmpleMI = new JLabel("DNI del empleado");
		lblDniEmpleMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblDniEmpleMI.setBounds(29, 174, 167, 22);
		panelMasInfo.add(lblDniEmpleMI);

		txtDniEmpleMI = new JTextField();
		txtDniEmpleMI.setEnabled(false);
		txtDniEmpleMI.setForeground(Color.WHITE);
		txtDniEmpleMI.setColumns(10);
		txtDniEmpleMI.setBackground(Color.WHITE);
		txtDniEmpleMI.setBounds(29, 207, 174, 22);
		panelMasInfo.add(txtDniEmpleMI);

		lblNomEmpleB = new JLabel("Nombre del empleado");
		lblNomEmpleB.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblNomEmpleB.setBounds(29, 245, 185, 22);
		panelMasInfo.add(lblNomEmpleB);

		txtNomEmpleMI = new JTextField();
		txtNomEmpleMI.setEnabled(false);
		txtNomEmpleMI.setForeground(Color.WHITE);
		txtNomEmpleMI.setColumns(10);
		txtNomEmpleMI.setBackground(Color.WHITE);
		txtNomEmpleMI.setBounds(29, 278, 174, 22);
		panelMasInfo.add(txtNomEmpleMI);

		lblApellido1DelEmpleMI = new JLabel("1\u00BA Apellido del Empleado");
		lblApellido1DelEmpleMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellido1DelEmpleMI.setBounds(29, 313, 187, 22);
		panelMasInfo.add(lblApellido1DelEmpleMI);

		txtApellido1DelEmpleMI = new JTextField();
		txtApellido1DelEmpleMI.setEnabled(false);
		txtApellido1DelEmpleMI.setForeground(Color.WHITE);
		txtApellido1DelEmpleMI.setColumns(10);
		txtApellido1DelEmpleMI.setBackground(Color.WHITE);
		txtApellido1DelEmpleMI.setBounds(29, 346, 174, 22);
		panelMasInfo.add(txtApellido1DelEmpleMI);

		lblNomDepartMI = new JLabel("Nombre del Departamento");
		lblNomDepartMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblNomDepartMI.setBounds(278, 94, 222, 34);
		panelMasInfo.add(lblNomDepartMI);

		comboBoxNomDepartMI = new JComboBox();
		comboBoxNomDepartMI.setEnabled(false);
		comboBoxNomDepartMI.setEditable(true);
		comboBoxNomDepartMI.setBounds(278, 133, 174, 23);
		panelMasInfo.add(comboBoxNomDepartMI);

		lblContratoMI = new JLabel("Contrato\r\n");
		lblContratoMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblContratoMI.setBounds(278, 168, 202, 34);
		panelMasInfo.add(lblContratoMI);

		comboBoxContratoMI = new JComboBox();
		comboBoxContratoMI.setEnabled(false);
		comboBoxContratoMI.setEditable(true);
		comboBoxContratoMI.setBounds(278, 207, 174, 23);
		panelMasInfo.add(comboBoxContratoMI);

		lblFechaInicioMI = new JLabel("Fecha de inicio del contrato");
		lblFechaInicioMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblFechaInicioMI.setBounds(277, 247, 227, 22);
		panelMasInfo.add(lblFechaInicioMI);

		dcFechaInicioMI = new JDateChooser();
		dcFechaInicioMI.setBounds(278, 279, 174, 22);
		panelMasInfo.add(dcFechaInicioMI);

		lblFechaFinMI = new JLabel("Fecha de fin del contrato");
		lblFechaFinMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblFechaFinMI.setBounds(277, 318, 207, 22);
		panelMasInfo.add(lblFechaFinMI);

		dcFechaFinMI = new JDateChooser();
		dcFechaFinMI.setBounds(278, 350, 174, 22);
		panelMasInfo.add(dcFechaFinMI);

		chckbxActivoMI = new JCheckBox("");
		chckbxActivoMI.setSelected(true);
		chckbxActivoMI.setForeground(Color.WHITE);
		chckbxActivoMI.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxActivoMI.setEnabled(false);
		chckbxActivoMI.setBackground(Color.WHITE);
		chckbxActivoMI.setBounds(278, 386, 26, 23);
		panelMasInfo.add(chckbxActivoMI);

		lblActivoMI = new JLabel("Activo");
		lblActivoMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblActivoMI.setBounds(310, 379, 58, 34);
		panelMasInfo.add(lblActivoMI);

		lblTipoEmpleMI = new JLabel("Tipo de empleado");
		lblTipoEmpleMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblTipoEmpleMI.setBounds(590, 89, 139, 34);
		panelMasInfo.add(lblTipoEmpleMI);

		rdbtnEnfermeroMI = new JRadioButton("Enfermero\r\n");
		rdbtnEnfermeroMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		rdbtnEnfermeroMI.setBackground(new Color(245, 245, 245));
		rdbtnEnfermeroMI.setBounds(590, 134, 93, 23);
		panelMasInfo.add(rdbtnEnfermeroMI);

		rdbtnDoctorMI = new JRadioButton("Doctor");
		rdbtnDoctorMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		rdbtnDoctorMI.setBackground(Color.WHITE);
		rdbtnDoctorMI.setBounds(590, 176, 75, 23);
		panelMasInfo.add(rdbtnDoctorMI);

		lblEspecialidadMI = new JLabel("Especialidad");
		lblEspecialidadMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblEspecialidadMI.setBounds(590, 239, 110, 34);
		panelMasInfo.add(lblEspecialidadMI);

		comboBoxEspecialidadMI = new JComboBox();
		comboBoxEspecialidadMI.setEnabled(false);
		comboBoxEspecialidadMI.setEditable(true);
		comboBoxEspecialidadMI.setBounds(590, 284, 174, 23);
		panelMasInfo.add(comboBoxEspecialidadMI);

		lblHorarioMI = new JLabel("Horario");
		lblHorarioMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblHorarioMI.setBounds(590, 313, 110, 34);
		panelMasInfo.add(lblHorarioMI);

		comboBoxHorarioMI = new JComboBox();
		comboBoxHorarioMI.setEnabled(false);
		comboBoxHorarioMI.setEditable(true);
		comboBoxHorarioMI.setBounds(590, 353, 174, 23);
		panelMasInfo.add(comboBoxHorarioMI);

		btnIrVentanaModificar = new JButton("MODIFICAR");
		btnIrVentanaModificar.setForeground(Color.WHITE);
		btnIrVentanaModificar.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		btnIrVentanaModificar.setFocusPainted(false);
		btnIrVentanaModificar.setBorder(null);
		btnIrVentanaModificar.setBackground(new Color(0, 118, 255));
		btnIrVentanaModificar.setBounds(710, 504, 131, 41);
		panelMasInfo.add(btnIrVentanaModificar);

		separadorBajaMod = new JSeparator();
		separadorBajaMod.setOrientation(SwingConstants.VERTICAL);
		separadorBajaMod.setForeground(SystemColor.textHighlight);
		separadorBajaMod.setBackground(SystemColor.textHighlight);
		separadorBajaMod.setBounds(534, 22, 10, 523);
		panelMasInfo.add(separadorBajaMod);
		
		JButton btnDarDeBaja = new JButton("DAR DE BAJA");
		btnDarDeBaja.setForeground(Color.WHITE);
		btnDarDeBaja.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		btnDarDeBaja.setFocusPainted(false);
		btnDarDeBaja.setBorder(null);
		btnDarDeBaja.setBackground(new Color(0, 118, 255));
		btnDarDeBaja.setBounds(560, 504, 131, 41);
		panelMasInfo.add(btnDarDeBaja);
		
		JLabel lblApellido2DelEmpleMI = new JLabel("2\u00BA Apellido del Empleado");
		lblApellido2DelEmpleMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellido2DelEmpleMI.setBounds(29, 389, 202, 22);
		panelMasInfo.add(lblApellido2DelEmpleMI);
		
		txtApellido2DelEmpleMI = new JTextField();
		txtApellido2DelEmpleMI.setEnabled(false);
		txtApellido2DelEmpleMI.setForeground(Color.WHITE);
		txtApellido2DelEmpleMI.setColumns(10);
		txtApellido2DelEmpleMI.setBackground(Color.WHITE);
		txtApellido2DelEmpleMI.setBounds(29, 422, 174, 22);
		panelMasInfo.add(txtApellido2DelEmpleMI);
		// Fin Panel mas informacion --------------------------------------------------------
		
		

		// Contenedor de pestañas y logo
		menuHospitalContainer = new JPanel();
		menuHospitalContainer.setBounds(0, 0, 234, 600);
		menuHospitalContainer.setLayout(null);
		menuHospitalContainer.setBackground(Color.WHITE);
		background.add(menuHospitalContainer);
		btnCerrarAppMouseListener();

		lblHeaderApp = new JLabel("");
		lblHeaderApp.setBounds(0, 0, 1100, 31);
		background.add(lblHeaderApp);
		lblHeaderAppMouseListener();
		lblHeaderAppMouseMotionListener();

		lblNombreHospital = new JLabel("Hospital Privado");
		lblNombreHospital.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNombreHospital.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreHospital.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 21));
		lblNombreHospital.setBounds(47, 38, 187, 23);
		menuHospitalContainer.add(lblNombreHospital);

		lblHospitalIcono = new JLabel("");
		lblHospitalIcono.setIcon(new ImageIcon(VentanaGestionEmpleados.class.getResource("/imgs/cruzRoja-32x32.png")));
		lblHospitalIcono.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHospitalIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospitalIcono.setBounds(0, 28, 50, 43);
		menuHospitalContainer.add(lblHospitalIcono);
		
		btnAlta = new JButton("Alta");
		btnAlta.setIcon(new ImageIcon(VentanaGestionEmpleados.class.getResource("/imgs/alta.png")));
		btnAlta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlta.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAlta.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlta.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 15));
		btnAlta.setFocusPainted(false);
		btnAlta.setBorder(null);
		btnAlta.setBackground(Color.WHITE);
		btnAlta.setBounds(20, 103, 177, 47);
		menuHospitalContainer.add(btnAlta);
		btnAltaMouseListener();
		

		btnBajaModificacion = new JButton("Baja y Modificaci\u00F3n");
		btnBajaModificacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBajaModificacion.setIcon(new ImageIcon(VentanaGestionEmpleados.class.getResource("/imgs/modificacion.png")));
		btnBajaModificacion.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnBajaModificacion.setHorizontalAlignment(SwingConstants.LEFT);
		btnBajaModificacion.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 15));
		btnBajaModificacion.setFocusPainted(false);
		btnBajaModificacion.setBorder(null);
		btnBajaModificacion.setBackground(Color.WHITE);
		btnBajaModificacion.setBounds(20, 161, 187, 43);
		menuHospitalContainer.add(btnBajaModificacion);
		btnModificarMouseListener();
		btnAgregarEspecialidadMouseListener();
		btnDarDeAltaMouseListener();
		btnDarDeBajaListener();
		btnBajaModificacionMouseListener();

		btnVolverAlMenu = new JButton("Menu Principal");
		btnVolverAlMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolverAlMenu.setIcon(new ImageIcon(VentanaGestionEmpleados.class.getResource("/imgs/menu.png")));
		btnVolverAlMenu.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnVolverAlMenu.setForeground(new Color(0, 118, 255));
		btnVolverAlMenu.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 16));
		btnVolverAlMenu.setFocusPainted(false);
		btnVolverAlMenu.setBorder(null);
		btnVolverAlMenu.setBackground(Color.WHITE);
		btnVolverAlMenu.setBounds(32, 470, 165, 33);
		menuHospitalContainer.add(btnVolverAlMenu);
		btnVolverAlMenuMouseListener();
		btnVolverAlMenu.addActionListener(this);

		btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrarSesion.setIcon(new ImageIcon(VentanaGestionEmpleados.class.getResource("/imgs/logoutAzul2.png")));
		btnCerrarSesion.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCerrarSesion.setForeground(new Color(0, 118, 255));
		btnCerrarSesion.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 16));
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setBackground(Color.WHITE);
		btnCerrarSesion.setBounds(32, 532, 148, 33);
		menuHospitalContainer.add(btnCerrarSesion);
		//btnCerrarSesionMouseListener();
		// Fin contenedor pestañas y logo ----------------------------------------
	}

	private void btnBajaModificacionMouseListener() {

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
				btnBajaModificacion.setBackground(new Color(255, 255, 255));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnBajaModificacion.setBackground(new Color(245, 245, 245));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelModificacion.setVisible(true);
				panelAlta.setVisible(false);
			}
		};

		btnBajaModificacion.addMouseListener(ml);

	}
	
	private void btnAltaMouseListener() {

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
				btnAlta.setBackground(new Color(255, 255, 255));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAlta.setBackground(new Color(245, 245, 245));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelAlta.setVisible(true);
				panelModificacion.setVisible(false);

			}
		};

		btnAlta.addMouseListener(ml);

	}

	private void btnModificarMouseListener() {

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
				btnMasInformacion.setBackground(new Color(0, 118, 255));
				btnMasInformacion.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnMasInformacion.setBackground(new Color(0, 80, 255));
				btnMasInformacion.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		};

		btnMasInformacion.addMouseListener(ml);
	}

	private void btnDarDeBajaListener() {

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
				btnIrVentanaModificar.setBackground(new Color(0, 118, 255));
				btnIrVentanaModificar.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnIrVentanaModificar.setBackground(new Color(0, 80, 255));
				btnIrVentanaModificar.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};
	}

	private void btnDarDeAltaMouseListener() {

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
				/*btnRegistro.setBackground(new Color(0, 118, 255));
				btnDarDeAlta.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));*/

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				/*btnDarDeAlta.setBackground(new Color(0, 80, 255));
				btnDarDeAlta.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));*/

			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		};

	}

	private void btnAgregarEspecialidadMouseListener() {

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
				/*btnAgregarEspecialidad.setBackground(new Color(0, 118, 255));
				btnAgregarEspecialidad.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));*/

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				/*btnAgregarEspecialidad.setBackground(new Color(0, 80, 255));
				btnAgregarEspecialidad.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));*/

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};

	}

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

	public void btnCerrarAppMouseListener() {

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
				btnCerrarApp.setBackground(new Color(0, 118, 255));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnCerrarApp.setBackground(new Color(209, 26, 42));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);

			}
		};

		btnCerrarApp.addMouseListener(ml);
	}

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
				btnCerrarSesion.setBackground(new Color(255, 255, 255));
				btnCerrarSesion.setForeground(new Color(0, 118, 255));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnCerrarSesion.setBackground(new Color(0, 118, 255));
				btnCerrarSesion.setForeground(new Color(255, 255, 255));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};

		btnCerrarSesion.addMouseListener(nl);

	}

	private void btnVolverAlMenuMouseListener() {

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
				btnVolverAlMenu.setBackground(new Color(255, 255, 255));
				btnVolverAlMenu.setForeground(new Color(0, 118, 255));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnVolverAlMenu.setBackground(new Color(0, 118, 255));
				btnVolverAlMenu.setForeground(new Color(255, 255, 255));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};

		btnVolverAlMenu.addMouseListener(nl);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * if (e.getSource().equals(btnModificar)) {
		 * VentanaGestionDepartamentoModificacion VentanaGestionDepartamentoModificacion
		 * = new VentanaGestionDepartamentoModificacion(true);
		 * VentanaGestionDepartamentoModificacion.setVisible(true); }
		 * if(e.getSource().equals(btnVolverAlMenu)) { this.dispose();
		 * VentanaAdminGestionDepartamentoYEmpleado
		 * VentanaAdminGestionDepartamentoYEmpleado = new
		 * VentanaAdminGestionDepartamentoYEmpleado();
		 * VentanaAdminGestionDepartamentoYEmpleado.setVisible(true);
		 * 
		 * }
		 */
	}
}
