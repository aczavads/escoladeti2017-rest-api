package br.unicesumar.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repo;
	
	
	@GetMapping
	public ResponseEntity<List<Produto>> get() {
		return ResponseEntity.ok(repo.findAll());
	}
	
	@PostMapping
	public ResponseEntity<ProdutoId> post(@RequestBody Produto novo) {
		this.repo.save(novo);
		return ResponseEntity.ok(novo.getId());
	}
	

}
