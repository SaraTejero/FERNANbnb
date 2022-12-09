package model;

import java.util.Date;

public class Usuario {
    // Atributos
    private String email;
    private String pass;
    private String nombre;
    private String apellidos;
    private int telefono;
    private Reserva reserva1;
    private Reserva reserva2;
    private Reserva ultimaReserva;
    private int numReservas = 0;
    private static int numeroUsuarios = 0;
    private String datosUltimaReservaCreada = "";

    // Constructor
    public Usuario(String email, String pass, String nombre, String apellidos, int telefono) {
        this.email = email;
        this.pass = pass;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        numeroUsuarios++;
    }

    // Getter and Setter
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public Reserva getReserva1() {
        return reserva1;
    }
    public void setReserva1(Reserva reserva) {
        this.reserva1 = reserva;
    }
    public Reserva getReserva2() {
        return reserva2;
    }
    public void setReserva2(Reserva reserva) {
        this.reserva2 = reserva;
    }
    public static int getNumeroUsuarios() {
        return numeroUsuarios;
    }
    public static void setNumeroUsuarios(int numeroUsuarios) {
        Usuario.numeroUsuarios = numeroUsuarios;
    }
    public int getNumReservas() {
        return numReservas;
    }
    public void setNumReservas(int numReservas) {
        this.numReservas = numReservas;
    }

    // Métodos
    public void crearReserva( int idReserva, Usuario usuario, Vivienda vivienda, Date fechaInicio, Date fechaFin, int huesped){
        if(reserva1 == null) {
            reserva1 = new Reserva(idReserva,usuario, vivienda, fechaInicio, fechaFin, huesped);
            guardarDatosUltimaReservaCreada(reserva1.toString());
            cogerUltimaReserva(reserva1);
        }
        else {
            reserva2 = new Reserva(idReserva, usuario, vivienda, fechaInicio, fechaFin, huesped);
            guardarDatosUltimaReservaCreada(reserva2.toString());
            cogerUltimaReserva(reserva2);
        }
        numReservas++;
    }

    public void cogerUltimaReserva(Reserva reserva){
        ultimaReserva = reserva;
    }

    public Reserva devulveUltimaReserva(){
        return ultimaReserva;
    }

    public String verReserva() {
        String listaReservas = "";
        if(reserva1 != null)  listaReservas += reserva1.toString() + "\n";
        if(reserva2 != null)  listaReservas += reserva2.toString() + "\n";
        return listaReservas;
    }

    public boolean comprobarReserva(int opcion) {
        if(reserva1 != null){
            if(reserva1.getId() == opcion) return true;
        }
        if(reserva2 != null){
            if(reserva2.getId() == opcion) return true;
        }
        return false;
    }
    public void borrarReserva(int opcion) {
        if(reserva1 != null){
            if(reserva1.getId() == opcion) {
                reserva1 = null;
                numReservas--;
            }
        }
        if(reserva2 != null){
            if(reserva2.getId() == opcion) {
                reserva1 = null;
                numReservas--;
            }
        }
    }

    private void guardarDatosUltimaReservaCreada(String reservaCreada){
        datosUltimaReservaCreada = reservaCreada;
    }

    public String mostrarUltimaReservaCreada(){
        return datosUltimaReservaCreada;
    }

    @Override
    public String toString() {
        return "========== USUARIO ==========" +
                "\nEmail = " + email +
                "\nPass = " + pass +
                "\nNombre = " + nombre +
                "\nApellidos = " + apellidos +
                "\nTeléfono = " + telefono;
    }

}
