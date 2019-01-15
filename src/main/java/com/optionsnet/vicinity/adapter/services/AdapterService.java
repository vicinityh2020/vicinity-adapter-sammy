/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.optionsnet.vicinity.adapter.services;

import com.optionsnet.vicinity.adapter.pojos.Response;
import com.optionsnet.vicinity.adapter.pojos.Requests;
import org.springframework.stereotype.Service;

/**
 *
 * @author dzandes
 */
@Service
public interface AdapterService {
    
    /**
     * 
     * @param oid
     * @param aid
     * @param request
     * @return 
     */
    Response postAction(String oid, String aid, Requests.ActionRequest request);
    
    /**
     * 
     * @param oid
     * @param aid
     * @param tid
     * @return 
     */
    Response getActionTask(String oid, String aid, String tid);
    
    /**
     * 
     * @param oid
     * @param aid
     * @param tid
     * @return 
     */
    Response deleteActionTask(String oid, String aid, String tid);
    
    /**
     * 
     * @param oid
     * @param pid
     * @return 
     */
    Response getProperty(String oid, String pid);
    
    /**
     * 
     * @param oid
     * @param pid
     * @param request
     * @return 
     */
    Response putProperty(String oid, String pid, Requests.PropertyRequest request);
    
    /**
     * 
     * @param oid
     * @param eid
     * @param request
     * @return 
     */
    Response putEvent(String oid, String eid, Requests.PropertyRequest request);
    
    /**
     * 
     * @return 
     */
    Response getThingsDescription();
}
