package io.github.danielnerys.icompras.clientes.service;

import io.github.danielnerys.icompras.clientes.model.Cliente;
import io.github.danielnerys.icompras.clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> obterPorCodigo(Long codigo){
        return clienteRepository.findById(codigo);
    }

}
