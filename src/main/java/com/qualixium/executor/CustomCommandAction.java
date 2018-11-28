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
package com.qualixium.executor;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.Presenter;

@ActionID(
        category = "Commands",
        id = "com.qualixium.executor.CustomCommandAction"
)
@ActionRegistration(
        lazy = false,
        displayName = "#CTL_CustomCommandAction"
)
@ActionReferences({
  @ActionReference(path = "Toolbars/Commands", position = 0)
  ,
  @ActionReference(path = "Shortcuts", name = "SM-E")
})
@Messages("CTL_CustomCommandAction=CustomCommand")
public final class CustomCommandAction extends AbstractAction implements Presenter.Toolbar {

  @Override
  public void actionPerformed(ActionEvent e) {
    //delegated to toolbar
    ToolbarPanel.executeLatestCommand();
  }

  @Override
  public Component getToolbarPresenter() {
    return new ToolbarPanel();
  }
}
