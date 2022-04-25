package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import panel.AltasPacientePanel;
import panel.ListadoBajasPacientePanel;

import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class VentanaEmpleadoPaciente extends JDialog implements ActionListener {

	AltasPacientePanel altasPacientePanel;
	ListadoBajasPacientePanel bajasPacientePanel;
	JTabbedPane panelesEmpleados;
	private JButton btnCerrarApp;

	public VentanaEmpleadoPaciente() {
		setUndecorated(true);
		setBounds(500, 200, 1000, 600);
		setResizable(false);
		
		iniciar();

	}

	private void iniciar() {
		getContentPane().setLayout(null);
		
		btnCerrarApp = new JButton("X");
		btnCerrarApp.setBounds(946, 0, 54, 32);
		btnCerrarApp.setFocusPainted(false);
		btnCerrarApp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrarApp.setForeground(new Color(255, 255, 255));
		btnCerrarApp.setFont(new Font("Montserrat Medium", Font.BOLD, 25));
		btnCerrarApp.setBorder(null);
		btnCerrarApp.setBackground(new Color(0, 118, 255));
		btnCerrarAppAppMouseListener();
		getContentPane().add(btnCerrarApp);
		
		
		
		panelesEmpleados = new JTabbedPane();
		panelesEmpleados.setBounds(0, 11, 1000, 589);

		altasPacientePanel = new AltasPacientePanel();

		panelesEmpleados.add("Altas", altasPacientePanel);
		bajasPacientePanel = new ListadoBajasPacientePanel();

		panelesEmpleados.add("Listado y Bajas", bajasPacientePanel);

		getContentPane().add(panelesEmpleados);

		/*
		 * btnSalir = new JButton("X");
		 * btnSalir.setBackground(UIManager.getColor("Button.background"));
		 * btnSalir.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		 * btnSalir.setBounds(891, 0, 63, 44); btnSalir.setOpaque(false);
		 * btnSalir.setContentAreaFilled(false); getContentPane().add(btnSalir);
		 * 
		 * if(btnSalir.isSelected()) { this.setVisible(false); }
		 */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void btnCerrarAppAppMouseListener() {

		MouseListener ml = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		};

		btnCerrarApp.addMouseListener(ml);
	}
}
