
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
        ArrayList <Usuario> usuarios = new ArrayList<>();
        ArrayList <Usuario> gmail = new ArrayList<>(); 
        ArrayList <Usuario> yahoo = new ArrayList<>();
        ArrayList <Usuario> icloud = new ArrayList<>();
        ArrayList <Usuario> outlook = new ArrayList<>();
        ArrayList <Usuario> protonmail = new ArrayList<>();
        ArrayList <Usuario> fastmail = new ArrayList<>();
        
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
                    
                    
                    System.out.print("Ingrese su correo electronico [Gmail, Outlook, Yahoo, iCloud, ProtonMail, FastMail]");
                    String correo = leerS.nextLine();
                    while (matches(correo) == false){
                         System.out.println("Ingrese otro correo");
                         System.out.println("Ingrese correo nuevamente: ");
                         correo=leerS.nextLine();
                    }
                    if (matches(correo) == true){
                        if (correo.contains("gmail") || correo.contains("yahoo")){
                            
                        }
                    }
                    System.out.println("Ingrese su contraseña: ");
                    String contra = leerS.nextLine();
                    while (matches2(contra) == false){
                        System.out.println("Ingrese otra contraseña: ");
                         contra=leerS.nextLine();
                    }
                    
                    usuarios.add(new Usuario(nombre,apellido,correo,anios,dias,meses));
                   
                   
                    
                    
                    switch (dominio[1]){
                        case "gmail.com":
                            
                            break;
                         
                         case "yahoo.com":
                            break;
                         
                          case "icloud.com":
                            break;
                            
                          case "outlook.com":
                            break;
                            
                         case "protonmail.com":
                            break;
                            
                         case "fastmail.com":
                            break;
                    }
                    
                              
                    
                    
                    
                    
                     
                    break;
                    
                case 2:
                    for (int i=0; i<usuarios.size(); i++){
                        System.out.println("Nombre: " + usuarios.get(i).getNombre() + "\n "
                            + "Apellido: "+ usuarios.get(i).getApellido()+ "\n Correo: "+ usuarios.get(i).getCorreo() + "\n Años: " + usuarios.get(i).getAnio()+ 
                            "\n Dias: " + usuarios.get(i).getDia() + "\n Meses: " + usuarios.get(i).getMes());
                    }
                    break;
                    
                case 3:
                    for (int i=0; i<usuarios.size(); i++){
                        String [] dominio =  usuarios.get(i).getCorreo().split("@"); 
                        if (dominio[0] == "gmail.com"){
                            gmail.add(usuarios.get(i));
                        }
                        else if (dominio[0] == "yahoo.com"){
                            
                        }
                        else if (dominio[0] == "outlook.com"){
                            
                        }
                        else if (dominio[0] == "icloud.com"){
                            
                        }
                        else if (dominio[0] == "protonmail.com"){
                            
                        }
                        else if (dominio[0] == "fastmail.com"){
                            
                        }
                         
                       
                    }
                    break;
                    
            }
            System.out.println("\nRegistro de Usuarios \n 1.Registrar Usuario \n 2.Listar todo \n 3.Listar por dominio \n 4.Salir");
            opcion = leer.nextInt();
        }
    }
    
    public static boolean matches (String cad){
        String regex = "^[a-zA-Z0-9._%&$+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cad);
       return matcher.matches();
    }
    
    public static boolean matches2(String cad){
        String regex = "^[a-zA-Z0-9._%&$+-?<>!]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cad);
        return matcher.matches();
    }
    
}
