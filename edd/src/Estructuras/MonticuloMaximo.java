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

  public boolean esMontMin(T[] arreglo) {
    int k = arreglo.length;
    T[] arr = nuevoArreglo(k);
    for (int h = 0; h < arreglo.length; h++) {
      T aux = arreglo[h];
      arr[h] = aux;
    }
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != null) {
        int hi = (i * 2) + 1;
        int hd = hi + 1;
        if (hi < arr.length) {
          if (arr[hi] != null) {
            if (
              arr[i].compareTo(arr[hi]) > 0 || arr[hi].compareTo(arr[i]) == 0
            ) {
              return false;
            }
          }
        }

        if (hd < arr.length) {
          if (arr[hd] != null) {
            if (
              arr[i].compareTo(arr[hd]) > 0 || arr[hd].compareTo(arr[i]) == 0
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

  public void arregloMin(T[] arr) {
    int k, mitad = (arr.length / 2) + 1;
    for (k = mitad; k >= 0; k--) {
      ordenarAbajo(arr, k);
    }
  }

  public MonticuloMinimo MontMax_MontMin(T[] arr) {
    Lista<T> lista = new Lista<T>();
    arregloMin(arr);
    int k;
    for (k = 0; k < arr.length; k++) {
      lista.add(arr[k]);
    }
    MonticuloMinimo<T> monti = new MonticuloMinimo<T>(lista, arr.length);
    return monti;
  }

  /**
   * Ordena la colección usando HeapSort.
   * @param <T> tipo del que puede ser el arreglo.
   * @param coleccion la colección a ordenar.
   * @return una lista ordenada con los elementos de la colección.
   */
  public <T extends Comparable<T>> Lista<T> heapSort(Collection<T> colec) {
    Lista<Adaptador<T>> lAdaptador = new Lista<Adaptador<T>>();
    Lista<T> list = new Lista<T>();
    for (T elem : colec) {
      System.out.println(elem);
      lAdaptador.add(new Adaptador<>(elem));
    }
    System.out.println("LISTA");
    System.out.println(lAdaptador);
    MonticuloMinimo<Adaptador<T>> monti = new MonticuloMinimo<Adaptador<T>>(
      lAdaptador,
      lAdaptador.size()
    );

    System.out.println("MONTI");
    System.out.println(monti);

    //Lista<T> l = new Lista<T>();
    // void
    return list;
  }
}