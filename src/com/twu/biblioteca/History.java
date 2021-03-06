package com.twu.biblioteca;

import java.util.ArrayList;

public class History {
    private static ArrayList<Record> records;

    public History() {
        records = new ArrayList<>();
    }


    public void addRecord(String userName, String itemName, String itemType) {
        records.add(new Record(userName, itemName, itemType));
    }

    public String show() {
        if (records.size() == 0)
            return "No records to show\n";
        String list = "";
        for (Record record : records) {
            list += record.toString() + System.lineSeparator();
        }
        return list;

    }

    public void removeRecord(String itemName, String itemType) {
        Record toRemove = new Record("", "","");
        for (Record record : records) {
            if (record.match(itemName, itemType))
                toRemove = record;
        }
        records.remove(toRemove);


    }
}
