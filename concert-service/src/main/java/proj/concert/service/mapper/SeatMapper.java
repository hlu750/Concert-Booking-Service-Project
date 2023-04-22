package proj.concert.service.mapper;

import proj.concert.common.dto.SeatDTO;
import proj.concert.service.domain.Seat;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper class to convert from domain-model to DTO objects representing Seats.
 */
public class SeatMapper {
    public static SeatDTO toDTO(Seat seat) {
        return new SeatDTO(seat.getLabel(), seat.getCost());
    }

    public static List<SeatDTO> listToDTO(List<Seat> seatList) {
        List<SeatDTO> seatDTOList = new ArrayList<>();
        for(Seat s: seatList) {
            seatDTOList.add(SeatMapper.toDTO(s));
        }
        return seatDTOList;
    }

}
