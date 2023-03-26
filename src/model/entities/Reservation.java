package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {// o calculo a ser usado retorna o tipo long, por isso não usar int
		long diff = checkOut.getTime() - checkIn.getTime();// pega a diferença em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);// Usa-se essa classe TimeUnit para converter para
																	// long
	}

	public String updateDates(Date checkIn, Date checkOut) {

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates";
		} // Usa-se um if após o outro pq o primeiro interrompe o código se a condição for
			// verdade
		if (!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null; // Faz-se desta forma pois se não ocorrer erro precisa retornar uma String, então retorna vazio
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + " , check-in: " + sdf.format(checkIn) + " , check-out: " + sdf.format(checkOut)
				+ " , " + duration() + " nights";
	}
}
