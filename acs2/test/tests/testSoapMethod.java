/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.alcatel.hdm.service.nbi2.NbiTemplate;
import dao.EquipamentoDAO;
import java.util.List;

/**
 *
 * @author G0042204
 */
public class testSoapMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            EquipamentoDAO d = new EquipamentoDAO();

            //d.listarEquipamentoPorSerial("c4a81dce6779");
            //NbiDeviceData findDeviceByGUID = d.findDeviceByGUID(new Long(23006));
            //System.out.println(findDeviceByGUID.getManufacturer());
//            List<NbiDeviceData> ds = d.listarEquipamentosPorMac("C4:A8:1D:CE:67:79");
//            for (NbiDeviceData detalhe : ds) {
//                System.out.println(detalhe.getSubscriberID());
//            }
            for (NbiTemplate arg : d.templates()) {
                System.out.println(arg.getName());
            }

        } catch (NBIException_Exception e) {
            System.out.println(e.getMessage());
        }

    }

}