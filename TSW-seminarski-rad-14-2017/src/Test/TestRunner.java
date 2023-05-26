package Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) throws SecurityException, IOException {

		Logger l = Logger.getLogger(TestRunner.class.toString());
				
		Result result = JUnitCore.runClasses(RegistrationTest.class);

		for(Failure f: result.getFailures()) 
		{
			l.warning(f.toString());
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("Opposite-report.txt", true));
		
		writer.newLine();
		writer.append("RegistrationTest ---> vrši se testiranje registracije korisnika: " +result.wasSuccessful());
		l.info("Test registracija: " +result.wasSuccessful());
		
		writer.newLine();
		result = JUnitCore.runClasses(LogInTest.class);
		writer.append("LogInTest ---> vrši se testiranje prijave korisnika na sajt: " +result.wasSuccessful());
		l.info("Test prijave korisnika: " +result.wasSuccessful());
		
		writer.newLine();
		result = JUnitCore.runClasses(CheckRegisterDataTest.class);
		writer.append("CheckRegisterDataTest ---> vrši se testiranje podataka korisnika, da li su podaci pri registraciji identièni sa podacima pri prijavi: " +result.wasSuccessful());
		l.info("Test provere podataka korisnika: " +result.wasSuccessful());
		
		writer.newLine();
		result = JUnitCore.runClasses(ThreeProductsTest.class);
		writer.append("ThreeProductsTest ---> vrši se testiranje dodavanja tri proizvoda u korpu: " +result.wasSuccessful());
		l.info("Test dodavanje tri proizvoda u korpu: " +result.wasSuccessful());

		writer.newLine();
		result = JUnitCore.runClasses(RemoveProductsFromCartTest.class);
		writer.append("RemoveProductsFromCartTest ---> vrši se testiranje brisanja proizvoda iz korpe: " +result.wasSuccessful());
		l.info("Test brisanja proizvoda iz korpe: " +result.wasSuccessful());

		writer.newLine();
		result = JUnitCore.runClasses(AddAddressTest.class);
		writer.append("AddAddressTest ---> vrši se testiranje dodavanja nove adrese korisnika: " +result.wasSuccessful());
		l.info("Test dodavanja nove adrese korisnika: " +result.wasSuccessful());

		writer.newLine();
		result = JUnitCore.runClasses(CheckCartTest.class);
		writer.append("CheckCartTest ---> vrši se testiranje cene proizvoda u korpi, da li su iz razlièitih kategorija kao i da li se u korpi nalazi tri proizvoda: " +result.wasSuccessful());
		l.info("Test provere cene u korpi: " +result.wasSuccessful());

		writer.newLine();
		result = JUnitCore.runClasses(TitleTest.class);
		writer.append("TitleTest ---> vrši se testiranje naslova stranice: " +result.wasSuccessful());
		l.info("Test naslov stranice: " +result.wasSuccessful());

		writer.newLine();
		result = JUnitCore.runClasses(UrlTest.class);
		writer.append("UrlTest ---> vrši se testiranje URL-a web stranice: " +result.wasSuccessful());
		l.info("Test URL web stranice: " +result.wasSuccessful());

		writer.newLine();
		result = JUnitCore.runClasses(PerformanceTest.class);
		writer.append("PerformanceTest ---> vrši se testiranje proseènog otvaranja pet razlièitih stranica: " +result.wasSuccessful());
		l.info("Test performansi otvaranja pet razlièitih strana: " +result.wasSuccessful());

		writer.newLine();
		result = JUnitCore.runClasses(CompanyDataTest.class);
		writer.append("CompanyDataTest ---> vrši se prikupljanje podataka o kompaniji i upisivanje u .txt fajl: " +result.wasSuccessful());
		l.info("Test podaci o kompaniji: "  +result.wasSuccessful());
		
		writer.newLine();
		writer.close();
		
		l.info("Broj testova koji padaju ---> " +result.getFailureCount());
		l.info("Vreme izvršavanja testova ---> " +result.getRunTime());
		l.info("Broj testova koji prolaze ---> " +(result.getRunCount()-result.getFailureCount()-result.getIgnoreCount()));

	}

}
