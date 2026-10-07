
        package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataReader {

    public static Object[][] getCheckoutData() throws IOException {

        String filePath =
                "src/test/resources/testdata/checkoutData.xlsx";

        FileInputStream fileInputStream =
                new FileInputStream(filePath);

        Workbook workbook =
                WorkbookFactory.create(fileInputStream);

        Sheet sheet =
                workbook.getSheet("Sheet1");

        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();

        Object[][] data =
                new Object[rowCount][columnCount];

        for (int i = 1; i <= rowCount; i++) {

            Row row = sheet.getRow(i);

            for (int j = 0; j < columnCount; j++) {

                Cell cell = row.getCell(
                        j,
                        Row.MissingCellPolicy.CREATE_NULL_AS_BLANK
                );

                data[i - 1][j] = cellToString(cell);
            }
        }

        workbook.close();
        fileInputStream.close();

        return data;
    }

    private static String cellToString(Cell cell) {

        if (cell == null || cell.getCellType() == CellType.BLANK) {
            return "";
        }

        if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((long) cell.getNumericCellValue());
        }

        return cell.toString().trim();
    }
}

