package edd.src.Estructuras;
public class pruebamonti {

  public static void main(String[] args) {
    Lista<Entero> lista1 = new Lista<Entero>();
    Lista<Entero> lista2 = new Lista<Entero>();
    Entero[] arr = new Entero[7];
    for (int i = 7; i > 0; i--) {
      lista1.add(new Entero(i*10));
      lista2.add(new Entero(i*10));
     // arr[i]= new Entero(i*10);
    }

    for(int j=0; j<3; j++){
      arr[j]=new Entero(10-j);
    }
    lista1.agregaInicio(new Entero(1));
    lista1.agregaFinal(new Entero(70));
    System.out.println(lista1);
    MonticuloMaximo<Entero> monMax = new MonticuloMaximo<Entero>(lista1);    
    System.out.println("max "+monMax);
    System.out.println("#############");
    monMax.add(new Entero(80));
    monMax.add(new Entero(15));
    monMax.add(new Entero(90));
    System.out.println("max "+monMax);
    System.out.println("#############");
    monMax.delete();
    monMax.delete();
    System.out.println("max "+monMax);
    
    MonticuloMinimo<Entero> monMin = new MonticuloMinimo<Entero>(lista1);
    System.out.println("\nmin "+monMin);
    monMin.add(new Entero(80));
    monMin.add(new Entero(15));
    monMin.add(new Entero(90));
    System.out.println("min "+monMin);
    System.out.println("#############");
    monMin.delete();
    monMin.delete();
    System.out.println("min "+monMin);

    
    Entero [] arr = new Entero[6];
    int x = 0;
    for (int i = 5; i >= 0; i--) {
      arr[x] = new Entero((1+i)*10);
      x++;
    }
    for (Entero entero : arr) {
      System.out.println(entero);
    }
    System.out.println(monMax.esMontMax(arr));
  }
}
