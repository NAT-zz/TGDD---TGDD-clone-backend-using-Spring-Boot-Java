package hcmute.edu.tgdd.statistics;

import hcmute.edu.tgdd.model.CartDetail;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import java.util.List;

public class ExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<CartDetail> cartDetailList;

    public ExcelExporter(List<CartDetail> cartDetailList) {
        this.cartDetailList = cartDetailList;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("CartDetail");
    }

    private void writeHeaderRows(){
        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("STT");

        cell = row.createCell(1);
    cell.setCellValue("Tên sản phẩm");

        cell = row.createCell(2);
        cell.setCellValue("Id sản phẩm");

        cell = row.createCell(3);
        cell.setCellValue("Số lượng bán được");

        cell = row.createCell(4);
        cell.setCellValue("Đơn giá");

        cell = row.createCell(5);
        cell.setCellValue("Số tiền thu được");
    }

    private void writeDataRows(){

    }

    public void export(){
        writeHeaderRows();
        writeDataRows();
    }
}
