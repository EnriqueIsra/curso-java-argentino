package org.eitorresmendoza.datetime.ejemplos;

import java.time.LocalDate;
import java.time.Period;

public class EjemploPeriod {
    public static void main(String[] args) {
        LocalDate fecha1 = LocalDate.of(2011, 9, 23);
        LocalDate fecha2 = LocalDate.of(2024, 4, 9);
        LocalDate fecha3 = fecha2.withDayOfMonth(12);
        fecha3 = fecha3.withDayOfMonth(28);

        Period periodo = Period.between( fecha1, fecha3);
        System.out.println("periodo = " + periodo);

        System.out.printf("Periodo entre %s y %s hay %d años, %d meses y %d dias",
                fecha1, fecha3, periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }
}
