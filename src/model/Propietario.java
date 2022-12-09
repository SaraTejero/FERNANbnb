package model;

import java.util.Date;

public class Propietario {
    // Atributos
    private String email;
    private String pass;
    private String nombre;
    private String apellidos;
    private int telefono;
    private Vivienda vivienda;
    private int totalViviendas = 0;
    private static int numeroPropietarios = 0;

    // Constructores
    public Propietario(String nuevoEmail, String nuevoPass, String nuevoNombre, String nuevoApellidos, int telefono, Vivienda nuevaVivienda) {
        this.email = nuevoEmail;
        this.pass = nuevoPass;
        this.nombre = nuevoNombre;
        this.apellidos = nuevoApellidos;
        this.telefono = telefono;
        this.vivienda = new Vivienda(nuevaVivienda.getLocalidad(), nuevaVivienda.getDireccion(), nuevaVivienda.getHuesped(), nuevaVivienda.getPrecioNoche(), nuevaVivienda.getTipoVivienda(), nuevaVivienda.getId());
        totalViviendas ++;
        numeroPropietarios ++;
    }

    public Propietario(String nuevoEmail, String nuevoPass, String nuevoNombre, String nuevoApellidos, int telefono) {
        this.email = nuevoEmail;
        this.pass = nuevoPass;
        this.nombre = nuevoNombre;
        this.apellidos = nuevoApellidos;
        this.telefono = telefono;
        numeroPropietarios ++;
    }

    // Getters and Setters
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
    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }
    public String mostrarVivienda() { return vivienda.toString(); }
    public void cambiarHuespedes(int nuevoHuespedes){ vivienda.setHuesped(nuevoHuespedes); }
    public void cambiarPrecioNoche(double nuevoPrecio){ vivienda.setPrecioNoche(nuevoPrecio); }
    public int getTotalViviendas(){ return totalViviendas; }
    public void setVivienda(Vivienda vivienda) { this.vivienda = vivienda; }
    public Vivienda getVivienda() { return vivienda; }
    public static int getNumeroPropietarios() { return numeroPropietarios; }

    public static void setNumeroPropietarios(int numeroPropietarios) { Propietario.numeroPropietarios = numeroPropietarios; }

    // Métodos
    public boolean login(String email, String pass) {
        if (this.email.equals(email) && this.pass.equals(pass)) return true;
        return false;
    }

    // Mostramos las reservas de dicho propietario
    public String verReservas() {
        String listaReservas = "";
        if (getVivienda() != null){
            if(getVivienda().getReserva1() != null) listaReservas += getVivienda().getReserva1().toString() + "\n";
            if(getVivienda().getReserva2() != null) listaReservas += getVivienda().getReserva2().toString() + "\n";
            if(getVivienda().getReserva3() != null) listaReservas += getVivienda().getReserva3().toString() + "\n";
            if(getVivienda().getReserva4() != null) listaReservas += getVivienda().getReserva4().toString() + "\n";
            if(listaReservas.equals("")) return "No se han realizado reservas.";
            else return listaReservas;
        }
        return "No hay viviendas en alquiler.";
    }

    // Cambiar método para simular que en las fechas introducidas no esté disponible la vivienda
    public void cambiarEstadoVivienda(Date fechaInicio, Date fechaFin){
        vivienda.setFechaInicio(fechaInicio);
        vivienda.setFechaFin(fechaFin);
    }

    public boolean comprobarEspacio(String email){
        if(email == "") return true;
        return false;
    }

    public boolean existenciaVivienda(){
        if (vivienda == null) return false;
        return true;
    }

    public void borrarVivienda(){
        if(totalViviendas == 0) System.out.println("No hay viviendas creadas para borrar");
        else {
            vivienda = null;
            totalViviendas--;
        }
    }

    public void crearVivienda (Vivienda vivienda){
        this.vivienda = new Vivienda(vivienda.getLocalidad(),vivienda.getDireccion(), vivienda.getHuesped(), vivienda.getPrecioNoche(), vivienda.getTipoVivienda());
        totalViviendas++;
    }

    @Override
    public String toString() {
        return "========== PROPIETARIO ==========" +
                "\nEmail = " + email +
                "\nPass = " + pass +
                "\nNombre = " + nombre +
                "\nApellidos = " + apellidos +
                "\nTeléfono = " + telefono +
                "\n\n" + vivienda;
    }
}