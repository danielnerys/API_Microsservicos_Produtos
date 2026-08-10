package io.github.danielnerys.icompras.clientes.controller;

import io.github.danielnerys.icompras.clientes.model.Cliente;
import io.github.danielnerys.icompras.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
        clienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @RequestMapping("{codigo}")
    public ResponseEntity<Cliente> obterDados(@PathVariable Long codigo){
        return clienteService.obterPorCodigo(codigo).map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }



}
