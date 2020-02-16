package cl.jose.persona.controllers;

import cl.jose.persona.models.Persona;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MainController {


    private final AtomicLong counter = new AtomicLong();
    private String[] nombre;
    private int diasVividos;
    private int diasAux ;
    private int diasRestantes;
    private int edad;




    @RequestMapping("/persona")
    public Persona persona(@RequestParam(value="nombreCompleto") String nombreCompleto, @RequestParam(value="fechaNacimiento") LocalDate nacimiento) {
        nombre = nombreCompleto.split(" ", 4);
        LocalDate ahora = LocalDate.now();
        int dia = nacimiento.getDayOfMonth();
        int mes = nacimiento.getMonthOfYear();
        int ano = nacimiento.getYear();
        int anoActual = ahora.getYear();
        String nace = dia+"/"+mes+"/"+ano;
        String proximoCumplStr = dia+"/"+mes+"/"+anoActual;
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime proximoCumple = formatter.parseDateTime(proximoCumplStr);
        LocalDate localDateObj = LocalDate.parse(proximoCumplStr, formatter);

        diasVividos = Days.daysBetween(ahora, nacimiento).getDays();
        edad = diasVividos/365;
        if (edad<0)
            edad=edad*-1;
        diasAux = Days.daysBetween(localDateObj, nacimiento).getDays();
        diasRestantes = diasAux - diasVividos;
        if(diasRestantes<0)
            diasRestantes=diasRestantes*-1;

        return new Persona(counter.incrementAndGet(), nombre[0], nombre[2], nace, edad, diasRestantes);
    }




}
