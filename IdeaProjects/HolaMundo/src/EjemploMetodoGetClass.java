import java.lang.reflect.Method;

public class EjemploMetodoGetClass {
    public static void main(String[] args) {
        String texto = "Hola perritos locos";
        Class strClass = texto.getClass();
        System.out.println("strClass.getName() = " + strClass.getName());
        System.out.println("strClass.getSimpleName() = " + strClass.getSimpleName());
        System.out.println("strClass.getPackageName() = " + strClass.getPackageName());
        System.out.println("strClass = " + strClass);
        
        for (Method metodo: strClass.getMethods()){
            System.out.println("metodo.getName() = " + metodo.getName());
        }

        Integer num = 34;
        Class intClass = num.getClass();
        Class objClass = intClass.getSuperclass().getSuperclass();
        System.out.println("intClass.getSuperclass() = " + intClass.getSuperclass());
        System.out.println("objClass = " + objClass);

        for (Method metodo: objClass.getMethods()){
            System.out.println("metodo.getName() = " + metodo.getName());
        }
    }
}
