package de.eldar.vacationhome.ui.components.polymer;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.validator.RegexpValidator;
import com.vaadin.flow.templatemodel.TemplateModel;

import de.eldar.vacationhome.ui.components.web.PaperInput;
import de.eldar.vacationhome.ui.components.web.PaperTextArea;
import de.eldar.vacationhome.ui.model.GuestbookEntry;
import lombok.extern.slf4j.Slf4j;

@Tag("create-guestbook-entry")
@HtmlImport("frontend://src/views/guestbook/create-entry.html")
@Slf4j
public class CreateGuestbookEntryForm extends PolymerTemplate<TemplateModel> {

	public static final String AUTHOR_PATTERN = "[a-z0-9\\.-]{2,256}";

	public static final String TITLE_PATTERN = "[a-z0-9\\_.-?!]{5,256}";

	private static final long serialVersionUID = 4093302817252833253L;

	Binder<GuestbookEntry> binder = new Binder<>(GuestbookEntry.class);

	@Id("addEntry")
	private Button addEntry;

	@Id("commentArea")
	private PaperTextArea commentArea;

	@Id("authorInput")
	private PaperInput authorInput;

	@Id("titleInput")
	private PaperInput titleInput;
	
	private Set<Consumer<GuestbookEntry>> consumers = new HashSet<>();
	
	public CreateGuestbookEntryForm() {
		initInputFields();

		initBindings();
		initInputListeners();

		addEntry.setEnabled(false);
		addEntry.setText("Leave message");
		addEntry.addClickListener(clickEvent -> {
			GuestbookEntry entry = new GuestbookEntry();
			try {
				entry.setDate(LocalDate.now());
				binder.writeBean(entry);
				consumers.forEach(c -> c.accept(entry));
			} catch (ValidationException e) {
				log.error("Binding values failed");
				List<ValidationResult> beanValidationErrors = e.getValidationErrors();
				beanValidationErrors.forEach(error -> log.error(error.getErrorMessage()));
			}
		});
	}
	
	public void addConsumer(Consumer<GuestbookEntry> consumer) {
		Objects.requireNonNull(consumer);
		consumers.add(consumer);		
	}

	private void initInputFields() {
		titleInput.setRequired(true);
		titleInput.setPattern(TITLE_PATTERN);
		titleInput.setAutoValidate(true);
		titleInput.setAlwaysFloatLabel(true);
		titleInput.setLabel("A suitable title (5 - 256 digits,letters and '._-!') - required");

		authorInput.setRequired(true);
		authorInput.setPattern(AUTHOR_PATTERN);
		authorInput.setAlwaysFloatLabel(true);
		authorInput.setLabel("Your name (2 - 256 digits,letters and '.-') - required");
		authorInput.setAutoValidate(true);

		commentArea.setRequired(true);
		commentArea.setAlwaysFloatLabel(true);
		commentArea.setLabel("Your message - required (Multiple lines possible)");
		commentArea.setAutoValidate(true);
	}

	private void initBindings() {
		binder.forField(authorInput)
				.withValidator(new RegexpValidator("Does not match regexp : " + AUTHOR_PATTERN, AUTHOR_PATTERN))
				.asRequired().bind(GuestbookEntry.AUTHOR);

		binder.forField(titleInput)
				.withValidator(new RegexpValidator("Does not match regexp : " + TITLE_PATTERN, TITLE_PATTERN))
				.asRequired().bind(GuestbookEntry.TITLE);

		binder.forField(commentArea).asRequired().bind(GuestbookEntry.COMMENT);
	}

	private void initInputListeners() {
		authorInput.addFocusListener(e -> validateInputFields());
		commentArea.addFocusListener(e -> validateInputFields());
		titleInput.addFocusListener(e -> validateInputFields());

		commentArea.addValueChangeListener(e -> toogleButtonIfValid());
		authorInput.addValueChangeListener(e -> toogleButtonIfValid());
		titleInput.addValueChangeListener(e -> toogleButtonIfValid());
	}

	private void toogleButtonIfValid() {
		if (areInputFieldsValid()) {
			addEntry.setEnabled(true);
		} else {
			addEntry.setEnabled(false);
		}
	}

	private void validateInputFields() {
		commentArea.validate();
		authorInput.validate();
		titleInput.validate();
	}

	private Boolean areInputFieldsValid() {
		return !(commentArea.isInvalid() || authorInput.isInvalid() || titleInput.isInvalid());
	}
}
