package edd.src.Estructuras;
public class pruebamonti {

  public static void main(String[] args) {
    Lista<Entero> lista1 = new Lista<Entero>();
    for (int i = 7; i > 0; i--) {
      lista1.add(new Entero(i*10));
     // arr[i]= new Entero(i*10);
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
    
    Entero [] arr = new Entero[6];
    Entero [] arr2 = new Entero[6];
    int x = 0;
    for (int i = 5; i >= 0; i--) {
      arr[x] = new Entero((1+i)*10);
      arr2[x] = lista1.pop();
      x++;
    }
    for (Entero entero : arr) {
      System.out.println(entero);
    }
    System.out.println("####");
    for (Entero entero : arr2) {
      System.out.println(entero);
    }
    System.out.println("1 "+monMax.esMontMax(arr));
    System.out.println("2 "+monMax.esMontMax(arr2));
  }
}
