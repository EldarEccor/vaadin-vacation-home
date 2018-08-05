package de.eldar.vacationhome.ui.components.polymer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.Encode;
import com.vaadin.flow.templatemodel.Exclude;
import com.vaadin.flow.templatemodel.TemplateModel;

import de.eldar.vacationhome.ui.components.polymer.GuestbookEntriesList.GuestbookModel;
import de.eldar.vacationhome.ui.model.GuestbookEntry;
import de.eldar.vacationhome.ui.model.ecnoder.LocalDateToEuroStringEncoder;

@Tag("guestbook-entries-list")
@HtmlImport("frontend://src/views/guestbook/entries-list.html")
public class GuestbookEntriesList extends PolymerTemplate<GuestbookModel> {

	private static final long serialVersionUID = -7266325564736028219L;

	public interface GuestbookModel extends TemplateModel {
		@Exclude({ GuestbookEntry.ID })
		@Encode(value = LocalDateToEuroStringEncoder.class, path = GuestbookEntry.DATE)
		void setEntries(List<GuestbookEntry> entries);

		List<GuestbookEntry> getEntries();
	}
	
	public GuestbookEntriesList() {}
	
	public void addToModel(GuestbookEntry... entries) {
		getModel().getEntries().addAll(Arrays.asList(entries));
	}
	
	public void reinitModel(List<GuestbookEntry> entries){
		getModel().setEntries(new ArrayList<>(entries));
	}
}
