package com.jdh.vo;

import lombok.Data;

@Data
public class SeatVO {
	private String bus_name;
	private String email;
	private int seat_number;
	private int available_seat;
	
	
	private String departure_time;
	private String departure_area;
	private String destination;
	private String[] inputSeatNumber;
	
	
}
