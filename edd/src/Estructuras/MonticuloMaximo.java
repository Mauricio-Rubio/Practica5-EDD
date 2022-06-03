package edd.src.Estructuras;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MonticuloMaximo<T extends ComparableIndexable<T>>
  implements Collection<T> {

  private class Iterador implements Iterator<T> {

    private int indice;

    @Override
    public boolean hasNext() {
      return indice < elementos;
    }

    @Override
    public T next() {
      if (hasNext()) {
        return arbol[indice++];
      }
      throw new NoSuchElementException("No hay, no existe");
    }
  }

  private static class Adaptador<T extends Comparable<T>>
    implements ComparableIndexable<Adaptador<T>> {

    /* El elemento. */
    private T elemento;
    /* El índice. */
    private int indice;

    /* Crea un nuevo comparable indexable. */
    public Adaptador(T elemento) {
      this.elemento = elemento;
      this.indice = -1;
    }

    public String toString() {
      String s;
      s = "" + elemento;
      return s;
    }

    /* Regresa el índice. */
    @Override
    public int getIndice() {
      return this.indice;
    }

    /* Define el índice. */
    @Override
    public void setIndice(int indice) {
      this.indice = indice;
    }

    /* Compara un indexable con otro. */
    @Override
    public int compareTo(Adaptador<T> adaptador) {
      return this.elemento.compareTo(adaptador.elemento);
    }
  }

  /* numero de elementos en el arreglo */
  private int elementos;
  /* Nuestro arbol representado como arreglo */
  private T[] arbol;

  /* Con esto podemos crear arreglos genericos sin que el compilador marque error */
  @SuppressWarnings("unchecked")
  private T[] nuevoArreglo(int n) {
    return (T[]) (new ComparableIndexable[n]);
  }

  public MonticuloMaximo(Collection<T> coleccion) {
    this(coleccion, coleccion.size());
  }

  public MonticuloMaximo() {
    elementos = 0;
    arbol = nuevoArreglo(100);
  }

  public T pop() {
    return null;
  }

  public MonticuloMaximo(Iterable<T> iterable, int n) {
    elementos = n;
    arbol = nuevoArreglo(n);
    int i = 0;
    for (T e : iterable) {
      arbol[i] = e;
      arbol[i].setIndice(i);
      i++;
    }
    for (int j = (elementos - 1) / 2; j >= 0; j--) {
      monticuloMax(j);
    }
  }

  private void monticuloMax(int i) {
    int izq = i * 2 + 1;
    int der = i * 2 + 2;
    int minimo = i;

    if (elementos <= i) {
      return;
    }
    if (izq < elementos && arbol[izq].compareTo(arbol[i]) > 0) {
      minimo = izq;
    }
    if (der < elementos && arbol[der].compareTo(arbol[minimo]) > 0) {
      minimo = der;
    }
    if (minimo == i) {
      return;
    } else {
      swap(arbol[minimo], arbol[i]);
      monticuloMax(minimo);
    }
  }

  @Override
  public void add(T elemento) {
    if (elementos == arbol.length) {
      duplicaSize();
    }
    elemento.setIndice(elementos);
    arbol[elementos] = elemento;
    elementos++;
    recorreArriba(elementos - 1);
  }

  private void duplicaSize() {
    T[] arr = nuevoArreglo(arbol.length * 2);
    elementos = 0;
    for (T e : arbol) {
      arr[elementos++] = e;
    }
    this.arbol = arr;
  }

  private void recorreArriba(int i) {
    int padre = (i - 1) / 2;
    int m = i;
    if (padre >= 0 && arbol[padre].compareTo(arbol[i]) < 0) {
      m = padre;
    }
    if (m != i) {
      this.swap(arbol[i], arbol[m]);
      recorreArriba(m);
    }
  }

  /**
   * Elimina el elemento maximo del monticulo
   *
   */
  public T delete() {
    if (elementos == 0) {
      throw new IllegalStateException("Monticulo vacio");
    }
    T e = arbol[0];
    boolean bool = delete(e);
    if (bool) {
      return e;
    } else {
      return null;
    }
  }

  /**
   * Elimina un elmento del monticulo
   *
   */

  @Override
  public boolean delete(T elemento) {
    if (elemento == null || isEmpty()) {
      return false;
    }
    if (!contains(elemento)) {
      return false;
    }
    int i = elemento.getIndice();
    if (i < 0 || elementos <= i) return false;
    swap(arbol[i], arbol[elementos - 1]);
    arbol[elementos - 1] = null;
    elementos--;
    recorreAbajo(i);
    return true;
  }

  private void swap(T i, T j) {
    int aux = j.getIndice();
    arbol[i.getIndice()] = j;
    arbol[j.getIndice()] = i;
    j.setIndice(i.getIndice());
    i.setIndice(aux);
  }

  private void recorreAbajo(int i) {
    if (i < 0) {
      return;
    }
    int izq = 2 * i + 1;
    int der = 2 * i + 2;
    int min = der;
    //No existen
    //  0, 1
    // [],[]
    if (izq >= elementos && der >= elementos) {
      return;
    }
    if (izq < elementos) {
      if (der < elementos) {
        if (arbol[izq].compareTo(arbol[der]) > 0) {
          min = izq;
        }
      } else {
        min = izq;
      }
    }
    if (arbol[min].compareTo(arbol[i]) > 0) {
      //Este swap ya esta
      swap(arbol[i], arbol[min]);

      recorreAbajo(min);
    }
  }

  @Override
  public boolean contains(T elemento) {
    for (T e : arbol) {
      if (elemento.equals(e)) return true;
    }
    return false;
  }

  @Override
  public boolean isEmpty() {
    return elementos == 0;
  }

  @Override
  public void empty() {
    for (int i = 0; i < elementos; i++) {
      arbol[i] = null;
    }
    elementos = 0;
  }

  @Override
  public int size() {
    return elementos;
  }

  public T get(int i) {
    if (i < 0 || i >= elementos) {
      throw new NoSuchElementException("Indice no valido");
    }
    return arbol[i];
  }

  @Override
  public String toString() {
    String resultado = "";
    for (int i = 0; i < elementos; i++) {
      resultado += arbol[i].toString() + ",";
    }
    return resultado;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    @SuppressWarnings("unchecked")
    MonticuloMaximo<T> monticulo = (MonticuloMaximo<T>) obj;
    if (elementos != monticulo.elementos) {
      return false;
    }
    for (int i = 0; i < elementos; i++) {
      if (!arbol[i].equals(monticulo.arbol[i])) {
        return false;
      }
    }
    return true;
  }

  /**
   * Regresa un iterador para iterar el montículo mínimo. El montículo se
   * itera en orden BFS.
   *
   * @return un iterador para iterar el montículo mínimo.
   */
  @Override
  public Iterator<T> iterator() {
    return new Iterador();
  }

  public <T extends Comparable<T>> boolean esMontMax(T[] arreglo) {
    int k = arreglo.length;
    // T[] arr = nuevoArreglo(k);
    for (int h = 0; h < arreglo.length; h++) {
      T aux = arreglo[h];
      arreglo[h] = aux;
    }
    for (int i = 0; i < arreglo.length; i++) {
      if (arreglo[i] != null) {
        int hi = (i * 2) + 1;
        int hd = hi + 1;
        if (hi < arreglo.length) {
          if (arreglo[hi] != null) {
            if (
              arreglo[i].compareTo(arreglo[hi]) < 0 ||
              arreglo[hi].compareTo(arreglo[i]) == 0
            ) {
              return false;
            }
          }
        }

        if (hd < arreglo.length) {
          if (arreglo[hd] != null) {
            if (
              arreglo[i].compareTo(arreglo[hd]) < 0 ||
              arreglo[hd].compareTo(arreglo[i]) == 0
            ) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  public void intercambiar(T[] arr, int ind1, int ind2) {
    T aux = arr[ind1];
    arr[ind1] = arr[ind2];
    arr[ind2] = aux;
  }

  public void ordenarAbajo(T[] arr, int pos) {
    int hi = (pos * 2) + 1;
    int posN = pos, hd = hi + 1;
    // int a = arr[pos].compareTo(arr[hi]);
    //  int b = arr[pos].compareTo(arr[hd]);

    T aux1 = null, aux2 = null;
    if (hi < arr.length) {
      aux1 = arr[hi];
    }

    if (hd < arr.length) {
      aux2 = arr[hd];
    }

    if (aux1 == null && aux2 == null) {
      return;
    }

    if (aux1 == null && aux2 != null) {
      if (arr[pos].compareTo(aux2) > 0) {
        intercambiar(arr, pos, hd);
        posN = hd;

        ordenarAbajo(arr, posN);
      }
    }

    if (aux1 != null && aux2 == null) {
      if (arr[pos].compareTo(aux1) > 0) {
        intercambiar(arr, pos, hi);
        posN = hi;

        ordenarAbajo(arr, posN);
      }
    }

    if (aux1 != null && aux2 != null) {
      if (aux1.compareTo(aux2) < 0) {
        if (arr[pos].compareTo(aux1) > 0) {
          intercambiar(arr, pos, hi);
          posN = hi;
          ordenarAbajo(arr, posN);
        }
      } else {
        if (arr[pos].compareTo(aux2) > 0) {
          intercambiar(arr, pos, hd);
          posN = hd;
          ordenarAbajo(arr, posN);
        }
      }
    }
    // ordenarAbajo(arr, posN);

  }

  /**
   * Metodo que toma un arreglo que representa un monituculo maximo y lo transforma en un monticulo minimo en complejidad O(n)
   * @param arr Arreglo a trabajar
   * @return MinticuloMinimo
   */
  public MonticuloMaximo<T> MontMin_MontMax(T[] arr) {
    MonticuloMinimo<T> monMin = new MonticuloMinimo<T>();
    if (!monMin.esMontMin(arr)) {
      System.err.println("No es un monticulo minimo");
      return null;
    }
    int k;
    T[] arreglo = nuevoArreglo(arr.length);
    for (k = 0; k < arr.length; k++) { //Clonamos el arreglo que recibimos para que este no se vea afectado. Esto toma O(n)
      arreglo[k] = arr[k];
    }
    Lista<T> lista = new Lista<T>();
    arregloMax(arreglo); //Convertimos el arreglo en un arreglo que represente un monticulo maximo. Tiene complejidad O(n) en tiempo

    for (k = 0; k < arreglo.length; k++) { //recorremos el arreglo y agregamos cada elemento de este en una lista. Igual toma complejidad O(n)
      if (arreglo[k] != null) {
        lista.add(arreglo[k]);
      }
    }
    MonticuloMaximo<T> monti = new MonticuloMaximo<T>(lista, lista.size()); //Creamos el arbol con la lista. Este constructor va añadiendo los elementos de la coleccion.
    // Añadir toma O(1) si no tenemos que reordenar hacia arriba.
    //Como la lista ya representa un MinHeap no tendremos que reordenar, pero tenemos que añadir los n elementos de la lista, por lo cual esto nos toma O(n) en complejidad de tiempo
    //return monti; //Regresamos el monticulo creado
    //Como todas las operaciones nos tomaron O(n) en tiempo y espacio donde "n" es el numero de elementos del arreglo que recibimos, entonces, sea T(n) la complejidad de nuestro algoritmo en tiempo y  espacio, sucede que T(n) pertenece a O(n)
    return monti;
  }

  /**
   * Metodo que transforma un arreglo en un arreglo que represente un MaxHeap. Este metodo, por lo escrito en las notas del profesor, tiene complejidad O(n) en tiempo.
   * @param <T> tipo del que puede ser el arreglo
   * @param arr
   */
  private <T extends Comparable<T>> void arregloMax(T[] arr) {
    //variables enteras a usar
    int k, mitad = (arr.length / 2) + 1; //mitad representa el indice a la mitad del arreglo
    for (k = mitad; k >= 0; k--) { //partiendo de la mitad del arreglo hacia el indice 0
      ordenarAbajo(arr, k); //ordenamos hacia abajo el arreglo
    }
  }

  /**
   * Metodo para ordenar hacia abajo un arreglo para que represente un MaxHeap
   * @param <T> Tipo del que puede ser el arreglo
   * @param arr Arreglo a manejar
   * @param pos Posicion del arreglo desde la cual deseamos ordenar hacia abajo
   */
  private <T extends Comparable<T>> void ordenarAbajo(T[] arr, int pos) {
    int hi = (pos * 2) + 1; //Indice del hijo izquierdo del elemento desde el cual ordenamos
    int posN = pos, hd = hi + 1; //Indice del hijo derecho del elemento desde el cual ordenamos

    T aux1 = null, aux2 = null; //Elementos auxiliares
    if (hi < arr.length) { //Si existe la posicion de hijo izquierdo en el arreglo
      aux1 = arr[hi]; //El primer auxiliar sera el elemento en la posicion del hijo izquierdo
    }

    if (hd < arr.length) { //Si existe la posicion de hijo izquierdo en el arreglo
      aux2 = arr[hd]; //El segundo auxiliar sera el elemento en la posicion del hijo derecho
    }

    if (aux1 == null && aux2 == null) { //Si no existe hijo izquierdo ni derecho, terminamos
      return;
    }

    if (aux1 == null && aux2 != null) { //Si solo exise hijo derecho
      if (arr[pos].compareTo(aux2) < 0) { //comparamos
        intercambiar(arr, pos, hd); //intercambiamos de ser necesario
        posN = hd; //ahora ordenamos hacia abajo desde la posicion del hijo derecho

        ordenarAbajo(arr, posN);
      }
    }

    if (aux1 != null && aux2 == null) { //Si solo exise hijo izquierdo
      if (arr[pos].compareTo(aux1) < 0) { //comparamos
        intercambiar(arr, pos, hi); //intercambiamos de ser necesario
        posN = hi; //ahora ordenamos hacia abajo desde la posicion del hijo izquierdo

        ordenarAbajo(arr, posN);
      }
    }

    if (aux1 != null && aux2 != null) { //Si exisen ambos hijos
      if (aux1.compareTo(aux2) > 0) { //Si el hijo izquierdo es el maximo entre los hijos
        if (arr[pos].compareTo(aux1) < 0) { //Comparamos con el hijo izquierdo
          intercambiar(arr, pos, hi); //Intercambiamos de ser necesario
          posN = hi; //ahora ordenamos hacia abajo desde el hijo izquierdo
          ordenarAbajo(arr, posN);
        }
      } else { //si el hijo derecho es igual o menor al hijo izquierdo
        if (arr[pos].compareTo(aux2) < 0) { //comparamos el elemento con su hijo derecho
          intercambiar(arr, pos, hd); //intercambiamos de ser necesario
          posN = hd; //ahora ordenamos hacia abajo desde la posicion del hijo derecho
          ordenarAbajo(arr, posN);
        }
      }
    }
  }

  /**
   * Metodo que hace la funcion swap en un arreglo
   * @param <T> Tipo del que puede ser el arreglo
   * @param arr El arreglo a manejar
   * @param ind1 Indice del primer elemento a intercambiar
   * @param ind2 Indice del segundo elemento a intercambiar
   */
  private <T extends Comparable<T>> void intercambiar(
    T[] arr,
    int ind1,
    int ind2
  ) {
    T aux = arr[ind1];
    arr[ind1] = arr[ind2];
    arr[ind2] = aux;
  }
}
