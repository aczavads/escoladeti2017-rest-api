package br.unicesumar.usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
@RequestMapping("/usuarios")
public class UsuarioController {
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	
	public UsuarioController() {
		usuarios.addAll(Arrays.asList(
			new Usuario("fulano", "fácil", "Fulano de Tal"),
			new Usuario("beltrano", "difícil", "Beltrano de Almeida")));
	}
	
	@GetMapping
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
	
	@GetMapping("/{id}")
	public Usuario getUsuarioPeloId(@PathVariable String id) {
		return this.usuarios.stream().parallel().filter(u -> u.getId().equals(id)).findFirst().get();
//		for (Usuario u : usuarios) {
//			if (u.getId().equals(id)) {
//				return u;
//			}
//		}
	}

	@PostMapping
	public void postUsuario(@RequestBody Usuario novo) {
		this.usuarios.add(novo);
	}
		
	@PatchMapping
	public void updateUsuario(@RequestBody Usuario novo) {
		this.usuarios = this.usuarios.stream().parallel().filter(u -> !u.getId().equals(novo.getId())).collect(Collectors.toList());
		this.usuarios.add(novo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteUsuario(@PathVariable String id) {
		if (id.equals("xxx")) {
			return ResponseEntity.notFound().build();
		}
		this.usuarios = this.usuarios.stream().parallel().filter(u -> !u.getId().equals(id)).collect(Collectors.toList());
		return ResponseEntity.ok().build();
	}
	
}













