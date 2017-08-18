package br.unicesumar.grupoUsuario;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicesumar.grupoUsuario.dtos.GrupoUsuarioDTO;

public interface GrupoUsuarioRepository extends JpaRepository<GrupoUsuario, String>{
	
	@Query(value="select new br.unicesumar.grupoUsuario.dtos.GrupoUsuarioDTO(g.id, g.nome) from GrupoUsuario g ")
	List<GrupoUsuarioDTO> selectGrupoSimples();

}
