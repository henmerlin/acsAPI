/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;


/**
 *
 * @author G0042204
 */
public class DeviceDetail {

    private NbiDeviceData device;

    private Boolean online;

    private Boolean firmwareUpdated;

    public NbiDeviceData getDevice() {
        return device;
    }

    public void setDevice(NbiDeviceData device) {
        this.device = device;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Boolean getFirmwareUpdated() {
        return firmwareUpdated;
    }

    public void setFirmwareUpdated(Boolean firmwareUpdated) {
        this.firmwareUpdated = firmwareUpdated;
    }

}
