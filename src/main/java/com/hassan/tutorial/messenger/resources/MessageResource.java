package com.hassan.tutorial.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hassan.tutorial.messenger.model.Message;
import com.hassan.tutorial.messenger.service.MessageService;


@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {


  MessageService messageService = new MessageService();


  @PUT
  @Path("/{messageId}")
  public Message updateMessage(@PathParam("messageId") long id, Message message) {
    message.setId(id);
    return messageService.updateMessage(message);
  }


  @DELETE
  @Path("/{messageId}")
  public void deleteMessage(@PathParam("messageId") long id) {
    messageService.removeMessage(id);
  }

  @GET
  public List<Message> getMessages() {
    return messageService.getAllMessages();
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
