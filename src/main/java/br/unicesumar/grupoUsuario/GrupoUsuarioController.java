package br.unicesumar.grupoUsuario;

import java.util.List;
import java.util.Map;
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

import br.unicesumar.usuarioPersistente.UsuarioRepository;


@RestController
@RequestMapping("/grupos")
public class GrupoUsuarioController {
	@Autowired
	private GrupoUsuarioRepository repo;
	@Autowired
	private UsuarioRepository repoUsuario;
	
	@GetMapping
	public List<GrupoUsuario> getGruposUsuarios() {
		//return repo.selectGrupoSimples();
		return repo.findAll();
	}

	@PostMapping("/usuarios")
	public ResponseEntity postUsuario(@RequestBody AdicionarUsuarioAoGrupo comando) {
		
		GrupoUsuario grupo = this.repo.findOne(comando.idDoGrupo);
		grupo.vincular(repoUsuario.findOne(comando.idDoUsuario));
		repo.save(grupo);
		
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/usuarios")
	public ResponseEntity deleteUsuario(@RequestBody RemoverUsuarioDoGrupo comando) {
		
		GrupoUsuario grupo = this.repo.findOne(comando.idDoGrupo);
		grupo.remover(repoUsuario.findOne(comando.idDoUsuario));
		repo.save(grupo);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public GrupoUsuario getGrupoUsuarioPeloId(@PathVariable String id) {
		return repo.findOne(id);
	}

	@PostMapping
	public ResponseEntity<String> postGrupoUsuario(@RequestBody GrupoUsuario novo) {
		this.repo.save(novo);
		return ResponseEntity.ok(novo.getId());
	}
		
	@PatchMapping
	public void updateGrupoUsuario(@RequestBody GrupoUsuario novo) {
		this.repo.save(novo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteGrupoUsuario(@PathVariable String id) {
		if (id.equals("xxx")) {
			return ResponseEntity.notFound().build();
		}
		this.repo.delete(id);
		return ResponseEntity.ok().build();
	}
	

}
