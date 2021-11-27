package com.truman.show.service;

import com.truman.show.domain.Tutorial;
import com.truman.show.helper.CSVHelper;
import com.truman.show.helper.WriteDataToCSVbyOpenCSV;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CSVService {

  private final List<Tutorial> TUTORIALS = List.of(
      Tutorial.builder()
          .id(1).description("설명1").published(true).title("안녕하세요1")
          .build()
      , Tutorial.builder()
          .id(2).description("설명2").published(false).title("안녕하세요2")
          .build());

  public ByteArrayInputStream load() {
    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(TUTORIALS);
    return in;
  }

  public ByteArrayInputStream load2() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintWriter writer = new PrintWriter(byteArrayOutputStream);
    return WriteDataToCSVbyOpenCSV.writeObjectToCSV(writer, TUTORIALS);
  }

}
