
package lab1p2_alejandrareyes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author aleja
 */
public class Lab1P2_AlejandraReyes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Scanner leerS = new Scanner(System.in);
        System.out.println("Registro de Usuarios \n 1.Registrar Usuario \n 2.Listar todo \n 3.Listar por dominio \n 4.Salir");
        int opcion = leer.nextInt();
        
        while (opcion>0 && opcion<4){
            switch (opcion){
                case 1: //registrar usuario
                    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yy");
                    System.out.print("Ingrese su nombre: ");
                    String nombre = leerS.nextLine();
                    System.out.print("Ingrese su apellido: ");
                    String apellido = leerS.nextLine();
                    System.out.println("Ingrese fecha de nacimiento en formato mm/dd/yyyy: ");
                    String f = leerS.nextLine();
                    Date fn = new Date (f);
                    Date actual = new Date();
                    
                    
                    
                    int anios;
                    if ((fn.getMonth()-1)<=(actual.getMonth()-1)){
                        anios = (actual.getYear() - fn.getYear()) ;
                    }
                    else {
                        anios = (actual.getYear() - fn.getYear())-1;
                    }
                    
                    int meses;
                       if ((fn.getMonth()-1) > (actual.getMonth()-1)){
                           meses = (fn.getMonth()-1) - (actual.getMonth()-1);
                       }
                       else {
                           meses = (actual.getMonth()-1) - (fn.getMonth()-1);
                       }
                    int dias = actual.getDate() - fn.getDate();
                    
                    if (anios <14){
                        System.out.println("Tiene que tener por lo menos 13 años de edad");
                        break;
                    }
                    
                    
                    System.out.println(anios + " " + meses + " " + dias);
                   
                    
                    System.out.println("Ingrese su correo electronico: ");
                    String correo = leerS.nextLine();
                    System.out.println(matches(correo));
                    
                    while (matches(correo) == false){
                         System.out.println("Ingrese otro correo");
                         System.out.println("Ingrese correo nuevamente: ");
                         correo=leerS.nextLine();
                    }
                    if (matches(correo) == true){
                        if (correo.contains("gmail") || correo.contains("yahoo")){
                            
                        }
                    }
                    
                    String [] dominio = correo.split("@"); 
                    System.out.println("Ingrese su contraseña: ");
                    String contra = leerS.nextLine();
                    while (matches2(contra) == false){
                        System.out.println("Ingrese otro correo");
                         System.out.println("Ingrese correo nuevamente: ");
                         contra=leerS.nextLine();
                    }
                     
                    
                    
                    System.out.println(fn);
                    
                    break;
                    
                case 2:
                    break;
                    
                case 3:
                    break; 
            }
        }
    }
    
    public static boolean matches (String cad){
        String regex = "^[a-zA-Z0-9._%&$+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cad);
       return matcher.matches();
    }
    
    public static boolean matches2(String cad){
        String regex = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[!\\?<>$%]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cad);
        return matcher.matches();
    }
    
}
