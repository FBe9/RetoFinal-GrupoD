package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;

import modelo.Propietario;
import modelo.CochePropietarioControlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.Set;

public class PVConsulta extends JDialog implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> cbxPropietarios;
	private JButton btnVerDatos;
	private CochePropietarioControlador datos;
	private PVMain ventanaPrincipal;
	
	public PVConsulta(PVMain pvMain, boolean b, CochePropietarioControlador datos) {
		super(pvMain);
		setModal(b);
		setTitle("Propietarios");
		setBounds(100, 100, 724, 487);
		getContentPane().setLayout(null);
		
		this.datos=datos;
		ventanaPrincipal=pvMain;
		
		JLabel lblPropietario = new JLabel("Elige el propietario");
		lblPropietario.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPropietario.setBounds(37, 80, 179, 54);
		getContentPane().add(lblPropietario);
		
		cbxPropietarios = new JComboBox <>();
		cbxPropietarios.setBounds(258, 100, 413, 34);
		getContentPane().add(cbxPropietarios);
		
		btnVerDatos = new JButton("Ver datos propietario");
		btnVerDatos.setFont(new Font("Tahoma", Font.ITALIC, 19));
		btnVerDatos.setBounds(120, 296, 450, 60);
		getContentPane().add(btnVerDatos);
		btnVerDatos.addActionListener(this);
		
		cargarPropietarios(datos);
	}
	
	private void cargarPropietarios(CochePropietarioControlador datos) {
		Set <Propietario> propietarios=datos.listarPropietarios();
		Iterator<Propietario> iterProp=propietarios.iterator();
		while (iterProp.hasNext()){
			Propietario aux=iterProp.next();
			cbxPropietarios.addItem(aux.getId()+" "+ aux.getNombre());
		}
		cbxPropietarios.setSelectedIndex(-1);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getSource().equals(btnVerDatos)){
			consultar(ventanaPrincipal,datos);
		}
	}
	
	private void consultar(PVMain pvMain, CochePropietarioControlador datos) {
		if (cbxPropietarios.getSelectedIndex()==-1){
			JOptionPane.showMessageDialog(this, "Selecciona un propietario");
		}
		else{
			String seleccionado, id;
			seleccionado=cbxPropietarios.getSelectedItem().toString();
			int posicion=seleccionado.indexOf(" ");
			id=seleccionado.substring(0, posicion);
			
			Propietario prop=datos.buscarPropietario(id);
			PVGestion pvGestion=new PVGestion(pvMain,true,prop, datos);
			pvGestion.setVisible(true);
			this.dispose();
		}
		
	}
}
