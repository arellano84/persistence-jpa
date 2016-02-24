# persistence-jpa
Ejemplos de JPA

EJERCICIO 1

Crear una entidad Persona mapeada contra la tabla personas con las siguientes propiedades:
	 Long codigo (debe ser la clave primaria)
	 String nombre
	 String dni
	 
Desde la clase principal obtendremos un EntityManager para persistir 20 personas y otro
EntityManager para recuperar todas las personas de la base de datos ordenados por su código
de forma descendente.


EJERCICIO 2

Crear una entidad Libro mapeada a la tabla libros con las siguientes propiedades:
	LibroPK libroPK (LibroPK es la clave primaria compuesta que consta de: String titulo,
String autor)
	String descripción
	String resumen

Desde la clase principal introducir 5 libros en la tabla y realizar las siguientes operaciones:
	Consultar todos los libros ordenados ascendentemente por titulo
	Consultar los libros de un determinado autor.
	Eliminar un libro de la tabla
	Modificar la descripción de un libro

	
EJERCICIO 3

Generar y relacionar las siguientes entidades con sus propiedades:

	Escudería
		Long id (clave primaria)
		String nombre
		String país
		Set<Piloto> pilotos
	Facturación
		Long id (clave primaria)
		int sueldo
		int publicidad
		Piloto piloto
		Nif
		Long id (clave primaria)
		char letra
		long numero
	Piloto
		Long id (clave primaria)
		String nombre
		int edad
		Facturacion facturacion
		Nif nif
		Escuderia escuderia
		Set<Telefono> telefonos
		Set<Temporada> temporadas
	Telefono
		Long id (clave primaria)
		long numero
		Piloto piloto
	
	Temporada
		Long id (clave primaria)
		int inicio
		int fin
		Set<Piloto> pilotos

El modelo de dominio es el siguiente:

........

Generar en la clase principal entidades de todos los tipos y persistirlas
Desde otra clase efectuar las siguientes consultas:
	Mostrar los pilotos que pertenecen a una determinada temporada
	Mostrar los pilotos de una escudería
	Mostrar los pilotos con un sueldo superior a una cifra
	Mostrar los pilotos que cobren por publicidad entre 2 valores
	Mostrar los pilotos que no sean de la escudería italiana
	Mostrar todos los teléfonos de Alonso


EJERCICIO 4

Crear una entidad abstracta Vehiculo con las siguientes propiedades:
	Long id
	String modelo
	float velocidad
	int potencia

Utilizando la estrategia de herencia Joined crear las siguientes entidades:
	Camión
		int tara
		int pma (Peso máximo autorizado)
		Coche
		int puertas
		float longitud

		
EJERCICIO 5

Realizar el ejercicio anterior utilizando la estrategia SingleTable


EJERCICIO 6

Realizar el ejercicio 4 utilizando los siguientes listeners:
	ListenerSuperclase monitoriza los eventos PrePersist y PreUpdate en la entidad Vehiculo.
	ListenerSubclasses monitoriza los eventos PrePersist y PreUpdate detectando si es una entidad de tipo Coche o Camión
