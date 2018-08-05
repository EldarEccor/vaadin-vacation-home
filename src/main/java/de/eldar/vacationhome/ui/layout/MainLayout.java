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

//	private Div headerContainer;
//
//	private Div heroContainer;
	
	@Id("navigationContainer")
	private Div navigationContainer;
	
	@Id("contentContainer")
	private Div contentContainer;
	
	@Id("footerContainer")
	private Div footerContainer;
	
	public interface MainLayoutModel extends TemplateModel {		
		void setHeroText(String text);		
	}
	
	public MainLayout() {
//		addClassName(MAIN_CSS_CLASS);
//		createHeaderContainer();
//		createHeroContainer();
//		createContentContainerWithFooter();		
//		add(new CookieConsent(),headerContainer,heroContainer,contentContainer);
		createNavigationContainer();
		getModel().setHeroText("Vaadin vacation home hero text.");
	}
	
//	private void createContentContainerWithFooter() {
//		contentContainer = new Div();
//		contentContainer.setClassName(CONTENT_CSS_CLASS);
//		
//		Paragraph footerName = new Paragraph("Vaadin vacation home \u00A9 2018");
//		footerName.setClassName(FOOTER_NAME_CSS_CLASS);
//
//		Anchor scrollUP = new Anchor();
//		scrollUP.setTarget("_top");
//		scrollUP.setText("Back to the top!");
//		scrollUP.setHref("#");
//		
//		footerContainer = new Div(scrollUP,footerName);
//		footerContainer.setClassName(FOOTER_CSS_CLASS);
//		contentContainer.add(footerContainer);
//	}
//
//	private void createHeroContainer() {
//		heroContainer = new Div();
//		heroContainer.setClassName(HERO_CSS_CLASS);
//		
//		Div heroImageContainer = new Div();
//		heroImageContainer.setClassName(HERO_IMAGE_CSS_CLASS);
//		Div heroTextContainer = new Div();
//		heroTextContainer.setClassName(HERO_TEXT_CSS_CLASS);		
//		heroTextContainer.add(new H1("Vaadin vacation home overlay text"));
//		heroContainer.add(heroImageContainer,heroTextContainer);
//	}
//
//	private void createHeaderContainer() {
//		Div navigationContainer = createNavigationContainer();
//		headerContainer = new Div();
//		headerContainer.setClassName(HEADER_CSS_CLASS);	
//		headerContainer.add(navigationContainer);
//	}

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
		
        navigationContainer.add(guestBookLink,bookingLink,galleryLink,aboutLink);
		return navigationContainer;
	}
	
	@Override
	public void showRouterLayoutContent(HasElement content) {	
		contentContainer.getElement().appendChild(content.getElement());
	}
}
