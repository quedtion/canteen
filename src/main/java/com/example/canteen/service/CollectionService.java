package com.example.canteen.service;

import com.example.canteen.model.Mycollection;

public interface CollectionService {

    String processCreate(Mycollection mycollection);

    String processUpdate(Mycollection mycollection);

    String processList(Mycollection mycollection);
}
