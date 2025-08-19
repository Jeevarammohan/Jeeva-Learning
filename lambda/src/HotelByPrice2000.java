public class HotelByPrice2000 implements FilterCondition{
    @Override
    public boolean test(Hotel hotel) {
        return hotel.getPrice()<=2000;
    }
}
