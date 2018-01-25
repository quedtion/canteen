package com.example.canteen.service;

import com.example.canteen.model.Address;

public interface AddressService {

    String processCreate(Address address);

    String processList(Address address);

    String processUpdate(Address address);
}
