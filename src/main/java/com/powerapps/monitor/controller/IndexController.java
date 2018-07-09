package com.powerapps.monitor.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.powerapps.monitor.service.ErrorFragmentIsolator;

@Controller
public class IndexController {
  
  @Autowired
  ErrorFragmentIsolator errorService;
  
  @RequestMapping("/")
  public String index() {
     return "dashboard";
  }
  
  
  @RequestMapping(value = "/seerrorreport", method = RequestMethod.GET)
  //@GetMapping(value = "/seerrorrepor")
  public String serviceEngineErrorLogReport(Model model) {
    final File logFile = new File("/home/joshua/Desktop/HLBB/eCollect_batches_notifications/ServerError.log");
    model.addAttribute("errorReport", errorService.execute(logFile));
     return "dash-errorlogreport";
  }
  
  
  
  @RequestMapping("/email")
  public String email() {
     return "emailSettingsForm";
  }
  
  
  @RequestMapping("/greeting")
  public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
      model.addAttribute("name", name);
      return "greeting";
  }

}