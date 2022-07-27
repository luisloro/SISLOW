package com.aplicacao.sislow.model.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao.sislow.model.Emprestimo;
import com.aplicacao.sislow.model.Equipamento;
import com.aplicacao.sislow.repositry.EmprestimoRepository;
import com.aplicacao.sislow.repositry.EquipamentoRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Transactional
public class EquipamentoController {
	
	@Autowired
	EmprestimoRepository emprestimoRepository;
	@Autowired
	EquipamentoRepository equipamentoRepository;
	
	/*
	@Transactional
	@GetMapping("/equipamento")
	public List<Equipamento> getEmprestimos(){
		return equipamentoRepository.findAll();
	}*/
	
	@PostMapping("/cadequip")
	public Equipamento saveEmprestimo(@RequestBody Equipamento equipamento) {
		return equipamentoRepository.save(equipamento);
	}

}
