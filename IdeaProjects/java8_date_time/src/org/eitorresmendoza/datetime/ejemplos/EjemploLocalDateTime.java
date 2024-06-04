package org.eitorresmendoza.datetime.ejemplos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class EjemploLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime fechaYHora = LocalDateTime.now();
        System.out.println("fechaYHora = " + fechaYHora);

        fechaYHora = LocalDateTime.of(2024, Month.APRIL, 9, 17, 18);
        System.out.println("fechaYHora = " + fechaYHora);

        fechaYHora = LocalDateTime.parse("2024-04-09T18:18");
        System.out.println("fechaYHora = " + fechaYHora);

        LocalDateTime fechaYHora2 = fechaYHora.plusDays(1).plusHours(3);
        System.out.println("fechaYHora2 = " + fechaYHora2);
        System.out.println("fechaYHora = " + fechaYHora);
        System.out.println("fechaYHora3 = " + fechaYHora.minusHours(5));

        Month mes = fechaYHora.getMonth();
        System.out.println("mes = " + mes);
        int dia = fechaYHora.getDayOfMonth();
        System.out.println("dia = " + dia);

        int anio = fechaYHora.getYear();
        System.out.println("anio = " + anio);

        String formato1 = fechaYHora.format(DateTimeFormatter.ISO_DATE);
        System.out.println("formato1 = " + formato1);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a");

        String formato2 = fechaYHora.format(df);
        System.out.println("formato2 = " + formato2);

        String formato3 = df.format(fechaYHora);
        System.out.println("formato3 = " + formato3);
    }
}
