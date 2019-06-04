package modelo;
/**
 * Esta clase representa un programador <br>
 * codigo >= 0 <br>
 * nombre != null && nombre != "" <br>
 * equipo != null && equipo != "" <br>
 * informacionLenguaje != null <br>
 * sexo == HOMBRE o sexo == MUJER
 */
public class Programador {
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	/**
	 * Constante para representar a un Hombre
	 */
	public final static int HOMBRE = 1;

	/**
	 * Constante para representar a una mujer
	 */
	public final static int MUJER = 2;
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * El c�digo del programador
	 */
	private int codigo;
	/**
	 * El nombre del programador
	 */
	private String nombre;
	/**
	 * Equipo al que pertenece el programador
	 */
	private String equipo;
	/**
	 * La informaci�n del lenguaje preferido del programador
	 */
	private String informacionLenguaje;
	/**
	 * Sexo del programador
	 */
	private int sexo;
	/**
	 * El siguiente programador de la lista
	 */
	private Programador siguiente;
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	/**
	 * Construye un programador
	 * 
	 * @param cod
	 *            El c�digo del programador - cod >= 0
	 * @param nom
	 *            El nombre del programador - nom!=null y nom!=""
	 * @param equi
	 *            El equipo del programador - equi!=null y equi!=""
	 * @param infoLeng
	 *            la informaci�n m�dica del programador - infoLeng!=null
	 * @param sex
	 *            El sexo del programador. sex pertenece a { HOMBRE, MUJER }
	 */
	public Programador(int cod, String nom, String equi, String infoLeng, int sex) {
		codigo = cod;
		nombre = nom;
		equipo = equi;
		informacionLenguaje = infoLeng;
		sexo = sex;
		siguiente = null;

		verificarInvariante();
	}
	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------
	/**
	 * Retorna el c�digo del programador
	 * 
	 * @return El c�digo del programador
	 */
	public int darCodigo() {
		return codigo;
	}
	/**
	 * Retorna el nombre del programador
	 * 
	 * @return El nombre del programador
	 */
	public String darNombre() {
		return nombre;
	}
	/**
	 * Retorna el equipo asignado al programador
	 * 
	 * @return El equipo asignado al programador
	 */
	public String darEquipo() {
		return equipo;
	}
	/**
	 * Retorna la informaci�n del lenguaje de programaci�n del programador
	 * 
	 * @return La informaci�n del lenguaje de programaci�n del programador
	 */
	public String darInformacionLenguaje() {
		return informacionLenguaje;
	}
	/**
	 * Retorna el sexo del programador
	 * 
	 * @return El sexo del programador
	 */
	public int darSexo() {
		return sexo;
	}
	/**
	 * Retorna el siguiente programador de la lista
	 * 
	 * @return El siguiente programador de la lista
	 */
	public Programador darSiguiente() {
		return siguiente;
	}
	/**
	 * Cambia el programador que le sigue al actual
	 * 
	 * @param prog
	 *            Programador siguiente al actual
	 */
	public void cambiarSiguiente(Programador prog) {
		siguiente = prog;
	}
	/**
	 * Desconecta el programador que le sigue en la lista al programador actual.
	 * <br>
	 * <b>pre: </b> No es el �ltimo programador de la lista <br>
	 * <b>post: </b> El programador siguiente al actual fue desconectado de la
	 * lista.
	 */
	public void desconectarSiguiente() {
		siguiente = siguiente.siguiente;
	}
	/**
	 * Inserta el programador despu�s del actual. <br>
	 * <b>post: </b> Se insert� el programador especificado despu�s del programador
	 * actual. <br>
	 * 
	 * @param prog
	 *            El programador a insertar - elProgramador!=null
	 */
	public void insertarDespues(Programador prog) {
		prog.siguiente = siguiente;
		siguiente = prog;
	}
	/**
	 * Retorna una cadena con la informaci�n del programador
	 * 
	 * @return [ codigo ]: nombre
	 */
	public String toString() {
		return "[ " + codigo + " ]: " + nombre;
	}
	/**
	 * Cambia la informaci�n del lenguaje de programaci�n del programador
	 * 
	 * @param informacion
	 *            Nueva informaci�n del lenguaje de programaci�n del programador
	 */
	public void cambiarInformacionLenguaje(String informacion) {
		informacionLenguaje = informacion;
	}
	// -----------------------------------------------------------------
	// Invariante
	// -----------------------------------------------------------------
	/**
	 * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un
	 * AssertError. <br>
	 * <b>inv: </b> <br>
	 * codigo >= 0 nombre != null <br>
	 * nombre != "" equipo != null <br>
	 * equipo != "" <br>
	 * informacionLenguaje != null <br>
	 * sexo == HOMBRE o sexo == MUJER
	 */
	private void verificarInvariante() {
		assert codigo >= 0 : "C�digo inv�lido";
		assert nombre != null && !nombre.equals("") : "Nombre inv�lido";
		assert equipo != null && !equipo.equals("") : "Equipo inv�lida";
		assert informacionLenguaje != null : "Informaci�n del lenguaje de programaci�n inv�lida";
		assert sexo == HOMBRE || sexo == MUJER : "Valor inv�lido para el atributo sexo";
	}
}