package de.eldar.vacationhome.ui.layout;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.templatemodel.TemplateModel;

import de.eldar.vacationhome.ui.layout.MainLayout.MainLayoutModel;
import de.eldar.vacationhome.ui.route.GuestbookRoute;
import de.eldar.vacationhome.ui.route.WelcomeRoute;
@HtmlImport("frontend://src/views/main-layout.html")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@Tag("main-layout")
public class MainLayout extends PolymerTemplate<MainLayoutModel>  implements RouterLayout{

	private static final String NAV_ITEM_CSS_CLASS = "header_nav-item";

	private static final long serialVersionUID = 661089314620602587L;
	
	@Id("navigationContainer")
	private Div navigationContainer;
	
	@Id("contentContainer")
	private Div contentContainer;
	
	public interface MainLayoutModel extends TemplateModel {		
		void setHeroText(String text);		
	}
	
	public MainLayout() {
		initNavigationContainer();
		getModel().setHeroText("Vaadin vacation home hero text.");
	}

	private Div initNavigationContainer() {
		RouterLink guestBookLink = new RouterLink(null, GuestbookRoute.class);
		guestBookLink.add(new Icon(VaadinIcon.LIST), new Text("Guestbook"));
		guestBookLink.addClassName(NAV_ITEM_CSS_CLASS);
        
        RouterLink bookingLink = new RouterLink(null, WelcomeRoute.class);
        bookingLink.add(new Icon(VaadinIcon.BOOK), new Text("Booking"));
        bookingLink.addClassName(NAV_ITEM_CSS_CLASS);
	
        RouterLink galleryLink = new RouterLink(null, WelcomeRoute.class);
        galleryLink.add(new Icon(VaadinIcon.PICTURE), new Text("Gallery"));
        galleryLink.addClassName(NAV_ITEM_CSS_CLASS);
        
        RouterLink aboutLink = new RouterLink(null, WelcomeRoute.class);
        aboutLink.add(new Icon(VaadinIcon.QUESTION), new Text("About"));
        aboutLink.addClassName(NAV_ITEM_CSS_CLASS);
		
        navigationContainer.add(guestBookLink,bookingLink,galleryLink,aboutLink);
		return navigationContainer;
	}
	
	@Override
	public void showRouterLayoutContent(HasElement content) {	
		contentContainer.getElement().appendChild(content.getElement());
	}
}
