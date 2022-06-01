package edd.src.Estructuras;

import java.util.Arrays;
import java.util.Comparator;

public class pruebamonti {

  public static void main(String[] args) {
    //int[] arreglo = new int[1];
    //arreglo[0] = 9;
    Lista lista1 = new Lista<>();
    for (int i = 1; i < 10; i++) {
        lista1.add(new Entero(i*10));
    }
    lista1.agregaInicio(new Entero(1));
    lista1.agregaFinal(new Entero(200));
    System.out.println(lista1);
    MonticuloMinimo monMin = new MonticuloMinimo<>(lista1);
    System.out.println(monMin);
    System.out.println("#############");
    MonticuloMaximo monMax = new MonticuloMaximo(lista1);
    System.out.println(monMax);
  }
}
