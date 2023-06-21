/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica2.sistemagestiontienda.modelo;

import java.util.LinkedList;

/**
 *
 * @author jeanp
 */
public class Inventario {
    private LinkedList<Producto> inventario;
    private LinkedList<Producto> historialVentas;

    public Inventario() {
        inventario = new LinkedList<>();
        historialVentas = new LinkedList<>();
    }

    public void agregarProducto(String nombre, int codigo, double precio, int cantidad) {
        Producto producto = new Producto(nombre, codigo, precio, cantidad);
        inventario.add(producto);
    }

    public void agregarVenta(Producto productoVenta) {
        historialVentas.add(productoVenta);
    }

    public LinkedList<Producto> getInventario() {
        return inventario;
    }

    public LinkedList<Producto> getHistorialVentas() {
        return historialVentas;
    }

    public Producto buscarProducto(int codigo) {
        for (Producto producto : inventario) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null;
    }
}
