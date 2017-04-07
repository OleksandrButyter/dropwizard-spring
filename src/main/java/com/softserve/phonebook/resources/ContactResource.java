
package com.softserve.phonebook.resources;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.softserve.phonebook.representations.Contact;
import com.softserve.phonebook.service.ContactService;

@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {

    private final ContactService contactService;

    public ContactResource(ContactService contactService) {
        this.contactService = contactService;
    }

    @GET
    @Path("/{id}")
    public Response getContactById(@PathParam("id") int id) {
        Contact contact = contactService.getContactById(id);
        return Response.ok(contact).build();
    }

    @GET
    public Response getAllContacts() {
        List<Contact> contact = contactService.getAllContacts();
        return Response.ok(contact).build();
    }

    @POST
    public Response createContact(@Valid Contact contact) throws URISyntaxException {
        contactService.createContact(contact);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") int id) {
        contactService.deleteContact(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateContact(@PathParam("id") int id, @Valid Contact contact) {
        contact.setId(id);
        contactService.updateContact(contact);
        return Response.noContent().build();
    }

}
