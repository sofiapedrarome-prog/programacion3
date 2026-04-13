import java.util.*;

public class ListaSecuencial {

    public int[] lista;
    public int llenas = 0;

    public static void main(String[] args) {

        ListaSecuencial obj = new ListaSecuencial();
        obj.limpiarCrear();
        obj.llenar();
        // obj.eliminarPosicion();
        obj.Insertar();
    }

    Random ran = new Random();
    Scanner sc = new Scanner(System.in);

    public ListaSecuencial() {
        this.lista = new int[1000];

    }

    public int limpiarCrear() {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = -1;
        }

        System.out.println("llenas es: " + llenas);
        return llenas;

    }

    public boolean Insertar() {
        int val = 0;
        int pos = 0;
        do {
            System.out.println("Que numero desea incluir en la lista (un numero de 0 a 1000)?");
            val = sc.nextInt();

            if (val < 0 || val > 1000) { // verificar los datos ingresados
                System.out.println("Valor fuera del rango, digite nuevamente");
            }
        } while (val < 0 || val > 1000);

        do {
            System.out.println("En que posicion desea incluirlo (1 a 1000)?");
            pos = sc.nextInt();

            if (pos < 1 || pos > 1000) { // verificar los datos ingresados
                System.out.println("Valor fuera del rango, digite nuevamente");
            }
        } while (pos < 1 || pos > 1000);

        if (lista[pos] != -1) { // verificar si la posicion esta llena
            for (int i = 999; i >= pos; i--) {
                lista[i] = lista[i - 1];

            }
            for (int i = 0; i < 10; i++) {
                System.out.print(lista[i] + " | ");
            }
            System.out.println("");
            lista[pos - 1] = val;

            for (int i = 0; i < 10; i++) {
                System.out.print(lista[i] + " | ");
            }
        } else {
            if (lista[pos - 2] != -1) {
                lista[pos - 1] = val;
            } else {
                lista[llenas] = val;

            }
            System.out.println("Su numero fue puesto en la primera casilla vacia");
            for (int i = 0; i < 10; i++) {
                System.out.print(lista[i] + " | ");
            }
        }

        return true;
    }

    public boolean eliminarPosicion() {
        boolean flag;
        System.out.println("¿Que posicion desea eliminar?");
        int posicion = sc.nextInt();

        if (posicion <= llenas && posicion >= 0) {
            lista[posicion] = -1;
            flag = true;
            llenas--;
            while (lista[posicion] < lista[posicion + 1]) { // mover posicion desde donde se elimino
                lista[posicion] = lista[posicion + 1];
                lista[posicion + 1] = -1;

                posicion++;
            }
            for (int i = 0; i < 5; i++) {
                System.out.print(lista[i] + " | ");
            }
        } else {
            System.out.println("Su posición esta fuera del rango");
            flag = false;
        }
        return flag;

    }

    public int llenar() {

        for (int i = 0; i < 5; i++) {
            lista[i] = ran.nextInt(101);
            llenas++;

        }
        for (int i = 0; i < 10; i++) {
            System.out.print(lista[i] + "| ");
        }
        System.out.println("llenas es: " + llenas);
        return llenas;
    }

}
