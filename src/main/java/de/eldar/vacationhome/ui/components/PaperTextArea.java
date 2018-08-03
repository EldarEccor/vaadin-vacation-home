package de.eldar.vacationhome.ui.components;

import org.apache.commons.lang3.StringEscapeUtils;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("paper-textarea")
@HtmlImport("bower_components/paper-input/paper-textarea.html")
public class PaperTextArea extends AbstractSinglePropertyField<PaperTextArea, String>{
	
	public PaperTextArea() {
		super("value",null,false);
	}

}