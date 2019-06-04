package modelo;
import java.util.ArrayList;
import junit.framework.TestCase;
import modelo.Maraton;
import modelo.NoExisteException;
import modelo.Programador;
/**
 * Esta es la clase usada para verificar que los métodos de la clase Maraton
 * estén correctamente implementados
 */
public class MaratonTest extends TestCase {

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Es la clase donde se harán las pruebas
	 */
	private Maraton maraton;

	/**
	 * El número de programadores a manejar en cada prueba
	 */
	private int numeroProgramadores;

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Construye una nueva Maratón vacío
	 * 
	 */
	private void setupEscenario1() {
		maraton = new Maraton();
		numeroProgramadores = 0;

	}

	/**
	 * Construye una nueva maratón con 10 programadores
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
	 * Construye una nueva Maratón con 10 programadores
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
	 * Prueba la adición de programadores. <br>
	 * <b> Métodos a probar: </b> <br>
	 * darProgramadores, agregarProgramadorAlComienzo. <br>
	 * <b> Objetivo: </b> probar que el método agregarProgramadorAlComienzo() agrega
	 * correctamente programadores a la lista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al agregar un programador en una maratón sin programadores este debe ser
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
					"la información del lenguaje del programación " + cont, Programador.MUJER);
			programadores.add(programador);
		}
		// Agrega los programadores y verifica que se hayan agregado correctamente
		for (int cont = 0; cont < numeroProgramadores; cont++) {
			programador = (Programador) programadores.get(cont);
			maraton.agregarProgramadorAlComienzo(new Programador(programador.darCodigo(), programador.darNombre(),
					programador.darEquipo(), programador.darInformacionLenguaje(), programador.darSexo()));
			ArrayList<Programador> losProgramadores = maraton.darProgramadores();
			aux = (Programador) losProgramadores.get(0);

			// Verifica que la información sea correcta
			assertEquals("La adición no se realizó correctamente", programador.darCodigo(), aux.darCodigo());
			assertEquals("La adición no se realizó correctamente", programador.darEquipo(), aux.darEquipo());
			assertEquals("La adición no se realizó correctamente", programador.darInformacionLenguaje(),
					aux.darInformacionLenguaje());
			assertEquals("La adición no se realizó correctamente", programador.darNombre(), aux.darNombre());
			assertEquals("La adición no se realizó correctamente", programador.darSexo(), aux.darSexo());

			// Verifica que el número de programadores en la lista sea el correcto
			assertEquals("El número de programadores no es el correcto", cont + 1, losProgramadores.size());
		}
	}

	/**
	 * Prueba la adición de programadores. <br>
	 * <b> Métodos a probar: </b> <br>
	 * darProgramadores, agregarProgramadorAlFinal. <br>
	 * <b> Objetivo: </b> probar que el método agregarProgramadorAlFinal() agrega
	 * correctamente programadores a la lista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al agregar un programador en una maratón sin programadores este debe ser
	 * insertado sin errores. <br>
	 * 2. Al agregar un programador 'A' al final de la lista este debe quedar de último
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
					"la información del lenguaje del programación " + cont, Programador.HOMBRE);
			programadores.add(programador);
		}
		// Agrega los programadores y verifica que se hayan agregado correctamente

		for (int cont = 0; cont < numeroProgramadores; cont++) {
			programador = (Programador) programadores.get(cont);
			maraton.agregarProgramadorAlFinal(new Programador(programador.darCodigo(), programador.darNombre(),
					programador.darEquipo(), programador.darInformacionLenguaje(), programador.darSexo()));
			ArrayList<Programador> losProgramadores = maraton.darProgramadores();
			aux = (Programador) losProgramadores.get(cont);

			// Verifica que la información sea correcta
			assertEquals("La adición no se realizó correctamente", programador.darCodigo(), aux.darCodigo());
			assertEquals("La adición no se realizó correctamente", programador.darEquipo(), aux.darEquipo());
			assertEquals("La adición no se realizó correctamente", programador.darInformacionLenguaje(),
					aux.darInformacionLenguaje());
			assertEquals("La adición no se realizó correctamente", programador.darNombre(), aux.darNombre());
			assertEquals("La adición no se realizó correctamente", programador.darSexo(), aux.darSexo());

			// Verifica que el número de programadores en la lista sea el correcto
			assertEquals("El número de programadores no es el correcto", cont + 1, losProgramadores.size());
		}

	}

	/**
	 * Prueba la adición de programadores. <br>
	 * <b> Métodos a probar: </b> <br>
	 * agregarProgramadorAntesDe, localizar, agregarProgramadorAlComienzo. <br>
	 * <b> Objetivo: </b> probar que el método agregarProgramadorAntesDe() agrega
	 * correctamente programadores a la lista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al agregar un programador en una maratón sin programadores este debe ser
	 * insertado sin errores. <br>
	 * 2. Al agregar un programador 'A' antes de un programador 'B' previamente
	 * adicionado, el programador 'A' debe quedar antes del programador 'B' en la lista.
	 * <br>
	 * 3. Al agregar un programador este debe quedar registrado en el maratón
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
		// buscándolos
		int ced = 0;

		try {
			for (int cont = 1; cont < numeroProgramadores - 1; cont++) {
				programador = (Programador) programadores.get(cont);
				maraton.agregarProgramadorAntesDe(ced, new Programador(programador.darCodigo(), programador.darNombre(),
						programador.darEquipo(), programador.darInformacionLenguaje(), programador.darSexo()));
				aux = maraton.localizar(programador.darCodigo());

				// Verifica que la información sea correcta
				assertEquals("La adición no se realizó correctamente", programador.darCodigo(), aux.darCodigo());
				assertEquals("La adición no se realizó correctamente", programador.darEquipo(), aux.darEquipo());
				assertEquals("La adición no se realizó correctamente", programador.darInformacionLenguaje(),
						aux.darInformacionLenguaje());
				assertEquals("La adición no se realizó correctamente", programador.darNombre(), aux.darNombre());
				assertEquals("La adición no se realizó correctamente", programador.darSexo(), aux.darSexo());
				ced = programador.darCodigo();
			}

			// Se verifica que los programadores hayan sido ingresados en el orden correcto
			ArrayList<Programador> programadoresMaraton = maraton.darProgramadores();

			for (int cont = 0; cont < numeroProgramadores - 1; cont++) {
				programador = (Programador) programadoresMaraton.get(cont);
				assertEquals("La adición no se realizó correctamente", numeroProgramadores - 2 - cont,
						programador.darCodigo());
			}

			// Adiciona un programador en la mitad y verifica que haya sido agregado
			// correctamente
			programador = (Programador) programadores.get(numeroProgramadores - 1);
			ced = 5;
			maraton.agregarProgramadorAntesDe(ced, new Programador(programador.darCodigo(), programador.darNombre(),
					programador.darEquipo(), programador.darInformacionLenguaje(), programador.darSexo()));

			aux = maraton.localizar(ced + 1);
			assertEquals("La adición no se realizó correctamente", programador.darCodigo(),
					aux.darSiguiente().darCodigo());
			assertEquals("La adición no se realizó correctamente", ced, aux.darSiguiente().darSiguiente().darCodigo());
			aux = aux.darSiguiente();
			assertEquals("La adición no se realizó correctamente", programador.darCodigo(), aux.darCodigo());
			assertEquals("La adición no se realizó correctamente", programador.darEquipo(), aux.darEquipo());
			assertEquals("La adición no se realizó correctamente", programador.darInformacionLenguaje(),
					aux.darInformacionLenguaje());
			assertEquals("La adición no se realizó correctamente", programador.darNombre(), aux.darNombre());
			assertEquals("La adición no se realizó correctamente", programador.darSexo(), aux.darSexo());
		} catch (NoExisteException e) {
			fail("No se debió arrojar esta excepción");
		}
	}

	/**
	 * Prueba que la adición de programadores arroje error cuando el código del programador siguiente no exista. <br>
	 * <b> Métodos a probar: </b> <br>
	 * agregarProgramadorAntesDe. <br>
	 * <b> Objetivo: </b> Probar que el método agregarProgramadorAntesDe() arroje
	 * excepción cuando se trate de agregar un programador antes de otro que no exista.
	 * <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al agregar un programador con una cédula del programador siguiente que no exista
	 * se debe arrojar una excepción.
	 */
	public void testAgregarProgramadorAntesDeError() {
		setupEscenario2();

		// Tratar de agregar un programador con el código del programador siguiente
		// inexistente
		try {
			maraton.agregarProgramadorAntesDe(1000, new Programador(numeroProgramadores, "Juan Manuel", "Septimo",
					"Python", Programador.HOMBRE));
			fail("No se debió agregar el programador");
		} catch (NoExisteException e1) {
			// Se verifica que la lista de programadores no haya crecido
			assertEquals("No se debió agregar el programador", numeroProgramadores, maraton.darProgramadores().size());
		}
	}

	/**
	 * Prueba la adición de programadores. <br>
	 * <b> Métodos a probar: </b> <br>
	 * agregarProgramadorDespuesDe, localizar. <br>
	 * <b> Objetivo: </b> Probar que el método agregarProgramadorDespuesDe() agregue
	 * programadores correctamente a la lista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al agregar un programador en una maratón sin programadores este debe ser
	 * insertado sin errores. <br>
	 * 2. Al agregar un programador 'A' después de un programador 'B' previamente
	 * adicionado, el programador 'A' debe quedar déspues del programador 'B' en la lista.
	 * <br>
	 * 3. Al agregar un programador este debe quedar registrado en el maratón
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

		// Agrega el primer programador para tener un elemento después del cual insertar
		// programadores
		programador = (Programador) programadores.get(0);
		maraton.agregarProgramadorAlComienzo(new Programador(programador.darCodigo(), programador.darNombre(),
				programador.darEquipo(), programador.darInformacionLenguaje(), programador.darSexo()));

		// Agrega los programadores y verifica que se hayan agregado correctamente
		// buscándolos
		int ced = 0;
		try {
			for (int cont = 1; cont < numeroProgramadores - 1; cont++) {
				programador = (Programador) programadores.get(cont);
				maraton.agregarProgramadorDespuesDe(ced,
						new Programador(programador.darCodigo(), programador.darNombre(), programador.darEquipo(),
								programador.darInformacionLenguaje(), programador.darSexo()));
				aux = maraton.localizar(programador.darCodigo());

				// Verifica que la información sea correcta
				assertEquals("La adición no se realizó correctamente", programador.darCodigo(), aux.darCodigo());
				assertEquals("La adición no se realizó correctamente", programador.darEquipo(), aux.darEquipo());
				assertEquals("La adición no se realizó correctamente", programador.darInformacionLenguaje(),
						aux.darInformacionLenguaje());
				assertEquals("La adición no se realizó correctamente", programador.darNombre(), aux.darNombre());
				assertEquals("La adición no se realizó correctamente", programador.darSexo(), aux.darSexo());
				ced = programador.darCodigo();
			}

			// Se verifica que los programadores hayan sido ingresados en el orden correcto
			ArrayList<Programador> programadoresMaraton = maraton.darProgramadores();

			for (int cont = 0; cont < numeroProgramadores - 1; cont++) {
				programador = (Programador) programadoresMaraton.get(cont);
				assertEquals("La adición no se realizó correctamente", cont, programador.darCodigo());
			}

			// Adiciona un programador en la mitad y verifica que haya sido agregado
			// correctamente
			programador = (Programador) programadores.get(numeroProgramadores - 1);
			ced = 3;
			maraton.agregarProgramadorDespuesDe(ced, new Programador(programador.darCodigo(), programador.darNombre(),
					programador.darEquipo(), programador.darInformacionLenguaje(), programador.darSexo()));

			aux = maraton.localizar(ced);
			assertEquals("La adición no se realizó correctamente", programador.darCodigo(),
					aux.darSiguiente().darCodigo());
			aux = aux.darSiguiente();
			assertEquals("La adición no se realizó correctamente", programador.darCodigo(), aux.darCodigo());
			assertEquals("La adición no se realizó correctamente", programador.darEquipo(), aux.darEquipo());
			assertEquals("La adición no se realizó correctamente", programador.darInformacionLenguaje(),
					aux.darInformacionLenguaje());
			assertEquals("La adición no se realizó correctamente", programador.darNombre(), aux.darNombre());
			assertEquals("La adición no se realizó correctamente", programador.darSexo(), aux.darSexo());
		} catch (NoExisteException e) {

			fail("No se debió arrojar esta excepción");
		}
	}

	/**
	 * Prueba que la adición de programadores arroje error cuando el código del programador
	 * anterior no exista. <br>
	 * <b> Métodos a probar: </b> <br>
	 * agregarProgramadorDespuesDe. <br>
	 * <b> Objetivo: </b> Probar que el método agregarProgramadordespuesDe() arroje
	 * excepción cuando se trate de agregar un programador despues de otro que no
	 * exista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al agregar un programador con una cédula del programador anterior que no exista
	 * se debe arrojar una excepción.
	 */
	public void testAgregarProgramadorDespuesDeError() {
		setupEscenario2();

		// Tratar de agregar un programador con el código del programador anterior inexistente
		try {
			maraton.agregarProgramadorDespuesDe(1000, new Programador(numeroProgramadores, "Luz Estela", "Septimo",
					"Python", Programador.MUJER));
			assertTrue("No se debió agregar el programador", false);
		} catch (NoExisteException e1) {
			// Se verifica que la lista de programadores no haya crecido
			assertEquals("No se debió agregar el programador", numeroProgramadores, maraton.darProgramadores().size());
		}
	}

	/**
	 * Prueba la eliminación de programadores. <br>
	 * <b> Métodos a probar: </b> <br>
	 * eliminarProgramador, localizar. <br>
	 * <b> Objetivo: </b> Probar que el método eliminarProgramador() elimine
	 * correctamente los programadores de la lista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al eliminar un programador existente en una maratón al buscarlos no se debe
	 * encontrar. <br>
	 * 2. Al eliminar un programador existente en una maratón la lista debe quedar
	 * encadenada correctamente. <br>
	 * 3. Al agregar un programador este debe quedar registrado en el maratón
	 */
	public void testEliminarProgramador() {
		setupEscenario3();

		// Eliminar la cabeza
		try {
			maraton.eliminarProgramador(0);
			Programador programador = maraton.localizar(0);

			assertNull("El programador no debería encontrarse", programador);
			assertEquals("El número de programadores no es el correcto", numeroProgramadores - 1,
					maraton.darProgramadores().size());

			// Eliminar un elemento del medio
			maraton.eliminarProgramador(5);
			programador = maraton.localizar(5);
			assertNull("El programador no debería encontrarse", programador);
			assertEquals("El número de programadores no es el correcto", numeroProgramadores - 2,
					maraton.darProgramadores().size());

			// Eliminar la cola
			maraton.eliminarProgramador(numeroProgramadores - 1);
			programador = maraton.localizar(numeroProgramadores - 1);
			assertNull("El programador no debería encontrarse", programador);
			assertEquals("El número de programadores no es el correcto", numeroProgramadores - 3,
					maraton.darProgramadores().size());

			// Verificar que la lista haya quedado encadenada correctamente después de las
			// eliminaciones
			ArrayList<Programador> programadores = maraton.darProgramadores();
			for (int cont = 0; cont < numeroProgramadores - 3; cont++) {
				programador = (Programador) programadores.get(cont);
				if (cont < 4) {

					assertEquals("La eliminación no se realizó de forma correcta", cont + 1, programador.darCodigo());
				} else if (cont > 4) {
					assertEquals("La eliminación no se realizó de forma correcta", cont + 2, programador.darCodigo());
				}
			}

			// Eliminar el resto de programadores y verificar que la eliminación se haga de
			// forma correcta
			numeroProgramadores -= 3;
			for (int cont = 0; cont < programadores.size() - 1; cont++) {
				if (cont != 5) {
					programador = (Programador) programadores.get(cont + 1);
					maraton.eliminarProgramador(programador.darCodigo());
					numeroProgramadores--;
					assertEquals("El número de programadores no es correcto", numeroProgramadores,
							maraton.darProgramadores().size());
				}

			}

		} catch (NoExisteException e) {
			fail("No se debió arrojar esta excepción");
		}
	}

	/**
	 * Prueba que al tratar de eliminar un programador que no exista se arroje
	 * excepción. <br>
	 * <b> Métodos a probar: </b> <br>
	 * eliminarProgramador. <br>
	 * <b> Objetivo: </b> Probar que el método eliminarProgramador() arroje excepción
	 * cuando se trate de eliminar un programador que no exista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al eliminar un programador que no existe se debe lanzar excepción.
	 */
	public void testEliminarProgramadorError() {
		setupEscenario1();

		try {
			maraton.eliminarProgramador(1000);
			assertTrue("No se debió eliminar ningún programador", false);
		} catch (NoExisteException e) {

			// Verificar que no se haya eliminado ningún programador
			assertEquals("No se debió eliminar ningún programador", numeroProgramadores, maraton.darProgramadores().size());

			setupEscenario2();

			try {
				maraton.eliminarProgramador(1000);
				assertTrue("No se debió eliminar ningún programador", false);
			} catch (NoExisteException e1) {
				// Verificar que no se haya eliminado ningún programador
				assertEquals("No se debió eliminar nimgún programador", numeroProgramadores,
						maraton.darProgramadores().size());
			}

		}
	}

	/**
	 * Prueba que la búsqueda de programadores se realice correctamente. <br>
	 * <b> Métodos a probar: </b> <br>
	 * localizar. <br>
	 * <b> Objetivo: </b> Probar que el método localizar() sea capaz de encontrar
	 * los programadores que se encuentran en la lista. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al buscar un programador existente se debe encontrar. <br>
	 * 2. Al buscar un programador que no exista se debe retornar null.
	 */
	public void testLocalizar() {
		setupEscenario2();

		// Busca un programador del medio
		Programador programador = maraton.localizar(numeroProgramadores - 6);
		assertNotNull("El programador debería haberse encontrado", programador);
		assertEquals("El programador no se busco de forma correcta", numeroProgramadores - 6, programador.darCodigo());

		// Busca el programador de la cola
		programador = maraton.localizar(numeroProgramadores - 1);
		assertNotNull("El programador debería haberse encontrado", programador);
		assertEquals("El programador no se busco de forma correcta", numeroProgramadores - 1, programador.darCodigo());

		programador = maraton.localizar(1000);
		assertNull("El programador no debería haberse encontrado", programador);
	}

	/**
	 * Prueba que la búsqueda del programador anterior a otro se realice correctamente.
	 * <br>
	 * <b> Métodos a probar: </b> <br>
	 * localizarAnterior. <br>
	 * <b> Objetivo: </b> Probar que el método localizarAnterior() sea capaz de
	 * encontrar el programador anterior de un programador dado. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al buscar un programador anterior en una lista vacía se debe retornar null.
	 * <br>
	 * 2. Al buscar el programador anterior al primero se debe retornar null. <br>
	 * 3. Al buscar el programador anterior a uno intermedio este debe ser encontrado.
	 * <br>
	 * 4. Al buscar el programador anterior al último este debe ser encontrado. <br>
	 * 5. Al buscar el programador anterior a uno que no exista se debe retornar null.
	 */
	public void testLocalizarAnterior() {

		setupEscenario1();

		// Verifica que se retorne null cuando la lista de programadores esté vacía
		Programador programador = maraton.localizarAnterior(0);
		assertNull("El programador anterior no debería existir", programador);

		setupEscenario2();

		// Verifica que se retorne null cuando se pida el programador anterior al primero
		programador = maraton.localizarAnterior(numeroProgramadores - 1);
		assertNull("El programador anterior no debería existir", programador);

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
		assertNull("El programador anterior no debería existir", programador);

	}

	/**
	 * Prueba que la búsqueda del programador anterior a otro se realice correctamente.
	 * <br>
	 * <b> Métodos a probar: </b> <br>
	 * localizarUltimo. <br>
	 * <b> Objetivo: </b> Probar que el método localizarUltimo() sea capaz de
	 * encontrar el último programador de la lista de forma correcta. <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al buscar el último programador en una lista vacía se debe retornar null.
	 * <br>
	 * 2. Al buscar el último programador en una lista no vacía este debe ser
	 * encontrado.
	 */
	public void testLocalizarUltimo() {

		setupEscenario1();

		// Verifica que se retorne null cuando la lista de programadores esté vacía
		Programador programador = maraton.localizarUltimo();
		assertNull("El último programador no debería existir", programador);

		setupEscenario2();

		// Verifica que se retorne correctamente el último programador de una lista no
		// vacía
		programador = maraton.localizarUltimo();
		assertEquals("El programador anterior no es el correcto", 0, programador.darCodigo());
	}
}