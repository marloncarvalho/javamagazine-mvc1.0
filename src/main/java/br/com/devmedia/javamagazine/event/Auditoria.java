package br.com.devmedia.javamagazine.event;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.mvc.event.ControllerMatched;
import javax.mvc.event.ViewEngineSelected;

@RequestScoped
public class Auditoria {

	public void auditar(@Observes ControllerMatched event) {
		System.out.println("Match: " + event.getResourceInfo().getResourceMethod());
	}

	public void auditar(@Observes ViewEngineSelected event) {
		System.out.println("Match: " + event.getEngine().getName());
	}

}
