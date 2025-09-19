package techlogistics.controller;

import techlogistics.model.EstadoEnvio;
import techlogistics.repository.EstadoEnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estados_envio")
public class EstadoEnvioController {
    @Autowired
    private EstadoEnvioRepository estadoEnvioRepository;

    @GetMapping public List<EstadoEnvio> getAllEstados() { return estadoEnvioRepository.findAll(); }
    @GetMapping("/{id}")
    public ResponseEntity<EstadoEnvio> getEstadoEnvioById(@PathVariable Integer id) {
        return estadoEnvioRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public EstadoEnvio createEstadoEnvio(@RequestBody EstadoEnvio estadoEnvio) { return estadoEnvioRepository.save(estadoEnvio); }
    @PutMapping("/{id}")
    public ResponseEntity<EstadoEnvio> updateEstadoEnvio(@PathVariable Integer id, @RequestBody EstadoEnvio estadoEnvioDetails) {
        return estadoEnvioRepository.findById(id).map(estadoEnvio -> {
            estadoEnvio.setId_ruta(estadoEnvioDetails.getId_ruta());
            estadoEnvio.setDescripcion_estado(estadoEnvioDetails.getDescripcion_estado());
            estadoEnvio.setFecha_hora_actualizacion(estadoEnvioDetails.getFecha_hora_actualizacion());
            estadoEnvio.setUbicacion_actual(estadoEnvioDetails.getUbicacion_actual());
            EstadoEnvio updatedEstadoEnvio = estadoEnvioRepository.save(estadoEnvio);
            return ResponseEntity.ok(updatedEstadoEnvio);
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadoEnvio(@PathVariable Integer id) {
        return estadoEnvioRepository.findById(id).map(estadoEnvio -> {
            estadoEnvioRepository.delete(estadoEnvio);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}