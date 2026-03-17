package com.example.springbootapp;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;


class ResponseTransfer{
    private String message;
    public String getMessage(){
        return this.message;
    }
    public void setMessage(String message){
        this.message = message;
    }
}

@RestController
public class App {
    @GetMapping("/health")
    public String health(){
        return "Health is perfectly fine";
    }

    @RequestMapping(value = "/data" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseTransfer data(){
        var response = new ResponseTransfer();
        response.setMessage("health is perfectly fine");
        return response;
    }

    @RequestMapping(value="/data", method = RequestMethod.POST)
    @ResponseBody
    public ResponseTransfer postData(@RequestBody ResponseTransfer req){
        if(req instanceof ResponseTransfer){
            System.out.println(true);
        }
        System.out.println(req);
        ResponseTransfer data = new ResponseTransfer();
        data.setMessage("Thanks for the request data, got it " +req.getMessage());
        return data;
    }

}