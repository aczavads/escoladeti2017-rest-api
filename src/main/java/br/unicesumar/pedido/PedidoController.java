package br.unicesumar.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired
	private PedidoRepository repo;
	
	
	@GetMapping
	public ResponseEntity<List<Pedido>> get() {
		return ResponseEntity.ok(repo.findAll());
	}
	
	@PostMapping
	public ResponseEntity<PedidoId> post(@RequestBody Pedido novo) {
		this.repo.save(novo);
		return ResponseEntity.ok(novo.getId());
	}
	
	

}
