package br.com.b3s.geopolitica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@SpringBootApplication
@Theme(themeClass = Lumo.class)
public class GeopoliticaApplication implements AppShellConfigurator {

	private static final long serialVersionUID = 6082268993251867018L;

	public static void main(String[] args) {
		SpringApplication.run(GeopoliticaApplication.class, args);
	}

}
