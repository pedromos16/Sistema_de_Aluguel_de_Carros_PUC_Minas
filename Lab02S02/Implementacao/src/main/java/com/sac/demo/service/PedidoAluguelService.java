package com.sac.demo.service;

import com.sac.demo.model.Automovel;
import com.sac.demo.model.Cliente;
import com.sac.demo.model.PedidoAluguel;
import com.sac.demo.repository.PedidoAluguelRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoAluguelService {

    @Autowired
    private PedidoAluguelRepository pedidoAluguelRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AutomovelService automovelService;

    @Transactional
    public PedidoAluguel insert(PedidoAluguel obj){
        obj.setId(null);
        if(!obj.getAutomovelList().isEmpty()){
            for(int i = 0; i < obj.getAutomovelList().size(); i++){
                Automovel aux = automovelService.find(obj.getAutomovelList().get(i).getId());
                obj.getAutomovelList().remove(obj.getAutomovelList().get(i));
                obj.getAutomovelList().add(aux);
                aux.setPedidoAluguel(obj);
                automovelService.update(aux);
            }
        }
        if(obj.getCliente() != null){
            Cliente cli = clienteService.find(obj.getCliente().getId());
            obj.setCliente(cli);
            cli.getPedidoAluguelList().add(obj);
            clienteService.update(cli);
        }

        obj.setPreco(calcularPrecoTotal(obj));
        obj = pedidoAluguelRepository.save(obj);
        return obj;
    }

    public PedidoAluguel find(Integer id){
        Optional<PedidoAluguel> obj = pedidoAluguelRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(1241, "Autmovel não encontrado. Id: " + id + " "));
    }

    public List<PedidoAluguel> findAll(){
        List<PedidoAluguel> objList = pedidoAluguelRepository.findAll();
        return objList;
    }

    public PedidoAluguel update(PedidoAluguel obj){
        if(!obj.getAutomovelList().isEmpty())
            obj.setPreco(calcularPrecoTotal(obj));
        PedidoAluguel newObj = find(obj.getId());
        updateData(newObj, obj);
        return pedidoAluguelRepository.save(newObj);
    }

    public void delete(Integer id) throws Exception{
        find(id);
        try {
            pedidoAluguelRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception(("Não foi possivel excluir o pedidoAluguel. Id:" + id));
        }
    }

    private void updateData(PedidoAluguel newobj, PedidoAluguel obj){
        newobj.setId(obj.getId());
        newobj.setObservacao(obj.getObservacao());
        newobj.setPreco(obj.getPreco());
        newobj.setCliente(obj.getCliente());
        newobj.setAutomovelList(obj.getAutomovelList());
    }

    private Double calcularPrecoTotal(PedidoAluguel obj){
        return new ArrayList<>(obj.getAutomovelList())
                .stream().map(Automovel::getPreco)
                .filter(p -> p != null)
                .reduce(0.0, Double::sum);
    }
}
