package com.servitec.modelo.dao.interfaz;

import java.util.List;
import com.servitec.modelo.entidad.Ciudad;

public interface ICiudadDao {

	public List<Ciudad> listar();

	public void guardar(Ciudad Ciudad);

	public Ciudad buscarId(Long id);

	public void eliminar(Long id);
}
