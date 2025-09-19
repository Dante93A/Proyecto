package techlogistics.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "EstadosEnvio")
public class EstadoEnvio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_estado_envio;
    private Integer id_ruta;
    private String descripcion_estado;
    private Date fecha_hora_actualizacion;
    private String ubicacion_actual;

    public EstadoEnvio() {}
    public EstadoEnvio(Integer id_ruta, String descripcion_estado, Date fecha_hora_actualizacion, String ubicacion_actual) {
        this.id_ruta = id_ruta;
        this.descripcion_estado = descripcion_estado;
        this.fecha_hora_actualizacion = fecha_hora_actualizacion;
        this.ubicacion_actual = ubicacion_actual;
    }

    // Getters y Setters
    public Integer getId_estado_envio() { return id_estado_envio; }
    public void setId_estado_envio(Integer id_estado_envio) { this.id_estado_envio = id_estado_envio; }
    public Integer getId_ruta() { return id_ruta; }
    public void setId_ruta(Integer id_ruta) { this.id_ruta = id_ruta; }
    public String getDescripcion_estado() { return descripcion_estado; }
    public void setDescripcion_estado(String descripcion_estado) { this.descripcion_estado = descripcion_estado; }
    public Date getFecha_hora_actualizacion() { return fecha_hora_actualizacion; }
    public void setFecha_hora_actualizacion(Date fecha_hora_actualizacion) { this.fecha_hora_actualizacion = fecha_hora_actualizacion; }
    public String getUbicacion_actual() { return ubicacion_actual; }
    public void setUbicacion_actual(String ubicacion_actual) { this.ubicacion_actual = ubicacion_actual; }
}