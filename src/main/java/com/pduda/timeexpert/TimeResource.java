package com.pduda.timeexpert;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("time")
public class TimeResource {
    private final Clock clock;

    @XmlRootElement
    public class DTO {
        String timeMessage;
    }

    public TimeResource(Clock clock) {
        this.clock = clock;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_PLAIN)
    public DTO getCurrentTime() {
        DTO dto = new DTO();
        dto.timeMessage = String.format("It's currently %s!", format(clock.now()));
        return dto;
    }

    private String format(Date now) {
        return new SimpleDateFormat("HH:mm").format(now);
    }
}
