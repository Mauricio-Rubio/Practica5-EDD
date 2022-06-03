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
    int b= (int) (Math.random()*100);
    arr[i]= (new Entero());
    arr2[i]=(new Entero(i));
    arr3[i]=(new Entero(10-i));
    lista1.add(new Entero());
    lista2.add(new Entero());
    lista3.add(new Entero(b));
    arbol.add(new Entero());
    
    
  }
  MonticuloMinimo<Entero> min = new MonticuloMinimo<Entero>(lista1, lista1.size());
  System.out.println("---PRUEBAS MinHeap---");
  System.out.println("Prueba de esMontMin \nEl arreglo que estamos revisando es:");
  for(k=0;k<arr.length;k++){
    System.out.print(arr[k]+",");
  }
  System.out.println("\nEl arreglo repesenta un Monticulo Minimo: "+ min.esMontMin(arr));
  System.out.println();
  System.out.println("Prueba del metodo MontMax_MontMin \nEl arreglo que convertimos es:");
  for(k=0;k<arr3.length;k++){
    System.out.print(arr3[k]+",");
  }
  System.out.println("\nEl monticulo resultante es:\n "+ min.MontMax_MontMin(arr3));
  System.out.println();
  System.out.println("Prueba del heapSort: ");
  System.out.println("La coleccion a ordenar es:\n"+ lista2+"\nEl resultado es:"+min.heapSort(lista2));

  System.out.println();
  System.out.println("---PRUEBAS MaxHeap---");
  System.out.println("La coleccion con la cual construimos el monticulo maximo es:"+ lista3);
  System.out.println("EL monticulo maximo resultante es:");
  MonticuloMaximo<Entero> max = new MonticuloMaximo<>(lista3);
  System.out.println(max);
  System.out.println();
  System.out.println("Prueba add");
  for(k=0;k<3;k++){
    int j=0;
    System.out.println("El monticulo maximo antes de hacer el add es:"+max);
     j= (int) (Math.random()*100);
    System.out.println();
    System.out.println("El elemento a agregar es:"+j);
    max.add(new Entero(j));
    System.out.println();
    System.out.println("El monticulo maximo despues de hacer el add es:"+max);
  }
  System.out.println();
  System.out.println("Prueba delete");
  for(k=0;k<3;k++){
    System.out.println("El monticulo maximo antes de hacer el delete es:"+max);
    System.out.println();
    max.delete();
    System.out.println("El monticulo maximo despues de hacer el delete es:"+max);
  }
System.out.println();
System.out.println("Prueba de esMontMax \nEl arreglo que estamos revisando es:");
  for(k=0;k<arr.length;k++){
    System.out.print(arr[k]+",");
  }
  System.out.println("\nEl arreglo repesenta un Monticulo Minimo: "+ max.esMontMax(arr));
  System.out.println();
  System.out.println("Prueba del metodo MontMin_MontMax\nEl arreglo que convertimos es:");
  for(k=0;k<arr2.length;k++){
    System.out.print(arr2[k]+",");
  }
  System.out.println("\nEl monticulo resultante es:\n "+ max.MontMin_MontMax(arr2));
  }

  
  
}
