package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
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

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import interfaces.*;
/**
 * 
 * @author Nerea
 *
 */
public class PanelAltaEmpleado extends JPanel {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDniEmple;
	private JTextField txtCodEmple;
	private JTextField txtNomEmple;
	private JTextField txtApellidosEmple;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JDateChooser dateChooserAddUser;
	private JDateChooser dateChooserAddUser_1;
	private JTextFieldDateEditor addUserDateEditor;

	private JPanel background;
	private JPanel menuHospitalContainer;
	private JPanel panelGestiones;
	private JPanel panelInicio;

	private JLabel lblHeaderApp;
	private JLabel lblInicio;
	private JLabel lblGestiones;
	private JLabel lblNewLabel;

	private JButton btnCerrarSesion;
	private JButton btnGestiones;

	private int xPositionMouse, yPositionMouse;
	private JButton btnCerrarApp;

	public PanelAltaEmpleado() {
		setLayout(null);
		setBounds(500, 200, 1100, 600);
		contentPanel.setBackground(SystemColor.controlLtHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		
		dateChooserAddUser = new JDateChooser();
		dateChooserAddUser.setLocale(java.util.Locale.ENGLISH);
		addUserDateEditor = (JTextFieldDateEditor) dateChooserAddUser.getDateEditor();
		addUserDateEditor.setEditable(false);
		dateChooserAddUser.setDateFormatString("yyyy-MM-dd");
		dateChooserAddUser.setBounds(272, 210, 174, 22);
		contentPanel.add(dateChooserAddUser);
		
		dateChooserAddUser_1 = new JDateChooser();
		dateChooserAddUser_1.setLocale(java.util.Locale.ENGLISH);
		addUserDateEditor = (JTextFieldDateEditor) dateChooserAddUser_1.getDateEditor();
		addUserDateEditor.setEditable(false);
		dateChooserAddUser_1.setDateFormatString("yyyy-MM-dd");
		dateChooserAddUser_1.setBounds(272, 281, 174, 22);
		contentPanel.add(dateChooserAddUser_1);
		
		JComboBox comboBoxNomDepart = new JComboBox();
		comboBoxNomDepart.setBounds(23, 418, 174, 23);
		contentPanel.add(comboBoxNomDepart);

		JLabel lblNomDepart = new JLabel("Nombre del Departamento");
		lblNomDepart.setBounds(23, 387, 222, 34);
		lblNomDepart.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		contentPanel.add(lblNomDepart);

		JLabel lblActivo = new JLabel("Activo");
		lblActivo.setBounds(304, 315, 58, 34);
		lblActivo.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		contentPanel.add(lblActivo);

		JCheckBox chckbxActivo = new JCheckBox("");
		chckbxActivo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxActivo.setEnabled(false);
		chckbxActivo.setSelected(true);
		chckbxActivo.setBounds(272, 324, 26, 23);
		chckbxActivo.setForeground(SystemColor.controlLtHighlight);
		chckbxActivo.setBackground(SystemColor.controlLtHighlight);
		contentPanel.add(chckbxActivo);

		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(584, 241, 110, 34);
		lblEspecialidad.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		contentPanel.add(lblEspecialidad);

		JLabel lblCodigoEmple = new JLabel("C\u00F3digo del empleado");
		lblCodigoEmple.setEnabled(false);
		lblCodigoEmple.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblCodigoEmple.setBounds(23, 98, 167, 22);
		contentPanel.add(lblCodigoEmple);

		txtDniEmple = new JTextField();
		txtDniEmple.setBounds(23, 210, 174, 22);
		txtDniEmple.setForeground(Color.WHITE);
		txtDniEmple.setEditable(false);
		txtDniEmple.setColumns(10);
		txtDniEmple.setBackground(Color.WHITE);
		contentPanel.add(txtDniEmple);

		txtCodEmple = new JTextField();
		txtCodEmple.setBounds(23, 137, 174, 22);
		txtCodEmple.setForeground(Color.WHITE);
		txtCodEmple.setColumns(10);
		txtCodEmple.setBackground(Color.WHITE);
		contentPanel.add(txtCodEmple);

		JLabel lblDniEmple = new JLabel("DNI del empleado");
		lblDniEmple.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblDniEmple.setBounds(23, 177, 167, 22);
		contentPanel.add(lblDniEmple);

		JLabel lblNomEmple = new JLabel("Nombre del empleado");
		lblNomEmple.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblNomEmple.setBounds(23, 248, 185, 22);
		contentPanel.add(lblNomEmple);

		txtNomEmple = new JTextField();
		txtNomEmple.setForeground(Color.WHITE);
		txtNomEmple.setEditable(false);
		txtNomEmple.setColumns(10);
		txtNomEmple.setBackground(Color.WHITE);
		txtNomEmple.setBounds(23, 281, 174, 22);
		contentPanel.add(txtNomEmple);

		JLabel lblApellidosEmple = new JLabel("Apellidos del empleado");
		lblApellidosEmple.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblApellidosEmple.setBounds(23, 321, 185, 22);
		contentPanel.add(lblApellidosEmple);

		txtApellidosEmple = new JTextField();
		txtApellidosEmple.setForeground(Color.WHITE);
		txtApellidosEmple.setEditable(false);
		txtApellidosEmple.setColumns(10);
		txtApellidosEmple.setBackground(Color.WHITE);
		txtApellidosEmple.setBounds(23, 354, 174, 22);
		contentPanel.add(txtApellidosEmple);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(SystemColor.textHighlight);
		separator.setForeground(SystemColor.textHighlight);
		separator.setBounds(528, 0, 10, 537);
		contentPanel.add(separator);

		JLabel lblContrato = new JLabel("Contrato\r\n");
		lblContrato.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblContrato.setBounds(272, 93, 202, 34);
		contentPanel.add(lblContrato);

		JComboBox comboBoxContrato = new JComboBox();
		comboBoxContrato.setBounds(272, 138, 174, 23);
		contentPanel.add(comboBoxContrato);



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
		rdbtnDoctor.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		buttonGroup.add(rdbtnDoctor);
		rdbtnDoctor.setBackground(Color.WHITE);
		rdbtnDoctor.setBounds(584, 193, 75, 23);
		contentPanel.add(rdbtnDoctor);

		JRadioButton rdbtnEnfermero = new JRadioButton("Enfermero\r\n");
		rdbtnEnfermero.setFont(new Font("Montserrat Medium", Font.PLAIN, 11));
		buttonGroup.add(rdbtnEnfermero);
		rdbtnEnfermero.setBackground(new Color(245, 245,245));
		rdbtnEnfermero.setBounds(584, 150, 93, 23);
		contentPanel.add(rdbtnEnfermero);

		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblHorario.setBounds(584, 320, 110, 34);
		contentPanel.add(lblHorario);

		JComboBox comboBoxHorario = new JComboBox();
		comboBoxHorario.setBounds(584, 359, 174, 23);
		contentPanel.add(comboBoxHorario);

		JComboBox comboBoxEspecialidad = new JComboBox();
		comboBoxEspecialidad.setBounds(584, 280, 174, 23);
		contentPanel.add(comboBoxEspecialidad);

		JLabel lblTipoEmple = new JLabel("Tipo de empleado");
		lblTipoEmple.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblTipoEmple.setBounds(584, 91, 139, 34);
		contentPanel.add(lblTipoEmple);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setBorder(null);
		btnRegistrar.setBackground(new Color(0, 118, 255));
		btnRegistrar.setBounds(664, 496, 131, 41);
		contentPanel.add(btnRegistrar);
		
		JLabel lblFechaFin = new JLabel("Fecha de fin del contrato");
		lblFechaFin.setBounds(271, 249, 207, 22);
		contentPanel.add(lblFechaFin);
		lblFechaFin.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio del contrato");
		lblFechaDeInicio.setFont(new Font("Montserrat Medium", Font.PLAIN, 15));
		lblFechaDeInicio.setBounds(271, 178, 227, 22);
		contentPanel.add(lblFechaDeInicio);
		
		

	}

	/*private void btnCerrarSesionMouseListener() {

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

		//btnCerrarApp.addMouseListener(ml);
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

	}*/
}