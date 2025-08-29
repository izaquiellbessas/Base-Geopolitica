package br.com.b3s.geopolitica.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "/geopolitica/login")
@PageTitle(value = "Login")
public class Login extends Div {

	private static final long serialVersionUID = 7826161985026036128L;

	public Login() {
		LoginForm loginForm = new LoginForm();
        add(loginForm);
	}
	
}
