package br.com.devmedia.javamagazine.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;

public class Produto {

	@FormParam("codigo")
	private String codigo;

	@FormParam("nome")
	private String nome;

	@FormParam("preco")
	private Double preco;

	@FormParam("descricao")
	private String descricao;
	private static List<Produto> lista = new ArrayList<Produto>();

	static {
		lista.add(new Produto("C1", "Cerveja de Trigo", 6.50, "Cerveja de Trigo"));
		lista.add(new Produto("C2", "Cerveja Pilsen", 4.50, "Cerveja Pilsen"));
		lista.add(new Produto("C3", "Cerveja Stout", 16.50, "Cerveja Stout"));
		lista.add(new Produto("C4", "Cerveja IPA", 12.50, "Cerveja IPA"));
	}

	public Produto() {
	}

	public Produto(String codigo, String nome, Double preco, String descricao) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}

	public static List<Produto> listar() {
		return lista;
	}

	public static Produto obter(String codigo) {
		Produto result = null;

		for (Produto produto : lista) {
			if (produto.codigo.equals(codigo)) {
				result = produto;
				break;
			}
		}

		return result;
	}

	public static void editar(Produto produto) {
		Produto e = obter(produto.codigo);
		e.codigo = produto.codigo;
		e.descricao = produto.descricao;
		e.nome = produto.nome;
		e.preco = produto.preco;
	}

	public static void adicionar(Produto produto) {
		lista.add(produto);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
