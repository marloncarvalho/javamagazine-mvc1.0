package br.com.devmedia.javamagazine.controller;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.oracle.ozark.core.Models;

import br.com.devmedia.javamagazine.model.Produto;

@Path("produtos")
public class ProdutoController {

	@Inject
	private Models models;

	@Controller
	@GET
	public String listar() {
		models.put("produtos", Produto.listar());
		return "/WEB-INF/jsp/listar.jsp";
	}

	@Path("novo")
	@Controller
	@GET
	public String cadastro() {
		return "/WEB-INF/jsp/editar.jsp";
	}

	@Path("novo")
	@Controller
	@POST
	public String incluir(@BeanParam Produto produto) {
		Produto.adicionar(produto);
		models.put("produtos", Produto.listar());
		return "/WEB-INF/jsp/listar.jsp";
	}

	@Path("{codigo}")
	@Controller
	@GET
	public String preEditar(@PathParam("codigo") String codigo) {
		models.put("produto", Produto.obter(codigo));
		return "/WEB-INF/jsp/editar.jsp";
	}

	@Path("{codigo}")
	@Controller
	@POST
	public String editar(@PathParam("codigo") String codigo, @BeanParam Produto produto) {
		Produto.editar(produto);
		models.put("produtos", Produto.listar());
		return "/WEB-INF/jsp/listar.jsp";
	}

}
