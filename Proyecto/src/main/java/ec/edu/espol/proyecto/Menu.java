package ec.edu.espol.proyecto;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {

    public static void iniciarMenu() throws IOException, NoSuchAlgorithmException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int seleccion;
        while (!salir) {
            System.out.println();
            System.out.print("==================================" + "\nMENU DE OPCIONES: \n1. Vendedor \n2. Comprador \n3. Salir \n==================================");
            System.out.print("\n\nIngrese una opcion 1-3: ");
            try {
                seleccion = sn.nextInt();
                if (seleccion == 1) {
                    System.out.println("\n-------------------------------------------------\nVENDEDOR");
                    System.out.print("------------------------------------------------- \n1. Registrar un nuevo vendedor \n2. Registrar un nuevo vehiculo \n3. Aceptar oferta \n4. Regresar \n\nIngrese una opcion 1-4: ");
                    boolean regresar = false;
                    while (!regresar) {
                        try {
                            seleccion = sn.nextInt();
                            if (seleccion == 1) {
                                System.out.println("\n---REGISTRAR UN NUEVO VENDEDOR---\n");
                                Vendedor.registrarVendedor();
                            } else if (seleccion == 2) {
                                System.out.println("\n---REGRISTRAR UN NUEVO VEHICULO---\n");
                                Utilitaria.obtenerCorreoClave("Vendedores.txt");
                                Vehiculo.registrarVehiculo();
                            } else if (seleccion == 3) {
                                
                                System.out.println("\n---ACEPTAR OFERTA---\n");
                                ArrayList<String> datos = Utilitaria.obtenerCorreoClave("Vendedores.txt");
                                System.out.print("Ingrese la placa:");
                                String plb = sn.next();
                                Utilitaria.mos(plb);
                                String c= datos.get(0);
                                String l= datos.get(1);
                                Oferta.aceptarOferta(plb,c,l);
                                
                            } else if (seleccion == 4) {
                                regresar = true;
                                break;
                            } else if (seleccion > 4 || seleccion < 1) {
                                System.out.println("[Opcion fuera de rango. Ingrese otra opcion]");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("\n[Debes insertar un nÃºmero]");
                            sn.next();
                        }
                        System.out.println("\n-------------------------------------------------\nVENDEDOR");
                        System.out.print("------------------------------------------------- \n1. Registrar un nuevo vendedor \n2. Registrar un nuevo vehi­culo \n3. Aceptar oferta\n4. Regresar \n\nIngrese una opcion 1-4: ");
                    }
                } else if (seleccion == 2) {
                    System.out.println("\n------------------------------------------------- \nCOMPRADOR");
                    System.out.print("------------------------------------------------- \n1. Registrar un nuevo comprador \n2. Ofertar por un vehiculo  \n\nIngrese una opcion 1-2: ");
                    int opcion = sn.nextInt();
                    if (opcion == 1) {
                        System.out.println("\n---REGISTRAR UN NUEVO COMPRADOR---\n");
                        Comprador.registrarComprador();
                    } else if (opcion == 2) {
                        System.out.println("\n---OFERTAR POR UN VEHICULO---\n");
                        ArrayList<String> datos = Utilitaria.obtenerCorreoClave("Compradores.txt");
                        if (Comprador.datosComprador().isEmpty() || Vehiculo.datosVehiculo().isEmpty())
                            System.out.println("\n[No hay vehiculos registrados hasta el momento]");
                        else {
                            ArrayList<Vehiculo> fvehiculos = Vehiculo.filtrarVehiculos();
                            if (fvehiculos.isEmpty())
                                System.out.println("[No hay vehiculos dentro de los parametros dados]");
                            else {
                                int index = 0;
                                System.out.println("\n[Presentando los vehiculos]");
                                do {
                                    System.out.println("\n<< VEHICULO " + (index + 1) + " >>\n");
                                    Vehiculo.presentarVehiculo(fvehiculos.get(index));
                                    System.out.println("\n------Opciones------");
                                    int n = 3;
                                    System.out.println("1 - Salir");
                                    System.out.println("2 - Dar oferta");
                                    if (index != fvehiculos.size() - 1) {
                                        System.out.println("3 - Siguiente Vehiculo");
                                    } else {
                                        n++;
                                    }
                                    if (index != 0) {
                                        System.out.println("4 - Anterior Vehiculo");
                                    }
                                    System.out.print("Ingrese una opcion: ");
                                    int op = sn.nextInt();
                                    if (op != 1 && op != 2) {
                                        while ((op == 3 && index == fvehiculos.size() - 1) || (op == 4 && index == 0)) {
                                            System.out.println("[Opcion no valida]");
                                            System.out.print("Ingrese una opciÃ³n: ");
                                            op = sn.nextInt();
                                        }
                                    }
                                    switch (op) {
                                        case 4: index--;
                                            break;
                                        case 3: index++;
                                            break;
                                        case 2: Oferta.registrarOferta(fvehiculos.get(index), datos.get(0));
                                                index = fvehiculos.size();
                                            break;
                                        case 1: index = fvehiculos.size();
                                            break;
                                    }
                                } while (index < fvehiculos.size());
                            }
                        }
                    }
                } else if (seleccion == 3) {
                    salir = true;
                } else if (seleccion > 3 || seleccion < 1) {
                    System.out.println("[Opcion fuera de rango. Ingrese otra opcion]");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[Debes insertar un numero]");
                sn.next();
            }
        }
    }

}
