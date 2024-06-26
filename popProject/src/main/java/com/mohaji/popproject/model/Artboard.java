package com.mohaji.popproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Artboard {

	private String popCode;
	private String popName;
	private String startDay;
	private String endDay;
	private String content;
	private String rink;
	private String img;
	private String place;
}
