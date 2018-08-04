package de.eldar.vacationhome.ui.components.web;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.Focusable;
import com.vaadin.flow.component.HasValidation;
import com.vaadin.flow.component.PropertyDescriptor;
import com.vaadin.flow.component.PropertyDescriptors;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("paper-input")
@HtmlImport("bower_components/paper-input/paper-input.html")
public class PaperInput extends AbstractSinglePropertyField<PaperInput, String> implements HasValidation,Focusable<PaperInput>{
	
	public PaperInput() {
		super("value", "",false);
		addFocusListener(e -> validate());
	}

	private static final long serialVersionUID = 2251802130755051704L;
	
	private static final PropertyDescriptor<Boolean, Boolean> REQUIRED = PropertyDescriptors
			.propertyWithDefault("required", false);
	
	private static final PropertyDescriptor<Boolean, Boolean> READONLY = PropertyDescriptors
			.propertyWithDefault("readonly", false);
	
	private static final PropertyDescriptor<Boolean, Boolean> AUTO_VALIDATE = PropertyDescriptors
			.propertyWithDefault("autoValidate", false);
	
	private static final PropertyDescriptor<Boolean, Boolean> ALWAYS_FLOAT_LABEL = PropertyDescriptors
			.propertyWithDefault("alwaysFloatLabel", false);

	private static final PropertyDescriptor<String, String> LABEL = PropertyDescriptors
			.propertyWithDefault("label", "");

	private static final PropertyDescriptor<String, String> ALLOWED_PATTERN = PropertyDescriptors
			.propertyWithDefault("allowedPattern", "");
	
	private static final PropertyDescriptor<String, String> PATTERN = PropertyDescriptors
			.propertyWithDefault("pattern", "");
	
	private static final PropertyDescriptor<String, String> ERROR_MESSAGE = PropertyDescriptors
			.propertyWithDefault("errorMessage","");
	
	private static final PropertyDescriptor<Integer, Integer> MIN_LENGTH = PropertyDescriptors
			.propertyWithDefault("minlength", 0);
	
	private static final PropertyDescriptor<Integer, Integer> MAX_LENGTH = PropertyDescriptors
			.propertyWithDefault("maxlength", Integer.MAX_VALUE);
	
	public void validate() {
		getElement().callFunction("validate");
	}
	
	public void setLabel(String label) {
		LABEL.set(this, label);
	}
	
	public String getLabel() {
		return LABEL.get(this);
	}
	
	public void setPattern(String pattern) {
		PATTERN.set(this, pattern);
	}
	
	public String getPattern() {
		return PATTERN.get(this);
	}
	
	public Boolean getRequired() {
		return REQUIRED.get(this);
	}
	
	public void setRequired(Boolean autoValidate) {
		REQUIRED.set(this, autoValidate);
	}
	
	public Boolean getAutoValidate() {
		return AUTO_VALIDATE.get(this);
	}
	
	public void setAutoValidate(Boolean autoValidate) {
		AUTO_VALIDATE.set(this, autoValidate);
	}
	
	public String getAllowedPattern() {
		return ALLOWED_PATTERN.get(this);
	}

	public void setAllowedPattern(String allowedPattern) {
		ALLOWED_PATTERN.set(this, allowedPattern);
	}

	public Boolean getAlwaysFloatLabel() {
		return ALWAYS_FLOAT_LABEL.get(this);
	}

	public void setAlwaysFloatLabel(Boolean alwaysFloatLabel) {
		ALWAYS_FLOAT_LABEL.set(this, alwaysFloatLabel);
	}

	public Integer getMinlength() {
		return MIN_LENGTH.get(this);
	}

	public void setMinlength(Integer minlength) {
		MIN_LENGTH.set(this, minlength);
	}

	public Integer getMaxlength() {
		return MAX_LENGTH.get(this);
	}

	public void setMaxlength(Integer maxlength) {
		MAX_LENGTH.set(this, maxlength);
	}

	public boolean isReadonly() {
		return READONLY.get(this);
	}
	
	public void setReadonly(boolean readonly) {
		READONLY.set(this, readonly);
	}

	public void setErrorMessage(String errorMessage) {
		ERROR_MESSAGE.set(this, errorMessage);		
	}

	public String getErrorMessage() {
		return ERROR_MESSAGE.get(this);
	}

	public void setInvalid(boolean invalid) {
		getElement().setProperty("invalid",invalid);		
	}
	
    @Synchronize(property = "invalid", value = "invalid-changed")
	public boolean isInvalid() {
		return getElement().getProperty("invalid", false);		
	}
	
}
