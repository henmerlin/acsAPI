/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.junit.consulta.equipamento;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class GetInterfaceStatisticsJUnitTest {

    public GetInterfaceStatisticsJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getInterfaceStatistics() {
        try {
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceData eqp;

            eqp = d.findDeviceByGUID(new Long(82018));

            d.getInterfaceStatistics(eqp);

            assertTrue(true);

        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
    }
}
