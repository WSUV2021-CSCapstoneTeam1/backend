package edu.wsu.backendapi.service;

import edu.wsu.backendapi.dao.TemplateDao;
import edu.wsu.backendapi.dao.TeamDao;

import javax.ws.rs.core.HttpHeaders;
import java.util.HashMap;

public class RdsService {
//test add
    public String getAllTeams(HttpHeaders headers) throws Exception {
        TeamDao teamDao = new TeamDao();
        String output = teamDao.getAll();
        return output;
    }

    public String getAllTemplates(HttpHeaders headers) throws Exception {
        TemplateDao templateDao = new TemplateDao();
        String output = templateDao.getAll();
        return output;
    }

    public String postTemplate(HashMap<String,Object> input, HttpHeaders headers) throws Exception {
        TemplateDao templateDao = new TemplateDao();
        String output = templateDao.post(input);
        return output;
    }

    public String getTemplateById(HashMap<String,Object> input, HttpHeaders headers) throws Exception {
        TemplateDao templateDao = new TemplateDao();
        String output = templateDao.getById(input);
        return output;
    }

    public String deleteTemplate(HashMap<String,Object> input, HttpHeaders headers) throws Exception {
        TemplateDao templateDao = new TemplateDao();
        String output = templateDao.delete(input);
        return output;
    }

    public String updateTemplateById(HashMap<String,Object> input, HttpHeaders headers) throws Exception {
        TemplateDao templateDao = new TemplateDao();
        String output = templateDao.update(input);
        return output;
    }
}
