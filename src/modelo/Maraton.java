package modelo;

import java.util.ArrayList;

public class Maraton {
	private Programador primero;
	private int numProgramador;
	/**
	 * Vector de equipos de la maratón
	 */
	private ArrayList<String> listaEquipos;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea una nueva maratón sin programadores y con una lista predefinida de
	 * equipos
	 */
	public Maraton() {
		primero = null;
		numProgramador = 0;

		listaEquipos = new ArrayList<String>();
		listaEquipos.add("Primero");
		listaEquipos.add("Segundo");
		listaEquipos.add("Tercero");
		listaEquipos.add("Cuarto");
		listaEquipos.add("Quinto");
		listaEquipos.add("Otro");
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el número de programadores de la maratón
	 * 
	 * @return El número de programadores de la maratón
	 */
	public int darNumeroProgramadores() {
		return numProgramador;
	}

	/**
	 * Adiciona un programador al principio de la lista
	 * 
	 * @param prog
	 *            El programador a ser agregado al comienzo de la lista. <br>
	 *            prog!=null y no existe un programador con código igual a
	 *            prog.codigo
	 */
	public void agregarProgramadorAlComienzo(Programador prog) {
		
	}

	/**
	 * Adiciona un programador al final de la lista. Si la lista está vacía el
	 * programador queda de primero 
	 * @param prog
	 *            El programador a ser agregado al final la lista. <br>
	 *            prog!=null y no existe un programador con código igual a
	 *            prog.codigo
	 */
	public void agregarProgramadorAlFinal(Programador prog) {
		// TODO
	}

	/**
	 * Adiciona un programador a la lista de programadores antes del programador con
	 * el código especificado. <br>
	 * <b> pre: </b> primero!= null. <br>
	 * 
	 * @param cod
	 *            El código del programador antes del que se va insertar el nuevo programador.
	 * @param prog
	 *            El programador que se va a adicionar. <br>
	 *            prog!=null y no existe un programador con código igual a prog.codigo
	 * @throws NoExisteException
	 *             Si el programador antes del que se va a realizar la adición no se
	 *             encuentra registrado.
	 */
	public void agregarProgramadorAntesDe(int cod, Programador prog) throws NoExisteException {
		// TODO
	}

	/**
	 * Adiciona un programador a la lista de programadores después del programador
	 * con el código especificado.
	 * 
	 * @param cod
	 *            El código del programador después del que se va insertar el nuevo programador.
	 * @param prog
	 *            El programador que se va a adicionar. <br>
	 *            prog!=null y no existe un programador con código igual a prog.codigo
	 * @throws NoExisteException
	 *             Si el programador después del que se va a realizar la adición no
	 *             se encuentra registrado.
	 */
	public void agregarProgramadorDespuesDe(int cod, Programador prog) throws NoExisteException {
		// TODO
	}

	/**
	 * Busca el programador con el código dado en la lista de programadores.
	 * 
	 * @param codigo
	 *            El código del programador que se va a buscar
	 * @return El programador con el código especificado. Si el programador no
	 *         existe se retorna null
	 */
	public Programador localizar(int codigo) {
		// TODO
		return null;
	}

	/**
	 * Busca el programador anterior al programador con el código especificado
	 * @param cod
	 *            Código del programador del que se desea el programador anterior
	 * @return El programador anterior al programador con el código dado. Se retorna
	 *         null si el programador con el código dado no existe o si es el
	 *         primero de la lista
	 */
	public Programador localizarAnterior(int cod) {
		// TODO
		return null;
	}

	/**
	 * Retorna el último programador de la lista
	 * 
	 * @return El último programador de la lista. Si la lista está vacía se retorna
	 *         null
	 */
	public Programador localizarUltimo() {
		// TODO
		return null;
	}

	/**
	 * Elimina el programador con el código especificado.
	 * @param cod
	 *            El código del programador a ser eliminado. cod >= 0
	 * @throws NoExisteException
	 *             Si el programador con el código especificado no existe y por
	 *             tanto no pudo ser eliminado de la lista
	 */
	public void eliminarProgramador(int cod) throws NoExisteException {
		// TODO
	}

	/**
	 * Devuelve una lista con los programadores de la maratón
	 * 
	 * @return Lista de Programadores
	 */
	public ArrayList<Programador> darProgramadores() {
		// TODO
		return null;
	}

	/**
	 * Retorna la lista de equipos manejadas por la maratón
	 * 
	 * @return La lista de equipos manejadas por la maratón
	 */
	public ArrayList<String> darListaEquipos() {
		return listaEquipos;
	}
}