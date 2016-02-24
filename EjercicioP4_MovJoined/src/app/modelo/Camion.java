package app.modelo;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="CA")
@Table(name="propuesto4_camion")
public class Camion extends Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int tara;
	float pma;
	
	public Camion() {
	}

	public Camion(String modelo, float velocidad, int potencia, int tara, float pma) {
		super(modelo, velocidad, potencia);
		this.tara = tara;
		this.pma = pma;
	}

	public int getTara() {
		return tara;
	}

	public void setTara(int tara) {
		this.tara = tara;
	}

	public float getPma() {
		return pma;
	}

	public void setPma(float pma) {
		this.pma = pma;
	}

	@Override
	public String toString() {
		return "Camion [tara=" + tara + ", pma=" + pma + "]";
	}

}
