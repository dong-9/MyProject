package com.jdh.vo;

import lombok.Data;

@Data
public class AreaTimeVO {
	private String departure_time;	//출발시간
	private String departure_area;	//출발지
	private String destination;		//도착지
	private int ticket_price;		//티켓가격
	private int remaining_seats;	//남은좌석
	private int total_seats;		//총좌석
	private String bus_name;		//버스이름
	
}
