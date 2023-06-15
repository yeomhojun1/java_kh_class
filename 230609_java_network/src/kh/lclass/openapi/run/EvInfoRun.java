package kh.lclass.openapi.run;

import kh.lclass.openapi.controller.EvInforController;

public class EvInfoRun {

	public static void main(String[] args) {
		EvInforController evInfoCtrl = new EvInforController();
		evInfoCtrl.getEvIfoAll();
		
	}

}
