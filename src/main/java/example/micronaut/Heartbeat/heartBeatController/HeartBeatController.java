package example.micronaut.Heartbeat.heartBeatController;

import example.micronaut.Heartbeat.heartBeatModel.HeartbeatModel;
import example.micronaut.Heartbeat.heartBeatService.HeartBeatService;
import example.micronaut.Heartbeat.heartBeatController.payloads.response_payload.HeartbeatResponsePayload;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import java.time.LocalDateTime;

@Controller("/heartbeat")
public class HeartBeatController {

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public LocalDateTime index() {
        HeartBeatService heartbeatServiceInstance = new HeartBeatService();
        HeartbeatModel heartbeatModel = heartbeatServiceInstance.getHeartbeat();
        HeartbeatResponsePayload heartbeatResponsePayload = new HeartbeatResponsePayload();
        heartbeatResponsePayload.lastHeartbeatAt = heartbeatModel.lastHeartBeatAt;

        return heartbeatResponsePayload.lastHeartbeatAt;
    }
}