
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title></title>
  </head>
  <body>

  <jsp:include page="header.jsp"/>

  <table width="100%">
      <tr>
          <td colspan="2" align="right"><a href="/newlot">Create Post</a></td>
      </tr>
      <tr>
          <td width="70%" valign="top">
              <h2>Lots</h2>

              <c:forEach items="${lots}" var="lot">
                  <h1>${lot.title}</h1>
                  <p>${lot.summary}</p>
                  <a href="/auction?lot=${lot.id}">Read more...</a>
                  <hr/>
              </c:forEach>

          </td>
          <td  valign="top">
              <h2>List lots:</h2>
              <ul>
                  <c:forEach items="${lots}" var="lot">
                      <li><a href="/auction/lot=${lot.id}">${lot.title}</a></li>
                  </c:forEach>
              </ul>
          </td>
      </tr>
  </table>

  <jsp:include page="footer.jsp" />

  </body>
</html>