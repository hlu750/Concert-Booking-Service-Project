package proj.concert.service.util;

import proj.concert.common.dto.ConcertInfoSubscriptionDTO;

import javax.ws.rs.container.AsyncResponse;

public class Subscription {
    private ConcertInfoSubscriptionDTO dto;
    private AsyncResponse response;

    public Subscription(ConcertInfoSubscriptionDTO dto, AsyncResponse response) {
        this.dto = dto;
        this.response = response;
    }

    public ConcertInfoSubscriptionDTO getDto() {
        return dto;
    }

    public AsyncResponse getResponse() {
        return response;
    }
}
