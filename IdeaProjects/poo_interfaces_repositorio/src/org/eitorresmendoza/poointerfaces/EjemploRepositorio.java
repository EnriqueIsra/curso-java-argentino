package org.eitorresmendoza.poointerfaces;

import org.eitorresmendoza.poointerfaces.modelo.Cliente;
import org.eitorresmendoza.poointerfaces.repositorio.*;
import org.eitorresmendoza.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.eitorresmendoza.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.eitorresmendoza.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.eitorresmendoza.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;
import org.eitorresmendoza.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        try {
            AllRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Santiago", "Hernández"));
            repo.crear(new Cliente("Alexander", "Torres"));
            repo.crear(new Cliente("Alejandra", "Hernández"));
            repo.crear(new Cliente("Enrique", "Torres"));
            Cliente enrique = new Cliente("Boulas", "Gonzo");
            repo.crear(enrique);
            repo.crear(enrique);

            List<Cliente> clientes = repo.listar();
            clientes.forEach(System.out::println);
            System.out.println("************************ Paginable ************************");
            List<Cliente> Clietntespaginable = repo.listar(0, 3);
            Clietntespaginable.forEach(System.out::println);

            System.out.println("************************ Ordenable por Nombre Ascendente ************************");
            List<Cliente> cientesOrdenNombreAsc = repo.listar("nombre", Direccion.ASC);
            for (int i = 0; i < cientesOrdenNombreAsc.size(); i++) {
                System.out.println(cientesOrdenNombreAsc.get(i));
            }
            System.out.println("************************ Ordenable por Apellido Ascendente ************************");
            List<Cliente> cientesOrdenApeAsc = repo.listar("apellido", Direccion.ASC);
            for (int i = 0; i < cientesOrdenApeAsc.size(); i++) {
                System.out.println(cientesOrdenApeAsc.get(i));
            }
            System.out.println("************************ Ordenable por Nombre Descendente ************************");
            List<Cliente> cientesOrdenNombreDesc = repo.listar("nombre", Direccion.DESC);
            for (Cliente cliente : cientesOrdenNombreDesc) {
                System.out.println(cliente);
            }
            System.out.println("************************ Ordenable por Apellido Descendente ************************");
            List<Cliente> cientesOrdenApeDesc = repo.listar("apellido", Direccion.DESC);
            for (Cliente cliente : cientesOrdenApeDesc) {
                System.out.println(cliente);
            }
            System.out.println("************************ Editar ************************");
            Cliente alexActualizar = new Cliente("Alexander", "Torres");
            alexActualizar.setId(2);
            repo.editar(alexActualizar);
            Cliente alexActualizado = repo.porId(2);
            System.out.println(alexActualizado);
            System.out.println("************** Lista después de editar *************");
            repo.listar("apellido", Direccion.ASC).forEach(System.out::println);

            System.out.println("************************ Eliminar ************************");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);

            System.out.println("************************ Total Registros ************************");
            System.out.println("Total de registros: " + repo.total());
        }
        catch (RegistroDuplicadoAccesoDatoException e){
            System.out.println("Registro duplicado: " + e.getMessage());
            e.printStackTrace();
        }
        catch (LecturaAccesoDatoException e){
            System.out.println("Lectura: " + e.getMessage());
            e.printStackTrace();
        }
        catch (EscrituraAccesoDatoException e){
            System.out.println("Escritura: " + e.getMessage());
            e.printStackTrace();
        }
        catch (AccesoDatoException e){
            System.out.println("Genérica: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
