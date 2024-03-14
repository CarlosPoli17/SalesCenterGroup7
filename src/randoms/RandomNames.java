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
}
