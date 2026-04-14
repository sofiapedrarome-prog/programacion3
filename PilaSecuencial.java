import java.util.Random;

public class PilaSecuencial {

        public int[] pila;
        public int tope = 0;
        Random ran = new Random();

        public PilaSecuencial() {
            pila = new int[1000]; // Se crea la pila con tamaño cualquier tamaño
            crear();
        }

        public void crear() {
            for (int i = 0; i < pila.length; i++) { // Recorre toda la pila
                pila[i] = -1;
            }
            tope = 0;
        }

        public void insertar(int dato) {
            if (tope < 1000) { // Verifica que no esté llena
                pila[tope] = dato; // Inserta el dato en la posición actual
                tope++; // Aumenta el tope (sube)
            } else {
                System.out.println("Pila llena");
            }
        }

        public void eliminar() {
            if (tope > 0) { // Verifica que no esté vacía
                pila[tope - 1] = -1; // Borra el último dato
                tope--; // Baja el tope (elimina el último)
            } else {
                System.out.println("Pila vacía");
            }
        }

    public void verPila() {
        for (int i = 0; i < tope; i++) {   // Recorre solo los datos llenos y Imprime cada elemento
            System.out.print(pila[i] + " | "); 
        }
        System.out.println();
    }

        public void llenarAleatorio() {
            for (int i = 0; i < 10; i++) {
                insertar(ran.nextInt(100) + 1);
            }
        }
}
