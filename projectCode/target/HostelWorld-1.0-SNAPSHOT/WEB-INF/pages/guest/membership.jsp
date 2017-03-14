<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ch-ZN">

<jsp:include page='../common/header-basic.jsp'>
  <jsp:param name="pageTitle" value="membership"/>
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

        <!--第一部分:个人信息-->
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header" data-background-color="purple">
                <h4 class="title">会员卡信息</h4>
                <p class="category"></p>
              </div>
              <div class="card-content">
                <form>
                  <div class="row">
                    <div class="col-md-2">
                      <label class="control-label">账号</label>
                    </div>

                    <div class="col-md-4">
                      <p class="card-text">${memberInfo.name}</p>
                    </div>

                    <div class="col-md-2">
                      <label class="control-label">状态</label>
                    </div>
                    <div class="col-md-4">
                      <p class="text-success card-text">${memberInfo.strStatus}</p>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-md-2">
                      <label class="control-label">激活时间</label>
                    </div>
                    <div class="col-md-4">
                      <p class="card-text">${memberInfo.strActivatedTime}</p>
                    </div>

                    <div class="col-md-2">
                      <label class="control-label">到期时间</label>
                    </div>
                    <div class="col-md-4">
                      <p class="card-text">${memberInfo.strExpireTime}</p>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-md-2">
                      <label class="control-label">累计消费</label>
                    </div>
                    <div class="col-md-4">
                      <p class="card-text">￥${memberInfo.totalConsume}</p>
                    </div>
                    <div class="col-md-2">
                      <label class="control-label">会员卡余额</label>
                    </div>
                    <div class="col-md-4">
                      <p class="card-text">￥${memberInfo.memberCardRemain}</p>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-md-2">
                      <label class="control-label">会员级别</label>
                    </div>
                    <div class="col-md-4">
                      <p class="card-text">${memberInfo.strLevel}</p>
                    </div>

                    <div class="col-md-2">
                      <label class="control-label">积分</label>
                    </div>
                    <div class="col-md-4">
                      <p class="card-text">${memberInfo.memberScore}</p>
                    </div>

                  </div>

                  <div class="row">
                    <div class="col-md-3">
                      <a type="button" href="${pageContext.request.contextPath}/guest/top-up/${memberInfo.id}" class="btn btn-primary pull-left">
                        会员充值
                      </a>
                    </div>

                    <div class="col-md-3">
                      <a type="button" href="${pageContext.request.contextPath}/guest/cancel/${memberInfo.id}" class="btn btn-danger pull-left">
                        取消资格
                      </a>
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