package com.sac.demo.service;

import com.sac.demo.DTO.Response.ClienteResponseDTO;
import com.sac.demo.model.Agente;
import com.sac.demo.model.Cliente;
import com.sac.demo.repository.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Autowired
    private AgenteService agenteService;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(123L,"Objeto não encontrado! id: " + id));
    }

    public List<Cliente> findAll(){
        List<Cliente> objList = repo.findAll();
        return objList;
    }

    @Transactional
    public Cliente insert(Cliente obj){
        obj.setId(null);
        obj = repo.save(obj);
        return obj;
    }

    public void delete(Integer id) throws Exception {
        find(id);
        try{
            repo.deleteById(id);
        }catch(Exception e){
            throw new Exception("Não foi possivel excluir o cliente");
        }
    }

    public Cliente update(Cliente obj){
        Cliente newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(Cliente newObj, Cliente obj){
        newObj.setId(obj.getId());
        newObj.setUsuario(obj.getUsuario());
        newObj.setCpf(obj.getCpf());
        newObj.setEndereco(obj.getEndereco());
        newObj.setNome(obj.getNome());
        newObj.setPedidoAluguelList(obj.getPedidoAluguelList());
        newObj.setRg(obj.getRg());
        newObj.setEntidadeEmpregadora(obj.getEntidadeEmpregadora());
        newObj.setProfissao(obj.getProfissao());
        newObj.setRendimentos(obj.getRendimentos());
        newObj.setAgente(obj.getAgente());
    }
}
