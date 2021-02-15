<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*,com.example.banqueApp.DAO.DAOCompte" %>
<%@ page import="com.example.banqueApp.model.Compte" %>
<%@ page import="com.example.banqueApp.database.DbConfig" %>
<%@ page import="java.sql.Connection" %>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">


<%--<%!DAOCompte com;%>
<%
    com = (DAOCompte) session.getAttribute("comptes");
  /*  String account_no = ac.getAccount_no();
    DbConfig connect = new DbConfig();
    Connection conn = connect.connect();
    DatabaseOperations operations = new DatabaseOperations();
    ac = operations.getAccountDetails(conn, account_no);*/
%>--%>
<div class="container">

<%--<a href="delete.jsp">Delete</a>
<a href="update.jsp">update</a>
<a href="insertEntr.jsp">Insert Entreprise</a>
    <a href="insertPers.jsp">Insert Presone</a>
    <a href="/Servlet2">Liste</a>--%>


<table class="table table-striped table-dark">
    <thead >
    <tr>
        <th><a href="/Servlet2">Liste Et Suprimer</a></th>
        <th><a href="insertEntr.jsp">Insert Entreprise</a></th>
        <th><a href="insertPers.jsp">Insert Presone</a></th>
        <th><a href="update.jsp">update</a></th>
        <%--//<th>numero</th>--%>
    </tr>
    </thead>
    <tbody>
   <%

       List<Compte> x= (List<Compte>) request.getAttribute("comptes");
 %>
   <c:forEach var="compte" items="${x}">

        <tr>
            <td><c:out value="${x.compte_id}" /></td>
            <a href="delete?id=<c:out value='${x.compte_id}' />">Delete</a>

        </tr>
    </c:forEach>
<%--<a href="<%=request.getContextPath()%>/"
         class="nav-link">comptes</a>--%>
<%--

          <%
       List<Compte> x= (List<Compte>) request.getAttribute("comptes");

       for (int i = 0; i < x.size(); i++) {


   %>
   <tr>
       <td><%=x.get(i).getCompteType()%>
       </td>
       <td><%=x.get(i).getId()%>
       </td>
       <td><%=x.get(i).getNumeroCompte()%>
       </td>
       <td>
           <div>
               <button class="btn btn-danger">Delete</button>
               <button class="btn btn-secondary">Block</button>
               <button style="display: none;" class="btn badge-success">Inblock
               </button>
           </div>
       </td>
   </tr>
--%>


  <%-- <% } %>--%>
    </tbody>

</table>
</div>