package entities;
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
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
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
    public void updateDates(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        //O atributo da classe, receber o parâmetro.
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
