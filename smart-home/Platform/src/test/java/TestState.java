import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import tartan.smarthome.resources.StaticTartanStateEvaluator;
import tartan.smarthome.resources.iotcontroller.IoTValues;
import static org.junit.Assert.assertEquals;

public class TestState {
    private  Map<String, Object> mockData;
    private StringBuffer mockLog;
    @Before
    public void initTest(){
        //this will be run before each test
        mockData = new HashMap<String,Object>();
        mockLog = new StringBuffer();
    }
    private void initDataTestLight(){
        mockData.put(IoTValues.DOOR_STATE, false);
        mockData.put(IoTValues.AWAY_TIMER, false);
        mockData.put(IoTValues.LIGHT_STATE, true);
        mockData.put(IoTValues.PROXIMITY_STATE, false);
        mockData.put(IoTValues.ALARM_STATE, false);
        mockData.put(IoTValues.HUMIDIFIER_STATE, false);
        mockData.put(IoTValues.HEATER_STATE, false);
        mockData.put(IoTValues.CHILLER_STATE, false);
        mockData.put(IoTValues.ALARM_ACTIVE, false);
        mockData.put(IoTValues.HVAC_MODE, "");
        mockData.put(IoTValues.ALARM_PASSCODE, "");
        mockData.put(IoTValues.GIVEN_PASSCODE, "");
        mockData.put(IoTValues.TEMP_READING,1);
        mockData.put(IoTValues.TARGET_TEMP,1);
    }
    @Test
    public void testLight() {
        initDataTestLight();
        StaticTartanStateEvaluator mock = new StaticTartanStateEvaluator();
        Map<String, Object> newState = mock.evaluateState(mockData,mockLog);
        assertEquals(false,newState.get(IoTValues.LIGHT_STATE));
    }

}