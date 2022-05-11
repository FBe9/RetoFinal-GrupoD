package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import modelo.Coche;
import modelo.Propietario;
import modelo.CochePropietarioControlador;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;

public class PVGestion extends JDialog implements ActionListener, FocusListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JButton btnAlta;
	private JButton btnBaja;
	private JButton btnModificacion;
	private CochePropietarioControlador datos;
	
	private Propietario propietario;
	private JTable table;
	private JScrollPane scrollPane;

	public PVGestion(PVMain pvMain, boolean b, Propietario prop, CochePropietarioControlador datos) {
		super(pvMain);
		setModal(b);
		this.datos=datos;
		
		propietario=prop;
		
		setTitle("Propietario");
		setBounds(100, 100, 656, 410);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(24, 48, 49, 31);
		contentPanel.add(lblNewLabel);
		
		
		txtId = new JTextField();
		txtId.setBounds(107, 54, 162, 20);
		contentPanel.add(txtId);
		txtId.setColumns(10);
		txtId.addFocusListener(this);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(24, 90, 95, 31);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(107, 96, 162, 20);
		contentPanel.add(txtNombre);
		
		JLabel lblFecha = new JLabel("Tel\u00E9fono");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(24, 132, 95, 31);
		contentPanel.add(lblFecha);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(107, 138, 162, 20);
		contentPanel.add(txtTelefono);
		
		btnAlta = new JButton("Alta");
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlta.setBounds(461, 48, 146, 23);
		contentPanel.add(btnAlta);
		btnAlta.addActionListener(this);
		
		btnBaja = new JButton("Baja");
		btnBaja.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBaja.setBounds(461, 93, 146, 23);
		contentPanel.add(btnBaja);
		btnBaja.addActionListener(this);
		
		btnModificacion = new JButton("Modificaci\u00F3n");
		btnModificacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModificacion.setBounds(461, 138, 146, 23);
		btnModificacion.addActionListener(this);
		
		contentPanel.add(btnModificacion);
		
		
		
		if (prop==null){
			btnBaja.setEnabled(false);
			btnModificacion.setEnabled(false);
		}
		else{
			txtId.setText(prop.getId());
			txtId.setEditable(false);
			txtNombre.setText(prop.getNombre());
			txtTelefono.setText(prop.getTelefono());
			btnAlta.setEnabled(false);
			ArrayList <Coche> coches=datos.listarCochesPropietario(prop.getId());
			if (coches.size()>0){
				String matrizTabla[][] = new String[coches.size()][5];
				for(int i=0; i<coches.size(); i++) {
					
					matrizTabla[i][0] = coches.get(i).getMatricula();
					matrizTabla[i][1] = coches.get(i).getMarca();
					matrizTabla[i][2] = coches.get(i).getModelo();
					matrizTabla[i][3] = String.valueOf(coches.get(i).getPrecio())+"\u20ac";
					matrizTabla[i][4] = String.valueOf(coches.get(i).getEdad());
					
				}
				
				
				scrollPane = new JScrollPane();
				scrollPane.setBounds(24, 209, 583, 121);
				contentPanel.add(scrollPane);
				
				String titulos[] = {"Matricula", "Marca", "Modelo", "Precio", "Edad"};
				table = new JTable(matrizTabla,  titulos);
				table.setSelectionBackground(new Color(0, 230, 168));
				table.setSelectionForeground(Color.WHITE);
				table.setRowMargin(0);
				table.setRowHeight(25);
				table.setShowVerticalLines(false);
				table.setFont(new Font("Tahoma", Font.PLAIN, 12));
				scrollPane.setViewportView(table);
				
				JTableHeader tableHeader = table.getTableHeader();
				tableHeader.setBackground(new Color(0, 191, 140));
				tableHeader.setForeground(Color.WHITE);
				tableHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
				tableHeader.setBorder(null);
				tableHeader.setEnabled(false);
			}
		
		else{
			JOptionPane.showMessageDialog(this, "Propietario sin coches");
		}
			
			
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAlta)){
			alta(datos);
		}
		if(e.getSource().equals(btnBaja)){
			baja(datos);
		}
		if (e.getSource().equals(btnModificacion)){
			modificacion(datos);
		}
		
	}

	protected void comprobarId(CochePropietarioControlador datos) {
		//Comprobamos al dar de alta que no haya otro Propietario con el mismo Id
		if(datos.buscarPropietario(txtId.getText())!=null) {
			JOptionPane.showMessageDialog(this, "Ya existe un propietario con este Id");
			txtId.setText("");
			//Esto lo pongo porque el foco se pierde 
			txtNombre.transferFocus();
		}	
	}
	private void modificacion(CochePropietarioControlador datos) {
		Propietario prop=cargarProp();
		if (datos.modificarPropietario(prop))
			JOptionPane.showMessageDialog(this, "Propietario modificado correctamente", "MODIFICACION CORRECTA", JOptionPane.OK_OPTION);
		else
			JOptionPane.showMessageDialog(this, "Error, modificación no realizada", "FATAL ERROR", JOptionPane.WARNING_MESSAGE);
		limpiar();
	}

	private void baja(CochePropietarioControlador datos) {
		datos.eliminarPropietario(cargarProp());
		JOptionPane.showMessageDialog(this, "Propietario borrado correctamente", "Borrado CORRECTO", JOptionPane.OK_OPTION);
		limpiar();
	}

	private Propietario cargarProp() {
		Propietario prop=new Propietario();
		prop.setId(txtId.getText());
		prop.setNombre(txtNombre.getText());
		prop.setTelefono(txtTelefono.getText());
		return prop;
	}
	private void alta(CochePropietarioControlador datos) {
		if (txtId.getText().isEmpty()||txtNombre.getText().isEmpty()||txtTelefono.getText().isEmpty()){
			JOptionPane.showMessageDialog(this, "Error, falta algún dato por rellenar", "FATAL ERROR", JOptionPane.WARNING_MESSAGE);
		}
		else{
			Propietario aux=datos.buscarPropietario(txtId.getText());
			if (aux==null){
				aux=new Propietario();
				aux.setId(txtId.getText());
				aux.setNombre(txtNombre.getText());
				aux.setTelefono(txtTelefono.getText());
				datos.addPropietario(aux);
				JOptionPane.showMessageDialog(this, "Propietario dado de alta correctamente");
				limpiar();
			}
			else{
				JOptionPane.showMessageDialog(this, "Error, el propietario ya existe", "Usuario duplicado", JOptionPane.WARNING_MESSAGE);
				limpiar();
			}
		}
		
	}

	private void limpiar() {
		txtId.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		
	}

	@Override
	public void focusGained(FocusEvent f) {
		
		
	}

	@Override
	public void focusLost(FocusEvent f) {
		if (f.getSource().equals(txtId)){
			if (propietario==null){
				if (datos.buscarPropietario(txtId.getText())!=null){
					JOptionPane.showMessageDialog(this,  "El propietario ya existe");
					limpiar();
					txtId.requestFocus();
					
				}
			}
		}
		
	}
}
