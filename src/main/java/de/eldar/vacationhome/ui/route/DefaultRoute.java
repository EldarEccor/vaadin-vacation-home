package de.eldar.vacationhome.ui.route;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

// "" is the default route for the Vaadin navigation
@Theme(Lumo.class)
@Route("")
public class DefaultRoute extends VerticalLayout{

	private static final long serialVersionUID = 3412336558939266983L;
	
	private Button crazyButton;
	
	private Label crazyLabel;
	
	public DefaultRoute() {
		crazyButton = new Button("Click me softly...");
		crazyButton.addClickListener(e -> {
			crazyLabel.setVisible(!crazyLabel.isVisible());
		});
		
		crazyLabel = new Label("Jihhaaaa! Keep toggling...");
		crazyLabel.setSizeFull();
		crazyLabel.setVisible(false);
		
		setSizeFull();
		add(crazyButton);
		add(crazyLabel);
	}
	
}
