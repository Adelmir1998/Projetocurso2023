package com.projeto.spring.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.spring.curso.domain.Turma;
import com.projeto.spring.curso.repository.TurmaRepository;

@RestController
public class TurmaController {
	
	@Autowired
	private TurmaRepository tu;
	
	@GetMapping("/turma/listar")
	public List<Turma> listar(){
		return tu.findAll();
	}
	@GetMapping("/turma/listar/{id}")
	public Optional<Turma> listar(@PathVariable Long id) {
		return tu.findById(id);
	}
	@PostMapping("/turma/cadastrar")
	public String cadastrar(@RequestBody Turma turma) {
		
		tu.save(turma);
		return "Turma Cadastrada com sucesso!";
	}
	@PutMapping("/turma/atualizar/{id}")
	public String atualizar(@PathVariable Long id, @RequestBody Turma turma) {
		String msg ="";
		Optional<Turma> t = tu.findById(id);
		
		if(t.isPresent()) {
			turma.setIdcurso(id);
			tu.save(turma);
			msg = "Turma Atualizada";
		}
		else {
			msg = "Turma não encontranda";
		}
		return msg;
	}
	@DeleteMapping("/turma/apagar/{id}")
	public String apagar(@PathVariable Long id) {
		String msg ="";
		Optional<Turma> t = tu.findById(id); 
		
		if(t.isPresent()) {
			tu.deleteById(id);
			msg = "Turma Apagada";
		}
	else {
		msg = "Turma não encontrada";
	}
	return msg;
	}
}
