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

	private Long id;

	private String title;
	
	private String author;

	private LocalDate date;

	private String comment;

}
