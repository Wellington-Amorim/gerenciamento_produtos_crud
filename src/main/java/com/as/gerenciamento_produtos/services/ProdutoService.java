package com.as.gerenciamento_produtos.services;

import com.as.gerenciamento_produtos.models.ProdutoModel;
import com.as.gerenciamento_produtos.exceptions.RecursoNaoEncontradoException;
import com.as.gerenciamento_produtos.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoModel> listar() {
        return produtoRepository.findAll();
    }

    public ProdutoModel criar(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public ProdutoModel buscarId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com id: " + id));
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoModel) {
        ProdutoModel model = buscarId(id);
        model.setNome(produtoModel.getNome());
        model.setPreco(produtoModel.getPreco());
        model.setEstoque(produtoModel.getEstoque());
        return produtoRepository.save(model);
    }

    public void deletar(Long id) {
        buscarId(id);
        produtoRepository.deleteById(id);
    }
}
