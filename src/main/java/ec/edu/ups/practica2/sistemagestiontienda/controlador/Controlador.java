/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica2.sistemagestiontienda.controlador;

import ec.edu.ups.practica2.sistemagestiontienda.modelo.Inventario;
import ec.edu.ups.practica2.sistemagestiontienda.modelo.Producto;
import ec.edu.ups.practica2.sistemagestiontienda.vista.Vista;

/**
 *
 * @author jeanp
 */
public class Controlador {
    private Vista vista;
    private Inventario inventario;

    public Controlador() {
        vista = new Vista();
        inventario = new Inventario();
    }

    public void iniciar() {
        while (true) {
            int opcion = vista.mostrarMenuPrincipal();

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    realizarVenta();
                    break;
                case 3:
                    mostrarInventario();
                    break;
                case 4:
                    mostrarHistorialVentas();
                    break;
                case 5:
                    vista.mostrarMensaje("¡Hasta luego!");
                    return;
                default:
                    vista.mostrarMensaje("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        }
    }

    private void agregarProducto() {
        String nombre = vista.ingresarNombreProducto();
        int codigo = vista.ingresarCodigoProducto();
        double precio = vista.ingresarPrecioProducto();
        int cantidad = vista.ingresarCantidadProducto();

        inventario.agregarProducto(nombre, codigo, precio, cantidad);
        vista.mostrarMensaje("Producto agregado correctamente al inventario.");
    }

    private void realizarVenta() {
        int codigoVenta = vista.ingresarCodigoVenta();
        int cantidadVenta = vista.ingresarCantidadVenta();

        Producto producto = inventario.buscarProducto(codigoVenta);
        if (producto != null) {
            if (producto.getCantidad() >= cantidadVenta) {
                producto.setCantidad(producto.getCantidad() - cantidadVenta);
                Producto productoVenta = new Producto(producto.getNombre(), producto.getCodigo(),
                        producto.getPrecio(), cantidadVenta);
                inventario.agregarVenta(productoVenta);
                vista.mostrarMensaje("Venta realizada correctamente.");
            } else {
                vista.mostrarMensaje("No hay suficiente cantidad disponible para realizar la venta.");
            }
        } else {
            vista.mostrarMensaje("No se encontró ningún producto con el código especificado.");
        }
    }

    private void mostrarInventario() {
        vista.mostrarMensaje("Inventario:");
        for (Producto producto : inventario.getInventario()) {
            vista.mostrarProducto(producto.getNombre(), producto.getCodigo(),
                    producto.getPrecio(), producto.getCantidad());
        }
    }

    private void mostrarHistorialVentas() {
        vista.mostrarMensaje("Historial de Ventas:");
        for (Producto productoVenta : inventario.getHistorialVentas()) {
            vista.mostrarProducto(productoVenta.getNombre(), productoVenta.getCodigo(),
                    productoVenta.getPrecio(), productoVenta.getCantidad());
        }
    }
}
