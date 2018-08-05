package de.eldar.vacationhome.ui.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuestbookEntry {

	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String AUTHOR = "author";
	public static final String DATE = "date";
	public static final String COMMENT = "comment";
	
	private Long id;

	private String title;
	
	private String author;

	private LocalDate date;

	private String comment;

}
