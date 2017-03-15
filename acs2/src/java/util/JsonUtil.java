/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import model.device.DmzInfo;
import model.device.ddns.DdnsInfo;
import model.device.firmware.FirmwareInfo;
import model.device.interfacestatistics.InterfaceStatistics;
import model.device.lanhost.LanDevice;
import model.device.log.DeviceLog;
import model.device.ping.PingResponse;
import model.device.portmapping.PortMappingInfo;
import model.device.pppoe.PPPoECredentialsInfo;
import model.device.wan.WanInfo;
import model.device.wifi.WifiInfo;
import model.device.wifi.WifiInfoFull;
import motive.hdm.synchdeviceops.StringResponseDTO;

/**
 *
 * @author G0042204
 */
public class JsonUtil {

    public static FirmwareInfo firmwareInfo(StringResponseDTO a) {
        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();
        String firmwareVersion = jobject.get("firmwareVersion").toString().replace("\"", "");
        String preferredVersion = jobject.get("preferredVersion").toString().replace("\"", "");
        return new FirmwareInfo(firmwareVersion, preferredVersion);
    }

    public static DmzInfo dmzInfo(StringResponseDTO a) {
        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();
        String Enable = jobject.get("Enable").toString().replace("\"", "");
        String IPAddress = jobject.get("IPAddress").toString().replace("\"", "");
        return new DmzInfo(new Boolean(Enable), IPAddress);
    }

    public static String serialize(Object o, Type a) {
        return new Gson().toJsonTree(o, a).toString().replace("\"", "'");
    }

    public static PortMappingInfo getPortMappingInfo(StringResponseDTO a) {

        PortMappingInfo i = new PortMappingInfo();

        JsonElement jelement = new JsonParser().parse(a.getValue().replace("[", "").replace("]", ""));
        JsonObject jobject = jelement.getAsJsonObject();

        // System.out.println("FullJson: " + jobject.toString());
        String externalPort = jobject.get("externalPort").toString().replace("\"", "");
        String internalClient = jobject.get("internalClient").toString().replace("\"", "");
        String internalPort = jobject.get("internalPort").toString().replace("\"", "");
        String portMapName = jobject.get("portMapName").toString().replace("\"", "");
        String enable = jobject.get("enable").toString().replace("\"", "");
        String protocol = jobject.get("protocol").toString().replace("\"", "");
        String remoteHost = jobject.get("remoteHost").toString().replace("\"", "");

        i.setExternalPort(externalPort);
        i.setInternalClient(internalClient);
        i.setInternalPort(internalPort);
        i.setPortMapName(portMapName);
        i.setEnable(enable);;
        i.setProtocol(protocol);
        i.setRemoteHost(remoteHost);

        return i;
    }

    public static WifiInfo getWifiInfo(StringResponseDTO a) {

        WifiInfo i = new WifiInfo();

        JsonElement jelement = new JsonParser().parse(a.getValue().replace("[", "").replace("]", ""));
        JsonObject jobject = jelement.getAsJsonObject();

        // System.out.println("FullJson: " + jobject.toString());
        String index = jobject.get("index").toString();
        String authentication = jobject.get("authentication").toString().replace("\"", "");
        String broadcastEnabled = jobject.get("broadcastEnabled").toString().replace("\"", "");
        String channel = jobject.get("Channel").toString().replace("\"", "");
        String operStatus = jobject.get("operStatus").toString().replace("\"", "");
        String encryptation = jobject.get("encryptation").toString().replace("\"", "");
        String radioStatus = jobject.get("RadioEnabled").toString().replace("\"", "");
        String ssid = jobject.get("SSID").toString().replace("\"", "");
        String standard = jobject.get("Standard").toString().replace("\"", "");
        String password = jobject.get("ssidPassword").toString().replace("\"", "");

        i.setIndex(index);
        i.setAuthentication(authentication);
        i.setBroadcastEnabled(broadcastEnabled);
        i.setChannel(channel);
        i.setOperStatus(operStatus);
        i.setEncryptation(encryptation);
        i.setRadioOperStatus(radioStatus);
        i.setSsid(ssid);
        i.setStandard(standard);
        i.setSsidPassword(password);

        return i;
    }

    public static WifiInfoFull getWifiInfoFull(StringResponseDTO a) {

        WifiInfoFull i = new WifiInfoFull();

        JsonElement jelement = new JsonParser().parse(a.getValue().replace("[", "").replace("]", ""));
        JsonObject jobject = jelement.getAsJsonObject();

        // System.out.println("FullJson: " + jobject.toString());
        String admStatus = jobject.get("admStatus").toString().replace("\"", "");
        String operStatus = jobject.get("operStatus").toString().replace("\"", "");
        String channel = jobject.get("channel").toString().replace("\"", "");
        Boolean bcEnabled = jobject.get("bcEnabled").getAsBoolean();
        String maxBitRate = jobject.get("maxBitRate").toString().replace("\"", "");
        Integer signal = jobject.get("signal").getAsInt();
        String ssid = jobject.get("ssid").toString().replace("\"", "");
        String authMode = jobject.get("authMode").toString().replace("\"", "");
        String encType = jobject.get("encType").toString().replace("\"", "");
        String key = jobject.get("key").toString().replace("\"", "");
        String wepKeyIndex = jobject.get("wepKeyIndex").toString().replace("\"", "");
        Boolean macAddrControl = jobject.get("macAddrControl").getAsBoolean();
        String macAddress = jobject.get("macAddress").toString().replace("\"", "");
        String radioStatus = jobject.get("radioStatus").toString().replace("\"", "");
        String standard = jobject.get("standard").toString().replace("\"", "");
        String bytesSent = jobject.get("bytesSent").toString().replace("\"", "");
        String bytesRecv = jobject.get("bytesRecv").toString().replace("\"", "");
        String pctSent = jobject.get("pctSent").toString().replace("\"", "");
        String pctRecv = jobject.get("pctRecv").toString().replace("\"", "");
        String errSent = jobject.get("errSent").toString().replace("\"", "");
        String errRecv = jobject.get("errRecv").toString().replace("\"", "");
        Boolean wpsEnabled = jobject.get("wpsEnabled").getAsBoolean();
        String wpsDeviceName = jobject.get("wpsDeviceName").toString().replace("\"", "");
        String wpsDevicePassword = jobject.get("wpsDevicePassword").toString().replace("\"", "");

        i.setSsid(ssid);
        i.setAdmStatus(admStatus);
        i.setAuthMode(authMode);
        i.setBcEnabled(bcEnabled);
        i.setBytesRecv(bytesRecv);
        i.setBytesSent(bytesSent);
        i.setChannel(channel);
        i.setEncType(encType);
        i.setErrRecv(errRecv);
        i.setErrSent(errSent);
        i.setKey(key);
        i.setMacAddrControl(macAddrControl);
        i.setMacAddress(macAddress);
        i.setMaxBitRate(maxBitRate);
        i.setOperStatus(operStatus);
        i.setPctSent(pctSent);
        i.setPctRecv(pctRecv);
        i.setRadioStatus(radioStatus);
        i.setSignal(signal);
        i.setStandard(standard);
        i.setWepKeyIndex(wepKeyIndex);
        i.setWpsDeviceName(wpsDeviceName);
        i.setWpsDevicePassword(wpsDevicePassword);
        i.setWpsEnabled(wpsEnabled);

        return i;
    }

    public static WanInfo getWanInfo(StringResponseDTO a) {

        WanInfo i = new WanInfo();

        JsonElement jelement = new JsonParser().parse(a.getValue().replace("[", "").replace("]", ""));
        JsonObject jobject = jelement.getAsJsonObject();

        String EthernetBytesSent = jobject.get("EthernetBytesSent").toString().replace("\"", "");
        String EthernetBytesReceived = jobject.get("EthernetBytesReceived").toString().replace("\"", "");
        String EthernetPacketsSent = jobject.get("EthernetPacketsSent").toString().replace("\"", "");
        String EthernetPacketsReceived = jobject.get("EthernetPacketsReceived").toString().replace("\"", "");
        String EthernetErrorsSent = jobject.get("EthernetErrorsSent").toString().replace("\"", "");
        String EthernetErrorsReceived = jobject.get("EthernetErrorsReceived").toString().replace("\"", "");
        String EthernetDiscardPacketsSent = jobject.get("EthernetDiscardPacketsSent").toString().replace("\"", "");
        String EthernetDiscardPacketsReceived = jobject.get("EthernetDiscardPacketsReceived").toString().replace("\"", "");

        i.setEthernetBytesReceived(EthernetBytesReceived);
        i.setEthernetBytesSent(EthernetBytesSent);
        i.setEthernetDiscardPacketsReceived(EthernetDiscardPacketsReceived);
        i.setEthernetDiscardPacketsSent(EthernetDiscardPacketsSent);
        i.setEthernetErrorsReceived(EthernetErrorsReceived);
        i.setEthernetErrorsSent(EthernetErrorsSent);
        i.setEthernetPacketsReceived(EthernetPacketsReceived);
        i.setEthernetPacketsSent(EthernetPacketsSent);

        return i;
    }

    public static DdnsInfo ddnsInfo(StringResponseDTO a) {

        DdnsInfo d = new DdnsInfo();

        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();

        Boolean enable = new Boolean(jobject.get("Enable").toString().replace("\"", ""));
        String hostname = jobject.get("Hostname").toString().replace("\"", "");
        String password = jobject.get("Password").toString().replace("\"", "");
        String provider = jobject.get("Provider").toString().replace("\"", "");
        String providerUrl = jobject.get("ProviderURL").toString().replace("\"", "");
        String user = jobject.get("User").toString().replace("\"", "");

        d.setEnable(enable);
        d.setHostname(hostname);
        d.setPassword(password);
        d.setProvider(provider);
        d.setProviderUrl(providerUrl);
        d.setUser(user);

        return d;
    }

    public static List<DeviceLog> deviceLog(StringResponseDTO a) {
        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();
        String[] split = jobject.get("DeviceLog").toString().replace("\"", "").replace("\\n", "\n").split("\n");

        List<DeviceLog> logs = new ArrayList<>();

        for (String string : split) {
            logs.add(new DeviceLog(string));
        }

        return logs;
    }

    public static List<LanDevice> getLanHosts(StringResponseDTO a) {

        List<LanDevice> lst = new ArrayList<>();

        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();

        Integer qtn = new Integer(jobject.get("HostNumberOfEntries").toString().replace("\"", ""));

        for (int i = 1; i < qtn; i++) {

            LanDevice l = new LanDevice();

            l.setIpAddress(jobject.get("Host." + i + ".IPAddress").toString().replace("\"", ""));
            l.setAddressSource(jobject.get("Host." + i + ".AddressSource").toString().replace("\"", ""));
            l.setLeaseTimeRemaining(jobject.get("Host." + i + ".LeaseTimeRemaining").toString().replace("\"", ""));
            l.setMacAddress(jobject.get("Host." + i + ".MACAddress").toString().replace("\"", ""));
            l.setHostName(jobject.get("Host." + i + ".HostName").toString().replace("\"", ""));
            l.setInterfaceType(jobject.get("Host." + i + ".InterfaceType").toString().replace("\"", ""));
            l.setAtivo(Boolean.valueOf(jobject.get("Host." + i + ".Active").toString().replace("\"", "")));

            lst.add(l);
        }
        return lst;
    }

    public static PingResponse pingResponse(StringResponseDTO a) {
        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();

        String status = jobject.get("status").toString().replace("\"", "");
        String avgRespTime = jobject.get("avgRespTime").toString().replace("\"", "");
        String qtdSuccess = jobject.get("qtdSuccess").toString().replace("\"", "");
        String qtdFailures = jobject.get("qtdFailures").toString().replace("\"", "");
        String hostAddress = jobject.get("hostAddress").toString().replace("\"", "");
        String repetitions = jobject.get("repetitions").toString().replace("\"", "");

        PingResponse r = new PingResponse();

        r.setStatus(status);
        r.setAvgRespTime(avgRespTime);
        r.setQtdSuccess(qtdSuccess);
        r.setQtdFailures(qtdFailures);
        r.setHostAddress(hostAddress);
        r.setRepetitions(repetitions);

        return r;
    }

    public static String removeBracket(String json) {
        return json;
        // .replace("[", "").replace("]", "").replace("\"", "\"\"");
    }

    public static PPPoECredentialsInfo getPPPoECredentialsInfo(StringResponseDTO a) {
        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();
        String username = jobject.get("Username").toString().replace("\"", "");
        String password = jobject.get("Password").toString().replace("\"", "");

        return new PPPoECredentialsInfo(username, password);
    }

    public static List<InterfaceStatistics> getInterfaceStatistics(StringResponseDTO a) {

        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonArray jarray = jelement.getAsJsonArray();

        List<InterfaceStatistics> list = new ArrayList<>();
        for (JsonElement jsonElement : jarray) {
            JsonObject jobject = jsonElement.getAsJsonObject();

            InterfaceStatistics i = new InterfaceStatistics();

            String operStatus = jobject.get("operStatus") != null ? jobject.get("operStatus").toString().replace("\"", "") : "";
            String ipAddress = jobject.get("ipAddress") != null ? jobject.get("ipAddress").toString().replace("\"", "") : "";
            if (operStatus.contentEquals("Up") && !(ipAddress.isEmpty())) {
                String ifType;
                if (jobject.get("ifType") != null) {
                    ifType = jobject.get("ifType").toString().replace("\"", "");
                } else if (jobject.get("iftype") != null) {
                    ifType = jobject.get("iftype").toString().replace("\"", "");
                } else {
                    ifType = "";
                }
                String adminStatus = jobject.get("adminStatus") != null ? jobject.get("adminStatus").toString().replace("\"", "") : "";
                String ifName = jobject.get("ifName") != null ? jobject.get("ifName").toString().replace("\"", "") : "";
                
                String ipAddrType = jobject.get("ipAddrType") != null ? jobject.get("ipAddrType").toString().replace("\"", "") : "";
                String macAddress = jobject.get("macAddress") != null ? jobject.get("macAddress").toString().replace("\"", "") : "";
                String bytesSent = jobject.get("bytesSent") != null ? jobject.get("bytesSent").toString().replace("\"", "") : "";
                String bytesRecv = jobject.get("bytesRecv") != null ? jobject.get("bytesRecv").toString().replace("\"", "") : "";
                String errSent = jobject.get("errSent") != null ? jobject.get("errSent").toString().replace("\"", "") : "";
                String errRecv = jobject.get("errRecv") != null ? jobject.get("errRecv").toString().replace("\"", "") : "";
                String pctSent = jobject.get("pctSent") != null ? jobject.get("pctSent").toString().replace("\"", "") : "";
                String pctRecv = jobject.get("pctRecv") != null ? jobject.get("pctRecv").toString().replace("\"", "") : "";
                String mcSent = jobject.get("mcSent") != null ? jobject.get("mcSent").toString().replace("\"", "") : "";
                String mcRecv = jobject.get("mcRecv") != null ? jobject.get("mcRecv").toString().replace("\"", "") : "";
                String bcSent = jobject.get("bcSent") != null ? jobject.get("bcSent").toString().replace("\"", "") : "";
                String bcRecv = jobject.get("bcRecv") != null ? jobject.get("bcRecv").toString().replace("\"", "") : "";

                i.setAdminStatus(adminStatus);
                i.setIpAddress(ipAddress);
                i.setBcRecv(bcRecv);
                i.setBcSent(bcSent);
                i.setBytesRecv(bytesRecv);
                i.setBytesSent(bytesSent);
                i.setErrRecv(errRecv);
                i.setErrSent(errSent);
                i.setIfName(ifName);
                i.setIfType(ifType);
                i.setIpAddrType(ipAddrType);
                i.setMacAddress(macAddress);
                i.setMcRecv(mcRecv);
                i.setMcSent(mcSent);
                i.setOperStatus(operStatus);
                i.setPctRecv(pctRecv);
                i.setPctSent(pctSent);

                list.add(i);
            }

        }

        return list;
    }

}
