package br.unicesumar.grupoUsuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class GrupoUsuarioService {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public GrupoUsuarioService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<GrupoUsuarioDTO> selectGrupoSimples() {
		RowMapper<GrupoUsuarioDTO> rowMapper = new RowMapper<GrupoUsuarioDTO>() {

			@Override
			public GrupoUsuarioDTO mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				
				return new GrupoUsuarioDTO(id, nome);
			}
		};
		
		return jdbcTemplate.query("select id, nome from grupo_usuario", rowMapper);
	}

}
