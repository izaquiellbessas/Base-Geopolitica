package br.com.b3s.geopolitica.views;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.MultiSortPriority;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import br.com.b3s.geopolitica.model.Estados;
import br.com.b3s.geopolitica.services.EstadosService;

@Route(value = "/browser-estados", layout = MainView.class)
public class BrowserEstados extends Div {

	private static final long serialVersionUID = -2533416478914498464L;
	
	@Autowired
	private final EstadosService service;
	
	public BrowserEstados(EstadosService es) {
		this.service = es;
		this.setSizeFull();
		
		Grid<Estados> grid = new Grid<>(Estados.class, false);
		grid.setSizeFull();
		grid.setMultiSort(true, MultiSortPriority.APPEND);
		grid.setPageSize(50);
		
		grid.addColumn(Estados::getNome).setHeader("Estado")
			.setSortable(true).setAutoWidth(true).setResizable(true);
		grid.addColumn(Estados::getSigla).setHeader("Sigla / UF")
			.setSortable(true).setAutoWidth(true).setResizable(true);
		grid.addColumn(estado -> (estado.getPais() == null ? "" : estado.getPais().getNome())).setHeader("País")
			.setSortable(true).setAutoWidth(true).setResizable(true);
		grid.addColumn(estado -> (estado.getRegioes() == null ? "" : estado.getRegioes().getNome().concat(" - ".concat(estado.getRegioes().getSigla()))))
			.setHeader("Região").setAutoWidth(true).setResizable(true).setSortable(true);
		
		grid.setItems(service.findAll());
		
		add(grid);
	}
	
}
