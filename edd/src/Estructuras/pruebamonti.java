package edd.src.Estructuras;

import java.util.Arrays;
import java.util.Comparator;

public class pruebamonti {

    public static void main(String[] args) {
        Pokemon poke1 = new Pokemon("a", "Planta", 1, 110);
        Pokemon poke2 = new Pokemon("b", "Fuego", 2, 100);
        Pokemon poke3 = new Pokemon("c", "Electrico", 3, 100);
        Pokemon poke4 = new Pokemon("d", "Agua", 4, 100);
        Pokemon poke5 = new Pokemon("e", "Volador", 5, 100);
        int[] arreglo = new int[1];
        arreglo[0]=9;
        Entero e1= new Entero(1);
          Entero e2= new Entero(2);
            Entero e3= new Entero(3);
              Entero e4= new Entero(4);
                Entero e5= new Entero(5);
                Entero e6= new Entero(6);
                Entero e7= new Entero(7);
                Entero e8= new Entero(-10);
                Entero e9= new Entero(1);
                Entero e10= new Entero(-13);
                Entero e11= new Entero(0);
        Entero[] arr = new Entero[7];
        arr[0]=e1;
        arr[1]=e4;
        arr[2]=e2;
        arr[3]=e3;
       // arr[4]=e5;
       // arr[5]=e6;
       // arr[6]=e7;
        Lista<Entero> lista = new Lista<Entero>();
        lista.add(e11);
        lista.add(e2);
        lista.add(e5);
        lista.add(e1);
        lista.add(e3);
        lista.add(e10); 
        lista.add(e8);
        lista.add(e9);
        lista.add(e4);
        lista.add(e6);
        lista.add(e7);
        ArbolRojinegro<Entero> arbol = new ArbolRojinegro<Entero>();
        arbol.add(e1);
        arbol.add(e2);
        arbol.add(e3);
       // System.out.println(arbol);
        MonticuloMinimo<Entero> monti = new MonticuloMinimo<Entero>(arbol,3);
       // System.out.println(monti);
        MonticuloMinimo<Entero> monticulo = new MonticuloMinimo<Entero>();
       System.out.println(monti.esMontMin(arr));
      //  System.out.println("HeapSort");
   //  monticulo.heapSort(lista);
      // monticulo.intercambiar(arr,0,4);
       // System.out.println("ORDENADO");
       // System.out.println(monticulo.MontMax_MontMin(arr));
       /* for( k=0; k<arr.length; k++){
          System.out.print(arr[k]+",");
        }*/
        // Mostramos el monticulo
       // System.out.println();
      //  System.out.println(monticulo);
        //System.out.println(monticulo.esMontMin(arr));
        //System.out.println(monticulo.size());
        //System.out.println("########");
       /* //Eliminamos el elemento con el mínimo valor
        monticulo.delete();
        // Mostramos el monticulo
        System.out.println(monticulo);
        System.out.println(monticulo.size());
        System.out.println("########");
        // Eliminamos el elemento con el mínimo valor
        monticulo.delete();
        // Mostramos el monticulo
        System.out.println(monticulo);
        System.out.println(monticulo.size());
        System.out.println("########");
        System.out.println(monticulo.contains(e5));
        
       // monticulo.empty();
        System.out.println("########");

        monticulo.delete();
        // Mostramos el monticulo
        System.out.println(monticulo);
        System.out.println(monticulo.size());
        System.out.println("########");
        monticulo.delete();
        // Mostramos el monticulo
        System.out.println(monticulo);
        System.out.println(monticulo.size());
        System.out.println("########");
        monticulo.delete();
        // Mostramos el monticulo
        System.out.println(monticulo);
        System.out.println(monticulo.size());
        System.out.println("########");

*/

    }
    lista1.agregaInicio(new Entero(1));
    lista1.agregaFinal(new Entero(70));
    System.out.println(lista1);
    MonticuloMaximo monMax = new MonticuloMaximo(lista1);
    System.out.println(monMax);
    System.out.println("#############");
    monMax.add(new Entero(80));
    monMax.add(new Entero(15));
    monMax.add(new Entero(90));
    System.out.println(monMax);
    System.out.println("#############");
    monMax.delete();
    monMax.delete();
    System.out.println(monMax);

  }
}
