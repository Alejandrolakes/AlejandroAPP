/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package teatromoro;

/**
 *
 * @author alejandrolagosj
 */
import java.util.Scanner;

public class TeatroMoro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        boolean continuar = true;

        for (; continuar;) {
            System.out.println("=== Teatro Moro - Sistema de Venta de Entradas ===");
            System.out.println("1. Comprar entrada");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            if (opcion == 1) { // Si elige comprar entrada. 
                scanner.nextLine(); 

                System.out.print("¿Es usted estudiante? (S/N): "); // preguntamos si es estudiante antes de todo para mostrar los valores.
                String esEstudiante = scanner.nextLine().toUpperCase();
                boolean estudiante = esEstudiante.equals("S");

                int edad = 0;
                boolean edadValida = false;
                while (!edadValida) {
                    System.out.print("Ingrese su edad: ");
                    if (scanner.hasNextInt()) {
                        edad = scanner.nextInt();
                        if (edad > 0 && edad < 120) {
                            edadValida = true;
                        } else {
                            System.out.println("Edad no válida. Intente nuevamente.");
                        }
                    } else {
                        System.out.println("Entrada inválida. Intente nuevamente.");
                        scanner.next();
                    }
                }

                scanner.nextLine();

                System.out.println("\n=== Tipos de Entrada y Tarifas Personalizadas ==="); // Nuestra segun la opcion ingresada
                if (estudiante) {
                    System.out.println("* Usted es estudiante. Tarifas especiales aplican.\n");
                    System.out.println("Tipo de Entrada     | Precio Estudiante");
                    System.out.println("------------------------------------");
                    System.out.println("VIP                | $20.000");
                    System.out.println("Platea Baja        | $10.000");
                    System.out.println("Platea Alta        | $9.000");
                    System.out.println("Palcos             | $6.500");
                } else {
                    System.out.println("* Usted no es estudiante. Tarifas generales aplican.\n");
                    System.out.println("Tipo de Entrada     | Precio General");
                    System.out.println("------------------------------------");
                    System.out.println("VIP                | $30.000");
                    System.out.println("Platea Baja        | $15.000");
                    System.out.println("Platea Alta        | $18.000");
                    System.out.println("Palcos             | $13.000");
                }

                System.out.println("\n=== Mapa de Asientos ===");
                System.out.print("    ");
                for (int col = 1; col <= 7; col++) {
                    System.out.print(col + "   ");
                }
                System.out.println();

                char fila = 'A';
                for (int row = 0; row < 5; row++) {
                    System.out.print(fila + " ");
                    for (int col = 1; col <= 7; col++) {
                        System.out.print("[" + fila + col + "]");
                    }
                    System.out.println();
                    fila++;
                }
                System.out.println();

                String tipoEntrada = "";
                boolean tipoValido = false;

                while (!tipoValido) {
                    System.out.print("Seleccione el tipo de entrada (VIP, PLATEA BAJA, PLATEA ALTA, PALCOS): ");
                    tipoEntrada = scanner.nextLine().toUpperCase();
                    if (tipoEntrada.equals("VIP") || tipoEntrada.equals("PLATEA BAJA") || tipoEntrada.equals("PLATEA ALTA") || tipoEntrada.equals("PALCOS")) {
                        tipoValido = true;
                    } else {
                        System.out.println("Tipo de entrada inválido. Intente nuevamente.");
                    }
                }

                String asientoSeleccionado = "";
                boolean asientoValido = false;

                while (!asientoValido) {
                    System.out.print("Seleccione su asiento (ejemplo B3): ");
                    asientoSeleccionado = scanner.nextLine().toUpperCase();

                    if (asientoSeleccionado.matches("[A-E][1-7]")) {
                        asientoValido = true;
                    } else {
                        System.out.println("Asiento inválido. Intente nuevamente.");
                    }
                }

                double precioBase = 0; 
                switch (tipoEntrada) {
                    case "VIP":
                        precioBase = estudiante ? 20000 : 30000;
                        break;
                    case "PLATEA BAJA":
                        precioBase = estudiante ? 10000 : 15000;
                        break;
                    case "PLATEA ALTA":
                        precioBase = estudiante ? 9000 : 18000;
                        break;
                    case "PALCOS":
                        precioBase = estudiante ? 6500 : 13000;
                        break;
                }

                // Calcular descuento final considerando edad o estudiante
                double descuento = 0;
                double precioFinal = 0;
                int contador = 1;
                do {
                    if (edad >= 60) {
                        descuento = 0.15;
                    } else if (estudiante) {
                        descuento = 0.10;
                    } else {
                        descuento = 0;
                    }
                    precioFinal = precioBase - (precioBase * descuento);
                    contador--;
                } while (contador > 0);
                            // Resumen de la compra. 
                System.out.println("\n=== Resumen de la Compra ===");
                System.out.println("Asiento seleccionado: " + asientoSeleccionado);
                System.out.println("Tipo de entrada: " + tipoEntrada);
                System.out.println("Precio base: $" + precioBase);
                System.out.println("Descuento aplicado: " + (int)(descuento * 100) + "%");
                System.out.println("Precio final a pagar: $" + precioFinal);

                System.out.print("\n¿Desea realizar otra compra? (S/N): ");
                String respuesta = scanner.nextLine().toUpperCase();
                if (!respuesta.equals("S")) {
                    continuar = false;
                    System.out.println("Gracias por su compra. ¡Hasta pronto!\n");
                }
            } else if (opcion == 2) {
                System.out.println("Gracias por utilizar el sistema. ¡Hasta pronto!");
                break;
            } else {
                System.out.println("Opción inválida. Intente nuevamente.\n");
            }
        }
        scanner.close();
    }
}


