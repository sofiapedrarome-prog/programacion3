
import java.util.*;

public class ColaSecuencial {

    public int[] lista;
    public int llenas = 0;
    Random ran = new Random();
    Scanner sc = new Scanner(System.in);

    public ColaSecuencial() {
        this.lista = new int[1000]; // crea la lista
    }

    public int limpiarCrear() {
        for (int i = 0; i < lista.length; i++) { // deja todos los valores de la lista en -1
            lista[i] = -1;
        }

        return llenas;

    }

    public boolean Insertarcola() {
        int val = 0;

        do {
            System.out.println("Indique el numero que desea ingresar en la lista (numero del 0 a 1000);");
            val = sc.nextInt();
            if (val < 0 || val > 1000) { // evalua el valor ingresado por el usuario
                System.out.println("Numero invalido, digite nuevamente");
            } else {
            }
        } while (val < 0 || val > 1000); // ejecuta mientras que el valor este dentro del rango

        for (int i = 0; i < llenas; i++) {
            lista[llenas] = val; // inserta el valor en la primera casilla dispnible
        }

        System.out.println("");
        return true;
    }

    public boolean Eliminarcola() {
        lista[0] = -1;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != -1) { // elimina el la primera casilla de la lista
                lista[i - 1] = lista[i]; // corre los elementos de la lista hacia la izquierda 1 casilla
            } else {

            }
        }
        lista[llenas] = -1; // deja vacia la casilla que tenia numero

        llenas = llenas - 1; // disminuye el valor de las llenas cada que elimina

        System.out.println("Se elimino el elemento de la primera posicion");

        for (int i = 0; i < llenas; i++) {
            System.out.print(lista[i] + " | ");
        }

        return true;
    }

    public int llenar() {

        for (int i = 0; i < 10; i++) {
            lista[i] = ran.nextInt(101);
            llenas++;

        }
        for (int i = 0; i < llenas; i++) {
            System.out.print(lista[i] + " | ");
        }
        return llenas;
    }

    public void MostrarCola() {
        for (int i = 0; i < llenas; i++) { // muestra la lista segun posicion y valor
            System.out.println("Posicion " + i + ": " + lista[i]);
        }
    }

}
