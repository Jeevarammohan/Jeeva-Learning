import java.util.ArrayList;
import java.util.List;

public class HotelService {
    List<Hotel> hotels = new ArrayList<>();
    public void getHotels(){
        hotels.add(new Hotel(2000,HotelType.THREE_STAR,4));
        hotels.add(new Hotel(1000,HotelType.THREE_STAR,3));
        hotels.add(new Hotel(1500,HotelType.THREE_STAR,4));
        hotels.add(new Hotel(4000,HotelType.FOU_STAR,5));
        hotels.add(new Hotel(20000,HotelType.FIVE_STAR,5));
        hotels.add(new Hotel(3500,HotelType.THREE_STAR,4));
    }

    HotelService(){
        getHotels();
    }

    public  List<Hotel> filterHotels(FilterCondition filterCondition){
        List<Hotel> result = new ArrayList<>();
        for(Hotel hotel:hotels){
            if(filterCondition.test(hotel)){
                result.add(hotel);
            }
        }
        return result;
    }
}
