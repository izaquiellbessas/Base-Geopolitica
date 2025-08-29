package br.com.b3s.geopolitica.views;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.grid.Grid.MultiSortPriority;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

import br.com.b3s.geopolitica.model.Paises;
import br.com.b3s.geopolitica.model.PaisesBandeiras;
import br.com.b3s.geopolitica.services.PaisesBandeirasService;
import br.com.b3s.geopolitica.services.PaisesService;

@Route(value = "/browser-paises", layout = MainView.class)
public class BrowserPaises extends Div {

	private static final long serialVersionUID = 2583667194299735860L;
	private final PaisesService servicePais;
	private final PaisesBandeirasService serviceBandeiras;
	
	private ListBox<PaisesBandeiras> listaBandeiras = new ListBox<PaisesBandeiras>();
	private Grid<Paises> grid = new Grid<>(Paises.class, false);
	private Div hint;
	
	public BrowserPaises(PaisesService ps, PaisesBandeirasService pbs) {
		this.servicePais = ps;
		this.serviceBandeiras = pbs;
		this.setSizeFull();
		
		this.setupGrid();
		this.refreshGrid();
		this.searchBar();
	}
	
	private void setupGrid() {
		grid.setSizeFull();
		grid.setMultiSort(true, MultiSortPriority.APPEND);
        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
		grid.setPageSize(50);
		
		grid.addColumn(Paises::getNome).setHeader("País").setSortable(true);
		grid.addColumn(Paises::getIsoAlpha3).setHeader("ISO Alpha 3").setSortable(true);
		grid.addColumn(Paises::getIsoAlpha2).setHeader("ISO Alpha 2").setSortable(true);
		grid.addColumn(Paises::getIsoNumero).setHeader("ISO Número").setSortable(true);
		grid.addColumn(
                new ComponentRenderer<>(Button::new, (edit, pais) -> {
                	edit.addThemeVariants(ButtonVariant.LUMO_ICON,
                            ButtonVariant.LUMO_PRIMARY);
                	edit.addClickListener(e -> this.paisForm(pais));
                	edit.setIcon(new Icon(VaadinIcon.EDIT));
                })).setHeader("Editar");
		grid.addColumn(
				new ComponentRenderer<>(Button::new, (remove, pais) -> {
					remove.addThemeVariants(ButtonVariant.LUMO_ICON, ButtonVariant.LUMO_PRIMARY,
							ButtonVariant.LUMO_ERROR);
					remove.addClickListener(e -> this.deleteForm(pais));
					remove.setIcon(new Icon(VaadinIcon.TRASH));
				})).setHeader("Remover");
		
		grid.setItems(servicePais.findAll());
		
		hint = new Div();
        hint.setText("Sem informações disponíveis para exibição");
        hint.getStyle().set("padding", "var(--lumo-size-l)")
                .set("text-align", "center").set("font-style", "italic")
                .set("color", "var(--lumo-contrast-70pct)");
		
		add(hint, grid);
	}
	
	private void searchBar() {
		GridListDataView<Paises> gridView = grid.getListDataView();
		TextField searchField = new TextField();
        searchField.setWidth("50%");
        searchField.setPlaceholder("Pesquisar e filtrar");
        searchField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
        searchField.setValueChangeMode(ValueChangeMode.EAGER);
        searchField.addValueChangeListener(e -> gridView.refreshAll());

        gridView.addFilter(pais -> {
            String searchTerm = searchField.getValue().trim();

            if (searchTerm.isEmpty())
                return true;

            return matchesTerm(pais.toString(),searchTerm);
        });
        
        Div div = new Div();
        div.setWidthFull();
        
        Button novo = new Button("Adicionar novo");
        novo.setIcon(new Icon(VaadinIcon.FILE_ADD));
        novo.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ICON);
        novo.addClickListener(e -> {
        	this.paisForm(new Paises());
        	this.refreshGrid();
        });
        
        div.add(searchField, novo);
        
        VerticalLayout layout = new VerticalLayout(div, grid);
        layout.setPadding(false);
        layout.setSizeFull();
        add(layout);
	}
	
	private boolean matchesTerm(String value, String searchTerm) {
        boolean resultado = true;
        
    	String searchTerms[] = searchTerm.split(";");
        for (String string : searchTerms) {
			resultado = value.toLowerCase().contains(string.toLowerCase());
			if (!resultado)
				return resultado;
		}
    
    	return resultado;
    }
	
	private void refreshGrid() {
        if (servicePais.findAll().size() > 0) {
            grid.setVisible(true);
            hint.setVisible(false);
            grid.setItems(servicePais.findAll());
            grid.getDataProvider().refreshAll();
        } else {
            grid.setVisible(false);
            hint.setVisible(true);
        }
    }
	
	private void paisForm(Paises pais) {
		Dialog dialog = new Dialog();
		if (pais.getNome() == null) {
			dialog.setHeaderTitle("Adicionando um novo país.");
		} else {
			dialog.setHeaderTitle("Editando o país: ".concat(pais.getNome()));
		}
		
		Binder<Paises> binder = new Binder<Paises>(Paises.class);
		
        TextField nomePais = new TextField("Nome do País");
        TextField isoAlpha2 = new TextField("ISO Alpha 2");
        TextField isoAlpha3 = new TextField("ISO Alpha 3");
        TextField isoNumero = new TextField("ISO Número");
        
        binder.setBean(pais);
        binder.forField(nomePais).bind(Paises::getNome, Paises::setNome);
        binder.forField(isoAlpha2).bind(Paises::getIsoAlpha2, Paises::setIsoAlpha2);
        binder.forField(isoAlpha3).bind(Paises::getIsoAlpha3, Paises::setIsoAlpha3);
        binder.forField(isoNumero).bind(Paises::getIsoNumero, Paises::setIsoNumero);

        ListBox<PaisesBandeiras> bandeiras = listBandeiras(pais);
        
        FormLayout dialogLayout = new FormLayout(nomePais, isoAlpha2, isoAlpha3, isoNumero, createDivUpload(pais), bandeiras);
        dialogLayout.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("500px", 2));
        dialogLayout.setColspan(nomePais, 2);
        dialogLayout.setColspan(bandeiras, 2);
        
        dialog.add(dialogLayout);
        Button saveButton = createSaveButton(dialog, pais, binder, servicePais);
        Button cancelButton = new Button("Cancelar", e -> dialog.close());
        dialog.getFooter().add(cancelButton);
        dialog.getFooter().add(saveButton);
        
        dialog.open();
    }
	
	private Button createSaveButton(Dialog dialog, Paises pais, Binder<Paises> binder, PaisesService ps) {
        Button saveButton = new Button("Salvar", e -> dialog.close());
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        
        try {
			binder.writeBean(pais);
			saveButton.addClickListener(e -> {
				ps.save(pais);
				refreshGrid();
        	});
		} catch (ValidationException e1) {
			e1.printStackTrace();
		}
        
        return saveButton;
    }
    
    private void deleteForm(Paises pais) {
    	Dialog dialog = new Dialog();

        dialog.setHeaderTitle("Você confirma a exclusão do país ".concat(pais.getNome()).concat(" ?"));
        dialog.add("A exclusão é permanente. Tem certeza que deseja seguir com o procedimento?");

        Button deleteButton = createRemoveButton(dialog, pais, servicePais);
        Button cancelButton = new Button("Voltar", (e) -> dialog.close());
        cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        dialog.getFooter().add(deleteButton);
        dialog.getFooter().add(cancelButton);

        dialog.open();
        
        add(dialog);
    }
    
    private Button createRemoveButton(Dialog dialog, Paises pais, PaisesService ps) {
        Button removeButton = new Button("Remover", e -> dialog.close());
        removeButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        removeButton.getStyle().set("margin-right", "auto");
        
		removeButton.addClickListener(e -> {
			ps.remove(pais);
			refreshGrid();
    	});
        
        return removeButton;
    }
	
	private Div createDivUpload(Paises pais) {
		PaisesBandeiras bandeira = new PaisesBandeiras();
		
		MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
        Upload uploadBandeira = new Upload(buffer);
        uploadBandeira.setDropAllowed(true);
        uploadBandeira.setAcceptedFileTypes("image/png", "image/jpg", "image/jpeg");
        
        uploadBandeira.addSucceededListener(event -> {
            try {
                BufferedImage buffImage = ImageIO.read(buffer.getInputStream(event.getFileName()));
                ByteArrayOutputStream bytesArray = new ByteArrayOutputStream();
                String extFile = event.getMIMEType().substring(event.getMIMEType().lastIndexOf("/")+1, event.getMIMEType().length());
                ImageIO.write(buffImage, extFile, bytesArray);
                                
                bandeira.setImagem(bytesArray.toByteArray());
                bandeira.setImagemNome(event.getFileName());
                bandeira.setImagemMimeType(event.getMIMEType());
                bandeira.setPais(pais);
                bandeira.setDescricao("Bandeira: ".concat(pais.getNome()));
               
                this.serviceBandeiras.save(bandeira);
        		this.listaBandeiras.setItems(this.serviceBandeiras.retornarTodasDoPais(pais.getIsoAlpha3()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        Button buttonUp = new Button("Enviar uma bandeira");
        buttonUp.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonUp.setIcon(new Icon(VaadinIcon.UPLOAD));
        Span dropLabel = new Span("Enviar uma bandeira");
        Icon dropIcon = new Icon(VaadinIcon.UPLOAD);
        
        uploadBandeira.setDropLabelIcon(dropIcon);
        uploadBandeira.setDropLabel(dropLabel);
        uploadBandeira.setUploadButton(buttonUp);
        
        Div divUploadBandeira = new Div();
        divUploadBandeira.add(uploadBandeira);
        
        return divUploadBandeira;
	}
	
	private ListBox<PaisesBandeiras> listBandeiras(Paises pais) {
		listaBandeiras.setItems(this.serviceBandeiras.retornarTodasDoPais(pais.getIsoAlpha3()));
		listaBandeiras.setRenderer(new ComponentRenderer<HorizontalLayout, PaisesBandeiras>(bandeira -> {
			HorizontalLayout row = new HorizontalLayout();
            
            Image imagem_bandeira = generateImage(bandeira);
            if (imagem_bandeira != null) {
            	imagem_bandeira.setHeight("100%");
            }
            Span descricao = new Span(bandeira.getDescricao());
            
            Button removeBandeira = new Button("Remover");
            removeBandeira.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
            removeBandeira.setIcon(new Icon(VaadinIcon.TRASH));
            removeBandeira.addClickListener(e -> {
            	serviceBandeiras.remove(bandeira);
            	listaBandeiras.setItems(this.serviceBandeiras.retornarTodasDoPais(pais.getIsoAlpha3()));
            });

            VerticalLayout column = new VerticalLayout(descricao);
            column.setPadding(false);
            column.setSpacing(false);

            row.add(imagem_bandeira, column, removeBandeira);
            row.getStyle().set("line-height", "var(--lumo-line-height-m)");
            return row;
		}));
		
		return listaBandeiras;
	}
	
	private Image generateImage(PaisesBandeiras imagem_bandeira) {
	    StreamResource sr = new StreamResource("imagem_bandeira", () ->  {
				return new ByteArrayInputStream(imagem_bandeira.getImagem());
	    });
	    sr.setContentType(imagem_bandeira.getImagemMimeType());
	    Image image = new Image(sr, "flag-of-country");
	    return image;
	}
	
}
