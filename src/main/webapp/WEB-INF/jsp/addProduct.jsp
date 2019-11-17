<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<form method="POST" action="${pageContext.request.contextPath}/add-product" enctype="multipart/form-data">
  <c:forEach items="${errors}" var="error">
    <p class="text-danger">
        <c:out value="${error.defaultMessage}"/>
    </p>
  </c:forEach>
  <div class="form-group">
      <label for="exampleInputEmail1">Device id</label>
      <input type="text" name="deviceId" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter device id">
      <small id="emailHelp" class="form-text text-muted">Please describe device id</small>
    </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Device name</label>
    <input type="text" name="deviceName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter device name">
    <small id="emailHelp" class="form-text text-muted">Please describe device item</small>
  </div>
  <div class="form-group">
      <label for="exampleInputEmail1">Device location</label>
      <input type="text" name="deviceLocation" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter device location">
      <small id="emailHelp" class="form-text text-muted">Please describe device location</small>
    </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Device IP adress</label>
    <input type="text" name="deviceIpAdress" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter device IP adress">
    <small id="emailHelp" class="form-text text-muted">Please describe device IP adress</small>
    </div>
    <div class="form-group">
          <label for="exampleFormControlFile1">Example file input</label>
          <input type="file" name="file" class="form-control-file" id="exampleFormControlFile1"/>
      </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="footer.jsp"/>