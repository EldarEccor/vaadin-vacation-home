package de.eldar.vacationhome.ui.components;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("paper-input")
@HtmlImport("bower_components/paper-input/paper-input.html")
public class PaperInput extends AbstractSinglePropertyField<PaperInput, String>{
	
	public PaperInput() {
		super("value",null,false);
	}
	
}
