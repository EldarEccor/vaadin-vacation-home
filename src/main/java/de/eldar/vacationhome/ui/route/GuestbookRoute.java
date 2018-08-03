package de.eldar.vacationhome.ui.route;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.util.HtmlUtils;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.Encode;
import com.vaadin.flow.templatemodel.Include;
import com.vaadin.flow.templatemodel.TemplateModel;

import de.eldar.vacationhome.ui.components.PaperInput;
import de.eldar.vacationhome.ui.components.PaperTextArea;
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

    @Id("addEntry")
    private Button addEntry;
    
    @Id("commentInput")
    private PaperTextArea commentInput;
    
    @Id("authorInput")
    private PaperInput authorInput;
    
    @Id("titleInput")
    private PaperInput titleInput;
	
	public interface GuestbookModel extends TemplateModel {     
		@Include({"title","date","author","comment"})
        @Encode(value = LocalDateToStringEncoder.class, path = "date")
        void setEntries(List<GuestbookEntry> entries);
		
		List<GuestbookEntry> getEntries();
    }
	
	public GuestbookRoute() {
		GuestbookEntry entry1 = GuestbookEntry.builder().author("EldarEcoor").title("Awesome").date(LocalDate.now()).comment("10 / 10 would book again!").build();
		GuestbookEntry entry2 = GuestbookEntry.builder().author("Jaangoo").title("Could have been better").date(LocalDate.now()).comment("8 / 10 The food was too good.").build();
		
		List<GuestbookEntry> entries = Arrays.asList(entry1,entry2);
		
		getModel().setEntries(entries);
	}
	
    @EventHandler
    private void addEntry() {
    	String title = titleInput.getValue();
    	String comment = commentInput.getValue();
    	String author = authorInput.getValue();   	
    	
        getModel().getEntries().add(GuestbookEntry.builder().author(author).title(title).date(LocalDate.now()).comment(comment).build());
        
        
    }
	
}

