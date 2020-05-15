package com.servitec.modelo.servicio.interfaz;

import java.util.List;

public interface IServicio<T, Id> {
	public List<T> findAll();

	public void save(T t);

	public T findById(Id id);

	public void deleteById(Id id);
}
