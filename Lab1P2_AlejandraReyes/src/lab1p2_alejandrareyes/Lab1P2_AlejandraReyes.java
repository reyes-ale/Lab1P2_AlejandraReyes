
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

        static ArrayList <Usuario> usuarios = new ArrayList<>();
        static ArrayList <Usuario> gmail = new ArrayList<>(); 
        static ArrayList <Usuario> yahoo = new ArrayList<>();
        static ArrayList <Usuario> icloud = new ArrayList<>();
        static ArrayList <Usuario> outlook = new ArrayList<>();
        static ArrayList <Usuario> protonmail = new ArrayList<>();
        static ArrayList <Usuario> fastmail = new ArrayList<>();
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
                    System.out.print("Ingrese fecha de nacimiento en formato mm/dd/yyyy: ");
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
                     if (fn.getDate() > actual.getDate()){
                           meses = fn.getDate() - actual.getDate();
                       }
                       else {
                           meses = actual.getDate() - fn.getDate();
                       }
                    
                    if (anios <14){
                        System.out.println("Tiene que tener por lo menos 13 años de edad");
                        break;
                    }
                    
                    
                    System.out.print("Ingrese su correo electronico [Gmail, Outlook, Yahoo, iCloud, ProtonMail, FastMail]: ");
                    String correo = leerS.nextLine();
                    while (matches(correo) == false || dom(correo)==false ){
                         System.out.println("Escribio su correo incorrectamente. Debe Ingrese correo denuevo: ");
                         correo=leerS.nextLine();
                    }
                    
                    while (correoexiste(correo)==true){
                         System.out.print("Este usuario ya existe. Ingrese otro correo nuevamente: ");
                         correo=leerS.nextLine();
                    }
                    
                    System.out.println("Ingrese su contraseña: ");
                    String contra = leerS.nextLine();
                    while (matches2(contra) == false){
                        System.out.println("Su contraseña debe tener mas de 8 caracteres y por lo menos una  mayúscula, una  minúscula, \n un número y un símbolo (“!“, “?”," +
"“<”, “>”, “$” y “%”). Ingrese otra contraseña: ");
                         contra=leerS.nextLine();
                    }
                    
                    usuarios.add(new Usuario(nombre,apellido,correo,contra,anios,dias,meses));
                    
                   
                     
                    break;
                    
                case 2:
                    for (int i=0; i<usuarios.size(); i++){
                        System.out.println();
                        System.out.println("Nombre: " + usuarios.get(i).getNombre() + "\n "
                            + "Apellido: "+ usuarios.get(i).getApellido()+ "\n Correo: "+ usuarios.get(i).getCorreo() + "\n Contraseña: "+ usuarios.get(i).getContra() + "\n Años: " + usuarios.get(i).getAnio()+ 
                            "\n Dias: " + usuarios.get(i).getDia() + "\n Meses: " + usuarios.get(i).getMes());
                    }
                    break;
                    
                case 3:
                    
                    for (int i=0; i<usuarios.size(); i++){
                        String [] dominio =  (usuarios.get(i).getCorreo()).split("@"); 
                        if (dominio.length == 2) {
                            switch (dominio[1]) {
                                case "gmail.com":
                                   gmail.add(usuarios.get(i));
                                   break;
                                case "yahoo.com":
                                   yahoo.add(usuarios.get(i));
                                   break;
                                case "outlook.com":
                                   outlook.add(usuarios.get(i));
                                   break;
                                case "icloud.com":
                                   icloud.add(usuarios.get(i));
                                   break;
                                case "protonmail.com":
                                   protonmail.add(usuarios.get(i));
                                   break;
                                case "fastmail.com":
                                   fastmail.add(usuarios.get(i));
                                   break;
                            }
                    }
                    }
                    
                    imprimeusuarios("Gmail",gmail);
                    imprimeusuarios("Yahoo",yahoo);  
                    imprimeusuarios("iCloud",icloud);
                    imprimeusuarios("Outlook",outlook);
                    imprimeusuarios("ProtonMail",protonmail);
                    imprimeusuarios("FastMail",fastmail);
                    
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
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!?$%<>]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cad);
        return matcher.matches();
    }
    
    public static boolean dom (String correo) {
        String[] domsi = {"gmail", "outlook", "yahoo", "icloud", "protonmail", "fastmail"};
        for (int i=0; i<domsi.length; i++){
            if (correo.contains("@" + domsi[i] + ".com")) {
                return true;
            }
        }
       
        return false;
    }
    
    public static boolean correoexiste (String correo){
        for (int i =0; i<usuarios.size(); i++){
            if (correo.equals(usuarios.get(i).getCorreo())){
                return true;
            }
        }
        return false;
    }
    
    public static void imprimeusuarios(String dom, ArrayList<Usuario> dominio) {
        System.out.println("\n" + dom);
        
        for (int i=0; i<dominio.size(); i++){
            Usuario usuario = dominio.get(i);
                        System.out.println("\n Nombre: " + dominio.get(i).getNombre() + "\n "
                            + "Apellido: "+ dominio.get(i).getApellido()+ "\n Correo: "+ dominio.get(i).getCorreo() + "\n Contraseña: "+ dominio.get(i).getContra() + "\n Años: " + dominio.get(i).getAnio()+ 
                            "\n Dias: " + dominio.get(i).getDia() + "\n Meses: " + dominio.get(i).getMes());
         }
        
    }
    
    

    
}
