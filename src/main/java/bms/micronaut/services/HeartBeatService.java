package bms.micronaut.services;
import bms.micronaut.models.HeartbeatModel;
import bms.micronaut.DAO.HeartBeatDAO;

public class HeartBeatService {
    public HeartbeatModel getHeartbeat(){
        return new HeartBeatDAO().getHeartbeat();
    }
}
