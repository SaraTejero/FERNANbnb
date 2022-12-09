import model.*;
import utils.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variables
        String opcionMenuPrincipal, op, emailTeclado, passTeclado, nombreTeclado, apellidosTeclado, localidadTeclado, direccionTeclado, fechaTeclado;
        boolean registrar = false, cerrarSesion;
        int contadorUser = 0, contadorPropietario = 0, totalHuespedes = 0, tipoTeclado, telefonoTeclado;
        double precioNoche;
        //Perfiles de usuarios
        Datos datos = new Datos();
        Scanner s = new Scanner(System.in);
        //Inicio del programa

        do {
            cerrarSesion = false; //Inicializamos en este punto para que en cada vuelta que se ejecute tenga el valor false

            //Comenzamos iniciando sesión o registrando un usuario o propietario

            Menus.menuInicio();

            System.out.print("-> Introduzca una opción: ");
            opcionMenuPrincipal = s.nextLine();

            switch (opcionMenuPrincipal) {
                case "1": // Iniciar sesión

                    System.out.print("Introduce el email: ");
                    emailTeclado = s.nextLine();
                    System.out.print("Introduce la contraseña: ");
                    passTeclado = s.nextLine();
                    if (!datos.usuarioExistente(emailTeclado, passTeclado)) {
                        System.out.println("\nUsuario o contraseña incorrecta.");
                        Mensajes.pausa("Pulse enter para continuar...");
                    }else datos.iniciarSesion(emailTeclado, passTeclado);
                    break;

                case "2": // Registrar nuevo perfil de usuario
                    // Comprobar que no hemos alcanzado el máximo de usuarios y propietarios creados
                    if (datos.maximoUsuariosPermitidos() && datos.maximoPropietariosPermitidos())
                        System.out.println("Se ha alcanzado el límite de registros.\n");
                    else {
                        registrar = false;
                        do {
                            Menus.menuRegistro();
                            System.out.print("-> Introduzca una opción: ");
                            op = s.nextLine();
                            switch (op) {
                                case "1": //Registrar usuario
                                    if (datos.maximoUsuariosPermitidos())
                                        System.out.println("Se ha alcanzado el límite de usuarios registrados.");
                                    else {
                                        //Comprobamos que el email no esté registrado
                                        do {
                                            boolean espacioDetectado = false;
                                            boolean emailTomado = false;

                                            System.out.print("\nIntroduce el email: ");
                                            emailTeclado = s.nextLine();
                                            if (!datos.validarEmail(emailTeclado)) emailTomado = true;
                                            if (datos.comprobarEspacio(emailTeclado)) espacioDetectado = true;
                                            if (espacioDetectado && emailTomado) System.out.println("Error al introducir el email.\n");
                                            if (!espacioDetectado && emailTomado) System.out.println("Ese email ya está registrado.");
                                        } while (!datos.validarEmail(emailTeclado) || datos.comprobarEspacio(emailTeclado));
                                        System.out.print("Introduce la contraseña: ");
                                        passTeclado = s.nextLine();
                                        System.out.print("Introduce tu nombre: ");
                                        nombreTeclado = s.nextLine();
                                        System.out.print("Introduce tus apellidos: ");
                                        apellidosTeclado = s.nextLine();
                                        System.out.print("Introduce el teléfono móvil: ");
                                        telefonoTeclado = Integer.parseInt(s.nextLine());

                                        datos.registrarUsuario(new Usuario(emailTeclado, passTeclado, nombreTeclado, apellidosTeclado, telefonoTeclado));
                                        registrar = true;
                                    }
                                    break;

                                case "2": // Registrar nuevo perfil de propietario
                                    if (datos.maximoPropietariosPermitidos())
                                        System.out.println("Se ha alcanzado el límite de propietarios registrados.");
                                    else {
                                        //Comprobamos que el email no esté registrado
                                        do {
                                            boolean espacioDetectado = false;
                                            boolean emailTomado = false;

                                            System.out.print("\nIntroduce el email: ");
                                            emailTeclado = s.nextLine();
                                            if (!datos.validarEmail(emailTeclado)) emailTomado = true;
                                            if (datos.comprobarEspacio(emailTeclado)) espacioDetectado = true;
                                            if (espacioDetectado && emailTomado) System.out.println("Error al introducir el email.\n");
                                            if (!espacioDetectado && emailTomado) System.out.println("Ese email ya está registrado.");
                                        } while (!datos.validarEmail(emailTeclado) || datos.comprobarEspacio(emailTeclado));
                                        System.out.print("Introduce la contraseña: ");
                                        passTeclado = s.nextLine();
                                        System.out.print("Introduce tu nombre: ");
                                        nombreTeclado = s.nextLine();
                                        System.out.print("Introduce tus apellidos: ");
                                        apellidosTeclado = s.nextLine();
                                        System.out.print("Introduce el teléfono móvil: ");
                                        telefonoTeclado = Integer.parseInt(s.nextLine());

                                        do {
                                            System.out.print("¿Desea añadir alguna propiedad? (S/N): ");
                                            op = s.nextLine().toUpperCase();
                                            if (!op.equals("S") && !op.equals("N")) System.out.println("Error al elegir la opción.");
                                        } while (!op.equals("S") && !op.equals("N"));

                                        if (op.equals("S")) {
                                            // Pedir datos constructor vivienda
                                            // Crearla y después añadirla al contructor de Propietario

                                            System.out.print("Introduce la localidad donde se encuentra: ");
                                            localidadTeclado = s.nextLine();

                                            System.out.print("Introduce la dirección donde se encuentra: ");
                                            direccionTeclado = s.nextLine();

                                            System.out.print("Introduce el número máximo de huéspedes: ");
                                            totalHuespedes = Integer.parseInt(s.nextLine());

                                            System.out.print("Introduce el precio por noche: ");
                                            precioNoche = Double.parseDouble(s.nextLine());

                                            do {
                                                Menus.menuTiposViviendas();
                                                System.out.print("-> Seleccione una opcion: ");
                                                tipoTeclado = Integer.parseInt(s.nextLine());
                                                if (tipoTeclado < 1 || tipoTeclado > 4) System.out.println("Tipo de vivienda incorrecto.");
                                            } while (tipoTeclado < 1 || tipoTeclado > 4);

                                            datos.registrarPropietarioConVivienda(new Propietario(emailTeclado, passTeclado, nombreTeclado, apellidosTeclado, telefonoTeclado), new Vivienda(localidadTeclado, direccionTeclado, totalHuespedes, precioNoche, tipoTeclado));
                                            registrar = true;
                                        } else {
                                            datos.registrarPropietarioSinVivienda(new Propietario(emailTeclado, passTeclado, nombreTeclado, apellidosTeclado, telefonoTeclado));
                                            registrar = true;
                                        }
                                    }
                                    break;
                                case "3": // Salir
                                    registrar = true;
                                    break;
                                default:
                                    registrar = false;
                                    System.out.println("Error al introducir la opción.");
                                    Mensajes.pausa("Pulse enter para continuar...");
                            }
                        } while (!registrar);

                        //Una vez finalizado el registro volvemos al menú de inicio
                        if (registrar && op.equals("3")) {
                            Mensajes.delay("Volviendo al menú principal");
                        }
                    }
                    break;
                case "3": // Apagar programa
                    Mensajes.delay("Apagando programa");
                    break;
                default:
                    System.out.println("Error al introducir la opción.");
                    Mensajes.delay("Volviendo al menú principal");
            }
        } while(!opcionMenuPrincipal.equals("3"));
    }
}