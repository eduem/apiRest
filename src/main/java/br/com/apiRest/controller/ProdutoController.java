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

import br.com.apiRest.entity.Produto;
import br.com.apiRest.repository.ProdutoRepository;


@RestController
public class ProdutoController{

    @Autowired
    ProdutoRepository repository;

    @RequestMapping(value = "/produto", method = RequestMethod.POST)
    public Produto Post(@RequestBody Produto produto){
        return repository.save(produto);
    }

    @RequestMapping(value = "/produto/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Produto> Put(@PathVariable(value = "id") long id, @RequestBody Produto newProduto){
        Optional<Produto> oldProduto = repository.findById(id);
        if(oldProduto.isPresent()){
        	Produto produto = oldProduto.get();
            repository.save(produto);
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> DeleteId(@PathVariable(value = "id") long id){
        Optional<Produto> produto = repository.findById(id);
        if(produto.isPresent()){
        	repository.delete(produto.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/produto", method = RequestMethod.GET)
    public List<Produto> Get(){
        return repository.findAll();
    }
    
    @RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> GetById(@PathVariable(value = "id") long id){
        Optional<Produto> produto = repository.findById(id);
        if(produto.isPresent())
            return new ResponseEntity<Produto>(produto.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}   
