package com.sac.demo.service;

import com.sac.demo.model.Automovel;
import com.sac.demo.repository.AutomovelRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AutomovelService {

    @Autowired
    private AutomovelRepository automovelRepository;

    @Transactional
    public Automovel insert(Automovel obj){
        obj.setId(null);
        obj = automovelRepository.save(obj);
        return obj;
    }

    public Automovel find(Integer id){
        Optional<Automovel> obj = automovelRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(1241, "Autmovel não encontrado. Id: " + id + " "));
    }

    public List<Automovel> findAll(){
        List<Automovel> objList = automovelRepository.findAll();
        return objList;
    }

    public Automovel update(Automovel obj){
        Automovel newObj = find(obj.getId());
        updateData(newObj, obj);
        return automovelRepository.save(newObj);
    }

    public void delete(Integer id) throws Exception{
        find(id);
        try {
            automovelRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception(("Não foi possivel excluir o automovel. Id:" + id));
        }
    }

    private void updateData(Automovel newobj, Automovel obj){
        newobj.setAno(obj.getAno());
        newobj.setId(obj.getId());
        newobj.setModelo(obj.getModelo());
        newobj.setPlaca(obj.getPlaca());
        newobj.setMarca(obj.getMarca());
        newobj.setMatricula(obj.getMatricula());
        newobj.setPreco(obj.getPreco());
    }
}
