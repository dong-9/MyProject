package com.jdh.vo;

import lombok.Data;

@Data
public class TicketingVO {
	private int ticketing_number;
	private String departure_date;		//출발날짜시간
	private String email;				//이메일
	private String departure_area; 		//출발지
	private String destination;			//도착지
	private String number_of_tickets;	//티켓수
	private String seat_number;			//좌석번호
	private int total_price;
	private int ticketing_status; 		//예매상태 : 1 취소상태 : 0
	private String bus_name;
	private String area_name;
	
	
	private String[] seatNumbers;		//예매취소할때 seat_number를 배열로만들기
	private int remaining_seats;
	
	
	public void setUpdateSeatNumbers(String seat_number) {
		seatNumbers = seat_number.split("/");
	}
	
	public void setInsertSeatNumbers() {
		seat_number = "";
		for(String number : seatNumbers) {
			seat_number += number+"/";
		}
	}
	
}

