package techlogistics.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transportistas")
public class Transportista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_transportista;
    private String nombre_empresa;
    private String contacto;
    private String telefono;

    public Transportista() {}
    public Transportista(String nombre_empresa, String contacto, String telefono) {
        this.nombre_empresa = nombre_empresa;
        this.contacto = contacto;
        this.telefono = telefono;
    }

    // Getters y Setters
    public Integer getId_transportista() { return id_transportista; }
    public void setId_transportista(Integer id_transportista) { this.id_transportista = id_transportista; }
    public String getNombre_empresa() { return nombre_empresa; }
    public void setNombre_empresa(String nombre_empresa) { this.nombre_empresa = nombre_empresa; }
    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}