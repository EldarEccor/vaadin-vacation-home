package de.eldar.vacationhome.ui.route;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.eldar.vacationhome.ui.layout.MainLayout;

@Route(layout = MainLayout.class,value = "")
public class WelcomeRoute extends VerticalLayout{

	private static final long serialVersionUID = 3412336558939266983L;
	
	private Label welcomeLabel;
	
	private Image welcomeImage;
	
	public WelcomeRoute() {
		welcomeLabel = new Label("Welcome to our vacation home page!");
		welcomeLabel.setWidth("100%");		
		
		welcomeImage = new Image();
		welcomeImage.setSrc("/frontend/graphics/welcome.jpg");
		welcomeImage.setWidth("400px");
		welcomeImage.setHeight("400px");
		
		add(welcomeLabel,welcomeImage);
	}
	
}
