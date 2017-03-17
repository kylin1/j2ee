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
        <%@include file="../common/error-display.jsp"%>

        <!--第一部分:个人信息的修改-->
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">个人资料</h4>
                <p class="category"></p>
              </div>
              <div class="card-content">
                <form action="${pageContext.request.contextPath}/guest/update" method="post">
                  <!--名称行-->
                  <div class="row">
                    <div class="col-md-4">
                      <div class="form-group label-floating">
                        <label class="control-label">姓名</label>
                        <input name="name" type="text" value="${memberInfo.name}" class="form-control">
                      </div>
                    </div>
                    <div class="col-md-4">
                      <div class="form-group label-floating">
                        <label class="control-label">手机</label>
                        <input name="phone" type="number" pattern="[0-9]*" value="${memberInfo.phone}" class="form-control">
                      </div>
                    </div>
                  </div>

                  <!--邮箱-->
                  <div class="row">
                    <div class="col-md-4">
                      <div class="form-group label-floating">
                        <label class="control-label">email</label>
                        <input name="email" type="email" value="${memberInfo.email}" class="form-control">
                      </div>
                    </div>
                  </div>

                  <!--银行卡-->
                  <div class="row">
                    <div class="col-md-4">
                      <div class="form-group label-floating">
                        <label class="control-label">银行卡</label>
                        <input name="bankCard" type="number" pattern="[0-9]*" value="${memberInfo.bankCard}" class="form-control">
                      </div>
                    </div>
                  </div>

                  <input type="hidden" name="memberId" value="${memberInfo.id}">

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