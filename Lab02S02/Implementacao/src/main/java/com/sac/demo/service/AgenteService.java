package com.sac.demo.service;

import com.sac.demo.DTO.AgenteDTO;
import com.sac.demo.model.Agente;
import com.sac.demo.repository.AgenteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AgenteService {

    @Autowired
    private AgenteRepository repo;

    public Agente find(Integer id){
        Optional<Agente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(123L,"Objeto não encontrado! id: " + id));
    }

    public List<Agente> findAll(){
        List<Agente> objList = repo.findAll();
        return objList;
    }

    @Transactional
    public Agente insert(Agente obj){
        obj.setId(null);
        obj = repo.save(obj);
        return obj;
    }

    public void delete(Integer id) throws Exception {
        find(id);
        try{
            repo.deleteById(id);
        }catch(Exception e){
            throw new Exception("Não foi possivel excluir o agente");
        }
    }

    public Agente update(Agente obj){
        Agente newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public Agente fromDTO(AgenteDTO objDTO){
        return new Agente(objDTO.getId(), objDTO.getUsuario(), objDTO.getSenha());
    }

    private void updateData(Agente newObj, Agente obj){
        newObj.setUsuario(obj.getUsuario());
        newObj.setObsAvaliacao(obj.getObsAvaliacao());
    }
}
