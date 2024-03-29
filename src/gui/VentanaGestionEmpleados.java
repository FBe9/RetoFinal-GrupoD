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
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Cursor;
import com.toedter.calendar.JDateChooser;

import clases.*;
import exceptions.CreateSqlException;
import interfaces.*;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import javax.swing.ButtonGroup;

/**
 * Ventana de Gestion de Empleados por el Administrador Hace Altas, Bajas
 * (borrado logico), Modificaciones y consultas de Empleados simpre y cuando
 * accedas a la aplicacion como Administrador
 * 
 * @author Nerea
 *
 */
public class VentanaGestionEmpleados extends JDialog implements ActionListener {

	// Otros
	private Empleado empleado;
	private String[] especialidades = new String[5];
	private int xPositionMouse, yPositionMouse;

	// Paneles
	private JPanel background;
	private JPanel menuHospitalContainer;
	private JPanel panelAlta;
	private JPanel panelMasInfo;
	private JPanel panelBajaYModificacion;

	// Labels de titulos de ventanas y header
	private JLabel lblHeaderApp;
	private JLabel lblNombreHospital;
	private JLabel lblHospitalIcono;
	private JLabel lblAlta;
	private JLabel lblBajaYModificacion;
	private JLabel lblMasInfo;

	// Botones del menu y header
	private JButton btnCerrarApp;
	private JButton btnAlta;
	private JButton btnBajaModificacion;
	private JButton btnVolverAlMenu;
	private JButton btnCerrarSesion;

	// Panel Alta
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
	private JLabel lblCodContratoA;
	private JTextField txtCodContratoA;
	private JLabel lblTipoContratoA;
	private JComboBox<String> comboBoxTipoContratoA;
	private JLabel lblFechaInicioA;
	private JDateChooser dcFechaInicioA;
	private JLabel lblFechaFinA;
	private JDateChooser dcFechaFinA;
	private JCheckBox chckbxActivoA;
	private JLabel lblActivoA;
	private JSeparator separadorAlta;
	private JLabel lblTipoEmpleA;
	private final ButtonGroup buttonGroupA = new ButtonGroup();
	private JRadioButton rdbtnDoctorA;
	private JRadioButton rdbtnEnfermeroA;
	private JLabel lblEspecialidadA;
	private JComboBox<String> comboBoxEspecialidadA;
	private JLabel lblHorarioA;
	private JComboBox<String> comboBoxHorarioA;
	private JButton btnRegistro;

	// Panel Baja y Modificacion
	private JTable tablaListadoEmpleados = new JTable();
	private JScrollPane buscarEmpleadoBM;
	private JTableHeader tableHeader;
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
	private JLabel lblCodEmpleMI;
	private JTextField txtCodEmpleMI;
	private JLabel lblDniEmpleMI;
	private JTextField txtDniEmpleMI;
	private JLabel lblNomEmpleB;
	private JTextField txtNomEmpleMI;
	private JLabel lblApellido1DelEmpleMI;
	private JTextField txtApellido1DelEmpleMI;
	private JLabel lblApellido2DelEmpleMI;
	private JTextField txtApellido2DelEmpleMI;
	private JLabel lblCodDepartMI;
	private JComboBox<String> comboBoxCodDepartMI;
	private JLabel lblCodContratoMI;
	private JTextField txtCodContratoMI;
	private JLabel lblTipoContratoMI;
	private JComboBox<String> comboBoxTipoContratoMI;
	private JLabel lblFechaInicioMI;
	private JDateChooser dcFechaInicioMI;
	private JLabel lblFechaFinMI;
	private JDateChooser dcFechaFinMI;
	private JCheckBox chckbxActivoMI;
	private JLabel lblActivoMI;
	private JSeparator separadorMasInfo;
	private JLabel lblTipoEmpleMI;
	private final ButtonGroup buttonGroupMI = new ButtonGroup();
	private JRadioButton rdbtnDoctorMI;
	private JRadioButton rdbtnEnfermeroMI;
	private JLabel lblEspecialidadMI;
	private JComboBox<String> comboBoxEspecialidadMI;
	private JLabel lblHorarioMI;
	private JComboBox<String> comboBoxHorarioMI;
	private JButton btnDarDeBaja;
	private JButton btnIrVentanaModificar;

	// Interfaces
	private EmpleadoControlable empleadoControlable;
	private DepartamentoControlable departamentoControlable;
	private EmpleadosPacienteControlable pacientesInterface;

	public VentanaGestionEmpleados(EmpleadoControlable empleadoControlable,
			EmpleadosPacienteControlable pacientesInterface, DepartamentoControlable departamentoControlable) throws CreateSqlException{
		getContentPane().setBackground(new Color(245, 245, 245));
		// Interface
		this.empleadoControlable = empleadoControlable;
		this.departamentoControlable = departamentoControlable;
		this.empleadoControlable = empleadoControlable;
		this.pacientesInterface = pacientesInterface;

		// ArrayList para los comboBox
		ArrayList<String> horarios = new ArrayList<>(empleadoControlable.buscarHorarios());
		ArrayList<String> contratos = new ArrayList<String>(empleadoControlable.buscarTipoContrato());
		ArrayList<String> codDepartamentos = new ArrayList<String>(empleadoControlable.buscarCodDepartamentos());

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
		background.setBackground(new Color(245, 245, 245));
		background.setBounds(0, 0, 1100, 600);
		background.setLayout(null);
		getContentPane().add(background);

		// Panel de Alta
		panelAlta = new JPanel();
		panelAlta.setBackground(new Color(245, 245, 245));
		panelAlta.setBounds(234, 32, 866, 568);
		panelAlta.setVisible(true);

		lblAlta = new JLabel("Alta de un Empleado");
		lblAlta.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAlta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlta.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		lblAlta.setBounds(0, 0, 271, 36);
		panelAlta.add(lblAlta);

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

		lblApellido1DelEmpleA = new JLabel("1. Apellido del Empleado");
		lblApellido1DelEmpleA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellido1DelEmpleA.setBounds(29, 322, 187, 22);
		panelAlta.add(lblApellido1DelEmpleA);

		txtApellido1DelEmpleA = new JTextField();
		txtApellido1DelEmpleA.setForeground(Color.BLACK);
		txtApellido1DelEmpleA.setColumns(10);
		txtApellido1DelEmpleA.setBackground(Color.WHITE);
		txtApellido1DelEmpleA.setBounds(29, 355, 174, 22);
		panelAlta.add(txtApellido1DelEmpleA);

		txtApellido2DelEmpleA = new JTextField();
		txtApellido2DelEmpleA.setForeground(Color.BLACK);
		txtApellido2DelEmpleA.setColumns(10);
		txtApellido2DelEmpleA.setBackground(Color.WHITE);
		txtApellido2DelEmpleA.setBounds(29, 423, 174, 22);
		panelAlta.add(txtApellido2DelEmpleA);

		lblApellido2DelEmpleA = new JLabel("2. Apellido del Empleado");
		lblApellido2DelEmpleA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellido2DelEmpleA.setBounds(29, 388, 202, 22);
		panelAlta.add(lblApellido2DelEmpleA);

		lblCodDepartA = new JLabel("Codigo del Departamento");
		lblCodDepartA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblCodDepartA.setBounds(282, 89, 222, 34);
		panelAlta.add(lblCodDepartA);

		comboBoxCodDepartA = new JComboBox<String>();
		for (String departamento : codDepartamentos) {
			comboBoxCodDepartA.addItem(departamento);
		}
		comboBoxCodDepartA.setBounds(282, 134, 174, 23);
		panelAlta.add(comboBoxCodDepartA);

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

		lblTipoContratoA = new JLabel("Tipo del Contrato");
		lblTipoContratoA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblTipoContratoA.setBounds(282, 239, 202, 34);
		panelAlta.add(lblTipoContratoA);

		comboBoxTipoContratoA = new JComboBox<String>();
		for (String contrato : contratos) {
			comboBoxTipoContratoA.addItem(contrato);
		}
		comboBoxTipoContratoA.setSelectedIndex(-1);
		comboBoxTipoContratoA.setBounds(282, 280, 174, 23);
		panelAlta.add(comboBoxTipoContratoA);

		lblFechaInicioA = new JLabel("Fecha de inicio del contrato");
		lblFechaInicioA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblFechaInicioA.setBounds(282, 322, 227, 22);
		panelAlta.add(lblFechaInicioA);

		dcFechaInicioA = new JDateChooser();
		dcFechaInicioA.setDateFormatString("yyyy/MM/dd");
		dcFechaInicioA.setBounds(282, 355, 174, 22);
		panelAlta.add(dcFechaInicioA);

		lblFechaFinA = new JLabel("Fecha de fin del contrato");
		lblFechaFinA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblFechaFinA.setBounds(282, 388, 207, 22);
		panelAlta.add(lblFechaFinA);

		dcFechaFinA = new JDateChooser();
		dcFechaFinA.setDateFormatString("yyyy/MM/dd");
		dcFechaFinA.setBounds(282, 423, 174, 22);
		panelAlta.add(dcFechaFinA);

		chckbxActivoA = new JCheckBox("");
		chckbxActivoA.setSelected(true);
		chckbxActivoA.setForeground(Color.WHITE);
		chckbxActivoA.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxActivoA.setEnabled(false);
		chckbxActivoA.setBackground(new Color(245, 245, 245));
		chckbxActivoA.setBounds(435, 518, 26, 23);
		panelAlta.add(chckbxActivoA);

		lblActivoA = new JLabel("Activo");
		lblActivoA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblActivoA.setBounds(467, 511, 58, 34);
		panelAlta.add(lblActivoA);

		separadorAlta = new JSeparator();
		separadorAlta.setOrientation(SwingConstants.VERTICAL);
		separadorAlta.setForeground(SystemColor.textHighlight);
		separadorAlta.setBackground(SystemColor.textHighlight);
		separadorAlta.setBounds(531, 21, 10, 523);
		panelAlta.add(separadorAlta);
		background.add(panelAlta);
		panelAlta.setLayout(null);

		lblTipoEmpleA = new JLabel("Tipo de empleado");
		lblTipoEmpleA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblTipoEmpleA.setBounds(590, 88, 139, 34);
		panelAlta.add(lblTipoEmpleA);

		rdbtnDoctorA = new JRadioButton("Doctor");
		buttonGroupA.add(rdbtnDoctorA);
		rdbtnDoctorA.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		rdbtnDoctorA.setBackground(new Color(245, 245, 245));
		rdbtnDoctorA.setBounds(590, 134, 75, 23);
		panelAlta.add(rdbtnDoctorA);
		rdbtnDoctorA.addActionListener(this);

		rdbtnEnfermeroA = new JRadioButton("Enfermero\r\n");
		buttonGroupA.add(rdbtnEnfermeroA);
		rdbtnEnfermeroA.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		rdbtnEnfermeroA.setBackground(new Color(245, 245, 245));
		rdbtnEnfermeroA.setBounds(590, 176, 93, 23);
		panelAlta.add(rdbtnEnfermeroA);
		rdbtnEnfermeroA.addActionListener(this);

		lblEspecialidadA = new JLabel("Especialidad");
		lblEspecialidadA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblEspecialidadA.setBounds(583, 242, 110, 34);
		panelAlta.add(lblEspecialidadA);

		comboBoxEspecialidadA = new JComboBox<String>();
		comboBoxEspecialidadA.setEnabled(false);
		comboBoxEspecialidadA.setBounds(583, 281, 174, 23);
		panelAlta.add(comboBoxEspecialidadA);

		lblHorarioA = new JLabel("Horario");
		lblHorarioA.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblHorarioA.setBounds(590, 316, 110, 34);
		panelAlta.add(lblHorarioA);

		comboBoxHorarioA = new JComboBox<String>();
		comboBoxHorarioA.setEnabled(false);
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
		// Fin Alta --------------------------------------------------------

		// Panel Baja y Modificacion ------------------------------------------
		panelBajaYModificacion = new JPanel();
		panelBajaYModificacion.setVisible(false);
		panelBajaYModificacion.setBackground(new Color(245, 245, 245));
		panelBajaYModificacion.setBounds(234, 32, 866, 568);
		background.add(panelBajaYModificacion);
		panelBajaYModificacion.setLayout(null);

		lblBajaYModificacion = new JLabel("Baja y Modificacion de un Empleado");
		lblBajaYModificacion.setBounds(0, 0, 422, 61);
		lblBajaYModificacion.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBajaYModificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblBajaYModificacion.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		panelBajaYModificacion.add(lblBajaYModificacion);

		separadorBajaYModificacion = new JSeparator();
		separadorBajaYModificacion.setOrientation(SwingConstants.VERTICAL);
		separadorBajaYModificacion.setForeground(SystemColor.textHighlight);
		separadorBajaYModificacion.setBackground(SystemColor.textHighlight);
		separadorBajaYModificacion.setBounds(566, 21, 10, 523);
		panelBajaYModificacion.add(separadorBajaYModificacion);

		lblCodigoEmpleBM = new JLabel("Codigo del empleado");
		lblCodigoEmpleBM.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblCodigoEmpleBM.setBounds(605, 63, 167, 22);
		panelBajaYModificacion.add(lblCodigoEmpleBM);

		txtCodigoEmpleBM = new JTextField();
		txtCodigoEmpleBM.setEditable(false);
		txtCodigoEmpleBM.setForeground(Color.BLACK);
		txtCodigoEmpleBM.setColumns(10);
		txtCodigoEmpleBM.setBackground(Color.WHITE);
		txtCodigoEmpleBM.setBounds(605, 102, 174, 22);
		panelBajaYModificacion.add(txtCodigoEmpleBM);

		lblDniEmpleBM = new JLabel("DNI del empleado");
		lblDniEmpleBM.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblDniEmpleBM.setBounds(605, 142, 167, 22);
		panelBajaYModificacion.add(lblDniEmpleBM);

		txtDniEmpleBM = new JTextField();
		txtDniEmpleBM.setEditable(false);
		txtDniEmpleBM.setForeground(Color.BLACK);
		txtDniEmpleBM.setColumns(10);
		txtDniEmpleBM.setBackground(Color.WHITE);
		txtDniEmpleBM.setBounds(605, 175, 174, 22);
		panelBajaYModificacion.add(txtDniEmpleBM);

		lblNomEmpleBM = new JLabel("Nombre del empleado");
		lblNomEmpleBM.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblNomEmpleBM.setBounds(605, 208, 185, 22);
		panelBajaYModificacion.add(lblNomEmpleBM);

		txtNomEmpleBM = new JTextField();
		txtNomEmpleBM.setEditable(false);
		txtNomEmpleBM.setForeground(Color.BLACK);
		txtNomEmpleBM.setColumns(10);
		txtNomEmpleBM.setBackground(Color.WHITE);
		txtNomEmpleBM.setBounds(605, 241, 174, 22);
		panelBajaYModificacion.add(txtNomEmpleBM);

		lblApellido1DelEmpleBM = new JLabel("1. Apellido del Empleado");
		lblApellido1DelEmpleBM.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellido1DelEmpleBM.setBounds(605, 274, 187, 22);
		panelBajaYModificacion.add(lblApellido1DelEmpleBM);

		txtApellido1DelEmpleBM = new JTextField();
		txtApellido1DelEmpleBM.setEditable(false);
		txtApellido1DelEmpleBM.setForeground(Color.BLACK);
		txtApellido1DelEmpleBM.setColumns(10);
		txtApellido1DelEmpleBM.setBackground(Color.WHITE);
		txtApellido1DelEmpleBM.setBounds(605, 307, 174, 22);
		panelBajaYModificacion.add(txtApellido1DelEmpleBM);

		lblApellido2DelEmpleBM = new JLabel("2. Apellido del Empleado");
		lblApellido2DelEmpleBM.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellido2DelEmpleBM.setBounds(605, 340, 202, 22);
		panelBajaYModificacion.add(lblApellido2DelEmpleBM);

		txtApellido2DelEmpleBM = new JTextField();
		txtApellido2DelEmpleBM.setEditable(false);
		txtApellido2DelEmpleBM.setForeground(Color.BLACK);
		txtApellido2DelEmpleBM.setColumns(10);
		txtApellido2DelEmpleBM.setBackground(Color.WHITE);
		txtApellido2DelEmpleBM.setBounds(605, 373, 174, 22);
		panelBajaYModificacion.add(txtApellido2DelEmpleBM);

		btnMasInformacion = new JButton("MAS INFORMACION");
		btnMasInformacion.setBounds(661, 487, 172, 41);
		btnMasInformacion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMasInformacion.setForeground(Color.WHITE);
		btnMasInformacion.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnMasInformacion.setFocusPainted(false);
		btnMasInformacion.setBorder(null);
		btnMasInformacion.setBackground(new Color(0, 118, 255));
		panelBajaYModificacion.add(btnMasInformacion);
		btnMasInformacion.addActionListener(this);

		// Generado de Tabla
		ArrayList<Empleado> empleados = null;
		String tableMatrix[][] = null;

		empleados = empleadoControlable.listarEmpleadosTabla();
		if (empleados.size() > 0) {
			tableMatrix = new String[empleados.size()][3];
			for (int i = 0; i < empleados.size(); i++) {
				tableMatrix[i][0] = empleados.get(i).getCodEmpleado();
				tableMatrix[i][1] = empleados.get(i).getNombreEmpleado();
				tableMatrix[i][2] = empleados.get(i).getTipoEmpleado();
			}

			String titles[] = { "Codigo Empleado", "Nombre", "Tipo Empleado" };

			tablaListadoEmpleados = new JTable(tableMatrix, titles) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
					return false;
				}
			};
			;

			buscarEmpleadoBM = new JScrollPane();
			buscarEmpleadoBM.setBounds(40, 70, 451, 452);
			buscarEmpleadoBM.setViewportView(tablaListadoEmpleados);
			panelBajaYModificacion.add(buscarEmpleadoBM);

			tablaListadoEmpleados.setSelectionBackground(new Color(24, 24, 24));
			tablaListadoEmpleados.setSelectionForeground(Color.WHITE);
			tablaListadoEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tablaListadoEmpleados.setRowMargin(0);
			tablaListadoEmpleados.setRowHeight(25);
			tablaListadoEmpleados.setShowVerticalLines(true);
			tablaListadoEmpleados.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));

			tableHeader = tablaListadoEmpleados.getTableHeader();
			tableHeader.setBackground(new Color(0, 118, 255));
			tableHeader.setForeground(Color.WHITE);
			tableHeader.setFont(new Font("Montserrat Medium", Font.BOLD, 15));
			tableHeader.setEnabled(false);

			btnListarMouseListener(empleadoControlable);
		}
		// Fin Panel Baja y Modificacion ------------------------------------------

		// Panel mas informacion
		panelMasInfo = new JPanel();
		panelMasInfo.setVisible(false);
		panelMasInfo.setBackground(new Color(245, 245, 245));
		panelMasInfo.setBounds(234, 32, 866, 568);
		background.add(panelMasInfo);
		panelMasInfo.setLayout(null);

		lblMasInfo = new JLabel("Informacion completa del Empleado");
		lblMasInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMasInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMasInfo.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		lblMasInfo.setBounds(0, 0, 433, 41);
		panelMasInfo.add(lblMasInfo);

		lblCodEmpleMI = new JLabel("Codigo del empleado");
		lblCodEmpleMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblCodEmpleMI.setBounds(29, 95, 167, 22);
		panelMasInfo.add(lblCodEmpleMI);

		txtCodEmpleMI = new JTextField();
		txtCodEmpleMI.setEditable(false);
		txtCodEmpleMI.setForeground(Color.BLACK);
		txtCodEmpleMI.setColumns(10);
		txtCodEmpleMI.setBackground(Color.WHITE);
		txtCodEmpleMI.setBounds(29, 134, 174, 22);
		panelMasInfo.add(txtCodEmpleMI);

		lblDniEmpleMI = new JLabel("DNI del empleado");
		lblDniEmpleMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblDniEmpleMI.setBounds(29, 174, 167, 22);
		panelMasInfo.add(lblDniEmpleMI);

		txtDniEmpleMI = new JTextField();
		txtDniEmpleMI.setEditable(false);
		txtDniEmpleMI.setForeground(Color.BLACK);
		txtDniEmpleMI.setColumns(10);
		txtDniEmpleMI.setBackground(Color.WHITE);
		txtDniEmpleMI.setBounds(29, 207, 174, 22);
		panelMasInfo.add(txtDniEmpleMI);

		lblNomEmpleB = new JLabel("Nombre del empleado");
		lblNomEmpleB.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblNomEmpleB.setBounds(29, 245, 185, 22);
		panelMasInfo.add(lblNomEmpleB);

		txtNomEmpleMI = new JTextField();
		txtNomEmpleMI.setForeground(Color.BLACK);
		txtNomEmpleMI.setColumns(10);
		txtNomEmpleMI.setBackground(Color.WHITE);
		txtNomEmpleMI.setBounds(29, 278, 174, 22);
		panelMasInfo.add(txtNomEmpleMI);

		lblApellido1DelEmpleMI = new JLabel("1. Apellido del Empleado");
		lblApellido1DelEmpleMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellido1DelEmpleMI.setBounds(29, 313, 187, 22);
		panelMasInfo.add(lblApellido1DelEmpleMI);

		txtApellido1DelEmpleMI = new JTextField();
		txtApellido1DelEmpleMI.setForeground(Color.BLACK);
		txtApellido1DelEmpleMI.setColumns(10);
		txtApellido1DelEmpleMI.setBackground(Color.WHITE);
		txtApellido1DelEmpleMI.setBounds(29, 346, 174, 22);
		panelMasInfo.add(txtApellido1DelEmpleMI);

		lblApellido2DelEmpleMI = new JLabel("2. Apellido del Empleado");
		lblApellido2DelEmpleMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellido2DelEmpleMI.setBounds(29, 389, 202, 22);
		panelMasInfo.add(lblApellido2DelEmpleMI);

		txtApellido2DelEmpleMI = new JTextField();
		txtApellido2DelEmpleMI.setForeground(Color.BLACK);
		txtApellido2DelEmpleMI.setColumns(10);
		txtApellido2DelEmpleMI.setBackground(Color.WHITE);
		txtApellido2DelEmpleMI.setBounds(29, 422, 174, 22);
		panelMasInfo.add(txtApellido2DelEmpleMI);

		lblCodDepartMI = new JLabel("Codigo del Departamento");
		lblCodDepartMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblCodDepartMI.setBounds(278, 94, 222, 34);
		panelMasInfo.add(lblCodDepartMI);

		comboBoxCodDepartMI = new JComboBox<String>();
		for (String departamento : codDepartamentos) {
			comboBoxCodDepartMI.addItem(departamento);
		}
		comboBoxCodDepartMI.setBounds(278, 133, 174, 23);
		panelMasInfo.add(comboBoxCodDepartMI);

		lblCodContratoMI = new JLabel("Codigo del Contrato");
		lblCodContratoMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblCodContratoMI.setBounds(278, 170, 167, 22);
		panelMasInfo.add(lblCodContratoMI);

		txtCodContratoMI = new JTextField();
		txtCodContratoMI.setForeground(Color.BLACK);
		txtCodContratoMI.setColumns(10);
		txtCodContratoMI.setBackground(Color.WHITE);
		txtCodContratoMI.setBounds(278, 209, 174, 22);
		panelMasInfo.add(txtCodContratoMI);

		lblTipoContratoMI = new JLabel("Tipo del Contrato");
		lblTipoContratoMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblTipoContratoMI.setBounds(279, 242, 202, 34);
		panelMasInfo.add(lblTipoContratoMI);

		comboBoxTipoContratoMI = new JComboBox<String>();
		for (String contrato : contratos) {
			comboBoxTipoContratoMI.addItem(contrato);
		}
		comboBoxTipoContratoMI.setEditable(false);
		comboBoxTipoContratoMI.setBounds(279, 281, 174, 23);
		panelMasInfo.add(comboBoxTipoContratoMI);

		lblFechaInicioMI = new JLabel("Fecha de inicio del contrato");
		lblFechaInicioMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblFechaInicioMI.setBounds(278, 321, 227, 22);
		panelMasInfo.add(lblFechaInicioMI);

		dcFechaInicioMI = new JDateChooser();
		dcFechaInicioMI.setDateFormatString("yyyy/MM/dd");
		dcFechaInicioMI.setBounds(279, 353, 174, 22);
		panelMasInfo.add(dcFechaInicioMI);

		lblFechaFinMI = new JLabel("Fecha de fin del contrato");
		lblFechaFinMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblFechaFinMI.setBounds(278, 392, 207, 22);
		panelMasInfo.add(lblFechaFinMI);

		dcFechaFinMI = new JDateChooser();
		dcFechaFinMI.setDateFormatString("yyyy/MM/dd");
		dcFechaFinMI.setBounds(279, 424, 174, 22);
		panelMasInfo.add(dcFechaFinMI);

		chckbxActivoMI = new JCheckBox("");
		chckbxActivoMI.setSelected(true);
		chckbxActivoMI.setForeground(Color.WHITE);
		chckbxActivoMI.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxActivoMI.setBackground(new Color(245, 245, 245));
		chckbxActivoMI.setBounds(438, 518, 26, 23);
		panelMasInfo.add(chckbxActivoMI);

		lblActivoMI = new JLabel("Activo");
		lblActivoMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblActivoMI.setBounds(470, 511, 58, 34);
		panelMasInfo.add(lblActivoMI);

		separadorMasInfo = new JSeparator();
		separadorMasInfo.setOrientation(SwingConstants.VERTICAL);
		separadorMasInfo.setForeground(SystemColor.textHighlight);
		separadorMasInfo.setBackground(SystemColor.textHighlight);
		separadorMasInfo.setBounds(534, 22, 10, 523);
		panelMasInfo.add(separadorMasInfo);

		lblTipoEmpleMI = new JLabel("Tipo de empleado");
		lblTipoEmpleMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblTipoEmpleMI.setBounds(590, 89, 139, 34);
		panelMasInfo.add(lblTipoEmpleMI);

		rdbtnDoctorMI = new JRadioButton("Doctor");
		buttonGroupMI.add(rdbtnDoctorMI);
		rdbtnDoctorMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		rdbtnDoctorMI.setBackground(new Color(245, 245, 245));
		rdbtnDoctorMI.setBounds(590, 134, 75, 23);
		panelMasInfo.add(rdbtnDoctorMI);

		rdbtnEnfermeroMI = new JRadioButton("Enfermero\r\n");
		buttonGroupMI.add(rdbtnEnfermeroMI);
		rdbtnEnfermeroMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		rdbtnEnfermeroMI.setBackground(new Color(245, 245, 245));
		rdbtnEnfermeroMI.setBounds(590, 176, 93, 23);
		panelMasInfo.add(rdbtnEnfermeroMI);

		lblEspecialidadMI = new JLabel("Especialidad");
		lblEspecialidadMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblEspecialidadMI.setBounds(590, 239, 110, 34);
		panelMasInfo.add(lblEspecialidadMI);

		comboBoxEspecialidadMI = new JComboBox<String>();
		comboBoxEspecialidadMI.setBounds(590, 284, 174, 23);
		panelMasInfo.add(comboBoxEspecialidadMI);

		lblHorarioMI = new JLabel("Horario");
		lblHorarioMI.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblHorarioMI.setBounds(590, 313, 110, 34);
		panelMasInfo.add(lblHorarioMI);

		comboBoxHorarioMI = new JComboBox<String>();
		for (String horario : horarios) {
			comboBoxHorarioMI.addItem(horario);
		}
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

		btnDarDeBaja = new JButton("DAR DE BAJA");
		btnDarDeBaja.setForeground(Color.WHITE);
		btnDarDeBaja.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		btnDarDeBaja.setFocusPainted(false);
		btnDarDeBaja.setBorder(null);
		btnDarDeBaja.setBackground(new Color(0, 118, 255));
		btnDarDeBaja.setBounds(560, 504, 131, 41);
		panelMasInfo.add(btnDarDeBaja);
		// Fin Panel mas informacion ------------------------------------------

		// Contenedor de pestanias y logo
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

		lblNombreHospital = new JLabel("Steven B. III");
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
		btnDarDeAltaMouseListener();
		btnDarDeBajaListener();
		btnBajaModificacionMouseListener();
		btnModificacionMouseListener();
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

		btnCerrarSesion = new JButton("Cerrar sesion");
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
		btnListarEspecialidadesListener();
		btnListarEspecialidadesMIListener();
		// Fin contenedor pestanias y logo ----------------------------------------
	}
	
	/**
	 * Escucha al Label del head para poder mover la ventana por la pantalla
	 */
	private void lblHeaderAppMouseMotionListener() {

		MouseMotionListener ml = new MouseMotionListener() {

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

		lblHeaderApp.addMouseMotionListener(ml);

	}

	/**
	 * Escucha al Label del head para poder mover la ventana por la pantalla
	 */
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

	/**
	 * Escucha al Boton de cerrar ventana
	 */
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
	
	/**
	 * Escucha al Boton de ir al panel de Alta
	 **/
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
				panelMasInfo.setVisible(false);
				panelAlta.setVisible(true);
				panelBajaYModificacion.setVisible(false);

			}
		};

		btnAlta.addMouseListener(ml);

	}

	/**
	 * Escucha al Boton de ir al panel de Baja y Modificacion
	 **/
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
				panelMasInfo.setVisible(false);
				panelBajaYModificacion.setVisible(true);
				panelAlta.setVisible(false);
			}
		};

		btnBajaModificacion.addMouseListener(ml);

	}
	
	/**
	 * Escucha al Boton de ir al panel de Mas Informacion
	 * 
	 * @param codigo El codigo del empleado y empleadoControlable la interfaz de
	 *               gestion de empleados
	 */
	private void btnIrMasInfoMouseListener(Empleado emple) {

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

	/**
	 * Escucha el Boton de registro para para utilizar el metodo de dar de alta de
	 * la interfaz
	 **/
	private void btnDarDeAltaMouseListener() throws CreateSqlException {

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
						|| txtCodContratoA.getText().isEmpty() || (comboBoxCodDepartA.getSelectedIndex() == -1)
						|| (comboBoxTipoContratoA.getSelectedIndex() == -1)
						|| dcFechaInicioA.getDate().toString().isEmpty()
						|| dcFechaFinA.getDate().toString().isEmpty()) {

					JOptionPane.showMessageDialog(btnRegistro, this, "Error, falta algun dato por rellenar",
							JOptionPane.ERROR_MESSAGE);

				} else {

					String tipoEmple;
					String espeHora;

					if (rdbtnEnfermeroA.isSelected()) {
						tipoEmple = "Enfermero";
						espeHora = comboBoxHorarioA.getSelectedItem().toString();
					} else {
						tipoEmple = "Doctor";
						espeHora = comboBoxEspecialidadA.getSelectedItem().toString();
					}

					java.sql.Date fechaFin = new java.sql.Date(dcFechaFinA.getDate().getTime());

					java.sql.Date fechaInicio = new java.sql.Date(dcFechaInicioA.getDate().getTime());

					Contrato con = new Contrato(txtCodContratoA.getText(),
							comboBoxTipoContratoA.getSelectedItem().toString(), fechaInicio, fechaFin);
					Empleado emple = new Empleado(txtCodEmpleA.getText(),
							comboBoxCodDepartA.getSelectedItem().toString(), txtDniEmpleA.getText(),
							txtNombreEmpleA.getText(), txtApellido1DelEmpleA.getText(), txtApellido2DelEmpleA.getText(),
							true, tipoEmple, "abcd*1234");

					try {
						empleadoControlable.altaEmpleado(emple, con, espeHora);
					} catch (CreateSqlException e1) {
					
					}

					try {
						cerrar();
					} catch (CreateSqlException e1) {
					}
				}
			}
		};

		btnRegistro.addMouseListener(ml);
	}

	/**
	 * Escucha el Boton de dar de baja para para utilizar el metodo de dar de baja
	 * de la interfaz
	 */
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
				int confirmado = JOptionPane.showConfirmDialog(panelMasInfo, "Estas seguro de darle de baja?", "",
						JOptionPane.INFORMATION_MESSAGE);
				if (JOptionPane.OK_OPTION == confirmado) {
					try {
						empleadoControlable.eliminarEmpleado(empleado, txtCodigoEmpleBM.getText());
					} catch (CreateSqlException e1) {
						
					}
					try {
						cerrar();
					} catch (CreateSqlException e1) {
					}
				} else
					JOptionPane.showMessageDialog(panelMasInfo, "Baja cancelada");
				panelMasInfo.setVisible(false);
				panelBajaYModificacion.setVisible(true);

			}
		};
		btnDarDeBaja.addMouseListener(ml);
	}
	
	/**
	 * Escucha al boton de modificar para para utilizar el metodo de modificacion
	 */
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

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				String tipoEmple;
				String espeHora;
				
				if (rdbtnEnfermeroA.isSelected()) {
					tipoEmple = "Enfermero";
					espeHora = comboBoxHorarioMI.getSelectedItem().toString();
				} else {
					tipoEmple = "Doctor";
					espeHora = comboBoxEspecialidadMI.getSelectedItem().toString();
				}

				java.sql.Date fechaFin = new java.sql.Date(dcFechaFinMI.getDate().getTime());

				java.sql.Date fechaInicio = new java.sql.Date(dcFechaInicioMI.getDate().getTime());

				Contrato con = new Contrato(txtCodContratoMI.getText(),
						comboBoxTipoContratoMI.getSelectedItem().toString(), fechaInicio, fechaFin);
				Empleado emple = new Empleado(txtCodEmpleMI.getText(), comboBoxCodDepartMI.getSelectedItem().toString(),
						txtDniEmpleMI.getText(), txtNomEmpleMI.getText(), txtApellido1DelEmpleMI.getText(),
						txtApellido2DelEmpleMI.getText(), chckbxActivoMI.isSelected(), tipoEmple, "abcd*1234");

				try {
					empleadoControlable.modificarEmpleado(emple, con, espeHora);
				} catch (CreateSqlException e1) {

				}

				try {
					cerrar();
				} catch (CreateSqlException e1) {
				}
			}
		};
		btnIrVentanaModificar.addMouseListener(ml);
	}

	

	/**
	 * Escucha al Boton de cerrar sesion
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

	/**
	 * Escucha al Boton de vuelta al menu
	 */
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

	/**
	 * Escucha al ConboBox de Especialidades pero del panel del Alta
	 */
	private void btnListarEspecialidadesListener() {

		MouseListener nl = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				comboBoxEspecialidadA.removeAllItems();
				ArrayList<String> especialidades = null;
				try {
					especialidades = new ArrayList<>(
							empleadoControlable.buscarEspecialidades(comboBoxCodDepartA.getSelectedItem().toString()));
				} catch (CreateSqlException e1) {
				}
				for (String especialidad : especialidades) {
					comboBoxEspecialidadA.addItem(especialidad);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				comboBoxEspecialidadA.removeAllItems();
				ArrayList<String> especialidades = null;
				try {
					especialidades = new ArrayList<>(
							empleadoControlable.buscarEspecialidades(comboBoxCodDepartA.getSelectedItem().toString()));
				} catch (CreateSqlException e1) {
				}
				for (String especialidad : especialidades) {
					comboBoxEspecialidadA.addItem(especialidad);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				comboBoxEspecialidadA.removeAllItems();
				ArrayList<String> especialidades = null;
				try {
					especialidades = new ArrayList<>(
							empleadoControlable.buscarEspecialidades(comboBoxCodDepartA.getSelectedItem().toString()));
				} catch (CreateSqlException e1) {
				}
				for (String especialidad : especialidades) {
					comboBoxEspecialidadA.addItem(especialidad);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				comboBoxEspecialidadA.removeAllItems();
				ArrayList<String> especialidades = null;
				try {
					especialidades = new ArrayList<>(
							empleadoControlable.buscarEspecialidades(comboBoxCodDepartA.getSelectedItem().toString()));
				} catch (CreateSqlException e1) {

				}
				for (String especialidad : especialidades) {
					comboBoxEspecialidadA.addItem(especialidad);
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				comboBoxEspecialidadA.removeAllItems();
				ArrayList<String> especialidades = null;
				try {
					especialidades = new ArrayList<>(
							empleadoControlable.buscarEspecialidades(comboBoxCodDepartA.getSelectedItem().toString()));
				} catch (CreateSqlException e1) {

				}
				for (String especialidad : especialidades) {
					comboBoxEspecialidadA.addItem(especialidad);
				}
			}
		};

		comboBoxCodDepartA.addMouseListener(nl);

	}

	/**
	 * Escucha al ConboBox de Especialidades pero del panel Mas informacion
	 */
	private void btnListarEspecialidadesMIListener() {

		MouseListener nl = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				comboBoxEspecialidadMI.removeAllItems();
				ArrayList<String> especialidades = null;
				try {
					especialidades = new ArrayList<>(
							empleadoControlable.buscarEspecialidades(comboBoxCodDepartMI.getSelectedItem().toString()));
				} catch (CreateSqlException e1) {
				}
				for (String especialidad : especialidades) {
					comboBoxEspecialidadMI.addItem(especialidad);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				comboBoxEspecialidadMI.removeAllItems();
				ArrayList<String> especialidades = null;
				try {
					especialidades = new ArrayList<>(
							empleadoControlable.buscarEspecialidades(comboBoxCodDepartMI.getSelectedItem().toString()));
				} catch (CreateSqlException e1) {
				}
				for (String especialidad : especialidades) {
					comboBoxEspecialidadMI.addItem(especialidad);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				comboBoxEspecialidadMI.removeAllItems();
				ArrayList<String> especialidades = null;
				try {
					especialidades = new ArrayList<>(
							empleadoControlable.buscarEspecialidades(comboBoxCodDepartMI.getSelectedItem().toString()));
				} catch (CreateSqlException e1) {

				}
				for (String especialidad : especialidades) {
					comboBoxEspecialidadMI.addItem(especialidad);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				comboBoxEspecialidadMI.removeAllItems();
				ArrayList<String> especialidades = null;
				try {
					especialidades = new ArrayList<>(
							empleadoControlable.buscarEspecialidades(comboBoxCodDepartMI.getSelectedItem().toString()));
				} catch (CreateSqlException e1) {
				}
				for (String especialidad : especialidades) {
					comboBoxEspecialidadMI.addItem(especialidad);
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				comboBoxEspecialidadMI.removeAllItems();
				ArrayList<String> especialidades = null;
				try {
					especialidades = new ArrayList<>(
							empleadoControlable.buscarEspecialidades(comboBoxCodDepartMI.getSelectedItem().toString()));
				} catch (CreateSqlException e1) {
				}
				for (String especialidad : especialidades) {
					comboBoxEspecialidadMI.addItem(especialidad);
				}
			}
		};

		comboBoxCodDepartMI.addMouseListener(nl);

	}

	/**
	 * Escucha a la tabla de Empleados
	 * 
	 * @param empleadoControlable La interfaz de de gestion de empleados
	 */
	private void btnListarMouseListener(EmpleadoControlable empleadoControlable) {

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

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				Empleado emple = null;

				String codigo = tablaListadoEmpleados.getValueAt(tablaListadoEmpleados.getSelectedRow(), 0).toString();

				try {
					emple = empleadoControlable.buscarEmpleado(codigo);
				} catch (CreateSqlException e1) {
				}

				txtCodigoEmpleBM.setText(emple.getCodEmpleado());
				txtDniEmpleBM.setText(emple.getDniEmpleado());
				txtNomEmpleBM.setText(emple.getNombreEmpleado());
				txtApellido1DelEmpleBM.setText(emple.getApellido1Empleado());
				txtApellido2DelEmpleBM.setText(emple.getApellido2Empleado());

				btnIrMasInfoMouseListener(emple);

			}
		};
		tablaListadoEmpleados.addMouseListener(ml);
	}
	
	/**
	 * Cierre de ventana para actualizar la tabla
	 * @throws CreateSqlException 
	 **/
	protected void cerrar() throws CreateSqlException {
		this.dispose();
		VentanaGestionEmpleados ventana = new VentanaGestionEmpleados(empleadoControlable, pacientesInterface,departamentoControlable);
		ventana.setVisible(true);
	}

	/**
	 * Que hacen los botones que tienen las ventanas y o paneles
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Radio buttons
		if (e.getSource().equals(rdbtnDoctorA)) {
			comboBoxEspecialidadA.setEnabled(true);
			comboBoxHorarioA.setEnabled(false);
		}
		if (e.getSource().equals(rdbtnEnfermeroA)) {
			comboBoxEspecialidadA.setEnabled(false);
			comboBoxHorarioA.setEnabled(true);
		}
		if (e.getSource().equals(rdbtnDoctorMI)) {
			comboBoxEspecialidadMI.setEnabled(true);
			comboBoxHorarioMI.setEnabled(false);
		}
		if (e.getSource().equals(rdbtnEnfermeroMI)) {
			comboBoxEspecialidadMI.setEnabled(false);
			comboBoxHorarioMI.setEnabled(true);
		}

		// Boton para abrir el panel de mas informacion
		if (e.getSource().equals(btnMasInformacion)) {
			int selectedRow = tablaListadoEmpleados.getSelectedRow();

			if (selectedRow != -1) {

				panelBajaYModificacion.setVisible(false);
				panelMasInfo.setVisible(true);

				Empleado emple = null;

				String codigo = tablaListadoEmpleados.getValueAt(tablaListadoEmpleados.getSelectedRow(), 0).toString();

				try {
					emple = empleadoControlable.buscarEmpleado(codigo);
				} catch (CreateSqlException e1) {
				}

				Contrato contrato = null;
				String espeHora = null;

				try {
					contrato = empleadoControlable.buscarContrato(codigo);
				} catch (CreateSqlException e1) {
				}
				try {
					espeHora = empleadoControlable.buscarEspecialidadHorario(codigo);
				} catch (CreateSqlException e1) {
				}

				txtCodEmpleMI.setText(emple.getCodEmpleado());
				txtDniEmpleMI.setText(emple.getDniEmpleado());
				txtNomEmpleMI.setText(emple.getNombreEmpleado());
				txtApellido1DelEmpleMI.setText(emple.getApellido1Empleado());
				txtApellido2DelEmpleMI.setText(emple.getApellido2Empleado());
				comboBoxCodDepartMI.setSelectedItem(emple.getCodDepartamento());
				txtCodContratoMI.setText(contrato.getCodContrato());
				comboBoxTipoContratoMI.setSelectedItem(contrato.getTipoContrato());
				dcFechaInicioMI.setDate(contrato.getFechaInicio());
				dcFechaFinMI.setDate(contrato.getFechaFin());
				chckbxActivoMI.setSelected(emple.isActivoEmpleado());

				if (emple.getTipoEmpleado().equalsIgnoreCase("Doctor")) {
					rdbtnDoctorMI.setSelected(true);
					comboBoxEspecialidadMI.setSelectedItem(espeHora);
				} else {
					rdbtnEnfermeroMI.setSelected(true);
					comboBoxHorarioMI.setSelectedItem(espeHora);
				}

			}else {
				JOptionPane.showMessageDialog(this, "No esta seleccionado ningun empleado", "", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		// Botones del menu
		if (e.getSource().equals(btnVolverAlMenu)) {
			this.dispose();
			VentanaAdminGestionDepartamentoYEmpleado VentanaAdminGestionDepartamentoYEmpleado = new VentanaAdminGestionDepartamentoYEmpleado(
					empleadoControlable, departamentoControlable, pacientesInterface);
			VentanaAdminGestionDepartamentoYEmpleado.setVisible(true);

		}
		if (e.getSource().equals(btnCerrarSesion)) {
			int confirmado = JOptionPane.showConfirmDialog(this, "Estas seguro de cerrar sesion?", "Cerrar sesion",
					JOptionPane.INFORMATION_MESSAGE);
			if (JOptionPane.OK_OPTION == confirmado) {
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(empleadoControlable, pacientesInterface,
						departamentoControlable);
				ventanaPrincipal.setVisible(true);
				this.dispose();
			} else
				System.out.println("");
		}
	}
}