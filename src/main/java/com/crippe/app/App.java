package com.crippe.app;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class App {
    public static void main(String[]args) {
        String date = "N/A";
        HashMap<String, Person> sshl = new HashMap<String, Person>();

        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String name = " ";
                String id = " ";
                String lunch = " ";
                if (data.contains("<timestamp>")) {
                    date = data.substring(11, 22);
                }
                
                if (data.contains("<description>Giltigt kort "))
                    {
                        name = data.substring(data.indexOf("kort ")+5, data.indexOf(" vid"));

                        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(data);
                        while(m.find()) {
                            id = m.group(1);
                        }

                        if (data.contains("Personal lunchläsare")){
                            lunch = "Personal";
                        }else if(data.contains("Pedagogisk lunchläsare")){
                            lunch = "Pedagogisk";
                        }else if(data.contains("Representativ lunchläsare")){
                            lunch = "Representativ";
                        }else{
                            lunch = "ERROR";
                        }
                        //System.out.println(name + " " + id + " " + lunch + " " + date);

                        if(sshl.containsKey(id)){
                            if(!sshl.get(id).foundDate(date)){
                                sshl.get(id).countLunch(lunch);
                                sshl.get(id).addDate(date);    
                            }else{
                                System.out.println("Duplicate date {" + date + "} found for " + name+ ". Discarded");
                                System.out.println(" ");
                            }                            
                        }else{
                            sshl.put(id, new Person(name, id, date));
                            sshl.get(id).countLunch(lunch);
                        }
                        
                        //sshl.get(id).printAll();
                    }
            }
            myReader.close();
            for (String i : sshl.keySet()) {
                sshl.get(i).printAll();
                System.out.println(" ");
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    
    
        try {
            String filename = "NewExcelFile.xls" ;
            if(args.length == 2){
                filename = args[1];
            }
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");    

            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("ID");
            rowhead.createCell(1).setCellValue("Name");
            rowhead.createCell(2).setCellValue("Personal Lunch");
            rowhead.createCell(3).setCellValue("Pedagogisk Lunch");
            rowhead.createCell(3).setCellValue("Representativ Lunch");
            int n = 1;
            for (String i : sshl.keySet()) {
                HSSFRow row = sheet.createRow((short)n);
                row.createCell(0).setCellValue(sshl.get(i).getID());
                row.createCell(1).setCellValue(sshl.get(i).getName());
                row.createCell(2).setCellValue(sshl.get(i).getPersonal());
                row.createCell(3).setCellValue(sshl.get(i).getPedagogisk());
                row.createCell(4).setCellValue(sshl.get(i).getRepresentativ());
                n++;
            }
            // HSSFRow row = sheet.createRow((short)1);
            // row.createCell(0).setCellValue("1");
            // row.createCell(1).setCellValue("Sankumarsingh");
            // row.createCell(2).setCellValue("India");
            // row.createCell(3).setCellValue("sankumarsingh@gmail.com");
            
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Excel file created!");

        } catch ( Exception ex ) {
            System.out.println(ex);
        }
    }
}
