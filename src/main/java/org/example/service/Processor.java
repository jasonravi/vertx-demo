package org.example.service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.example.model.User;
import java.io.*;


import java.util.List;

public class Processor {

    ObjectMapper mapper = new ObjectMapper();
    String users = "[{\"id\":12345,\"name\":\"Ravi\",\"address\":\"2nd cross Gandhi Nagar\"},{\"id\":12346,\"name\":\"Ranjan\",\"address\":\"2nd cross Gandhi Nagar\"},{\"id\":12347,\"name\":\"Pandey\",\"address\":\"2nd cross Gandhi Nagar\"}]";

    public  List<User> getUser() throws Exception {
        List<User> userList = mapper.readValue(users, new TypeReference<List<User>>(){});
        return userList;

    }
}
