package utils;

import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menus {
    private static Scanner s = new Scanner(System.in);
    private static int opcion;
    private static int totalHuespedes;
    private static double precioNoche;
    private static Vivienda plantillaVivienda;
    private static boolean cerrarSesion;
    private static Datos datos = new Datos();
    public static Date fechaIniTeclado;


    // Menú inicio
    public static void menuInicio() {
        System.out.println();
        System.out.println("""
                    ================== FERNANbnb =================
                    |                                            |
                    |                    ___                     |
                    |                   /   \\                    |
                    |                  /  _  \\                   |
                    |                 /  \\ /  \\                  |
                    |                /    /    \\                 |
                    |                \\___/ \\___/                 |
                    |                                            |
                    ================== FERNANbnb =================
                    
                    =============== MENÚ PRINCIPAL ===============
                    |                                            |
                    |  1. Iniciar sesión.                        |
                    |  2. Registrar nuevo usuario o propietario. |
                    |  3. Salir.                                 |
                    |                                            |
                    ==============================================
                    """);
    }


    // Menú registro
    public static void menuRegistro() {
        System.out.println();
        System.out.println("""
                        ================== REGISTRO ==================
                        |                                            |
                        |         ¿Cómo desea registrarse?           |
                        |                                            |
                        |    1. Usuario.                             |
                        |    2. Propietario.                         |
                        |    3. Salir.                               |
                        |                                            |
                        ==============================================
                        """);
    }


    // Menú administrador
    public static Administrador menuAdminstrador(Administrador administrador) {
        cerrarSesion = false;
        while (!cerrarSesion){
            System.out.println();
            System.out.println(
                    "==================== PERFIL DE ADMINISTRADOR ====================\n" +
                    "\n" +
                    " Bienvenio/a " + administrador.getNombre() + ", perfil de administración\n" +
                    "\n" +
                    "========================= MENÚ PRINCIPAL ========================\n" +
                    "\n" +
                    "  1.- Ver todas las viviendas en alquiler.\n" +
                    "  2.- Ver todos los usuarios del sistema.\n" +
                    "  3.- Ver todas las reservas de viviendas.\n" +
                    "  4.- Ver mi perfil.\n" +
                    "  5.- Modificar mi perfil.\n" +
                    "  6.- Cerrar sesión.\n" +
                    "\n" +
                    "=================================================================\n");

            System.out.print("-> Seleccione una opcion: ");
            opcion = Integer.parseInt(s.nextLine());
            switch (opcion) {
                case 1: // Ver todas las viviendas en alquiler
                    System.out.println(datos.mostrarViviendas());
                    break;
                case 2: // Ver todos los usuarios del sistema
                    Mensajes.delay("Mostrando todos los usuarios");
                    if (datos.getTotalUsuarios() == 0 && datos.getTotalPropietarios() == 0) System.out.println("No hay usuarios creados");
                    if(datos.getTotalPropietarios() != 0 && datos.getTotalUsuarios() == 0){
                        System.out.println("--------- PROPIETARIOS ---------");
                        System.out.println(datos.mostrarPropietarios());
                    }
                    if(datos.getTotalUsuarios() != 0 && datos.getTotalPropietarios() == 0){
                        System.out.println("--------- USUARIOS ---------");
                        System.out.println(datos.mostrarUsuarios());
                    }
                    if(datos.getTotalUsuarios() != 0 && datos.getTotalPropietarios() != 0){
                        System.out.println("--------- PROPIETARIOS ---------");
                        System.out.println(datos.mostrarPropietarios());
                        System.out.println("\n--------- USUARIOS ---------");
                        System.out.println(datos.mostrarUsuarios());
                    }
                    break;
                case 3: // Ver todas las reservas de viviendas
                    System.out.println(Datos.mostrarTodasReservas(administrador));
                    break;
                case 4: // Ver mi perfil
                    System.out.println(administrador.toString());
                    break;
                case 5: // Modificar mi perfil
                    do {
                        System.out.println("""
                            =========== MODIFICAR PERFIL ===========
                            |                                      |
                            |    ¿Qué apartado desea modificar?    |
                            |                                      |
                            |  1.- Nombre                          |
                            |  2.- Contraseña                      |
                            |  3.- Salir                           |
                            |                                      |
                            ========================================
                            """);
                        System.out.print("-> Seleccione una opcion: ");
                        opcion = Integer.parseInt(s.nextLine());
                        switch (opcion) {
                            case 1 -> { // Modificar nombre
                                System.out.print("Introduce el nuevo nombre: ");
                                administrador.setNombre(s.nextLine());
                                Mensajes.delay("Guardando cambios");
                            }
                            case 2 -> { // Modificar contraseña
                                System.out.print("Introduce la contraseña antigua: ");
                                if (s.nextLine().equals(administrador.getPass())) {
                                    System.out.print("Introduce la contraseña nueva: ");
                                    administrador.setPass(s.nextLine());
                                    Mensajes.delay("Guardando cambios");
                                } else System.out.println("Contraseña incorrecta");
                            }
                            case 3 -> { // Salir
                                Mensajes.delay("Volviendo al menú administrador");
                            }
                        }
                    } while (opcion != 3);
                    break;
                case 6: // Cerrar sesión
                    cerrarSesion = true;
                    break;
                default:
                    System.out.println("Error al elegir la opción.");
                    Mensajes.pausa("Pulse enter para continuar...");
            }
            Mensajes.pausa("Pulse enter para continuar...");
        }
        Mensajes.delay("Volviendo al menú principal");
        return administrador;
    }


    // Menú usuario
    public static Usuario menuUsuario(Usuario usuario) {
        cerrarSesion = false;
        Mensajes.delay("Cargando menú usuario");
        while (!cerrarSesion){
            System.out.println();
            System.out.println(
                    "============================== PERFIL DE USUARIO ==============================\n" +
                    "\n" +
                    " Bienvenio/a " + usuario.getNombre() +", busque un alojamiento para sus próximas vacaciones\n" +
                    "                               Tienes " + usuario.getNumReservas() + " reservas\n" +
                    "\n" +
                    "================================ MENÚ PRINCIPAL ===============================\n" +
                    "\n" +
                    "    1.- Búsqueda de alojamientos.\n" +
                    "    2.- Ver mis reservas.\n" +
                    "    3.- Borrar mis reservas.\n" +
                    "    4.- Ver mi perfil.\n" +
                    "    5.- Modificar mi perfil.\n" +
                    "    6.- Cerrar sesión.\n" +
                    "\n" +
                    "===============================================================================\n");
            System.out.print("-> Seleccione una opcion: ");
            opcion = Integer.parseInt(s.nextLine());

            switch (opcion) {
                case 1: // Búsqueda de alojamientos
                    System.out.print("Introduzca una ciudad para buscar: ");
                    String ciudadTeclado = s.nextLine();
                    Date fechaInicio = pedirFechaInicio();
                    Date fechaFin = pedirFechaFin();
                    System.out.print("Introduzca número de huéspedes: ");
                    int huespedesTeclado = Integer.parseInt(s.nextLine());
                    Mensajes.delay("Buscando alojamientos");
                    String resultadoAlojamoientos = Datos.buscarAlojamiento(ciudadTeclado, fechaInicio, fechaFin, huespedesTeclado);
                    System.out.println(resultadoAlojamoientos);
                    if(!resultadoAlojamoientos.equals("No hay viviendas en alquiler.") && !resultadoAlojamoientos.equals("No se han encontrado viviendas con esos requisistos")){
                        System.out.print("¿Deseas hacer una reserva (S/N)?: ");
                        if (!s.nextLine().toUpperCase().equals("S")) Mensajes.pausa("Pulse enter para continuar...");
                        else {
                            boolean reservar = false;
                            do{
                                System.out.print("¿Qué vivienda deseas reservar? (Seleccione el ID de la vivienda deseada): ");
                                opcion = Integer.parseInt(s.nextLine());
                                switch (opcion){
                                    case 1,2 ->{
                                        if(Datos.comprobarID(opcion) == -1) System.out.println("Opción incorrecta."); //Como el total de id son 1 o 2 si se introduce el id equivocado que se muestre como en defauldt
                                        else{
                                            if (usuario.getNumReservas() >= 2) System.out.println("Límite de reversas alcanzado.");
                                            else{
                                                Datos.crearReserva(usuario, Datos.comprobarID(opcion), fechaInicio, fechaFin, huespedesTeclado);
                                                Mensajes.delay("Generando reserva");
                                                System.out.println(usuario.mostrarUltimaReservaCreada());
                                            }
                                            reservar = true;
                                        }
                                    }
                                    default ->{
                                        System.out.println("Error al elegir la opción.");
                                        Mensajes.pausa("Pulse enter para continuar...");
                                    }
                                }
                            }while (!reservar);
                        }
                    }else Mensajes.pausa("Pulse enter para continuar...");

                    break;
                case 2: // Ver mis reservas
                    if(usuario.verReserva().equals("")) System.out.println("No hay reservas creadas.");
                    else {
                        Mensajes.delay("Recopilando reservas");
                        System.out.println(usuario.verReserva());
                    }
                    Mensajes.pausa("Pulse enter para continuar...");
                    break;
                case 3: // Borrar mis reservas
                    if(usuario.verReserva().equals("")) System.out.println("No hay reservas creadas.");
                    else {
                        System.out.println(usuario.verReserva());
                        Boolean salir = false;
                        while (!salir){
                            do {
                                System.out.print("Seleccione la reserva que desea borrar o pulse 0 (cero) para salir: ");
                                opcion = Integer.parseInt(s.nextLine());
                                if(opcion == 0) salir = true;
                                else {
                                    if(usuario.comprobarReserva(opcion)){
                                        System.out.print("¿Deseas borrarla?: ");
                                        String opcionBorrar = s.nextLine().toUpperCase();
                                        if(opcionBorrar.equals("S")){
                                            usuario.borrarReserva(opcion);
                                            Datos.borrarReserva(opcion);
                                            Mensajes.delay("Borrando reserva");
                                        }
                                        salir = true;
                                    } else System.out.println("Opción incorrecta");
                                }

                            }while (!salir);
                        }
                    }
                    Mensajes.pausa("Pulse enter para continuar...");
                    break;
                case 4: // Ver mi perfil
                    System.out.println(usuario.toString());
                    Mensajes.pausa("Pulse enter para continuar...");
                    break;
                case 5: // Modificar mi perfil
                    do {
                        menuModificarPerfil();
                        System.out.print("-> Seleccione una opcion: ");
                        opcion = Integer.parseInt(s.nextLine());
                        switch (opcion) {
                            case 1 -> { // Modificar nombre
                                System.out.print("Introduce el nuevo nombre: ");
                                usuario.setNombre(s.nextLine());
                                Mensajes.delay("Guardando cambios");
                            }
                            case 2 -> { // Modificar apellidos
                                System.out.print("Introduce el nuevo apellido: ");
                                usuario.setApellidos(s.nextLine());
                                Mensajes.delay("Guardando cambios");
                            }
                            case 3 -> { // Modificar contraseña pidiendo la antigua
                                System.out.print("Introduce la contraseña antigua: ");
                                if (s.nextLine().equals(usuario.getPass())) {
                                    System.out.print("Introduce la contraseña nueva: ");
                                    usuario.setPass(s.nextLine());
                                    Mensajes.delay("Guardando cambios");
                                } else System.out.println("Contraseña incorrecta.");
                            }
                            case 4 -> { // Modificar número de teléfono pidiendo la contraseña
                                System.out.print("Introduce la contraseña: ");
                                if (s.nextLine().equals(usuario.getPass())) {
                                    System.out.print("Introduce el nuevo teléfono: ");
                                    usuario.setTelefono(Integer.parseInt(s.nextLine()));
                                } else System.out.println("Contraseña incorrecta.");
                            }
                            case 5 -> { // Salir
                                Mensajes.delay("Volviendo al menú usuario");
                            }
                        }
                    } while (opcion != 5);
                    break;
                case 6: // Cerrar sesión
                    cerrarSesion = true;
                    break;
                default:
                    System.out.println("Error al elegir la opción.");
                    Mensajes.pausa("Pulse enter para continuar...");
            }
        }
        Mensajes.delay("Volviendo al menú principal");
        return usuario;
    }


    // Menú propietario
    public static Propietario menuPropietario(Propietario propietario) {
        cerrarSesion = false;
        Mensajes.delay("Cargando menú propietario");
        while (!cerrarSesion){
            System.out.println();
            System.out.println(
                    "============================ PERFIL DE PROPIETARIO ============================\n" +
                    "\n" +
                    "  Bienvenio/a " + propietario.getNombre() + ", gestione sus viviendas en alquiler.\n" +
                    "                       Tienes " + propietario.getTotalViviendas() + " viviendas en alquiler.\n" +
                    "\n" +
                    "=============================== MENÚ PRINCIPAL ================================\n" +
                    "\n" +
                    "   1.- Ver mis viviendas en alquiler.\n" +
                    "   2.- Editar mis viviendas.\n" +
                    "   3.- Ver las reservas de mis viviendas.\n" +
                    "   4.- Cambiar periodo de disponibilidad para una vivienda.\n" +
                    "   5.- Ver mi perfil.\n" +
                    "   6.- Modificar mi perfil.\n" +
                    "   7.- Cerrar sesión.\n" +
                    "\n" +
                    "===============================================================================\n");
            System.out.print("-> Seleccione una opcion: ");
            opcion = Integer.parseInt(s.nextLine());
            switch (opcion) {
                case 1: // Ver mis viviendas
                    Mensajes.delay("Recopilando propiedades");
                    if (propietario.existenciaVivienda())  System.out.println(propietario.mostrarVivienda());
                    else System.out.println("No se han registrado viviendas");
                    Mensajes.pausa("Pulse enter para continuar...");
                    break;
                case 2: // Editar mis viviendas
                    Boolean salirModificacion = false;
                    do {
                        System.out.println("""
                            ========= EDITAR MIS VIVIENDAS =========
                            |                                      |
                            |    ¿Qué apartado desea modificar?    |
                            |                                      |
                            |  1.- Número de huéspedes             |
                            |  2.- Precio por noche                |
                            |  3.- Borrar Vivienda                 |
                            |  4.- Añadir vivienda (Max 1)         |
                            |  5.- Salir                           |
                            |                                      |
                            ========================================
                            """);
                        System.out.print("-> Seleccione una opcion: ");
                        opcion = Integer.parseInt(s.nextLine());
                        switch (opcion) {
                            case 1: // Editar el número de huéspedes
                                System.out.print("Introduce el número de huéspedes: ");
                                totalHuespedes = Integer.parseInt(s.nextLine());
                                propietario.cambiarHuespedes(totalHuespedes);
                                Mensajes.delay("Guardando cambios");
                                break;
                            case 2: // Editar el precio por noche
                                System.out.print("Introduce el precio por noche: ");
                                precioNoche = Double.parseDouble(s.nextLine());
                                propietario.cambiarPrecioNoche(precioNoche);
                                Mensajes.delay("Guardando cambios");
                                break;
                            case 3: // Borrar vivienda
                                Mensajes.delay("Borrando vivienda");
                                propietario.borrarVivienda();
                                break;
                            case 4: // Añadir vivienda
                                if (propietario.getTotalViviendas() != 0) System.out.println("Se ha alcanzado el total de viviendas creadas.");
                                else {
                                    // Pedir datos constructor vivienda
                                    // Crearla y después añadirla al contructor de Propietario
                                    plantillaVivienda = new Vivienda();
                                    System.out.print("Introduce la localidad donde se encuentra: ");
                                    plantillaVivienda.setLocalidad(s.nextLine());

                                    System.out.print("Introduce la dirección donde se encuentra: ");
                                    plantillaVivienda.setDireccion(s.nextLine());

                                    System.out.print("Introduce el número máximo de huéspedes: ");
                                    plantillaVivienda.setHuesped(Integer.parseInt(s.nextLine()));

                                    System.out.print("Introduce el precio por noche: ");
                                    plantillaVivienda.setPrecioNoche(Double.parseDouble(s.nextLine()));
                                    do {
                                        menuTiposViviendas();
                                        System.out.print("-> Seleccione una opcion: ");
                                        opcion = Integer.parseInt(s.nextLine());
                                        switch (opcion) {
                                            case 1: // Chalet
                                                plantillaVivienda.setTipoVivienda(1);
                                                break;
                                            case 2: // Apartamento
                                                plantillaVivienda.setTipoVivienda(2);
                                                break;
                                            case 3: // Bajo
                                                plantillaVivienda.setTipoVivienda(3);
                                                break;
                                            case 4: // Estudio
                                                plantillaVivienda.setTipoVivienda(4);
                                                break;
                                            default:
                                                System.out.println("Tipo de vivienda incorrecto.");
                                                Mensajes.pausa("Pulse enter para continuar...");
                                        }
                                    }while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4);
                                    propietario.crearVivienda(plantillaVivienda);
                                    Mensajes.delay("Guardando cambios");
                                }
                                break;
                            case 5: //Salir
                                salirModificacion = true;
                                Mensajes.delay("Volviendo al menú propietario");
                                break;
                            default:
                                System.out.println("Error al elegir la opción.");
                                Mensajes.pausa("Pulse enter para continuar...");
                        }
                    } while (!salirModificacion);
                    break;
                case 3: // Ver las reservas de mis viviendas
                    System.out.println(propietario.verReservas());
                    Mensajes.pausa("Pulse enter para continuar...");
                    break;
                case 4: // Cambiar periodo de no disponibilidad para una vivienda
                    // Simular que en las fechas introducidas no esté disponible la vivienda
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    String op;
                    if(propietario.getVivienda().getFechaInicio() != null) {
                        do {
                            System.out.print("Actualmente tienes un periodo de no disponibilidad en su vivienda en las siguientes fechas: " +
                                    "\nInicio: " + formato.format(propietario.getVivienda().getFechaInicio()) +
                                    "\nFin: " + formato.format(propietario.getVivienda().getFechaFin()) +
                                    "\n¿Deseas borrarla o modificarla (B/M)?: ") ;
                            op = s.nextLine().toUpperCase();
                            switch (op){
                                case "B" -> {
                                    propietario.getVivienda().borrarFechaNoDisponibilidad();
                                    Mensajes.delay("Borrando fecha de no disponibilidad");
                                }
                                case "M" -> {
                                    crearPeriodoNoDisponible(propietario);
                                    Mensajes.delay("Guardando cambios");
                                }
                                default -> {
                                    System.out.println("Error al elegir la opción.");
                                    Mensajes.pausa("Pulse enter para continuar...");
                                }
                            }
                        } while (!op.equals("B") && !op.equals("M"));

                    }else {
                        crearPeriodoNoDisponible(propietario);
                        Mensajes.delay("Guardando cambios");
                    }
                    break;
                case 5: // Ver mi perfil
                    System.out.println(propietario.toString());
                    Mensajes.pausa("Pulse enter para continuar...");
                    break;
                case 6: // Modificar mi perfil
                    boolean salirMenuOpcion = false;
                    do {
                        menuModificarPerfil();
                        System.out.print("-> Seleccione una opcion: ");
                        opcion = Integer.parseInt(s.nextLine());
                        switch (opcion) {
                            case 1 -> { // Modificar nombre
                                System.out.print("Introduce el nuevo nombre: ");
                                propietario.setNombre(s.nextLine());
                                Mensajes.delay("Guardando cambios");
                            }
                            case 2 -> { // Modificar apellidos
                                System.out.print("Introduce el nuevo apellido: ");
                                propietario.setApellidos(s.nextLine());
                                Mensajes.delay("Guardando cambios");
                            }
                            case 3 -> { // Modificar contraseña pidiendo la antigua
                                System.out.print("Introduce la contraseña antigua: ");
                                if (s.nextLine().equals(propietario.getPass())) {
                                    System.out.print("Introduce la contraseña nueva: ");
                                    propietario.setPass(s.nextLine());
                                    Mensajes.delay("Guardando cambios");
                                } else System.out.println("Contraseña incorrecta");
                            }
                            case 4 -> { // Modificar número de teléfono pidiendo la contraseña
                                System.out.print("Introduce la contraseña: ");
                                if (s.nextLine().equals(propietario.getPass())) {
                                    System.out.print("Introduce el nuevo teléfono: ");
                                    propietario.setTelefono(Integer.parseInt(s.nextLine()));
                                } else System.out.println("Contraseña incorrecta");
                            }
                            case 5 -> { // Salir
                                salirMenuOpcion = true;
                                Mensajes.delay("Volviendo al menú propietario");
                            }
                        }
                    } while (!salirMenuOpcion);
                    break;
                case 7: // Cerrar sesión
                    cerrarSesion = true;
                    break;
                default:
                    System.out.println("Error al elegir la opción.");
                    Mensajes.pausa("Pulse enter para continuar...");
            }
        }
        Mensajes.delay("Volviendo al menu principal");
        return propietario;
    }

    // Método para validar fecha de inicio
    public static Date pedirFechaInicio(){
        Date fechaInicioTeclado = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Introduzca una fecha de inicio: ");
        try {
            fechaInicioTeclado = formato.parse(s.nextLine());
            fechaIniTeclado = fechaInicioTeclado;
        } catch (ParseException e) {
            System.out.println("Error al introducir la fecha.");
            pedirFechaInicio();
        }
        return fechaInicioTeclado;
    }

    // Método para validar fecha de fin
    public static Date pedirFechaFin(){
        Date fechaFinTeclado = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Introduzca una fecha de fin: ");
        try {
            fechaFinTeclado = formato.parse(s.nextLine());
            if (fechaFinTeclado.before(fechaIniTeclado)) {
                System.out.println("¡Error! Has introducido una fecha de fin anterior a la fecha de inicio.");
                pedirFechaFin();
            }
        } catch (ParseException e) {
            System.out.println("Error al introducir la fecha.");
            pedirFechaFin();
        }
        return fechaFinTeclado;
    }

    public static void crearPeriodoNoDisponible(Propietario propietario) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaI = pedirFechaInicio();
        Date fechaF = pedirFechaFin();
        propietario.cambiarEstadoVivienda(fechaI, fechaF);
        System.out.println("Tu vivienda no estará disponible en estas fechas: Fecha Inicio: " + formato.format(fechaI) + "    Fecha Fin: " + formato.format(fechaF));
    }

    public static void menuTiposViviendas() {

        System.out.println("""
                            ======== TIPO DE VIVIENDA ========
                            |                                |
                            |  1.- Chalet                    |
                            |  2.- Apartamento               |
                            |  3.- Bajo                      |
                            |  4.- Estudio                   |
                            |                                |
                            ==================================
                            """);
    }

    public static void menuModificarPerfil() {
        System.out.println("""
                            =========== MODIFICAR PERFIL ===========
                            |                                      |
                            |    ¿Qué apartado desea modificar?    |
                            |                                      |
                            |  1.- Nombre                          |
                            |  2.- Apellidos                       |
                            |  3.- Contraseña                      |
                            |  4.- Teléfono                        |
                            |  5.- Salir                           |
                            |                                      |
                            ========================================
                            """);
    }
}
