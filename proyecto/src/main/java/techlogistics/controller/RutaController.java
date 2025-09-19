package techlogistics.controller;

import techlogistics.model.Ruta;
import techlogistics.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rutas")
public class RutaController {
    @Autowired
    private RutaRepository rutaRepository;

    @GetMapping public List<Ruta> getAllRutas() { return rutaRepository.findAll(); }
    @GetMapping("/{id}")
    public ResponseEntity<Ruta> getRutaById(@PathVariable Integer id) {
        return rutaRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public Ruta createRuta(@RequestBody Ruta ruta) { return rutaRepository.save(ruta); }
    @PutMapping("/{id}")
    public ResponseEntity<Ruta> updateRuta(@PathVariable Integer id, @RequestBody Ruta rutaDetails) {
        return rutaRepository.findById(id).map(ruta -> {
            ruta.setId_pedido(rutaDetails.getId_pedido());
            ruta.setId_transportista(rutaDetails.getId_transportista());
            ruta.setOrigen(rutaDetails.getOrigen());
            ruta.setDestino(rutaDetails.getDestino());
            ruta.setFecha_salida_estimada(rutaDetails.getFecha_salida_estimada());
            ruta.setFecha_llegada_estimada(rutaDetails.getFecha_llegada_estimada());
            Ruta updatedRuta = rutaRepository.save(ruta);
            return ResponseEntity.ok(updatedRuta);
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRuta(@PathVariable Integer id) {
        return rutaRepository.findById(id).map(ruta -> {
            rutaRepository.delete(ruta);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}