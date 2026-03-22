package com.as.gerenciamento_produtos.controllers;

import com.as.gerenciamento_produtos.models.ProdutoModel;
import com.as.gerenciamento_produtos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> criar(@RequestBody ProdutoModel produtoModel){
        ProdutoModel produto = produtoService.criar(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(produtoModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listar() {
        List<ProdutoModel> produtos = produtoService.listar();
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> buscarId(@PathVariable Long id) {
        return produtoService.buscarId(id);
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizar(@PathVariable Long id, @RequestBody ProdutoModel produtoModel) {
        return produtoService.atualizar(id, produtoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
