package com.as.gerenciamento_produtos.services;

import com.as.gerenciamento_produtos.models.ProdutoModel;
import com.as.gerenciamento_produtos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> listar() {
        return produtoRepository.findAll();
    }

    public ProdutoModel criar(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public Optional<ProdutoModel> buscarId(Long id) {
        return produtoRepository.findById(id);
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoModel) {
        ProdutoModel model = produtoRepository.findById(id).get();
        model.setNome(produtoModel.getNome());
        model.setPreco(produtoModel.getPreco());
        model.setEstoque(produtoModel.getEstoque());
        return produtoRepository.save(model);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
