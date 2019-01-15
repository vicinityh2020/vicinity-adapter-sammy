/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optionsnet.vicinity.adapter.services.impl;

import com.optionsnet.vicinity.adapter.pojos.Response;

import com.optionsnet.vicinity.adapter.services.AdapterService;

import com.optionsnet.vicinity.adapter.services.SammyService;
import com.optionsnet.vicinity.adapter.pojos.Requests;
import org.apache.commons.io.IOUtils;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dzandes
 */
@Service
public class AdapterServiceImpl implements AdapterService {
    
    private static final Logger LOG = Logger.getLogger(AdapterServiceImpl.class);

    @Autowired
    private SammyService sammyService;

    @Override
    public Response postAction(String oid, String aid, Requests.ActionRequest request) {
        
        LOG.info("Inside postAction - TBD by each pilot depending on their VAS...");
        
        Response resp_ = new Response("Not supported yet."); // TODO
        return resp_;
    }

    @Override
    public Response getActionTask(String oid, String aid, String tid) {
        
        LOG.info("Inside getActionTask - TBD by each pilot depending on their VAS...");
        
        Response resp_ = new Response("Not supported yet."); // TODO
        return resp_;
    }

    @Override
    public Response deleteActionTask(String oid, String aid, String tid) {
        
        LOG.info("Inside deleteActionTask - TBD by each pilot depending on their VAS...");
      
        Response resp_ = new Response("Not supported yet."); // TODO
        return resp_;
    }

    @Override
    public Response getProperty(String oid, String pid) {
        
        LOG.info("Inside getProperty - Will proceed to read SaMMy platform");

        //sammyService = new SammyService();

        //Response resp_ = new Response("Not supported yet 1234."); // TODO
        Response resp_ = new Response(JSONObject.valueToString(sammyService.getIoTValue(pid)));
        return resp_;
    }

    @Override
    public Response putProperty(String oid, String pid, Requests.PropertyRequest request) {
        
        LOG.info("Inside putProperty - TBD by each pilot depending on their VAS...");
        
        Response resp_ = new Response("Not supported yet."); // TODO
        return resp_;
    }

    @Override
    public Response putEvent(String oid, String eid, Requests.PropertyRequest request) {
        
        LOG.info("Inside putEvent - TBD by each pilot depending on their VAS...");
        
        Response resp_ = new Response("Not supported yet."); // TODO
        return resp_;
    }
    
    @Override
    public Response getThingsDescription() {
        
        LOG.info("Inside getThingsDescription - TBD by each pilot depending on their VAS/Things...");
        
        ClassLoader cl = getClass().getClassLoader();
        
        String thingsDescription = "";
        try {
            thingsDescription = IOUtils.toString(cl.getResourceAsStream("things-sammy.json"));
        } catch (Exception ex) {
            LOG.error("Unable to load Things Description...");
            ex.printStackTrace();
        }
        
        Response resp_ = new Response(thingsDescription);
        return resp_;
    }
    
}
