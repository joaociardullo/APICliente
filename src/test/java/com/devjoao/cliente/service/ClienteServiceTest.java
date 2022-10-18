//package com.devjoao.cliente.service;
//
//import com.devjoao.cliente.domain.entity.Cliente;
//import com.devjoao.cliente.repositories.ClienteRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//import static org.mockito.Mockito.anyString;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class ClienteServiceTest {
//    @Mock
//    ClienteRepository clienteRepository;
//    @InjectMocks
//    ClienteService clienteService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testTheLoadingSave() {
//        Cliente result = clienteService.save(new Cliente(Long.valueOf(1), "nome", "foneMovel", "foneFixo", "email", "cpf", LocalDate.of(2022, Month.OCTOBER, 9)));
//        Assertions.assertEquals(new Cliente(Long.valueOf(1), "nome", "foneMovel", "foneFixo", "email", "cpf", LocalDate.of(2022, Month.OCTOBER, 9)), result);
//    }
//
//    @Test
//    void testLoadingFindAll() {
//        List<Cliente> result = clienteService.findAll();
//        Assertions.assertEquals(List.of(new Cliente(Long.valueOf(1), "nome", "foneMovel", "foneFixo", "email", "cpf", LocalDate.of(2022, Month.OCTOBER, 9))), result);
//    }
//
//    @Test
//    void testDeleteById() {
//        clienteService.deleteById(Long.valueOf(1));
//    }
//
//    @Test
//    void testLoadingFindById() throws Exception {
//        Cliente result = clienteService.findById(Long.valueOf(1));
//        Assertions.assertEquals(new Cliente(Long.valueOf(1), "nome", "foneMovel", "foneFixo", "email", "cpf", LocalDate.of(2022, Month.OCTOBER, 9)), result);
//    }
//
//    @Test
//    void testPeopleFindByEmail() throws Exception {
//        when(clienteRepository.findByEmail(anyString())).thenReturn(null);
//
//        Cliente result = clienteService.findByEmail("email");
//        Assertions.assertEquals(new Cliente(Long.valueOf(1), "nome", "foneMovel", "foneFixo", "email", "cpf", LocalDate.of(2022, Month.OCTOBER, 9)), result);
//    }
//}
