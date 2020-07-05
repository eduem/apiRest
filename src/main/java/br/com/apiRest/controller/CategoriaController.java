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

import br.com.apiRest.entity.Categoria;
import br.com.apiRest.repository.CategoriaRepository;

@RestController
public class CategoriaController {
	
	 @Autowired
	    CategoriaRepository repository;

	    @RequestMapping(value = "/categoria", method = RequestMethod.POST)
	    public Categoria Post(@RequestBody Categoria categoria){
	        return repository.save(categoria);
	    }

	    @RequestMapping(value = "/categoria/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Categoria> Put(@PathVariable(value = "id") long id, @RequestBody Categoria newCategoria){
	        Optional<Categoria> oldCategoria = repository.findById(id);
	        if(oldCategoria.isPresent()){
	        	Categoria categoria = oldCategoria.get();
	            repository.save(categoria);
	            return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    @RequestMapping(value = "/categoria/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> DeleteId(@PathVariable(value = "id") long id){
	        Optional<Categoria> categoria = repository.findById(id);
	        if(categoria.isPresent()){
	        	repository.delete(categoria.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    @RequestMapping(value = "/categoria", method = RequestMethod.GET)
	    public List<Categoria> Get(){
	        return repository.findAll();
	    }
	    
	    @RequestMapping(value = "/categoria/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Categoria> GetById(@PathVariable(value = "id") long id){
	        Optional<Categoria> categoria = repository.findById(id);
	        if(categoria.isPresent())
	            return new ResponseEntity<Categoria>(categoria.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
}
