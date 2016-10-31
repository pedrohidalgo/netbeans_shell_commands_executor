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
import javax.swing.table.DefaultTableModel;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author pedro
 */
public class CommandHelperTest {

    @Test
    public void testGetJsonFromModel() {
        Object[] columnNames = new Object[]{"Name", "Shell Command"};
        Object[][] data = {
            {"Kathy", "Smith"},
            {"John", "Doe"}
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        String expected = "[{\"Name\":\"Kathy\",\"Shell Command\":\"Smith\"},{\"Name\":\"John\",\"Shell Command\":\"Doe\"}]";

        String actual = CommandHelper.getJsonStringFromCommandsModel(model);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetJsonFromModelWithURLs() {
        Object[] columnNames = new Object[]{"Name", "Shell Command"};
        Object[][] data = {
            {"Open jsonlint.com", "open http://jsonlint.com"},
            {"Open Escape/UnEscape Tool", "open http://www.freeformatter.com/javascript-escape.html"}
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JsonNode jsonNode = CommandHelper.getJsonNodeFromCommandsModel(model);

        assertEquals("Open jsonlint.com", jsonNode.get(0).get("Name").asText());
        assertEquals("open http://jsonlint.com", jsonNode.get(0).get("Shell Command").asText());
        assertEquals("Open Escape/UnEscape Tool", jsonNode.get(1).get("Name").asText());
        assertEquals("open http://www.freeformatter.com/javascript-escape.html", jsonNode.get(1).get("Shell Command").asText());
    }

}
