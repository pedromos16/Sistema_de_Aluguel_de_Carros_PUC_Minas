package com.sac.demo.controller;

import com.sac.demo.DTO.Request.PedidoAluguelRequestDTO;
import com.sac.demo.DTO.Response.PedidoAluguelResponseDTO;
import com.sac.demo.model.PedidoAluguel;
import com.sac.demo.service.PedidoAluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/pedidoAluguel")
public class PedidoAluguelController {

    @Autowired
    private PedidoAluguelService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody PedidoAluguelRequestDTO objDTO){
        PedidoAluguel obj = objDTO.build();
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<PedidoAluguelResponseDTO> find(@PathVariable Integer id){
        PedidoAluguel obj = service.find(id);
        PedidoAluguelResponseDTO objDTO = new PedidoAluguelResponseDTO(obj);
        return ResponseEntity.ok().body(objDTO);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> update(@RequestBody PedidoAluguelRequestDTO objDTO, @PathVariable Integer id){
        PedidoAluguel obj = objDTO.build();
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
    public ResponseEntity<List<PedidoAluguelResponseDTO>> findAll(){
        List<PedidoAluguel> objList = service.findAll();
        List<PedidoAluguelResponseDTO> objListDTO = objList.stream().map(PedidoAluguelResponseDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(objListDTO);
    }

}
