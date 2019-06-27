/*
 * Copyright © 2019 OptionsNet.
 * All rights reserved.
 *
 * This file is part of SaMMY@VICINITY adapter.
 *
 * SaMMY@VICINITY adapter is free software: you can redistribute it
 * and/or modify it under the terms of GNU GPL.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT ANY WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT, IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * See README file for the full disclaimer information and LICENSE file for full license information in the project root.
 */

package com.optionsnet.vicinity.adapter.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.optionsnet.vicinity.adapter.pojos.sammy.IotDTO;
import com.optionsnet.vicinity.adapter.pojos.sammy.SammyDTO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class SammyService {

    private Logger LOG = LoggerFactory.getLogger(SammyService.class);

    @Value("${sammy.protocol}")
    private String sammyProtocol;
    @Value("${sammy.host}")
    private String sammyHost;
    @Value("${sammy.port}")
    private Integer sammyPort;
    @Value("${sammy.path}")
    private String sammyPath;
    @Value("${sammy.user}")
    private String sammyUser;
    @Value("${sammy.pass}")
    private String sammyPass;
    @Value("${sammy.marinaId}")
    private String sammyMarinaId;


    private final RestTemplate restTemplate;

    public SammyService() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.setConnectTimeout(5000).setReadTimeout(5000).build();
    }

    public JSONObject getIoTValue(String name) {
        LOG.info("Request read property with pid = " + name);

        JSONObject r = new JSONObject();
        String v = readSammy().get(name);
        r.put("value", v);

        LOG.info("Value of property found = " + v);
        return r;
    }

    private HashMap<String, String> readSammy() {
        HashMap<String, String> values = new HashMap<>();

        //initialize headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        //set basic authentication
        String plainCreds = sammyUser + ":" + sammyPass;
        String base64Creds = new String(Base64.encodeBase64(plainCreds.getBytes()));
        headers.add("Authorization", "Basic " + base64Creds);

        //add request parameters to headers
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("idm", sammyMarinaId);

        //set request with headers abd parameters
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        //request data from SaMMY platform
        ResponseEntity<SammyDTO> response = restTemplate.postForEntity(buildSammyURL(), request, SammyDTO.class);
        LOG.info("Response status from SaMMY platform: " + response.getStatusCode().toString());
        LOG.debug("Response message from SaMMY platform: "+ response.getBody());

        //get values from SaMMY response
        SammyDTO sammyDTO = new ObjectMapper().convertValue(response.getBody(), SammyDTO.class);
        for (IotDTO iot : sammyDTO.getIot()) {
            values.put(iot.name, iot.value);
        }

        return values;
    }

    private String buildSammyURL() {
        return sammyProtocol + "://" + sammyHost + ":" + sammyPort + "/" + sammyPath;
    }
}
