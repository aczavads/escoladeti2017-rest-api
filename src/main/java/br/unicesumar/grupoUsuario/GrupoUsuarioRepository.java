package br.unicesumar.grupoUsuario;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicesumar.grupoUsuario.dtos.GrupoUsuarioDTO;

public interface GrupoUsuarioRepository extends JpaRepository<GrupoUsuario, String>{
	
	@Query(value="select new br.unicesumar.grupoUsuario.dtos.GrupoUsuarioDTO(u.id, u.nome) from GrupoUsuario g inner join g.usuarios u")
	List<GrupoUsuarioDTO> selectGrupoSimples();

}
