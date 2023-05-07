package proj.concert.service.mapper;

import proj.concert.common.dto.ConcertDTO;
import proj.concert.common.dto.ConcertSummaryDTO;
import proj.concert.service.domain.Concert;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper class to convert from domain-model to DTO objects representing Concert.
 */
public class ConcertMapper {
    public static ConcertDTO toConcertDTO(Concert concert){
        ConcertDTO result = new ConcertDTO(concert.getId(),concert.getTitle(),concert.getImageName(),concert.getBlurb());
        result.setDates(new ArrayList<>(concert.getDates()));
        result.setPerformers(PerformerMapper.listToDTO(concert.getPerformers()));
        return result;
    }

    public static List<ConcertDTO> listToDTO(List<Concert> concerts) {
        List<ConcertDTO> dtoList = new ArrayList<>();
        for (Concert c : concerts) {
            dtoList.add(ConcertMapper.toConcertDTO(c));
        }
        return dtoList;
    }

    public static List<ConcertSummaryDTO> listToConcertSummaryDTO(List<Concert> concerts) {
        List<ConcertSummaryDTO> concertSummaryDTOList = new ArrayList<>();

        for(Concert c:concerts) {
            concertSummaryDTOList.add( new ConcertSummaryDTO(c.getId(), c.getTitle(), c.getImageName()));
        }

        return concertSummaryDTOList;
    }
}

