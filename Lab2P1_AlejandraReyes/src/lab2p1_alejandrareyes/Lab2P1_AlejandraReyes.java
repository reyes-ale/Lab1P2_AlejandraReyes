
package lab2p1_alejandrareyes;
import java.util.Scanner;
/**
 *
 * @author aleja
 */
public class Lab2P1_AlejandraReyes {

  
    public static void main(String[] args) {
        int opcion;
        Scanner leer=new Scanner (System.in);
        System.out.println(" ********* M E N U *********");
        System.out.println(" 1. Dibujando triangulos ");
        System.out.println(" 2. Area de figuras ");
        System.out.println(" 3. Evaluando numeros ");
        System.out.println(" 4. Salir del programa ");
        System.out.print("Seleccione una opcion   ");
        opcion=leer.nextInt();
        
        while (opcion>0 && opcion<4){
            if (opcion==1){
                System.out.println(" Ingrese a: ");
                int numero1 = leer.nextInt();
                System.out.println(" Ingrese b: ");
                int numero2 = leer.nextInt();
                System.out.println(" Ingrese c: ");
                int numero3 = leer.nextInt();
                        if (numero1<0 || numero2<0 || numero3<0){
                            System.out.println(" Las longitudes no pueden ser negativas.");
                        }
                        else if ( (numero1+numero2 > numero3) && (numero2+numero3 > numero1) && (numero3+numero1 > numero2) ){
                                System.out.println(" Las longitudes ingresadas forman un triángulo.");
                            }
                            else{
                                 System.out.println(" Las longitudes ingresadas no forman un triangulo");
                                }
            }
            
            if (opcion==2){
                char resp='s';
                while (resp=='s' || resp=='S'){
                    int opcionarea;
                    System.out.println(" Ingrese la figura a la que desea calcularle el area: ");
                    System.out.println(" 1. Triangulo ");
                    System.out.println(" 2. Rectangulo ");
                    System.out.println(" 3. Circulo ");
                    System.out.print("Opcion: ");
                    opcionarea=leer.nextInt();

                    
                    if (opcionarea==1){
                       System.out.print( "Ingrese la base: ");
                       double basetri=leer.nextInt();
                       System.out.print( "Ingrese la altura: ");
                       double alturatri=leer.nextInt();
                       if (basetri>0 && alturatri>0){
                           double areatri=(0.5)*basetri*alturatri;
                           System.out.println(" El area del triangulo es: " + areatri);
                       }
                        else{
                            System.out.println(" Los valores no pueden ser negativos");
                        }
                    }
                    
                    
                    if (opcionarea==2){
                        
                        System.out.print(" Ingrese la base: ");
                        double baserec=leer.nextInt();
                        System.out.print(" Ingrese la altura");
                        double alturarec=leer.nextInt();
                        if (baserec>0 && alturarec>0){
                            double arearec=baserec*alturarec;
                            System.out.println(" El area del rectangulo es: " + arearec);
                        }
                        else{
                            System.out.println(" Los valores no pueden ser negativos");
                        }
                    }
                    
                    
                    if (opcionarea==3){
                       System.out.print( "Ingrese el radio: ");
                       double radio=leer.nextInt();
                       if (radio>0){
                           double areacir=Math.PI*(radio*radio);
                           System.out.println(" El area del triangulo es: " + areacir);
                       }
                        else{
                            System.out.println(" Los valores no pueden ser negativos");
                        }
                    }
                    
                   System.out.print( "Desea calcular el area de otra figura? [s/n]");
                   resp=leer.next().charAt(0);
                }
            }
            
            if (opcion==3){
                System.out.println(" Ingrese el numero que desea evaluar: ");
                int num=leer.nextInt();
                if (num>0){
                    int cont=1;
                    int contfac=0;
                    boolean par=false;
                    boolean primo=false;
                    
                    while (cont<=num){
                       if (num%cont==0){
                          contfac=contfac+1;
                       }
                       cont=cont+1;
                    }

                       if(contfac<=2 && num%2==0){
                           par=true;
                           primo=true;
                           System.out.println(" El numero ingresado es par y primo");
                           
                       }
                       else{
                            if(contfac>2 && num%2==0){ 
                            par=true;
                                System.out.println(" El numero ingresado es par");
                           }
                        
                          else{
                              if (contfac>2 && num%2!=0){
                                 par=false;
                                  System.out.println(" El numero ingresado es impar");
                                }
                               else{
                                   if (contfac<=2 && num%2!=0){
                                    par=false;
                                    primo=true;
                                       System.out.println(" El numero ingresado es impar y primo");
                                    
                                   }
                                }
                            }
                       }
                }
            
                    
            }
        System.out.println(" ********* M E N U *********");
        System.out.println(" 1. Dibujando triangulos ");
        System.out.println(" 2. Area de figuras ");
        System.out.println(" 3. Evaluando numeros ");
        System.out.println(" 4. Salir del programa ");
        System.out.print("Seleccione una opcion   ");
       
         opcion=leer.nextInt(); 
        }
    }
}
    

