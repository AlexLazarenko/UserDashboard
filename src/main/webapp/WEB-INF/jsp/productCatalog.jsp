<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<h1>Your devices!</h1>

<table class="table">
    <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Device name</th>
          <th scope="col">Location</th>
        </tr>
      </thead>
      <tbody>
    <c:forEach var="item" items="${catalog}">
        <tr>
          <th scope="row">${item.deviceId}</th>
          <td><a href="${pageContext.request.contextPath}/product-catalog/item/${item.deviceId}" class="badge badge-light">${item.deviceName}</a></td>
          <td>${item.deviceLocation}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp"/>