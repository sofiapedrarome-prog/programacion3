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

    public boolean Insertar() {
        int val = 0;
        int pos = 0;
        if (llenas == 1000) {
            System.out.println(
                    "la lista se encuentra llena, si desea ingresar un dato primero debe limpiar la lista o eliminar un dato");
        } else {
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

    public boolean eliminarPosicion() {
        boolean flag = true;
        int posicion = 0;
        do {
            System.out.println("Que posicion desea eliminar (1 a " + llenas + ")?");
            posicion = sc.nextInt();

            if (posicion < 1 || posicion > llenas) {
                System.out.println("Valor fuera del rango, digite nuevamente");
                flag = false;
            }

        } while (posicion < 1 || posicion > llenas);

        posicion--;
        for (int i = posicion; i < llenas - 1; i++) {
            lista[i] = lista[i + 1];
        }
        lista[llenas - 1] = -1;
        llenas--;
        flag = true;
        return flag;

    }

    public boolean eliminarDato() {
        int val = 0;
        boolean flag = true;
        int pos = -1;
        ; // verifica si el dato existe
        do {
            System.out.println(
                    "que dato desea eliminar (0 a 1000)? Si se dato se encuentra repetido solo se borrara el primero");
            val = sc.nextInt();

            if (val < 1 || val > 1000) { // verificar los datos ingresados
                System.out.println("Valor fuera del rango, digite nuevamente");
            }
        } while (val < 1 || val > 1000);

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
            System.out.println("En esta posicion no hay nmigun dato actualmente");
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
                // intercambiar lista[i] y lista[j]
                int temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }
        // poner el pivote en su lugar correcto
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
                // intercambiar lista[i] y lista[j]
                int temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }
        // poner el pivote en su lugar correcto
        int temp = lista[i + 1];
        lista[i + 1] = lista[fin];
        lista[fin] = temp;

        return i + 1;
    }

    public int busquedaSecuencial() {
        int val = 0;
        do {
            System.out.println("Que dato desea buscar (1 a 1000)?");
            val = sc.nextInt();
            if (val < 1 || val > 1000) {
                System.out.println("Valor fuera del rango, digite nuevamente");
            }
        } while (val < 1 || val > 1000);

        for (int i = 0; i < llenas; i++) {
            if (lista[i] == val) {
                System.out.println("Dato " + val + " encontrado en posicion " + (i + 1));
                return i + 1;
            }
        }
        System.out.println("Dato " + val + " no encontrado");
        return -1;
    }

    public int busquedaBinaria() {
        int val = 0;
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

        do {
            System.out.println("Que dato desea buscar (1 a 1000)?");
            val = sc.nextInt();
            if (val < 1 || val > 1000) {
                System.out.println("Valor fuera del rango, digite nuevamente");
            }
        } while (val < 1 || val > 1000);

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
