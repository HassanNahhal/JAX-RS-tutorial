package com.hassan.tutorial.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.hassan.tutorial.messenger.database.DatabaseClass;
import com.hassan.tutorial.messenger.model.Message;

/**
 * @author hassannahhal
 *
 */
public class MessageService {
     
     private Map<Long, Message> messages = DatabaseClass.getMessages();
     
     public MessageService() {
          messages.put(1L, new Message(1, "Hello World", "Hassan"));
          messages.put(2L, new Message(2, "Hello Jersey", "Hassan"));
     }
     
     public List<Message> getAllMessages() {
          return new ArrayList<Message>(messages.values());
     }
     
     /**
      * @param start
      * @param size
      * @return return a list of messages starting from a date
      * @comment check if it will return an error, since author used arrayList to declare the list
      */
     public List<Message> getAllMessagesPaginated(int start, int size) {
          List<Message> list = new ArrayList<Message>(messages.values());
          if (start + size > list.size())
               return new ArrayList<Message>();
          return list.subList(start, start + size);
     }
     
     /**
      * @param year
      * @return return all messages in a specific year
      */
     public List<Message> getAllMessagesForYear(int year) {
          List<Message> messagesForYear = new ArrayList<>();
          Calendar cal = Calendar.getInstance();
          for (Message message : messages.values()) {
               cal.setTime(message.getCreated());
               if (cal.get(Calendar.YEAR) == year) {
                    messagesForYear.add(message);
               }
          }
          return messagesForYear;
     }
     
     public Message getMessage(long id) {
          return messages.get(id);
     }
     
     public Message addMessage(Message message) {
          message.setId(messages.size() + 1);
          messages.put(message.getId(), message);
          return message;
     }
     
     public Message updateMessage(Message message) {
          if (message.getId() <= 0) {
               return null;
          }
          messages.put(message.getId(), message);
          return message;
     }
     
     public Message removeMessage(long id) {
          return messages.remove(id);
     }
}
