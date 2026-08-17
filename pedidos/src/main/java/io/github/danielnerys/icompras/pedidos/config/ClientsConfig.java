package io.github.danielnerys.icompras.pedidos.config;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Configurable
@EnableFeignClients(basePackages = "io.github.danielnerys.icompras.pedidos.client")
public class ClientsConfig {
}
