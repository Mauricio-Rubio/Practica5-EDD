package edd.src.Estructuras;

import java.util.Arrays;
import java.util.Comparator;

public class pruebamonti{

    public static void main(String[] args) {
        Pokemon poke1 = new Pokemon("a", "Planta", 1, 110);
        Pokemon poke2 = new Pokemon("b", "Fuego", 2, 100);
        Pokemon poke3 = new Pokemon("c", "Electrico", 3, 100);
        Pokemon poke4 = new Pokemon("d", "Agua", 4, 100);
        Pokemon poke5 = new Pokemon("e", "Volador", 5, 100);
        
        Entero e1= new Entero(70);
          Entero e2= new Entero(60);
            Entero e3= new Entero(50);
              Entero e4= new Entero(11);
                Entero e5= new Entero(28);
                Entero e6= new Entero(13);
                Entero e7= new Entero(41);
        Entero[] arr = new Entero[7];
        arr[0]=e1;
        arr[1]=e2;
        arr[2]=e3;
        arr[3]=e4;
        arr[4]=e5;
        arr[5]=e6;
        arr[6]=e7;
        MonticuloMinimo<Entero> monticulo = new MonticuloMinimo<Entero>();
        // Agregamos elementos
       
        monticulo.add(e1);
        monticulo.add(e2);
        monticulo.add(e3);
        monticulo.add(e4);
        monticulo.add(e5);
        monticulo.add(e6);
        monticulo.add(e7);
       /* int k;
        for( k=0; k<arr.length; k++){
          System.out.print(arr[k]+",");
        }*/
     
      // monticulo.intercambiar(arr,0,4);
       // System.out.println("ORDENADO");
        //System.out.println(monticulo.MontMax_MontMin(arr));
       /* for( k=0; k<arr.length; k++){
          System.out.print(arr[k]+",");
        }*/
        // Mostramos el monticulo
       // System.out.println();
        System.out.println(monticulo);
        System.out.println(monticulo.esMontMin(arr));
        System.out.println(monticulo.size());
        System.out.println("########");
        //Eliminamos el elemento con el mínimo valor
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



    }


}
