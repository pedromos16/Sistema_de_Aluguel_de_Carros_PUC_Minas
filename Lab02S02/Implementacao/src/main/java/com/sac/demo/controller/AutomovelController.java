package com.sac.demo.controller;

import com.sac.demo.DTO.Request.AutomovelRequestDTO;
import com.sac.demo.DTO.Response.AutomovelResponseDTO;
import com.sac.demo.model.Automovel;
import com.sac.demo.service.AutomovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/automoveis")
public class AutomovelController {

    @Autowired
    private AutomovelService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody AutomovelRequestDTO objDTO){
        Automovel obj = objDTO.build();
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<AutomovelResponseDTO> find(@PathVariable Integer id){
        Automovel obj = service.find(id);
        AutomovelResponseDTO objDTO = new AutomovelResponseDTO(obj);
        return ResponseEntity.ok().body(objDTO);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> update(@RequestBody AutomovelRequestDTO objDTO, @PathVariable Integer id){
        Automovel obj = objDTO.build();
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
    public ResponseEntity<List<AutomovelResponseDTO>> findAll(){
        List<Automovel> objList = service.findAll();
        List<AutomovelResponseDTO> objListDTO = objList.stream().map(AutomovelResponseDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(objListDTO);
    }

}
