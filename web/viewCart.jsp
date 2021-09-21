<%-- 
    Document   : viewCart
    Created on : Jun 21, 2021, 3:35:51 PM
    Author     : ASUS
--%>

<%@page import="java.util.Map"%>
<%@page import="anpdt.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your Cart Includes:</h1>
        
        
        <%
            if(session != null){
                CartObj cart = (CartObj)session.getAttribute("CART");
                if(cart != null){
                    Map<String, Integer> items = cart.getItems();
                    if(items != null){
                        %>
                        <form action="DispatchController">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Name</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    <th>Total</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                                int count = 0;
                                for(String key : items.keySet()){
                            %>
                            
                                <tr>
                                    <td>
                                        <%= ++count %>
                                    </td>
                                    <td>
                                        <%= key %>
                                    </td>
                                    <td>
                                        <%= items.get(key) %>
                                    </td>
                                    <td>
                                        <%= cart.getPrice(key) %>
                                    </td>
                                    <td>
                                        <%= cart.getTotal(key) %>
                                    </td>
                                    <td>
                                        <input type="checkbox" name="chkItem" value="<%= key %>" />
                                    </td>
                                </tr>
                            <%
                                }//for loop
                            %>
                                <tr>
                                    <td colspan="3">
                                        <a href="onlineShopping.html">Add more items to cart</a>
                                    </td >
                                    <td colspan="3">
                                        <input type="submit" value="Remove Selected Items" name="btAction" />
                                    </td>
                                </tr>
                                
                            </tbody>
                        </table>
                 </form>
        <%
                        return;
                    }//items has value
                }//cart has exist
            }//sesion has existed
        %>
    </body>
</html>
