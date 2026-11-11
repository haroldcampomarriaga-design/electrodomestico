package com.uniremington.electrodomesticos.controller.mvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.uniremington.electrodomesticos.model.dao.ClienteDAO;
import com.uniremington.electrodomesticos.model.vo.ClienteVO;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class ClienteMvcControllerTest {

    private ClienteDAO clienteDAO;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        clienteDAO = Mockito.mock(ClienteDAO.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new ClienteMvcController(clienteDAO)).build();
    }

    @Test
    void listShowsTheCrudViewAndClientData() throws Exception {
        ClienteVO cliente = cliente(1, "Ana");
        when(clienteDAO.findAll()).thenReturn(List.of(cliente));

        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andExpect(view().name("crud/list"))
                .andExpect(model().attribute("title", "Clientes"))
                .andExpect(model().attribute("basePath", "/clientes"))
                .andExpect(model().attributeExists("columns", "rows"));

        verify(clienteDAO).findAll();
    }

    @Test
    void createFormShowsTheSharedFormView() throws Exception {
        mockMvc.perform(get("/clientes/nuevo"))
                .andExpect(status().isOk())
                .andExpect(view().name("crud/form"))
                .andExpect(model().attribute("action", "/clientes"))
                .andExpect(model().attributeExists("fields"));
    }

    @Test
    void createSavesTheSubmittedClientAndRedirects() throws Exception {
        mockMvc.perform(post("/clientes")
                        .param("nombre", "Ana")
                        .param("numeroDocumento", "123"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/clientes"));

        ArgumentCaptor<ClienteVO> cliente = ArgumentCaptor.forClass(ClienteVO.class);
        verify(clienteDAO).save(cliente.capture());
        assertEquals("Ana", cliente.getValue().getNombre());
        assertEquals("123", cliente.getValue().getNumeroDocumento());
    }

    @Test
    void editFormLoadsExistingClient() throws Exception {
        when(clienteDAO.findById(1)).thenReturn(Optional.of(cliente(1, "Ana")));

        mockMvc.perform(get("/clientes/1/editar"))
                .andExpect(status().isOk())
                .andExpect(view().name("crud/form"))
                .andExpect(model().attribute("action", "/clientes/1"))
                .andExpect(model().attributeExists("fields"));

        verify(clienteDAO).findById(1);
    }

    @Test
    void updateChangesClientAndRedirects() throws Exception {
        when(clienteDAO.findById(1)).thenReturn(Optional.of(cliente(1, "Ana")));

        mockMvc.perform(post("/clientes/1")
                        .param("idCliente", "99")
                        .param("nombre", "Ana María"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/clientes"));

        ArgumentCaptor<ClienteVO> cliente = ArgumentCaptor.forClass(ClienteVO.class);
        verify(clienteDAO).update(cliente.capture());
        assertEquals(1, cliente.getValue().getIdCliente());
        assertEquals("Ana María", cliente.getValue().getNombre());
    }

    @Test
    void deleteRemovesClientAndRedirects() throws Exception {
        when(clienteDAO.deleteById(1)).thenReturn(true);

        mockMvc.perform(post("/clientes/1/eliminar"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/clientes"));

        verify(clienteDAO).deleteById(1);
    }

    @Test
    void editReturnsNotFoundWhenClientDoesNotExist() throws Exception {
        when(clienteDAO.findById(999)).thenReturn(Optional.empty());

        mockMvc.perform(get("/clientes/999/editar"))
                .andExpect(status().isNotFound());
    }

    private ClienteVO cliente(Integer id, String nombre) {
        ClienteVO cliente = new ClienteVO();
        cliente.setIdCliente(id);
        cliente.setNombre(nombre);
        return cliente;
    }
}
