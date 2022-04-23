package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import panel.AltasPacientePanel;
import panel.ListadoBajasPacientePanel;

import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
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
		setUndecorated(true);
		setResizable(false);
		getContentPane().setLayout(null);
		
		iniciar();
		
	
	}
	
	private void iniciar() {
		panelesEmpleados  = new JTabbedPane();
		
		altasPacientePanel = new AltasPacientePanel();
		bajasPacientePanel = new ListadoBajasPacientePanel();
		
		panelesEmpleados.add("Altas", altasPacientePanel);
		panelesEmpleados.add("Listado y Bajas", bajasPacientePanel);
		
		add(panelesEmpleados);
		
	}
	
	
}
