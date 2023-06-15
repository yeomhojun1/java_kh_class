package kh.lclass.openapi.controller;



import kh.lclass.openapi.model.service.EvInfoService;

public class EvInforController {
	 public void getEvIfoAll() {
		 	Thread service = new EvInfoService();
		 	service.start();
	       
	    }
}
