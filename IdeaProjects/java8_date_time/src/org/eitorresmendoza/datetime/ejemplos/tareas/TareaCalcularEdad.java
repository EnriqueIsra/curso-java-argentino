package org.eitorresmendoza.datetime.ejemplos.tareas;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TareaCalcularEdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar una fecha de nacimiento con formato yyyy-MM-dd:");
        String fechaString = scanner.next();

        LocalDate fechaNacimiento = LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, fechaActual);
        System.out.printf("La edad es: %s años, %s meses y %s dias",
                periodo.getYears(), periodo.getMonths(), periodo.getDays());

        long anios = ChronoUnit.YEARS.between(fechaNacimiento, fechaActual);
        System.out.printf("\nTu edad es: %s años", anios);
    }
}
