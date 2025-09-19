package techlogistics.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;
    private Integer id_cliente;
    private Date fecha_pedido;
    private String estado;
    private double total;

    public Pedido() {}
    public Pedido(Integer id_cliente, Date fecha_pedido, String estado, double total) {
        this.id_cliente = id_cliente;
        this.fecha_pedido = fecha_pedido;
        this.estado = estado;
        this.total = total;
    }

    // Getters y Setters
    public Integer getId_pedido() { return id_pedido; }
    public void setId_pedido(Integer id_pedido) { this.id_pedido = id_pedido; }
    public Integer getId_cliente() { return id_cliente; }
    public void setId_cliente(Integer id_cliente) { this.id_cliente = id_cliente; }
    public Date getFecha_pedido() { return fecha_pedido; }
    public void setFecha_pedido(Date fecha_pedido) { this.fecha_pedido = fecha_pedido; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}