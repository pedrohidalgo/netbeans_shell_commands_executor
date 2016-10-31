package com.qualixium.executor.command;

import javax.swing.table.DefaultTableModel;

public class CommandHelper {

    public static String getJsonStringFromCommandsModel(DefaultTableModel model) {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < model.getRowCount(); i++) {
            if (i != 0) {
                result.append(",");
            }
            result.append("{");

            String name = (String) model.getValueAt(i, 0);
//            String command = ((String) model.getValueAt(i, 1));
            String command = ((String) model.getValueAt(i, 1)).replace("\\", "\\\\");
            result.append("\"").append(model.getColumnName(0)).append("\":\"")
                    .append(name).append("\",\"").append(model.getColumnName(1)).append("\":\"")
                    .append(command).append("\"");

            result.append("}");
        }
        result.append("]");

        String toReturn = result.toString();
        return toReturn;
    }

}
