package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Propietario;
import modelo.Coche;
import modelo.CochePropietarioControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
//import java.awt.event.FocusAdapter;
//import java.awt.event.FocusEvent;
import java.util.Set;

import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

public class VCoche extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Set <Propietario> propietarios;

	private final JPanel contentPanel = new JPanel();
	private JTextField textMatricula;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textEdad;
	private JTextField textPrecio;
	private JComboBox <String> cbPropietarios;
	private JButton btnAlta;
	private JButton btnBaja;
	private JButton btnModificacion;
	
	private CochePropietarioControlador datos;

	
	public VCoche(PVMain ven, boolean modal, Coche coche, CochePropietarioControlador datos) {
		super(ven);
		this.setModal(modal);
		setTitle("Coche");
		setBounds(100, 100, 546, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		this.datos=datos;
		
		JLabel lblNewLabel = new JLabel("Matr\u00EDcula");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(24, 48, 95, 31);
		contentPanel.add(lblNewLabel);
		

		textMatricula = new JTextField();
		//En el caso de alta tengo que comprobar que no exista otro Propietario con ese id
			if (coche==null) { 
					comprobarId(datos);
			}

		textMatricula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textMatricula.setBounds(129, 51, 162, 28);
		contentPanel.add(textMatricula);
		textMatricula.setColumns(10);

		JLabel lblNombre = new JLabel("Marca");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(24, 90, 95, 31);
		contentPanel.add(lblNombre);

		textMarca = new JTextField();
		textMarca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textMarca.setColumns(10);
		textMarca.setBounds(129, 93, 162, 28);
		contentPanel.add(textMarca);

		JLabel lblFecha = new JLabel("Modelo");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFecha.setBounds(24, 132, 95, 31);
		contentPanel.add(lblFecha);

		textModelo = new JTextField();
		textModelo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textModelo.setColumns(10);
		textModelo.setBounds(129, 135, 162, 28);
		contentPanel.add(textModelo);

		btnAlta = new JButton("Alta");
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlta.setForeground(new Color(148, 0, 211));
		btnAlta.setBounds(312, 48, 146, 23);
		contentPanel.add(btnAlta);
		
		btnAlta.addActionListener(this);

		btnBaja = new JButton("Baja");
		btnBaja.setForeground(new Color(148, 0, 211));
		btnBaja.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBaja.setBounds(312, 95, 146, 23);
		contentPanel.add(btnBaja);
		
		btnBaja.addActionListener(this);

		btnModificacion = new JButton("Modificaci\u00F3n");
		btnModificacion.setForeground(new Color(148, 0, 211));
		btnModificacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModificacion.setBounds(312, 137, 146, 23);
		contentPanel.add(btnModificacion);
		
		btnModificacion.addActionListener(this);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEdad.setBounds(24, 174, 95, 31);
		contentPanel.add(lblEdad);

		textEdad = new JTextField();
		textEdad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textEdad.setColumns(10);
		textEdad.setBounds(129, 177, 162, 28);
		contentPanel.add(textEdad);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setBounds(24, 216, 95, 31);
		contentPanel.add(lblPrecio);

		textPrecio = new JTextField();
		textPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPrecio.setColumns(10);
		textPrecio.setBounds(129, 219, 162, 28);
		contentPanel.add(textPrecio);

		JLabel lblPropietario = new JLabel("Propietario:");
		lblPropietario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPropietario.setBounds(24, 264, 118, 20);
		contentPanel.add(lblPropietario);

		cbPropietarios = new JComboBox<>();
		cbPropietarios.setSelectedIndex(-1);
		cbPropietarios.setBounds(129, 262, 242, 28);
		contentPanel.add(cbPropietarios);
		
		cargarPropietarios(datos);

		if (coche == null) {
			btnBaja.setEnabled(false);
			btnModificacion.setEnabled(false);
		} else {
			textMatricula.setText(coche.getMatricula());
			textMatricula.setEnabled(false);
			textMarca.setText(coche.getMarca());
			textModelo.setText(coche.getModelo());
			textEdad.setText(Integer.toString(coche.getEdad()));
			textPrecio.setText(Double.toString(coche.getPrecio()));
			btnAlta.setEnabled(false);
			
			//Cargamos los propietarios en un array porque las claves de cada propietario no se corresponden con la
			//posición que ocupan en la colección y por tanto el orden en el que se visualizan en el combo.
			Propietario[] propietariosArray = new Propietario[propietarios.size()];
			propietarios.toArray(propietariosArray);
			for (int i=0;i<propietariosArray.length;i++){
				if (propietariosArray[i].getId().equalsIgnoreCase(coche.getIdPropietario())) {
					cbPropietarios.setSelectedIndex(i);
					return;
				}
			}
			btnAlta.setEnabled(false);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		if (a.getSource().equals(btnAlta)){
			alta(datos);
		}
		if (a.getSource().equals(btnBaja)){
			baja(datos);
		}
		if (a.getSource().equals(btnModificacion)){
			modificacion(datos);
		}
		
	}

	protected void comprobarId(CochePropietarioControlador datos) {
		//Comprobamos al dar de alta que no haya otro Propietario con el mismo Id
		if(datos.buscarCoche(textMatricula.getText())!=null) {
			JOptionPane.showMessageDialog(this, "Ya existe un coche con esta matrícula");
			textMatricula.setText("");
		}	
	}
	
	private void cargarPropietarios(CochePropietarioControlador datos) {
		propietarios = datos.listarPropietarios();
		
		for (Propietario pro : propietarios) {
			cbPropietarios.addItem(pro.getId() + " " + pro.getNombre());
		}
		cbPropietarios.setSelectedIndex(-1);	
	}

	protected void modificacion(CochePropietarioControlador datos) {
		//
		Coche coc = leerDatosPantalla(textMatricula.getText());
		
		//La matrícula no cambia en la modificación
		datos.modificarCoche(coc);

		//
		JOptionPane.showMessageDialog(this, "Coche modificado con exito");
	}

	//
	protected void baja(CochePropietarioControlador datos) {
		Coche coc = leerDatosPantalla(textMatricula.getText());

		datos.eliminarCoche(coc);
		JOptionPane.showMessageDialog(this, "Coche borrado con exito");
		
		limpiarPantalla();		
	}

	protected void alta(CochePropietarioControlador datos) {
		
		Coche coc = leerDatosPantalla(textMatricula.getText());
		
		//Modificar para comprobar si ya existe ese coche
		datos.altaCoche(coc);
		JOptionPane.showMessageDialog(this, "Coche dado de alta");
		
		limpiarPantalla();
	}

	private Coche leerDatosPantalla(String matricula) {
		//
		Coche coche = new Coche();
		coche.setMatricula(matricula);
		coche.setMarca(textMarca.getText());
		coche.setModelo(textModelo.getText());
		coche.setEdad(Integer.parseInt(textEdad.getText()));
		coche.setPrecio(Double.parseDouble(textPrecio.getText()));

		// Propietario
		String cadena = (String) cbPropietarios.getSelectedItem();
		int pos = cadena.indexOf(" ");
		String id = cadena.substring(0, pos);
		coche.setIdPropietario(id);
		
		return coche;
	}
	
	private void limpiarPantalla() {
		// 
		textMatricula.setText("");
		textMarca.setText("");
		textModelo.setText("");
		textEdad.setText("");
		textPrecio.setText("");
		cbPropietarios.setSelectedIndex(-1);
	}

	
}

