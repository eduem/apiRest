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

import br.com.apiRest.entity.Cliente;
import br.com.apiRest.repository.ClienteRepository;


@RestController
public class ClienteController{

    @Autowired
    ClienteRepository repository;

    @RequestMapping(value = "/cliente", method = RequestMethod.POST)
    public Cliente Post(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cliente> Put(@PathVariable(value = "id") long id, @RequestBody Cliente newCliente){
        Optional<Cliente> oldCliente = repository.findById(id);
        if(oldCliente.isPresent()){
        	Cliente cliente = oldCliente.get();
            cliente.setNome(newCliente.getNome());
            repository.save(cliente);
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> DeleteId(@PathVariable(value = "id") long id){
        Optional<Cliente> cliente = repository.findById(id);
        if(cliente.isPresent()){
        	repository.delete(cliente.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public List<Cliente> Get(){
        return repository.findAll();
    }
    
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> GetById(@PathVariable(value = "id") long id){
        Optional<Cliente> cliente = repository.findById(id);
        if(cliente.isPresent())
            return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}   