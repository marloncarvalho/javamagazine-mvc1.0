package br.com.devmedia.javamagazine.controller;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.View;
import javax.mvc.Viewable;
import javax.mvc.validation.ValidationResult;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.oracle.ozark.core.Models;

import br.com.devmedia.javamagazine.model.Produto;

@Path("produtos")
public class ProdutoController {

	@Inject
	private ValidationResult validationResult;

	@Inject
	private Models models;

	@Controller
	@GET
	@View("/WEB-INF/jsp/listar.jsp")
	public void listar() {
		models.put("produtos", Produto.listar());
	}

	@Path("novo")
	@Controller
	@GET
	@View("/WEB-INF/jsp/editar.jsp")
	public void cadastro() {
	}

	@Path("novo")
	@Controller
	@POST
	@ValidateOnExecution(type = ExecutableType.NONE)
	public Viewable incluir(@BeanParam @Valid Produto produto) {
		String result = "/WEB-INF/jsp/listar.jsp";

		if (validationResult.isFailed()) {
			models.put("erros", validationResult.getAllViolations());
			models.put("produto", produto);
			result = "/WEB-INF/jsp/editar.jsp";
		} else {
			Produto.adicionar(produto);
			models.put("produtos", Produto.listar());
		}

		return new Viewable(result);
	}

	@Path("{codigo}")
	@Controller
	@GET
	@View("/WEB-INF/jsp/editar.jsp")
	public void preEditar(@PathParam("codigo") String codigo) {
		models.put("produto", Produto.obter(codigo));
	}

	@Path("{codigo}")
	@Controller
	@POST
	@ValidateOnExecution(type = ExecutableType.NONE)
	public Response editar(@PathParam("codigo") String codigo, @BeanParam @Valid Produto produto) {
		String result = "/WEB-INF/jsp/listar.jsp";

		if (validationResult.isFailed()) {
			models.put("erros", validationResult.getAllViolations());
			models.put("produto", produto);
			result = "/WEB-INF/jsp/editar.jsp";
		} else {
			Produto.editar(produto);
			models.put("produtos", Produto.listar());
		}

		return Response.status(Status.OK).entity(result).build();
	}

}
