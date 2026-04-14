import java.util.Random;

public class GestorLista {

    public static void main(String[] args) {

        Random ran = new Random();

        ListaSecuencial lista = new ListaSecuencial();
        PilaSecuencial pila = new PilaSecuencial();
        ColaSecuencial cola = new ColaSecuencial();

        System.out.println("LISTA SECUENCIAL");

        lista.limpiarCrear();
        for (int i = 0; i < 95; i++) {
            lista.lista[i] = ran.nextInt(1000) + 1;
            lista.llenas++;
        }

        System.out.println("-- Lista con 95 datos aleatorios --");
        lista.verLista();

        System.out.println("\n-- Insertar dato=10000, posicion=900 --");
        lista.Insertar(10000, 900);
        lista.verLista();

        System.out.println("\n-- Insertar dato=10, posicion=20 --");
        lista.Insertar(10, 20);
        lista.verLista();

        System.out.println("\n-- Insertar dato=25, posicion=5 --");
        lista.Insertar(25, 5);
        lista.verLista();

        System.out.println("\n-- Eliminar dato=10 --");
        lista.eliminarDato(10);
        lista.verLista();

        System.out.println("\n-- Eliminar dato=1000 --");
        lista.eliminarDato(1000);
        lista.verLista();

        System.out.println("\n-- Llenar lista completamente --");
        lista.limpiarCrear();
        for (int i = 0; i < 1000; i++) {
            lista.lista[i] = ran.nextInt(1000) + 1;
            lista.llenas++;
        }

        System.out.println("\n-- Busqueda secuencial dato 1000 --");
        lista.busquedaSecuencial(1000);

        System.out.println("\n-- Ordenar burbuja menor a mayor --");
        lista.burbujaMenoraMayor();
        lista.verLista();

        System.out.println("\n-- Busqueda binaria dato 1000 --");
        lista.busquedaBinaria(1000);

        System.out.println("\n-- Busqueda binaria dato 10 --");
        lista.busquedaBinaria(10);

        System.out.println("\n-- Ordenar burbuja mayor a menor --");
        lista.burbujaMayoraMenor();
        lista.verLista();

        System.out.println("\n-- Busqueda secuencial dato 1000 --");
        lista.busquedaSecuencial(1000);

        System.out.println("\n-- Busqueda binaria dato 10 --");
        lista.busquedaBinaria(10);

        System.out.println("\n-- Ordenar quicksort menor a mayor --");
        lista.quicksortMenorAmayor();
        lista.verLista();

        System.out.println("\n-- Limpiar lista --");
        lista.limpiarCrear();
        lista.verLista();

        System.out.println("COLA SECUENCIAL");

        cola.limpiarCrear();

        System.out.println("-- Insertar 10 datos aleatorios --");
        cola.llenar();

        System.out.println("\n-- Ver cola --");
        cola.MostrarCola();

        System.out.println("\n-- Eliminar 5 datos --");
        for (int i = 0; i < 5; i++) {
            cola.Eliminarcola();
        }

        System.out.println("\n-- Ver cola --");
        cola.MostrarCola();

        System.out.println("PILA SECUENCIAL");

        pila.crear();

        System.out.println("-- Insertar 10 datos aleatorios --");
        pila.llenarAleatorio();

        System.out.println("-- Ver pila --");
        pila.verPila();

        System.out.println("\n-- Eliminar 5 datos --");
        for (int i = 0; i < 5; i++) {
            pila.eliminar();
        }

        System.out.println("-- Ver pila --");
        pila.verPila();

    }
}
