package startup;

import controller.Controller;
import integration.ExternalSystemsCreator;
import integration.Printer;
import view.View;

public class Main {
public static void main(String[] args) {
	Controller contr= new Controller();
	Printer printer = new Printer();
	View view = new View(contr);
	ExternalSystemsCreator externalSystemsCreator= new ExternalSystemsCreator();
	System.out.println("hej");
}
}
