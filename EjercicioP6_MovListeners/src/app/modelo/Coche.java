package app.modelo;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="CO")
@Table(name="propuesto6_coche")
public class Coche extends Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	int puertas;
	float longitud;
	
	public Coche() {
	}

	public Coche(String modelo, float velocidad, int potencia, int puertas, float longitud) {
		super(modelo, velocidad, potencia);
		this.puertas = puertas;
		this.longitud = longitud;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Coche [puertas=" + puertas + ", longitud=" + longitud + "]";
	}

}
