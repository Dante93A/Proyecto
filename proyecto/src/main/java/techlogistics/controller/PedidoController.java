package techlogistics.controller;

import techlogistics.model.Pedido;
import techlogistics.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping public List<Pedido> getAllPedidos() { return pedidoRepository.findAll(); }
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Integer id) {
        return pedidoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public Pedido createPedido(@RequestBody Pedido pedido) { return pedidoRepository.save(pedido); }
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Integer id, @RequestBody Pedido pedidoDetails) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setId_cliente(pedidoDetails.getId_cliente());
            pedido.setFecha_pedido(pedidoDetails.getFecha_pedido());
            pedido.setEstado(pedidoDetails.getEstado());
            pedido.setTotal(pedidoDetails.getTotal());
            Pedido updatedPedido = pedidoRepository.save(pedido);
            return ResponseEntity.ok(updatedPedido);
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Integer id) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedidoRepository.delete(pedido);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}