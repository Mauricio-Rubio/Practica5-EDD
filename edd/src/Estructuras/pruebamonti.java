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
        
        Entero e1= new Entero(1);
          Entero e2= new Entero(2);
            Entero e3= new Entero(3);
              Entero e4= new Entero(4);
                Entero e5= new Entero(5);
        Entero[] arr = new Entero[5];
        arr[0]=e1;
        arr[1]=e1;
        arr[2]=e3;
        arr[3]=e4;
        arr[4]=e5;
        MonticuloMinimo<Entero> monticulo = new MonticuloMinimo<Entero>();
        // Agregamos elementos
        monticulo.add(e1);
        monticulo.add(e2);
        monticulo.add(e3);
        monticulo.add(e4);
        monticulo.add(e5);
    
        // Mostramos el monticulo
        System.out.println(monticulo);
        System.out.println(monticulo.esMontMin(arr));
        System.out.println(monticulo.size());
        System.out.println("########");
        // Eliminamos el elemento con el mínimo valor
        /*monticulo.delete();
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
        System.out.println(monticulo.contains(poke5));
        
        monticulo.empty();
        System.out.println("########");

        System.out.println(monticulo);
        System.out.println(monticulo.size());
*/


    }


}
