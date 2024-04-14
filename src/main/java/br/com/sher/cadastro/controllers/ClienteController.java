package br.com.sher.cadastro.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sher.cadastro.entities.Cliente;

import br.com.sher.cadastro.repositories.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@GetMapping("/listar")
	public List<Cliente> findAll() {
		List<Cliente> result = repository.findAll();
		return result;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> consultarCliente(@PathVariable Long id) {
	    Optional<Cliente> optionalCliente = repository.findById(id);
	    if (optionalCliente.isPresent()) {
	        Cliente cliente = optionalCliente.get();
	        return ResponseEntity.ok(cliente);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Objeto não encontrado com o ID: " + id);
	    }
	}
	
	@PostMapping("/inserir")
	public Cliente insert(@RequestBody Cliente cliente) {
		Cliente result = repository.save(cliente);
		return result;
	}

}
