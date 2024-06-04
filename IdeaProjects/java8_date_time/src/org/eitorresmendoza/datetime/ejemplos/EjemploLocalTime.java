package org.eitorresmendoza.datetime.ejemplos;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EjemploLocalTime {
    public static void main(String[] args) {
        LocalTime ahorita = LocalTime.now();
        System.out.println("ahorita = " + ahorita);
        System.out.println("Hora: " + ahorita.getHour());
        System.out.println("minuto: " + ahorita.getMinute());
        System.out.println("Segundo: " + ahorita.getSecond());
        System.out.println("Nanosegundo:" + ahorita.getNano());

        LocalTime seisYMedia = LocalTime.of(6, 30);
        System.out.println("seisYMedia = " + seisYMedia);
        seisYMedia = LocalTime.parse("18:30:45");
        System.out.println("seisYMedia = " + seisYMedia);

        LocalTime sieteYMedia = LocalTime.of(6, 30).plus(1, ChronoUnit.HOURS);
        System.out.println("sieteYMedia = " + sieteYMedia);

        boolean esAnterior = LocalTime.of(6, 30).isBefore(LocalTime.parse("07:30"));
        System.out.println("esAnterior = " + esAnterior);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss a"); // con H mayuscula es formato de 24 horas y con h minuscula es para manejar am y pm
        String ahoraFormateado = seisYMedia .format(dateTimeFormatter);
        System.out.println("ahoraFormateado = " + ahoraFormateado);

        ahoraFormateado = dateTimeFormatter.format(ahorita);
        System.out.println("ahoraFormateado = " + ahoraFormateado);

        LocalTime max = LocalTime.MAX;
        LocalTime min = LocalTime.MIN;
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }
}
