package com.vnpt.salary.view;

import com.vnpt.salary.entity.Record;
import com.vnpt.salary.entity.TimeLine;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.stream.Collectors;

public class RecordBar {
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("EEE dd/MM/yyyy");

    @FXML
    private Label index;
    @FXML
    private Label date;
    @FXML
    private Label param;
    @FXML
    private Label time;
    @FXML
    private Label status;


    private Record record;

    public RecordBar(int index, Record record) {
        this.record = record;
        this.index.setText(String.valueOf(index));
        init();
    }

    public void init(){
        String pr = record.getTimeLines().stream()
                .filter(Objects::nonNull)
                .map(TimeLine::toString)
                .collect(Collectors.joining(";"));
        date.setText(record.getDate().format(fmt));
        param.setText(pr);
        time.setText(String.valueOf(record.getWorkTimes()));
        status.setText(record.getStatus().getDescription());
    }

}
