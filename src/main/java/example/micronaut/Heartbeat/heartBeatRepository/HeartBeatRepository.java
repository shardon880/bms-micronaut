package example.micronaut.Heartbeat.heartBeatRepository;

import example.micronaut.Heartbeat.heartBeatModel.HeartbeatModel;

import example.micronaut.common.helper.DateTime_helper;
public class HeartBeatRepository {
    public HeartbeatModel getHeartbeat(){
        HeartbeatModel obj = new HeartbeatModel(new DateTime_helper().getCurrentDate());
        return obj;
    }
}
