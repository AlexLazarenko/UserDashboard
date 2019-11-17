<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<h1>Your devices!</h1>

<table class="table">
    <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Device name</th>
          <th scope="col">Location</th>
           <th scope="col">Sensor id</th>
            <th scope="col">Sensor value</th>
        </tr>
      </thead>
      <tbody>
    <c:forEach var="item" items="${catalog}">
        <tr>
          <th scope="row">${item.deviceId}</th>
          <td>${item.deviceName}</td>
          <td>${item.deviceLocation}</td>
       <c:forEach var="item" items="${catalog}">
          <td>${item.sensors.sensorId}</td>
       </c:forEach>
       <c:forEach var="item" items="${catalog}">
          <td>${item.sensors.sensorValue}</td>
       </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp"/>