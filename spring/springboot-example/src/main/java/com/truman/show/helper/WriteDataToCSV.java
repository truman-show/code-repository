package com.truman.show.helper;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.truman.show.domain.Tutorial;
import java.io.PrintWriter;
import java.util.List;

public class WriteDataToCSV {
  public static void writeObjectToCSV(PrintWriter writer, List<Tutorial> Tutorials) {
    String[] CSV_HEADER = {"아이디", "성", "name"};
    StatefulBeanToCsv<Tutorial> beanToCsv;
    try (
        CSVWriter csvWriter = new CSVWriter(writer,
            CSVWriter.DEFAULT_SEPARATOR,
            CSVWriter.NO_QUOTE_CHARACTER,
            CSVWriter.DEFAULT_ESCAPE_CHARACTER,
            CSVWriter.DEFAULT_LINE_END)
    ) {

      csvWriter.writeNext(CSV_HEADER);
//
//      for (Tutorial tutorial : Tutorials) {
//        String[] data = {
//            tutorial.getTitle(),
//            tutorial.getDescription(),
//            String.valueOf(tutorial.getId())
//        };
//
//        csvWriter.writeNext(data);
//      }
//
//      System.out.println("Write CSV using CSVWriter successfully!");

      // write List of Objects
      ColumnPositionMappingStrategy<Tutorial> mappingStrategy =
          new ColumnPositionMappingStrategy<>();

      mappingStrategy.setType(Tutorial.class);
      mappingStrategy.setColumnMapping(CSV_HEADER);

      beanToCsv = new StatefulBeanToCsvBuilder<Tutorial>(writer)
          .withMappingStrategy(mappingStrategy)
          .withQuotechar(CSVWriter.DEFAULT_SEPARATOR)
          .build();
      writer.flush();
      beanToCsv.write(Tutorials);

      System.out.println("Write CSV using BeanToCsv successfully!");
    } catch (Exception e) {
      System.out.println("Writing CSV error!");
      e.printStackTrace();
    }
  }
}
