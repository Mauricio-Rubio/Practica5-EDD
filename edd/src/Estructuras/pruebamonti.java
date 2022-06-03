package edd.src.Estructuras;

public class pruebamonti <T extends ComparableIndexable<T>>{

  public static void main(String[] args) {
    Entero[] arr = new Entero[10];
    Entero[] arr2 = new Entero[10];
    Entero[] arr3 = new Entero[10];
    Lista <Entero> lista1 = new Lista<Entero>();
    Lista <Entero> lista2 = new Lista<Entero>();
   ArbolRojinegro<Entero> arbol = new ArbolRojinegro<Entero>(lista1);
    Lista <Entero> lista3 = new Lista<Entero>();
  int k;
  for(int i=0; i<10;i++){
    arr[i]= (new Entero());
    arr2[i]=i;
    arr3[i]=(10-i);
    lista1.add(new Entero());
    lista2.add(new Entero());
    lista3.add(new Entero());
    arbol.add(new Entero());
    
    
  }
  MonticuloMinimo<Entero> min = new MonticuloMinimo<Entero>(lista1, lista1.size());
  System.out.println("Prueba de esMontMin\nEl arreglo que estamos revisando es:");
  for(k=0;k<arr.length;k++){
    System.out.println(arr[k]);
  }
  System.out.println("El arreglo repesenta un Monticulo Minimo: "+ min.esMontMin(arr));
  System.out.println("Prueba del metodo MontMax_MontMin\nEl arreglo que convertimos es:");
  for(k=0;k<arr3.length;k++){
    System.out.println(arr3[k]);
  }
  System.out.println("El monticulo resultante es:\n "+ min.MontMax_MontMin(arr3));
  System.out.println("Prueba del heapSort: ");
  System.out.println("La coleccion a ordenar es:\n"+ lista2+"El resultado es:"+min.heapSort(lista2));
  
  }
  
}
