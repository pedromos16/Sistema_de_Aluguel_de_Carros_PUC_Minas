package com.sac.demo.controller;

import com.sac.demo.DTO.AgenteDTO;
import com.sac.demo.DTO.ClienteDTO;
import com.sac.demo.DTO.ClientePDTO;
import com.sac.demo.model.Agente;
import com.sac.demo.model.Cliente;
import com.sac.demo.repository.AgenteRepository;
import com.sac.demo.service.AgenteService;
import com.sac.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {

    @Autowired
    private AgenteRepository repository;

    @Autowired
    private ClienteService service;

    @Autowired
    private AgenteService agenteService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ClientePDTO objDTO){
        Cliente obj = service.fromDTO(objDTO);
        obj.setUsuario(objDTO.getUsuario());
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Cliente> find(@PathVariable Integer id){
        Cliente obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> update(@RequestBody ClientePDTO objDTO, @PathVariable Integer id){
        Cliente obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj.setAgente(agenteService.find(objDTO.getAgenteId()));
        obj = service.update(obj);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        List<Cliente> objList = service.findAll();
        List<ClienteDTO> objListDTO = objList.stream().map(ClienteDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(objListDTO);
    }


}
