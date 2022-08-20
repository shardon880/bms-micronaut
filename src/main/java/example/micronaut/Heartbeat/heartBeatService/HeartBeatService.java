package example.micronaut.Heartbeat.heartBeatService;
import example.micronaut.Heartbeat.heartBeatModel.HeartbeatModel;
import example.micronaut.Heartbeat.heartBeatRepository.HeartBeatRepository;
public class HeartBeatService {
    public HeartbeatModel getHeartbeat(){
        return new HeartBeatRepository().getHeartbeat();
    }
}
