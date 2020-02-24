package cl.jose.persona.controllers;

import cl.jose.persona.models.Persona;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

@RestController
public class MainController<JsonObject> {

    private final AtomicLong counter = new AtomicLong();
    private String[] nombre;
    private int diasVividos;
    private int diasAux ;
    private int diasRestantes;
    private int edad;

    @RequestMapping("/persona")
    public Persona persona(@RequestParam(value="nombreCompleto") String nombreCompleto, @RequestParam(value="fechaNacimiento") LocalDate nacimiento) throws Exception {
        nombre = nombreCompleto.split(" ", 4);
        LocalDate ahora = LocalDate.now();
        int dia = nacimiento.getDayOfMonth();
        int mes = nacimiento.getMonthOfYear();
        int ano = nacimiento.getYear();
        int anoActual = ahora.getYear();
        String nace = dia+"/"+mes+"/"+ano;
        String proximoCumplStr = dia+"/"+mes+"/"+anoActual;
        String contenido = "FELIZ CUMPLEAÑOS";

        String url = "https://www.poemist.com/api/v1/randompoems";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        String personStringData = response.toString();

        JsonReader reader = Json.createReader(new StringReader(personStringData));
        javax.json.JsonArray personArray = reader.readArray();
        javax.json.JsonObject poemas = personArray.getJsonObject(Integer.parseInt(String.valueOf(1)));
        String poema = poemas.getString("content");
        in.close();

        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        LocalDate localDateObj = LocalDate.parse(proximoCumplStr, formatter);

        diasVividos = Days.daysBetween(ahora, nacimiento).getDays();
        edad = diasVividos/365;

        if (edad<0)
            edad=edad*-1;
        diasAux = Days.daysBetween(localDateObj, nacimiento).getDays();
        diasRestantes = diasAux - diasVividos;
        if(diasRestantes<0)
            diasRestantes=diasRestantes*-1;

        if(diasRestantes!=0){
            return new Persona(counter.incrementAndGet(), nombre[0], nombre[2], nace, edad, diasRestantes, "");
        }
        else {
            return new Persona(counter.incrementAndGet(), nombre[0], nombre[2], nace, edad, diasRestantes, poema);
        }

    }




}
