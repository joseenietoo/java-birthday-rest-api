package cl.jose.persona.models;

import org.json.JSONObject;

public class Persona {

    private final long id;
    private final String primerNombre;
    private final String primerApellido;
    private final String fechaNacimiento;
    private final int edad;
    private final int diasRestantes;
    private final String poema;

    public Persona(long id, String primerNombre, String primerApellido, String fechaNacimiento, int edad, int diasRestantes, String poema) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.diasRestantes = diasRestantes;
        this.poema = poema;
    }

    public long getId() {
        return id;
    }

    public String getPrimerNombre() {
        return primerNombre; }

    public String getprimerApellido() {
        return primerApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public int getDiasRestantes() {
        return diasRestantes;
    }

    public String getPoema() {
        return poema;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", primerNombre='" + primerNombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", edad=" + edad +
                ", diasRestantes=" + diasRestantes +
                ", poema=" + poema +
                '}';
    }
}
