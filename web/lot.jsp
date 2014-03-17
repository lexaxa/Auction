<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>${lot.lotId}</title>
    </head>
<body>

    <jsp:include page="header.jsp"/>
    <h1>List of lots</h1>
    <span style="font-size: 32px; color: #00008b">Lot_id=${lot.lot_id}</span>
    <p>${lot.description}</p>
    <hr/>
    <p>${lot.lot_date}</p>

    <jsp:include page="footer.jsp"/>
</body>
</html>
