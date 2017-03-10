/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.wifi;

/**
 *
 * @author G0042204
 */
public class WifiInfoSet {

    private String operStatus,
            ssid,
            radioEnabled;
    
    private String channel;

    public WifiInfoSet() {

    }

    public WifiInfoSet(String operStatus, String ssid, String channel, String radioEnabled) {
        this.operStatus = operStatus;
        this.ssid = ssid;
        this.channel = channel;
        this.radioEnabled = radioEnabled;
    }

    public String getOperStatus() {
        return operStatus;
    }

    public void setOperStatus(String operStatus) {
        this.operStatus = operStatus;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRadioEnabled() {
        return radioEnabled;
    }

    public void setRadioEnabled(String radioEnabled) {
        this.radioEnabled = radioEnabled;
    }

}
