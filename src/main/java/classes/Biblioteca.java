package classes;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Biblioteca {
	private String name;
	private List<Libro> libros;
	
	public Biblioteca() {
		this.name = "BBK";
		this.libros = new LinkedList<Libro>();		
	}
	
	public Biblioteca(String name) {
		this.name = name;
		this.libros = new LinkedList<Libro>();
	}
	
	public Biblioteca(String name, List<Libro> libros) {
		this.name = name;
		this.libros = libros;
	}

	public void addLibro(Libro libro) {
		this.libros.add(libro);
	}
	
	public int getNumberLibros() {
		int i = 0;
		for (Libro libro : libros) {
			i += libro.getNumeroEjemplares();
		}
		return i;
	}
	
	public String printBooks() {
		String s = "";
		int n = 0;
		for(Libro libro : this.libros) {
			n += libro.getNumeroEjemplares();
			s += libro.getTitle() + " " + libro.getNumeroEjemplares() + "\n";
		}
		s += "--------------------------------------------------------------" + "\n";
		s += "Total number or books: " + n;
		return s;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
}
