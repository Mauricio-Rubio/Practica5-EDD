package edd.src.Estructuras;

import java.util.Arrays;
import java.util.Comparator;

public class pruebamonti {

  public static void main(String[] args) {
    //int[] arreglo = new int[1];
    //arreglo[0] = 9;
    Lista lista1 = new Lista<>();
    for (int i = 1; i < 6; i++) {
        lista1.add(new Entero(i*10));
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
  }
}
