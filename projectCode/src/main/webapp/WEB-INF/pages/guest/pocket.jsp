<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-basic.jsp'>
  <jsp:param name="pageTitle" value="pocket"/>
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

        <!--recent order-->
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">账户充值</h4>
              </div>

              <div class="card-content">
                <form action="guest/top-up" method="POST">

                  <div class="row">
                    <div class="col-sm-3">
                      <label class="control-label">当前余额</label>
                    </div>

                    <div class="col-sm-3">
                      <p class="text-info">￥${memberInfo.memberCardRemain}</p>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-sm-3">
                      <label class="control-label">当前积分</label>
                    </div>

                    <div class="col-sm-3">
                      <p class="text-info">￥${memberInfo.memberScore}</p>
                    </div>
                  </div>

                  <div class="row">

                    <div class="col-sm-3">
                      <label class="control-label">充值金额(￥)</label>
                    </div>

                    <div class="col-sm-3">
                      <input type="text" name="money" pattern="[0-9]">
                    </div>
                  </div>

                  <div class="row">

                    <div class="col-sm-3">
                      <label class="control-label">使用积分(100积分=￥1)</label>
                    </div>

                    <div class="col-sm-3">
                      <input type="text" name="score" pattern="[0-9]">
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-md-3">
                      <button type="submit" class="btn btn-primary pull-left">
                        确定
                      </button>
                    </div>

                    <div class="col-md-3">
                      <button type="submit" class="btn btn-danger pull-left">
                        取消
                      </button>
                    </div>
                  </div>
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