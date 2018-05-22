package com.qualixium.executor;

import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.windows.TopComponent;

public final class NetBeansContextInfo {

  private NetBeansContextInfo() {
  }

  public static String getFullFilePath() {
    try {
      DataObject dataLookup = getActiveTopComponent().getLookup().lookup(DataObject.class);
      return FileUtil.toFile(dataLookup.getPrimaryFile()).getAbsolutePath();
    } catch (Exception ex) {
      ex.printStackTrace();
      return "";
    }
  }

  public static String getProjectName() {
    try {
      FileObject fileObject = getActiveTopComponent().getLookup().lookup(FileObject.class);
      
      return ProjectUtils.getInformation(FileOwnerQuery.getOwner(fileObject)).getDisplayName();
    } catch (Exception ex) {
      ex.printStackTrace();
      return "";
    }
  }

  public static String getProjectDirectory() {
    try {
      FileObject fileObject = getActiveTopComponent().getLookup().lookup(FileObject.class);
      Project project = ProjectUtils.getInformation(FileOwnerQuery.getOwner(fileObject)).getProject();
      FileObject projectDirectoryObj = project.getProjectDirectory();
      
      return projectDirectoryObj.getPath();
    } catch (Exception ex) {
      ex.printStackTrace();
      return "";
    }
  }

  private static TopComponent getActiveTopComponent() {
    return TopComponent.getRegistry().getActivated();
  }

}
