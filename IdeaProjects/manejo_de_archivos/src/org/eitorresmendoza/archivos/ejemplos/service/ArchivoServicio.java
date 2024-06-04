package org.eitorresmendoza.archivos.ejemplos.service;

import java.io.*;
import java.util.Scanner;

public class ArchivoServicio {
    public void crearArchivo(String nombre) {
        File archivo = new File(nombre);
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, true))) {

            buffer.append("Hola que tal amigos!\n")
                    .append("Todo bien? yo aca escribiendo un archivo...\n")
                    .append("Hasta luego Lucas!\n");

            System.out.println("El archivo se ha creado con éxito");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void crearArchivo2(String nombre) {
        File archivo = new File(nombre);
        try (PrintWriter buffer = new PrintWriter(new FileWriter(archivo, true))) {

            buffer.println("Hola que tal amigos!");
            buffer.println("Todo bien? yo aca escribiendo un archivo...");
            buffer.printf("Hasta luego %s", "Santi");

            System.out.println("El archivo se ha creado con éxito");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String leerArchivo(String nombre){
        StringBuilder stringBuilder = new StringBuilder();
        File archivo = new File(nombre);
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = bufferReader.readLine()) != null){
                stringBuilder.append(linea).append("\n");
            }
            // bufferReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
    public String leerArchivo2(String nombre){
        StringBuilder stringBuilder = new StringBuilder();
        File archivo = new File(nombre);
        try ( Scanner scanner = new Scanner(archivo)){
            scanner.useDelimiter("\n");
            while (scanner.hasNext()){
                stringBuilder.append(scanner.next()).append("\n");
            }
            // scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
