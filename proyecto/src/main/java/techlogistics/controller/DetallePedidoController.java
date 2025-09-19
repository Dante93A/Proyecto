package techlogistics.controller;

import techlogistics.model.DetallePedido;
import techlogistics.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detalles_pedido")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @GetMapping public List<DetallePedido> getAllDetalles() { return detallePedidoRepository.findAll(); }
    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> getDetallePedidoById(@PathVariable Integer id) {
        return detallePedidoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public DetallePedido createDetallePedido(@RequestBody DetallePedido detallePedido) { return detallePedidoRepository.save(detallePedido); }
    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> updateDetallePedido(@PathVariable Integer id, @RequestBody DetallePedido detallePedidoDetails) {
        return detallePedidoRepository.findById(id).map(detallePedido -> {
            detallePedido.setId_pedido(detallePedidoDetails.getId_pedido());
            detallePedido.setId_producto(detallePedidoDetails.getId_producto());
            detallePedido.setCantidad(detallePedidoDetails.getCantidad());
            detallePedido.setPrecio_unitario(detallePedidoDetails.getPrecio_unitario());
            DetallePedido updatedDetallePedido = detallePedidoRepository.save(detallePedido);
            return ResponseEntity.ok(updatedDetallePedido);
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetallePedido(@PathVariable Integer id) {
        return detallePedidoRepository.findById(id).map(detallePedido -> {
            detallePedidoRepository.delete(detallePedido);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}