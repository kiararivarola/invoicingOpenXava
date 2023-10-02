package com.yourcompany.invoicing.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@View(name = "Simple", // This view is used only when “Simple” is specified
		members = "number, name" // Shows only number and name in the same line
)

@Entity
@Getter
@Setter
public class Customer {

	@Id
	@Column(length = 6)
	int number;

	@Column(length = 50)
	@Required
	String name;

	@Embedded
	@NoFrame
	Address address;

}
