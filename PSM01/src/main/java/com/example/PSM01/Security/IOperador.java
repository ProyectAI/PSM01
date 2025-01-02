package com.example.PSM01.Security;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IOperador extends CrudRepository<Operador, Integer>  {
	Optional<Operador> findBynicope(String nombre);
}
