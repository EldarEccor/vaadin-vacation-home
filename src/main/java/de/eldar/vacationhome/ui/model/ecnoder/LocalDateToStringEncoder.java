package de.eldar.vacationhome.ui.model.ecnoder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.vaadin.flow.templatemodel.ModelEncoder;

/**
 * Converts between DateTime-objects and their String-representations
 *
 */

public class LocalDateToStringEncoder
        implements ModelEncoder<LocalDate, String> {

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter
            .ofPattern("dd.MM.YYYY");

    @Override
    public LocalDate decode(String presentationValue) {
        return LocalDate.parse(presentationValue, DATE_FORMAT);
    }

    @Override
    public String encode(LocalDate modelValue) {
        return modelValue == null ? null : modelValue.format(DATE_FORMAT);
    }

}
