package cl.jose.persona.models;

public class Persona {

    private final long id;
    private final String nombre;
    private final String apellido;
    private final String fechaNacimiento;
    private final int edad;

    public Persona(long id, String nombre, String apellido, String fechaNacimiento, int edad, int diasRestantes) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.diasRestantes = diasRestantes;
    }

    private final int diasRestantes;

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
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
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", edad=" + edad +
                ", diasRestantes=" + diasRestantes +
                '}';
    }
}
