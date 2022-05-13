package gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

import clases.Contrato;
import clases.Doctor;
import clases.Empleado;
import clases.Enfermero;
import interfaces.*;

import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.ButtonGroup;

/**
 * Gestion de Empleados por el Administrador
 * 
 * @author Nerea
 *
 */
public class VentanaGestionEmpleados extends JDialog implements ActionListener {

	private String[] especialidades = new String[5];

	// Paneles
	private JPanel background;
	private JPanel menuHospitalContainer;
	private JPanel panelAlta;
	private JPanel panelMasInfo;
	private JPanel panelBajaYModificacion;

	private JLabel lblHeaderApp;
	private JLabel lblNombreHospital;
	private JLabel lblHospitalIcono;
	private JLabel lblAlta;
	private JLabel lblBajaYModificacion;

	private int xPositionMouse, yPositionMouse;
	private JButton btnBajaModificacion;
	private JButton btnCerrarApp;
	private JButton btnBusqueda;
	private JButton btnVolverAlMenu;
	private JButton btnCerrarSesion;

	// Panel Alta
	private JButton btnAlta;
	private JLabel lblCodigoEmpleA;
	private JTextField txtCodEmpleA;
	private JLabel lblDniEmpleA;
	private JTextField txtDniEmpleA;
	private JLabel lblNomEmpleA;
	private JTextField txtNombreEmpleA;
	private JLabel lblApellido1DelEmpleA;
	private JTextField txtApellido1DelEmpleA;
	private JLabel lblApellido2DelEmpleA;
	private JTextField txtApellido2DelEmpleA;
	private JLabel lblCodDepartA;
	private JComboBox<String> comboBoxCodDepartA;
	private JLabel lblContratoA;
	
	
	private JLabel lblFechaInicioA;
	private JDateChooser dcFechaInicioA;
	private JDateChooser dcFechaFinA;
	private JLabel lblFechaFinA;
	private JComboBox<String> comboBoxContratoA;
	private JCheckBox chckbxActivoA;
	private JComboBox<String> comboBoxEspecialidadA;
	private JLabel lblActivoA;
	private JLabel lblTipoEmpleA;
	private JLabel lblEspecialidadA;
	private JRadioButton rdbtnDoctorA;
	private JRadioButton rdbtnEnfermeroA;
	private JLabel lblHorarioA;
	private JComboBox<String> comboBoxHorarioA;
	private JButton btnRegistro;
	private JLabel lblCodContratoA;
	
	private JSeparator separadorAlta;

	// Panel Baja y Modificacion
	private JTextField txtBusqueda;
	private JSeparator separadorBajaYModificacion;
	private JLabel lblCodigoEmpleBM;
	private JTextField txtCodigoEmpleBM;
	private JLabel lblDniEmpleBM;
	private JTextField txtDniEmpleBM;
	private JLabel lblNomEmpleBM;
	private JTextField txtNomEmpleBM;
	private JLabel lblApellido1DelEmpleBM;
	private JTextField txtApellido1DelEmpleBM;
	private JLabel lblApellido2DelEmpleBM;
	private JTextField txtApellido2DelEmpleBM;
	private JButton btnMasInformacion;

	// Mas info
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
	private JSeparator separadorMasInfo;
	private JTextField txtApellido2DelEmpleMI;
	private JButton btnDarDeBaja;

	// Interfaces
	private EmpleadoControlable empleadoControlable;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtCodContratoA;
	private JLabel lblCodigoContratoMI;
	private JTextField txtCodigoContrato;
	
	

	public VentanaGestionEmpleados(EmpleadoControlable empleadoControlable) {
		this.empleadoControlable = empleadoControlable;

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
		txtCodEmpleA.setForeground(Color.BLACK);
		txtCodEmpleA.setColumns(10);
		txtCodEmpleA.setBackground(Color.WHITE);
		txtCodEmpleA.setBounds(29, 134, 174, 22);
		panelAlta.add(txtCodEmpleA);

		lblDniEmpleA = new JLabel("DNI del empleado");
		lblDniEmpleA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblDniEmpleA.setBounds(29, 174, 167, 22);
		panelAlta.add(lblDniEmpleA);

		txtDniEmpleA = new JTextField();
		txtDniEmpleA.setForeground(Color.BLACK);
		txtDniEmpleA.setColumns(10);
		txtDniEmpleA.setBackground(Color.WHITE);
		txtDniEmpleA.setBounds(29, 207, 174, 22);
		panelAlta.add(txtDniEmpleA);

		lblNomEmpleA = new JLabel("Nombre del empleado");
		lblNomEmpleA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblNomEmpleA.setBounds(29, 245, 185, 22);
		panelAlta.add(lblNomEmpleA);

		txtNombreEmpleA = new JTextField();
		txtNombreEmpleA.setForeground(Color.BLACK);
		txtNombreEmpleA.setColumns(10);
		txtNombreEmpleA.setBackground(Color.WHITE);
		txtNombreEmpleA.setBounds(29, 278, 174, 22);
		panelAlta.add(txtNombreEmpleA);

		lblCodDepartA = new JLabel("Codigo del Departamento");
		lblCodDepartA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblCodDepartA.setBounds(282, 89, 222, 34);
		panelAlta.add(lblCodDepartA);

		comboBoxCodDepartA = new JComboBox<String>();
		ArrayList<String> codDepartamentos = new ArrayList<String>(empleadoControlable.buscarCodDepartamentos());
		for (String departamento : codDepartamentos) {
			comboBoxCodDepartA.addItem(departamento);
		}
		comboBoxCodDepartA.setBounds(282, 134, 174, 23);
		panelAlta.add(comboBoxCodDepartA);

		lblContratoA = new JLabel("Contrato\r\n");
		lblContratoA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblContratoA.setBounds(282, 239, 202, 34);
		panelAlta.add(lblContratoA);

		comboBoxContratoA = new JComboBox<String>();
		ArrayList<String> contratos = new ArrayList<String>(empleadoControlable.buscarTipoContrato());
		for (String contrato : contratos) {
			comboBoxContratoA.addItem(contrato);
		}
		comboBoxContratoA.setSelectedIndex(-1);
		comboBoxContratoA.setBounds(282, 280, 174, 23);
		panelAlta.add(comboBoxContratoA);

		lblFechaInicioA = new JLabel("Fecha de inicio del contrato");
		lblFechaInicioA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblFechaInicioA.setBounds(282, 322, 227, 22);
		panelAlta.add(lblFechaInicioA);

		dcFechaInicioA = new JDateChooser();
		dcFechaInicioA.setBounds(282, 355, 174, 22);
		panelAlta.add(dcFechaInicioA);

		lblFechaFinA = new JLabel("Fecha de fin del contrato");
		lblFechaFinA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblFechaFinA.setBounds(282, 388, 207, 22);
		panelAlta.add(lblFechaFinA);

		dcFechaFinA = new JDateChooser();
		dcFechaFinA.setBounds(282, 423, 174, 22);
		panelAlta.add(dcFechaFinA);

		chckbxActivoA = new JCheckBox("");
		chckbxActivoA.setSelected(true);
		chckbxActivoA.setForeground(Color.WHITE);
		chckbxActivoA.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxActivoA.setEnabled(false);
		chckbxActivoA.setBackground(Color.WHITE);
		chckbxActivoA.setBounds(435, 518, 26, 23);
		panelAlta.add(chckbxActivoA);

		lblActivoA = new JLabel("Activo");
		lblActivoA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblActivoA.setBounds(467, 511, 58, 34);
		panelAlta.add(lblActivoA);

		lblTipoEmpleA = new JLabel("Tipo de empleado");
		lblTipoEmpleA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblTipoEmpleA.setBounds(590, 88, 139, 34);
		panelAlta.add(lblTipoEmpleA);

		rdbtnEnfermeroA = new JRadioButton("Enfermero\r\n");
		buttonGroup.add(rdbtnEnfermeroA);
		rdbtnEnfermeroA.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		rdbtnEnfermeroA.setBackground(new Color(245, 245, 245));
		rdbtnEnfermeroA.setBounds(590, 176, 93, 23);
		panelAlta.add(rdbtnEnfermeroA);

		rdbtnDoctorA = new JRadioButton("Doctor");
		buttonGroup.add(rdbtnDoctorA);
		rdbtnDoctorA.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		rdbtnDoctorA.setBackground(Color.WHITE);
		rdbtnDoctorA.setBounds(590, 134, 75, 23);
		panelAlta.add(rdbtnDoctorA);

		lblEspecialidadA = new JLabel("Especialidad");
		lblEspecialidadA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblEspecialidadA.setBounds(583, 242, 110, 34);
		panelAlta.add(lblEspecialidadA);

		comboBoxEspecialidadA = new JComboBox<String>();
		comboBoxEspecialidadA.setSelectedIndex(-1);
		comboBoxEspecialidadA.setBounds(583, 281, 174, 23);
		panelAlta.add(comboBoxEspecialidadA);

		lblHorarioA = new JLabel("Horario");
		lblHorarioA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblHorarioA.setBounds(590, 316, 110, 34);
		panelAlta.add(lblHorarioA);

		comboBoxHorarioA = new JComboBox<String>();
		ArrayList<String> horarios = new ArrayList<>(empleadoControlable.buscarHorarios());
		for (String horario : horarios) {
			comboBoxHorarioA.addItem(horario);
		}
		comboBoxHorarioA.setSelectedIndex(-1);
		comboBoxHorarioA.setBounds(583, 354, 174, 23);
		panelAlta.add(comboBoxHorarioA);

		btnRegistro = new JButton("REGISTRAR");
		btnRegistro.setForeground(Color.WHITE);
		btnRegistro.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		btnRegistro.setFocusPainted(false);
		btnRegistro.setBorder(null);
		btnRegistro.setBackground(new Color(0, 118, 255));
		btnRegistro.setBounds(709, 504, 131, 41);
		panelAlta.add(btnRegistro);

		separadorAlta = new JSeparator();
		separadorAlta.setOrientation(SwingConstants.VERTICAL);
		separadorAlta.setForeground(SystemColor.textHighlight);
		separadorAlta.setBackground(SystemColor.textHighlight);
		separadorAlta.setBounds(531, 21, 10, 523);
		panelAlta.add(separadorAlta);
		background.add(panelAlta);
		panelAlta.setLayout(null);

		lblAlta = new JLabel("Alta");
		lblAlta.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAlta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlta.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		lblAlta.setBounds(0, 0, 141, 36);
		panelAlta.add(lblAlta);

		lblCodContratoA = new JLabel("Codigo del Contrato\r\n");
		lblCodContratoA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblCodContratoA.setBounds(282, 168, 202, 34);
		panelAlta.add(lblCodContratoA);

		txtCodContratoA = new JTextField();
		txtCodContratoA.setForeground(Color.BLACK);
		txtCodContratoA.setColumns(10);
		txtCodContratoA.setBackground(Color.WHITE);
		txtCodContratoA.setBounds(282, 207, 174, 22);
		panelAlta.add(txtCodContratoA);

		lblApellido1DelEmpleA = new JLabel("1\u00BA Apellido del Empleado");
		lblApellido1DelEmpleA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellido1DelEmpleA.setBounds(29, 322, 187, 22);
		panelAlta.add(lblApellido1DelEmpleA);

		txtApellido1DelEmpleA = new JTextField();
		txtApellido1DelEmpleA.setForeground(Color.WHITE);
		txtApellido1DelEmpleA.setEnabled(false);
		txtApellido1DelEmpleA.setColumns(10);
		txtApellido1DelEmpleA.setBackground(Color.WHITE);
		txtApellido1DelEmpleA.setBounds(29, 355, 174, 22);
		panelAlta.add(txtApellido1DelEmpleA);

		lblApellido2DelEmpleA = new JLabel("2\u00BA Apellido del Empleado");
		lblApellido2DelEmpleA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellido2DelEmpleA.setBounds(29, 388, 202, 22);
		panelAlta.add(lblApellido2DelEmpleA);

		txtApellido2DelEmpleA = new JTextField();
		txtApellido2DelEmpleA.setForeground(Color.WHITE);
		txtApellido2DelEmpleA.setEnabled(false);
		txtApellido2DelEmpleA.setColumns(10);
		txtApellido2DelEmpleA.setBackground(Color.WHITE);
		txtApellido2DelEmpleA.setBounds(29, 423, 174, 22);
		panelAlta.add(txtApellido2DelEmpleA);
		// Fin Alta --------------------------------------------------------

		// Panel Baja y Modificacion
		panelBajaYModificacion = new JPanel();
		panelBajaYModificacion.setVisible(false);
		panelBajaYModificacion.setBackground(Color.WHITE);
		panelBajaYModificacion.setBounds(234, 32, 866, 568);
		background.add(panelBajaYModificacion);
		panelBajaYModificacion.setLayout(null);

		lblBajaYModificacion = new JLabel("Baja y Modificaci\u00F3n");
		lblBajaYModificacion.setBounds(0, 0, 283, 61);
		lblBajaYModificacion.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBajaYModificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblBajaYModificacion.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		panelBajaYModificacion.add(lblBajaYModificacion);

		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(26, 101, 420, 34);
		panelBajaYModificacion.add(txtBusqueda);
		txtBusqueda.setColumns(10);

		btnBusqueda = new JButton("");
		btnBusqueda.setBounds(460, 101, 67, 34);
		btnBusqueda.setFocusPainted(false);
		btnBusqueda.setIcon(new ImageIcon(VentanaGestionEmpleados.class.getResource("/imgs/lupa.png")));
		btnBusqueda.setForeground(Color.BLACK);
		btnBusqueda.setBorder(null);
		btnBusqueda.setBackground(new Color(0, 118, 255));
		panelBajaYModificacion.add(btnBusqueda);

		separadorBajaYModificacion = new JSeparator();
		separadorBajaYModificacion.setOrientation(SwingConstants.VERTICAL);
		separadorBajaYModificacion.setForeground(SystemColor.textHighlight);
		separadorBajaYModificacion.setBackground(SystemColor.textHighlight);
		separadorBajaYModificacion.setBounds(566, 21, 10, 523);
		panelBajaYModificacion.add(separadorBajaYModificacion);
		
		lblCodigoEmpleBM = new JLabel("C\u00F3digo del empleado");
		lblCodigoEmpleBM.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblCodigoEmpleBM.setBounds(607, 101, 167, 22);
		panelBajaYModificacion.add(lblCodigoEmpleBM);

		txtCodigoEmpleBM = new JTextField();
		txtCodigoEmpleBM.setForeground(Color.BLACK);
		txtCodigoEmpleBM.setColumns(10);
		txtCodigoEmpleBM.setBackground(Color.WHITE);
		txtCodigoEmpleBM.setBounds(607, 140, 174, 22);
		panelBajaYModificacion.add(txtCodigoEmpleBM);

		lblDniEmpleBM = new JLabel("DNI del empleado");
		lblDniEmpleBM.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblDniEmpleBM.setBounds(607, 180, 167, 22);
		panelBajaYModificacion.add(lblDniEmpleBM);

		txtDniEmpleBM = new JTextField();
		txtDniEmpleBM.setEditable(false);
		txtDniEmpleBM.setForeground(Color.WHITE);
		txtDniEmpleBM.setColumns(10);
		txtDniEmpleBM.setBackground(Color.WHITE);
		txtDniEmpleBM.setBounds(607, 213, 174, 22);
		panelBajaYModificacion.add(txtDniEmpleBM);

		lblNomEmpleBM = new JLabel("Nombre del empleado");
		lblNomEmpleBM.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblNomEmpleBM.setBounds(607, 246, 185, 22);
		panelBajaYModificacion.add(lblNomEmpleBM);

		txtNomEmpleBM = new JTextField();
		txtNomEmpleBM.setForeground(Color.BLACK);
		txtNomEmpleBM.setColumns(10);
		txtNomEmpleBM.setBackground(Color.WHITE);
		txtNomEmpleBM.setBounds(607, 279, 174, 22);
		panelBajaYModificacion.add(txtNomEmpleBM);

		lblApellido1DelEmpleBM = new JLabel("1\u00BA Apellido del Empleado");
		lblApellido1DelEmpleBM.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellido1DelEmpleBM.setBounds(607, 312, 187, 22);
		panelBajaYModificacion.add(lblApellido1DelEmpleBM);

		txtApellido1DelEmpleBM = new JTextField();
		txtApellido1DelEmpleBM.setEditable(false);
		txtApellido1DelEmpleBM.setForeground(Color.WHITE);
		txtApellido1DelEmpleBM.setColumns(10);
		txtApellido1DelEmpleBM.setBackground(Color.WHITE);
		txtApellido1DelEmpleBM.setBounds(607, 345, 174, 22);
		panelBajaYModificacion.add(txtApellido1DelEmpleBM);

		lblApellido2DelEmpleBM = new JLabel("2\u00BA Apellido del Empleado");
		lblApellido2DelEmpleBM.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellido2DelEmpleBM.setBounds(607, 378, 202, 22);
		panelBajaYModificacion.add(lblApellido2DelEmpleBM);

		txtApellido2DelEmpleBM = new JTextField();
		txtApellido2DelEmpleBM.setEditable(false);
		txtApellido2DelEmpleBM.setForeground(Color.WHITE);
		txtApellido2DelEmpleBM.setColumns(10);
		txtApellido2DelEmpleBM.setBackground(Color.WHITE);
		txtApellido2DelEmpleBM.setBounds(607, 411, 174, 22);
		panelBajaYModificacion.add(txtApellido2DelEmpleBM);

		btnMasInformacion = new JButton("MAS INFORMACION");
		btnMasInformacion.setBounds(664, 503, 172, 41);
		btnMasInformacion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMasInformacion.setForeground(Color.WHITE);
		btnMasInformacion.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnMasInformacion.setFocusPainted(false);
		btnMasInformacion.setBorder(null);
		btnMasInformacion.setBackground(new Color(0, 118, 255));
		panelBajaYModificacion.add(btnMasInformacion);
		btnMasInformacion.addActionListener(this);
		// Fin Panel Baja y Modificacion ------------------------------------------

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

		lblCodigoEmpleMI = new JLabel("Codigo del empleado");
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
		lblContratoMI.setBounds(279, 242, 202, 34);
		panelMasInfo.add(lblContratoMI);

		comboBoxContratoMI = new JComboBox();
		comboBoxContratoMI.setEnabled(false);
		comboBoxContratoMI.setEditable(true);
		comboBoxContratoMI.setBounds(279, 281, 174, 23);
		panelMasInfo.add(comboBoxContratoMI);

		lblFechaInicioMI = new JLabel("Fecha de inicio del contrato");
		lblFechaInicioMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblFechaInicioMI.setBounds(278, 321, 227, 22);
		panelMasInfo.add(lblFechaInicioMI);

		dcFechaInicioMI = new JDateChooser();
		dcFechaInicioMI.getCalendarButton().setEnabled(false);
		dcFechaInicioMI.setBounds(279, 353, 174, 22);
		panelMasInfo.add(dcFechaInicioMI);

		lblFechaFinMI = new JLabel("Fecha de fin del contrato");
		lblFechaFinMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblFechaFinMI.setBounds(278, 392, 207, 22);
		panelMasInfo.add(lblFechaFinMI);

		dcFechaFinMI = new JDateChooser();
		dcFechaFinMI.getCalendarButton().setEnabled(false);
		dcFechaFinMI.setBounds(279, 424, 174, 22);
		panelMasInfo.add(dcFechaFinMI);

		chckbxActivoMI = new JCheckBox("");
		chckbxActivoMI.setSelected(true);
		chckbxActivoMI.setForeground(Color.WHITE);
		chckbxActivoMI.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxActivoMI.setEnabled(false);
		chckbxActivoMI.setBackground(Color.WHITE);
		chckbxActivoMI.setBounds(438, 518, 26, 23);
		panelMasInfo.add(chckbxActivoMI);

		lblActivoMI = new JLabel("Activo");
		lblActivoMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblActivoMI.setBounds(470, 511, 58, 34);
		panelMasInfo.add(lblActivoMI);

		lblTipoEmpleMI = new JLabel("Tipo de empleado");
		lblTipoEmpleMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblTipoEmpleMI.setBounds(590, 89, 139, 34);
		panelMasInfo.add(lblTipoEmpleMI);

		rdbtnEnfermeroMI = new JRadioButton("Enfermero\r\n");
		rdbtnEnfermeroMI.setEnabled(false);
		buttonGroup_1.add(rdbtnEnfermeroMI);
		rdbtnEnfermeroMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		rdbtnEnfermeroMI.setBackground(new Color(245, 245, 245));
		rdbtnEnfermeroMI.setBounds(590, 176, 93, 23);
		panelMasInfo.add(rdbtnEnfermeroMI);

		rdbtnDoctorMI = new JRadioButton("Doctor");
		rdbtnDoctorMI.setEnabled(false);
		buttonGroup_1.add(rdbtnDoctorMI);
		rdbtnDoctorMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		rdbtnDoctorMI.setBackground(Color.WHITE);
		rdbtnDoctorMI.setBounds(590, 134, 75, 23);
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

		separadorMasInfo = new JSeparator();
		separadorMasInfo.setOrientation(SwingConstants.VERTICAL);
		separadorMasInfo.setForeground(SystemColor.textHighlight);
		separadorMasInfo.setBackground(SystemColor.textHighlight);
		separadorMasInfo.setBounds(534, 22, 10, 523);
		panelMasInfo.add(separadorMasInfo);

		btnDarDeBaja = new JButton("DAR DE BAJA");
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

		lblCodigoContratoMI = new JLabel("Codigo del Contrato");
		lblCodigoContratoMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblCodigoContratoMI.setBounds(278, 170, 167, 22);
		panelMasInfo.add(lblCodigoContratoMI);

		txtCodigoContrato = new JTextField();
		txtCodigoContrato.setForeground(Color.WHITE);
		txtCodigoContrato.setEnabled(false);
		txtCodigoContrato.setColumns(10);
		txtCodigoContrato.setBackground(Color.WHITE);
		txtCodigoContrato.setBounds(278, 209, 174, 22);
		panelMasInfo.add(txtCodigoContrato);
		// Fin Panel mas informacion
		// --------------------------------------------------------

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

		btnBajaModificacion = new JButton("Baja y Modificacion");
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
		btnDarDeAltaMouseListener();
		btnDarDeBajaListener();
		btnBajaModificacionMouseListener();
		btnBajaModificacion.addActionListener(this);

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
		btnCerrarSesionMouseListener();
		// Fin contenedor pestañas y logo ----------------------------------------

		btnListarEspecialidadesListener();
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
				panelBajaYModificacion.setVisible(true);
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
				panelBajaYModificacion.setVisible(false);

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

	// Boton de registro para para utilizar el metodo de dar de alta de la interfaz
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

	// Boton de registro para para utilizar el metodo de dar de alta de la interfaz
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
				btnRegistro.setBackground(new Color(0, 118, 255));
				btnRegistro.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color(0, 80, 255));
				btnRegistro.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtCodEmpleA.getText().isEmpty() || txtDniEmpleA.getText().isEmpty()
						|| txtNombreEmpleA.getText().isEmpty() || txtApellido1DelEmpleA.getText().isEmpty()
						|| txtCodContratoA.getText().isEmpty() || dcFechaInicioA.getToolTipText().isEmpty()
						|| dcFechaFinA.getToolTipText().isEmpty() || (comboBoxCodDepartA.getSelectedIndex() == -1)
						|| (comboBoxContratoA.getSelectedIndex() == -1)) {

					JOptionPane.showMessageDialog(btnRegistro, this, "Error, falta algun dato por rellenar",
							JOptionPane.ERROR_MESSAGE);

				} else if (!rdbtnDoctorA.isSelected() && comboBoxEspecialidadA.getSelectedIndex() == -1
						|| !rdbtnEnfermeroA.isSelected() && comboBoxHorarioA.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(btnRegistro, this, "Error, no se ha escogido tipo de empleado",
							JOptionPane.ERROR_MESSAGE);
				} else {

					Contrato con = new Contrato();
					Empleado emple = new Empleado();

					emple.setCodEmpleado(txtCodEmpleA.getText());
					emple.setDniEmpleado(txtDniEmpleA.getText());
					emple.setNombreEmpleado(txtNombreEmpleA.getText());
					emple.setApellido1Empleado(txtApellido1DelEmpleA.getText());
					emple.setApellido2Empleado(txtApellido2DelEmpleA.getText());
					String codDepart = (String) comboBoxCodDepartA.getSelectedItem();
					emple.setCodDepartamento(codDepart);

					con.setCodContrato(txtCodContratoA.getText());
					String tipoContrato = (String) comboBoxContratoA.getSelectedItem();
					con.setTipoContrato(tipoContrato);
					con.setFechaInicio((Date) dcFechaInicioA.getDate());
					con.setFechaFin((Date) dcFechaFinA.getDate());

					if (rdbtnEnfermeroA.isSelected()) {
						emple.setTipoEmpleado("Enfermero");
						emple = new Enfermero();
						String horario = (String) comboBoxHorarioA.getSelectedItem();
						((Enfermero) emple).setHorario(horario);
					} else {
						emple.setTipoEmpleado("Doctor");
						emple = new Doctor();
						String especialidad = (String) comboBoxEspecialidadA.getSelectedItem();
						((Doctor) emple).setEspecialidad(especialidad);
					}

					empleadoControlable.altaEmpleado(emple, con);
				}

			}
		};

		btnRegistro.addMouseListener(ml);
	}

	// Labeel del head para poder mover la ventana por la pantalla
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
	// Fin Labeel del head para poder mover la ventana por la pantalla
	// ---------------------------------------

	// Boton de cerrar ventana
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

	// Boton de cerrar sesion
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

	// Boton de vuelta al menu
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

	// ConboBox de Especialidades
	private void btnListarEspecialidadesListener() {

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
				// TODO Auto-generated method stub
				ArrayList<String> especialidades = new ArrayList<>(
						empleadoControlable.buscarEspecialidades(comboBoxCodDepartA.getSelectedItem().toString()));
				for (String especialidad : especialidades) {
					comboBoxEspecialidadA.addItem(especialidad);
				}
			}
		};

		comboBoxCodDepartA.addMouseListener(nl);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Boton para registrar
		if (e.getSource().equals(btnRegistro)) {

		}

		// Boton para dar de baja
		if (e.getSource().equals(btnDarDeBaja)) {

		}

		// Boton para abrir el panel de mas informacion
		if (e.getSource().equals(btnMasInformacion)) {
			panelBajaYModificacion.setVisible(false);
			panelMasInfo.setVisible(true);
		}

		// Botones del menu
		if (e.getSource().equals(btnVolverAlMenu)) {
			this.dispose();
			VentanaAdminGestionDepartamentoYEmpleado VentanaAdminGestionDepartamentoYEmpleado = new VentanaAdminGestionDepartamentoYEmpleado(empleadoControlable);
			VentanaAdminGestionDepartamentoYEmpleado.setVisible(true);

		}
		if (e.getSource().equals(btnCerrarSesion)) {
			int confirmado = JOptionPane.showConfirmDialog(this, "¿Estas seguro de cerrar sesión?", "Cerrar Sesión",
					JOptionPane.INFORMATION_MESSAGE);
			if (JOptionPane.OK_OPTION == confirmado) {
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(empleadoControlable);
				ventanaPrincipal.setVisible(true);
				this.dispose();
			} else
				System.out.println("");
		}
	}
}
