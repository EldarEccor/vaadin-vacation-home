package de.eldar.vacationhome.ui.layout;

import java.util.Objects;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

import de.eldar.vacationhome.ui.route.GuestbookRoute;
import de.eldar.vacationhome.ui.route.WelcomeRoute;
@HtmlImport("frontend://styles/shared-styles.html")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
public class MainLayout extends Div  implements RouterLayout{

	private static final long serialVersionUID = 661089314620602587L;

	private Div headerContainer;

	private Div heroContainer;
	
	private Div contentContainer;
	
	private Div footerContainer;
	
	public MainLayout() {
		
		RouterLink guestBookLink = new RouterLink(null, GuestbookRoute.class);
		guestBookLink.add(new Icon(VaadinIcon.LIST), new Text("Guestbook"));
		guestBookLink.addClassName("header_nav-item");
        
        RouterLink bookingLink = new RouterLink(null, WelcomeRoute.class);
        bookingLink.add(new Icon(VaadinIcon.BOOK), new Text("Booking"));
        bookingLink.addClassName("header_nav-item");
	
        RouterLink galleryLink = new RouterLink(null, WelcomeRoute.class);
        galleryLink.add(new Icon(VaadinIcon.PICTURE), new Text("Gallery"));
        galleryLink.addClassName("header_nav-item");
        
        RouterLink aboutLink = new RouterLink(null, WelcomeRoute.class);
        aboutLink.add(new Icon(VaadinIcon.QUESTION), new Text("About"));
        aboutLink.addClassName("header_nav-item");
		
        Div navigationContainer = new Div(guestBookLink,bookingLink,galleryLink,aboutLink);
		navigationContainer.setClassName("header_navigation");
        
		
		heroContainer = new Div();
		heroContainer.setClassName("hero-image");
		Div heroTextContainer = new Div();
		heroTextContainer.setClassName("hero-text");		
		heroTextContainer.add(new H1("Vaadin vacation home overlay text"));
		heroContainer.add(heroTextContainer);
		
		headerContainer = new Div();
		headerContainer.setClassName("header");	
		headerContainer.add(navigationContainer);
		
		contentContainer = new Div();
		contentContainer.setClassName("content");
		
		Paragraph footerName = new Paragraph("Vaadin vacation home \u00A9 2018");
		footerName.setClassName("footer-name");

		Anchor scrollUP = new Anchor();
		scrollUP.setTarget("_top");
		scrollUP.setText("Back to the top!");
		scrollUP.setHref("#");
		
		footerContainer = new Div(scrollUP,footerName);
		footerContainer.setClassName("footer");		
		add(headerContainer,heroContainer,contentContainer,footerContainer);
		setClassName("main-layout");
	}	

	@Override
	public void showRouterLayoutContent(HasElement content) {
		if (content != null) {
			this.contentContainer.removeAll();
			this.contentContainer.add(Objects.requireNonNull((Component)content));
		}
	}
}
