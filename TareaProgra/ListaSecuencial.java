import java.util.*;

public class ListaSecuencial {

    public int[] lista;
    public int llenas = 0;
    Random ran = new Random();
    Scanner sc = new Scanner(System.in);

    public ListaSecuencial() {
        this.lista = new int[1000];

    }

    public int limpiarCrear() {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = -1;
        }
        llenas = 0;
        return llenas;

    }

    public boolean Insertar(int val, int pos) {

        if (llenas == 1000) {
            System.out.println(
                    "la lista se encuentra llena, si desea ingresar un dato primero debe limpiar la lista o eliminar un dato");
        } else {
            if (lista[pos] != -1) { // verificar si la posicion esta llena
                for (int i = 999; i >= pos; i--) {
                    lista[i] = lista[i - 1];

                }

                lista[pos - 1] = val;
                llenas++;

            } else {
                if (lista[pos - 2] != -1) {
                    lista[pos - 1] = val;
                } else {
                    lista[llenas] = val;

                }
                System.out.println("Su numero fue puesto en la primera casilla vacia");
                llenas++;

            }
        }

        return true;
    }

    public boolean eliminarPosicion(int posicion) {
        boolean flag = true;
        posicion--;
        for (int i = posicion; i < llenas - 1; i++) {
            lista[i] = lista[i + 1];
        }
        lista[llenas - 1] = -1;
        llenas--;
        flag = true;
        return flag;

    }

    public boolean eliminarDato(int val) {
        int pos = -1;
        boolean flag = true;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == val) {
                pos = i;
                break;

            }
        }

        if (pos != -1) {

            for (int j = pos; j < llenas - 1; j++) {
                lista[j] = lista[j + 1];
            }
            lista[llenas - 1] = -1;
            llenas--;
            flag = true;

        } else {
            System.out.println("Este dato no existe en la lista");
            flag = false;
        }

        return flag;
    }

    public void burbujaMenoraMayor() {
        int extra = 0; // varibale para hacer el cambio de posiciones
        for (int i = 0; i < llenas - 1; i++) {
            for (int j = 0; j < llenas - 1 - i; j++) {
                if (lista[j] > lista[j + 1]) {
                    extra = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = extra;
                }
            }
        }
    }

    public void burbujaMayoraMenor() {
        int extra = 0; // varibale para hacer el cambio de posiciones
        for (int i = 0; i < llenas - 1; i++) {
            for (int j = 0; j < llenas - 1 - i; j++) {
                if (lista[j] < lista[j + 1]) {
                    extra = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = extra;
                }
            }
        }
    }

    public void quicksortMayoraMenor() {
        quicksort(0, llenas - 1);
    }

    private void quicksort(int inicio, int fin) {
        if (inicio < fin) {
            int posPivote = partir(inicio, fin);
            quicksort(inicio, posPivote - 1); // ordenar lado izquierdo
            quicksort(posPivote + 1, fin); // ordenar lado derecho
        }
    }

    private int partir(int inicio, int fin) {
        int pivote = lista[fin]; // el último es el pivote
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (lista[j] >= pivote) {
                i++;

                int temp = lista[i];// intercambiar lista[i] y lista[j]
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }

        int temp = lista[i + 1];
        lista[i + 1] = lista[fin];
        lista[fin] = temp;

        return i + 1;
    }

    public void quicksortMenorAmayor() {
        quicksort2(0, llenas - 1);
    }

    private void quicksort2(int inicio, int fin) {
        if (inicio < fin) {
            int posPivote = partir2(inicio, fin);
            quicksort2(inicio, posPivote - 1); // ordenar lado izquierdo
            quicksort2(posPivote + 1, fin); // ordenar lado derecho
        }
    }

    private int partir2(int inicio, int fin) {
        int pivote = lista[fin]; // el último es el pivote
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (lista[j] <= pivote) {
                i++;

                int temp = lista[i];// intercambiar lista[i] y lista[j]
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }
        int temp = lista[i + 1];
        lista[i + 1] = lista[fin];
        lista[fin] = temp;

        return i + 1;
    }

    public int busquedaSecuencial(int val) {
        for (int i = 0; i < llenas; i++) {
            if (lista[i] == val) {
                System.out.println("Dato " + val + " encontrado en posicion " + (i + 1));
                return i + 1;
            }
        }
        System.out.println("Dato " + val + " no encontrado");
        return -1;
    }

    public int busquedaBinaria(int val) {
        boolean ordenada = true;
        for (int i = 0; i < llenas - 1; i++) {// verificar si está ordenada
            if (lista[i] > lista[i + 1]) {
                ordenada = false;
                break;
            }
        }

        if (!ordenada) {
            System.out.println("La lista no esta ordenada, primero ordene la lista");
            return -1;
        }

        int low = 0;
        int high = llenas - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (lista[mid] == val) {
                System.out.println("Dato " + val + " encontrado en posicion " + (mid + 1));
                return mid + 1;
            } else if (lista[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Dato no encontrado");
        return -1;
    }

    public void verLista() {
        for (int i = 0; i < llenas; i++) {
            System.out.print(lista[i] + "| ");
        }
        System.out.println("llenas es: " + llenas);
    }

}
