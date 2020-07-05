package br.com.apiRest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.apiRest.entity.PedidoItens;
import br.com.apiRest.repository.PedidoItensRepository;

public class PedidoItensController {
	
	    @Autowired
	    PedidoItensRepository repository;

	    @RequestMapping(value = "/pedidoItens", method = RequestMethod.POST)
	    public PedidoItens Post(@RequestBody PedidoItens pedidoItens){
	        return repository.save(pedidoItens);
	    }

	    @RequestMapping(value = "/pedidoItens/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<PedidoItens> Put(@PathVariable(value = "id") long id, @RequestBody PedidoItens newPedidoItens){
	        Optional<PedidoItens> oldPedidoItens = repository.findById(id);
	        if(oldPedidoItens.isPresent()){
	        	PedidoItens pedidoItens = oldPedidoItens.get();
	            repository.save(pedidoItens);
	            return new ResponseEntity<PedidoItens>(pedidoItens, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    @RequestMapping(value = "/pedidoItens/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> DeleteId(@PathVariable(value = "id") long id){
	        Optional<PedidoItens> pedidoItens = repository.findById(id);
	        if(pedidoItens.isPresent()){
	        	repository.delete(pedidoItens.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    @RequestMapping(value = "/pedidoItens", method = RequestMethod.GET)
	    public List<PedidoItens> Get(){
	        return repository.findAll();
	    }
	    
	    @RequestMapping(value = "/pedidoItens/{id}", method = RequestMethod.GET)
	    public ResponseEntity<PedidoItens> GetById(@PathVariable(value = "id") long id){
	        Optional<PedidoItens> pedidoItens = repository.findById(id);
	        if(pedidoItens.isPresent())
	            return new ResponseEntity<PedidoItens>(pedidoItens.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

}
