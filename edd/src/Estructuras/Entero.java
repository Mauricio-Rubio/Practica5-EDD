package edd.src.Estructuras;

public class Entero implements ComparableIndexable<Entero>{
    
    int num;
    int indice;
    

    public Entero(int num) {
	this.num=num;
    }
    
    public Entero(){
     this.num=0;
    }

    public String toString() {
        return "" + num ;
    }
    
    @Override
    public int compareTo(Entero otro) {
       if(this.num==otro.num){
       	return 0;
       }else if(this.num<otro.num){
       	return -1;
       }else {
       	return 1;
       }
    }
    
    @Override
    public int getIndice() {
        return this.indice;
    }

    @Override
    public void setIndice(int indice) {
        this.indice = indice;
    }


}
