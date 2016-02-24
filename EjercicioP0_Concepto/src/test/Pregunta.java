package test;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Pregunta  implements Serializable{
	
	private String pregunta;
	private String orden;
	
	public Pregunta(){
	}
	
	public Pregunta(String pregunta, String orden) {
		this.pregunta = pregunta;
		this.orden = orden;
	}
	
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "Pregunta [pregunta=" + pregunta + ", orden=" + orden + "]";
	}
	
}
