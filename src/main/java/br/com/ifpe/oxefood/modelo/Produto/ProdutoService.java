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

    @Transactional
        public void update(Long id, Produto produtoAlterado) {

        Produto produto = produtoRepository.findById(id).get();
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());
        produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());

        super.preencherCamposAuditoria(produto);
        produtoRepository.save(produto);
    }
 
    @Transactional
   public void delete(Long id) {

    Produto produto = produtoRepository.findById(id).get();
    produto.setHabilitado(Boolean.FALSE);
       super.preencherCamposAuditoria(produto);

       produtoRepository.save(produto);
   }

    public Produto obterPorID(Long id) {
    
        return produtoRepository.findById(id).get();
    }
}
