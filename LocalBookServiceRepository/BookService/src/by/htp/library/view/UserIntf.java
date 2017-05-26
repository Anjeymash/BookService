package by.htp.library.view;

import by.htp.library.controller.Controller;

public class UserIntf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller cont = new Controller();
		//String request = "ADD_BOOK Ccmm+ JJJJ 2007mfm";
		String request1 = "FND_BOOK Ruby";
		//String request2 = "DEL_BOOK C++ JJJ J 2007";
		System.out.println(cont.executeTask(request1));
		// System.out.println(cont.executeTask(request2));
		// cont.executeTask(request2);
	}

}
