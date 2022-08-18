package example.micronaut.Heartbeat.heartBeatModel;

import java.time.LocalDateTime;

public class HeartbeatModel {

    public LocalDateTime lastHeartBeatAt;

    public HeartbeatModel(LocalDateTime lastHeartBeatAt) {
        this.lastHeartBeatAt = lastHeartBeatAt;
    }
}
