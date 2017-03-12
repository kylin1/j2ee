<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-with-date.jsp'>
  <jsp:param name="pageTitle" value="住客登记"/>
</jsp:include>

<body>

<div class="wrapper">

  <!--整个左侧导航栏-->
  <%@include file="hotel-navbar-left.jsp" %>

  <!--主体界面-->
  <div class="main-panel">

    <!--1.导航栏-->
    <%@include file="hotel-navbar-top.jsp" %>

    <!--2.内容-->
    <div class="content">
      <div class="container-fluid">

        <!--酒店输入日期,房间类型:查找合适房间列表-->
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">查找本酒店房间</h4>
                <p class="category"></p>
              </div>
              <div class="card-content">
                <form>
                  <!--time-->
                  <div class="row">
                    <div class="col-md-1">
                      <label class="control-label">开始</label>
                    </div>

                    <div class="col-sm-3">
                      <div class="form-group label-floating">
                        <input type="text" id="dpd1" class="form-control">
                      </div>
                    </div>

                    <div class="col-md-1">
                      <label class="control-label">结束</label>
                    </div>

                    <div class="col-sm-3">
                      <div class="form-group label-floating">
                        <input type="text" id="dpd2" class="form-control">
                      </div>
                    </div>

                    <div class="col-md-3 dropdown">
                      <a href="#" class="btn btn-simple dropdown-toggle" data-toggle="dropdown">
                        类型
                        <b class="caret"></b>
                      </a>
                      <ul class="dropdown-menu">
                        <li><a href="#">标准间</a></li>
                        <li><a href="#">单人间</a></li>
                        <li><a href="#">套房</a></li>
                      </ul>
                    </div>
                  </div>

                  <button type="submit" class="btn btn-primary pull-left">
                    确定
                  </button>
                  <div class="clearfix"></div>
                </form>
              </div>
            </div>
          </div>
        </div>

        <!--合适房间列表:在列表中点击一个房间进行预订-->

        <div class="row">
          <div class="col-md-10">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">请为客人选择空闲房间</h4>
                <p class="category"></p>
              </div>

              <div class="card-content table-responsive">
                <table class="table">
                  <thead class="text-primary">
                  <th>房间号</th>
                  <th>类型</th>
                  <th>状态</th>
                  <th>其他信息</th>
                  <th>操作</th>
                  </thead>
                  <tbody>

                  <tr>
                    <td>401</td>
                    <td>标准间</td>
                    <td>空闲</td>
                    <td>位于4楼楼梯附近</td>
                    <td><a href="#">入住</a></td>
                  </tr>

                  </tbody>
                </table>

              </div>
            </div>
          </div>
        </div>

        <!--登记一个房间的入住人信息-->
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">登记入住人信息</h4>
                <p class="category"></p>
              </div>
              <div class="card-content">
                <form>
                  <!--名称行-->
                  <div class="row">
                    <label class="col-md-1 control-label">酒店</label>
                    <div class="col-md-6">
                      <h4>上海中环国际酒店</h4>
                    </div>
                  </div>

                  <!--房间号-->
                  <div class="row">
                    <div class="input-group">
                      <div class="col-md-6">
                        <input type="text" class="form-control" placeholder="房间号">
                      </div>

                    </div>


                  </div>

                  <div class="row">
                    <div class="input-group">
                      <div class="col-md-4">
                        <input type="text" class="form-control" placeholder="房客1姓名">
                      </div>
                      <div class="col-md-4">
                        <input type="text" class="form-control" placeholder="身份证">
                      </div>
                      <div class="col-md-1" style="padding-top: 40px;">
                        <a href="#" id="add-room-icon">
                          <i class="material-icons">add_circle_outline</i>
                        </a>
                      </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="input-group">
                      <div class="col-md-4">
                        <input type="text" class="form-control" placeholder="房客2姓名">
                      </div>
                      <div class="col-md-4">
                        <input type="text" class="form-control" placeholder="身份证">
                      </div>
                      <div class="col-md-1" style="padding-top: 40px;">
                        <a href="#" id="add-room-icon2">
                          <i class="material-icons">add_circle_outline</i>
                        </a>
                      </div>
                    </div>
                  </div>

                  <!--是否会员-->
                  <div class="row">
                    <label class="col-sm-2 control-label">是否会员</label>

                    <div class="col-sm-2">
                      <div class="radio">
                        <label>
                          <input type="radio" name="optionsRadios">
                          是
                        </label>
                      </div>
                    </div>

                    <div class="col-sm-2">
                      <div class="radio">
                        <label>
                          <input type="radio" name="optionsRadios">
                          否
                        </label>
                      </div>
                    </div>
                  </div>

                  <!--付款方式-->
                  <div class="row">
                    <label class="col-sm-2 control-label">付款方式</label>

                    <div class="col-sm-2">
                      <div class="radio">
                        <label>
                          <input type="radio" name="optionsRadios">
                          会员卡
                        </label>
                      </div>
                    </div>

                    <div class="col-sm-3">
                      <div class="radio">
                        <label>
                          <input type="radio" name="optionsRadios">
                          现金结账
                        </label>
                      </div>
                    </div>
                  </div>

                  <button type="submit" class="btn btn-primary pull-left">
                    确定
                  </button>
                  <div class="clearfix"></div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!--3.页脚-->
    <%@include file="../common/footer.jsp" %>
  </div>
</div>

</body>

<%@include file="../common/js-file.jsp" %>

<script>
    var nowTemp = new Date();
    var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);

    var checkin = $('#dpd1').datepicker({
        onRender: function (date) {
            return date.valueOf() < now.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        if (ev.date.valueOf() > checkout.date.valueOf()) {
            var newDate = new Date(ev.date)
            newDate.setDate(newDate.getDate() + 1);
            checkout.setValue(newDate);
        }
        checkin.hide();
        $('#dpd2')[0].focus();
    }).data('datepicker');
    var checkout = $('#dpd2').datepicker({
        onRender: function (date) {
            return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
        }
    }).on('changeDate', function (ev) {
        checkout.hide();
    }).data('datepicker');
</script>
</html>
