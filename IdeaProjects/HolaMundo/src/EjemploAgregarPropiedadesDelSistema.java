import java.io.FileInputStream;
import java.util.Properties;

public class EjemploAgregarPropiedadesDelSistema {
    public static void main(String[] args) {
        try {
            FileInputStream archivo = new FileInputStream("IdeaProjects/HolaMundo/src/config.properties1");

            Properties p = new Properties(System.getProperties());
            p.load(archivo);
            p.setProperty("mi.propiedad.personalizada","mi valor guardado en el objeto properties");
            System.setProperties(p);
            Properties ps = System.getProperties();
            System.out.println("ps.getProperty(\"mi.propiedad.personalizada\") = " + ps.getProperty("mi.propiedad.personalizada"));
            System.out.println(System.getProperty("config.puerto.servidor"));
            System.out.println(System.getProperty("config.autor.nombre"));
            System.out.println(System.getProperty("config.autor.email"));
            p.list(System.out);
        } catch (Exception e){
            System.err.println("No existe el archivo: " + e);
            System.exit(1);
        }
    }
}
