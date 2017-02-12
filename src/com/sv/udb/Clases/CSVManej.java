/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Clases;
import com.csvreader.CsvWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis
 */
public class CSVManej {
 
    public void Save (List<Gasolinera> Nuevo)
    {       
//        usuarios.add(new Usuario("1002","Saul","Gaviria Garcia","sgaviria12@gmail.com"));
//        usuarios.add(new Usuario("1003","Maria","Torres Mendoza","mtorres12@yahoo.com"));
         
        String outputFile = "src\\com\\sv\\udb\\files\\datos.csv";
        boolean alreadyExists = new File(outputFile).exists();
         
        if(alreadyExists)
        {
            File ficheroUsuarios = new File(outputFile);
            ficheroUsuarios.delete();
        }        
         
        try {
         
            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
             
            csvOutput.write("Nombre");
            csvOutput.write("Tipo");
            csvOutput.write("Cantidad en galones");
            csvOutput.write("Total");
            csvOutput.endRecord();
             
            for(Gasolinera us : Nuevo)
            {
//                System.out.println("hola");
                csvOutput.write(us.getNombre());
                csvOutput.write(us.getTipo()+"");
                csvOutput.write(us.getCantidad()+"");
                csvOutput.write(us.getPago()+"");
                csvOutput.endRecord();                   
            }
             
            csvOutput.close();
         
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
   
    }
    public List<Gasolinera> getData()
    {
        List<Gasolinera> resp = null;
        try
        {
            String csvFile = "com/sv/udb/files/datos.csv";
            File file = new File(ClassLoader.getSystemResource(csvFile).getFile());
            String line = "";
            String simb = ",";
            if(file.exists())
            {
                resp = new ArrayList<>();
                BufferedReader br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine()) != null)
                {
                    String[] nota = line.split(simb);
                    Gasolinera obj = new Gasolinera();
                    obj.setNombre(nota[0]);
                    obj.setTipo(Double.parseDouble(nota[1]));
                    obj.setCantidad(Double.parseDouble(nota[2]));
                    obj.setPago(Double.parseDouble(nota[3]));
                    
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    return resp;
    }
    
        
    }
    

