package model;

import java.util.Date;

public class Vivienda {
    // Atributos
    private int id;
    private int tipoVivienda;
    private String localidad;
    private String direccion;
    private int huesped;
    private double precioNoche;
    private Date fechaInicio;
    private Date fechaFin;
    private int numeroReservas = 0;
    private Reserva reserva1;
    private Reserva reserva2;
    private Reserva reserva3;
    private Reserva reserva4;

    // Constructores
    public Vivienda(String localidad, String direccion, int huesped, double precioNoche, int tipoVivienda) {
        this.id ++;
        this.localidad = localidad.toUpperCase();
        this.direccion = direccion;
        this.huesped = huesped;
        this.precioNoche = precioNoche;
        this.tipoVivienda = tipoVivienda;
    }
    public Vivienda(String localidad, String direccion, int huesped, double precioNoche, int tipoVivienda, int id) {
        this.id = id;
        this.localidad = localidad.toUpperCase();
        this.direccion = direccion;
        this.huesped = huesped;
        this.precioNoche = precioNoche;
        this.tipoVivienda = tipoVivienda;
    }

    public Vivienda() {

    }

    //Getter and Setter
    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id; }
    public int getTipoVivienda() {
        return tipoVivienda;
    }
    public void setTipoVivienda(int tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }
    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getHuesped() {
        return huesped;
    }
    public void setHuesped(int huesped) {
        this.huesped = huesped;
    }
    public double getPrecioNoche() {
        return precioNoche;
    }
    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public int getNumeroReservas() {
        return numeroReservas;
    }
    public void setNumeroReservas(int numeroReservas) {
        this.numeroReservas = numeroReservas;
    }
    public Reserva getReserva1() {
        return reserva1;
    }
    public void setReserva1(Reserva reserva1) {
        this.reserva1 = reserva1;
    }
    public Reserva getReserva2() {
        return reserva2;
    }
    public void setReserva2(Reserva reserva2) {
        this.reserva2 = reserva2;
    }
    public Reserva getReserva3() {
        return reserva3;
    }
    public void setReserva3(Reserva reserva3) {
        this.reserva3 = reserva3;
    }
    public Reserva getReserva4() {
        return reserva4;
    }
    public void setReserva4(Reserva reserva4) {
        this.reserva4 = reserva4;
    }

    // Métodos
    public static String tipoViviendaString(int tipoVivienda) {
        if (tipoVivienda == 1) return "Chalet";
        if (tipoVivienda == 2) return "Apartamento";
        if (tipoVivienda == 3) return "Bajo";
        else return "Estudio";
    }

    public boolean cumplirTodosRequisitos(String ciudad,Date fechaInicio, Date fechaFin, int huespedes){
        if (!cumplirRequisitoLocalidad(ciudad)) return false;
        if (!cumplirRequisitoFechaNoDisponible(fechaInicio,fechaFin)) return false;
        if (!cumplirRequisitoOtrasReservas(fechaInicio, fechaFin)) return false;
        if (!cumplirRequisitoHuespedes(huespedes)) return false;
        return true;
    }

    private boolean cumplirRequisitoOtrasReservas(Date fechaInicio, Date fechaFin) {
        if(reserva1 != null){
            if (!cumplirRequisitoFechaInicio(fechaInicio, fechaFin, reserva1.getFechaEntrada()) && !cumplirRequisitoFechaFin(fechaInicio,fechaFin, reserva1.getFechaSalida())) return false;
        }
        if(reserva2 != null){
            if (!cumplirRequisitoFechaInicio(fechaInicio, fechaFin, reserva2.getFechaEntrada()) && !cumplirRequisitoFechaFin(fechaInicio,fechaFin, reserva2.getFechaSalida())) return false;
        }
        if(reserva3 != null){
            if (!cumplirRequisitoFechaInicio(fechaInicio, fechaFin, reserva3.getFechaEntrada()) && !cumplirRequisitoFechaFin(fechaInicio,fechaFin, reserva3.getFechaSalida())) return false;
        }
        if(reserva4 != null){
            if (!cumplirRequisitoFechaInicio(fechaInicio, fechaFin, reserva4.getFechaEntrada()) && !cumplirRequisitoFechaFin(fechaInicio,fechaFin, reserva4.getFechaSalida())) return false;
        }
        return true;
    }

    private boolean cumplirRequisitoLocalidad(String ciudad){
        if (this.localidad.equalsIgnoreCase(ciudad)) return true;
        return false;
    }

    private  boolean cumplirRequisitoFechaNoDisponible(Date fechaInicio, Date fechaFin){
        if (this.fechaInicio == null) return true;
        else{
            if (cumplirRequisitoFechaInicio(fechaInicio, fechaFin, this.fechaInicio) || cumplirRequisitoFechaFin(fechaInicio,fechaFin, this.fechaFin)) return true;
            return false;
        }
    }

    private boolean cumplirRequisitoFechaFin(Date fechaInicio, Date fechaFin, Date fechaFinCriterio){
        if(fechaInicio.after(fechaFinCriterio) && fechaFin.after(fechaFinCriterio)) return true;
        return false;
    }

    private boolean cumplirRequisitoFechaInicio(Date fechaInicio, Date fechaFin, Date fechaInicioCriterio){
        if(fechaInicio.before(fechaInicioCriterio) && fechaFin.before(fechaInicioCriterio)) return true;
        return false;
    }

    private boolean cumplirRequisitoHuespedes(int huespedes){
        if (this.huesped >= huespedes) return true;
        return false;
    }

    public void borrarFechaNoDisponibilidad() {
        this.fechaInicio = null;
        this.fechaFin = null;
    }

    public void crearReserva(Reserva reserva) {
        if (reserva1 == null) {
            reserva1 = reserva;
        } else if (reserva2 == null) {
            reserva2 = reserva;
        } else if (reserva3 == null) {
            reserva3 = reserva;
        } else if (reserva4 == null) {
            reserva4 = reserva;
        }
    }

    public boolean coincideIdReserva(int id){
        if (reserva1 != null) {
            if (reserva1.getId() == id) return true;
        } else if (reserva2 != null) {
            if (reserva2.getId() == id) return true;
        } else if (reserva3 != null) {
            if (reserva3.getId() == id) return true;
        } else if (reserva4 != null) {
            if (reserva4.getId() == id) return true;
        }
        return false;
    }

    public void borrarReserva(int id){
        if (reserva1 != null) {
            if (reserva1.getId() == id) reserva1 = null;
        } else if (reserva2 != null) {
            if (reserva2.getId() == id) reserva2 = null;
        } else if (reserva3 != null) {
            if (reserva3.getId() == id) reserva3 = null;;
        } else {
            if (reserva4.getId() == id) reserva4 = null;
        }
    }


    //Métodos
    @Override
    public String toString() {
        return "====== VIVIENDA CON ID: " + id + " ======" +
                "\nVivienda: " + tipoViviendaString(tipoVivienda) + " en " + localidad +
                "\nDireccion: " + direccion +
                "\nNúmero de huésped máximo: " + huesped +
                "\nPrecio por noche: " + precioNoche + " euros";
    }


}