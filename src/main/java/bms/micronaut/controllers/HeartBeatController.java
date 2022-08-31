package bms.micronaut.controllers;

import bms.micronaut.controllers.payloads.response_payload.HeartbeatResponsePayload;
import bms.micronaut.exceptionHandler.GlobalException;
import bms.micronaut.models.HeartbeatModel;
import bms.micronaut.services.HeartBeatService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.time.LocalDateTime;


@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/heartbeat")
public class HeartBeatController {

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public LocalDateTime index() throws GlobalException {

        HeartBeatService heartbeatServiceInstance = new HeartBeatService();
        HeartbeatModel heartbeatModel = heartbeatServiceInstance.getHeartbeat();
        HeartbeatResponsePayload heartbeatResponsePayload = new HeartbeatResponsePayload();
        heartbeatResponsePayload.lastHeartbeatAt = heartbeatModel.lastHeartBeatAt;

        return heartbeatResponsePayload.lastHeartbeatAt;
    }
}