package com.servitec.modelo.servicio.interfaz;

import java.util.List;

import com.servitec.modelo.entidad.Funcion;

public interface IFuncionServicio {
	public List<Funcion> findAll();

	public void save(Funcion funcion);

	public Funcion findById(Long id);

	public void delete(Funcion funcion);
}
