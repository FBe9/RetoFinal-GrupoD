package panel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;

import clases.Doctor;
import clases.Empleado;
import clases.Paciente;
import gui.VentanaGestionPacientes;
import gui.VentanaModificacionPaciente;
import interfaces.DepartamentoControlable;
import interfaces.EmpleadoControlable;
import interfaces.EmpleadosPacienteControlable;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;

public class ListadoBajasPacientePanel extends JPanel implements ActionListener {
	protected static final Component ListadoBajasPacientePanel = null;

	private VentanaModificacionPaciente ventanaModificacion;

	private JScrollPane buscarPaciente;

	private JTextField txtCicPaciente;
	private JTextField txtDniPaciente;
	private JTextField txtNombrePaciente;
	private JTextField txtApellidoPaciente;
	private JTextField txtTelefonoPaciente;
	private JTextField txtEnfermedadPaciente;

	private JButton btnModificarPaciente;
	private JLabel lblCicALtaPaciente;
	private JLabel lblDniALtaPaciente;
	private JLabel lblNombreALtaPaciente;
	private JLabel lblApellidoAltaPaciente;
	private JLabel lblTelefonoALtaPaciente;
	private JLabel lblEnfermedadALtaPaciente;

	private JButton btnDardeBajaPaciente;

	private JTable tablaListadoPacientes = new JTable();

	private EmpleadosPacienteControlable pacientesInterface;
	private Empleado empleado;
	private JTextField txtApellidoSegundo;
	private EmpleadoControlable empleadoControlable;
	private DepartamentoControlable departamentoControlable;

	public ListadoBajasPacientePanel(EmpleadosPacienteControlable pacientesInterface, Empleado empleado,
			EmpleadoControlable empleadoControlable, DepartamentoControlable departamentoControlable) {
		setBackground(new Color(245, 245, 245));
		
		/**
		 * Llama controlador desde la ventana
		 */
		this.ventanaModificacion = ventanaModificacion;
		this.empleadoControlable = empleadoControlable;
		this.pacientesInterface = pacientesInterface;
		this.empleado = empleado;
		this.departamentoControlable = departamentoControlable;

		setBounds(500, 200, 926, 607);
		setLayout(null);

		txtCicPaciente = new JTextField();
		txtCicPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtCicPaciente.setBackground(new Color(245, 245, 245));
		txtCicPaciente.setBorder(null);
		txtCicPaciente.setEditable(false);
		txtCicPaciente.setBounds(477, 96, 172, 29);
		add(txtCicPaciente);
		txtCicPaciente.setColumns(10);

		txtDniPaciente = new JTextField();
		txtDniPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtDniPaciente.setBackground(new Color(245, 245, 245));
		txtDniPaciente.setBorder(null);
		txtDniPaciente.setEditable(false);
		txtDniPaciente.setColumns(10);
		txtDniPaciente.setBounds(477, 187, 172, 29);
		add(txtDniPaciente);

		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtNombrePaciente.setBackground(new Color(245, 245, 245));
		txtNombrePaciente.setBorder(null);
		txtNombrePaciente.setEditable(false);
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(477, 261, 172, 29);
		add(txtNombrePaciente);

		txtApellidoPaciente = new JTextField();
		txtApellidoPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtApellidoPaciente.setBackground(new Color(245, 245, 245));
		txtApellidoPaciente.setBorder(null);
		txtApellidoPaciente.setEditable(false);
		txtApellidoPaciente.setColumns(10);
		txtApellidoPaciente.setBounds(675, 265, 172, 29);
		add(txtApellidoPaciente);

		txtTelefonoPaciente = new JTextField();
		txtTelefonoPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtTelefonoPaciente.setBackground(new Color(245, 245, 245));
		txtTelefonoPaciente.setBorder(null);
		txtTelefonoPaciente.setEditable(false);
		txtTelefonoPaciente.setColumns(10);
		txtTelefonoPaciente.setBounds(675, 96, 161, 29);
		add(txtTelefonoPaciente);

		txtEnfermedadPaciente = new JTextField();
		txtEnfermedadPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtEnfermedadPaciente.setBackground(new Color(245, 245, 245));
		txtEnfermedadPaciente.setBorder(null);
		txtEnfermedadPaciente.setEditable(false);
		txtEnfermedadPaciente.setColumns(10);
		txtEnfermedadPaciente.setBounds(675, 187, 161, 29);
		add(txtEnfermedadPaciente);

		btnModificarPaciente = new JButton("Modificar");
		btnModificarPaciente.setFocusPainted(false);
		btnModificarPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarPaciente.setForeground(new Color(255, 255, 255));
		btnModificarPaciente.setBackground(new Color(0, 118, 255));
		btnModificarPaciente.setBorder(null);
		btnModificarPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnModificarPaciente.setBounds(675, 449, 172, 36);
		add(btnModificarPaciente);

		lblCicALtaPaciente = new JLabel("CIC");
		lblCicALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblCicALtaPaciente.setBounds(477, 64, 172, 21);
		add(lblCicALtaPaciente);

		lblDniALtaPaciente = new JLabel("DNI");
		lblDniALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblDniALtaPaciente.setBounds(477, 153, 172, 21);
		add(lblDniALtaPaciente);

		lblNombreALtaPaciente = new JLabel("Nombre");
		lblNombreALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblNombreALtaPaciente.setBounds(477, 227, 172, 21);
		add(lblNombreALtaPaciente);

		lblApellidoAltaPaciente = new JLabel("Primer apellido");
		lblApellidoAltaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblApellidoAltaPaciente.setBounds(675, 227, 172, 21);
		add(lblApellidoAltaPaciente);

		lblTelefonoALtaPaciente = new JLabel("Telefono");
		lblTelefonoALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblTelefonoALtaPaciente.setBounds(675, 64, 132, 21);
		add(lblTelefonoALtaPaciente);

		lblEnfermedadALtaPaciente = new JLabel("Enfermedad");
		lblEnfermedadALtaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblEnfermedadALtaPaciente.setBounds(675, 155, 132, 21);
		add(lblEnfermedadALtaPaciente);

		btnDardeBajaPaciente = new JButton("Baja");
		btnDardeBajaPaciente.setFocusPainted(false);
		btnDardeBajaPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDardeBajaPaciente.setForeground(new Color(255, 255, 255));
		btnDardeBajaPaciente.setBackground(new Color(0, 118, 255));
		btnDardeBajaPaciente.setBorder(null);
		btnDardeBajaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		btnDardeBajaPaciente.setBounds(531, 449, 104, 36);
		/**
		 * En caso de ser doctor, se te a�ade el boton de baja del paciente
		 */
		if (empleado.getTipoEmpleado().equalsIgnoreCase("Doctor")) {
			add(btnDardeBajaPaciente);
		}

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(456, 64, 2, 492);
		add(separator);

		JLabel lblApellido2AltaPaciente = new JLabel("Segundo apellido");
		lblApellido2AltaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		lblApellido2AltaPaciente.setBounds(477, 301, 172, 21);
		add(lblApellido2AltaPaciente);

		txtApellidoSegundo = new JTextField();
		txtApellidoSegundo.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		txtApellidoSegundo.setBackground(new Color(245, 245, 245));
		txtApellidoSegundo.setBorder(null);
		txtApellidoSegundo.setEditable(false);
		txtApellidoSegundo.setColumns(10);
		txtApellidoSegundo.setBounds(477, 346, 172, 29);
		add(txtApellidoSegundo);

		
		JSeparator separatorCodigoDelDepartamento_1 = new JSeparator();
		separatorCodigoDelDepartamento_1.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1.setBounds(477, 125, 172, 2);
		add(separatorCodigoDelDepartamento_1);
		
		JSeparator separatorCodigoDelDepartamento_1_1 = new JSeparator();
		separatorCodigoDelDepartamento_1_1.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1_1.setBounds(479, 216, 170, 2);
		add(separatorCodigoDelDepartamento_1_1);
		
		JSeparator separatorCodigoDelDepartamento_1_2 = new JSeparator();
		separatorCodigoDelDepartamento_1_2.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1_2.setBounds(479, 290, 170, 2);
		add(separatorCodigoDelDepartamento_1_2);
		
		JSeparator separatorCodigoDelDepartamento_1_3 = new JSeparator();
		separatorCodigoDelDepartamento_1_3.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1_3.setBounds(479, 375, 170, 2);
		add(separatorCodigoDelDepartamento_1_3);
		
		JSeparator separatorCodigoDelDepartamento_1_4 = new JSeparator();
		separatorCodigoDelDepartamento_1_4.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1_4.setBounds(675, 125, 161, 2);
		add(separatorCodigoDelDepartamento_1_4);
		
		JSeparator separatorCodigoDelDepartamento_1_5 = new JSeparator();
		separatorCodigoDelDepartamento_1_5.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1_5.setBounds(675, 216, 161, 2);
		add(separatorCodigoDelDepartamento_1_5);
		
		JSeparator separatorCodigoDelDepartamento_1_6 = new JSeparator();
		separatorCodigoDelDepartamento_1_6.setForeground(Color.BLACK);
		separatorCodigoDelDepartamento_1_6.setBounds(675, 294, 172, 2);
		add(separatorCodigoDelDepartamento_1_6);

		
		/**
		 * Te lista todos los pacientes asociados a un doctor o enfermero en una tabla
		 */
		ArrayList<Paciente> pacientes = null;
		String tableMatrix[][] = null;

		pacientes = pacientesInterface.listarPacientes(empleado.getCodEmpleado());
		if (pacientes.size() > 0) {

			tableMatrix = new String[pacientes.size()][3];
			for (int i = 0; i < pacientes.size(); i++) {
				tableMatrix[i][0] = pacientes.get(i).getCic();
				tableMatrix[i][1] = pacientes.get(i).getNombrePaciente();
				tableMatrix[i][2] = pacientes.get(i).getEnfermedad();
			}

			String titles[] = { "CIC", "Nombre", "Enfermedad" };

			tablaListadoPacientes = new JTable(tableMatrix, titles) {
				public boolean editCellAt(int row, int column, java.util.EventObject e) {
					return false;
				}
			};
			;

			buscarPaciente = new JScrollPane();
			buscarPaciente.setBounds(22, 70, 421, 422);
			add(buscarPaciente);

			tablaListadoPacientes.setSelectionBackground(new Color(24, 24, 24));
			tablaListadoPacientes.setSelectionForeground(Color.WHITE);
			tablaListadoPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tablaListadoPacientes.setRowMargin(0);
			tablaListadoPacientes.setRowHeight(25);
			tablaListadoPacientes.setShowVerticalLines(true);
			tablaListadoPacientes.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));

			buscarPaciente.setViewportView(tablaListadoPacientes);

			JTableHeader tableHeader = tablaListadoPacientes.getTableHeader();
			tableHeader.setBackground(new Color(0, 118, 255));
			tableHeader.setForeground(Color.WHITE);
			tableHeader.setFont(new Font("Montserrat Medium", Font.BOLD, 15));
			tableHeader.setEnabled(false);

			btnListarMouseListener(pacientesInterface);
			btnModificarPacienteMouseListener();
			btnDardeBajaPacienteMouseListener();

		}

	}

	private void btnDardeBajaPacienteMouseListener() {
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
				btnDardeBajaPaciente.setBackground(new Color(0, 118, 255));
				btnDardeBajaPaciente.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnDardeBajaPaciente.setBackground(new Color(0, 80, 255));
				btnDardeBajaPaciente.setFont(new Font("Montserrat SemiBold", Font.BOLD, 14));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};

		btnDardeBajaPaciente.addMouseListener(ml);
		
		
	}

	private void btnModificarPacienteMouseListener() {
		
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
				// TODO Auto-generated method stub

			}
		};

		btnModificarPaciente.addMouseListener(ml);
	}
	
	/**
	 * Este metodo recoge los datos de un paciente de la tabla y los lista todos
	 * @param pacientesInterface
	 */

	protected void cerrar() {
		// TODO Auto-generated method stub
		JDialog parent = (JDialog) this.getTopLevelAncestor();
		parent.dispose();
		VentanaGestionPacientes ventana = new VentanaGestionPacientes(pacientesInterface, empleado, empleadoControlable, departamentoControlable);
		ventana.setVisible(true);
	}
	
	/**
	 * Este metodo recoge los datos de un paciente de la tabla y los lista todos
	 * @param pacientesInterface
	 */
	private void btnListarMouseListener(EmpleadosPacienteControlable pacientesInterface) {

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

				Paciente pac = new Paciente();

				String codigo = tablaListadoPacientes.getValueAt(tablaListadoPacientes.getSelectedRow(), 0).toString();

				pac = pacientesInterface.buscarPaciente(codigo);

				txtCicPaciente.setText(pac.getCic());
				txtDniPaciente.setText(pac.getDniPaciente());
				txtNombrePaciente.setText(pac.getNombrePaciente());
				txtApellidoPaciente.setText(pac.getApellidoPaciente());
				txtApellidoSegundo.setText(pac.getApellido2Paciente());
				txtEnfermedadPaciente.setText(pac.getEnfermedad());
				txtTelefonoPaciente.setText(pac.getTlf());

				btnBajaMouseListener(codigo, pacientesInterface);
				btnModificacionMouseListener(pac, pacientesInterface);

			}
		};

		tablaListadoPacientes.addMouseListener(ml);

	}

	/**
	 * Elimina el paciente que este seleccionado en la tabla y cuyos datos se ven
	 * @param codigo
	 * @param pacientesInterface
	 */
	private void btnBajaMouseListener(String codigo, EmpleadosPacienteControlable pacientesInterface) {

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
				int confirmado = JOptionPane.showConfirmDialog(ListadoBajasPacientePanel,
						"Estas seguro de darle de baja?", "", JOptionPane.INFORMATION_MESSAGE);
				if (JOptionPane.OK_OPTION == confirmado) {
					pacientesInterface.eliminarPaciente(codigo);	
					cerrar();
				} else {
					JOptionPane.showMessageDialog(ListadoBajasPacientePanel, "Baja cancelada");
				}
			}
		};
		
		btnDardeBajaPaciente.addMouseListener(ml);

	}

	/**
	 * Abre una ventana nueva que permite modificar todos los datos excepto el codigo y el dni
	 * @param pac
	 * @param pacientesInterface
	 */
	private void btnModificacionMouseListener(Paciente pac, EmpleadosPacienteControlable pacientesInterface) {

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
				if (tablaListadoPacientes.getSelectedRow() != -1) {
					ventanaModificacion = new VentanaModificacionPaciente(pac,pacientesInterface);
					ventanaModificacion.setVisible(true);
					VentanaGestionPacientes ventanaGestionPacientes = new VentanaGestionPacientes(pacientesInterface, empleado, empleadoControlable, departamentoControlable);
					ventanaGestionPacientes.setVisible(true);
				} else if (tablaListadoPacientes.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(ListadoBajasPacientePanel,
							"Advertencia, no se pueden modificar ningun departamento ya que no se a seleccionado ninguno",
							"Modificacion", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		};

		btnModificarPaciente.addMouseListener(ml);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
