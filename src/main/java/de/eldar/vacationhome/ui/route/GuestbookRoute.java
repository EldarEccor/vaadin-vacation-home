package de.eldar.vacationhome.ui.route;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.Encode;
import com.vaadin.flow.templatemodel.Include;
import com.vaadin.flow.templatemodel.TemplateModel;

import de.eldar.vacationhome.ui.layout.MainLayout;
import de.eldar.vacationhome.ui.model.GuestbookEntry;
import de.eldar.vacationhome.ui.model.ecnoder.LocalDateToStringEncoder;
import de.eldar.vacationhome.ui.route.GuestbookRoute.GuestbookModel;

@HtmlImport("frontend://src/views/guestbook/guestbook.html")
@Route(layout = MainLayout.class,value = "Guestbook")
@Tag("guestbook-view")
@PageTitle("Guestbook")
public class GuestbookRoute extends PolymerTemplate<GuestbookModel> {

	private static final long serialVersionUID = 4093302817252833253L;

	public interface GuestbookModel extends TemplateModel {     
		@Include({"title","date","author","comment"})
        @Encode(value = LocalDateToStringEncoder.class, path = "date")
        void setEntries(List<GuestbookEntry> entries);
    }
	
	public GuestbookRoute() {
		GuestbookEntry entry1 = GuestbookEntry.builder().author("EldarEcoor").title("Awesome").date(LocalDate.now()).comment("10 / 10 would book again!").build();
		GuestbookEntry entry2 = GuestbookEntry.builder().author("Jaangoo").title("Could hva been better").date(LocalDate.now()).comment("8 / 10 The food was too good.").build();
		
		List<GuestbookEntry> entries = Arrays.asList(entry1,entry2);
		
		getModel().setEntries(entries);
	}
	
}

