package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import modelo.CochePropietarioControlador;
import modelo.Propietario;
import modelo.Coche;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class PVMain extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAltaP;
	private JButton btnConsultaP;
	private JButton btnAltaC;
	private JButton btnConsultaC;
	private CochePropietarioControlador datos;
	
	public PVMain(CochePropietarioControlador datos) {
		this.datos=datos;
		
		setResizable(false);
		setTitle("Ventana Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(299, 34, 2, 239);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 30, 279, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Propietarios");
		lblNewLabel.setBounds(0, 0, 279, 70);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 52));
		lblNewLabel.setForeground(new Color(165, 42, 42));
		panel.add(lblNewLabel);
		
		btnAltaP = new JButton("Alta");
		btnAltaP.setBounds(0, 121, 131, 122);
		panel.add(btnAltaP);
		btnAltaP.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnAltaP.setForeground(Color.BLUE);
		
		btnAltaP.addActionListener(this);
		
		btnConsultaP = new JButton("Consulta");
		btnConsultaP.setBounds(148, 121, 131, 122);
		panel.add(btnConsultaP);
		btnConsultaP.setForeground(new Color(46, 139, 87));
		btnConsultaP.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		btnConsultaP.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(321, 30, 279, 243);
		contentPane.add(panel_1);
		
		JLabel lblCoches = new JLabel("Coches");
		lblCoches.setBounds(43, 0, 178, 70);
		panel_1.add(lblCoches);
		lblCoches.setForeground(new Color(210, 105, 30));
		lblCoches.setFont(new Font("Sylfaen", Font.PLAIN, 52));
		
		btnAltaC = new JButton("Alta");
		btnAltaC.setBounds(0, 121, 131, 122);
		panel_1.add(btnAltaC);
		btnAltaC.setForeground(Color.BLUE);
		btnAltaC.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		btnAltaC.addActionListener(this);
		
		btnConsultaC = new JButton("Consulta");
		btnConsultaC.setBounds(148, 121, 131, 122);
		panel_1.add(btnConsultaC);
		btnConsultaC.setForeground(new Color(46, 139, 87));
		btnConsultaC.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		btnConsultaC.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAltaP)){
			altaPropietario(datos);
		}
		if (e.getSource().equals(btnConsultaP)){
			consultaPropietario(datos);
		}
		if (e.getSource().equals(btnAltaC)){
			altaCoche(datos);
		}
		if (e.getSource().equals(btnConsultaC)){
			consultaCoche(datos);
		}
		
	}

	private void altaPropietario(CochePropietarioControlador datos) {
		Propietario prop=null;
		PVGestion pVGestion=new PVGestion(this,true,prop,datos);
		pVGestion.setVisible(true);
		
	}
	
	private void consultaPropietario(CochePropietarioControlador datos) {
		PVConsulta pVConsulta=new PVConsulta(this,true,datos);
		pVConsulta.setVisible(true);
		
	}
	protected void altaCoche(CochePropietarioControlador datos) {
		Coche coche = null;
		VCoche ventAlta = new VCoche(this, true, coche, datos);
		ventAlta.setVisible(true);	
	}
	
	protected void consultaCoche(CochePropietarioControlador datos) {
		VListarCoches ventConsulta = new VListarCoches(this, true, datos);
		ventConsulta.setVisible(true);	
	}




}
