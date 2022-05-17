package gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Departamento;
import exceptions.CreateSqlException;
import interfaces.DepartamentoControlable;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ImageIcon;

/**
 * 
 * @author Julen
 *Esta es la ventana donde se modifican los datos de un departamento de la aplicación.
 */

public class VentanaGestionDepartamentoModificacion extends JDialog implements ActionListener{
	
	private JPanel background;
	
	private JButton btnModificar;
	private JButton btnCerrarApp;
	
	private JLabel lblHeaderApp;
	private JLabel lblModificacion;
	private JLabel lblCdigoDelDepartamento;
	private JLabel lblNombreDelDepartamento;
	private JLabel lblEspecialidad;
	
	private JTextField txtCdigoDelDepartamento;
	private JTextField txtNombreDelDepartamento;
	
	private JCheckBox chckbxActivo;
	
	private JComboBox<String> comboBoxEspecialidades;
	
	private JSeparator separatorCodigoDelDepartamento;
	private JSeparator separatorNombreDelDepartamento;
	
	private int xPositionMouse, yPositionMouse;
	
	private Departamento departamento;
	
	private JTable tablaListadoDepartamentos;
	
	private DepartamentoControlable departamentoControlable;

	public VentanaGestionDepartamentoModificacion(boolean b, Departamento departamento, DepartamentoControlable departamentoControlable, JTable tablaListadoDepartamentos) {
		/**
		 * Controladores para pasar datos entre ventanas
		 */
		this.tablaListadoDepartamentos = tablaListadoDepartamentos;
		this.departamentoControlable = departamentoControlable;
		this.departamento = departamento;
		
		/**
		 * Diseño de la ventana
		 */
		
		setModal(b);
		setUndecorated(true);
		setLocationByPlatform(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imgs/cruzRoja.png")));
		setBounds(600, 200, 761, 508);
		getContentPane().setLayout(null);
		
		background = new JPanel();
		background.setLayout(null);
		background.setBackground(new Color(245, 245, 245));
		background.setBounds(0, 0, 761, 508);
		getContentPane().add(background);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnModificar.setFocusPainted(false);
		btnModificar.setBorder(null);
		btnModificar.setBackground(new Color(0, 118, 255));
		btnModificar.setBounds(565, 447, 172, 36);
		background.add(btnModificar);
		
		btnCerrarApp = new JButton("x");
		btnCerrarApp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrarApp.setForeground(Color.WHITE);
		btnCerrarApp.setFont(new Font("Montserrat Medium", Font.BOLD, 25));
		btnCerrarApp.setFocusPainted(false);
		btnCerrarApp.setBorder(null);
		btnCerrarApp.setBackground(new Color(0, 118, 255));
		btnCerrarApp.setBounds(693, 0, 68, 31);
		background.add(btnCerrarApp);
		
		
		lblHeaderApp = new JLabel("");
		lblHeaderApp.setBounds(0, 0, 761, 31);
		background.add(lblHeaderApp);
		
		
		lblModificacion = new JLabel("Modificaci\u00F3n");
		lblModificacion.setHorizontalTextPosition(SwingConstants.CENTER);
		lblModificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificacion.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		lblModificacion.setBounds(31, 42, 161, 36);
		background.add(lblModificacion);
		
		lblCdigoDelDepartamento = new JLabel("C\u00D3DIGO DEL DEPARTAMENTO");
		lblCdigoDelDepartamento.setIcon(new ImageIcon(VentanaGestionDepartamentoModificacion.class.getResource("/imgs/codigode.png")));
		lblCdigoDelDepartamento.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblCdigoDelDepartamento.setHorizontalAlignment(SwingConstants.LEFT);
		lblCdigoDelDepartamento.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		lblCdigoDelDepartamento.setBounds(49, 113, 292, 21);
		background.add(lblCdigoDelDepartamento);
		
		lblNombreDelDepartamento = new JLabel("NOMBRE DEL DEPARTAMENTO");
		lblNombreDelDepartamento.setIcon(new ImageIcon(VentanaGestionDepartamentoModificacion.class.getResource("/imgs/nombrede.png")));
		lblNombreDelDepartamento.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNombreDelDepartamento.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreDelDepartamento.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		lblNombreDelDepartamento.setBounds(49, 240, 291, 21);
		background.add(lblNombreDelDepartamento);
		
		lblEspecialidad = new JLabel("ESPECIALIDAD");
		lblEspecialidad.setIcon(new ImageIcon(VentanaGestionDepartamentoModificacion.class.getResource("/imgs/especialidad.png")));
		lblEspecialidad.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblEspecialidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblEspecialidad.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		lblEspecialidad.setBounds(438, 112, 161, 28);
		background.add(lblEspecialidad);
		
		txtCdigoDelDepartamento = new JTextField();
		txtCdigoDelDepartamento.setBackground(new Color(245, 245, 245));
		txtCdigoDelDepartamento.setEditable(false);
		txtCdigoDelDepartamento.setForeground(Color.GRAY);
		txtCdigoDelDepartamento.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		txtCdigoDelDepartamento.setColumns(10);
		txtCdigoDelDepartamento.setBorder(null);
		txtCdigoDelDepartamento.setBounds(49, 172, 292, 28);
		background.add(txtCdigoDelDepartamento);
		
		txtNombreDelDepartamento = new JTextField();
		txtNombreDelDepartamento.setBackground(new Color(245, 245, 245));
		txtNombreDelDepartamento.setForeground(new Color(0,0,0));
		txtNombreDelDepartamento.setFont(new Font("Montserrat Medium", Font.PLAIN, 16));
		txtNombreDelDepartamento.setColumns(10);
		txtNombreDelDepartamento.setBorder(null);
		txtNombreDelDepartamento.setBounds(50, 299, 291, 28);
		background.add(txtNombreDelDepartamento);
		
		chckbxActivo = new JCheckBox(" Activo");
		chckbxActivo.setHorizontalTextPosition(SwingConstants.RIGHT);
		chckbxActivo.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxActivo.setFont(new Font("Montserrat Medium", Font.PLAIN, 17));
		chckbxActivo.setBorder(null);
		chckbxActivo.setBackground(new Color(245, 245, 245));
		chckbxActivo.setBounds(49, 405, 97, 23);
		background.add(chckbxActivo);
		
		comboBoxEspecialidades = new JComboBox<String>();
		comboBoxEspecialidades.setEditable(true);
		comboBoxEspecialidades.setForeground(Color.BLACK);
		comboBoxEspecialidades.setBorder(null);
		comboBoxEspecialidades.setBackground(new Color(245, 245, 245));
		comboBoxEspecialidades.setBounds(438, 174, 278, 28);
		background.add(comboBoxEspecialidades);
		
		separatorCodigoDelDepartamento = new JSeparator();
		separatorCodigoDelDepartamento.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento.setBounds(48, 200, 293, 2);
		background.add(separatorCodigoDelDepartamento);
		
		separatorNombreDelDepartamento = new JSeparator();
		separatorNombreDelDepartamento.setForeground(Color.BLACK);
		separatorNombreDelDepartamento.setBounds(49, 327, 292, 2);
		background.add(separatorNombreDelDepartamento);
		
		/**
		 * LLamada de los botones para realizar eventos.
		 */
		
		btnModificarMouseListener();
		lblHeaderAppMouseListener();
		lblHeaderAppMouseMotionListener();
		btnCerrarAppMouseListener();
		
		/**
		 * LLamada al metodo para colocar los datos que viene de la vetana padre en los campos a modificar.
		 */
		
		colocarDatos();

	}
	
	/**
	 * Metodos
	 */
	
	/**
	 * Metodo en el cual se recojer datos de la ventana padre y se colocan en sus respectivos campos.
	 */
	
	private void colocarDatos() {
		String[] especialidades = null;
		
		txtCdigoDelDepartamento.setText(departamento.getCodDepartamento());
		txtNombreDelDepartamento.setText(departamento.getNombreDepartamento());
		chckbxActivo.setSelected(departamento.getActivoDepartamento());
		
		especialidades = departamento.getEspecialidades().clone();
		for(int i = 0; i < 5; i++) {
			comboBoxEspecialidades.addItem(especialidades[i]);
		}
	}

	/**
	 * Metodo para modificar los datos del departamento correspondiente.
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnModificar)) {
			
			boolean activoONo = false;
			boolean modificado = false;
			
			if(chckbxActivo.isSelected()) {
				activoONo = true;
			}
			
			if(!txtCdigoDelDepartamento.getText().isEmpty() || txtNombreDelDepartamento.getText().isEmpty()) {
				Departamento departamento = new Departamento(txtCdigoDelDepartamento.getText(), txtNombreDelDepartamento.getText(), activoONo);
				try {
					modificado = departamentoControlable.modificarDepartamento(departamento);
					if(modificado) {
						JOptionPane.showMessageDialog(this, "Modificado correctamente", "Modificado", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (CreateSqlException e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage(), "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
				}
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "Error, todavia hay datos sin introducir", "Datos sin introducir", JOptionPane.INFORMATION_MESSAGE);
			}
		}if(e.getSource().equals(btnCerrarApp)) {
			int confirmado = JOptionPane.showConfirmDialog(this,"¿Estas seguro de cancelar la modificacion?", "Cancelar modificacion",JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (JOptionPane.OK_OPTION == confirmado) {
				dispose();
			}else
				System.out.println("");	
		}
		
	}
	
	/**
	 * Metodos MouseListener para realizar eventos al clicar, presionar, soltar etc...
	 */
	
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

		btnModificar.addMouseListener(ml);

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
	
	
}
