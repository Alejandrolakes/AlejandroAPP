/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.entrada;

/**
 *
 * @author alejandrolagosj
 */
import java.util.Scanner;


public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nombreObraTeatro = "Teatro Moro";
        int cantidadEntradasVendidas = 0;
        double totalIngresosPorVentas = 0.0;
        String asientoUltimaCompra = "";
        String tipoEntradaUltimaCompra = "";
        double precioUltimaCompra = 0.0;
        boolean hayCompra = false;
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Ventas de entradas - " + nombreObraTeatro + " ---");
            System.out.println("1. Registrar venta de entrada");
            System.out.println("2. Buscar última venta");
            System.out.println("3. Eliminar última venta");
            System.out.println("4. Consultar ventas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("¿Es usted estudiante? (S/N): ");
                    boolean estudiante = scanner.nextLine().equalsIgnoreCase("S");

                    System.out.print("Ingrese su edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Seleccione tipo de entrada: ");
                    System.out.println("1. VIP");
                    System.out.println("2. Platea Baja");
                    System.out.println("3. Platea Alta");
                    System.out.println("4. Palcos");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    String tipoEntrada = "";
                    double precioBase = 0;

                    if (tipo == 1) {
                        tipoEntrada = "VIP";
                        precioBase = estudiante ? 20000 : 30000;
                    } else if (tipo == 2) {
                        tipoEntrada = "Platea Baja";
                        precioBase = estudiante ? 10000 : 15000;
                    } else if (tipo == 3) {
                        tipoEntrada = "Platea Alta";
                        precioBase = estudiante ? 9000 : 18000;
                    } else if (tipo == 4) {
                        tipoEntrada = "Palcos";
                        precioBase = estudiante ? 6500 : 13000;
                    } else {
                        System.out.println("Tipo de entrada no válida.");
                        break;
                    }

                    System.out.println("\n--- Mapa de Asientos ---"); // muestra un mapa basico de los asientos disponibles
                    for (char fila = 'A'; fila <= 'E'; fila++) {
                        for (int numero = 1; numero <= 7; numero++) {
                            String asientoActual = "" + fila + numero;
                            if (hayCompra && asientoActual.equals(asientoUltimaCompra)) {
                                System.out.print("[X] ");
                            } else {
                                System.out.print("[" + asientoActual + "] ");
                            }
                        }
                        System.out.println();
                    }

                    String asiento = ""; // valida que el asiento exista 
                    boolean asientoValido = false;

                    while (!asientoValido) {
                        System.out.print("Seleccione su asiento (ej: A1): ");
                        asiento = scanner.nextLine().toUpperCase();

                        if (asiento.matches("[A-E][1-7]")) { // comparamos lo que ingresa el usuario con los parametros que nosotros indicamos
                            asientoValido = true;
                        } else {
                            System.out.println("Asiento inválido. Debe estar entre A1 y E7.");
                        }
                    }

                    double descuento = 0;
                    if (edad >= 60) {
                        descuento = 0.15;
                    } else if (estudiante) {
                        descuento = 0.10;
                    }

                    double precioFinal = precioBase - (precioBase * descuento);

                    System.out.println("\n--- Resumen de Compra ---");
                    System.out.println("Obra: " + nombreObraTeatro);
                    System.out.println("Asiento: " + asiento);
                    System.out.println("Tipo de entrada: " + tipoEntrada);
                    System.out.println("Precio base: $" + precioBase);
                    System.out.println("Descuento: " + (int) (descuento * 100) + "%");
                    System.out.println("Total a pagar: $" + precioFinal);

                    cantidadEntradasVendidas++;
                    totalIngresosPorVentas += precioFinal;

                    asientoUltimaCompra = asiento;
                    tipoEntradaUltimaCompra = tipoEntrada;
                    precioUltimaCompra = precioFinal;
                    hayCompra = true;

                    break;

                case 2:
                    if (hayCompra) {
                        System.out.println("Última entrada comprada:");
                        System.out.println("Asiento: " + asientoUltimaCompra);
                        System.out.println("Tipo de entrada: " + tipoEntradaUltimaCompra);
                        System.out.println("Precio: $" + precioUltimaCompra);
                    } else {
                        System.out.println("No se han realizado compras aún.");
                    }
                    break;

                case 3:
                    if (hayCompra) {
                        cantidadEntradasVendidas--;
                        totalIngresosPorVentas -= precioUltimaCompra;
                        hayCompra = false;
                        System.out.println("La última venta ha sido eliminada.");
                    } else {
                        System.out.println("No hay venta para eliminar.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Consulta de Ventas ---");
                    System.out.println("Cantidad de entradas vendidas: " + cantidadEntradasVendidas);
                    System.out.println("Total ingresos: $" + totalIngresosPorVentas);
                    break;

                case 5:
                    System.out.println("Gracias por comprar entradas para  Teatro Moro.");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }

        scanner.close();
    }
}


