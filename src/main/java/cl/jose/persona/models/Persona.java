package cl.jose.persona.models;

public class Persona {

    private final long id;
    private final String primerNombre;
    private final String primerApellido;
    private final String fechaNacimiento;
    private final int edad;

    public Persona(long id, String primerNombre, String primerApellido, String fechaNacimiento, int edad, int diasRestantes) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.diasRestantes = diasRestantes;
    }

    private final int diasRestantes;

    public long getId() {
        return id;
    }

    public String getPrimerNombre() { return primerNombre; }

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

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", primerNombre='" + primerNombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", edad=" + edad +
                ", diasRestantes=" + diasRestantes +
                '}';
    }
}
