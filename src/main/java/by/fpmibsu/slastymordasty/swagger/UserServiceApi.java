package by.fpmibsu.slastymordasty.swagger;

import by.fpmibsu.slastymordasty.dao.UserDao;
import by.fpmibsu.slastymordasty.entity.User;
import by.fpmibsu.slastymordasty.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
//import io.swagger.oas.annotations.parameters.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.*;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserServiceApi
{
    private static final UserDao userDao;

    static {
        try {
            userDao = new UserDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @GET
    @ApiOperation(value = "Gets all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public Response getAllUsers() {
        try {
            List<User> user = userDao.getAllUsers();
            return Objects.equals(user, "null") ? Response.status(Response.Status.NOT_FOUND).build() :
                    Response.ok(user).build();
        } catch (InterruptedException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    /*@GET
    @Path("/{id}&")
    @ApiOperation(value = "Gets a user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public Response getUserById(
            @ApiParam(value = "User ID", required = true) @PathParam("id") Integer id) {
        try {
            User user = userDao.getById(id);
            return Objects.equals(user, "null") ? Response.status(Response.Status.NOT_FOUND).build() :
                    Response.ok(user).build();
        } catch (InterruptedException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @ApiOperation(value = "Gets all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public Response getAllUsers() {
        try {
            List<User> user = userDao.getAll();
            return Objects.equals(user, "null") ? Response.status(Response.Status.NOT_FOUND).build() :
                    Response.ok(user).build();
        } catch (DaoException | InterruptedException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation(value =  "Deletes User by id.")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public Response deleteUserById(@ApiParam(value = "User ID", required = true) @PathParam("id") Integer id) {
        try {
            User user = userDao.findById(id);
            userDao.delete(user);
            return Objects.equals(user, "null") ? Response.status(Response.Status.NOT_FOUND).build() :
                    Response.ok(user).build();
        } catch (DaoException | InterruptedException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @ApiOperation(value = "Creates user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public Response postUser(@ApiParam(value="User", required = true) @RequestBody User user) {
        try {
            boolean res = userDao.create(user);
            if (! res)
            {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            return Response.ok("User successfully created.").build();
        } catch (DaoException | InterruptedException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @ApiOperation(value = "updates users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public Response putUser(@ApiParam(value="User", required = true) @RequestBody User user) {
        try {
            User res = userDao.update(user);
            if (res == null)
            {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            return Response.ok("User successfully updated.").build();
        } catch (DaoException | InterruptedException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }*/
}