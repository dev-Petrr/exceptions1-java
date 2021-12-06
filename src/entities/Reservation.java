package entities;
import entities.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(){
    }
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException{
        if (!checkOut.after(checkIn)){
            throw new DomainException("Error in reservation: Check-out must be after Check-in.");
        }
        this.setRoomNumber(roomNumber);
        this.checkIn=checkIn;
        this.checkOut=checkOut;
    }
    public Integer getRoomNumber(){
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber){
        this.roomNumber=roomNumber;
    }
    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        //pega a diferença das datas em milissegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        //converte diff que estava em milissegundos para dias.

    }
    public void updateDates(Date checkIn, Date checkOut) throws DomainException{

        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Reservation must be future dates.");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Error in reservation: Check-out must be after Check-in.");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    @Override
    public String toString(){
        return "Room "
            +  getRoomNumber()
            + ", check-in: "
            + sdf.format(getCheckIn())
            + ", check-out: "
            + sdf.format(getCheckOut())
            + ", " + duration()
            + " nights.";
    }
    public Date getCheckIn(){
        return checkIn;
    }

    public Date getCheckOut(){
        return checkOut;
    }


}
