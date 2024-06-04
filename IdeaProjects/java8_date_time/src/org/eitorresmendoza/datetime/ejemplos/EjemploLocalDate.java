package org.eitorresmendoza.datetime.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class EjemploLocalDate {
    public static void main(String[] args) {
        LocalDate fechaActual = LocalDate.now();
        System.out.println("fechaActual = " + fechaActual);
        System.out.println("Día: " + fechaActual.getDayOfMonth());
        Month mes = fechaActual.getMonth();
        System.out.println("Mes: " + mes);
        System.out.println("Número del mes: " + mes.getValue());
        System.out.println("Mes en español: " + mes.getDisplayName(TextStyle.FULL, new Locale("es", "MX")));

        DayOfWeek diaSemana = fechaActual.getDayOfWeek();
        System.out.println("Número del día de la semana: " + diaSemana.getValue());
        System.out.println("Nombre del día de la semana: " + diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "MX")));

        System.out.println("Año: " + fechaActual.getYear());
        System.out.println("Día del año:" + fechaActual.getDayOfYear());
        System.out.println("Era: " + fechaActual.getEra());

        fechaActual = LocalDate.of(2020, 1, 25);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.of(2020, Month.NOVEMBER, 11);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.parse("2020-02-01");
        System.out.println("fechaActual = " + fechaActual);

        LocalDate maniana = LocalDate.now().plusDays(1);
        System.out.println("maniana = " + maniana);

        LocalDate hoyMesAnterior = LocalDate.now().minusMonths(1);
        System.out.println("hoyMesAnterior = " + hoyMesAnterior);

        LocalDate hoyMesAnterior2 = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println("hoyMesAnterior2 = " + hoyMesAnterior2);

        DayOfWeek miercoles = LocalDate.parse("2024-11-13").getDayOfWeek();
        System.out.println("miercoles = " + miercoles);

        int once = LocalDate.of(2024, 4, 11).getDayOfMonth();
        System.out.println("once = " + once);

        boolean esBisiesto = LocalDate.now().isLeapYear();
        System.out.println("esBisiesto = " + esBisiesto);

        boolean esAntes = LocalDate.of(2024, 11, 11).isBefore(LocalDate.parse("2024-11-10"));
        System.out.println("esAntes = " + esAntes);

        boolean esDespues = LocalDate.parse("2024-11-11").isAfter(LocalDate.parse("2024-11-10"));
        System.out.println("esDespues = " + esDespues);

        esDespues = LocalDate.now().isAfter(LocalDate.now().minusDays(1));
        System.out.println("esDespues = " + esDespues);
    }
}
