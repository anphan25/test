/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anpdt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "DispatchController", urlPatterns = {"/DispatchController"})
public class DispatchController extends HttpServlet {
    private final String LOGIN_PAGE ="login.html";
    private final String LOGIN_SERVLET="LoginServlet";
    private final String SEARCH_LASTNAME_SERVLET="SearchLastnameServlet";
    private final String DELETE_ACCOUNT_SERVLET="DeleteAccountServlet";
    private final String UPDATE_SERVLET = "UpdateServlet";
    private final String PROCESS_REQUEST_SERVLET = "ProcessRequestServlet";
    private final String ADD_ITEM_TO_CART = "AddItemToCart";
    private final String VIEW_CART_PAGE = "viewCart.jsp";
    private final String REMOVE_ITEM_FROM_CART ="RemoveItemServlet";
    private final String CREATE_NEW_ACCOUNT_CONTROLLER ="CreateNewAccount";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url =LOGIN_PAGE;
        String button = request.getParameter("btAction");
        try {
            if(button == null){
                url = PROCESS_REQUEST_SERVLET;
            }else if(button.equals("Login")){
                url = LOGIN_SERVLET;
            }else if(button.equals("Search")){
                url = SEARCH_LASTNAME_SERVLET;
            }else if(button.equals("Delete")){
                url = DELETE_ACCOUNT_SERVLET;
            }else if(button.equals("Update")){
                url = UPDATE_SERVLET;
            }else if(button.equals("Add Item to Your Cart")){
                url = ADD_ITEM_TO_CART; 
            }else if(button.equals("View Your Cart")){
                url = VIEW_CART_PAGE;
            }else if(button.equals("Remove Selected Items")){
                url = REMOVE_ITEM_FROM_CART;
            }else if(button.equals("Create New Account")){
                url = CREATE_NEW_ACCOUNT_CONTROLLER;
            }
            
        }finally{
                RequestDispatcher rd= request.getRequestDispatcher(url);
                rd.forward(request,response);
                
                
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
