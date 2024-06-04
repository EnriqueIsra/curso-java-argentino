package org.eitorresmendoza.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class EjemploZoneDateTime {
    public static void main(String[] args) {
        LocalDateTime fechaLocal = LocalDateTime.parse("2024/05/10 05:00",
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        ZoneId newYork = ZoneId.of("America/New_York");

        //ZonedDateTime zonaNewYork = ZonedDateTime.of(fechaLocal, ZoneOffset.of("-04:00"));
        ZonedDateTime zonaNewYork = fechaLocal.atZone(newYork); // o = fechaLocal.atZone(ZoneOffset.of("-04:00"));
        System.out.println("Hora de partida en ZonaNewYork = " + zonaNewYork);

        //ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime zonaMadrid = zonaNewYork.withZoneSameInstant(ZoneOffset.of("+02:00")).plusHours(8);
        System.out.println("Hora de llegada en zonaMadrid = " + zonaMadrid);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm, dd MMM yyyy");
        System.out.println("Detalles del viaje a españa: ");
        System.out.println("Partida NY: " + f.format(zonaNewYork));
        System.out.println("Llegada a Madrid: " + f.format(zonaMadrid));

        ZoneId.getAvailableZoneIds().forEach(System.out::println);
    }
}
