package br.comspringboot.bo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.comspringboot.dao.CRUD;
import br.comspringboot.dao.ClienteDAO;
import br.comspringboot.model.Cliente;

@Service
public class ClienteBO implements CRUD<Cliente, Long> {
	@Autowired
	private ClienteDAO dao;

	@Override
	public Cliente pesquisaPeloId(Long id) {
		return dao.pesquisaPeloId(id);
	}

	@Override
	public List<Cliente> lista() {
		return dao.lista();
	}

	@Override
	public void insere(Cliente cliente) {
		dao.insere(cliente);
		
	}

	@Override
	public void atualiza(Cliente cliente) {
		dao.atualiza(cliente);
		
	}

	@Override
	public void remove(Cliente cliente) {
		dao.remove(cliente);
	}
	
	public void inativa(Cliente cliente) {
	    cliente.setAtivo(false);
	    dao.atualiza(cliente);		
	    
}
	
	public void ativa(Cliente cliente) {
		    cliente.setAtivo(true);
		    dao.atualiza(cliente);	
		    
	}	
	}			
		
