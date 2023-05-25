package br.com.ifpe.oxefood.modelo.comprador;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class CompradorService extends GenericService {
    
    @Autowired
   private CompradorRepository compradorRepository;
   @Transactional
   public Comprador save(Comprador Comprador) {

    super.preencherCamposAuditoria(Comprador);
    return compradorRepository.save(Comprador);
}

public List<Comprador> listarTodos() {

 return compradorRepository.findAll();
}

public Comprador obterPorID(Long id) {

 return compradorRepository.findById(id).get();
}

}
