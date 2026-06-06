package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtil {

    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtil(String filePath, String sheetName) {

        try {

            FileInputStream fis =
                    new FileInputStream(filePath);

            workbook =
                    new XSSFWorkbook(fis);

            sheet =
                    workbook.getSheet(sheetName);

            if (sheet == null) {

                throw new RuntimeException(
                        "Sheet not found: " + sheetName
                );
            }

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load Excel file: "
                            + filePath,
                    e
            );
        }
    }

    public String getCellData(int rowNum,
                              int colNum) {

        DataFormatter formatter =
                new DataFormatter();

        Row row =
                sheet.getRow(rowNum);

        if (row == null) {

            return "";
        }

        Cell cell =
                row.getCell(colNum);

        if (cell == null) {

            return "";
        }

        return formatter.formatCellValue(cell);
    }

    public int getRowCount() {

        return sheet.getLastRowNum();
    }

    public int getColumnCount() {

        return sheet
                .getRow(0)
                .getLastCellNum();
    }

    public void writeCellData(
            int rowNum,
            int colNum,
            String value) {

        Row row =
                sheet.getRow(rowNum);

        if (row == null) {

            row =
                    sheet.createRow(rowNum);
        }

        Cell cell =
                row.getCell(colNum);

        if (cell == null) {

            cell =
                    row.createCell(colNum);
        }

        cell.setCellValue(value);
    }

    public void saveWorkbook(String filePath) {

        try (FileOutputStream fos =
                     new FileOutputStream(filePath)) {

            workbook.write(fos);

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to save workbook",
                    e
            );
        }
    }

    public void closeWorkbook() {

        try {

            if (workbook != null) {

                workbook.close();
            }

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to close workbook",
                    e
            );
        }
    }
}