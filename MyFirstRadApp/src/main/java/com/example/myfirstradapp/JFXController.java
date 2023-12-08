package com.example.myfirstradapp;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class JFXController{
  @FXML
  MenuButton priorityDropdown;
  @FXML
  MenuItem Priority1Button;
  @FXML
  MenuItem Priority2Button;
  @FXML
  MenuItem Priority3Button;
  @FXML
  Button deleteItem;
  @FXML
  TextField itemName;
  boolean namePickedBoolean;
  @FXML
  DatePicker itemDate;
  Boolean datePickedBoolean;
  @FXML
  Button addItem;
  @FXML
  Button finishItem;
  @FXML
  Button restoreItem;
  @FXML
  ListView toDoList;
  @FXML
  ListView finishedList;

  public void initialize() {
    addItem.setDisable(true);
    namePickedBoolean = false;
    datePickedBoolean = false;
  }
public void namePicked(ActionEvent event){
      if (datePickedBoolean){
          addItem.setDisable(false);
      }
      else {
        addItem.setDisable(true);
      }
      itemName.setDisable(true);
      namePickedBoolean = true;
  }
  public void datePicked(ActionEvent event){
    if (namePickedBoolean){
      addItem.setDisable(false);
    }
    else {
      addItem.setDisable(true);
    }
    datePickedBoolean = true;
    itemDate.setDisable(true);
  }
  public void addItemEvent(ActionEvent event){
      toDoList.getItems().add(itemName.getText()+" "+itemDate.getValue());
      datePickedBoolean=false;
      namePickedBoolean=false;
      itemName.setDisable(false);
      itemDate.setDisable(false);
      itemName.setText(null);
      itemDate.setValue(null);
      addItem.setDisable(true);
  }


  public void finishItemEvent(ActionEvent event) {
    ObservableList selectedIndices = toDoList.getSelectionModel().getSelectedItems();
    for(Object o : selectedIndices){
      finishedList.getItems().add(o);
      toDoList.getItems().remove(o);
    }
  }

  public void restoreItemEvent(ActionEvent event) {
    ObservableList selectedIndices = finishedList.getSelectionModel().getSelectedItems();
    for(Object o : selectedIndices){
      toDoList.getItems().add(o);
      finishedList.getItems().remove(o);
    }
  }

  public void deleteItemEvent(ActionEvent event) {
    ObservableList selectedIndices = finishedList.getSelectionModel().getSelectedItems();
    for(Object o : selectedIndices){
      toDoList.getItems().remove(o);
      finishedList.getItems().remove(o);
    }
  }

  public void priorityDropdownEvent(ActionEvent event) {
  }

  public void Priority1ButtonEvent(ActionEvent event) {
  }

  public void Priority2ButtonEvent(ActionEvent event) {
  }

  public void Priority3ButtonEvent(ActionEvent event) {
  }
}