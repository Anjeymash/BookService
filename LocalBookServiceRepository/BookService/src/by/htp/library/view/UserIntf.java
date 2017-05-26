package by.htp.library.view;

import by.htp.library.controller.Controller;

public class UserIntf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller cont = new Controller();
	
		String request1 = "FND_BOOK Java";
		String request2 = "DEL_BOOK PHP Lerdorf 2015";
		String request3 = "CHANGE_BOOK Java Eckel 2016-Java Eckel 2020";
		String request4 = "ADD_BOOK PHP Lerdorf 2015";
		
		//System.out.println(cont.executeTask(request1));
		//System.out.println(cont.executeTask(request2));
		//System.out.println(cont.executeTask(request3));
		System.out.println(cont.executeTask(request4));
	}

}
