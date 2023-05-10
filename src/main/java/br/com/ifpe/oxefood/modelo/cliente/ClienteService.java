package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class ClienteService extends GenericService {

   @Autowired
   private ClienteRepository clienteRepository;

   @Transactional
   public Cliente save(Cliente cliente) {

       super.preencherCamposAuditoria(cliente);
       return clienteRepository.save(cliente);
   }

   
   public List<Cliente> listarTodos() {
  
    return clienteRepository.findAll();
}

public Cliente obterPorID(Long id) {

    return clienteRepository.findById(id).get();
}


}
