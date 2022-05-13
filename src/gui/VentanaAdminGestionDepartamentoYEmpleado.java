package gui;

import java.awt.Color;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import interfaces.DepartamentoControlable;
import interfaces.EmpleadoControlable;
import interfaces.EmpleadoControlableBDImplementation;
import interfaces.EmpleadosPacienteControlable;
import clases.Contrato;
import clases.Empleado;
import interfaces.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Cursor;

public class VentanaAdminGestionDepartamentoYEmpleado extends JDialog implements ActionListener {

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
	private JLabel lblNombreHospital;
	private JLabel lblHospitalIcono;
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
	private JButton btnCerrarApp;

	private int xPositionMouse, yPositionMouse;
	
	private DepartamentoControlable departamentoControlable;
	private EmpleadoControlable empleadoControlable;
	private EmpleadosPacienteControlable pacientesInterface;

	public VentanaAdminGestionDepartamentoYEmpleado(EmpleadoControlable empleadoControlable, DepartamentoControlable departamentoControlable) {
		this.empleadoControlable = empleadoControlable;
    this.departamentoControlable = departamentoControlable;
		setUndecorated(true);
		setLocationByPlatform(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imgs/cruzRoja.png")));
		setBounds(400, 200, 1100, 600);
		getContentPane().setLayout(null);

		background = new JPanel();
		background.setBackground(new Color(245, 245, 245));
		background.setBounds(0, 0, 1100, 600);
		getContentPane().add(background);
		background.setLayout(null);

		menuHospitalContainer = new JPanel();
		menuHospitalContainer.setBounds(0, 0, 234, 600);
		menuHospitalContainer.setBackground(new Color(255, 255, 255));
		background.add(menuHospitalContainer);
		menuHospitalContainer.setLayout(null);

		panelGestiones = new JPanel();
		panelGestiones.setVisible(false);
		panelGestiones.setBackground(new Color(245, 245, 245));
		panelGestiones.setLayout(null);
		panelGestiones.setBounds(234, 32, 866, 568);
		background.add(panelGestiones);

		panelInicio = new JPanel();
		panelInicio.setVisible(true);
		panelInicio.setBackground(new Color(245, 245, 245));
		panelInicio.setBounds(234, 32, 866, 568);
		background.add(panelInicio);
		panelInicio.setLayout(null);

		panelAdministrador = new JPanel();
		panelAdministrador.setBackground(new Color(0, 118, 255));
		panelAdministrador.setBounds(39, 73, 792, 188);
		panelInicio.add(panelAdministrador);
		panelAdministrador.setLayout(null);

		panelPermisosAdministrador = new JPanel();
		panelPermisosAdministrador.setBackground(new Color(255, 255, 255));
		panelPermisosAdministrador.setBounds(140, 291, 584, 246);
		panelInicio.add(panelPermisosAdministrador);
		panelPermisosAdministrador.setLayout(null);

		departamentosContainer = new JPanel();
		departamentosContainer.setBackground(new Color(255, 255, 255));
		departamentosContainer.setBounds(39, 163, 792, 173);
		panelGestiones.add(departamentosContainer);
		departamentosContainer.setLayout(null);

		gestionesContainer = new JPanel();
		gestionesContainer.setBackground(new Color(255, 255, 255));
		gestionesContainer.setBounds(39, 351, 792, 173);
		panelGestiones.add(gestionesContainer);
		gestionesContainer.setLayout(null);

		departamentosYGestionesContainer = new JPanel();
		departamentosYGestionesContainer.setBackground(new Color(245, 245, 245));
		departamentosYGestionesContainer.setBounds(10, 61, 846, 496);
		panelGestiones.add(departamentosYGestionesContainer);
		departamentosYGestionesContainer.setLayout(null);

		btnCerrarApp = new JButton("x");
		btnCerrarApp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrarApp.setForeground(Color.WHITE);
		btnCerrarApp.setFont(new Font("Montserrat Medium", Font.BOLD, 25));
		btnCerrarApp.setFocusPainted(false);
		btnCerrarApp.setBorder(null);
		btnCerrarApp.setBackground(new Color(0, 118, 255));
		btnCerrarApp.setBounds(1032, 0, 68, 31);
		background.add(btnCerrarApp);
		btnCerrarApp.addActionListener(this);
		btnCerrarAppMouseListener();

		lblHeaderApp = new JLabel("");
		lblHeaderApp.setBounds(0, 0, 1100, 31);
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

		lblNombreHospital = new JLabel("Hospital Privado");
		lblNombreHospital.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 21));
		lblNombreHospital.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNombreHospital.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreHospital.setBounds(47, 38, 187, 23);
		menuHospitalContainer.add(lblNombreHospital);

		lblHospitalIcono = new JLabel("");
		lblHospitalIcono.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHospitalIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospitalIcono.setIcon(new ImageIcon(VentanaAdminGestionDepartamentoYEmpleado.class.getResource("/imgs/cruzRoja-32x32.png")));
		lblHospitalIcono.setBounds(0, 28, 50, 43);
		menuHospitalContainer.add(lblHospitalIcono);

		lblGestionesDisponibles = new JLabel(" Gestiones Disponibles");
		lblGestionesDisponibles.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGestionesDisponibles.setBounds(0, 0, 297, 67);
		departamentosYGestionesContainer.add(lblGestionesDisponibles);
		lblGestionesDisponibles.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblGestionesDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionesDisponibles.setIcon(new ImageIcon(VentanaAdminGestionDepartamentoYEmpleado.class.getResource("/imgs/disponible.png")));
		lblGestionesDisponibles.setFont(new Font("Montserrat Medium", Font.PLAIN, 17));

		lblDepartamentos = new JLabel("Departamentos");
		lblDepartamentos.setIcon(new ImageIcon(VentanaAdminGestionDepartamentoYEmpleado.class.getResource("/imgs/departamentos.png")));
		lblDepartamentos.setBounds(10, 11, 164, 37);
		departamentosContainer.add(lblDepartamentos);
		lblDepartamentos.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));

		lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setIcon(new ImageIcon(VentanaAdminGestionDepartamentoYEmpleado.class.getResource("/imgs/empleados.png")));
		lblEmpleados.setBounds(10, 11, 135, 32);
		gestionesContainer.add(lblEmpleados);
		lblEmpleados.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));

		lblPermisos_1 = new JLabel("Permisos");
		lblPermisos_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPermisos_1.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 18));
		lblPermisos_1.setBounds(0, 0, 150, 74);
		panelPermisosAdministrador.add(lblPermisos_1);

		lblPermisos_2 = new JLabel("\u25A0  Gestion completa de los departamentos");
		lblPermisos_2.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblPermisos_2.setBounds(131, 101, 350, 19);
		panelPermisosAdministrador.add(lblPermisos_2);

		lblPermisos_3 = new JLabel("\u25A0 Gestion completa de los empleados");
		lblPermisos_3.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblPermisos_3.setBounds(131, 165, 350, 19);
		panelPermisosAdministrador.add(lblPermisos_3);

		lblTextoAdmin_1 = new JLabel(" Hola, Administrador");
		lblTextoAdmin_1.setForeground(new Color(255, 255, 255));
		lblTextoAdmin_1.setBounds(25, 11, 439, 79);
		panelAdministrador.add(lblTextoAdmin_1);
		lblTextoAdmin_1.setIcon(new ImageIcon(VentanaAdminGestionDepartamentoYEmpleado.class.getResource("/imgs/icons8-username-90.png")));
		lblTextoAdmin_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblTextoAdmin_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextoAdmin_1.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 30));

		lblTextoAdmin_2 = new JLabel("Justo debajo, te encontraras informaci\u00F3n relacionada");
		lblTextoAdmin_2.setForeground(new Color(255, 255, 255));
		lblTextoAdmin_2.setBounds(115, 101, 416, 31);
		panelAdministrador.add(lblTextoAdmin_2);
		lblTextoAdmin_2.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblTextoAdmin_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTextoAdmin_2.setHorizontalAlignment(SwingConstants.CENTER);

		lblTextoAdmin_3 = new JLabel("con lo que puedes hacer como administrador");
		lblTextoAdmin_3.setForeground(new Color(255, 255, 255));
		lblTextoAdmin_3.setBounds(115, 130, 416, 31);
		panelAdministrador.add(lblTextoAdmin_3);
		lblTextoAdmin_3.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(VentanaAdminGestionDepartamentoYEmpleado.class.getResource("/imgs/flechaabajo.png")));
		lblNewLabel.setBounds(626, 54, 104, 100);
		panelAdministrador.add(lblNewLabel);

		btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setIcon(new ImageIcon(VentanaAdminGestionDepartamentoYEmpleado.class.getResource("/imgs/logoutAzul2.png")));
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setBackground(new Color(255, 255, 255));
		btnCerrarSesion.setForeground(new Color(0, 118, 255));
		btnCerrarSesion.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCerrarSesion.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 16));
		btnCerrarSesion.setBounds(32, 532, 148, 33);
		menuHospitalContainer.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(this);
		btnCerrarSesionMouseListener();

		btnInicio = new JButton("   Inicio");
		btnInicio.setIcon(new ImageIcon(VentanaAdminGestionDepartamentoYEmpleado.class.getResource("/imgs/inicio.png")));
		btnInicio.setHorizontalAlignment(SwingConstants.LEFT);
		btnInicio.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnInicio.setFocusPainted(false);
		btnInicio.setBackground(new Color(255, 255, 255));
		btnInicio.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 15));
		btnInicio.setBorder(null);
		btnInicio.setBounds(20, 107, 177, 43);
		menuHospitalContainer.add(btnInicio);
		btnInicioMouseListener();

		btnGestiones = new JButton("   Gestiones");
		btnGestiones.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnGestiones.setFocusPainted(false);
		btnGestiones.setIcon(
				new ImageIcon(VentanaAdminGestionDepartamentoYEmpleado.class.getResource("/imgs/gestiones.png")));
		btnGestiones.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestiones.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 15));
		btnGestiones.setBorder(null);
		btnGestiones.setBackground(new Color(255, 255, 255));
		btnGestiones.setBounds(20, 161, 177, 47);
		menuHospitalContainer.add(btnGestiones);
		btnGestionesMouseListener();

		btnEmpleados = new JButton("EMPLEADOS");
		btnEmpleados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEmpleados.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEmpleados.setFocusPainted(false);
		btnEmpleados.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnEmpleados.setForeground(new Color(255, 255, 255));
		btnEmpleados.setBounds(280, 86, 252, 59);
		gestionesContainer.add(btnEmpleados);
		btnEmpleados.setBackground(new Color(0, 118, 255));
		btnEmpleados.setBorder(null);
		btnEmpleadosMouseListener();
		btnEmpleados.addActionListener(this);

		btnDepartamentos = new JButton("DEPARTAMENTOS");
		btnDepartamentos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDepartamentos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDepartamentos.setFocusPainted(false);
		btnDepartamentos.setBounds(280, 79, 252, 59);
		departamentosContainer.add(btnDepartamentos);
		btnDepartamentos.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnDepartamentos.setBackground(new Color(0, 118, 255));
		btnDepartamentos.setForeground(new Color(255, 255, 255));
		btnDepartamentos.setBorder(null);
		btnDepartamentos.addActionListener(this);
		btnDepartamentosMouseListener();
	}
	
	private void btnDepartamentosMouseListener() {

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
				btnDepartamentos.setBackground(new Color(0, 118, 255));
				btnDepartamentos.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnDepartamentos.setBackground(new Color(0, 80, 255));
				btnDepartamentos.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		};

		btnDepartamentos.addMouseListener(ml);

	}
	
	private void btnEmpleadosMouseListener() {

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
				btnEmpleados.setBackground(new Color(0, 118, 255));
				btnEmpleados.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnEmpleados.setBackground(new Color(0, 80, 255));
				btnEmpleados.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		};

		btnEmpleados.addMouseListener(ml);

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

	private void btnInicioMouseListener() {

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
				btnInicio.setBackground(new Color(255, 255, 255));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnInicio.setBackground(new Color(245, 245, 245));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelGestiones.setVisible(false);
				panelInicio.setVisible(true);
			}
		};

		btnInicio.addMouseListener(ml);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnDepartamentos)) {
			VentanaGestionDepartamentos VentanaGestionDepartamentos = new VentanaGestionDepartamentos(empleadoControlable, departamentoControlable);
			VentanaGestionDepartamentos.setVisible(true);
			this.dispose();
		}if (e.getSource().equals(btnEmpleados)) {
			VentanaGestionEmpleados vGestionEmples = new VentanaGestionEmpleados(empleadoControlable, pacientesInterface , departamentoControlable);
			vGestionEmples.setVisible(true);
			this.dispose();
		}if(e.getSource().equals(btnCerrarSesion)) {
			int confirmado = JOptionPane.showConfirmDialog(this,"¿Estas seguro de cerrar sesión?", "Cerrar Sesión", JOptionPane.INFORMATION_MESSAGE);
			if (JOptionPane.OK_OPTION == confirmado) {
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(empleadoControlable, pacientesInterface, departamentoControlable);
				ventanaPrincipal.setVisible(true);
				this.dispose();
			}else
				System.out.println("");	
		}if(e.getSource().equals(btnCerrarApp)) {
			int confirmado = JOptionPane.showConfirmDialog(this,"�Estas seguro de cerrar la aplicacion? Si es asi, se cerrara sesi�n al cerrarla", "Cerrar App", JOptionPane.INFORMATION_MESSAGE);
			if (JOptionPane.OK_OPTION == confirmado) {
				System.exit(0);
			}else
				System.out.println("");	
		}
	}
}
