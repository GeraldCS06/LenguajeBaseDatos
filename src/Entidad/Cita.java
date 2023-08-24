package Entidad;

public class Cita {

    private int id_cita;
    private int fecha;
    private int hora;
    private int persona;
    private int mascota;

    public Cita() {
    }

    public Cita(int id_cita, int fecha, int hora, int persona, int mascota) {
        this.id_cita = id_cita;
        this.fecha = fecha;
        this.hora = hora;
        this.persona = persona;
        this.mascota = mascota;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    public int getMascota() {
        return mascota;
    }

    public void setMascota(int mascota) {
        this.mascota = mascota;
    }

}
