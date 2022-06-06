package com.matheushenrique.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheushenrique.cursomc.dao.CategoriaDAO;
import com.matheushenrique.cursomc.dao.CidadeDAO;
import com.matheushenrique.cursomc.dao.ClienteDAO;
import com.matheushenrique.cursomc.dao.EnderecoDAO;
import com.matheushenrique.cursomc.dao.EstadoDAO;
import com.matheushenrique.cursomc.dao.PagamentoDAO;
import com.matheushenrique.cursomc.dao.PedidoDAO;
import com.matheushenrique.cursomc.dao.ProdutoDAO;
import com.matheushenrique.cursomc.domain.Categoria;
import com.matheushenrique.cursomc.domain.Cidade;
import com.matheushenrique.cursomc.domain.Cliente;
import com.matheushenrique.cursomc.domain.Endereco;
import com.matheushenrique.cursomc.domain.Estado;
import com.matheushenrique.cursomc.domain.Pagamento;
import com.matheushenrique.cursomc.domain.PagamentoComBoleto;
import com.matheushenrique.cursomc.domain.PagamentoComCartao;
import com.matheushenrique.cursomc.domain.Pedido;
import com.matheushenrique.cursomc.domain.Produto;
import com.matheushenrique.cursomc.domain.enums.EstadoPagamento;
import com.matheushenrique.cursomc.domain.enums.TipoCliente;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private EstadoDAO estadoDAO;
	
	@Autowired
	private CidadeDAO cidadeDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private EnderecoDAO enderecoDAO;
	
	@Autowired
	private PedidoDAO pedidoDAO;
	
	@Autowired
	private PagamentoDAO pagamentoDAO;
	

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaDAO.saveAll(Arrays.asList(cat1, cat2));
		produtoDAO.saveAll(Arrays.asList(p1, p2, p3));
		
		
		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");
		Cidade cidade1 = new Cidade(null, "Uberlândia", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "Campinas", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		estadoDAO.saveAll(Arrays.asList(estado1, estado2));
		cidadeDAO.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
		
		Cliente cliente1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cliente1.getTelefone().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cliente1, cidade1);
		Endereco endereco2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "3877012", cliente1, cidade2);
		
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
		
		clienteDAO.saveAll(Arrays.asList(cliente1));
		enderecoDAO.saveAll(Arrays.asList(endereco1, endereco2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
		
		
		Pedido pedido1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cliente1, endereco1);
		Pedido pedido2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cliente1, endereco2);	
		
		Pagamento pagamento1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
		pedido1.setPagamento(pagamento1);
		
		Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2, sdf.parse("20/10/2017 00:00"), null);
		pedido2.setPagamento(pagamento2);
		
		cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		
		pedidoDAO.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoDAO.saveAll(Arrays.asList(pagamento1, pagamento2));
		
	}

}
