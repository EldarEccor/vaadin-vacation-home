package de.eldar.vacationhome.ui.route;

import java.util.List;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.Encode;
import com.vaadin.flow.templatemodel.Exclude;
import com.vaadin.flow.templatemodel.TemplateModel;

import de.eldar.vacationhome.ui.components.polymer.CreateGuestbookEntryForm;
import de.eldar.vacationhome.ui.layout.MainLayout;
import de.eldar.vacationhome.ui.model.GuestbookEntry;
import de.eldar.vacationhome.ui.model.ecnoder.LocalDateToStringEncoder;
import de.eldar.vacationhome.ui.route.GuestbookRoute.GuestbookModel;

@HtmlImport("frontend://src/views/guestbook/guestbook.html")
@Route(layout = MainLayout.class, value = "Guestbook")
@Tag("guestbook-view")
@PageTitle("Guestbook")
public class GuestbookRoute extends PolymerTemplate<GuestbookModel> {

	private static final long serialVersionUID = 4093302817252833253L;

	@Id("createEntryForm")
	private CreateGuestbookEntryForm createEntryForm;
	
	public interface GuestbookModel extends TemplateModel {
		@Exclude({ "id" })
		@Encode(value = LocalDateToStringEncoder.class, path = "date")
		void setEntries(List<GuestbookEntry> entries);

		List<GuestbookEntry> getEntries();
	}

	public GuestbookRoute() {
		createEntryForm.addConsumer(entry -> getModel().getEntries().add(entry));
	}

}
