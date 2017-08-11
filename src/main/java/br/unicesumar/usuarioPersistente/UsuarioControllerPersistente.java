package br.unicesumar.usuarioPersistente;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuarios-persistentes")
public class UsuarioControllerPersistente {
	@Autowired
	private UsuarioRepository repo;
	
	
	@GetMapping
	public List<Usuario> getUsuarios() {
		return repo.findAll();
	}

	
	@GetMapping("/{id}")
	public Usuario getUsuarioPeloId(@PathVariable String id) {
		return repo.findOne(id);
	}

	@PostMapping
	public ResponseEntity<String> postUsuario(@RequestBody Usuario novo) {
		this.repo.save(novo);
		return ResponseEntity.ok(novo.getId());
	}
		
	@PatchMapping
	public void updateUsuario(@RequestBody Usuario novo) {
		this.repo.save(novo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteUsuario(@PathVariable String id) {
		if (id.equals("xxx")) {
			return ResponseEntity.notFound().build();
		}
		try {
			this.repo.delete(id);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Não foi possível excluir o usuário, verifique se ele está sendo utilizado em algum outro ponto do sistema!");
		}
		return ResponseEntity.ok().build();
	}
	

}
