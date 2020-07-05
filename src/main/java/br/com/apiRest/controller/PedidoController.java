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
import org.springframework.web.bind.annotation.RestController;

import br.com.apiRest.entity.Pedido;
import br.com.apiRest.repository.PedidoRepository;


@RestController
public class PedidoController{

    @Autowired
    PedidoRepository repository;

    @RequestMapping(value = "/pedido", method = RequestMethod.POST)
    public Pedido Post(@RequestBody Pedido pedido){
        return repository.save(pedido);
    }

    @RequestMapping(value = "/pedido/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pedido> Put(@PathVariable(value = "id") long id, @RequestBody Pedido newPedido){
        Optional<Pedido> oldPedido = repository.findById(id);
        if(oldPedido.isPresent()){
        	Pedido pedido = oldPedido.get();
            repository.save(pedido);
            return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/pedido/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> DeleteId(@PathVariable(value = "id") long id){
        Optional<Pedido> pedido = repository.findById(id);
        if(pedido.isPresent()){
        	repository.delete(pedido.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/pedido", method = RequestMethod.GET)
    public List<Pedido> Get(){
        return repository.findAll();
    }
    
    @RequestMapping(value = "/pedido/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> GetById(@PathVariable(value = "id") long id){
        Optional<Pedido> pedido = repository.findById(id);
        if(pedido.isPresent())
            return new ResponseEntity<Pedido>(pedido.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}  
