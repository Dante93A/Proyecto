package techlogistics.controller;

import techlogistics.model.Transportista;
import techlogistics.repository.TransportistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transportistas")
public class TransportistaController {
    @Autowired
    private TransportistaRepository transportistaRepository;

    @GetMapping public List<Transportista> getAllTransportistas() { return transportistaRepository.findAll(); }
    @GetMapping("/{id}")
    public ResponseEntity<Transportista> getTransportistaById(@PathVariable Integer id) {
        return transportistaRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public Transportista createTransportista(@RequestBody Transportista transportista) { return transportistaRepository.save(transportista); }
    @PutMapping("/{id}")
    public ResponseEntity<Transportista> updateTransportista(@PathVariable Integer id, @RequestBody Transportista transportistaDetails) {
        return transportistaRepository.findById(id).map(transportista -> {
            transportista.setNombre_empresa(transportistaDetails.getNombre_empresa());
            transportista.setContacto(transportistaDetails.getContacto());
            transportista.setTelefono(transportistaDetails.getTelefono());
            Transportista updatedTransportista = transportistaRepository.save(transportista);
            return ResponseEntity.ok(updatedTransportista);
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransportista(@PathVariable Integer id) {
        return transportistaRepository.findById(id).map(transportista -> {
            transportistaRepository.delete(transportista);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}