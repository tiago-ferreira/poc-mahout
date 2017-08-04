package br.com.duck.poc.mahout;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

public class LoadModel {
  
  
  public DataModel getCoursesModel() throws IOException {
    return new FileDataModel(getFile("cursos.csv"));
  }
  
  private File getFile(String file) {
    ClassLoader classloader = getClass().getClassLoader();
    return new File(classloader.getResource(file).getFile());
  }

}
