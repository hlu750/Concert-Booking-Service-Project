package proj.concert.service.mapper;

import proj.concert.common.dto.BookingDTO;
import proj.concert.service.domain.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class to convert from domain-model to DTO objects representing
 * Bookings.
 */
public class BookingMapper {
    public static BookingDTO toBookingDTO(Booking booking){
        return new BookingDTO(booking.getConcertId(), booking.getDate(),
                booking.getSeats().stream().map(s -> SeatMapper.toSeatDTO(s)).collect(Collectors.toList()));
    }

    public static List<BookingDTO> listToDTO(List<Booking> bookingList) {
        ArrayList<BookingDTO> result = new ArrayList<>();

        for (Booking b: bookingList) {
            result.add(BookingMapper.toBookingDTO(b));
        }

        return result;
    }
}
