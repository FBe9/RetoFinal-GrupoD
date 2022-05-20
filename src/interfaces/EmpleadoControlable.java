package interfaces;

import java.util.ArrayList;

import clases.*;
import exceptions.CreateSqlException;

/**
 * Esta es la interfaz que declara los metodos que tendran las clases relacionadas con Empleados que lo implementen
 * 
 * @author Nerea
 *
 */
public interface EmpleadoControlable {
	/**
	 * Busca un objeto de tipo Empleado y te lo devuelve.
	 * 
	 * @param auxCodEmpleado El codigo del empleado
	 * @return un objeto Empleado con los datos del empleado
	 */
	public Empleado buscarEmpleado(String codEmple) throws CreateSqlException;

	/**
	 * Busca un objeto de tipo Contrato y te lo devuelve
	 * 
	 * @param auxCodEmpleado El codigo del empleado y auxCodContrato El codigo del
	 *                       contrato
	 * @return un objeto Contrato con los datos del contrato
	 */
	public Contrato buscarContrato(String auxCodEmpleado) throws CreateSqlException;

	/**
	 * Busca en las tablas de Doctor y Enfermero y trae una especialidad o un
	 * horario
	 * 
	 * @param auxCodEmpleado EL codigo del empleado
	 * @return especialidad u horario dependiendo del tipo del empleado
	 */
	public String buscarEspecialidadHorario(String auxCodEmpleado) throws CreateSqlException;

	/**
	 * Busca los 3 tipos de contrato que hay y los vuelca a un ArrayList para poder
	 * usarlos en un comboBox
	 * 
	 * @return devuelve un ArrayList de Strings con los valores de tipo de contrato
	 *         cargados
	 */
	public ArrayList<String> buscarTipoContrato() throws CreateSqlException;

	/**
	 * Busca los codigos de departamento registrados y los vuelca a un ArrayList
	 * para poder usarlos en un comboBox
	 * 
	 * @return devuelve un ArrayList de Strings con los valores de los codigos de
	 *         cada departamento registrado
	 */
	public ArrayList<String> buscarCodDepartamentos() throws CreateSqlException;

	/**
	 * Busca los 5 tipos de especialidades que hay por cada departamento y los
	 * vuelca a un ArrayList para poder usarlos en un comboBox
	 * 
	 * @param departamento El codigo del departamento
	 * @return devuelve un ArrayList de Strings con los valores de las
	 *         especialidades dependendo del departamento
	 */
	public ArrayList<String> buscarEspecialidades(String auxCodDepart) throws CreateSqlException;

	/**
	 * Busca los 2 tipos de horarios que hay y los vuelca a un ArrayList para poder
	 * usarlos en un comboBox
	 * 
	 * @return devuelve un ArrayList de Strings con los valores de los horarios
	 */
	public ArrayList<String> buscarHorarios() throws CreateSqlException;

	/**
	 * Introduce un Empleado nuevo a la base de datos
	 * 
	 * @param emple Un objeto de tipo Empleado, contrato Un objeto de tipo Contrato
	 *              y espHora El atributo que guarda una especialidad o un horario
	 */
	public void altaEmpleado(Empleado emple, Contrato contrato, String espeHora) throws CreateSqlException;

	/**
	 * Busca los empleados registrados y los vuelca a un ArrayList para poder
	 * usarlos en una tabla
	 * 
	 * @return un ArrayList de tipo Empleado
	 */
	public ArrayList<Empleado> listarEmpleadosTabla() throws CreateSqlException;

	/**
	 * Cambia valores de un Empleado previamente registrado en la base de datos
	 * 
	 * @param emple Un objeto de tipo Empleado y contrato Un objeto de tipo Contrato
	 * @return un boolean para comprobar si se ha modificado
	 */
	public boolean modificarEmpleado(Empleado emple, Contrato contrato, String espeHora) throws CreateSqlException;

	/**
	 * Elimina un Empleado existente de la base de datos cambiando su atributo
	 * activeEmploye a false
	 *
	 * @param emple Un objeto de tipo Empleado y auxCodEmple El codigo del empleado
	 * @return un boolean para comprobar si se ha modificado
	 */
	public boolean eliminarEmpleado(Empleado emple, String auxCodEmpleado) throws CreateSqlException;

	/**
	 * Te conecta a la aplicacion y comprueba tu tipo para abrir las ventanas de
	 * administrador o empleados despues
	 *
	 * @param codigoDelUsuario El codigo del empleado y contrasenaDelUsuario
	 *                         contrasenia del usuario
	 * @return un objeto de tipo Empleado
	 */
	public Empleado loginUsuario(String codigoDelUsuario, String contrasenaDelUsuario) throws CreateSqlException;

}