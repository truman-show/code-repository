package com.truman.show;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCsv {
  public static void writeDataToCsv(String filePath) throws IOException {
    //CSVWriter 로 csv 파일을 쓴다.
    CSVWriter writer = new CSVWriter(new PrintWriter(filePath));
    String[] entries = "EW#City#State".split("#");  // 1
    writer.writeNext(entries);  // 2

    String[] entries1 = {"W", "Youngstown", "OH"};  // 3
    writer.writeNext(entries1);

    String[] entries2 = {"W", "Williamson", "WV"};
    writer.writeNext(entries2);

    writer.close();
  }

  public static void main(String args[]) throws Exception {
    //writeDataToCsv("./sample.csv");

    Path path = Paths.get("./writtenBean.csv");
    writeCsvFromBean(path);
  }


  // 스프링 response Resource 로 반환하는 방법?


  // bean 을 읽어서 csv 파일 생성하기
  public static void writeCsvFromBean(Path path) throws Exception {
    Writer writer  = new FileWriter(path.toString());

    StatefulBeanToCsv sbc = new StatefulBeanToCsvBuilder(writer)
        .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
        .build();

    List<CsvBean> list = new ArrayList<>();
    list.add(new WriteExampleBean("Test1", "sfdsf", "fdfd"));
    list.add(new WriteExampleBean("Test2", "ipso", "facto"));

    sbc.write(list);
    writer.close();
//    return Helpers.readFile(path);  // 파일을 읽어들어서 콘솔에 출력
  }

  // 파일을 만들기는 했다.
  // 만든 파일을 response body에 넣으려면 어떻게해야할까?

  private static class CsvBean {
    private WriteExampleBean writeExampleBean;
  }

  private static class WriteExampleBean extends CsvBean{
    private String temp1;
    private String temp2;
    private String temp3;

    public WriteExampleBean(String temp1, String temp2, String temp3) {
      this.temp1 = temp1;
      this.temp2 = temp2;
      this.temp3 = temp3;
    }
  }

  private static class Helpers {
    /**
     * Simple File Reader
     */
    public static String readFile(Path path) {
      String response = "";
      try {
        FileReader fr = new FileReader(path.toString());
        BufferedReader br = new BufferedReader(fr);
        String strLine;
        StringBuffer sb = new StringBuffer();
        while ((strLine = br.readLine()) != null) {
          sb.append(strLine);
        }
        response = sb.toString();
        System.out.println(response);
        fr.close();
        br.close();
      } catch (Exception ex) {
      }
      return response;
    }
  }
}
