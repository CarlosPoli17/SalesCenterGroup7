package randoms;
import java.util.Random;

//class to obtain random names and products from a pre-established list using an array
public class RandomNames {
	//ArrayList document types
	private String[] documentTypes= {"CC","CE","TI","PEP","DNI","PA"};
	//ArrayList First Names
	private String[] firstName={
            "Juan", "María", "José", "Ana", "Carlos", "Laura", "Pedro", "Sofía", "Luis", "Isabella",
            "Miguel", "Lucía", "Fernando", "Elena", "Javier", "Valentina", "David", "Camila", "Diego", "Martina",
            "Alejandro", "Paula", "Daniel", "Adriana", "Andrés", "Gabriela", "Manuel", "Valeria", "Jorge", "Natalia",
            "Pablo", "Daniela", "Mario", "Carmen", "Roberto", "Verónica", "Joaquín", "Rosa", "Ricardo", "Patricia",
            "Francisco", "Clara", "Gustavo", "Beatriz", "Antonio", "Silvia", "Alberto", "Raquel", "Federico", "Eva"
    };
	//Arraylist last Names
	private String[] lastName ={
        "García", "Rodríguez", "Martínez", "Hernández", "López", "González", "Pérez", "Sánchez", "Ramírez", "Torres",
        "Flores", "Rivera", "Gómez", "Díaz", "Reyes", "Morales", "Castillo", "Ortiz", "Álvarez", "Ruiz",
        "Jiménez", "Luna", "Dominguez", "Vázquez", "Serrano", "Silva", "Ramos", "Mendoza", "Medina", "Vega",
        "Castro", "Fernández", "Cruz", "Aguilar", "Mendoza", "Salazar", "Arias", "Campos", "Rojas", "Guerrero",
        "Vargas", "Mora", "Delgado", "Contreras", "Núñez", "Peña", "Benítez", "Santos", "Herrera"
    };
	//Arraylist stationeryProducts
	private String[] stationeryProducts = {
            "Cuaderno", "Lápiz", "Pluma", "Borrador", "Sacapuntas", "Regla", "Cinta adhesiva",
            "Pegamento", "Tijeras", "Goma de borrar", "Marcadores", "Resaltador", "Calculadora",
            "Papel", "Carpeta", "Clips", "Grapas", "Lápices de colores", "Corrector líquido",
            "Bolígrafo", "Post-it", "Agenda", "Block de notas", "Pizarra blanca", "Rotuladores",
            "Estuche", "Pincel", "Papel de carta", "Sellos", "Caja de cartón", "Carpeta clasificadora",
            "Plastificadora", "Bandeja organizadora", "Etiquetas", "Bolígrafo de gel", "Tabla de cortar",
            "Puntero láser", "Grapadora", "Portaminas", "Tiza", "Papelera", "Cizalla", "Clasificadores",
            "Cartulina", "Perforadora", "Libreta", "Encuadernadora", "Cinta correctora", "Cartuchos de tinta",
            "Rotulador permanente"
    };
	//Arraylist characteristics
	private String[] characteristics = {
			"Resistente al desgaste","Reciclable","Ecológico","Borrado fácil","No mancha","A prueba de agua","Diseño ergonómico",
		    "Compacto","Ligero","Duradero","Fácil de transportar","Multifuncional","Resistente a la rotura","Libre de ácido",
		    "Antideslizante","Alta calidad","Suave al tacto","Brilloso","Sin olor","Colores vibrantes","Económico","No tóxico"
	};
	
	
	//get a random name from the array of firstName
	public String firstName() {
		/*First, a random index is obtained within the number of indexes of the array and then .
		 * the name is obtained through the index obtained.
		 */
		Random random = new Random();
		int randomFirstNameId = random.nextInt(firstName.length);
		String randomFirstName =firstName[randomFirstNameId];
		return randomFirstName;
	}
	//get a random last name from the array of lastName
	public String lastName() {
		/*First, a random index is obtained within the number of indexes of the array and then .
		 * the name is obtained through the index obtained.
		 */
		Random random = new Random();
		int randomLastNameId = random.nextInt(lastName.length);
		String randomLastName =lastName[randomLastNameId];
		return randomLastName;
	}
	//get a random document type from the array of documentTypes
	public String documentType () {
		/*First, a random index is obtained within the number of indexes of the array and then .
		 * the name is obtained through the index obtained.
		 */
		Random random = new Random();
		int randomType = random.nextInt(documentTypes.length);
		String Type =documentTypes[randomType];
		return Type;
	}
	//get a random product from the array of stationeryProducts
	public String stationeryProduct() {
		Random random = new Random();
		int randomNumberProduct = random.nextInt(stationeryProducts.length);
		String randomProduct =stationeryProducts[randomNumberProduct];
		return randomProduct;
	}
	//get a random feature from the array of characteristics
	public String characteristicsProduct() {
		Random random = new Random();
		int randomcharacProduct = random.nextInt(characteristics.length);
		String characProduct =characteristics[randomcharacProduct];
		return characProduct;
	}
}
