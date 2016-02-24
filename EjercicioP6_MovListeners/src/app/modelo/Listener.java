package app.modelo;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class Listener {
	
	@PrePersist
	@PreUpdate
	public void interceptar(Vehiculo p){
		
		if(p instanceof Camion){
			p.setModelo("Modelo Volvo");
			System.out.println("Se va crear una entidad de tipo Camion");
		}
		if(p instanceof Coche){
			p.setModelo("Modelo BMW");
			System.out.println("Se va crear una entidad de tipo Coche");
		}
	}

}
