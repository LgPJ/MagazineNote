import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MagazineNote {

    public static boolean canWriteNoteWithMagazine(String note, String magazine) {
        // Crear un mapa para contar los caracteres en la revista
        Map<Character, Integer> magazineCharCount = new HashMap<>();

        // Contar cada carácter en la revista
        for (char c : magazine.toCharArray()) {
            magazineCharCount.put(c, magazineCharCount.getOrDefault(c, 0) + 1);
        }

        // Verificar si la nota puede ser escrita usando los caracteres de la revista
        for (char c : note.toCharArray()) {
            if (!magazineCharCount.containsKey(c) || magazineCharCount.get(c) == 0) {
                return false; // No se puede escribir la nota
            }
            magazineCharCount.put(c, magazineCharCount.get(c) - 1);
        }

        return true; // Se puede escribir la nota
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la nota desde la consola
        System.out.println("Ingrese la nota que desea escribir:");
        String note = scanner.nextLine();

        // Leer la revista desde la consola
        System.out.println("Ingrese el texto completo de la revista:");
        String magazine = scanner.nextLine();

        // Determinar si la nota puede ser escrita con la revista dada
        boolean result = canWriteNoteWithMagazine(note, magazine);
        if(result){
            System.out.println("Se puede escribir la nota: " + note);
        }else{
            System.out.println("No se puede escribir la nota");
        }

        scanner.close();
    }
}