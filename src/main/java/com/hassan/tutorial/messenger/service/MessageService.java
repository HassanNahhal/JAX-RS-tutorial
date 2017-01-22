package com.hassan.tutorial.messenger.service;

import java.util.ArrayList;
import java.util.List;

import com.hassan.tutorial.messenger.model.Message;

public class MessageService {

  public List<Message> getAllMessages() {
    Message m1 = new Message(1L, "Hello World", "Hassan");
    Message m2 = new Message(2L, "Hello Jersey!", "Hassan");
    List<Message> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);

    return list;

  }


}
