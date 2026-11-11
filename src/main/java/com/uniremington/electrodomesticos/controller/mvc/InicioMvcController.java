package com.uniremington.electrodomesticos.controller.mvc;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioMvcController {

    private static final List<Map<String, String>> MODULES = List.of(
            module("Clientes", "Personas y datos de contacto", "/clientes", "CL"),
            module("Productos", "Catálogo y niveles de inventario", "/productos", "PR"),
            module("Proveedores", "Empresas y abastecimiento", "/proveedores", "PV"),
            module("Usuarios", "Accesos y perfiles del sistema", "/usuarios", "US"),
            module("Ventas", "Facturación y detalle de ventas", "/ventas", "VE"),
            module("Compras", "Recepción y detalle de compras", "/compras", "CO"),
            module("Devoluciones", "Solicitudes y sus detalles", "/devoluciones", "DE"),
            module("Garantías", "Coberturas y reclamos", "/garantias", "GA"),
            module("Series", "Trazabilidad por unidad", "/series", "SE"),
            module("Movimientos", "Entradas y salidas de inventario", "/movimientos-inventario", "MI"),
            module("Detalles de venta", "Productos incluidos en ventas", "/detalles-venta", "DV"),
            module("Detalles de compra", "Productos incluidos en compras", "/detalles-compra", "DC"),
            module("Detalles de devolución", "Productos incluidos en devoluciones", "/detalles-devolucion", "DD"));

    @GetMapping({"/", "/inicio"})
    public String home(Model model) {
        model.addAttribute("title", "Panel de control");
        model.addAttribute("activePath", "/");
        model.addAttribute("modules", MODULES);
        return "inicio";
    }

    private static Map<String, String> module(String name, String description, String path, String initials) {
        return Map.of("name", name, "description", description, "path", path, "initials", initials);
    }
}
