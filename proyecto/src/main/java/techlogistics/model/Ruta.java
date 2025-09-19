package techlogistics.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Rutas")
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ruta;
    private Integer id_pedido;
    private Integer id_transportista;
    private String origen;
    private String destino;
    private Date fecha_salida_estimada;
    private Date fecha_llegada_estimada;

    public Ruta() {}
    public Ruta(Integer id_pedido, Integer id_transportista, String origen, String destino, Date fecha_salida_estimada, Date fecha_llegada_estimada) {
        this.id_pedido = id_pedido;
        this.id_transportista = id_transportista;
        this.origen = origen;
        this.destino = destino;
        this.fecha_salida_estimada = fecha_salida_estimada;
        this.fecha_llegada_estimada = fecha_llegada_estimada;
    }

    // Getters y Setters
    public Integer getId_ruta() { return id_ruta; }
    public void setId_ruta(Integer id_ruta) { this.id_ruta = id_ruta; }
    public Integer getId_pedido() { return id_pedido; }
    public void setId_pedido(Integer id_pedido) { this.id_pedido = id_pedido; }
    public Integer getId_transportista() { return id_transportista; }
    public void setId_transportista(Integer id_transportista) { this.id_transportista = id_transportista; }
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public Date getFecha_salida_estimada() { return fecha_salida_estimada; }
    public void setFecha_salida_estimada(Date fecha_salida_estimada) { this.fecha_salida_estimada = fecha_salida_estimada; }
    public Date getFecha_llegada_estimada() { return fecha_llegada_estimada; }
    public void setFecha_llegada_estimada(Date fecha_llegada_estimada) { this.fecha_llegada_estimada = fecha_llegada_estimada; }
}