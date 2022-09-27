package com.sac.demo.controller;

import com.sac.demo.DTO.Request.ClienteRequestDTO;
import com.sac.demo.DTO.Response.AgenteResponseDTO;
import com.sac.demo.DTO.Response.ClienteResponseDTO;
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
    private ClienteService service;

    @Autowired
    private AgenteService agenteService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ClienteRequestDTO objDTO){
        Agente agente;
        Cliente obj = objDTO.build();
        if(objDTO.getAgente() != null){
            agente = agenteService.find(objDTO.getAgente().getId());
            obj.setAgente(agente);
        }
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ClienteResponseDTO> find(@PathVariable Integer id){
        Cliente obj = service.find(id);
        ClienteResponseDTO objDTO = new ClienteResponseDTO(obj);
        return ResponseEntity.ok().body(objDTO);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> update(@RequestBody ClienteRequestDTO objDTO, @PathVariable Integer id){
        Cliente obj = objDTO.build();
        obj.setId(id);
        Agente agente;
        if(objDTO.getAgente() != null){
            agente = agenteService.find(objDTO.getAgente().getId());
            obj.setAgente(agente);
        }
        obj = service.update(obj);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> findAll(){
        List<Cliente> objList = service.findAll();
        List<ClienteResponseDTO> objListDTO = objList.stream().map(ClienteResponseDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(objListDTO);
    }


}
