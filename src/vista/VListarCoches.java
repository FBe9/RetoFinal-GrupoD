package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


//import modelo.Propietario;
import modelo.Coche;
import modelo.CochePropietarioControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Map;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VListarCoches extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnVerLosDatos;
	private JComboBox<String> cbLista;
	private Map<String, Coche> coches;

	private PVMain ventanaPrincipal;
	private CochePropietarioControlador datos;
	
	public VListarCoches(PVMain ven, boolean modal, CochePropietarioControlador datos) {
		super(ven);
		this.setModal(modal);
		setTitle("Listar coches");
		setBounds(100, 100, 582, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		ventanaPrincipal=ven;
		this.datos=datos;

		JLabel lblSeleccione = new JLabel("Seleccione un coche:");
		lblSeleccione.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSeleccione.setBounds(10, 74, 242, 20);
		contentPanel.add(lblSeleccione);

		cbLista = new JComboBox<>();
		cbLista.setSelectedIndex(-1);
		cbLista.setBounds(266, 75, 242, 26);
		contentPanel.add(cbLista);

		btnVerLosDatos = new JButton("Ver los datos del coche");
		btnVerLosDatos.setForeground(new Color(255, 0, 255));
		btnVerLosDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVerLosDatos.setBounds(128, 168, 293, 64);
		contentPanel.add(btnVerLosDatos);
		
		btnVerLosDatos.addActionListener(this);

		cargarCoches(datos);
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		if (accion.getSource().equals(btnVerLosDatos)){
			consultar(ventanaPrincipal,datos);
		}
	}
	
	protected void consultar(PVMain ven, CochePropietarioControlador datos) {
		//
			if (cbLista.getSelectedIndex()==-1)
				JOptionPane.showMessageDialog(this, "Selecciona un coche");
			else {
				String  cadena= (String) cbLista.getSelectedItem();
				int pos=cadena.indexOf(" ");
				String matricula = cadena.substring(0, pos);
	
				VCoche vent = new VCoche(ven, true, coches.get(matricula), datos);
				vent.setVisible(true);
				this.dispose();
			}	
	}

	private void cargarCoches(CochePropietarioControlador datos) {
		coches = datos.listarCoches();
		
		for (Coche coc : coches.values()) {
			cbLista.addItem(coc.getMatricula() +" "+ coc.getMarca());
		}
		cbLista.setSelectedIndex(-1);
		
	}
}