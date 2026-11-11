package com.uniremington.electrodomesticos.model.dao;

import com.uniremington.electrodomesticos.model.vo.ClienteVO;
import com.uniremington.electrodomesticos.model.vo.CompraVO;
import com.uniremington.electrodomesticos.model.vo.DetalleCompraVO;
import com.uniremington.electrodomesticos.model.vo.DetalleDevolucionVO;
import com.uniremington.electrodomesticos.model.vo.DetalleVentaVO;
import com.uniremington.electrodomesticos.model.vo.DevolucionVO;
import com.uniremington.electrodomesticos.model.vo.GarantiaVO;
import com.uniremington.electrodomesticos.model.vo.MovimientoInventarioVO;
import com.uniremington.electrodomesticos.model.vo.ProductoSerieVO;
import com.uniremington.electrodomesticos.model.vo.ProductoVO;
import com.uniremington.electrodomesticos.model.vo.ProveedorVO;
import com.uniremington.electrodomesticos.model.vo.UsuarioVO;
import com.uniremington.electrodomesticos.model.vo.VentaVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InMemoryDaoConfiguration {

    @Bean
    ClienteDAO clienteDAO() {
        return InMemoryDaoFactory.create(ClienteDAO.class, ClienteVO.class, "idCliente");
    }

    @Bean
    CompraDAO compraDAO() {
        return InMemoryDaoFactory.create(CompraDAO.class, CompraVO.class, "idCompra");
    }

    @Bean
    DetalleCompraDAO detalleCompraDAO() {
        return InMemoryDaoFactory.create(DetalleCompraDAO.class, DetalleCompraVO.class, "idDetalleCompra");
    }

    @Bean
    DetalleDevolucionDAO detalleDevolucionDAO() {
        return InMemoryDaoFactory.create(DetalleDevolucionDAO.class, DetalleDevolucionVO.class,
                "idDetalleDevolucion");
    }

    @Bean
    DetalleVentaDAO detalleVentaDAO() {
        return InMemoryDaoFactory.create(DetalleVentaDAO.class, DetalleVentaVO.class, "idDetalleVenta");
    }

    @Bean
    DevolucionDAO devolucionDAO() {
        return InMemoryDaoFactory.create(DevolucionDAO.class, DevolucionVO.class, "idDevolucion");
    }

    @Bean
    GarantiaDAO garantiaDAO() {
        return InMemoryDaoFactory.create(GarantiaDAO.class, GarantiaVO.class, "idGarantia");
    }

    @Bean
    MovimientoInventarioDAO movimientoInventarioDAO() {
        return InMemoryDaoFactory.create(MovimientoInventarioDAO.class, MovimientoInventarioVO.class, "idMovimiento");
    }

    @Bean
    ProductoDAO productoDAO() {
        return InMemoryDaoFactory.create(ProductoDAO.class, ProductoVO.class, "idProducto");
    }

    @Bean
    ProductoSerieDAO productoSerieDAO() {
        return InMemoryDaoFactory.create(ProductoSerieDAO.class, ProductoSerieVO.class, "idSerie");
    }

    @Bean
    ProveedorDAO proveedorDAO() {
        return InMemoryDaoFactory.create(ProveedorDAO.class, ProveedorVO.class, "idProveedor");
    }

    @Bean
    UsuarioDAO usuarioDAO() {
        return InMemoryDaoFactory.create(UsuarioDAO.class, UsuarioVO.class, "idUsuario");
    }

    @Bean
    VentaDAO ventaDAO() {
        return InMemoryDaoFactory.create(VentaDAO.class, VentaVO.class, "idVenta");
    }
}
