package edd.src.Estructuras;

import java.time.Year;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MonticuloMaximo<T extends ComparableIndexable<T>>
  implements Collection<T> {

  /* numero de elementos en el arreglo */
  private int elementos;
  /* Nuestro arbol representado como arreglo */
  private T[] arbol;

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
    if (padre >= 0 && arbol[padre].compareTo(arbol[i]) > 0) {
      m = padre;
    }
    if (m != i) {
      this.swap(arbol[i], arbol[m]);
      recorreArriba(m);
    }
  }

  @Override
  public boolean contains(T elemento) {
    for (T e : arbol) {
      if (elemento.equals(e)) return true;
    }
    return false;
  }

  /**
   * Elimina el elemento minimo del monticulo
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
    if (izq >= elementos && der >= elementos) {
      return;
    }
    if (izq < elementos) {
      if (der < elementos) {
        if (arbol[izq].compareTo(arbol[der]) < 0) {
          min = izq;
        }
      } else {
        min = izq;
      }
    }
    if (arbol[min].compareTo(arbol[i]) < 0) {
      //Este swap ya esta
      swap(arbol[i], arbol[min]);
      recorreAbajo(i);
    }
  }

  /**
   * Revisar
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append('[');
    for (int i = 0; i < elementos; ++i) {
      builder.append(arbol[i]);
      if (i < elementos - 1) {
        builder.append(", ");
      }
    }
    builder.append(']');
    return builder.toString();
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

  /**
   * Revisar si el monticulo esta vacio
   */
  @Override
  public boolean isEmpty() {
    return elementos == 0;
  }

  /**
   * vaciar el monticulo
   */
  @Override
  public void empty() {
    for (int i = 0; i < elementos; i++) {
      arbol[i] = null;
    }
    elementos = 0;
  }

  /**
   * Tamaño del arreglo
   */
  @Override
  public int size() {
    return elementos;
  }

  public T pop() {
    return null;
  }

  /* Con esto podemos crear arreglos genericos sin que el compilador marque error */
  @SuppressWarnings("unchecked")
  private T[] nuevoArreglo(int n) {
    return (T[]) (new ComparableIndexable[n]);
  }
}
