package br.com.b3s.geopolitica.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle(value = "Home")
@Route(value = "/geopolitica")
public class MainView extends AppLayout{

	private static final long serialVersionUID = -238262402673508450L;

	public MainView() {
		H1 appTitle = new H1("Geopolítica");
        appTitle.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("line-height", "var(--lumo-size-l)")
                .set("margin", "0 var(--lumo-space-m)");

        DrawerToggle toggle = new DrawerToggle();
        SideNav nav = getSideNavigation();

        Scroller scroller = new Scroller(nav);
        scroller.setClassName(LumoUtility.Padding.SMALL);
        
        addToDrawer(scroller);
        addToNavbar(toggle, appTitle);

        setPrimarySection(Section.DRAWER);
    }

    private SideNav getSideNavigation() {
            SideNav sideNav = new SideNav();
            sideNav.addItem(new SideNavItem("Países", "/browser-paises", VaadinIcon.MAP_MARKER.create()),
                            new SideNavItem("Regiões", "/browser-regioes", VaadinIcon.MAP_MARKER.create()),
                            new SideNavItem("Estados", "/browser-estados", VaadinIcon.MAP_MARKER.create()),
                            new SideNavItem("Municípios", "/browser-municipios", VaadinIcon.MAP_MARKER.create()),
                            new SideNavItem("Indicadores", "/indicadores", VaadinIcon.CHART_LINE.create())
                            );
            return sideNav;
    }


}