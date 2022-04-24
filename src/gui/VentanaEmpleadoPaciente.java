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
import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import java.awt.SystemColor;
import javax.swing.JLabel;

public class VentanaEmpleadoPaciente extends JDialog {
	
	AltasPacientePanel altasPacientePanel; 
	ListadoBajasPacientePanel bajasPacientePanel;
	JTabbedPane panelesEmpleados;
	
	public VentanaEmpleadoPaciente() {
		setResizable(false);
		
		iniciar();
	
	}
	
	private void iniciar() {
		getContentPane().setLayout(null);
		panelesEmpleados  = new JTabbedPane();
		panelesEmpleados.setBounds(0, 0, 1000, 600);
		
		altasPacientePanel = new AltasPacientePanel();
		
		panelesEmpleados.add("Altas", altasPacientePanel);
		bajasPacientePanel = new ListadoBajasPacientePanel();

		panelesEmpleados.add("Listado y Bajas", bajasPacientePanel);
		
		
		getContentPane().add(panelesEmpleados);
		
		
		/*
		btnSalir = new JButton("X");
		btnSalir.setBackground(UIManager.getColor("Button.background"));
		btnSalir.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 20));
		btnSalir.setBounds(891, 0, 63, 44);
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		getContentPane().add(btnSalir);
		
		if(btnSalir.isSelected()) {
			this.setVisible(false);
		}
		*/
	}
}
