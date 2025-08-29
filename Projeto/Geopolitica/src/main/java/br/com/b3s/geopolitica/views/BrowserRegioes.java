package br.com.b3s.geopolitica.views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.MultiSortPriority;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import br.com.b3s.geopolitica.model.Microrregioes;
import br.com.b3s.geopolitica.services.MicrorregioesService;

@Route(value = "browser-regioes", layout = MainView.class)
public class BrowserRegioes extends Div {

	private static final long serialVersionUID = -5296616507277776013L;
	private MicrorregioesService service;
	
	public BrowserRegioes(MicrorregioesService ms) {
		this.service = ms;
		this.setSizeFull();
		
		Grid<Microrregioes> grid = new Grid<Microrregioes>();
		grid.setSizeFull();
		grid.setMultiSort(true, MultiSortPriority.APPEND);
		grid.setPageSize(50);
		
		grid.addColumn(micro -> micro.getEstado().getRegioes().getNome()).setAutoWidth(true).setHeader("Região").setSortable(true);
		grid.addColumn(micro -> micro.getEstado().getNome()).setAutoWidth(true).setHeader("Estado").setSortable(true);
		grid.addColumn(micro -> micro.getMesorregiao().getNome()).setAutoWidth(true).setHeader("Mesorregião").setSortable(true);
		grid.addColumn(Microrregioes::getNome).setAutoWidth(true).setHeader("Microrregião").setSortable(true);
		
		grid.setItems(service.findAll());
		
		add(grid);
	}
	
	
}
