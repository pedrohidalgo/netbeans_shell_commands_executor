/*
 * Copyright 2016 Qualixium.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qualixium.executor.command;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import static com.qualixium.executor.command.CommandsConfigurationDialog.MAPPER;
import javax.swing.table.DefaultTableModel;

public class CommandHelper {

    public static String getJsonStringFromCommandsModel(DefaultTableModel model) {
        return getJsonNodeFromCommandsModel(model).toString();
    }

    public static JsonNode getJsonNodeFromCommandsModel(DefaultTableModel model) {
        ArrayNode jsonArray = MAPPER.createArrayNode();

        for (int i = 0; i < model.getRowCount(); i++) {
            ObjectNode jsonNode = MAPPER.createObjectNode();

            String name = (String) model.getValueAt(i, 0);
            String command = ((String) model.getValueAt(i, 1)).replace("\\", "\\\\");

            jsonNode.put(model.getColumnName(0), name);
            jsonNode.put(model.getColumnName(1), command);

            jsonArray.add(jsonNode);
        }

        return jsonArray;
    }

}
