package br.com.ifpe.oxefood.modelo.Produto;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class ProdutoService extends GenericService{
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Transactional
    public Produto save(Produto produto) {
 
        super.preencherCamposAuditoria(produto);
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
  
        return produtoRepository.findAll();
    }
    
    public Produto obterPorID(Long id) {
    
        return produtoRepository.findById(id).get();
    }
}
