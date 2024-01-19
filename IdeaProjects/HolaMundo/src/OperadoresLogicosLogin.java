import java.util.Scanner;

public class OperadoresLogicosLogin {
    public static void main(String[] args) {

        /*String[] usernames = new String[3];
        String[] passwords = new String[3];
        usernames[0] = "enrique";
        passwords[0] = "12345";
        usernames[1] = "admin";
        passwords[1] = "12345";
        usernames[2] = "pepe";
        passwords[2] = "12345";*/
        String[] usernames = {"enrique", "admin", "pepe"};
        String[] passwords = {"12345", "12345", "12345"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre de usuario");
        String u = scanner.nextLine();
        System.out.println("Ingresa la contraseña");
        String p = scanner.nextLine();
        boolean usuarioAutenticado = false;
        for(int i = 0; i < usernames.length; i++){
            usuarioAutenticado = (usernames[i].equals(u) && passwords[i].equals(p)) ? true: usuarioAutenticado;
            /*if ((usernames[i].equals(u) && passwords[i].equals(p))) {
                usuarioAutenticado = true;
                break;
            }*/
        }

        String mensaje = usuarioAutenticado ? "Bienvenido " + u + "!" :
                "nombre de usuario o contraseña incorrecto\nse requiere autenticación del usuario";
        System.out.println("mensaje = " + mensaje);
        /*if (usuarioAutenticado){
            System.out.println("Bienvenido " + u + "!");
        } else {
            System.out.println("nombre de usuario o contraseña incorrecto");
            System.out.println("Se requiere autenticación del usuario");
            main(args);
        }*/
    }
}
