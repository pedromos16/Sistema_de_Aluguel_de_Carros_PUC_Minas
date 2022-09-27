package com.sac.demo.controller;

import com.sac.demo.DTO.Response.AgenteResponseDTO;
import com.sac.demo.DTO.Request.AgenteRequestDTO;
import com.sac.demo.model.Agente;
import com.sac.demo.repository.AgenteRepository;
import com.sac.demo.service.AgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/agentes")
public class AgenteController {

    @Autowired
    private AgenteRepository repository;

    @Autowired
    private AgenteService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody AgenteRequestDTO objDTO){
        Agente obj = objDTO.build();
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<AgenteResponseDTO> find(@PathVariable Integer id){
        Agente obj = service.find(id);
        AgenteResponseDTO objDTO = new AgenteResponseDTO(obj);
        return ResponseEntity.ok().body(objDTO);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> update(@RequestBody AgenteRequestDTO objDTO, @PathVariable Integer id){
        Agente obj = objDTO.build();
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AgenteResponseDTO>> findAll(){
        List<Agente> objList = service.findAll();
        List<AgenteResponseDTO> objListDTO = objList.stream().map(AgenteResponseDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(objListDTO);
    }


}
