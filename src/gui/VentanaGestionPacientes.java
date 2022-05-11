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

import interfaces.EmpleadosPacienteControlable;
import panel.AltasPacientePanel;
import panel.ListadoBajasPacientePanel;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Cursor;
	/**
	 * Esta clase es la clase principal si se logea un doctor y gestiona sus pacientes
	 * @author Emil
	 * 
	 */
public class VentanaGestionPacientes extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private EmpleadosPacienteControlable pacientesInterface;
	private VentanaPrincipal login;
	
	AltasPacientePanel altasPacientePanel;
	ListadoBajasPacientePanel listadoBajasPacientePanel;

	private JPanel background;
	private JPanel menuHospitalContainer;

	private JLabel lblHeaderApp;
	private JLabel lblNombreHospital;
	private JLabel lblHospitalIcono;
	private JLabel lblAlta;

	private JButton btnAlta;
	private JButton btnDarDeAlta;
	private JButton btnDarDeBaja;
	private JButton btnModificacion;
	private JButton btnCerrarApp;
	private JButton btnCerrarSesion;
	private int xPositionMouse, yPositionMouse;
	private JLabel lblListadoModificacion;

	public VentanaGestionPacientes(EmpleadosPacienteControlable pacientesInterface) {
		/*
		 * Llama controlador desde la ventana
		 */
		this.pacientesInterface = pacientesInterface;
		
		
		//diseño de la ventana
		
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

		listadoBajasPacientePanel = new ListadoBajasPacientePanel(pacientesInterface);
		listadoBajasPacientePanel.setBounds(223, 32, 877, 568);
		listadoBajasPacientePanel.setVisible(false);
		
		/*
		 * Panel de alta
		 */
		
		altasPacientePanel = new AltasPacientePanel(pacientesInterface);
		altasPacientePanel.setBounds(223, 32, 877, 568);
		background.add(altasPacientePanel);

		btnCerrarApp = new JButton("x");
		btnCerrarApp.setBounds(1032, 0, 68, 31);
		btnCerrarApp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrarApp.setForeground(Color.WHITE);
		btnCerrarApp.setFont(new Font("Montserrat Medium", Font.BOLD, 25));
		btnCerrarApp.setFocusPainted(false);
		btnCerrarApp.setBorder(null);
		btnCerrarApp.setBackground(new Color(0, 118, 255));
		background.add(btnCerrarApp);
		
		lblAlta = new JLabel("Alta");
		lblAlta.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAlta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlta.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		lblAlta.setBounds(0, 0, 141, 50);
		altasPacientePanel.add(lblAlta);
		background.add(listadoBajasPacientePanel);
		
		
		lblListadoModificacion = new JLabel("Listado y Modificacion");
		lblListadoModificacion.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListadoModificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoModificacion.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		lblListadoModificacion.setBounds(0, 0, 243, 50);
		listadoBajasPacientePanel.add(lblListadoModificacion);
		
		menuHospitalContainer = new JPanel();
		menuHospitalContainer.setBounds(0, 0, 223, 600);
		menuHospitalContainer.setLayout(null);
		menuHospitalContainer.setBackground(Color.WHITE);
		background.add(menuHospitalContainer);

		lblNombreHospital = new JLabel("Hospital Privado");
		lblNombreHospital.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNombreHospital.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreHospital.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 19));
		lblNombreHospital.setBounds(47, 38, 168, 23);
		menuHospitalContainer.add(lblNombreHospital);

		lblHospitalIcono = new JLabel("");
		lblHospitalIcono.setIcon(new ImageIcon(VentanaGestionPacientes.class.getResource("/imgs/cruzRoja-32x32.png")));
		lblHospitalIcono.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHospitalIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospitalIcono.setBounds(0, 28, 50, 43);
		menuHospitalContainer.add(lblHospitalIcono);

		btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlta.setIcon(new ImageIcon(VentanaGestionPacientes.class.getResource("/imgs/alta.png")));
		btnAlta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlta.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAlta.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlta.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 15));
		btnAlta.setFocusPainted(false);
		btnAlta.setBorder(null);
		btnAlta.setBackground(Color.WHITE);
		btnAlta.setBounds(20, 103, 177, 47);
		menuHospitalContainer.add(btnAlta);

		btnModificacion = new JButton("Modificaci\u00F3n");
		btnModificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificacion.setIcon(new ImageIcon(VentanaGestionPacientes.class.getResource("/imgs/modificacion.png")));
		btnModificacion.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnModificacion.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificacion.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 15));
		btnModificacion.setFocusPainted(false);
		btnModificacion.setBorder(null);
		btnModificacion.setBackground(Color.WHITE);
		btnModificacion.setBounds(20, 161, 177, 43);
		menuHospitalContainer.add(btnModificacion);

		btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrarSesion.setIcon(new ImageIcon(VentanaGestionPacientes.class.getResource("/imgs/logoutAzul2.png")));
		btnCerrarSesion.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCerrarSesion.setForeground(new Color(0, 118, 255));
		btnCerrarSesion.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 16));
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setBackground(Color.WHITE);
		btnCerrarSesion.setBounds(32, 532, 148, 33);
		menuHospitalContainer.add(btnCerrarSesion);

		lblHeaderApp = new JLabel("");
		lblHeaderApp.setBounds(0, 0, 1100, 31);
		background.add(lblHeaderApp);
		btnCerrarAppMouseListener();
		lblHeaderAppMouseListener();
		lblHeaderAppMouseMotionListener();
		btnAltaMouseListener();
		btnModificacionMouseListener();
		btnCerrarSesionMouseListener();
	}

	/*
	 * Metodo para mostrar el listado a partir del boton de modificacion
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
				btnModificacion.setBackground(new Color(255, 255, 255));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnModificacion.setBackground(new Color(245, 245, 245));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setBounds(500, 200, 1100, 600);
				background.setBounds(0, 0, 1100, 600);
				listadoBajasPacientePanel.setVisible(true);
				altasPacientePanel.setVisible(false);
			}
		};
		
		btnModificacion.addMouseListener(ml);

	}
	

	/*
	 * Metodo para mostrar el alta a partir del boton de alta
	 */

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
				setBounds(500, 200, 1100, 600);
				background.setBounds(0, 0, 1100, 600);
				altasPacientePanel.setVisible(true);
				listadoBajasPacientePanel.setVisible(false);

			}
		};

		btnAlta.addMouseListener(ml);

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

	/*
	 * Boton de cierre de la aplicacion
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
	
	/*
	 * Boton para volver a la ventana de login
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
				login = new VentanaPrincipal(null);
				login.setVisible(true);
				dispose();
				
			}
		};

		btnCerrarSesion.addMouseListener(nl);

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		

	}

}
