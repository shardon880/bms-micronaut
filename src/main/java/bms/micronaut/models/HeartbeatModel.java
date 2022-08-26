package bms.micronaut.models;

import java.time.LocalDateTime;

public class HeartbeatModel {

    public LocalDateTime lastHeartBeatAt;

    public HeartbeatModel(LocalDateTime lastHeartBeatAt) {
        this.lastHeartBeatAt = lastHeartBeatAt;
    }
}
