package com.aplicacao.sislow.repositry;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aplicacao.sislow.model.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
	
	@Query("SELECT obj FROM Emprestimo obj WHERE obj.datafim BETWEEN :max AND :min and obj.emprestado = :estado")
	List<Emprestimo> findByEmprestado(LocalDate max, LocalDate min ,Boolean estado);
	
	
	@Query("SELECT obj FROM Emprestimo obj WHERE obj.datafim BETWEEN :max AND :min")
	List<Emprestimo> findEmprestimos(LocalDate max, LocalDate min);
	
<<<<<<< HEAD
	@Query("SELECT obj FROM Emprestimo obj WHERE obj.datafim < :data AND obj.emprestado = TRUE")
	List<Emprestimo> findEmprestimosAtrasados(LocalDate data);
	
	@Query("SELECT obj FROM Emprestimo obj WHERE obj.cliente.id = :idCliente")
	List<Emprestimo> findEmprestimosByCliente(Long idCliente);
	
	@Query("SELECT obj FROM Emprestimo obj WHERE obj.cliente.id = :idCliente AND  obj.datafim BETWEEN :dataInicio AND :dataFim AND obj.emprestado = TRUE")
	List<Emprestimo> findEmprestimosAbertosByCliente(Long idCliente, LocalDate dataInicio, LocalDate dataFim);
	
	@Query("SELECT obj FROM Emprestimo obj WHERE obj.cliente.id = :idCliente AND  obj.datafim < :dataFim AND obj.emprestado = TRUE")
	List<Emprestimo> findEmprestimosAtrasadosByCliente(Long idCliente, LocalDate dataFim);
=======
	@Query("SELECT obj FROM Emprestimo obj WHERE obj.datafim < :data")
	List<Emprestimo> findEmprestimosAtrasados(LocalDate data);
	

>>>>>>> ee6cfc2ec7a18d0f1eb2ac32e7594751812b81e6
}
