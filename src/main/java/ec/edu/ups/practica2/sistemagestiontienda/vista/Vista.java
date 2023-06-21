/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica2.sistemagestiontienda.vista;

import java.util.Scanner;

/**
 *
 * @author jeanp
 */
public class Vista {
    private Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenuPrincipal() {
        System.out.println("-------- Menú Principal --------");
        System.out.println("1. Agregar producto al inventario");
        System.out.println("2. Realizar venta");
        System.out.println("3. Mostrar inventario");
        System.out.println("4. Mostrar historial de ventas");
        System.out.println("5. Salir");
        System.out.println("--------------------------------");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        return opcion;
    }

    public String ingresarNombreProducto() {
        System.out.println("Ingrese el nombre del producto:");
        return scanner.nextLine();
    }

    public int ingresarCodigoProducto() {
        System.out.println("Ingrese el código del producto:");
        return scanner.nextInt();
    }

    public double ingresarPrecioProducto() {
        System.out.println("Ingrese el precio del producto:");
        return scanner.nextDouble();
    }

    public int ingresarCantidadProducto() {
        System.out.println("Ingrese la cantidad disponible:");
        return scanner.nextInt();
    }

    public int ingresarCodigoVenta() {
        System.out.println("Ingrese el código del producto a vender:");
        return scanner.nextInt();
    }

    public int ingresarCantidadVenta() {
        System.out.println("Ingrese la cantidad a vender:");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarProducto(String nombre, int codigo, double precio, int cantidad) {
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad disponible: " + cantidad);
        System.out.println("-----------------------------");
    }
}
