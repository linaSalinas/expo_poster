package modelo;
public class NoExisteException extends Exception {
	public NoExisteException(int codigo) {
		super("El programador con c�digo " + codigo + " no est� registrado");
	}
}