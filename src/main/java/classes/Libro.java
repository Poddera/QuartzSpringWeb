package classes;

public class Libro {
	private String autor;
	private String title;
	private int numeroEjemplares = 0;
	
	public Libro(String autor, String title, int numeroEjemplares) {
		this.autor = autor;
		this.title = title;
		this.numeroEjemplares = numeroEjemplares;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumeroEjemplares() {
		return numeroEjemplares;
	}

	public void setNumeroEjemplares(int numeroEjemplares) {
		this.numeroEjemplares = numeroEjemplares;
	}
}
