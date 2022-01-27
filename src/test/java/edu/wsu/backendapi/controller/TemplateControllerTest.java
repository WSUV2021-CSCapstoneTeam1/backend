package edu.wsu.backendapi.controller;

import edu.wsu.backendapi.dao.TemplateDao;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TemplateControllerTest {
/*
    private TemplateController testGetAll;

    @BeforeEach
    void createTemplateCon() {
        testGetAll = new TemplateController();
    }

    @Test
    @DisplayName("Testing that function does not throw exception")
    void templateAssert() throws SQLException {
        JSONObject TestObj = new JSONObject();
        TestObj.put("id", 123);
        TestObj.put("name", "Name One");
        TestObj.put("description", "This is a description");
        String TestObjStr = TestObj.toString();

        //MOCK for testing TemplateDao.getTemplateAllRds()
        TemplateDao tempGetRds = mock(TemplateDao.class);
        when(tempGetRds.getTemplateAllRds()).thenReturn(TestObjStr);
        //System.out.println(MockTempDao.getTemplateAllRds());

        //MOCK for testing TemplateController.templateGetAllRds()
        //System.out.println(testGetAll.templateGetAllRds());

        assertNotNull(testGetAll.templateGetAllRds());
        String retVal = String.valueOf(testGetAll.templateGetAllRds());
        assertFalse(retVal.isEmpty());
        System.out.println(retVal);
        assertTrue(true);

    }
*/
    @Test
    @DisplayName("Get Templates By ID Tests")
    void getTemplateByIdTests() throws SQLException {
        JSONObject TestObj = new JSONObject();
        TestObj.put("id", 123);
        TestObj.put("name", "Name One");
        TestObj.put("description", "This is a description");
        String TestObjStr = TestObj.toString();

        TemplateController testGetAll = spy(new TemplateController());
        //MOCK for testing TemplateDao.getTemplateAllRds()
        TemplateDao MockTempDao = mock(TemplateDao.class);
        when(MockTempDao.getTemplateAllRds()).thenReturn(TestObjStr);
        //System.out.println(MockTempDao.getTemplateAllRds());
        when(testGetAll.templateGetAllRds()).thenReturn(MockTempDao);
        //MOCK for testing TemplateController.templateGetAllRds()
        System.out.println(testGetAll.templateGetAllRds());

        assertNotNull(testGetAll);
        assertTrue(true);

    }


}