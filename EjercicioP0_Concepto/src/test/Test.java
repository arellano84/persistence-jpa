package test;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="EjercicioP0_Test")
@NamedQueries({
    @NamedQuery(name="version",
                query="select t from Test t where t.version=:ver" ),
    @NamedQuery(name="todas",
                query="select t from Test t" )
})
@SecondaryTable(name="EjercicioP0_Versiones",
pkJoinColumns={@PrimaryKeyJoinColumn(name="id_test",
                         referencedColumnName="id_test")
  }
)
public class Test implements Serializable{
	
	@Id
    @Column(name="id_test", nullable=false)
	private Long id;
	private String version;
	private String descripcion;
	
	@Embedded
	private Pregunta pregunta;
	
    @Basic(fetch=FetchType.LAZY)
    @Column(table="EjercicioP0_Versiones")
    private boolean activo;
	
	
	public Test(){
	}

	public Test(Long id, String version, String descripcion, Pregunta pregunta, boolean activo) {
		this.id = id;
		this.version = version;
		this.descripcion = descripcion;
		this.pregunta = pregunta;
		this.activo = activo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", version=" + version + ", descripcion="
				+ descripcion + ", pregunta=" + pregunta + ", activo=" + activo
				+ "]";
	}

}
