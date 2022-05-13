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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import interfaces.*;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Cursor;

public class VentanaGestionDepartamentos extends JDialog implements ActionListener{

	private JPanel background;
	private JPanel menuHospitalContainer;
	private JPanel panelAlta;
	private JPanel panelBajaYModificacion;

	private JLabel lblHeaderApp;
	private JLabel lblNombreHospital;
	private JLabel lblHospitalIcono;
	private JLabel lblAlta;
	private JLabel lblBajaYModificacion;
	private JLabel lblCdigoDelDepartamento_1;
	private JLabel lblNombreDelDepartamento_1;
	private JLabel lblEspecialidad_1;
	private JLabel lblTextoEspecialidad_1;
	private JLabel lblTextoEspecialidad_2;
	private JLabel lblCdigoDelDepartamento_2;
	private JLabel lblNombreDelDepartamento_2;
	private JLabel lblEspecialidad_2;

	private JTextField txtCodigoDelDepartamento_1;
	private JTextField txtNombreDelDepartamento_1;
	private JTextField txtEspecialidad_1;
	private JTextField txtBarrarDeBusqueda_1;
	private JTextField textFieldCdigoDelDepartamento_2;
	private JTextField textFieldNombreDelDepartamento_2;

	private JButton btnAlta;
	private JButton btnBaja;
	private JButton btnAgregarEspecialidad;
	private JButton btnDarDeAlta;
	private JButton btnDarDeBaja;
	private JButton btnModificar;
	private JButton btnCerrarApp;
	private JButton btnBusqueda_1;
	private JButton btnVolverAlMenu;
	private JButton btnCerrarSesion;

	private JCheckBox chckbxActivo_1;
	private JCheckBox chckbxActivo_2;

	private JComboBox comboBoxEspecialidades_1;

	private JSeparator separatorCodigoDelDepartamento_1;
	private JSeparator separatorNombreDelDepartamento_1;
	private JSeparator separatorEspecialidad;
	private JSeparator separatorCodigoDelDepartamento_2;
	private JSeparator separatorNombreDelDepartamento_2;
	private JSeparator separator;

	private int xPositionMouse, yPositionMouse;
	
	private EmpleadoControlable empleadoControlable;

	public VentanaGestionDepartamentos(EmpleadoControlable empleadoControlable) {
		this.empleadoControlable = empleadoControlable;
		
		setUndecorated(true);
		setLocationByPlatform(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imgs/cruzRoja.png")));
		setBounds(500, 200, 1100, 600);
		getContentPane().setLayout(null);

		background = new JPanel();
		background.setBackground(new Color(248, 250, 251));
		background.setBounds(0, 0, 1100, 600);
		background.setLayout(null);
		getContentPane().add(background);

		menuHospitalContainer = new JPanel();
		menuHospitalContainer.setBounds(0, 0, 234, 600);
		menuHospitalContainer.setLayout(null);
		menuHospitalContainer.setBackground(Color.WHITE);
		background.add(menuHospitalContainer);

		panelAlta = new JPanel();
		panelAlta.setBounds(1500, 32, 866, 568);
		panelAlta.setLayout(null);
		panelAlta.setBackground(new Color(248, 250, 251));
		panelAlta.setVisible(true);
		background.add(panelAlta);

		panelBajaYModificacion = new JPanel();
		panelBajaYModificacion.setVisible(false);
		panelBajaYModificacion.setBackground(new Color(255, 255, 255));
		panelBajaYModificacion.setBounds(234, 32, 1380, 600);
		panelBajaYModificacion.setLayout(null);
		background.add(panelBajaYModificacion);

		btnCerrarApp = new JButton("x");
		btnCerrarApp.setBounds(1032, 0, 68, 31);
		btnCerrarApp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrarApp.setForeground(Color.WHITE);
		btnCerrarApp.setFont(new Font("Montserrat Medium", Font.BOLD, 25));
		btnCerrarApp.setFocusPainted(false);
		btnCerrarApp.setBorder(null);
		btnCerrarApp.setBackground(new Color(0, 118, 255));
		background.add(btnCerrarApp);
		btnCerrarAppMouseListener();

		lblHeaderApp = new JLabel("");
		lblHeaderApp.setBounds(0, 0, 1033, 31);
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
		lblHospitalIcono.setIcon(new ImageIcon(VentanaGestionDepartamentos.class.getResource("/imgs/cruzRoja-32x32.png")));
		lblHospitalIcono.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHospitalIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospitalIcono.setBounds(0, 28, 50, 43);
		menuHospitalContainer.add(lblHospitalIcono);

		lblAlta = new JLabel("Alta");
		lblAlta.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAlta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlta.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		lblAlta.setBounds(0, 0, 141, 50);
		panelAlta.add(lblAlta);

		lblBajaYModificacion = new JLabel("Baja y Modificacion");
		lblBajaYModificacion.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBajaYModificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblBajaYModificacion.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		lblBajaYModificacion.setBounds(20, 11, 212, 50);
		panelBajaYModificacion.add(lblBajaYModificacion);

		lblCdigoDelDepartamento_1 = new JLabel("C\u00D3DIGO DEL DEPARTAMENTO");
		lblCdigoDelDepartamento_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblCdigoDelDepartamento_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCdigoDelDepartamento_1.setIcon(new ImageIcon(VentanaGestionDepartamentos.class.getResource("/imgs/codigode.png")));
		lblCdigoDelDepartamento_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		lblCdigoDelDepartamento_1.setBounds(52, 114, 292, 21);
		panelAlta.add(lblCdigoDelDepartamento_1);

		lblNombreDelDepartamento_1 = new JLabel("NOMBRE DEL DEPARTAMENTO");
		lblNombreDelDepartamento_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNombreDelDepartamento_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreDelDepartamento_1.setIcon(new ImageIcon(VentanaGestionDepartamentos.class.getResource("/imgs/nombrede.png")));
		lblNombreDelDepartamento_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		lblNombreDelDepartamento_1.setBounds(52, 241, 291, 21);
		panelAlta.add(lblNombreDelDepartamento_1);

		lblEspecialidad_1 = new JLabel("ESPECIALIDAD");
		lblEspecialidad_1.setIcon(new ImageIcon(VentanaGestionDepartamentos.class.getResource("/imgs/especialidad.png")));
		lblEspecialidad_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblEspecialidad_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEspecialidad_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		lblEspecialidad_1.setBounds(441, 107, 161, 28);
		panelAlta.add(lblEspecialidad_1);

		lblTextoEspecialidad_1 = new JLabel("<html>\u25A0 Solo puedes agregar una especialidad <br/>al mismo tiempo.");
		lblTextoEspecialidad_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 13));
		lblTextoEspecialidad_1.setBounds(441, 280, 278, 50);
		panelAlta.add(lblTextoEspecialidad_1);

		lblTextoEspecialidad_2 = new JLabel("<html>\u25A0 Solo se pueden agregar hasta <br/>5 especialidades</html>");
		lblTextoEspecialidad_2.setFont(new Font("Montserrat Medium", Font.PLAIN, 13));
		lblTextoEspecialidad_2.setForeground(new Color(0, 118, 255));
		lblTextoEspecialidad_2.setBounds(441, 328, 278, 50);
		panelAlta.add(lblTextoEspecialidad_2);

		lblCdigoDelDepartamento_2 = new JLabel("C\u00D3DIGO DEL DEPARTAMENTO");
		lblCdigoDelDepartamento_2.setIcon(new ImageIcon(VentanaGestionDepartamentos.class.getResource("/imgs/codigode.png")));
		lblCdigoDelDepartamento_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblCdigoDelDepartamento_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCdigoDelDepartamento_2.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
		lblCdigoDelDepartamento_2.setBounds(434, 113, 186, 21);
		panelBajaYModificacion.add(lblCdigoDelDepartamento_2);

		lblNombreDelDepartamento_2 = new JLabel("NOMBRE DEL DEPARTAMENTO");
		lblNombreDelDepartamento_2.setIcon(new ImageIcon(VentanaGestionDepartamentos.class.getResource("/imgs/nombrede.png")));
		lblNombreDelDepartamento_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNombreDelDepartamento_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreDelDepartamento_2.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
		lblNombreDelDepartamento_2.setBounds(434, 240, 291, 21);
		panelBajaYModificacion.add(lblNombreDelDepartamento_2);

		lblEspecialidad_2 = new JLabel("ESPECIALIDAD");
		lblEspecialidad_2.setIcon(new ImageIcon(VentanaGestionDepartamentos.class.getResource("/imgs/especialidad.png")));
		lblEspecialidad_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblEspecialidad_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEspecialidad_2.setFont(new Font("Montserrat Medium", Font.PLAIN, 10));
		lblEspecialidad_2.setBounds(685, 109, 161, 28);
		panelBajaYModificacion.add(lblEspecialidad_2);

		txtCodigoDelDepartamento_1 = new JTextField();
		txtCodigoDelDepartamento_1.setForeground(Color.GRAY);
		txtCodigoDelDepartamento_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		txtCodigoDelDepartamento_1.setColumns(10);
		txtCodigoDelDepartamento_1.setBorder(null);
		txtCodigoDelDepartamento_1.setBounds(52, 173, 292, 28);
		panelAlta.add(txtCodigoDelDepartamento_1);

		txtNombreDelDepartamento_1 = new JTextField();
		txtNombreDelDepartamento_1.setForeground(Color.GRAY);
		txtNombreDelDepartamento_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		txtNombreDelDepartamento_1.setColumns(10);
		txtNombreDelDepartamento_1.setBorder(null);
		txtNombreDelDepartamento_1.setBounds(53, 300, 291, 28);
		panelAlta.add(txtNombreDelDepartamento_1);

		txtEspecialidad_1 = new JTextField();
		txtEspecialidad_1.setForeground(Color.GRAY);
		txtEspecialidad_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		txtEspecialidad_1.setColumns(10);
		txtEspecialidad_1.setBorder(null);
		txtEspecialidad_1.setBounds(444, 151, 278, 28);
		panelAlta.add(txtEspecialidad_1);

		txtBarrarDeBusqueda_1 = new JTextField();
		txtBarrarDeBusqueda_1.setBounds(20, 113, 281, 34);
		panelBajaYModificacion.add(txtBarrarDeBusqueda_1);
		txtBarrarDeBusqueda_1.setColumns(10);

		textFieldCdigoDelDepartamento_2 = new JTextField();
		textFieldCdigoDelDepartamento_2.setForeground(Color.GRAY);
		textFieldCdigoDelDepartamento_2.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		textFieldCdigoDelDepartamento_2.setEditable(false);
		textFieldCdigoDelDepartamento_2.setColumns(10);
		textFieldCdigoDelDepartamento_2.setBorder(null);
		textFieldCdigoDelDepartamento_2.setBounds(434, 160, 212, 20);
		panelBajaYModificacion.add(textFieldCdigoDelDepartamento_2);

		textFieldNombreDelDepartamento_2 = new JTextField();
		textFieldNombreDelDepartamento_2.setEditable(false);
		textFieldNombreDelDepartamento_2.setForeground(Color.GRAY);
		textFieldNombreDelDepartamento_2.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		textFieldNombreDelDepartamento_2.setColumns(10);
		textFieldNombreDelDepartamento_2.setBorder(null);
		textFieldNombreDelDepartamento_2.setBounds(435, 292, 211, 20);
		panelBajaYModificacion.add(textFieldNombreDelDepartamento_2);

		btnAlta = new JButton("Alta");
		btnAlta.setIcon(new ImageIcon(VentanaGestionDepartamentos.class.getResource("/imgs/alta.png")));
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

		btnBaja = new JButton("Baja y Modificacion");
		btnBaja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBaja.setIcon(new ImageIcon(VentanaGestionDepartamentos.class.getResource("/imgs/modificacion.png")));
		btnBaja.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnBaja.setHorizontalAlignment(SwingConstants.LEFT);
		btnBaja.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 15));
		btnBaja.setFocusPainted(false);
		btnBaja.setBorder(null);
		btnBaja.setBackground(Color.WHITE);
		btnBaja.setBounds(20, 161, 187, 47);
		menuHospitalContainer.add(btnBaja);
		btnBajaMouseListener();
		btnModificarMouseListener();

		btnAgregarEspecialidad = new JButton("Agregar especialidad");
		btnAgregarEspecialidad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarEspecialidad.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAgregarEspecialidad.setForeground(Color.WHITE);
		btnAgregarEspecialidad.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnAgregarEspecialidad.setFocusPainted(false);
		btnAgregarEspecialidad.setBorder(null);
		btnAgregarEspecialidad.setBackground(new Color(0, 118, 255));
		btnAgregarEspecialidad.setBounds(441, 222, 172, 36);
		panelAlta.add(btnAgregarEspecialidad);
		btnAgregarEspecialidadMouseListener();

		btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDarDeAlta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDarDeAlta.setForeground(Color.WHITE);
		btnDarDeAlta.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnDarDeAlta.setFocusPainted(false);
		btnDarDeAlta.setBorder(null);
		btnDarDeAlta.setBackground(new Color(0, 118, 255));
		btnDarDeAlta.setBounds(675, 509, 172, 36);
		panelAlta.add(btnDarDeAlta);
		btnDarDeAltaMouseListener();
		
		btnModificar = new JButton("Modificar");
		btnModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnModificar.setFocusPainted(false);
		btnModificar.setBorder(null);
		btnModificar.setBackground(new Color(0, 118, 255));
		btnModificar.setBounds(492, 509, 172, 36);
		panelBajaYModificacion.add(btnModificar);
		btnModificar.addActionListener(this);
		btnModificarMouseListener();

		btnDarDeBaja = new JButton("Dar de baja");
		btnDarDeBaja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDarDeBaja.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDarDeBaja.setForeground(Color.WHITE);
		btnDarDeBaja.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnDarDeBaja.setFocusPainted(false);
		btnDarDeBaja.setBorder(null);
		btnDarDeBaja.setBackground(new Color(0, 118, 255));
		btnDarDeBaja.setBounds(675, 509, 172, 36);
		panelBajaYModificacion.add(btnDarDeBaja);
		btnDarDeBajaListener();

		btnBusqueda_1 = new JButton("");
		btnBusqueda_1.setFocusPainted(false);
		btnBusqueda_1.setForeground(new Color(0, 0, 0));
		btnBusqueda_1.setBackground(new Color(0, 118, 255));
		btnBusqueda_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBusqueda_1.setIcon(new ImageIcon(VentanaGestionDepartamentos.class.getResource("/imgs/lupa.png")));
		btnBusqueda_1.setBorder(null);
		btnBusqueda_1.setBounds(300, 113, 67, 34);
		panelBajaYModificacion.add(btnBusqueda_1);
		
		btnVolverAlMenu = new JButton("Menu Principal");
		btnVolverAlMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolverAlMenu.setIcon(new ImageIcon(VentanaGestionDepartamentos.class.getResource("/imgs/menu.png")));
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
		btnCerrarSesion.setIcon(new ImageIcon(VentanaGestionDepartamentos.class.getResource("/imgs/logoutAzul2.png")));
		btnCerrarSesion.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCerrarSesion.setForeground(new Color(0, 118, 255));
		btnCerrarSesion.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 16));
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setBackground(Color.WHITE);
		btnCerrarSesion.setBounds(32, 532, 148, 33);
		menuHospitalContainer.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(this);
		btnCerrarSesionMouseListener();

		chckbxActivo_1 = new JCheckBox(" Activo");
		chckbxActivo_1.setFocusPainted(false);
		chckbxActivo_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		chckbxActivo_1.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxActivo_1.setBackground(new Color(255, 255, 255));
		chckbxActivo_1.setBorder(null);
		chckbxActivo_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 17));
		chckbxActivo_1.setBounds(52, 406, 97, 23);
		panelAlta.add(chckbxActivo_1);

		chckbxActivo_2 = new JCheckBox(" Activo");
		chckbxActivo_2.setFocusPainted(false);
		chckbxActivo_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		chckbxActivo_2.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxActivo_2.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		chckbxActivo_2.setBorder(null);
		chckbxActivo_2.setBackground(Color.WHITE);
		chckbxActivo_2.setBounds(434, 380, 67, 23);
		panelBajaYModificacion.add(chckbxActivo_2);

		comboBoxEspecialidades_1 = new JComboBox();
		comboBoxEspecialidades_1.setEnabled(false);
		comboBoxEspecialidades_1.setForeground(new Color(0, 0, 0));
		comboBoxEspecialidades_1.setBackground(new Color(255, 255, 255));
		comboBoxEspecialidades_1.setBorder(null);
		comboBoxEspecialidades_1.setBounds(685, 160, 161, 20);
		panelBajaYModificacion.add(comboBoxEspecialidades_1);

		separatorCodigoDelDepartamento_1 = new JSeparator();
		separatorCodigoDelDepartamento_1.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1.setBounds(51, 201, 293, 2);
		panelAlta.add(separatorCodigoDelDepartamento_1);

		separatorNombreDelDepartamento_1 = new JSeparator();
		separatorNombreDelDepartamento_1.setForeground(Color.BLACK);
		separatorNombreDelDepartamento_1.setBounds(52, 328, 292, 2);
		panelAlta.add(separatorNombreDelDepartamento_1);

		separatorEspecialidad = new JSeparator();
		separatorEspecialidad.setForeground(Color.BLACK);
		separatorEspecialidad.setBounds(443, 179, 279, 2);
		panelAlta.add(separatorEspecialidad);

		separatorCodigoDelDepartamento_2 = new JSeparator();
		separatorCodigoDelDepartamento_2.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_2.setBounds(434, 181, 212, 2);
		panelBajaYModificacion.add(separatorCodigoDelDepartamento_2);

		separatorNombreDelDepartamento_2 = new JSeparator();
		separatorNombreDelDepartamento_2.setForeground(Color.BLACK);
		separatorNombreDelDepartamento_2.setBounds(434, 313, 212, 2);
		panelBajaYModificacion.add(separatorNombreDelDepartamento_2);

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(211, 211, 211));
		separator.setBounds(386, 39, 2, 475);
		panelBajaYModificacion.add(separator);
	}

	private void btnBajaMouseListener() {

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
				btnBaja.setBackground(new Color(255, 255, 255));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnBaja.setBackground(new Color(245, 245, 245));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelBajaYModificacion.setVisible(true);
				panelAlta.setVisible(false);
			}
		};

		btnBaja.addMouseListener(ml);

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
				btnModificar.setBackground(new Color(0, 118, 255));
				btnModificar.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificar.setBackground(new Color(0, 80, 255));
				btnModificar.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		};
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
				btnDarDeBaja.setBackground(new Color(0, 118, 255));
				btnDarDeBaja.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnDarDeBaja.setBackground(new Color(0, 80, 255));
				btnDarDeBaja.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};

		btnDarDeBaja.addMouseListener(ml);
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
				btnDarDeAlta.setBackground(new Color(0, 118, 255));
				btnDarDeAlta.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnDarDeAlta.setBackground(new Color(0, 80, 255));
				btnDarDeAlta.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		};

		btnDarDeAlta.addMouseListener(ml);

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
				btnAgregarEspecialidad.setBackground(new Color(0, 118, 255));
				btnAgregarEspecialidad.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAgregarEspecialidad.setBackground(new Color(0, 80, 255));
				btnAgregarEspecialidad.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};

		btnAgregarEspecialidad.addMouseListener(ml);

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
		if (e.getSource().equals(btnModificar)) {
			VentanaGestionDepartamentoModificacion VentanaGestionDepartamentoModificacion = new VentanaGestionDepartamentoModificacion(true);
			VentanaGestionDepartamentoModificacion.setVisible(true);
		}
		if(e.getSource().equals(btnVolverAlMenu)) {
			this.dispose();
			VentanaAdminGestionDepartamentoYEmpleado VentanaAdminGestionDepartamentoYEmpleado = new VentanaAdminGestionDepartamentoYEmpleado(empleadoControlable);
			VentanaAdminGestionDepartamentoYEmpleado.setVisible(true);
			
		}if(e.getSource().equals(btnCerrarSesion)) {
			int confirmado = JOptionPane.showConfirmDialog(this,"¿Estas seguro de cerrar sesión?", "Cerrar Sesión", JOptionPane.INFORMATION_MESSAGE);
				if (JOptionPane.OK_OPTION == confirmado) {
					VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(empleadoControlable, null);
					ventanaPrincipal.setVisible(true);
					this.dispose();
				}else
					System.out.println("");	
		}
		
	}
	
	
}
