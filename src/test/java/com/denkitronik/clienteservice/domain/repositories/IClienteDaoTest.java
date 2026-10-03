package com.denkitronik.clienteservice.domain.repositories;

import com.denkitronik.clienteservice.domain.entities.Cliente;
import com.denkitronik.clienteservice.domain.entities.Region;
import com.denkitronik.clienteservice.domain.repositories.IClienteDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("Integration tests (data slice)")
class IClienteDaoTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private IClienteDao clienteDao;

    private Region region;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        region = new Region();
        region.setNombre("Asia");
        em.persist(region);

        cliente = new Cliente();
        cliente.setNombre("Grace");
        cliente.setApellido("Hopper");
        cliente.setEmail("grace@navy.mil");
        cliente.setRegion(region);
        em.persist(cliente);
        em.flush();
    }

    @Test
    @DisplayName("findById encuentra el cliente")
    void findById_ok() {
        Optional<Cliente> resultado = clienteDao.findById(cliente.getId());
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNombre()).isEqualTo("Grace");
    }

    @Test
    @DisplayName("deleteById elimina el cliente")
    void deleteById_ok() {
        Long id = cliente.getId();
        clienteDao.deleteById(id);
        em.flush();
        assertThat(em.find(Cliente.class, id)).isNull();
    }
}