package bms.micronaut.DAO;

import bms.micronaut.common.helper.DateTime_helper;
import bms.micronaut.models.HeartbeatModel;

public class HeartBeatDAO {
    public HeartbeatModel getHeartbeat(){
        HeartbeatModel obj = new HeartbeatModel(new DateTime_helper().getCurrentDate());
        return obj;
    }
}
