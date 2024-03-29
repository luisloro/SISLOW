package com.aplicacao.sislow.model.controller;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao.sislow.model.Cliente;
import com.aplicacao.sislow.model.Emprestimo;
import com.aplicacao.sislow.model.Equipamento;
import com.aplicacao.sislow.model.Usuario;
import com.aplicacao.sislow.repositry.ClienteRepository;
import com.aplicacao.sislow.repositry.EmprestimoRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Transactional
public class ClienteController {
	@Autowired
	ClienteRepository repository;

	@Autowired
	EmprestimoRepository emprestimoRepository;

	@GetMapping("/cliente")
	public List<Cliente> getClietes() {
		return repository.findAll();
	}

	/*
	 * @GetMapping("/cliente") public List<Cliente> getCliete(){ List clientes = new
	 * ArrayList<Cliente>();
	 * 
	 * clientes = repository.findAll();
	 * 
	 * return clientes; }
	 */

	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> clienteById(@PathVariable Long id) {
		Cliente cliente = repository.findById(id).get();
		return ResponseEntity.ok(cliente);
	}

	@Transactional
	@GetMapping("/cliente/emprestimos/{id}")
	public List<Emprestimo> emprestimosDoCliente(@PathVariable Long id) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
<<<<<<< HEAD

		Cliente cliente = repository.findById(id).get();
		List<Emprestimo> emprestimos = new ArrayList<>();
		for (Emprestimo emprestimo : emprestimoRepository.findEmprestimosByCliente(cliente.getId())) {
			emprestimo.setDataInicioFormatada(formatter.format(emprestimo.getDatainicio()));
			emprestimo.setDataFimFormatada(formatter.format(emprestimo.getDatafim()));

=======
		
		Cliente cliente = repository.findById(id).get();
		List<Emprestimo> emprestimos = new ArrayList<>();
		for (Emprestimo emprestimo : cliente.getEmprestimo()) {
			emprestimo.setDataInicioFormatada(formatter.format(emprestimo.getDatainicio()));
			emprestimo.setDataFimFormatada(formatter.format(emprestimo.getDatafim()));
			
>>>>>>> ee6cfc2ec7a18d0f1eb2ac32e7594751812b81e6
			emprestimos.add(emprestimo);
		}

		return emprestimos;
	}

	@PostMapping("/cadcli")
	public Cliente cadastraCliente(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}

	@Transactional
	@PostMapping("/cadcliente")
	public ResponseEntity<String> cadastraCliente(@RequestParam(value = "nome") String nome,
			@RequestParam(value = "fone") String fone, @RequestParam(value = "cpf") String cpf,
			@RequestParam(value = "senha") String senha, @RequestParam(value = "email") String email) {

<<<<<<< HEAD
		Cliente verifica = repository.encontraClienteCPF(cpf);
		if (verifica instanceof Cliente) {
			String msg = "CPF ja cadastrado no sistema";
			return ResponseEntity.ok(msg);
		}
=======
		
		
>>>>>>> ee6cfc2ec7a18d0f1eb2ac32e7594751812b81e6

		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setFone(fone);
		cliente.setCpf(cpf);
		cliente.setSenha(senha);
		cliente.setCnpj(".");
		cliente.setIe(".");
		cliente.setTipo(false);
		cliente.setEmail(email);
		repository.save(cliente);
<<<<<<< HEAD

=======
		
		String msg = "Cliente Cadastrado com sucesso";
		return ResponseEntity.ok(msg);
	}
	
	@Transactional
	@PostMapping("/cadclientejuridico")
	public ResponseEntity<String> cadastraClienteJuridico(@RequestParam(value = "nome") String nome,
			@RequestParam(value = "fone") String fone, @RequestParam(value = "cnpj") String cnpj,
			@RequestParam(value = "senha") String senha, @RequestParam(value = "email") String email,@RequestParam(value = "ie") String ie) {

		
		

		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setFone(fone);
		cliente.setCpf(".");
		cliente.setSenha(senha);
		cliente.setCnpj(".");
		cliente.setIe(ie);
		cliente.setTipo(true);
		cliente.setEmail(email);
		repository.save(cliente);
		
>>>>>>> ee6cfc2ec7a18d0f1eb2ac32e7594751812b81e6
		String msg = "Cliente Cadastrado com sucesso";
		return ResponseEntity.ok(msg);
	}

	@Transactional
	@PostMapping("/cadclientejuridico")
	public ResponseEntity<String> cadastraClienteJuridico(@RequestParam(value = "nome") String nome,
			@RequestParam(value = "fone") String fone, @RequestParam(value = "cnpj") String cnpj,
			@RequestParam(value = "senha") String senha, @RequestParam(value = "email") String email,
			@RequestParam(value = "ie") String ie) {

		Cliente verifica = repository.encontraClienteCNPJ(cnpj);
		if (verifica instanceof Cliente) {
			String msg = "CNPJ ja cadastrado no sistema";
			return ResponseEntity.ok(msg);
		}

		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setFone(fone);
		cliente.setCpf(".");
		cliente.setSenha(senha);
		cliente.setCnpj(cnpj);
		cliente.setIe(ie);
		cliente.setTipo(true);
		cliente.setEmail(email);
		repository.save(cliente);

		String msg = "Cliente Cadastrado com sucesso";
		return ResponseEntity.ok(msg);
	}

	@Transactional
	@PostMapping("/atucli")
	public ResponseEntity<Cliente> atualizaCliente(@RequestParam(value = "nome") String nome,
<<<<<<< HEAD
			@RequestParam(value = "fone") String fone, @RequestParam(value = "cpf") String cpf,
			@RequestParam(value = "id") String idCLiente, @RequestParam(value = "senha") String senha,
			@RequestParam(value = "cnpj") String cnpj, @RequestParam(value = "ie") String ie,
			@RequestParam(value = "email") String email) {

=======
			@RequestParam(value = "fone") String fone,
			@RequestParam(value = "cpf") String cpf,
			@RequestParam(value = "id") String idCLiente,
			@RequestParam(value = "senha") String senha,
			@RequestParam(value = "cnpj") String cnpj,
			@RequestParam(value = "ie") String ie,
			@RequestParam(value = "email") String email){

		
>>>>>>> ee6cfc2ec7a18d0f1eb2ac32e7594751812b81e6
		Long id = Long.parseLong(idCLiente);
		

		Cliente cliente = repository.findById(id).get();
		cliente.setNome(nome);
		cliente.setFone(fone);
		cliente.setCpf(cpf);
		cliente.setSenha(senha);
		cliente.setCnpj(cnpj);
		cliente.setIe(ie);
		cliente.setEmail(email);
		repository.save(cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/cliente/{id}")
	public void deletaCliente(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@GetMapping("/buscaCliente")
	public List<Cliente> buscaNome(@RequestParam(value = "nome") String nome) {
		List<Cliente> cliente = new ArrayList<Cliente>();
		List<Cliente> clientes = new ArrayList<Cliente>();
		cliente = repository.findAll();
		String nm = nome.toLowerCase();
		for (Cliente cli : cliente) {
			if (cli.getNome().toLowerCase().contains(nm)) {
				clientes.add(cli);
			}
		}
		return clientes;
	}
	
	@GetMapping("/testemenssagem")
	public String retornaMenssagem() {
		
		String msg = "Teste Menssagem";
		
		return msg;
	}
	
	
	
	/*
	@GetMapping("/consultaemp")
	public List<Emprestimo> buscaNome(@RequestParam(value = "documento") String documento,
							@RequestParam (value = "senha") String senha
			) {
		
		Long doc = Long.parseLong(documento);
		
		
		Cliente clienteCadastrado = repository.encontraCliente(doc,senha);
		Boolean estado = true;
		Long id = clienteCadastrado.getId();
		
		List<Emprestimo> emprestimos = clienteCadastrado.getEmprestimo();
		List<Emprestimo> lista = new ArrayList<Emprestimo>();
		for(Emprestimo emp:emprestimos) {
	    	if(emp.getEmprestado().equals(estado)) {
	    		lista.add(emp);
	    	}
	    }
		
		return lista;
	
	}*/

	@GetMapping("/testemenssagem")
	public String retornaMenssagem() {

		String msg = "Teste Menssagem";

		return msg;
	}

	/*
	 * @GetMapping("/consultaemp") public List<Emprestimo>
	 * buscaNome(@RequestParam(value = "documento") String documento,
	 * 
	 * @RequestParam (value = "senha") String senha ) {
	 * 
	 * Long doc = Long.parseLong(documento);
	 * 
	 * 
	 * Cliente clienteCadastrado = repository.encontraCliente(doc,senha); Boolean
	 * estado = true; Long id = clienteCadastrado.getId();
	 * 
	 * List<Emprestimo> emprestimos = clienteCadastrado.getEmprestimo();
	 * List<Emprestimo> lista = new ArrayList<Emprestimo>(); for(Emprestimo
	 * emp:emprestimos) { if(emp.getEmprestado().equals(estado)) { lista.add(emp); }
	 * }
	 * 
	 * return lista;
	 * 
	 * }
	 */

	@PostMapping("/cpf")
	public static String isCPF(@RequestParam(value = "cpf") String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return ("Falso");

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return ("Verdadeiro");
			else
				return ("Falso");
		} catch (InputMismatchException erro) {
			return ("Falso");
		}
	}

}
