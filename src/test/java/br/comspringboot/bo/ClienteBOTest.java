package br.comspringboot.bo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.comspringboot.model.Cliente;
import br.comspringboot.model.Sexo;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)


public class ClienteBOTest {

	
   @Autowired
   private ClienteBO bo;
   
   @Test
   @Order(1)
   
   public void insere() {
	   Cliente cliente = new Cliente();
	   cliente.setName("José da Silva");
	   cliente.setCpf("1234567892");
	   cliente.setDataDeNascimento(LocalDate.of(2000, 1, 8));
	   cliente.setSexo(Sexo.MASCULINO);
	   cliente.setTelefone("123456797");
	   cliente.setTelefone("1234567812");
	   cliente.setAtivo(true);
	   cliente.setEmail("larissa@gmail.com");
	   bo.insere(cliente);

	   assertThat(cliente.getSexo()).isEqualTo(Sexo.MASCULINO);
   }
   
   @Test
   @Order(2)
   public void pesquisaPeloId() {
	   Cliente cliente = bo.pesquisaPeloId(1L);
	   System.out.println(cliente);
   }
   
   @Test
   @Order(3)
   public void atualiza() {
	   Cliente cliente = bo.pesquisaPeloId(1L);
	   cliente.setCpf("2547896315");
	   bo.atualiza(cliente);
	   
	   
   }
   
}
	