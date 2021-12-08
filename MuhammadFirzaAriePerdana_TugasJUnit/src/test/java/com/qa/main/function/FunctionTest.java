package com.qa.main.function;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.juaracoding.sqa.Function.Function;

public class FunctionTest {
Function function;
	@Before
	public void setUp() throws Exception {
		function = new Function();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testKecepatanrata() {
		for (String isi : readfile("skenario_kecepatan.csv")) {
			String [] data = isi.split(";");
			
			String jarak = data[0];
			String waktu = data[1];
			String jawab = data[2];
			
			assertEquals(Double.parseDouble(jawab), function.kecepatanrata(Double.parseDouble(jarak),Double.parseDouble(waktu)));
			
		}
	}
	
	public List<String> readfile(String namefile){
		List<String> penampung = new ArrayList<String>();
		
		try {
			File myFile = new File(namefile);
//			InputStream myFile = getClass().getClassLoader().getResourceAsStream("skenario_kecepatan.csv");
			Scanner reader = new Scanner(myFile);
			
			while(reader.hasNextLine()) {
				penampung.add(reader.nextLine());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return penampung;
	}

}
