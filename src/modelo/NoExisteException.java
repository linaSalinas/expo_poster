package modelo;
public class NoExisteException extends Exception {
	public NoExisteException(int codigo) {
		super("El programador con código " + codigo + " no está registrado");
	}
}