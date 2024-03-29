package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.acesso.UsuarioService;
import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class ClienteService extends GenericService {

   @Autowired
   private ClienteRepository clienteRepository;

   @Autowired
   private UsuarioService usuarioService;

   @Transactional
   public Cliente save(Cliente cliente) {

    usuarioService.save(cliente.getUsuario());

       super.preencherCamposAuditoria(cliente);
       return clienteRepository.save(cliente);
   }

   
   public List<Cliente> listarTodos() {
  
    return clienteRepository.findAll();
}

public Cliente obterPorID(Long id) {

    return clienteRepository.findById(id).get();
}

@Transactional
public void update(Long id, Cliente clienteAlterado) {

   Cliente cliente = clienteRepository.findById(id).get();
   cliente.setNome(clienteAlterado.getNome());
   cliente.setDataNascimento(clienteAlterado.getDataNascimento());
   cliente.setCpf(clienteAlterado.getCpf());
   cliente.setFoneCelular(clienteAlterado.getFoneCelular());
   cliente.setFoneFixo(clienteAlterado.getFoneFixo());
     
   super.preencherCamposAuditoria(cliente);
   clienteRepository.save(cliente);
   
}

@Transactional
   public void delete(Long id) {

       Cliente cliente = clienteRepository.findById(id).get();
       cliente.setHabilitado(Boolean.FALSE);
       super.preencherCamposAuditoria(cliente);

       clienteRepository.save(cliente);
   }


}
