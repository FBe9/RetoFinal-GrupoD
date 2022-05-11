package panel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;

import clases.Paciente;
import clases.Usuario;
import gui.VentanaModificacionPaciente;
import interfaces.EmpleadosPacienteControlable;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

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
	private JTextField txtBarraDeBusqueda;
	private JButton btnBotonBusquedaPaciente;

	private JTable tablaListadoPacientes = new JTable();
	private JTable tablaListadoPacientesBusqueda = new JTable();

	private EmpleadosPacienteControlable pacientesInterface;
	private Usuario usuario;
	private JTextField txtApellidoSegundo;

	public ListadoBajasPacientePanel(EmpleadosPacienteControlable pacientesInterface, Usuario usuario) {
		this.pacientesInterface = pacientesInterface;
		this.usuario = usuario;

		setBounds(500, 200, 926, 607);
		setLayout(null);

		txtCicPaciente = new JTextField();
		txtCicPaciente.setEditable(false);
		txtCicPaciente.setBounds(477, 96, 172, 29);
		add(txtCicPaciente);
		txtCicPaciente.setColumns(10);

		txtDniPaciente = new JTextField();
		txtDniPaciente.setEditable(false);
		txtDniPaciente.setColumns(10);
		txtDniPaciente.setBounds(477, 187, 172, 29);
		add(txtDniPaciente);

		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setEditable(false);
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(477, 261, 172, 29);
		add(txtNombrePaciente);

		txtApellidoPaciente = new JTextField();
		txtApellidoPaciente.setEditable(false);
		txtApellidoPaciente.setColumns(10);
		txtApellidoPaciente.setBounds(675, 265, 172, 29);
		add(txtApellidoPaciente);

		txtTelefonoPaciente = new JTextField();
		txtTelefonoPaciente.setEditable(false);
		txtTelefonoPaciente.setColumns(10);
		txtTelefonoPaciente.setBounds(675, 96, 161, 29);
		add(txtTelefonoPaciente);

		txtEnfermedadPaciente = new JTextField();
		txtEnfermedadPaciente.setEditable(false);
		txtEnfermedadPaciente.setColumns(10);
		txtEnfermedadPaciente.setBounds(675, 187, 161, 29);
		add(txtEnfermedadPaciente);

		btnModificarPaciente = new JButton("MODIFICAR");
		btnModificarPaciente.setBounds(703, 449, 104, 36);
		add(btnModificarPaciente);

		lblCicALtaPaciente = new JLabel("CIC");
		lblCicALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblCicALtaPaciente.setBounds(477, 64, 172, 21);
		add(lblCicALtaPaciente);

		lblDniALtaPaciente = new JLabel("DNI");
		lblDniALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblDniALtaPaciente.setBounds(477, 153, 172, 21);
		add(lblDniALtaPaciente);

		lblNombreALtaPaciente = new JLabel("Nombre");
		lblNombreALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblNombreALtaPaciente.setBounds(477, 227, 172, 21);
		add(lblNombreALtaPaciente);

		lblApellidoAltaPaciente = new JLabel("Primer apellido");
		lblApellidoAltaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblApellidoAltaPaciente.setBounds(675, 240, 172, 21);
		add(lblApellidoAltaPaciente);

		lblTelefonoALtaPaciente = new JLabel("Telefono");
		lblTelefonoALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblTelefonoALtaPaciente.setBounds(675, 64, 132, 21);
		add(lblTelefonoALtaPaciente);

		lblEnfermedadALtaPaciente = new JLabel("Enfermedad");
		lblEnfermedadALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblEnfermedadALtaPaciente.setBounds(675, 155, 132, 21);
		add(lblEnfermedadALtaPaciente);

		btnDardeBajaPaciente = new JButton("BAJA");
		btnDardeBajaPaciente.setBounds(531, 449, 104, 36);
		if (usuario.getTipoDeUsuario().equalsIgnoreCase("Doctor")) {
			add(btnDardeBajaPaciente);
		}

		txtBarraDeBusqueda = new JTextField();
		txtBarraDeBusqueda.setColumns(10);
		txtBarraDeBusqueda.setBounds(25, 64, 331, 35);
		add(txtBarraDeBusqueda);

		// Buscar imagen para boton
		btnBotonBusquedaPaciente = new JButton("");
		btnBotonBusquedaPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBotonBusquedaPaciente.setBounds(366, 64, 70, 37);
		add(btnBotonBusquedaPaciente);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(SystemColor.activeCaption);
		separator.setBackground(SystemColor.activeCaption);
		separator.setBounds(456, 64, 11, 492);
		add(separator);

		JLabel lblApellido2AltaPaciente = new JLabel("Segundo apellido");
		lblApellido2AltaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblApellido2AltaPaciente.setBounds(477, 321, 172, 21);
		add(lblApellido2AltaPaciente);

		txtApellidoSegundo = new JTextField();
		txtApellidoSegundo.setEditable(false);
		txtApellidoSegundo.setColumns(10);
		txtApellidoSegundo.setBounds(477, 346, 172, 29);
		add(txtApellidoSegundo);

		ArrayList<Paciente> pacientes = null;
		String tableMatrix[][] = null;

		pacientes = pacientesInterface.listarPacientes(usuario.getCodigoDelUsuario());
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
			buscarPaciente.setBounds(22, 110, 421, 422);
			add(buscarPaciente);

			tablaListadoPacientes.setSelectionBackground(new Color(46, 46, 46));
			tablaListadoPacientes.setSelectionForeground(Color.WHITE);
			tablaListadoPacientes.setRowMargin(0);
			tablaListadoPacientes.setRowHeight(25);
			tablaListadoPacientes.setShowVerticalLines(true);
			tablaListadoPacientes.setFont(new Font("Tahoma", Font.PLAIN, 12));

			buscarPaciente.setViewportView(tablaListadoPacientes);

			JTableHeader tableHeader = tablaListadoPacientes.getTableHeader();
			tableHeader.setBackground(new Color(20, 57, 122));
			tableHeader.setForeground(Color.WHITE);
			tableHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
			tableHeader.setEnabled(false);

			btnListarMouseListener(pacientesInterface);

		}

		btnListarPacientesMouseListener(pacientesInterface, usuario);

	}

	private void btnListarPacientesMouseListener(EmpleadosPacienteControlable pacientesInterface, Usuario usuario) {

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
				String tableMatrix[][] = null;
				ArrayList<Paciente> pacientes = null;
				
				if (txtBarraDeBusqueda.getText().isEmpty()) {
					pacientes = pacientesInterface.listarPacientes(usuario.getCodigoDelUsuario());
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
						buscarPaciente.setBounds(22, 110, 421, 422);
						add(buscarPaciente);

						tablaListadoPacientes.setSelectionBackground(new Color(46, 46, 46));
						tablaListadoPacientes.setSelectionForeground(Color.WHITE);
						tablaListadoPacientes.setRowMargin(0);
						tablaListadoPacientes.setRowHeight(25);
						tablaListadoPacientes.setShowVerticalLines(true);
						tablaListadoPacientes.setFont(new Font("Tahoma", Font.PLAIN, 12));

						buscarPaciente.setViewportView(tablaListadoPacientes);

						JTableHeader tableHeader = tablaListadoPacientes.getTableHeader();
						tableHeader.setBackground(new Color(20, 57, 122));
						tableHeader.setForeground(Color.WHITE);
						tableHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
						tableHeader.setEnabled(false);

						btnListarMouseListener(pacientesInterface);

					}

				} else {

					pacientes = pacientesInterface.listarPacientesFiltro(txtBarraDeBusqueda.getText(),
							usuario.getCodigoDelUsuario());
					if (pacientes.size() > 0) {
						tableMatrix = new String[pacientes.size()][3];
						for (int i = 0; i < pacientes.size(); i++) {
							tableMatrix[i][0] = pacientes.get(i).getCic();
							tableMatrix[i][1] = pacientes.get(i).getNombrePaciente();
							tableMatrix[i][2] = pacientes.get(i).getEnfermedad();
						}

						String titles[] = { "CIC", "Nombre", "Enfermedad" };

						tablaListadoPacientesBusqueda = new JTable(tableMatrix, titles) {
							public boolean editCellAt(int row, int column, java.util.EventObject e) {
								return false;
							}
						};
						;

						buscarPaciente = new JScrollPane();

						buscarPaciente.setBounds(22, 110, 421, 422);
						add(buscarPaciente);

						tablaListadoPacientesBusqueda.setSelectionBackground(new Color(46, 46, 46));
						tablaListadoPacientesBusqueda.setSelectionForeground(Color.WHITE);
						tablaListadoPacientesBusqueda.setRowMargin(0);
						tablaListadoPacientesBusqueda.setRowHeight(25);
						tablaListadoPacientesBusqueda.setShowVerticalLines(true);
						tablaListadoPacientesBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 12));

						buscarPaciente.setViewportView(tablaListadoPacientesBusqueda);

						JTableHeader tableHeader = tablaListadoPacientesBusqueda.getTableHeader();
						tableHeader.setBackground(new Color(20, 57, 122));
						tableHeader.setForeground(Color.WHITE);
						tableHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
						tableHeader.setEnabled(false);

						btnListarMouseListener(pacientesInterface);

					}

				}

			}
		};

		btnBotonBusquedaPaciente.addMouseListener(ml);

	}

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

				btnBajaMouseListener(pac.getCic(), pacientesInterface);
				btnModificacionMouseListener(pac, pacientesInterface);
			}
		};

		tablaListadoPacientes.addMouseListener(ml);

	}

	private void btnBajaMouseListener(String string, EmpleadosPacienteControlable pacientesInterface) {

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
						"�Estas seguro de darle de baja?", "", JOptionPane.INFORMATION_MESSAGE);
				if (JOptionPane.OK_OPTION == confirmado) {
					pacientesInterface.eliminarPaciente(string);
				} else
					JOptionPane.showMessageDialog(ListadoBajasPacientePanel, "Baja cancelada");
			}
		};

		btnDardeBajaPaciente.addMouseListener(ml);

	}

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
				VentanaModificacionPaciente modificacionPaciente = new VentanaModificacionPaciente(pac,
						pacientesInterface);
				modificacionPaciente.setVisible(true);

			}
		};

		btnModificarPaciente.addMouseListener(ml);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
