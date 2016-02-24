package app.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@IdClass(LibroPK.class)
@Table(name="libros")
@NamedQueries({
    @NamedQuery(name="autores",query="select l from Libro l where l.autor=:autor")
})
public class Libro implements Serializable{

//	@EmbeddedId
//    private LibroPK libroPk;
	
	@Id
	@Column(name="id_titulo",nullable=false,length=20)
	private String titulo;
	
	@Id
	@Column(name="id_autor",nullable=false,length=20)
	private String autor;
	
	@Column(length=100)
	private String descripcion;
	
	@Column(length=100)
	private String resumen;
	
	
	public Libro(String titulo, String autor, String descripcion, String resumen) {
		this.titulo = titulo;
		this.autor = autor;
		this.descripcion = descripcion;
		this.resumen = resumen;
	}

	public Libro() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor
				+ ", descripcion=" + descripcion + ", resumen=" + resumen + "]";
	}

}
