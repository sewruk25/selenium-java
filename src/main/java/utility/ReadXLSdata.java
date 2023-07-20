package utility;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadXLSdata {


    public static void main(String[] args) throws IOException {
        ReadXLSdata read = new ReadXLSdata();
        read.getData("login");
    }
    public String[][] getData(String excelSheetName) throws IOException {


        // Dostaję się do wybranego arkusza \/
        File file = new File(System.getProperty("user.dir")+"/src/main/resources/testdata.xlsx"); //jak chcę przeczytać excela najpierw biorę klasę File i znajduje plik który będę czytał "user.dir" to miejsce z którego uruchomiona jest java
        FileInputStream fis = new FileInputStream(file); //betoda używana do odczytu strumieni bajtów
        Workbook wb = WorkbookFactory.create(fis); // Workbook służy do tworzenia arkuszy w excelu
        Sheet sheetName = wb.getSheet(excelSheetName); // klasa Sheet reprezentuje arkusz

        // Musimy dodać taką logikę żeby nasza metoda która będzie odczytywać excela nie była podatna na dynamiczne zmiany pliku
        int totalRows = sheetName.getLastRowNum(); // zwracamy liczbe wierszy w pliku
        System.out.println(totalRows);
        Row rowCells = sheetName.getRow(0);
        int totalCollumns = rowCells.getLastCellNum(); // ilośc kolumn w wierszu
        System.out.println(totalCollumns);

        //Muszę sformatować dane z excela
        DataFormatter format = new DataFormatter();

        //Tworzę pętle które przejdą przez wiersze i kolumny

        String testData [][]=new String[totalRows][totalCollumns];
        for(int i=1; i<=totalRows;i++){
            for(int j=0;j<totalCollumns;j++){
                testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.println(testData[i-1][j]);
            }
        }

        return testData;



    }

}
