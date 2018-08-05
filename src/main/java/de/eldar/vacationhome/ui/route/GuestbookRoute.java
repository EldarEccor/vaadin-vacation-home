package de.eldar.vacationhome.ui.route;

import java.time.LocalDate;
import java.util.Arrays;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

import de.eldar.vacationhome.ui.components.polymer.CreateGuestbookEntryForm;
import de.eldar.vacationhome.ui.components.polymer.GuestbookEntriesList;
import de.eldar.vacationhome.ui.layout.MainLayout;
import de.eldar.vacationhome.ui.model.GuestbookEntry;

@HtmlImport("frontend://src/views/guestbook/guestbook.html")
@Route(layout = MainLayout.class, value = "Guestbook")
@Tag("guestbook-view")
@PageTitle("Guestbook")
public class GuestbookRoute extends PolymerTemplate<TemplateModel> {

	private static final long serialVersionUID = 4093302817252833253L;

	@Id("createEntryForm")
	private CreateGuestbookEntryForm createEntryForm;
	
	@Id("entriesList")
	private GuestbookEntriesList entriesList;
	
	public GuestbookRoute() {
		GuestbookEntry entry1 = GuestbookEntry.builder().author("EldarEcoor").title("Awesome").date(LocalDate.now())
				.comment("10 / 10 would book again!").build();
		GuestbookEntry entry2 = GuestbookEntry.builder().author("Jaangoo").title("Could have been better")
				.date(LocalDate.now()).comment("8 / 10 The food was too good.").build();
		
		entriesList.reinitModel(Arrays.asList(entry1,entry2));
		createEntryForm.addConsumer(entry -> entriesList.addToModel(entry));
	}

}
