package panel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;

import clases.Paciente;
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
	private JLabel lblApellidoALtaPaciente;
	private JLabel lblTelefonoALtaPaciente;
	private JLabel lblEnfermedadALtaPaciente;

	private JButton btnDardeBajaPaciente;
	private JTextField txtBarraDeBusqueda;
	private JButton btnBotonBusquedaPaciente;

	private JTable tablaListadoPacientes;

	public ListadoBajasPacientePanel(EmpleadosPacienteControlable pacientesInterface) {

		setBounds(500, 200, 926, 607);
		setLayout(null);

		txtCicPaciente = new JTextField();
		txtCicPaciente.setBounds(477, 96, 172, 29);
		add(txtCicPaciente);
		txtCicPaciente.setColumns(10);

		txtDniPaciente = new JTextField();
		txtDniPaciente.setColumns(10);
		txtDniPaciente.setBounds(477, 187, 172, 29);
		add(txtDniPaciente);

		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setColumns(10);
		txtNombrePaciente.setBounds(477, 261, 172, 29);
		add(txtNombrePaciente);

		txtApellidoPaciente = new JTextField();
		txtApellidoPaciente.setColumns(10);
		txtApellidoPaciente.setBounds(477, 356, 172, 29);
		add(txtApellidoPaciente);

		txtTelefonoPaciente = new JTextField();
		txtTelefonoPaciente.setColumns(10);
		txtTelefonoPaciente.setBounds(675, 96, 161, 29);
		add(txtTelefonoPaciente);

		txtEnfermedadPaciente = new JTextField();
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

		lblApellidoALtaPaciente = new JLabel("Apellido/s");
		lblApellidoALtaPaciente.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 14));
		lblApellidoALtaPaciente.setBounds(477, 331, 172, 21);
		add(lblApellidoALtaPaciente);

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
		add(btnDardeBajaPaciente);

		// Poner panel para señalar busqueda o no?

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

		btnModificacionMouseListener();
		btnListarPacientesMouseListener(pacientesInterface);

		/*
		 * En caso de que se busque paciente
		 * 
		 * Jtable = new Jtable(); (Mandandole array[][] de pacientes) String Titles =
		 * {CIC, Nombre, Enfermedad}
		 * 
		 */

	}

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
				VentanaModificacionPaciente modificacionPaciente = new VentanaModificacionPaciente();
				modificacionPaciente.setVisible(true);

			}
		};

		btnModificarPaciente.addMouseListener(ml);

	}

	private void btnListarPacientesMouseListener(EmpleadosPacienteControlable pacientesInterface) {

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

			@SuppressWarnings("serial")
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Paciente>  pacientes = null;
				if (txtBarraDeBusqueda.getText().isBlank()) {
					pacientes = pacientesInterface.listarPacientes("CE001");
					if (pacientes.size() > 0) {
						String tableMatrix[][] = new String[pacientes.size()][3];
						for (int i = 0; i < pacientes.size(); i++) {
							tableMatrix[i][0] = pacientes.get(i).getCic();
							tableMatrix[i][1] = pacientes.get(i).getNombrePaciente();
							tableMatrix[i][2] = pacientes.get(i).getEnfermedad();

							Border blackline;

							blackline = BorderFactory.createLineBorder(Color.black, 1);

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
							tablaListadoPacientes.setBorder(blackline);
							tablaListadoPacientes.setShowVerticalLines(true);
							tablaListadoPacientes.setFont(new Font("Tahoma", Font.PLAIN, 12));

							buscarPaciente.setViewportView(tablaListadoPacientes);

							JTableHeader tableHeader = tablaListadoPacientes.getTableHeader();
							tableHeader.setBackground(new Color(20, 57, 122));
							tableHeader.setForeground(Color.WHITE);
							tableHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
							tableHeader.setBorder(blackline);
							tableHeader.setEnabled(false);

						}

					} else {
						pacientes = pacientesInterface.listarPacientesFiltro("CE001", txtBarraDeBusqueda.getText());
						if (pacientes.size() > 0) {
							String tableMatrix[][] = new String[pacientes.size()][3];
							for (int i = 0; i < pacientes.size(); i++) {
								tableMatrix[i][0] = pacientes.get(i).getCic();
								tableMatrix[i][1] = pacientes.get(i).getNombrePaciente();
								tableMatrix[i][2] = pacientes.get(i).getEnfermedad();

								Border blackline;

								blackline = BorderFactory.createLineBorder(Color.black, 1);

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
								tablaListadoPacientes.setBorder(blackline);
								tablaListadoPacientes.setShowVerticalLines(true);
								tablaListadoPacientes.setFont(new Font("Tahoma", Font.PLAIN, 12));

								buscarPaciente.setViewportView(tablaListadoPacientes);

								JTableHeader tableHeader = tablaListadoPacientes.getTableHeader();
								tableHeader.setBackground(new Color(20, 57, 122));
								tableHeader.setForeground(Color.WHITE);
								tableHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
								tableHeader.setBorder(blackline);
								tableHeader.setEnabled(false);

							}
						}
					}
				}
			}
		};

		btnBotonBusquedaPaciente.addMouseListener(ml);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
