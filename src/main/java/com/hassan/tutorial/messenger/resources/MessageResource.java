package com.hassan.tutorial.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hassan.tutorial.messenger.model.Message;
import com.hassan.tutorial.messenger.resources.beans.MessageFilterBean;
import com.hassan.tutorial.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
     
     MessageService messageService = new MessageService();
     
     @GET
     public List<Message> getMessages(@BeanParam MessageFilterBean filterbean) {
          if (filterbean.getYear() > 0)
               return messageService.getAllMessagesForYear(filterbean.getYear());
          if (filterbean.getStart() >= 0 && filterbean.getSize() >= 0)
               return messageService.getAllMessagesPaginated(filterbean.getStart(),
                                                             filterbean.getSize());
          return messageService.getAllMessages();
     }
     
     /**
      * @param year
      * @param start
      * @param size
      * @return list of messages based on the params given
      * @comment this is the hard way, to simplify it see the other getMessages method
      */
     /*
      * @GET public List<Message> getMessages(@QueryParam("year") int year,
      * 
      * @QueryParam("start") int start,
      * 
      * @QueryParam("size") int size) { if (year > 0) return
      * messageService.getAllMessagesForYear(year); if (start >= 0 && size >= 0) return
      * messageService.getAllMessagesPaginated(start, size); return messageService.getAllMessages();
      * }
      */
     @PUT
     @Path("/{messageId}")
     public Message updateMessage(@PathParam("messageId") long id,
                                  Message message) {
          message.setId(id);
          return messageService.updateMessage(message);
     }
     
     @DELETE
     @Path("/{messageId}")
     public void deleteMessage(@PathParam("messageId") long id) {
          messageService.removeMessage(id);
     }
     
     @GET
     @Path("/{messageId}")
     public Message getMessage(@PathParam("messageId") long id) {
          return messageService.getMessage(id);
     }
     
     @POST
     public Message addMessage(Message message) {
          return messageService.addMessage(message);
     }
}
