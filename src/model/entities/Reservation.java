package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn)) { //J� coloca no construtor para n�o estanciar errado = Program��o defensiva
			throw new DomainException("Check-out date must be after check-in date");
		}
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

	public long duration() {// o calculo a ser usado retorna o tipo long, por isso n�o usar int
		long diff = checkOut.getTime() - checkIn.getTime();// pega a diferen�a em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);// Usa-se essa classe TimeUnit para converter para
																	// long
	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
    //Quem trata isso � o m�todo, por isso tem que colocar o throws acima
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			 throw new DomainException("Reservation dates for update must be future dates");
		} // Usa-se throw para retornar uma excess�o. Ex acima.(Quando o argumento � invalido)
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		 // Faz-se desta forma pois se n�o ocorrer erro precisa retornar uma String, ent�o retorna vazio
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + " , check-in: " + sdf.format(checkIn) + " , check-out: " + sdf.format(checkOut)
				+ " , " + duration() + " nights";
	}
}
