<%--
  Created by IntelliJ IDEA.
  User: kylin
  Date: 14/03/2017
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--基本信息-->
<section>
  <input type="hidden" name="hotelId" value="${hotelId}">

  <div class="row">
    <div class="col-md-2">
      <label class="control-label">酒店识别码</label>
    </div>

    <div class="col-md-4">
      <p class="card-text">${hotelIdentity}</p>
    </div>
  </div>

  <div class="row">
    <div class="col-md-3 dropdown">
      <label class="form-group label-floating">级别
        <select class="selectpicker" name="level">
          <option value="0">快捷连锁酒店</option>
          <option value="1">一星级酒店</option>
          <option value="2">二星级酒店</option>
          <option value="3">三星级酒店</option>
          <option value="4">四星级酒店</option>
          <option value="5">五星级酒店</option>
        </select>
      </label>
    </div>

    <div class="col-md-2">
      <div class="form-group label-floating">
        <label class="control-label">酒店名称</label>
        <input name="name" value="${hotel.name}" type="text" class="form-control">
      </div>
    </div>

    <div class="col-md-6">
      <div class="form-group label-floating">
        <label class="control-label">地址</label>
        <input name="location" value="${hotel.location}" type="text" class="form-control">
      </div>
    </div>
  </div>
</section>