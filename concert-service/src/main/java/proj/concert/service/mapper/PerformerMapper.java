package proj.concert.service.mapper;

import proj.concert.common.dto.PerformerDTO;
import proj.concert.service.domain.Performer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Mapper class to convert from domain-model to DTO objects representing Performers.
 */
public class PerformerMapper {
    public static PerformerDTO toPerformerDTO(Performer performer) {
        return new PerformerDTO(performer.getId(), performer.getName(), performer.getImageName(), performer.getGenre(), performer.getBlurb());
    }

    public static List<PerformerDTO> listToDTO(List<Performer> performers) {
        List<PerformerDTO> dtoList = new ArrayList<>();

        for (Performer p: performers){
            dtoList.add(PerformerMapper.toPerformerDTO(p));
        }
        return dtoList;
    }

    public static List<PerformerDTO> setToDTO(Set<Performer> performerSet) {
        ArrayList<Performer> performerList = new ArrayList<>(performerSet);
        return PerformerMapper.listToDTO(performerList);
    }
}

