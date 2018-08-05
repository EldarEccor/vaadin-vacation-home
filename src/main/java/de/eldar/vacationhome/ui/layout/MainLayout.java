package de.eldar.vacationhome.ui.layout;

import java.util.Objects;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.cookieconsent.CookieConsent;
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
/**
 * I am 99% certain this will be moved to a template but let's see what we will learn :D
 * 
 *
 */
public class MainLayout extends Div  implements RouterLayout{

	private static final String HERO_TEXT_CSS_CLASS = "hero-text";

	private static final String HERO_IMAGE_CSS_CLASS = "hero-image";

	private static final String HERO_CSS_CLASS = "hero";

	private static final String FOOTER_CSS_CLASS = "footer";

	private static final String FOOTER_NAME_CSS_CLASS = "footer-name";

	private static final String CONTENT_CSS_CLASS = "content";

	private static final String NAVIGATION_CSS_CLASS = "header_navigation";

	private static final String HEADER_CSS_CLASS = "header";

	private static final String NAV_ITEM_CSS_CLASS = "header_nav-item";

	private static final String MAIN_CSS_CLASS = "main-layout";

	private static final long serialVersionUID = 661089314620602587L;

	private Div headerContainer;

	private Div heroContainer;
	
	private Div contentContainer;
	
	private Div footerContainer;
	
	public MainLayout() {
		addClassName(MAIN_CSS_CLASS);
		createHeaderContainer();
		createHeroContainer();
		createContentContainerWithFooter();		
		add(new CookieConsent(),headerContainer,heroContainer,contentContainer);
	}

	private void createContentContainerWithFooter() {
		contentContainer = new Div();
		contentContainer.setClassName(CONTENT_CSS_CLASS);
		
		Paragraph footerName = new Paragraph("Vaadin vacation home \u00A9 2018");
		footerName.setClassName(FOOTER_NAME_CSS_CLASS);

		Anchor scrollUP = new Anchor();
		scrollUP.setTarget("_top");
		scrollUP.setText("Back to the top!");
		scrollUP.setHref("#");
		
		footerContainer = new Div(scrollUP,footerName);
		footerContainer.setClassName(FOOTER_CSS_CLASS);
		contentContainer.add(footerContainer);
	}

	private void createHeroContainer() {
		heroContainer = new Div();
		heroContainer.setClassName(HERO_CSS_CLASS);
		
		Div heroImageContainer = new Div();
		heroImageContainer.setClassName(HERO_IMAGE_CSS_CLASS);
		Div heroTextContainer = new Div();
		heroTextContainer.setClassName(HERO_TEXT_CSS_CLASS);		
		heroTextContainer.add(new H1("Vaadin vacation home overlay text"));
		heroContainer.add(heroImageContainer,heroTextContainer);
	}

	private void createHeaderContainer() {
		Div navigationContainer = createNavigationContainer();
		headerContainer = new Div();
		headerContainer.setClassName(HEADER_CSS_CLASS);	
		headerContainer.add(navigationContainer);
	}

	private Div createNavigationContainer() {
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
		
        Div navigationContainer = new Div(guestBookLink,bookingLink,galleryLink,aboutLink);
		navigationContainer.setClassName(NAVIGATION_CSS_CLASS);
		return navigationContainer;
	}	

	@Override
	public void showRouterLayoutContent(HasElement content) {
		if (content != null) {
			this.contentContainer.removeAll();
			this.contentContainer.add(Objects.requireNonNull((Component)content));
			this.contentContainer.add(footerContainer);
		}		
	}
}
