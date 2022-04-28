package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Alta extends JPanel {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDniEmple;
	private JTextField txtCodEmple;
	private JTextField txtNomEmple;
	private JTextField txtApellidosEmple;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JPanel background;
	private JPanel menuHospitalContainer;
	private JPanel panelGestiones;
	private JPanel panelInicio;
	private JPanel panelAdministrador;
	private JPanel panelPermisosAdministrador;
	private JPanel departamentosContainer;
	private JPanel gestionesContainer;
	private JPanel departamentosYGestionesContainer;

	private JLabel lblHeaderApp;
	private JLabel lblInicio;
	private JLabel lblGestiones;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblGestionesDisponibles;
	private JLabel lblDepartamentos;
	private JLabel lblEmpleados;
	private JLabel lblPermisos_1;
	private JLabel lblPermisos_2;
	private JLabel lblPermisos_3;
	private JLabel lblTextoAdmin_1;
	private JLabel lblTextoAdmin_2;
	private JLabel lblTextoAdmin_3;

	private JButton btnCerrarSesion;
	private JButton btnInicio;
	private JButton btnGestiones;
	private JButton btnEmpleados;
	private JButton btnDepartamentos;

	private int xPositionMouse, yPositionMouse;
	private JButton btnCerrarApp;

	public Alta() {
		/*
		setUndecorated(true);
		setLocationByPlatform(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CopiaVPrincipal.class.getResource("/imgs/cruzRoja.png")));
		setBounds(500, 200, 1000, 600);
		getContentPane().setLayout(null);*/

		background = new JPanel();
		background.setBackground(new Color(248, 250, 251));
		background.setBounds(0, 0, 1000, 600);
		//getContentPane().add(background);
		background.setLayout(null);

		
		setLayout(null);
		setBounds(100, 100, 750, 450);
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);

		JButton btnRegistrar = new JButton("Registrar\r\n");
		btnRegistrar.setBounds(885, 566, 89, 23);
		contentPanel.add(btnRegistrar);

		JComboBox comboBoxNomDepart = new JComboBox();
		comboBoxNomDepart.setBounds(419, 317, 174, 23);
		contentPanel.add(comboBoxNomDepart);

		JLabel lblNomDepart = new JLabel("Nombre del Departamento");
		lblNomDepart.setBounds(419, 272, 202, 34);
		lblNomDepart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblNomDepart);

		JLabel lblActivo = new JLabel("Activo");
		lblActivo.setBounds(419, 532, 58, 34);
		lblActivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblActivo);

		JCheckBox chckbxActivo = new JCheckBox("");
		chckbxActivo.setBounds(483, 540, 26, 23);
		chckbxActivo.setForeground(Color.WHITE);
		chckbxActivo.setBackground(Color.WHITE);
		contentPanel.add(chckbxActivo);

		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(603, 210, 110, 34);
		lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblEspecialidad);

		JLabel lblCodigoEmple = new JLabel("C\u00F3digo del empleado");
		lblCodigoEmple.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodigoEmple.setBounds(218, 278, 167, 22);
		contentPanel.add(lblCodigoEmple);

		txtDniEmple = new JTextField();
		txtDniEmple.setBounds(218, 390, 174, 22);
		txtDniEmple.setForeground(Color.WHITE);
		txtDniEmple.setEditable(false);
		txtDniEmple.setColumns(10);
		txtDniEmple.setBackground(Color.WHITE);
		contentPanel.add(txtDniEmple);

		txtCodEmple = new JTextField();
		txtCodEmple.setBounds(218, 317, 174, 22);
		txtCodEmple.setForeground(Color.WHITE);
		txtCodEmple.setEditable(false);
		txtCodEmple.setColumns(10);
		txtCodEmple.setBackground(Color.WHITE);
		contentPanel.add(txtCodEmple);

		JLabel lblDniEmple = new JLabel("DNI del empleado");
		lblDniEmple.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblDniEmple.setBounds(218, 357, 167, 22);
		contentPanel.add(lblDniEmple);

		JLabel lblNomEmple = new JLabel("Nombre del empleado");
		lblNomEmple.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomEmple.setBounds(218, 428, 167, 22);
		contentPanel.add(lblNomEmple);

		txtNomEmple = new JTextField();
		txtNomEmple.setForeground(Color.WHITE);
		txtNomEmple.setEditable(false);
		txtNomEmple.setColumns(10);
		txtNomEmple.setBackground(Color.WHITE);
		txtNomEmple.setBounds(218, 461, 174, 22);
		contentPanel.add(txtNomEmple);

		JLabel lblApellidosEmple = new JLabel("Nombre del empleado");
		lblApellidosEmple.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApellidosEmple.setBounds(218, 507, 167, 22);
		contentPanel.add(lblApellidosEmple);

		txtApellidosEmple = new JTextField();
		txtApellidosEmple.setForeground(Color.WHITE);
		txtApellidosEmple.setEditable(false);
		txtApellidosEmple.setColumns(10);
		txtApellidosEmple.setBackground(Color.WHITE);
		txtApellidosEmple.setBounds(218, 540, 174, 22);
		contentPanel.add(txtApellidosEmple);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(SystemColor.textHighlight);
		separator.setForeground(SystemColor.textHighlight);
		separator.setBounds(563, 76, 10, 329);
		contentPanel.add(separator);

		JLabel lblContrato = new JLabel("Contrato\r\n");
		lblContrato.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrato.setBounds(419, 351, 202, 34);
		contentPanel.add(lblContrato);

		JComboBox comboBoxContrato = new JComboBox();
		comboBoxContrato.setBounds(419, 390, 174, 23);
		contentPanel.add(comboBoxContrato);

		JButton btnCerrarApp = new JButton("x");
		btnCerrarApp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrarApp.setForeground(Color.WHITE);
		btnCerrarApp.setFont(new Font("Montserrat Medium", Font.BOLD, 25));
		btnCerrarApp.setFocusPainted(false);
		btnCerrarApp.setBorder(null);
		btnCerrarApp.setBackground(new Color(0, 118, 255));
		btnCerrarApp.setBounds(932, 0, 68, 31);
		background.add(btnCerrarApp);
		btnCerrarAppMouseListener();

		JLabel lblHeaderApp = new JLabel("");
		lblHeaderApp.setBounds(0, 0, 999, 31);
		background.add(lblHeaderApp);
		lblHeaderAppMouseListener();
		lblHeaderAppMouseMotionListener();

		lblInicio = new JLabel("Inicio");
		lblInicio.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicio.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		lblInicio.setBounds(0, 0, 141, 50);
		panelInicio.add(lblInicio);

		lblGestiones = new JLabel("Gestiones");
		lblGestiones.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGestiones.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestiones.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		lblGestiones.setBounds(0, 0, 141, 50);
		panelGestiones.add(lblGestiones);

		lblNewLabel = new JLabel("Hospital Privado");
		lblNewLabel.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 21));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(47, 38, 187, 23);
		menuHospitalContainer.add(lblNewLabel);

		JRadioButton rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonGroup.add(rdbtnDoctor);
		rdbtnDoctor.setBackground(Color.WHITE);
		rdbtnDoctor.setBounds(816, 156, 75, 23);
		contentPanel.add(rdbtnDoctor);

		JRadioButton rdbtnEnfermero = new JRadioButton("Enfermero\r\n");
		rdbtnEnfermero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonGroup.add(rdbtnEnfermero);
		rdbtnEnfermero.setBackground(Color.WHITE);
		rdbtnEnfermero.setBounds(695, 156, 93, 23);
		contentPanel.add(rdbtnEnfermero);

		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHorario.setBounds(603, 288, 110, 34);
		contentPanel.add(lblHorario);

		JComboBox comboBoxHorario = new JComboBox();
		comboBoxHorario.setBounds(603, 333, 174, 23);
		contentPanel.add(comboBoxHorario);

		JComboBox comboBoxEspecialidad = new JComboBox();
		comboBoxEspecialidad.setBounds(603, 254, 174, 23);
		contentPanel.add(comboBoxEspecialidad);

		JLabel lblTipoEmple = new JLabel("Tipo de empleado");
		lblTipoEmple.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoEmple.setBounds(603, 111, 139, 34);
		contentPanel.add(lblTipoEmple);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

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

	private void btnGestionesMouseListener() {

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
				btnGestiones.setBackground(new Color(255, 255, 255));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestiones.setBackground(new Color(245, 245, 245));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelInicio.setVisible(false);
				panelGestiones.setVisible(true);
			}
		};

		btnGestiones.addMouseListener(ml);
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

}