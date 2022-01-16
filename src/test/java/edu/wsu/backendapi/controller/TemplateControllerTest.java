package edu.wsu.backendapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemplateControllerTest {

    private TemplateController testGetAll;

    @BeforeEach
    void createTemplateCon() {
        testGetAll = new TemplateController();
    }

    @Test
    @DisplayName("Testing that function does not throw exception")
    void templateAssert() {
        assertNotNull(testGetAll);

        System.out.println("tested OK");

    }
}