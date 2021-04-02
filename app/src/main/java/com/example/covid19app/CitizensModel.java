package com.example.covid19app;

import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CitizensModel {

    private  String api_url ="http://192.168.8.100:44373/api/citizen/";
    private RestTemplate restTemplate=new RestTemplate();

    public List<Citizen> findAll(){
        try{
            return restTemplate.exchange(
                    api_url + "findall",
                    HttpMethod.GET,null,
                    new ParameterizedTypeReference<List<Citizen>>() {
                    }
            ).getBody();
        }
        catch (Exception e1){
            return  null;
        }
    }

    public List<Citizen> find(String id){
        try{
            return restTemplate.exchange(
                    api_url + "find/",
                    HttpMethod.GET,null,
                    new ParameterizedTypeReference<List<Citizen>>() {
                    }
            ).getBody();
        }
        catch (Exception e1){
            return  null;
        }
    }


    public boolean add(Citizen citizen){
        try
        {
            Map<String,String> items = new HashMap<String,String>();
            items.put("fname",citizen.getFname());
            items.put("age", String.valueOf(citizen.getAge()));
            items.put("address",citizen.getAddrress());
            items.put("lat",String.valueOf(citizen.getLat()));
            items.put("lang",String.valueOf(citizen.getLang()));
            items.put("professin",citizen.getProfessin());
            items.put("email",citizen.getEmail());
            items.put("affiliation",citizen.getAffiliation());
            items.put("password",citizen.getPassword());
            items.put("healthStatus",citizen.getHealthStatus());

            JSONObject jsonObject=new JSONObject(items);
            HttpHeaders headers=new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity=new HttpEntity<String>(jsonObject.toString(), headers);
            restTemplate.put(api_url + "update",entity);
            return  true;

        }

        catch(Exception e)
        {
            return false;
        }
    }
}


