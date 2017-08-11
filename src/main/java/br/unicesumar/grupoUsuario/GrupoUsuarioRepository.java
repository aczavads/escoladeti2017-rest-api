package br.unicesumar.grupoUsuario;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GrupoUsuarioRepository extends JpaRepository<GrupoUsuario, String>{
	
	@Query(nativeQuery=true, value="select id, nome from grupo_usuario")
	List<Map<String, Object>> selectGrupoSimples();

}
