package gui;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import clases.Empleado;
import exceptions.CreateSqlException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import interfaces.DepartamentoControlable;
import interfaces.EmpleadoControlable;
import interfaces.EmpleadosPacienteControlable;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author Julen
 *Esta es la primera ventana que se va a desplegar al iniciar la aplicación, la cual pedira ciertos datos para logear una cuenta.
 */

public class VentanaPrincipal extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JPanel background;
	private JPanel nombreHospitalContainer;

	private JButton btnCerrarApp;
	private JButton btnMinimizarApp;
	private JButton btnEntrar;

	private JLabel lblNombreHospital;
	private JLabel lblHospitalIcono;
	private JLabel lblIniciarSesion;
	private JLabel lblIconoCodigoUsuario;
	private JLabel lblCodigoUsuario;
	private JLabel lblContrasena;
	private JLabel lblIconoContrasena;
	private JLabel lblSinCuenta_1;
	private JLabel lblSinCuenta_2;
	private JLabel lblHeaderApp;
	private JLabel lblDerechosReservados;
	private JLabel lblContrasenaVisibleONo;

	private JTextField txtCodigoUsuario;

	private JPasswordField pwdContrasena;

	private JSeparator separatorCodigoUsuario;
	private JSeparator separatorContrasena;

	private int xPositionMouse, yPositionMouse;
	
	private DepartamentoControlable departamentoControlable;
	private EmpleadoControlable empleadoControlable;
	private EmpleadosPacienteControlable pacientesInterface;

	public VentanaPrincipal(EmpleadoControlable empleadoControlable, EmpleadosPacienteControlable pacientesInterface, DepartamentoControlable departamentoControlable) {
		/**
		 * Controladores para pasar datos entre ventanas
		 */
		this.empleadoControlable = empleadoControlable;
		this.pacientesInterface = pacientesInterface;
		this.departamentoControlable = departamentoControlable;
		
		/**
		 * Diseño de la ventana
		 */
		
		setUndecorated(true);
		setLocationByPlatform(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imgs/cruzRoja.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 1100, 600);


		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		background = new JPanel();
		background.setBackground(new Color(255, 255, 255));
		background.setBounds(0, 0, 1100, 600);
		background.setLayout(null);
		contentPane.add(background);
		
		lblContrasenaVisibleONo = new JLabel("");
		lblContrasenaVisibleONo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imgs/contrasenaVisible.png")));
		lblContrasenaVisibleONo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblContrasenaVisibleONo.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasenaVisibleONo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblContrasenaVisibleONo.setBounds(360, 372, 46, 32);
		background.add(lblContrasenaVisibleONo);
		
		nombreHospitalContainer = new JPanel();
		nombreHospitalContainer.setBackground(new Color(0, 118, 255));
		nombreHospitalContainer.setBounds(770, 0, 330, 602);
		nombreHospitalContainer.setLayout(null);
		background.add(nombreHospitalContainer);
		
		btnCerrarApp = new JButton("x");
		btnCerrarApp.setFocusPainted(false);
		btnCerrarApp.setBounds(262, 0, 68, 31);
		btnCerrarApp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrarApp.setForeground(new Color(255, 255, 255));
		btnCerrarApp.setFont(new Font("Montserrat Medium", Font.BOLD, 25));
		btnCerrarApp.setBorder(null);
		btnCerrarApp.setBackground(new Color(0, 118, 255));
		nombreHospitalContainer.add(btnCerrarApp);
		

		btnMinimizarApp = new JButton("-");
		btnMinimizarApp.setFocusPainted(false);
		btnMinimizarApp.setBounds(196, 0, 68, 31);
		btnMinimizarApp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMinimizarApp.setForeground(new Color(255, 255, 255));
		btnMinimizarApp.setFont(new Font("Montserrat Medium", Font.PLAIN, 35));
		btnMinimizarApp.setBorder(null);
		btnMinimizarApp.setBackground(new Color(0, 118, 255));
		nombreHospitalContainer.add(btnMinimizarApp);
		

		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setFocusPainted(false);
		btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		btnEntrar.setBorder(null);
		btnEntrar.setBackground(new Color(0, 118, 255));
		btnEntrar.setBounds(88, 465, 131, 41);
		background.add(btnEntrar);

		lblNombreHospital = new JLabel("Hospital privado");
		lblNombreHospital.setForeground(new Color(255, 255, 255));
		lblNombreHospital.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNombreHospital.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreHospital.setFont(new Font("Montserrat SemiBold", Font.BOLD, 23));
		lblNombreHospital.setBounds(0, 299, 327, 23);
		nombreHospitalContainer.add(lblNombreHospital);

		lblHospitalIcono = new JLabel("");
		lblHospitalIcono.setBounds(48, 29, 112, 90);
		lblHospitalIcono.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHospitalIcono.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospitalIcono.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imgs/cruzRoja-50x50.png")));
		background.add(lblHospitalIcono);

		lblIniciarSesion = new JLabel("INICIAR SESI\u00D3N");
		lblIniciarSesion.setFont(new Font("Montserrat SemiBold", Font.BOLD, 23));
		lblIniciarSesion.setBounds(144, 65, 200, 21);
		background.add(lblIniciarSesion);

		lblIconoCodigoUsuario = new JLabel("");
		lblIconoCodigoUsuario.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imgs/codigoDeUsuario.png")));
		lblIconoCodigoUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIconoCodigoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoCodigoUsuario.setBounds(390, 216, 62, 48);
		background.add(lblIconoCodigoUsuario);

		lblCodigoUsuario = new JLabel("C\u00D3DIGO DEL USUARIO");
		lblCodigoUsuario.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		lblCodigoUsuario.setBounds(88, 179, 194, 21);
		background.add(lblCodigoUsuario);
		
		lblContrasena = new JLabel("CONTRASE\u00D1A");
		lblContrasena.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		lblContrasena.setBounds(88, 327, 194, 21);
		background.add(lblContrasena);

		lblIconoContrasena = new JLabel("");
		lblIconoContrasena.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imgs/contrasenaUsuario.png")));
		lblIconoContrasena.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIconoContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoContrasena.setBounds(390, 372, 62, 32);
		background.add(lblIconoContrasena);

		lblSinCuenta_1 = new JLabel("No tienes cuenta?");
		lblSinCuenta_1.setFont(new Font("Montserrat Medium", Font.PLAIN, 13));
		lblSinCuenta_1.setBounds(286, 467, 194, 14);
		background.add(lblSinCuenta_1);

		lblSinCuenta_2 = new JLabel("Porfavor, contacte a un administrador");
		lblSinCuenta_2.setForeground(new Color(0, 118, 255));
		lblSinCuenta_2.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		lblSinCuenta_2.setBounds(286, 492, 233, 14);
		background.add(lblSinCuenta_2);

		lblHeaderApp = new JLabel("");
		lblHeaderApp.setBounds(0, 0, 1100, 31);
		background.add(lblHeaderApp);
		

		lblDerechosReservados = new JLabel("@2022 All Rights Reserved");
		lblDerechosReservados.setForeground(new Color(128, 128, 128));
		lblDerechosReservados.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		lblDerechosReservados.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDerechosReservados.setHorizontalAlignment(SwingConstants.CENTER);
		lblDerechosReservados.setBounds(611, 568, 159, 32);
		background.add(lblDerechosReservados);

		txtCodigoUsuario = new JTextField();
		txtCodigoUsuario.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		txtCodigoUsuario.setForeground(new Color(128, 128, 128));
		txtCodigoUsuario.setText("Introduzca el codigo del usuario");
		txtCodigoUsuario.setBorder(null);
		txtCodigoUsuario.setBounds(89, 228, 317, 28);
		background.add(txtCodigoUsuario);
		txtCodigoUsuario.setColumns(10);
		

		pwdContrasena = new JPasswordField();
		pwdContrasena.setFont(new Font("Montserrat Medium", Font.PLAIN, 32));
		pwdContrasena.setForeground(new Color(128, 128, 128));
		pwdContrasena.setText("000000000000");
		pwdContrasena.setBorder(null);
		pwdContrasena.setBounds(88, 376, 276, 28);
		background.add(pwdContrasena);
	

		separatorCodigoUsuario = new JSeparator();
		separatorCodigoUsuario.setForeground(new Color(0, 0, 0));
		separatorCodigoUsuario.setBounds(88, 256, 345, 2);
		background.add(separatorCodigoUsuario);

		separatorContrasena = new JSeparator();
		separatorContrasena.setForeground(Color.BLACK);
		separatorContrasena.setBounds(88, 404, 345, 2);
		background.add(separatorContrasena);
		
		/**
		 * LLamada de los botones para realizar eventos.
		 */
		
		lblContrasenaVisibleONoMouseLister();
		btnCerrarAppMouseListener();
		btnMinimizarAppMouseListener();
		btnEntrarMouseListener();
		lblHeaderAppMouseListener();
		lblHeaderAppMouseMotionListener();
		txtCodigoUsuarioMouseListener();
		pwdContrasenaMouseListener();
		
		/**
		 * LLamada al evento para entrar en la aplicación.
		 */
		
		btnEntrar.addActionListener(this);

	}
	
	/**
	 * Metodos
	 */
	
	/**
	 * Metodo para verificar que los datos introducidos son correctos. (Existen en la BD)
	 * @param empleadoControlable
	 */
	
	private void loginUsuario(EmpleadoControlable empleadoControlable){
		String auxPwdContrasena = new String(pwdContrasena.getPassword());
		Empleado empleado = null;
		
		try {
			empleado = empleadoControlable.loginUsuario(txtCodigoUsuario.getText(), auxPwdContrasena);
		} catch (CreateSqlException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
		}
		if(!(txtCodigoUsuario.getText().equals("Introduzca el codigo del usuario") || auxPwdContrasena.equals("000000000000"))) {
			if(empleado != null) {
				if(empleado.getTipoEmpleado().equalsIgnoreCase("Administrador")) {
					VentanaAdminGestionDepartamentoYEmpleado ventanaAdminGestionDepartamentoYEmpleado = new VentanaAdminGestionDepartamentoYEmpleado(empleadoControlable, departamentoControlable);
					 ventanaAdminGestionDepartamentoYEmpleado.setVisible(true);
					 this.dispose();
				}else {
					VentanaGestionPacientes ventanaPacientes = new VentanaGestionPacientes(pacientesInterface, empleado, empleadoControlable , departamentoControlable);
					ventanaPacientes.setVisible(true);
					this.dispose();
				}
			}else {
				JOptionPane.showMessageDialog(this, "Codigo del usuario o clave incorrecto/s", "Dato/s incorrecto/s", JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(this, "Error, los campos del codigo del usuario o clave estan vacios", "Campo/s Vacio/s", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo para realizar el logeo de un usuario apartir de un ActionListener de un boton.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.getRootPane().setDefaultButton(btnEntrar);
		if (e.getSource().equals(btnEntrar)) {
			loginUsuario(empleadoControlable);
		}
	}
	
	/**
	 * Metodos MouseListener para realizar eventos al clicar, presionar, soltar etc...
	 */
	
	private void lblContrasenaVisibleONoMouseLister() {

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
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if(!(String.valueOf(pwdContrasena.getPassword()).isEmpty() || String.valueOf(pwdContrasena.getPassword()).equals("000000000000")) && pwdContrasena.getEchoChar() != ((char)0) ) {
					lblContrasenaVisibleONo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imgs/contrasenaNoVisisble.png")));
					pwdContrasena.setEchoChar((char)0);
					pwdContrasena.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
				}else if(!(String.valueOf(pwdContrasena.getPassword()).isEmpty() || String.valueOf(pwdContrasena.getPassword()).equals("000000000000")) && pwdContrasena.getEchoChar() == (char)0 ) {
					lblContrasenaVisibleONo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imgs/contrasenaVisible.png")));
					pwdContrasena.setEchoChar('•');
					pwdContrasena.setFont(new Font("Montserrat Medium", Font.PLAIN, 32));
				}

			}
		};

		lblContrasenaVisibleONo.addMouseListener(ml);

		
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

	private void btnEntrarMouseListener() {

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
				btnEntrar.setBackground(new Color(0, 118, 255));
				btnEntrar.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnEntrar.setBackground(new Color(0, 80, 255));
				btnEntrar.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		};

		btnEntrar.addMouseListener(ml);

	}

	private void pwdContrasenaMouseListener() {

		MouseListener ml = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(pwdContrasena.getPassword()).equals("000000000000")) {
					pwdContrasena.setText("");
					pwdContrasena.setForeground(Color.BLACK);
				}
				if (txtCodigoUsuario.getText().isEmpty()) {
					txtCodigoUsuario.setText("Introduzca el codigo del usuario");
					txtCodigoUsuario.setForeground(new Color(128, 128, 128));
				}
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

		pwdContrasena.addMouseListener(ml);

	}

	private void txtCodigoUsuarioMouseListener() {

		MouseListener ml = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (txtCodigoUsuario.getText().equals("Introduzca el codigo del usuario")) {
					txtCodigoUsuario.setText("");
					txtCodigoUsuario.setForeground(Color.BLACK);
				}
				if (String.valueOf(pwdContrasena.getPassword()).isEmpty()) {
					pwdContrasena.setText("000000000000");
					pwdContrasena.setForeground(new Color(128, 128, 128));
				}

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

		txtCodigoUsuario.addMouseListener(ml);

	}

	private void btnMinimizarAppMouseListener() {

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
				btnMinimizarApp.setBackground(new Color(0, 118, 255));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnMinimizarApp.setBackground(new Color(0, 110, 255));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(ICONIFIED);

			}
		};

		btnMinimizarApp.addMouseListener(ml);

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

}
