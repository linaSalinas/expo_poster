package modelo;
import java.util.ArrayList;
import junit.framework.TestCase;
import modelo.Maraton;
import modelo.NoExisteException;
import modelo.Programador;
/**
 * Esta es la clase usada para verificar que los m�todos de la clase Maraton
 * est�n correctamente implementados
 */
public class MaratonTest extends TestCase {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Es la clase donde se har�n las pruebas
	 */
	private Maraton maraton;

	/**
	 * El n�mero de programadores a manejar en cada prueba
	 */
	private int numeroProgramadores;

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Construye una nueva Marat�n vac�o
	 * 
	 */
	private void setupEscenario1() {
		maraton = new Maraton();
		numeroProgramadores = 0;

	}

	/**
	 * Construye una nueva marat�n con 10 programadores
	 * 
	 */
	private void setupEscenario2() {
		maraton = new Maraton();
		numeroProgramadores = 10;
		for (int cont = 0; cont < numeroProgramadores; cont++) {
			maraton.agregarProgramadorAlComienzo(new Programador(cont, "nombre" + cont, "Noveno" + cont,
					"Java" + cont, Programador.HOMBRE));
		}
	}

	/**
	 * Construye una nueva Marat�n con 10 programadores
	 * 
	 */
	private void setupEscenario3() {
		maraton = new Maraton();
		numeroProgramadores = 10;
		for (int cont = 0; cont < numeroProgramadores; cont++) {
			maraton.agregarProgramadorAlFinal(new Programador(cont, "nombre" + cont, "Decimo" + cont,
					"Java" + cont, Programador.HOMBRE));
		}
	}

	/**
	 * Prueba la adici�n de programadores. <br>
	 * <b> M�todos a probar: </b> <br>
	 * darProgramadores, agregarProgramadorAlComienzo. <br>
	 * <b> Objetivo: </b> probar que el m�todo agregarProgramadorAlComienzo() agrega
	 * correctamente programadores a la lista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al agregar un programador en una marat�n sin programadores este debe ser
	 * insertado sin errores. <br>
	 * 2. Al agregar un programador 'A' al comienzo de la lista este debe quedar de
	 * primero y no se debe perder ninguno de los programadores previamente agregados.
	 * <br>
	 */
	public void testAgregarProgramadorAlComienzo() {
		setupEscenario1();
		numeroProgramadores = 11;
		ArrayList<Programador> programadores = new ArrayList<Programador>();
		Programador programador;
		Programador aux;
		for (int cont = 0; cont < numeroProgramadores; cont++) {
			programador = new Programador(cont, "nombre" + cont, "Segundo" + cont,
					"la informaci�n del lenguaje del programaci�n " + cont, Programador.MUJER);
			programadores.add(programador);
		}
		// Agrega los programadores y verifica que se hayan agregado correctamente
		for (int cont = 0; cont < numeroProgramadores; cont++) {
			programador = (Programador) programadores.get(cont);
			maraton.agregarProgramadorAlComienzo(new Programador(programador.darCodigo(), programador.darNombre(),
					programador.darEquipo(), programador.darInformacionLenguaje(), programador.darSexo()));
			ArrayList<Programador> losProgramadores = maraton.darProgramadores();
			aux = (Programador) losProgramadores.get(0);

			// Verifica que la informaci�n sea correcta
			assertEquals("La adici�n no se realiz� correctamente", programador.darCodigo(), aux.darCodigo());
			assertEquals("La adici�n no se realiz� correctamente", programador.darEquipo(), aux.darEquipo());
			assertEquals("La adici�n no se realiz� correctamente", programador.darInformacionLenguaje(),
					aux.darInformacionLenguaje());
			assertEquals("La adici�n no se realiz� correctamente", programador.darNombre(), aux.darNombre());
			assertEquals("La adici�n no se realiz� correctamente", programador.darSexo(), aux.darSexo());

			// Verifica que el n�mero de programadores en la lista sea el correcto
			assertEquals("El n�mero de programadores no es el correcto", cont + 1, losProgramadores.size());
		}
	}

	/**
	 * Prueba la adici�n de programadores. <br>
	 * <b> M�todos a probar: </b> <br>
	 * darProgramadores, agregarProgramadorAlFinal. <br>
	 * <b> Objetivo: </b> probar que el m�todo agregarProgramadorAlFinal() agrega
	 * correctamente programadores a la lista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al agregar un programador en una marat�n sin programadores este debe ser
	 * insertado sin errores. <br>
	 * 2. Al agregar un programador 'A' al final de la lista este debe quedar de �ltimo
	 * y no se debe perder ninguno de los programadores previamente agregados. <br>
	 */
	public void testAgregarProgramadorAlFinal() {
		setupEscenario1();
		numeroProgramadores = 11;
		ArrayList<Programador> programadores = new ArrayList<Programador>();
		Programador programador;
		Programador aux;
		for (int cont = 0; cont < numeroProgramadores; cont++) {
			programador = new Programador(cont, "nombre programador" + cont, "Cuearto" + cont,
					"la informaci�n del lenguaje del programaci�n " + cont, Programador.HOMBRE);
			programadores.add(programador);
		}
		// Agrega los programadores y verifica que se hayan agregado correctamente

		for (int cont = 0; cont < numeroProgramadores; cont++) {
			programador = (Programador) programadores.get(cont);
			maraton.agregarProgramadorAlFinal(new Programador(programador.darCodigo(), programador.darNombre(),
					programador.darEquipo(), programador.darInformacionLenguaje(), programador.darSexo()));
			ArrayList<Programador> losProgramadores = maraton.darProgramadores();
			aux = (Programador) losProgramadores.get(cont);

			// Verifica que la informaci�n sea correcta
			assertEquals("La adici�n no se realiz� correctamente", programador.darCodigo(), aux.darCodigo());
			assertEquals("La adici�n no se realiz� correctamente", programador.darEquipo(), aux.darEquipo());
			assertEquals("La adici�n no se realiz� correctamente", programador.darInformacionLenguaje(),
					aux.darInformacionLenguaje());
			assertEquals("La adici�n no se realiz� correctamente", programador.darNombre(), aux.darNombre());
			assertEquals("La adici�n no se realiz� correctamente", programador.darSexo(), aux.darSexo());

			// Verifica que el n�mero de programadores en la lista sea el correcto
			assertEquals("El n�mero de programadores no es el correcto", cont + 1, losProgramadores.size());
		}

	}

	/**
	 * Prueba la adici�n de programadores. <br>
	 * <b> M�todos a probar: </b> <br>
	 * agregarProgramadorAntesDe, localizar, agregarProgramadorAlComienzo. <br>
	 * <b> Objetivo: </b> probar que el m�todo agregarProgramadorAntesDe() agrega
	 * correctamente programadores a la lista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al agregar un programador en una marat�n sin programadores este debe ser
	 * insertado sin errores. <br>
	 * 2. Al agregar un programador 'A' antes de un programador 'B' previamente
	 * adicionado, el programador 'A' debe quedar antes del programador 'B' en la lista.
	 * <br>
	 * 3. Al agregar un programador este debe quedar registrado en el marat�n
	 */
	public void testAgregarProgramadorAntesDe() {
		setupEscenario1();
		numeroProgramadores = 11;
		ArrayList<Programador> programadores = new ArrayList<Programador>();
		Programador programador;
		Programador aux;
		for (int cont = 0; cont < numeroProgramadores; cont++) {
			programador = new Programador(cont, "nombre" + cont, "Equipo" + cont, "Java" + cont,
					Programador.HOMBRE);
			programadores.add(programador);
		}

		// Se agrega el primer programador a la maraton para tener un elementos antes del
		// cual agregar
		programador = (Programador) programadores.get(0);
		maraton.agregarProgramadorAlComienzo(new Programador(programador.darCodigo(), programador.darNombre(),
				programador.darEquipo(), programador.darInformacionLenguaje(), programador.darSexo()));
		// Agrega los programadores y verifica que se hayan agregado correctamente
		// busc�ndolos
		int ced = 0;

		try {
			for (int cont = 1; cont < numeroProgramadores - 1; cont++) {
				programador = (Programador) programadores.get(cont);
				maraton.agregarProgramadorAntesDe(ced, new Programador(programador.darCodigo(), programador.darNombre(),
						programador.darEquipo(), programador.darInformacionLenguaje(), programador.darSexo()));
				aux = maraton.localizar(programador.darCodigo());

				// Verifica que la informaci�n sea correcta
				assertEquals("La adici�n no se realiz� correctamente", programador.darCodigo(), aux.darCodigo());
				assertEquals("La adici�n no se realiz� correctamente", programador.darEquipo(), aux.darEquipo());
				assertEquals("La adici�n no se realiz� correctamente", programador.darInformacionLenguaje(),
						aux.darInformacionLenguaje());
				assertEquals("La adici�n no se realiz� correctamente", programador.darNombre(), aux.darNombre());
				assertEquals("La adici�n no se realiz� correctamente", programador.darSexo(), aux.darSexo());
				ced = programador.darCodigo();
			}

			// Se verifica que los programadores hayan sido ingresados en el orden correcto
			ArrayList<Programador> programadoresMaraton = maraton.darProgramadores();

			for (int cont = 0; cont < numeroProgramadores - 1; cont++) {
				programador = (Programador) programadoresMaraton.get(cont);
				assertEquals("La adici�n no se realiz� correctamente", numeroProgramadores - 2 - cont,
						programador.darCodigo());
			}

			// Adiciona un programador en la mitad y verifica que haya sido agregado
			// correctamente
			programador = (Programador) programadores.get(numeroProgramadores - 1);
			ced = 5;
			maraton.agregarProgramadorAntesDe(ced, new Programador(programador.darCodigo(), programador.darNombre(),
					programador.darEquipo(), programador.darInformacionLenguaje(), programador.darSexo()));

			aux = maraton.localizar(ced + 1);
			assertEquals("La adici�n no se realiz� correctamente", programador.darCodigo(),
					aux.darSiguiente().darCodigo());
			assertEquals("La adici�n no se realiz� correctamente", ced, aux.darSiguiente().darSiguiente().darCodigo());
			aux = aux.darSiguiente();
			assertEquals("La adici�n no se realiz� correctamente", programador.darCodigo(), aux.darCodigo());
			assertEquals("La adici�n no se realiz� correctamente", programador.darEquipo(), aux.darEquipo());
			assertEquals("La adici�n no se realiz� correctamente", programador.darInformacionLenguaje(),
					aux.darInformacionLenguaje());
			assertEquals("La adici�n no se realiz� correctamente", programador.darNombre(), aux.darNombre());
			assertEquals("La adici�n no se realiz� correctamente", programador.darSexo(), aux.darSexo());
		} catch (NoExisteException e) {
			fail("No se debi� arrojar esta excepci�n");
		}
	}

	/**
	 * Prueba que la adici�n de programadores arroje error cuando el c�digo del programador siguiente no exista. <br>
	 * <b> M�todos a probar: </b> <br>
	 * agregarProgramadorAntesDe. <br>
	 * <b> Objetivo: </b> Probar que el m�todo agregarProgramadorAntesDe() arroje
	 * excepci�n cuando se trate de agregar un programador antes de otro que no exista.
	 * <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al agregar un programador con una c�dula del programador siguiente que no exista
	 * se debe arrojar una excepci�n.
	 */
	public void testAgregarProgramadorAntesDeError() {
		setupEscenario2();

		// Tratar de agregar un programador con el c�digo del programador siguiente
		// inexistente
		try {
			maraton.agregarProgramadorAntesDe(1000, new Programador(numeroProgramadores, "Juan Manuel", "Septimo",
					"Python", Programador.HOMBRE));
			fail("No se debi� agregar el programador");
		} catch (NoExisteException e1) {
			// Se verifica que la lista de programadores no haya crecido
			assertEquals("No se debi� agregar el programador", numeroProgramadores, maraton.darProgramadores().size());
		}
	}

	/**
	 * Prueba la adici�n de programadores. <br>
	 * <b> M�todos a probar: </b> <br>
	 * agregarProgramadorDespuesDe, localizar. <br>
	 * <b> Objetivo: </b> Probar que el m�todo agregarProgramadorDespuesDe() agregue
	 * programadores correctamente a la lista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al agregar un programador en una marat�n sin programadores este debe ser
	 * insertado sin errores. <br>
	 * 2. Al agregar un programador 'A' despu�s de un programador 'B' previamente
	 * adicionado, el programador 'A' debe quedar d�spues del programador 'B' en la lista.
	 * <br>
	 * 3. Al agregar un programador este debe quedar registrado en el marat�n
	 */
	public void testAgregarProgramadorDespuesDe() {
		setupEscenario1();
		numeroProgramadores = 11;
		ArrayList<Programador> programadores = new ArrayList<Programador>();
		Programador programador;
		Programador aux;
		for (int cont = 0; cont < numeroProgramadores; cont++) {
			programador = new Programador(cont, "nombre" + cont, "grupo" + cont, "Java" + cont,
					Programador.HOMBRE);
			programadores.add(programador);
		}

		// Agrega el primer programador para tener un elemento despu�s del cual insertar
		// programadores
		programador = (Programador) programadores.get(0);
		maraton.agregarProgramadorAlComienzo(new Programador(programador.darCodigo(), programador.darNombre(),
				programador.darEquipo(), programador.darInformacionLenguaje(), programador.darSexo()));

		// Agrega los programadores y verifica que se hayan agregado correctamente
		// busc�ndolos
		int ced = 0;
		try {
			for (int cont = 1; cont < numeroProgramadores - 1; cont++) {
				programador = (Programador) programadores.get(cont);
				maraton.agregarProgramadorDespuesDe(ced,
						new Programador(programador.darCodigo(), programador.darNombre(), programador.darEquipo(),
								programador.darInformacionLenguaje(), programador.darSexo()));
				aux = maraton.localizar(programador.darCodigo());

				// Verifica que la informaci�n sea correcta
				assertEquals("La adici�n no se realiz� correctamente", programador.darCodigo(), aux.darCodigo());
				assertEquals("La adici�n no se realiz� correctamente", programador.darEquipo(), aux.darEquipo());
				assertEquals("La adici�n no se realiz� correctamente", programador.darInformacionLenguaje(),
						aux.darInformacionLenguaje());
				assertEquals("La adici�n no se realiz� correctamente", programador.darNombre(), aux.darNombre());
				assertEquals("La adici�n no se realiz� correctamente", programador.darSexo(), aux.darSexo());
				ced = programador.darCodigo();
			}

			// Se verifica que los programadores hayan sido ingresados en el orden correcto
			ArrayList<Programador> programadoresMaraton = maraton.darProgramadores();

			for (int cont = 0; cont < numeroProgramadores - 1; cont++) {
				programador = (Programador) programadoresMaraton.get(cont);
				assertEquals("La adici�n no se realiz� correctamente", cont, programador.darCodigo());
			}

			// Adiciona un programador en la mitad y verifica que haya sido agregado
			// correctamente
			programador = (Programador) programadores.get(numeroProgramadores - 1);
			ced = 3;
			maraton.agregarProgramadorDespuesDe(ced, new Programador(programador.darCodigo(), programador.darNombre(),
					programador.darEquipo(), programador.darInformacionLenguaje(), programador.darSexo()));

			aux = maraton.localizar(ced);
			assertEquals("La adici�n no se realiz� correctamente", programador.darCodigo(),
					aux.darSiguiente().darCodigo());
			aux = aux.darSiguiente();
			assertEquals("La adici�n no se realiz� correctamente", programador.darCodigo(), aux.darCodigo());
			assertEquals("La adici�n no se realiz� correctamente", programador.darEquipo(), aux.darEquipo());
			assertEquals("La adici�n no se realiz� correctamente", programador.darInformacionLenguaje(),
					aux.darInformacionLenguaje());
			assertEquals("La adici�n no se realiz� correctamente", programador.darNombre(), aux.darNombre());
			assertEquals("La adici�n no se realiz� correctamente", programador.darSexo(), aux.darSexo());
		} catch (NoExisteException e) {

			fail("No se debi� arrojar esta excepci�n");
		}
	}

	/**
	 * Prueba que la adici�n de programadores arroje error cuando el c�digo del programador
	 * anterior no exista. <br>
	 * <b> M�todos a probar: </b> <br>
	 * agregarProgramadorDespuesDe. <br>
	 * <b> Objetivo: </b> Probar que el m�todo agregarProgramadordespuesDe() arroje
	 * excepci�n cuando se trate de agregar un programador despues de otro que no
	 * exista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al agregar un programador con una c�dula del programador anterior que no exista
	 * se debe arrojar una excepci�n.
	 */
	public void testAgregarProgramadorDespuesDeError() {
		setupEscenario2();

		// Tratar de agregar un programador con el c�digo del programador anterior inexistente
		try {
			maraton.agregarProgramadorDespuesDe(1000, new Programador(numeroProgramadores, "Luz Estela", "Septimo",
					"Python", Programador.MUJER));
			assertTrue("No se debi� agregar el programador", false);
		} catch (NoExisteException e1) {
			// Se verifica que la lista de programadores no haya crecido
			assertEquals("No se debi� agregar el programador", numeroProgramadores, maraton.darProgramadores().size());
		}
	}

	/**
	 * Prueba la eliminaci�n de programadores. <br>
	 * <b> M�todos a probar: </b> <br>
	 * eliminarProgramador, localizar. <br>
	 * <b> Objetivo: </b> Probar que el m�todo eliminarProgramador() elimine
	 * correctamente los programadores de la lista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al eliminar un programador existente en una marat�n al buscarlos no se debe
	 * encontrar. <br>
	 * 2. Al eliminar un programador existente en una marat�n la lista debe quedar
	 * encadenada correctamente. <br>
	 * 3. Al agregar un programador este debe quedar registrado en el marat�n
	 */
	public void testEliminarProgramador() {
		setupEscenario3();

		// Eliminar la cabeza
		try {
			maraton.eliminarProgramador(0);
			Programador programador = maraton.localizar(0);

			assertNull("El programador no deber�a encontrarse", programador);
			assertEquals("El n�mero de programadores no es el correcto", numeroProgramadores - 1,
					maraton.darProgramadores().size());

			// Eliminar un elemento del medio
			maraton.eliminarProgramador(5);
			programador = maraton.localizar(5);
			assertNull("El programador no deber�a encontrarse", programador);
			assertEquals("El n�mero de programadores no es el correcto", numeroProgramadores - 2,
					maraton.darProgramadores().size());

			// Eliminar la cola
			maraton.eliminarProgramador(numeroProgramadores - 1);
			programador = maraton.localizar(numeroProgramadores - 1);
			assertNull("El programador no deber�a encontrarse", programador);
			assertEquals("El n�mero de programadores no es el correcto", numeroProgramadores - 3,
					maraton.darProgramadores().size());

			// Verificar que la lista haya quedado encadenada correctamente despu�s de las
			// eliminaciones
			ArrayList<Programador> programadores = maraton.darProgramadores();
			for (int cont = 0; cont < numeroProgramadores - 3; cont++) {
				programador = (Programador) programadores.get(cont);
				if (cont < 4) {

					assertEquals("La eliminaci�n no se realiz� de forma correcta", cont + 1, programador.darCodigo());
				} else if (cont > 4) {
					assertEquals("La eliminaci�n no se realiz� de forma correcta", cont + 2, programador.darCodigo());
				}
			}

			// Eliminar el resto de programadores y verificar que la eliminaci�n se haga de
			// forma correcta
			numeroProgramadores -= 3;
			for (int cont = 0; cont < programadores.size() - 1; cont++) {
				if (cont != 5) {
					programador = (Programador) programadores.get(cont + 1);
					maraton.eliminarProgramador(programador.darCodigo());
					numeroProgramadores--;
					assertEquals("El n�mero de programadores no es correcto", numeroProgramadores,
							maraton.darProgramadores().size());
				}

			}

		} catch (NoExisteException e) {
			fail("No se debi� arrojar esta excepci�n");
		}
	}

	/**
	 * Prueba que al tratar de eliminar un programador que no exista se arroje
	 * excepci�n. <br>
	 * <b> M�todos a probar: </b> <br>
	 * eliminarProgramador. <br>
	 * <b> Objetivo: </b> Probar que el m�todo eliminarProgramador() arroje excepci�n
	 * cuando se trate de eliminar un programador que no exista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al eliminar un programador que no existe se debe lanzar excepci�n.
	 */
	public void testEliminarProgramadorError() {
		setupEscenario1();

		try {
			maraton.eliminarProgramador(1000);
			assertTrue("No se debi� eliminar ning�n programador", false);
		} catch (NoExisteException e) {

			// Verificar que no se haya eliminado ning�n programador
			assertEquals("No se debi� eliminar ning�n programador", numeroProgramadores, maraton.darProgramadores().size());

			setupEscenario2();

			try {
				maraton.eliminarProgramador(1000);
				assertTrue("No se debi� eliminar ning�n programador", false);
			} catch (NoExisteException e1) {
				// Verificar que no se haya eliminado ning�n programador
				assertEquals("No se debi� eliminar nimg�n programador", numeroProgramadores,
						maraton.darProgramadores().size());
			}

		}
	}

	/**
	 * Prueba que la b�squeda de programadores se realice correctamente. <br>
	 * <b> M�todos a probar: </b> <br>
	 * localizar. <br>
	 * <b> Objetivo: </b> Probar que el m�todo localizar() sea capaz de encontrar
	 * los programadores que se encuentran en la lista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al buscar un programador existente se debe encontrar. <br>
	 * 2. Al buscar un programador que no exista se debe retornar null.
	 */
	public void testLocalizar() {
		setupEscenario2();

		// Busca un programador del medio
		Programador programador = maraton.localizar(numeroProgramadores - 6);
		assertNotNull("El programador deber�a haberse encontrado", programador);
		assertEquals("El programador no se busco de forma correcta", numeroProgramadores - 6, programador.darCodigo());

		// Busca el programador de la cola
		programador = maraton.localizar(numeroProgramadores - 1);
		assertNotNull("El programador deber�a haberse encontrado", programador);
		assertEquals("El programador no se busco de forma correcta", numeroProgramadores - 1, programador.darCodigo());

		programador = maraton.localizar(1000);
		assertNull("El programador no deber�a haberse encontrado", programador);
	}

	/**
	 * Prueba que la b�squeda del programador anterior a otro se realice correctamente.
	 * <br>
	 * <b> M�todos a probar: </b> <br>
	 * localizarAnterior. <br>
	 * <b> Objetivo: </b> Probar que el m�todo localizarAnterior() sea capaz de
	 * encontrar el programador anterior de un programador dado. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al buscar un programador anterior en una lista vac�a se debe retornar null.
	 * <br>
	 * 2. Al buscar el programador anterior al primero se debe retornar null. <br>
	 * 3. Al buscar el programador anterior a uno intermedio este debe ser encontrado.
	 * <br>
	 * 4. Al buscar el programador anterior al �ltimo este debe ser encontrado. <br>
	 * 5. Al buscar el programador anterior a uno que no exista se debe retornar null.
	 */
	public void testLocalizarAnterior() {

		setupEscenario1();

		// Verifica que se retorne null cuando la lista de programadores est� vac�a
		Programador programador = maraton.localizarAnterior(0);
		assertNull("El programador anterior no deber�a existir", programador);

		setupEscenario2();

		// Verifica que se retorne null cuando se pida el programador anterior al primero
		programador = maraton.localizarAnterior(numeroProgramadores - 1);
		assertNull("El programador anterior no deber�a existir", programador);

		// Verifica que se busque correctamente el programador anterior a un programador del
		// medio
		programador = maraton.localizarAnterior(numeroProgramadores / 2);
		assertEquals("El programador anterior no es el correcto", (numeroProgramadores / 2) + 1, programador.darCodigo());

		// Verifica que se busque correctamente el programador anterior al programador del
		// final
		programador = maraton.localizarAnterior(0);
		assertEquals("El programador anterior no es el correcto", 1, programador.darCodigo());

		// Verifica que se retorne null cuando se busque un programador que no exista
		programador = maraton.localizarAnterior(1000);
		assertNull("El programador anterior no deber�a existir", programador);

	}

	/**
	 * Prueba que la b�squeda del programador anterior a otro se realice correctamente.
	 * <br>
	 * <b> M�todos a probar: </b> <br>
	 * localizarUltimo. <br>
	 * <b> Objetivo: </b> Probar que el m�todo localizarUltimo() sea capaz de
	 * encontrar el �ltimo programador de la lista de forma correcta. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al buscar el �ltimo programador en una lista vac�a se debe retornar null.
	 * <br>
	 * 2. Al buscar el �ltimo programador en una lista no vac�a este debe ser
	 * encontrado.
	 */
	public void testLocalizarUltimo() {

		setupEscenario1();

		// Verifica que se retorne null cuando la lista de programadores est� vac�a
		Programador programador = maraton.localizarUltimo();
		assertNull("El �ltimo programador no deber�a existir", programador);

		setupEscenario2();

		// Verifica que se retorne correctamente el �ltimo programador de una lista no
		// vac�a
		programador = maraton.localizarUltimo();
		assertEquals("El programador anterior no es el correcto", 0, programador.darCodigo());
	}
}