package edd.src.Estructuras;

import java.time.Year;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * Clase para monticulos minimos (Minheaps)
 * @author Alcantara Estrada Kevin Isaac
 * @author Rubio Haro Mauricio
*/
public class MonticuloMinimo<T extends ComparableIndexable<T>> implements Collection<T>{
    
    /**
     * Clase iterador para recorrer la estructura
     */
    private class Iterador implements Iterator<T>{
        //Atributos de la clase
        private int indice;
        
        /**
         * Metodo para saber si hay siguiente elemento
         * @return boolean
         */
        @Override public boolean hasNext(){
            return indice < elementos;
        }
        /**
         * Metodo que devuelve el siguiente elemento de la estructura
         * @return T
         */
        @Override public T next(){
            if (hasNext()) {
                return arbol[indice++];
            }
            throw new NoSuchElementException("No hay, no existe");
        }

    @Override
    public boolean hasNext() {
      return indice < elementos;
    }

/**
 * Clase para convertir un elemento T en un objeto que pueda ser contenido en el MinHeap
 */
    private static class Adaptador<T extends Comparable<T>>
    implements ComparableIndexable<Adaptador<T>>{
        /* El elemento. */
        private T elemento;
        /* El índice. */
        private int indice;

        /* Crea un nuevo comparable indexable. */
        public Adaptador(T elemento) {
            this.elemento = elemento;
            this.indice = -1;
        }
        /**
         * Metodo para representar en cadena al objeto
         * @return String
         */
        public String toString(){
            String s;
            s=""+elemento;
            return s;
        }
        /* Regresa el índice. */
        @Override
        public int getIndice() {
            return this.indice;
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
/**
 * Constructor sin parametros de la clase
 */
    public MonticuloMinimo(){
        elementos = 0;
        arbol = nuevoArreglo(100);
    }
    /*Metodo para que no chille el compilador */
    public T pop(){
        return null;
    }
/**
 * Metodo para construir un MInHeap a partir de un objeto de la clase COllection
 * @param coleccion Objeto de la clase Collection para construir el MinHeap
 */
    public MonticuloMinimo(Collection<T> coleccion){
        this(coleccion, coleccion.size());
      }

      /**
       * Metodo para construir un MinHeap a partir de un objeto de la clase Iterable y el numero de elementos de tal objeto
       * @param iterable objeto de la clase Iterable
       * @param n Numero de elementos de iterable
       */
    public MonticuloMinimo(Iterable<T> iterable, int n ){
        elementos = n;
        arbol = nuevoArreglo(n);
        int i = 0;
        for (T e : iterable) {
           arbol[i] = e;
           arbol[i].setIndice(i);
           i ++;
        }
        for(int j = (elementos-1) /2; j >= 0; j--){
            monticuloMin(j);
            
        }
    }

    /**
     * 
     * @param i
     */
    private void monticuloMin(int i){
        int izq = i * 2 +1 ;
        int der = i * 2 + 2;
        int minimo = i;

  public T pop() {
    return null;
  }

  public MonticuloMinimo(Collection<T> coleccion) {
    this(coleccion, coleccion.size());
  }

  public MonticuloMinimo(Iterable<T> iterable, int n) {
    elementos = n;
    arbol = nuevoArreglo(n);
    int i = 0;
    for (T e : iterable) {
      arbol[i] = e;
      arbol[i].setIndice(i);
      i++;
    }
    /**
     * Metodo para agregar un elemento al MinHeap
     * @param elemento Elemento a agregar
     */
    @Override public void add(T elemento){
        if (elementos == arbol.length) {
            duplicaSize();
        }
        elemento.setIndice(elementos);
        arbol[elementos] = elemento;
        elementos++;
        recorreArriba(elementos - 1);
    }
    if (izq < elementos && arbol[izq].compareTo(arbol[i]) < 0) {
      minimo = izq;
    }
    if (der < elementos && arbol[der].compareTo(arbol[minimo]) < 0) {
      minimo = der;
    }
    if (minimo == i) {
      return;
    } else {
      swap(arbol[minimo], arbol[i]);
      monticuloMin(minimo);
    }
  }

    /**
     * Metodo que duplica el tamaño del arreglo de elementos de nuestro MinHeap
     */
    private void duplicaSize(){
        T[] arr = nuevoArreglo(arbol.length * 2);
        elementos = 0;
        for(T e: arbol){
            arr[elementos++] = e;
        }
        this.arbol = arr;
    }
/**
 * Metodo para reordenar el MinHeap desde una elemento del MinHeap hacia la raiz
 * @param i Indice del elemento desde el cual deseamos reordenar
 */
    private void recorreArriba(int i){
        int padre = (i-1) / 2;
        int m = i;
        if(padre >= 0 && arbol[padre].compareTo(arbol[i]) > 0){
            m = padre;
        }
        if (m!= i) {
            this.swap(arbol[i],arbol[m]);
            recorreArriba(m);
        }
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

    /**
     * Elimina un elemento del monticulo
     * 
     */

    @Override public boolean delete(T elemento){
        if(elemento ==null || isEmpty() ){
            return false;
        }
        if(!contains(elemento)){
            return false;
        }
        int i = elemento.getIndice();
        if(i <0 || elementos <=i )
            return false;
        swap(arbol[i], arbol[elementos -1]);
        arbol[elementos -1] = null;
        elementos --;
        recorreAbajo(i);
        return true;
    }
    /**
     * Metodo que intercambia dos elementos del MinHeap
     * @param i Indice del primer elemento a intercambiar
     * @param j Indice del segundo elemento a intercambiar
     */
    private void swap(T i, T j) {
        int aux = j.getIndice();
        arbol[i.getIndice()] = j;
        arbol[j.getIndice()] = i;
        j.setIndice(i.getIndice());
        i.setIndice(aux);
    }
/**
 * Metodo que reordena el MinHeap desde un elemento hacia las hojas
 * @param i Indice del elemento desde el cual reordenamos hacia abajo
 */
    private void recorreAbajo(int i){
        if(i < 0){
            return;
        }
        int izq = 2*i +1;
        int der = 2*i +2;
        int min = der;
        //No existen
        //  0, 1
        // [],[]
        if(izq >= elementos && der >= elementos){
            return;
        }
        if(izq < elementos){
            if (der < elementos) {
                if (arbol[izq].compareTo(arbol[der]) <0 ) {
                    min = izq;
                }
            }
            else{
                min = izq;
            }
        }
        if(arbol[min].compareTo(arbol[i])<0){
            //Este swap ya esta 
            swap(arbol[i], arbol[min]);
            
            recorreAbajo(min);
            
        }
        
        

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

    /**
     * Metodo para saber si un elemento ya se encuentra en el MinHeap
     * @param elemento Elemento el cual se quiere saber si esta en la estructura
     * @return boolean
     */
    @Override public boolean contains(T elemento){
        for(T e: arbol){
            if(elemento.equals(e))
                return true;
        }
        return false;
    }
    /**
     * Metodo para saber si el MinHeap esta vacio
     * @return boolean
     */
    @Override public boolean isEmpty(){
        return elementos == 0;
    }
    
    /**
     * Metodo para vaciar el MinHeap
     */
    @Override
    public void empty() {
        for (int i = 0; i < elementos; i++) {
            arbol[i] = null;
        }
      } else {
        min = izq;
      }
    }
    if (arbol[min].compareTo(arbol[i]) < 0) {
      //Este swap ya esta
      swap(arbol[i], arbol[min]);

    /**
     * Metodo para conocer el tamaño del MinHeap
     * @return int
     */
    @Override
    public int size(){
        return elementos;
    }
  }

    /**
     * Metodo para obtener el elemento minimo del MinHeap
     * @param i indice del elemento que deseamos obtener
     * @return T
     */
    public T get(int i){
        if (i< 0 || i>= elementos) {
            throw new NoSuchElementException("Indice no valido");
        }
        return arbol[i];
    }
    return false;
  }

/**
 * Metodo para representar en cadena los MinHeap
 * @return String
 */
    @Override public String toString(){
        String resultado ="";
        for (int i = 0; i <elementos; i++) {
            resultado += arbol[i].toString() + ",";
        }
        return resultado;
    }
    elementos = 0;
  }

    /**
     * Metodo para comparar nuestro MinHeap con otro MinHeap
     * @param obj Instancia de la clase con la cual haremos la comparacion
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(obj==null || getClass() != obj.getClass()){
            return false;
        }
        @SuppressWarnings("unchecked") MonticuloMinimo<T> monticulo = (MonticuloMinimo<T>)obj;
        if (elementos != monticulo.elementos) {
            return false;
        }
        for (int i = 0; i < elementos; i++) {
            if(!arbol[i].equals(monticulo.arbol[i])){
                return false;
            }
        }
        return true;
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

   
   
/**
 * Metodo para ver si un arreglo representa un MinHeap o no
 * @param <T> Tipo del que puede ser el arreglo
 * @param arreglo Arreglo sobre el cual deseamos hacer la verificiacion
 * @return boolean
 */
public <T extends Comparable<T>> boolean esMontMin(T[] arreglo){
    
    for(int i=0; i<arreglo.length; i++){//Recorremos el arreglo de forma iterativa
    if(arreglo[i]!=null){//Verificamos que el objeto contenido en el arreglo no sea null
    int hi = (i*2)+1;//Denotamos el indice del hijo izquierdo del elemento del arreglo que estamos revisando
    int hd=hi+1;//Denotamos el indice del hijo derecho del elemento del arreglo que estamos revisando
    if(hi<arreglo.length){//Verificamos que existe un espacio para el hijo izquierdo en el arreglo
    if(arreglo[hi]!=null){//Verificamos que tal espacio no es null
    	if(arreglo[i].compareTo(arreglo[hi])>0 ){//Comparamos el elemento con su hjo izquierdo
    		return false;
    	}
    }
    for (int i = 0; i < elementos; i++) {
      if (!arbol[i].equals(monticulo.arbol[i])) {
        return false;
      }
    }
    
    if(hd<arreglo.length){//Verificamos que existe un espacio para el hijo derecho en el arreglo
     if(arreglo[hd]!=null){//Verificamos que tal espacio no es null
    	if(arreglo[i].compareTo(arreglo[hd])>0){//Comparamos el elemento con su hjo derecho
    		return false;
    	}
    }
    }
    
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

  public <T extends Comparable<T>> boolean esMontMin(T[] arreglo) {
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
              arreglo[i].compareTo(arreglo[hi]) > 0 ||
              arreglo[hi].compareTo(arreglo[i]) == 0
            ) {
              return false;
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
    private <T extends Comparable<T>>void intercambiar(T[] arr, int ind1, int ind2){
        T aux = arr[ind1];
        arr[ind1]=arr[ind2];
        arr[ind2]= aux;
    }

    /**
     * Metodo para ordenar hacia abajo un arreglo para que represente un MinHeap
     * @param <T> Tipo del que puede ser el arreglo
     * @param arr Arreglo a manejar
     * @param pos Posicion del arreglo desde la cual deseamos ordenar hacia abajo
     */
private <T extends Comparable<T>> void ordenarAbajo(T[] arr, int pos){
    int hi = (pos*2)+1;//Indice del hijo izquierdo del elemento desde el cual ordenamos
    int posN=pos,hd= hi+1;//Indice del hijo derecho del elemento desde el cual ordenamos

    T aux1=null, aux2=null;//Elementos auxiliares
    if(hi<arr.length){//Si existe la posicion de hijo izquierdo en el arreglo
        aux1= arr[hi]; //El primer auxiliar sera el elemento en la posicion del hijo izquierdo
    }

    if(hd<arr.length){//Si existe la posicion de hijo izquierdo en el arreglo
        aux2= arr[hd];//El segundo auxiliar sera el elemento en la posicion del hijo derecho
    }

    if(aux1==null && aux2==null){//Si no existe hijo izquierdo ni derecho, terminamos
        return;
    }

    if(aux1==null && aux2!=null){//Si solo exise hijo derecho
        if(arr[pos].compareTo(aux2)>0){//comparamos
        intercambiar(arr, pos, hd);//intercambiamos de ser necesario
        posN=hd;//ahora ordenamos hacia abajo desde la posicion del hijo derecho
    
   ordenarAbajo(arr, posN);
        }
    

        ordenarAbajo(arr, posN);
      }
    }

    if(aux1!=null && aux2==null){//Si solo exise hijo izquierdo
        if(arr[pos].compareTo(aux1)>0){//comparamos
        intercambiar(arr, pos, hi);//intercambiamos de ser necesario
        posN=hi;//ahora ordenamos hacia abajo desde la posicion del hijo izquierdo
    
   ordenarAbajo(arr, posN);
        }
    }

    if(aux1!=null && aux2!=null){//Si exisen ambos hijos
        if(aux1.compareTo(aux2)<0){//Si el hijo izquierdo es el minimo entre los hijos
            if(arr[pos].compareTo(aux1)>0){//Comparamos con el hijo izquierdo
            intercambiar(arr, pos, hi);//Intercambiamos de ser necesario
            posN=hi;//ahora ordenamos hacia abajo desde el hijo izquierdo
           ordenarAbajo(arr, posN);
            }
        }else{//si el hijo derecho es igual o menor al hijo izquierdo
            if(arr[pos].compareTo(aux2)>0){//comparamos el elemento con su hijo derecho
            intercambiar(arr, pos, hd);//intercambiamos de ser necesario
            posN=hd;//ahora ordenamos hacia abajo desde la posicion del hijo derecho
            ordenarAbajo(arr, posN);
            }
        }
    } 
        
}
    /**
     * Metodo que transforma un arreglo en un arreglo que represente un MinHeap. Este metodo, por lo escrito en las notas del profesor, tiene complejidad O(n) en tiempo.
     * @param <T> tipo del que puede ser el arreglo
     * @param arr
     */
    private <T extends Comparable<T>> void arregloMin(T[] arr){
       //variables enteras a usar
        int k,mitad = (arr.length/2)+1;//mitad representa el indice a la mitad del arreglo
        for(k=mitad; k>=0;k--){//partiendo de la mitad del arreglo hacia el indice 0 
            ordenarAbajo(arr, k);//ordenamos hacia abajo el arreglo
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

    /**
     * Metodo que toma un arreglo que representa un monituculo maximo y lo transforma en un monticulo minimo en complejidad O(n)
     * @param arr Arreglo a trabajar
     * @return MinticuloMinimo
     */
    public MonticuloMinimo MontMax_MontMin(T[] arr){
        int k; 
        T[] arreglo = nuevoArreglo(arr.length);
        for(k=0; k<arr.length;k++){//Clonamos el arreglo que recibimos para que este no se vea afectado. Esto toma O(n)
            arreglo[k]=arr[k];
        }
        Lista<T> lista = new Lista<T>();
        arregloMin(arreglo);//Convertimos el arreglo en un arreglo que represente un monticulo minimo. Tiene complejidad O(n) en tiempo
        
        for(k=0; k<arreglo.length;k++){//recorremos el arreglo y agregamos cada elemento de este en una lista. Igual toma complejidad O(n)
            if(arreglo[k]!=null){
            lista.add(arreglo[k]);
            }
        }
        MonticuloMinimo<T> monti = new MonticuloMinimo<T>(lista, lista.size());//Creamos el arbol con la lista. Este constructor va añadiendo los elementos de la coleccion.
                                                                            // Añadir toma O(1) si no tenemos que reordenar hacia arriba. 
                                                                             //Como la lista ya representa un MinHeap no tendremos que reordenar, pero tenemos que añadir los n elementos de la lista, por lo cual esto nos toma O(n) en complejidad de tiempo
        return monti;//Regresamos el monticulo creado
        //Como todas las operaciones nos tomaron O(n) en tiempo y espacio donde "n" es el numero de elementos del arreglo que recibimos, entonces, sea T(n) la complejidad de nuestro algoritmo en tiempo y  espacio, sucede que T(n) pertenece a O(n)
    }
 /**
    * Ordena la colección usando HeapSort.
    * @param <T> tipo del que puede ser el arreglo.
    * @param coleccion la colección a ordenar.
    * @return una lista ordenada con los elementos de la colección.
    */
    public <T extends Comparable<T>> Lista<T>  heapSort(Collection<T> colec){
        
      
        Lista<Adaptador<T>> lAdaptador = new Lista<Adaptador<T>>();
       Lista<T> list = new Lista<T>();
        for (T elem :colec) {
            System.out.println(elem);
            lAdaptador.add(new Adaptador<>(elem));//usamos un adaptador para posteriomente agregar este elemento a un MinHeap
        }
       //Creamos el MinHeap a partir de la lista de adaptadores
          MonticuloMinimo<Adaptador<T>> monti = new MonticuloMinimo<Adaptador<T>>();
          for (Adaptador t : lAdaptador) {
              monti.add(t);
          }
          //Mientras el MinHeap no este vacio, sacamos al primer elemento y lo vamod agregando a nuestra lista
          while(!monti.isEmpty()){
       list.add(monti.get(0).elemento);//copiamos solo el elemento que tiene el adapatador que sacamos del MinHeap
       monti.delete(monti.get(0));
          }
      
        return list;//Devolvemos la lista de elementos que ahora esta ordenada
    }
    while (!monti.isEmpty()) {
      l.add(monti.get(0));
      list.add(monti.get(0).elemento);
      monti.delete(monti.get(0));
    }
    //System.out.println("MONTI");
    //  System.out.println(monti);

    //Lista<T> l = new Lista<T>();
    // voi
    System.out.println(l.toString());
    System.out.println(list.toString());
    return list;
  }
}
