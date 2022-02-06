package edu.wsu.backendapi.service;

import edu.wsu.backendapi.dao.NewTemplateDao;

import javax.ws.rs.core.HttpHeaders;
import java.util.HashMap;

public class RdsService {

    public String getAllTemplates(HttpHeaders headers) throws Exception {
        NewTemplateDao templateDao = new NewTemplateDao();
        String output = templateDao.getAll();
        return output;
    }

    public String postTemplate(HashMap<String,Object> input, HttpHeaders headers) throws Exception {
        NewTemplateDao templateDao = new NewTemplateDao();
        String output = templateDao.post(input);
        return output;
    }

    public String getTemplateById(HashMap<String,Object> input, HttpHeaders headers) throws Exception {
        NewTemplateDao templateDao = new NewTemplateDao();
        String output = templateDao.getById(input);
        return output;
    }

    public String deleteTemplate(HashMap<String,Object> input, HttpHeaders headers) throws Exception {
        NewTemplateDao templateDao = new NewTemplateDao();
        String output = templateDao.delete(input);
        return output;
    }

    public String updateTemplateById(HashMap<String,Object> input, HttpHeaders headers) throws Exception {
        NewTemplateDao templateDao = new NewTemplateDao();
        String output = templateDao.update(input);
        return output;
    }
}
