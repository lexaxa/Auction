package com.govauction.business;

import com.govauction.view.LotView;
import org.junit.*;

public class LotManagerTest {
    
    public LotManagerTest() {
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

    /**
     * Test of addLot method, of class LotManager.
     */
    public int test = 10;
    @Test
    public void addLot() {
        System.out.println("addLot:" + test);
        LotManager lm = new LotManager();
        LotView lv = new LotView();
        //lm.addLot(lv);
    }
    
    @Test
    public void simpleTest() {
        try {
            LotManager lm = new LotManager();
            LotView lv = new LotView();
            lm.addLot(lv);
            Assert.fail();
        } catch(Exception e) {
            
        }
        
    }
}