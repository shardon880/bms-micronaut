package bms.micronaut.services;
import bms.micronaut.models.HeartbeatModel;
import bms.micronaut.DAO.HeartBeatRepository;

public class HeartBeatService {
    public HeartbeatModel getHeartbeat(){
        return new HeartBeatRepository().getHeartbeat();
    }
}
