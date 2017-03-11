<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-basic.jsp'>
  <jsp:param name="pageTitle" value="profile"/>
</jsp:include>
<body>

<div class="wrapper">
  <!--整个左侧导航栏-->
  <%@include file="guest-navbar-left.jsp" %>

  <!--主体界面-->
  <div class="main-panel">
    <!--1.导航栏-->
    <%@include file="guest-navbar-top.jsp" %>

    <!--2.内容-->
    <div class="content">
      <div class="container-fluid">

        <!--第一部分:个人信息的修改-->
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">个人资料</h4>
                <p class="category"></p>
              </div>
              <div class="card-content">
                <form>
                  <!--名称行-->
                  <div class="row">
                    <div class="col-md-4">
                      <div class="form-group label-floating">
                        <label class="control-label">姓名</label>
                        <input type="text" class="form-control">
                      </div>
                    </div>
                    <div class="col-md-4">
                      <div class="form-group label-floating">
                        <label class="control-label">手机</label>
                        <input type="text" class="form-control">
                      </div>
                    </div>
                  </div>


                  <!--性别行-->
                  <div class="row">
                    <label class="col-sm-1 control-label">性别</label>

                    <div class="col-sm-1">
                      <div class="radio">
                        <label>
                          <input type="radio" name="optionsRadios">
                          男
                        </label>
                      </div>
                    </div>

                    <div class="col-sm-1">
                      <div class="radio">
                        <label>
                          <input type="radio" name="optionsRadios">
                          女
                        </label>
                      </div>
                    </div>
                  </div>

                  <!--名称行-->
                  <div class="row">
                    <div class="col-md-4">
                      <div class="form-group label-floating">
                        <label class="control-label">银行卡</label>
                        <input type="text" class="form-control">
                      </div>
                    </div>
                  </div>

                  <button type="submit" class="btn btn-primary pull-left">
                    保存
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
</html>