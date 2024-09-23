package org.example.eitorresmendoza.webapp.produces.factura.tarea15.models;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Date;
import java.util.List;

@Named
@RequestScoped
public class Factura {
    private Cliente cliente;
    private Integer folioFactura;
    private String descripcion;

    @Inject
    private List<LineaFactura> detalleFactura;


    @PostConstruct
    public void inicializar() {
        folioFactura = (int) Math.round(Math.random() * 100) + 10;
        descripcion = "Factura de compras con fecha de: " + new Date();
        System.out.println("Factura " + folioFactura + " creada: ".concat(descripcion));
    }

    @PreDestroy
    public void destruir(){
        System.out.println("Factura " + folioFactura + " destruida: ".concat(descripcion));
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Inject
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getFolioFactura() {
        return folioFactura;
    }

    public void setFolioFactura(Integer folioFactura) {
        this.folioFactura = folioFactura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<LineaFactura> getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(List<LineaFactura> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public Double getTotal() {
        return detalleFactura.stream().mapToDouble(LineaFactura::calcularImporte).sum();
    }

}
